#import "_soaws.typ": *
#show: template
= _Data Distribution and Transactions_

== How to split databases cleanly
Understand which parts of the code read and write to and from the database.

Database level constraints still need to be considered, like foreign key relationships. Tables may span service boundaries, a database may be used from different bounded contexts.

*Foreign key relation* possible solution: remove the relation and use the service or triplicate the database if it's static data.

Transactional behavior: either all these events happen together or none of them happen. ACID properties.

Transactions in databases: operations in a database can happen within a single transaction boundary. Decomposing a database may break transactions. Solutions:
/ Eventual consistency: assume that the system will return to a consistent state in the future
/ Abort the operation: rollback to restore the consistent state
/ Implement a distributed transaction: use a transaction manager to keep the system in a consistent state across different transactional boundaries.

== Two-phase commit protocol
The two-phase commit protocol is used to implementi distributed transactions to maintain a consistent state across different service boundaries, specifically in short-lived transactions. It relies on a central transaction manager to coordinate the process between multiple participants.
It operates in two distinct phases:
/ Preparation (Voting Phase): The transaction manager sends a request to all participating services. Each participant evaluates the request and responds with a vote. If even one participant votes "NO", the entire transaction is cancelled. If a participant votes "YES", they remain blocked until they receive the final instruction to proceed.
/ Commit: The transaction manager sends a "COMMIT" message to the participants. This phase operates on the assumption that any participant who said "YES" during the voting phase will be able to successfully commit.

== SAGA Pattern

The Saga pattern is a microservice design pattern used to implement distributed transactions that maintain ACD (Atomicity, Consistency, and Durability) properties. In a saga, a distributed transaction consists of a sequence of local transactions that are executed individually by each participating microservice.
These transactions are executed in a specific order. If any local transaction fails during the process, the saga executes compensating transactions to undo the changes made by the preceding successful steps, effectively rolling back the overall process.
The local steps within a saga generally fall into three structural classifications:
 / Compensatable transactions: Initial steps that can potentially be rolled back using a paired compensating transaction.
/ Pivot transaction: The "go/no-go" point of the saga. If this transaction successfully commits, the rest of the saga is guaranteed to run to completion.
/ Retriable transactions: Steps that follow the pivot transaction and are guaranteed to complete successfully without needing rollbacks.
To trigger these local transactions, sagas require a coordination mechanism, typically utilizing message queues (publish/subscribe) to prevent the microservices from becoming too tightly coupled.

There are two main approaches to coordination:
/ Choreography: Each service performs its task and then publishes an event that triggers the next service's step. This creates a completely distributed flow, but it can make the overall saga difficult to track and understand.
/ Orchestration: A central orchestrator controls the process by explicitly requesting each service to perform its step one at a time, acting as a state machine. While easier to map out, this approach risks inappropriately centralizing business logic within the orchestrator.
=== The Isolation Challenge
 A defining characteristic of sagas is that they lack the Isolation property found in traditional database ACID transactions. Because sagas execute over time across multiple independent services, different sagas can compete for the same resources concurrently, which can lead to data anomalies:
/ Lost updates: One saga overwrites changes without reading the modifications just made by another saga.
/ Dirty reads: A saga reads data updated by another saga that has not yet completed (and might ultimately roll back, meaning the data was never permanently valid).
/ Fuzzy/nonrepeatable reads: Two different steps of the same saga read the same data but get different results because a different saga updated the data in the meantime.
To mitigate these isolation issues, developers must build in *countermeasures*. These can include semantic locks (blocking other operations while an entity is in a `"_PENDING"` state), using commutative updates (designing operations like credits and debits so they can be executed in any order), or taking a pessimistic view (reordering the saga steps so the riskiest transaction serves as the pivot point).
.
