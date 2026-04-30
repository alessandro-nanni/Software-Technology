#set page(numbering:"1")
#show heading.where(level:1): it => underline(it.body)
#align(center,text(size:20pt)[Chapter 5 Concepts])

= Cristian's Algorithm

== Purpose
Cristian's algorithm is a protocol used in distributed systems for *physical clock synchronization*. It provides a mechanism for a client machine to synchronize its local software clock with an accurate time server, such as a machine equipped with a UTC receiver.

== How It Works
Because network communication takes a finite and unpredictable amount of time, a client cannot simply ask a server for the time and blindly set its clock to the received value; by the time the message arrives, the server's timestamp is already outdated. Cristian's algorithm compensates for this by estimating the network delay using the following steps:

+ The client sends a time request to the server and records the exact time the request was sent ($T_0$).
+ The server processes the request and returns a response containing its current time ($T_s$).
+ Upon receiving the response, the client records the arrival time ($T_1$).
+ The client assumes that the network delay is perfectly *symmetric*, meaning the message took the exact same amount of time to reach the server as it did to return. It calculates the total round-trip time ($T_1 - T_0$), divides it by two to estimate the one-way delay, and adds this value to the server's time.
+ The client sets its new clock time to: $T_s + (T_1 - T_0) / 2$.

The accuracy of this synchronization is bounded by $plus.minus (T_"round" - T_"min") / 2$, where $T_"min"$ is the absolute minimum possible one-way delay of the network.

== Limitations
- *Asymmetric Delays:* The algorithm's fundamental flaw is its reliance on the assumption of symmetric delays. In the real world, particularly under heavy network congestion, routing paths and delays are often highly asymmetric, which significantly degrades the accuracy of the clock adjustment.
- *Single Point of Failure:* Relying on a single time server creates a strict single point of failure for the entire distributed system.
- *Time Cannot Go Backward:* If the algorithm calculates that the client's clock is running fast, the system cannot simply jump the clock backward to match the server. Doing so would break software logic that relies on time strictly moving forward (such as `make` compilation scripts which look at file modification times). Instead, the client must use a process called *slewing*, where the local clock is gradually slowed down by adding fewer milliseconds per hardware interrupt until it aligns with the correct time.

= Lamport's Logical Clocks

== The Need for Logical Time
In distributed systems, relying on physical clocks is fundamentally flawed due to clock drift, unpredictable network latencies, and the lack of perfect synchronization. However, for many distributed applications, processes do not actually need to agree on exactly what the absolute time is. Instead, they only need to agree on the *order* in which events occur. This insight led to the creation of logical clocks, which track the relative ordering of events without relying on physical time.

== The "Happened-Before" Relation
To synchronize logical clocks, a foundational relation called *happened-before* is used, denoted as $a -> b$ (read as "event a happens before event b"). This relation means that all processes agree that event a occurred first, followed by event b. The relation can be observed directly in two situations:
- If events $a$ and $b$ happen in the same process, and $a$ occurs before $b$, then $a -> b$ is true.
- If $a$ is the event of a message being sent by one process, and $b$ is the event of that same message being received by another process, then $a -> b$ is also true. This is because a message cannot be received before, or at the exact same time, it is sent.
- *Transitivity:* If $a -> b$ and $b -> c$, then $a -> c$.

If two events happen in different processes that do not exchange messages (even indirectly via third parties), neither $a -> b$ nor $b -> a$ is true. These events are considered *concurrent* ($a || b$), meaning nothing can be said about their relative ordering.

== The Algorithm
To implement this concept, every process maintains a local software counter (its logical clock), which increments to assign a time value to every event. The goal is to ensure that if $a -> b$, then the clock time of $a$ is strictly less than the clock time of $b$ ($C(a) < C(b)$). The algorithm follows three rules:
+ Before executing any event (such as sending a message or delivering a message to an application), a process increments its local counter by 1.
+ When a process sends a message, it attaches its current, newly incremented counter value to the message as a timestamp.
+ When a process receives a message, it compares its own local counter to the message's timestamp. It adjusts its local counter to be equal to the maximum of these two values. After adjusting the clock to ensure it is caught up to the sender, the receiver then executes the first step (incrementing its counter by 1) before delivering the message.

