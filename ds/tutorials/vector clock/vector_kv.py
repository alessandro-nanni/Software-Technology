"""
Vector clock demo: replicated key-value store with conflict detection.

Five nodes (A-E) each run in their own thread and communicate only
through a central MessageBus.  The bus can deliver messages immediately
or buffer them for out-of-order delivery to demonstrate causal gaps.

Usage:
    python3 vector_kv.py                   # show causal gap (naive delivery)
    python3 vector_kv.py --causal          # enforce causal delivery, gap prevented
    python3 vector_kv.py --verbose         # include bus/inbox debug trace
"""

import argparse, logging, queue, threading

NODES = ['A', 'B', 'C', 'D', 'E']

log = logging.getLogger('vc')

def setup_logging(verbose: bool = False):
    threading.current_thread().name = 'scenario'
    level = logging.DEBUG if verbose else logging.INFO
    fmt   = '%(asctime)s.%(msecs)03d  %(threadName)-8s  %(message)s'
    logging.basicConfig(level=level, format=fmt, datefmt='%H:%M:%S')


# ── Vector clock ──────────────────────────────────────────────────────────────

class VectorClock: #dict
    def __init__(self):
        self.v = {n: 0 for n in NODES}

    def tick(self, node):
        self.v[node] += 1 

    def merge(self, other):
        for n in self.v:
            self.v[n] = max(self.v[n], other.v[n])

    def __le__(self, other):  return all(self.v[n] <= other.v[n] for n in self.v)
    def __eq__(self, other):  return self.v == other.v
    def __lt__(self, other):  return self <= other and self != other   # happens-before
    def concurrent(self, other): return not (self < other) and not (other < self)

    def copy(self):
        vc = VectorClock(); vc.v = dict(self.v); return vc

    def __repr__(self):
        return '{' + ', '.join(f'{k}:{v}' for k, v in self.v.items()) + '}'


# ── Node ──────────────────────────────────────────────────────────────────────

