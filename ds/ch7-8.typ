= Consistency and Replication

== Introduction: The Motivations and the Fundamental Catch
Data replication is a core technique in distributed systems driven by two primary motivations: improving reliability and enhancing performance. By maintaining multiple copies of data, a system can survive the crash of individual nodes and protect against corrupted data by using majority voting. Furthermore, replicating data to geographic locations close to end-users significantly reduces network latency, scaling the system to handle massive workloads. Content Delivery Networks (CDNs) heavily rely on these principles to serve users effectively.

However, replication introduces a fundamental problem: maintaining consistency. Whenever one replica is updated, it temporarily diverges from the others, creating a state of inconsistency. Solving this requires updates to be propagated as a single atomic operation, synchronizing all replicas. Because global synchronization over wide-area networks is inherently expensive and severely limits scalability, system designers must frequently weaken consistency requirements to achieve acceptable performance.

== Data-Centric Consistency Models
A data-centric consistency model is a contract between the system and the processes accessing it: if processes follow certain rules, the data store promises to return specific, predictable results.

=== Sequential Consistency
Defined by Leslie Lamport, a data store is sequentially consistent if the result of any execution is the same as if the read and write operations by all processes were executed in some sequential order, and the operations of each individual process appear in this sequence in the order specified by its program. This model does not rely on a global clock or absolute time; it simply dictates that all processes must observe the exact same valid interleaving of operations. For example, if three independent processes execute a set of operations, many time-independent execution signatures are mathematically possible, but the system guarantees that every node agrees on which specific sequence occurred.

=== Linearizability
Linearizability is a stricter model than sequential consistency. It dictates that each operation must appear to take effect instantaneously at some exact moment between its start and its completion. This introduces a real-time (clock time) ordering constraint: if an operation fully completes before another one begins, the system must respect this chronological order. While linearizability solves the non-compositional flaws of sequential consistency, implementing it over wide-area networks introduces massive performance overhead.

=== Causal Consistency
Causal consistency represents a weakening of sequential consistency by distinguishing between causally related events and concurrent events. If a write operation $W_2$ is influenced by an earlier write $W_1$ (e.g., reading a post and then writing a reply), all processes must see $W_1$ before $W_2$. However, if two processes spontaneously write data items without any causal link, these concurrent writes do not need to be globally ordered; different machines may observe them in different sequences. Implementing causal consistency generally requires maintaining a dependency graph using mechanisms like vector clocks.

=== Eventual Consistency and the CAP Theorem
For systems with very few write-write conflicts, such as the Domain Name System (DNS) or web caches, developers often adopt eventual consistency. This model guarantees that if no new updates are submitted, all replicas will eventually converge to identical copies. However, it offers no guarantees on when this convergence will happen or what intermediate values clients might observe. To resolve the rare conflicts, systems often use mechanisms like Conflict-Free Replicated Data Types (CRDTs) to ensure deterministic conflict resolution. 

This directly relates to the CAP Theorem, which states that a distributed system cannot simultaneously guarantee Consistency, Availability, and Partition tolerance. Because network partitions are inevitable, developers must usually choose between building a Consistent and Partition-tolerant (CP) system or an Available and Partition-tolerant (AP) system.

== Client-Centric Consistency Models
Data-centric models are expensive because they provide guarantees for concurrent operations across all clients. In contrast, client-centric models (originating from the Bayou system) focus on the experience of a single, often mobile, client connecting to different replicas over time. They provide four session guarantees to hide inconsistencies from the user:

- *Monotonic Reads:* Once a process reads a data value, any successive read will return that same value or a newer one; a client will never "travel back in time" to see older data.
- *Monotonic Writes:* A write operation by a process is completely propagated and executed before any successive write operation by the same process can take place.
- *Read Your Writes:* The effect of a write operation by a process will always be seen by a successive read operation by that same process, preventing a user from updating a web page and then seeing the old version upon refreshing.
- *Writes Follow Reads:* Any successive write operation by a process is guaranteed to take place on a copy of the data that is at least as up to date as the value most recently read by that process.

=== Example: ZooKeeper
Apache ZooKeeper is a coordination service that provides a mix of these models. It routes all write operations to a fixed primary server, guaranteeing sequential consistency for updates. However, reads are served by the local replica the client is connected to, meaning reads can be stale. While it natively guarantees monotonic reads and monotonic writes, it deliberately does not guarantee read-your-writes or writes-follow-reads consistency, making this trade-off to enable high-performance coordination at scale.

== Replica Management
Replica management dictates where to place content and how to propagate updates.