Because events can potentially happen at the exact same logical time in different processes, systems often add a unique process identifier to break ties. For example, an event at time 40 in process $i$ becomes a tuple $<40, i>$. If process $j$ also generates an event at time 40, and $i < j$, then the system globally agrees that $<40, i> < <40, j>$.

== Application: Totally Ordered Multicasting
A major application of Lamport clocks is solving distributed synchronization problems, such as updating a replicated database. For example, if a customer deposits \$100 in a San Francisco database replica while a bank employee in New York simultaneously adds 1% interest to the same account, both updates must be applied in the exact same order at all replicas to ensure the final account balance is consistent everywhere.

Lamport clocks solve this by enabling *totally ordered multicasting*. When an update occurs, the process multicasts the message along with its Lamport timestamp to all other processes. Each receiver places incoming messages into a local queue, strictly ordered by their timestamps, and multicasts an acknowledgment to the group. A process only delivers an update to its application when that update is at the head of its queue and has been acknowledged by all other processes. Because everyone adheres to the same Lamport clock rules and resolves ties using process IDs, every replica processes the updates in the exact same sequence.

== Limitations: The Causal Gap
While Lamport clocks guarantee that if $a -> b$, then $C(a) < C(b)$, the converse is fundamentally *not* true. Just because $C(a) < C(b)$ does not imply that event $a$ actually caused or happened before event $b$. The events might be completely independent and concurrent, but one process simply had a faster-ticking logical counter due to executing more local events. 

Consequently, Lamport clocks provide a clean total ordering of events but cannot reliably distinguish between events that are causally related and those that are merely concurrent. To accurately capture and track true causality, distributed systems must extend this concept into *Vector Clocks*.


= Vector Clocks

== The Causal Gap of Lamport Clocks
While Lamport's logical clocks successfully provide a total ordering of events in a distributed system, they suffer from a fundamental limitation often referred to as the "causal gap." Lamport clocks guarantee that if event $a$ happens before event $b$ ($a -> b$), then the logical time of $a$ is strictly less than $b$ ($C(a) < C(b)$). However, the converse is not true: if we observe $C(a) < C(b)$, we cannot definitively conclude that $a$ actually caused or happened before $b$. The events might be completely independent and concurrent, but one process simply happened to have a faster-ticking logical counter. 

To overcome this limitation and accurately capture true causality, distributed systems use vector clocks. With vector clocks, by simply comparing the timestamps of two events, we can determine exactly whether one event causally preceded the other or if they occurred concurrently.

== The Core Concept: Tracking Causal Histories
The theoretical foundation of vector clocks lies in tracking "causal histories." If every event in a system is assigned a unique name (such as the process ID combined with a locally incrementing counter), causality could be tracked by attaching the entire history of all preceding events to every message. When a process receives a message, it would merge the sender's causal history with its own.

However, transmitting entire histories over the network is highly inefficient. Because events within a single process occur sequentially, there is no need to list every single event from that process; knowing the *total number* of events that have occurred at that process is sufficient. Vector clocks optimize causal histories by compressing this information into a simple array (a vector) of integers.

== The Algorithm
In a system with $N$ processes, each process $P_i$ maintains a local vector, $V C_i$, consisting of $N$ elements. 
- The entry $V C_i[i]$ represents the number of events that have occurred so far at process $P_i$ (its own local logical clock).
- Any other entry $V C_i[j]$ represents $P_i$'s knowledge of the local time at process $P_j$. In other words, it indicates that $P_i$ knows about exactly $V C_i[j]$ events that have taken place at $P_j$.