class Node: #every node has its own vector clock
    """
    Runs in its own daemon thread, draining an inbox queue.
    All shared state (clock, store) is protected by a lock.
    The scenario runner calls put() directly and uses the bus to send
    messages; the node's thread processes everything from its inbox.
    """

    def __init__(self, name: str, causal: bool = False):
        self.name    = name
        self.clock   = VectorClock()
        self.store: dict[str, tuple] = {}   # key → (value, VectorClock)
        self.causal  = causal               # enforce causal delivery if True
        self.pending: list = []             # msgs held waiting for dependencies
        self.lock    = threading.Lock()
        self.inbox   = queue.Queue()  # for messages delivered
        self._thread = threading.Thread(target=self._run, daemon=True, name=name)
        self._thread.start()

    def _run(self):
        """Drain the inbox forever."""
        while True:
            msg = self.inbox.get()
            log.debug(f"[{self.name}] inbox dequeued  "
                      f"{msg['key']}={msg['value']!r} @ {msg['vc']}  from={msg['from']}")
            try:
                if self.causal:
                    self._causal_receive(msg)
                else:
                    self._deliver(msg)
            finally:
                self.inbox.task_done()

    # ── causal delivery ───────────────────────────────────────────────────────

    def _causally_ready(self, msg_vc: VectorClock, sender: str) -> bool:
        """
        True when all causal dependencies for this message are satisfied.
        Two conditions (called with self.lock held):
          1. msg_vc[sender] == clock[sender] + 1  — next expected event from sender
          2. msg_vc[n] <= clock[n] for all n≠sender — every event sender had seen
                                                       has already reached us too
        """
        if msg_vc.v[sender] > self.clock.v[sender] + 1:
            return False
        for node in self.clock.v:
            if node != sender and msg_vc.v[node] > self.clock.v[node]:
                return False
        return True

    def _causal_receive(self, msg: dict):
        """Buffer msg if dependencies are unmet; deliver immediately if ready."""
        # did the package arrive in the right order?
        sender = msg['from']
        with self.lock:
            ready = self._causally_ready(msg['vc'], sender)
            if not ready:
                need = self.clock.v[sender] + 1
                have = self.clock.v[sender]
        if ready:
            self._deliver(msg)
            self._retry_pending()
        else:
            log.info(f"[{self.name}] causal-hold  {msg['key']}={msg['value']!r} "
                     f"@ {msg['vc']}  from={sender}  "
                     f"(need {sender}:{need}, have {sender}:{have})")
            self.pending.append(msg)

    def _retry_pending(self):
        """After a delivery, re-check buffered messages — release any now ready."""
        changed = True
        while changed:
            changed = False
            for msg in list(self.pending):
                with self.lock:
                    ready = self._causally_ready(msg['vc'], msg['from'])
                if ready:
                    self.pending.remove(msg)
                    log.info(f"[{self.name}] causal-release  {msg['key']}={msg['value']!r} "
                             f"@ {msg['vc']}  from={msg['from']}")
                    self._deliver(msg)
                    changed = True

    def _deliver(self, msg: dict):
        """Process one replication message (called from this node's thread)."""
        key, value, remote_vc, from_node = (
            msg['key'], msg['value'], msg['vc'], msg['from'])

        with self.lock:
            self.clock.merge(remote_vc)

            if key not in self.store:
                self.store[key] = (value, remote_vc.copy())
                log.info(f"[{self.name}] rcv  {key}={value!r:<6}  stored   "
                         f"(no local copy)  from={from_node}")
                return

            local_val, local_vc = self.store[key]

            if remote_vc < local_vc:
                log.info(f"[{self.name}] rcv  {key}={value!r:<6}  ignored  "
                         f"(stale)  from={from_node}")
            elif local_vc < remote_vc:
                self.store[key] = (value, remote_vc.copy())
                log.info(f"[{self.name}] rcv  {key}={value!r:<6}  accepted "
                         f"(causal: {local_vc} → {remote_vc})  from={from_node}")
            else:
                log.info(f"[{self.name}] rcv  {key}={value!r:<6}  CONFLICT  from={from_node}")
                log.info(f"         local    {local_val!r} @ {local_vc}")
                log.info(f"         incoming {value!r} @ {remote_vc}")

    # ── called from the scenario (main) thread ────────────────────────────────

    def put(self, key, value):
        with self.lock:
            self.clock.tick(self.name)
            self.store[key] = (value, self.clock.copy())
            log.info(f"[{self.name}] put  {key}={value!r:<6}  clock={self.clock}")

    def flush(self):
        """Block until this node's inbox is empty (all messages processed)."""
        self.inbox.join()


# ── Message bus ───────────────────────────────────────────────────────────────

class MessageBus:
    """
    Routes messages between nodes.

    send()  — capture the value+clock snapshot now and deliver immediately
    queue() — capture now but hold in buffer (for out-of-order demo)
    deliver(i) — release message i from the buffer
    """

    def __init__(self, nodes: dict[str, Node]):
        self.nodes  = nodes
        self.buffer: list[dict] = []

    def _make_msg(self, src_name: str, key: str) -> dict | None:
        src = self.nodes[src_name]
        with src.lock:
            if key not in src.store:
                log.info(f"  BUS  ✗  {src_name}: no value for {key!r}")
                return None
            val, vc = src.store[key]
            return {'from': src_name, 'key': key, 'value': val, 'vc': vc.copy()}

    def send(self, src_name: str, dst_name: str, key: str):
        """Snapshot and deliver immediately."""
        msg = self._make_msg(src_name, key)
        if msg:
            self._put(dst_name, msg)

    def queue(self, src_name: str, dst_name: str, key: str):
        """Snapshot now, hold in buffer — don't deliver yet."""
        msg = self._make_msg(src_name, key)
        if msg:
            entry = {'dst': dst_name, **msg}
            self.buffer.append(entry)
            log.info(f"  BUS  ~ queued  [{len(self.buffer)-1}] "
                     f"{src_name}→{dst_name}: {key}={msg['value']!r} @ {msg['vc']}"
                     f"  (clock snapshot taken NOW)")

    def deliver(self, index: int = 0):
        """Release message at buffer[index]."""
        if not self.buffer:
            log.info("  BUS  (buffer empty)"); return
        entry = self.buffer.pop(index)
        dst_name = entry['dst']
        log.info(f"  BUS  → deliver [{index}] "
                 f"{entry['from']}→{dst_name}: "
                 f"{entry['key']}={entry['value']!r} @ {entry['vc']}")
        self._put(dst_name, {k: v for k, v in entry.items() if k != 'dst'})

    def show_buffer(self):
        if not self.buffer:
            log.info("  BUS  (buffer empty)"); return
        for i, e in enumerate(self.buffer):
            log.info(f"  BUS  [{i}] {e['from']}→{e['dst']}: "
                     f"{e['key']}={e['value']!r} @ {e['vc']}")

    def flush_all(self):
        """Wait until every node's inbox is empty."""
        for node in self.nodes.values():
            node.flush()

    def _put(self, dst_name: str, msg: dict):
        dst = self.nodes[dst_name]
        log.debug(f"  BUS  inbox← {dst_name}: enqueuing "
                  f"{msg['key']}={msg['value']!r} @ {msg['vc']}  from={msg['from']}")
        dst.inbox.put(msg)


