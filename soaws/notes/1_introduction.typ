#import "_soaws.typ": *
#show: template
= Introduction
How quickly can new services and applications be implemented, and at which costs? How expensive is it to change the applications later? How do you reduce maintenance costs?

Usual solutions involved group fixes, random integration approaches with accidental architectures. Architectures become unmanageable. *No Adapters*.

There was a big focus on system integration, and not business integration. System processes were inflexible and scattered. Rigid architectures and no process alignment resulted in costly maintenance.

Instead of one-to-one connection, services are used to interface the different components of the web application. Services can also be offered to other organizations.

Proper architectures use a layered system. Systems are interconnected by services #sym.arrow *Service Oriented Architecture*.

Services can be packaged, reused, and distributed.

Service oriented architecture (SOA) is a design discipline for applications whose parts interact by referring to each other's services. Web service is a software system designed to support interoperable machine-to-machine interaction over a network.

Web services and technologies can be used to implement service-oriented architectures.

#i[A service is a logical representation of a repeatable business activity that has a specified outcome, is self contained (complete in itself) and is a "black box" to consumers of the service. A service can be composed of other services. It can be considered the evolution of middleware.]

A service offers an interface to consumers. Consumers can utilize multiple interfaces in their own service. They are designed to allow interoperability.

*Naive view*: applications are designed with top-down development. However, legacy applications cannot be ignored in the development of a bigger application.\ Legacy applications impose additional technological requirements, addressed by bottom-up development.

== Layers of distributed applications

#merge(separator: sym.arrow.l.r.double.long)[Presentation (GUI)][Application Logic][Resource Management (database)]

Logical layers do not impose any combination and distribution of functionality

A tier is a combination of layers in a physical system.

One Tier architecture:

#merge(separator: sym.arrow.l.r.double.long)[Client (terminal)][Presentation][Application Logic (monolithic application)][Resource Management]\
This was very performant, but had high maintainability costs.

Two tier architecture:
#merge(separator: sym.arrow.l.r.double.long)[Client (terminal) + Presentation][Application Logic][Resource Management]
-  Free server from presentation issues
- Poor scalability
- Difficult to integrate with other two-tier applications (had to be done via a client)

Three tier architecture
#merge(separator: sym.arrow.l.r.double.long)[Client + Presentation][Application Logic (middle tier)][Resource Management]
N Tier architecture

#merge(separator: sym.arrow.l.r.double.long)[Client (web browser) ][Web Server + HTML filter][Application Logic][Resource Management]

Web server forms an additional tier, setting for web service architectures.
== Interaction between tiers
Synchronous communication
+ A request is sent trough a service interface
+ When it arrives to the provider, a response is formed (blocking operation)
+ Only after the response is received, the thread is resumed.

Relatively simple architecture, but the calling and the called are tightly coupled. There is poor performance if processing takes too much time or multiple tiers.

Asynchronous communication
- Calling and called are loosely coupled
- Intermediaries can store and process messages
- Potentially more complex due to the need to synchronize