The vector clock is maintained through three strict rules:
+ *Local Event:* Before executing any event (sending a message, delivering a message to an application, or an internal event), $P_i$ increments its own entry in its vector: $V C_i[i] <- V C_i[i] + 1$.
+ *Sending a Message:* When $P_i$ sends a message $m$, it attaches its current, newly updated vector as the message's timestamp: $t s(m) = V C_i$.
+ *Receiving a Message:* Upon receiving a message $m$ with timestamp $t s(m)$, a process $P_j$ updates its own vector by taking the element-wise maximum of its current vector and the message's timestamp: $V C_j[k] <- max(V C_j[k], t s(m)[k])$ for every index $k$. This step essentially merges the sender's causal knowledge with the receiver's causal knowledge. After this, $P_j$ executes step 1 (incrementing its own local counter $V C_j[j]$) before delivering the message.

== Comparing Vector Clocks
Because timestamps are arrays rather than single integers, comparing them requires a specific mathematical definition. We say that a vector timestamp $V$ is strictly less than $V'$ ($V < V'$) if and only if:
- $V[k] <= V'[k]$ for all indices $k$, AND
- There is at least one index $k^*$ for which $V[k^*] < V'[k^*]$.

Using this definition, the causal gap is completely closed. We can state with absolute certainty that event $a$ causally precedes event $b$ ($a -> b$) *if and only if* $V(a) < V(b)$. 

If we compare two vector timestamps and find that neither $V(a) < V(b)$ nor $V(b) < V(a)$ is true (meaning one vector has a higher value in one index, but the other vector has a higher value in a different index), we know definitively that the two events are *concurrent* ($a || b$). Neither event knows about the other's existence.

== Application: Causally-Ordered Multicast
Vector clocks are instrumental in implementing causally-ordered multicasting. Unlike totally ordered multicasting (which forces all nodes to process all messages in the exact same sequence regardless of relevance), causally-ordered multicasting only requires that messages which share a cause-and-effect relationship are delivered in order. Concurrent messages can be processed in different orders at different nodes, which significantly improves system concurrency and performance. This is heavily used in collaborative editors, distributed databases, and chat systems where replies must visually follow the specific messages they respond to.

To enforce causal delivery, a middleware layer intercepts incoming messages and places them in a "hold-back queue" until their causal dependencies are met. A process $P_j$ will only deliver a received message $m$ (sent by process $P_i$ with timestamp $t s(m)$) to the application layer when two specific conditions are satisfied:
+ $t s(m)[i] = V C_j[i] + 1$: This guarantees that $m$ is exactly the next consecutive message that $P_j$ is expecting from the sender $P_i$, ensuring no missing intermediate messages from that sender.
+ $t s(m)[k] <= V C_j[k]$ for all $k != i$: This guarantees that $P_j$ has already received and delivered every single message from other processes that the sender $P_i$ had seen *before* it sent message $m$. 

If these conditions are not met, the message remains safely buffered in the queue until the missing prerequisite messages arrive.


= Centralized Mutual Exclusion Algorithm

== The Core Concept
The most straightforward way to achieve mutual exclusion in a distributed system is to simulate how it is handled in a traditional, single-processor system. This is done by electing a single, dedicated process to act as the coordinator. This coordinator is uniquely responsible for managing access to a specific shared resource (such as a file, database row, or printer) and ensuring that only one process can enter the critical section at any given time.

== How the Algorithm Works
The centralized algorithm operates through a simple request-grant-release protocol involving the coordinator and the competing processes:

- *Request:* Whenever a process wants to access the shared resource, it sends a request message to the coordinator, specifying the resource it needs.
- *Grant (Resource Free):* If no other process is currently accessing that resource, the coordinator immediately sends back a grant message, giving the requesting process permission to proceed into the critical section.
- *Queue (Resource Busy):* If another process is already in the critical section, the coordinator cannot grant permission. Depending on the specific system implementation, it will either refrain from replying at all (forcing the requester to block and wait) or send an explicit "permission denied" message. The coordinator then places the incoming request into a local waiting queue.
- *Release:* When the process currently utilizing the resource finishes its task, it exits the critical section and sends a release message to the coordinator. The coordinator then takes the first request off its queue and sends a grant message to that waiting process, unblocking it and allowing it to access the resource.