# ── Scenarios ─────────────────────────────────────────────────────────────────

def log_state(nodes):
    log.info("── final store state ─────────────────────────────────────────────────")
    for node in nodes.values():
        entry = node.store.get('x')
        if entry:
            val, vc = entry
            log.info(f"  {node.name}: x={val!r:<8} @ {vc}")
        else:
            log.info(f"  {node.name}: x=<none>")


def scenario_delayed(nodes, bus):
    log.info("══ Delayed-delivery scenario ════════════════════════════════════════")
    log.info("   B's message reaches D before A's — a causal gap.")

    log.info("── 1. A writes x=1; sends to B, C; queues to D (held back) ─────────")
    nodes['A'].put('x', 1)
    bus.send('A', 'B', 'x'); bus.send('A', 'C', 'x')
    bus.queue('A', 'D', 'x')          # held back
    bus.flush_all()

    log.info("── 2. B writes x=2  (B has seen A's write) ──────────────────────────")
    nodes['B'].put('x', 2)
    bus.queue('B', 'D', 'x')          # also held back

    log.info("   Buffer contents:")
    bus.show_buffer()

    log.info("── 3. Deliver B→D first (index 1), before A→D ───────────────────────")
    bus.deliver(1)                     # B→D jumps the queue
    bus.flush_all()
    log.info("   *** D holds x=2 @ {A:1,B:1,...} but its A-counter was 0.     ***")
    log.info("   *** Causal gap: D never saw x=1. The missing dependency is   ***")
    log.info("   *** visible — incoming vc[A]=1 > D's clock[A]=0 — but        ***")
    log.info("   *** receive() accepted it anyway.                             ***")

    log.info("── 4. Now deliver the delayed A→D (index 0) ─────────────────────────")
    bus.deliver(0)                     # A→D arrives late → stale, ignored
    bus.flush_all()

    log.info("── 5. C writes and replicates to D ──────────────────────────────────")
    nodes['C'].put('x', 'hi')
    bus.send('C', 'D', 'x'); bus.flush_all()

    log_state(nodes)

    log.info("── What causal delivery would do ────────────────────────────────────")
    log.info("   Before accepting B's msg (vc[A]=1), D checks: clock[A] >= 1?")
    log.info("   0 < 1  →  buffer B's msg until A's arrives.")
    log.info("   Once A→D is delivered, release B→D.  D always sees x=1 → x=2.")


# ── Entry point ───────────────────────────────────────────────────────────────

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('--causal', action='store_false',
                        help='Enforce causal delivery: buffer msgs until dependencies are met')
    parser.add_argument('--verbose', '-v', action='store_true',
                        help='Show DEBUG-level bus/inbox trace')
    args = parser.parse_args()

    setup_logging(args.verbose)

    nodes = {n: Node(n, causal=args.causal) for n in NODES}
    bus   = MessageBus(nodes)

    scenario_delayed(nodes, bus)


"""
what to keep track of
- message ordering
- processes or threads?

threading systems gives access to shared memory
causal multicast -> every actor is implemented as a thread

how to make the threads communicate? shared memory, message bus even better

when A wants to do a causal multicast it uses a pointer in a queue

compare the sent clock to the one maintained locally, check if there is a gap

what to do when the message bus is kept in a separate service? TCP connection

vector: <t(A),t(B),t(C)>
"""