=== Content Placement Strategies
Content is typically organized into three logical, concentric rings:
1.  *Permanent Replicas:* The initial, statically configured core servers or mirror sites (e.g., origin servers in a cluster).
2.  *Server-Initiated Replicas:* Created dynamically to handle bursts in demand. Servers count file accesses grouped by client origin. If demand exceeds a replication threshold $R$, a replica is pushed to a server closer to that region. If demand drops below a deletion threshold $D$, the replica is removed, creating a self-tuning system.
3.  *Client-Initiated Replicas:* Local client caches (like browser caches). They are lightweight, ephemeral, and managed by the client to bypass network latency.

=== Propagating Updates
When data changes, the system can use three propagation strategies:
- *Invalidation:* Sending only a notification that data is stale. This requires minimal bandwidth and works best when the update-to-read ratio is high.
- *Transfer of Data:* Pushing the actual updated data. This is efficient when the read-to-update ratio is high.
- *Transfer of Operations (Active Replication):* Sending the instruction itself (e.g., "add 5") to let each replica independently re-execute it. This saves bandwidth but requires more processing power.

Updates can be *pushed* by the server (best for shared data with high read ratios) or *pulled* by the client (best for personal caches with low read ratios). Systems often blend these using *leases*, where a server promises to push updates for a limited time. Leases can be dynamically shortened or lengthened based on the data's age, a client's renewal frequency, or the server's load. Furthermore, updates can be sent via *unicast* (point-to-point, often paired with pull) or *multicast* (efficient network delivery, paired with push).

== Consistency Protocols
Consistency protocols provide the concrete mechanisms to implement these abstract models.

=== Primary-Based Protocols
In a primary-backup protocol, a single designated server (the primary) accepts all write operations, coordinates a global ordering, and propagates the updates to backup servers. The write can be blocking (the client waits until all backups acknowledge the update) or nonblocking (faster, but less fault-tolerant). To optimize performance for mobile or disconnected users, a *local-write protocol* allows the primary copy to physically migrate to the process initiating the updates.

=== Quorum-Based Protocols
Quorum-based protocols avoid single points of failure by using majority voting. In a system with $N$ replicas, clients must acquire permission from a read quorum ($N_R$) to read, or a write quorum ($N_W$) to write. The system enforces two rules:
1.  $N_R + N_W > N$: This ensures the read and write quorums overlap, so a reader always sees the latest write.
2.  $N_W > N / 2$: This prevents write-write conflicts because two concurrent updates cannot both assemble a majority.

A popular configuration is Read-One, Write-All (ROWA), where $N_R = 1$ and $N_W = N$. This yields extremely fast reads but makes write operations slow and vulnerable to any single node failure.


= Fault Tolerance: Communication, Consensus, and Byzantine Failures

== Synchrony, Dependability, and Failure Detection
To build fault-tolerant systems, it is crucial to understand the timing assumptions of the underlying network. In a *synchronous system*, execution speeds and message delays are bounded, meaning that if a process does not respond within a known timeframe, it can be reliably declared as crashed (fail-stop). However, distributed systems in practice are *partially synchronous*: they normally operate synchronously, but can experience unbounded delays. In such systems, failure detection relies on timeouts, leading to a "fail-noisy" model where a process might eventually be detected as crashed, but false positives can occur if the network is merely slow. 

The dependability of these systems is measured using specific metrics:
- *Availability:* The probability that the system is operating correctly and is ready for immediate use at any given moment.
- *Reliability:* The ability of a system to run continuously without failure over a specific time interval.
- *Maintainability:* How easily a failed system can be repaired. 
These metrics are mathematically related using Mean Time To Failure (MTTF) and Mean Time To Repair (MTTR), where the Mean Time Between Failures (MTBF) is simply $"MTTF" + "MTTR"$.

== RPC Failures and Semantics
Client-server communication, particularly Remote Procedure Calls (RPC), faces unique failure modes that do not exist in local execution. These failures are categorized into five types:
1. *Client cannot locate the server:* Handled by raising an exception, though this inherently breaks the transparency of the RPC.
2. *Lost request messages:* Handled by setting a timer at the client and retransmitting the request if no acknowledgment arrives.
3. *Server crashes:* The most difficult to handle because the client cannot know if the server crashed before, during, or after executing the request. Systems must choose a failure semantic: *at-least-once* (keep retrying, risking duplicate execution), *at-most-once* (give up immediately), or making no guarantees. *Exactly-once* semantics are mathematically impossible to guarantee in the presence of server crashes.
4. *Lost reply messages:* If a client retransmits, the server might execute the operation twice. This is harmless if the operation is *idempotent* (e.g., reading a file block), but dangerous if it is not (e.g., transferring money). Non-idempotent operations require the server to track client sequence numbers to reject duplicate requests.
5. *Client crashes:* This creates "orphan" computations running on the server without a waiting client. Solutions include *extermination* (explicitly killing the orphan), *reincarnation* (broadcasting a new epoch number when the client reboots to kill old computations), or *expiration* (giving the RPC a maximum time quantum to finish).