== Guarantees and Performance
This algorithm perfectly satisfies the fundamental requirements of distributed mutual exclusion:
- *Safety:* It strictly guarantees mutual exclusion because the single coordinator only ever permits one process to access the resource at a time.
- *Fairness:* Because the coordinator queues deferred requests in the exact order they are received, the system is strictly fair. 
- *Liveness:* As long as processes eventually release the resource, no process will wait forever, meaning there is no starvation and no deadlocks.

In terms of performance, the centralized algorithm is highly efficient. It requires exactly three messages per use of the resource: one to request access, one to grant access, and one to release the resource. Furthermore, the delay before a process can enter an available critical section is merely two message transfer time units (MTTUs)—one for the request to reach the coordinator and one for the grant to return.

== Drawbacks and Vulnerabilities
Despite its efficiency, relying on a single coordinator introduces several distinct challenges:
- *Single Point of Failure (SPOF):* If the coordinator crashes, the entire system mechanism for that resource halts. Processes waiting in the queue or attempting to request access will be permanently blocked.
- *The "Silent Coordinator" Problem:* If the system is designed such that the coordinator simply ignores requests when the resource is busy (rather than sending an explicit "denied" message), clients face an ambiguity problem. A process that blocks after making a request cannot easily distinguish whether it is waiting because the resource is legitimately busy, or because the coordinator has crashed and the request was lost. 
- *Performance Bottleneck:* In a massively scaled distributed system with high load, a single coordinator can quickly become overwhelmed by thousands of incoming requests and releases, limiting overall system throughput.

== Practical Viability
Interestingly, even though fully distributed algorithms (like Ricart-Agrawala or Token Ring) eliminate the single point of failure, they often introduce much greater complexity and perform worse under failure conditions, as a crash in *any* node can halt a fully distributed algorithm. Because the centralized algorithm's behavior is so simple to reason about, and because it is relatively straightforward to implement fault tolerance for the coordinator (e.g., using primary-backup replication or leader election protocols like ZooKeeper), the centralized approach remains widely applied in real-world distributed systems.

= Distributed Algorithm: Ricart-Agrawala

== The Core Concept
Unlike the centralized approach, the Ricart-Agrawala algorithm achieves mutual exclusion without relying on a single dedicated coordinator. Instead, it is a fully distributed algorithm where every process in the system participates in every access decision. To resolve concurrent requests fairly and unambiguously across the network, the algorithm requires a total ordering of all events, which is achieved by utilizing Lamport's logical clocks.

== How the Algorithm Works
The protocol ensures mutual exclusion through a strict peer-to-peer agreement mechanism. When a process wants to access a shared resource, the following sequence occurs:

- *Requesting Access:* The process builds a request message containing the name of the resource, its own process identifier, and its current logical timestamp. It then reliably multicasts this message to all other processes in the system.
- *Processing Incoming Requests:* When a process receives a request message, its response depends entirely on its current state regarding that specific resource:
  1. *Not interested:* If the receiver is not currently accessing the resource and has no interest in doing so, it immediately sends an "OK" reply back to the sender.
  2. *Resource busy:* If the receiver is already inside the critical section, it does not reply. Instead, it places the incoming request into a local waiting queue.
  3. *Conflict (both want access):* If the receiver is also currently waiting to access the resource, it compares the timestamp of the incoming request with the timestamp of its own broadcasted request. The request with the lowest timestamp wins. If the incoming request is older (lower timestamp), the receiver yields and sends an "OK" message. If the receiver's own request is older, it queues the incoming request and sends nothing.
- *Entering the Critical Section:* A requesting process must sit back and wait until it has received an "OK" message from *every* other process in the system ($N-1$ messages). Only when all permissions are collected is it allowed to proceed into the critical section.
- *Releasing the Resource:* After the process finishes using the resource, it iterates through its local waiting queue, sends an "OK" message to every deferred process waiting in it, and then clears the queue.

