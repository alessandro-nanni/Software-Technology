#import "_soaws.typ": *
#show: template
= Security
= Sync/Async communication

/ Async processing: do not wait while the activity is performed;
/ Async communication: do not wait for the other to reply.

HTTP is a 1-1 synchronous communication.

Websocket: The client initializes a request, a tunnel is created that allows asynchronous processing (client sends request, server sends response at a later time).

= Transfer Protocols

/ UDP/TCP: UDP is used for calls and voice chats, since it doesn't need any checks.
/ SMTP/SFTP:
/ HTTP: synchronous request/response. In the authentication header you pass the JWT token.

== Message Queue

The clients scale with the size of the queue to reduce cost and energy.

Different types:
/ Broker: load balancing helps with background processes, but it also has more complexity and is a single point of failure.
/ Brokerless:
/ In-memory:
/ Database-based:

In java there are transactional methods (commit, rollback). Multiple listeners can cause deadlocks.

Two phase commit:
+ The coordinator asks if he can delete a blogpost
+ If all the participants vote yes, the the coordinator executes the decision
+ The decision is acknowledged by the participants.

There are multiple message queue implementations.
ActiveMQ classic is the easiest to startup.


== Websockets
Allow bidirectional communication over TCP. Communication between services and other services or a server.

== AS2
A specification on how to share sensitive/secure data safely.