== Process Redundancy and k-Fault Tolerance
To mask failures, systems organize identical processes into groups. 
- *Flat groups* are completely symmetrical with no single point of failure, but decision-making requires complex voting.
- *Hierarchical groups* use a coordinator and workers. This allows for fast decisions, but the coordinator becomes a single point of failure, requiring a leader election if it crashes.

The size of the group required depends on the failure model:
- *Crash/Omission Failures:* To survive $k$ concurrent crash failures, a system needs $k + 1$ members, as one correct result is sufficient.
- *Arbitrary (Byzantine) Failures:* If processes can produce incorrect or malicious responses, simple majority voting (like in Triple Modular Redundancy hardware) requires $2k + 1$ components to mask $k$ faults. However, if the processes must actively communicate to *reach distributed consensus*, the mathematical requirement rises to $3k + 1$ members.

== Consensus with Crash Failures
The goal of consensus is to ensure all non-faulty processes in a group execute the exact same commands in the same order. The *FLP Impossibility Theorem* proves that in a fully asynchronous system, guaranteeing consensus is impossible if even one process crashes. Therefore, practical algorithms rely on partial synchrony.

=== Raft
Designed specifically to be easier to understand than Paxos, Raft is a log-based, primary-backup consensus algorithm.
- *Log Replication:* The leader receives client requests, appends them to its local log as uncommitted entries, and sends `AppendEntries` RPCs to followers. Once a majority of followers acknowledge the entry, it is committed, executed, and the client receives a response. 
- *Leader Election:* If a follower hears nothing from the leader, it becomes a candidate and requests votes. To prevent split votes where multiple candidates tie, Raft uses randomized timeouts. The candidate with the most up-to-date log that secures a majority becomes the new leader.

=== Paxos
Paxos strictly separates roles into Proposers (who receive client requests), Acceptors (who vote on proposals), and Learners (who execute chosen operations). It operates in two phases to handle concurrent proposers:
1. *Prepare/Promise:* A leader broadcasts a proposal with a strictly increasing timestamp. Acceptors promise not to accept anything older and return any operation they have already accepted.
2. *Accept/Learn:* The leader instructs acceptors to accept an operation. If the acceptors returned a previously accepted operation in Phase 1, the leader is forced to adopt it. Once a majority accepts an operation, learners are notified to execute it.
By forcing new leaders to adopt previously accepted operations, Paxos mathematically guarantees safety (no divergent logs), even during false crash detections where multiple leaders might be active simultaneously.

== Byzantine Fault Tolerance (PBFT)
Byzantine failures occur when a process behaves arbitrarily—lying, colluding, or sending contradictory messages to different peers (the Byzantine Generals Problem). 

To tolerate $k$ Byzantine failures, a group must have $n = 3k + 1$ replicas. If a group only had $3k$ replicas (e.g., 3 replicas for 1 fault), a faulty primary could send 'True' to one backup and 'False' to the other. When the backups exchange their values, they both hold the set {True, False} and cannot determine whether the primary lied or the other backup lied. With $3k + 1$ processes, the $2k + 1$ non-faulty processes will always form a strict mathematical majority to outvote the $k$ traitors.

Practical Byzantine Fault Tolerance (PBFT) achieves consensus through three signed message phases:
1. *Pre-Prepare:* The primary assigns a timestamp and view number to an operation and broadcasts it.
2. *Prepare:* Backups verify the message and broadcast a `Prepare` message. A server achieves a "prepare certificate" once it logs $2k$ matching prepare messages.
3. *Commit:* Servers broadcast a `Commit` message. Once a server collects $2k$ matching commits, it finally executes the operation.

If the primary acts maliciously or crashes, backups trigger a *View Change*. The new primary collects prepare certificates from a quorum to prove which operations were already agreed upon, preserving safety across leadership changes. 

Because PBFT requires every node to communicate with every other node, it generates $O(N^2)$ network messages, making it practical only for relatively small groups (e.g., ~100 nodes). Modern blockchain consensus algorithms scale this by using protocols like *HotStuff* (which reduces communication to $O(N)$ via leader-relays) and by using economic deterrents (Proof of Work/Proof of Stake) alongside cryptographic threshold signatures.