== Guarantees and Performance
The Ricart-Agrawala algorithm successfully guarantees mutual exclusion without introducing deadlocks. Because conflicting requests are resolved by comparing logical timestamps, the process that requested access "first" (in logical time) will consistently win, ensuring strict fairness and preventing starvation.

In terms of performance and network overhead, the algorithm requires exactly $2(N-1)$ messages for a process to enter a critical region: $N-1$ request messages sent to all other peers, and $N-1$ "OK" messages received in return. Assuming sequential message passing over the network, the delay before entry is also $2(N-1)$ message transfer time units.

== Vulnerabilities and Limitations
While this algorithm successfully eliminates the single point of failure inherent in the centralized approach, it inadvertently replaces it with $N$ points of failure, making it highly fragile in real-world scenarios.

- *Vulnerability to Crashes:* If any single process crashes, it will fail to respond to incoming requests. Because the algorithm requires an active "OK" from *all* nodes, the crashed node's silence will be incorrectly interpreted as a denial of permission. This permanently blocks all other processes from ever entering the critical section.
- *Complexity in Fault Tolerance:* To patch the crash vulnerability, the algorithm must be modified so that processes always reply (either granting or explicitly denying permission). If a reply is lost, the sender must use timeouts to retry or eventually conclude the peer is dead. This requires every process to continuously and accurately maintain a global group membership list (handling nodes that join, leave, or crash), which is notoriously difficult to synchronize.
- *Resource Burden:* Because every process must be involved in every single access decision, the algorithm imposes a heavy processing and communication burden across the entire network. This makes it highly inefficient for large-scale systems or environments with resource-constrained nodes.


= Token Ring Algorithm

== The Core Concept
The token ring algorithm achieves distributed mutual exclusion by organizing all processes into a logical overlay network structured as a ring. In this ring, each process is assigned a specific position and knows exactly who its successor is. Mutual exclusion is enforced by a single, special message called the "token" that circulates around this ring. A process is only granted permission to enter the critical section if it currently holds the token.

== How the Algorithm Works
The algorithm operates through the continuous passing of the token:
- *Initialization:* When the system starts, process 0 is given the token.
- *Circulation:* The token is passed sequentially from one process to its neighbor (from process $k$ to process $(k+1) "mod" N$) using point-to-point messages.
- *Resource Access:* When a process acquires the token from its neighbor, it checks if it needs to access the shared resource. If it does, it enters the critical section, does its required work, and then leaves. After finishing, it passes the token to the next process in the ring. To ensure fairness, a process is not permitted to immediately re-enter the critical section using the same token.
- *Bypassing:* If a process receives the token but has no interest in accessing the resource, it simply forwards the token to its neighbor immediately.

== Guarantees and Performance
The token ring algorithm perfectly satisfies the fundamental requirements of mutual exclusion without relying on a central coordinator:
- *Safety:* Because only one token exists in the entire system at any given time, it is impossible for multiple processes to access the resource simultaneously.
- *Fairness and Liveness:* The strict circulation order guarantees that no process will starve. Once a process decides it wants the resource, it will wait at most for every other process in the ring to take its turn.
- *Performance:* The algorithm's efficiency depends heavily on system load. Under heavy load (when everyone wants to enter), each token pass results in an entry, meaning it requires an average of just $1$ message per entry. However, when the system is idle, the token circulates continuously, meaning the number of messages sent is technically unbounded ($1 "to" infinity$). The delay before a process can enter the critical section varies from $0$ message transfer time units (MTTUs) if the token just arrived, to $N-1$ MTTUs if the token just departed.

== Vulnerabilities and Limitations
While it effectively eliminates the single point of failure found in centralized algorithms, the token ring introduces its own set of distinct challenges:
- *Token Loss:* If the token is lost (e.g., dropped by the network or lost because the holding process crashed), the entire system halts. Detecting a lost token is inherently difficult because the time between successive appearances of the token is unbounded—if the token hasn't been seen for an hour, it might be lost, or another process might simply be spending a long time inside the critical section. 
- *Process Crashes:* If a process crashes, the logical ring is broken. To recover from this, the protocol must be enhanced to require acknowledgments when passing the token. If a neighbor fails to acknowledge receipt, the sender assumes the neighbor is dead and throws the token "over the head" of the crashed process to the next active process in the line. Implementing this recovery, however, requires every single process to constantly maintain and synchronize an up-to-date map of the current ring configuration.


