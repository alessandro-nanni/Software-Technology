#import "_soaws.typ": *
#show: template
= Microservices
== Motivation (technical)
Service oriented architecture is independent of the middleware used. Their size can be as big as an entire application or as small as a single data object. Services can be deployed in-house or in the cloud, and the user wouldn't notice.

People realized they needed more guidelines to achieve performance, fast deployment. Smaller services were assigned to a single development team.

Many applications used to be deployed as big Java Web Archive (WAR) files deployed in an application server like tomcat. They typically have a backend that supports a web UI, and often also a REST API and calls other services trough adapters. This type of web applications are called monoliths. The use of microservices rather than monoliths promotes scalability. Monoliths couldn't be extended.

Systems can scale by:
+ Instance duplication (could make the application faster);
+ Functional decomposition: separate big functions in smaller components;
+ Data partitioning: if everyone is accessing the same data if partitioned correctly it can reduce the number of concurrent operations;

Microservice architecture combines these 3 strategies.

#note(supplement: [def])[Microservice][
    The microservice architectural style is an
    - approach to developing a single application
    - as a suite of small (modular) Services
    - each running in its own process and
    - communicating with lightweight mechanisms, often an HTTP resource API (i.e. REST).
]

A monolithic application puts all its functionality in a single process, and scales by replicating the monolith on multiple servers.\
A microservice architecture puts each element of functionality in into a separate service, and scales by distributing these services across servers, replicating as needed.

== Principles

Microservices
+ Are componentised: microservices should run in their own separate processes and utilize lightweight communication mechanisms, such as RESTful resources or asynchronous message queues (MQ). Additionally, each service encapsulates its own data and logic, and relies on lightweight containers to handle deployment and scaling
+ are rganized around business capabilities. Business driven development practices and pattern languages, i.e. domain driven design (DDD) to identify and conceptualize services.
+ should be designed for failure: failures are isolated. If a service fails, the whole system doesn't break. Circuit breakers are introduced to make the whole system reliable.
+ should be designed with decentralization in mind, specifically regarding intelligence, governance, and data management. Cloud-native principles such as IDEAL (isolated state, distribution, elasticity, automated management, and loose coupling) should be used, as well as polyglot programming and persistence strategies.
+ Profit from infrastructure automation: it is possible to continuously deliver new versions of the application. Lean DevOps: holistic and largely automated configuration, performance and fault management (agile practices).

== Service Definition

#def[Service (Richardson 2019)][
    A service is a *standalone*, *independently deployable* software component that implements some useful functionality.
]

Traditionally applications were developed and maintained by teams horizontally organized in terms of functions (development, testing, operations,...). The lifecycle was delayed since every change had to pass trough these teams.

Vertical organization causes less delay and enables more frequent releases. A core team is still required to make sure everything works together. This way each team can be made responsible for the while lifecycle of a microservice.

== Identifying Services
The definition of a service doesn't rely entirely on its size, but also on the context of the application. Microservices should also be organized around business concerns rather than technical concerns.

Services can be identified trough *business capabilities* or *domain driven design*.

=== Business Capabilities
A business capability is something that a business does to generate value. It captures what an organization's business is and what the organization does or should do. It's identified by analyzing the organization's purpose, structure and business processes. A business capability actually defines a business service, and can be mapped onto an application (micro)service.

=== Domain Driven Design

It's a technique based on object orientation in which the problem domain (business logic) is addressed first before entering the solution domain. In the problem domain, designers focus on the domain model that represents the domain concepts and their relations, and defines an ubiquitous language for the stakeholders.

Since domains can become complex, making it difficult to align all stakeholders of a domain to agree on a domain model and a single vocabulary, *subdomains* can be used, each with their own domain model.

== API Gateways
Api gateways control access to APIs. They are the entrance point for a system. The API gateway offers an URI request to the microservice internal APIs.

*Service meshes* are dedicated layers that provide secure service-to-service communication for on-premise, cloud, or multi-cloud infrastructure. It's composed of two parts:
/ Control plane: it maintains a central registry that keeps track of all the services and their respective ip addresses. It's able to share with other members of the service mesh how to communicate with the application and enforce rules for who can communicate with each other. They are responsible for securing the mesh, checking it's health and policy enforcement.
/ Data plane: it handles communication between services. Some service mesh solutions use a sidecar proxy to handle data plane communications: it limits the level of awareness the services need to have about the network environment.

== SOA and Microservices

Microservices aren't different from SOA. They are just a particular implementation of SOA.
#figure(table(
    columns: 3,
    [], [*Traditional SOA Style*], [*Microservices*],
    [Core metaphor],
    [Service, consumer-provider contract pattern],
    [Fine-grained interfaces, independently deployable services, RESTful resources],

    [Method],
    [Object-oriented analysis and design, service-specific design methods],
    [Domain-Driven Design, agile practices],

    [Architectural principles],
    [Layering, loose coupling, flow independence, modularity],
    [IDEAL cloud architectural principles, overlap SOA principles but cover cloud computing-specific aspects],

    [Data Storage],
    [Information services, service provider implementations (Relational Databases)],
    [Polyglot persistence (SQL, NoSQL, NewSQL)],

    [ Deployment and hosting],
    [Not applicable],
    [Lightweight containers (e.g., Docker, Dropwizard), XaaS cloud offerings],

    [Build tool chain / operations],
    [Not applicable],
    [Decentralised continuous delivery / Lean but comprehensive system/service management (DevOps)],

    [Message routing, transformation, adaptation],
    [Enterprise Service Bus (ESB)],
    [API gateways, lightweight messaging systems (Message queues), transformation services],

    [Assembly / composition],
    [Choreography and Orchestration],
    [Orchestration via plain old programming (also Choreography)],

    [Lookup (runtime, design time)],
    [Service registry (including service repository)],
    [Custom service registries and repositories (OpenAPI/Swagger-based), service discovery (application and network level)],
),caption:[Service Principles from Zimmerman 2017])

== Drawbacks & Obstacles

While microservices offer flexibility, they also introduce significant architectural complexity and overhead. Because the system is heavily distributed, seamless collaboration between the individual services is essential and cannot afford to break. To maintain this, development teams must communicate effectively and strictly manage documentation and versioning. Additionally, this architecture creates new technical obstacle. For example, breaking up a monolithic database means that handling transactions across multiple microservices now requires extra, specialized mechanisms to function correctly.