= Leader Election

== Why Leader Election is a Problem
Many distributed algorithms—such as those for mutual exclusion, log replication, and two-phase commit—rely heavily on a single process acting as a coordinator or leader. If this coordinator crashes, the entire system can stall. The goal of a leader election algorithm is to automatically, safely, and eventually pick a new coordinator so the system can recover.

However, electing a leader in a distributed system is fundamentally difficult. If all processes are identical, it is impossible to single one out, so processes must be assigned unique identifiers. While processes generally know the identifiers of all other members in the group, they do not inherently know which ones are currently running and which have crashed.

The theoretical core of the problem is defined by the *FLP Impossibility Theorem*. It proves that in a fully asynchronous system (where there is no upper bound on message delays or processing times), it is mathematically impossible to guarantee consensus if even a single process might crash. Because a system cannot distinguish between a process that has truly crashed and one that is merely running very slowly, it faces a dilemma:
- If the system waits indefinitely for all processes to vote, it risks blocking forever if a node has crashed.
- If it uses timeouts to assume a node is dead, a slow-but-correct node might be falsely classified as failed. If that "dead" node was the old leader and it continues to operate alongside a newly elected leader, the system suffers a "split-brain" scenario, violating safety guarantees.

To make progress, practical distributed systems rely on partial synchrony and timeouts, accepting that occasional false elections might occur to ensure the system doesn't halt permanently.

== The Bully Algorithm
The Bully algorithm assumes every process has a unique numeric ID and enforces the rule that the active process with the highest ID always becomes the coordinator. It operates through the following steps:

- *Initiation:* When a process notices that the current coordinator is no longer responding, it initiates an election by sending an `ELECTION` message to all processes with identifiers *higher* than its own.
- *Victory by Default:* If no higher-ID process responds, the initiating process assumes it is the highest active node. It wins the election and broadcasts a `COORDINATOR` message to all other processes to announce its takeover.
- *Takeover:* If one or more higher-ID processes respond with an `OK` message, they take over the election process. The original sender's job is done, and it simply waits to be told who the new leader is. The higher-ID processes then hold their own elections by sending messages to processes with even higher IDs.
- *Rejoining:* If a process that previously crashed comes back online, it immediately holds a new election. If it happens to have the highest ID in the network, it will successfully bully the current leader into submission and take over the coordinator role.

While straightforward, this algorithm can be network-intensive, potentially requiring $O(N^2)$ messages in the worst-case scenario where the lowest-ID process triggers the election.

== The Ring Algorithm
Unlike the Bully algorithm, the Ring algorithm organizes all processes into a logical ring overlay network, where each process knows exactly who its successor is.

- *Initiation:* When a process discovers the coordinator is down, it creates an `ELECTION` message containing its own process identifier and passes it to its successor.
- *Bypassing Failures:* If the immediate successor is down and does not respond, the sender skips over it and forwards the message to the next member along the ring until it finds a running process.
- *Building the List:* At each active step along the ring, the receiving process appends its own identifier to the list within the `ELECTION` message and forwards it.
- *Declaring the Winner:* Eventually, the message circulates the entire ring and returns to the process that originally started the election (which it recognizes because its own ID is the first in the message). At this point, the list contains all currently active processes in the system.
- *Informing the Ring:* The initiator selects the highest identifier from the collected list, changes the message type to `COORDINATOR`, and circulates it around the ring one more time. This informs everyone who the new leader is and updates them on the current active ring membership. Once this message completes the circle, it is removed, and normal operations resume.

Even if multiple processes detect the coordinator's failure and start independent elections simultaneously, the algorithm remains safe. Multiple `ELECTION` messages will simply circulate, but all will eventually yield the exact same active membership list and conclude with the exact same highest-ID leader.
