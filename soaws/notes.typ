#import "../mono.typ": *
#show: template.with(rgb("#00aa88"), rgb("#ffaa00"), [Service-Oriented Architecture with Web Services])

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

= Service Composition
Service composition is born from architectural needs. Realistic services are made of smaller, elemental (atomic), reusable ones (composition). Composition can be seen as a workflow (process), in which each task is performed by a web service. The workflow describes how the services are composed and *how they work together*.
#i[Web services are invoked and not compiled and linked together as libraries.]
Atomic services remain separate from the composite service to promote reusability. The composition specifies the services to be invoked, the order and the conditions.

SOA architectures have better support for business processes.
== Choreography
With choreography (implicit support), a collection of services knows what they must do in order to work together and implement a certain service. The choreographer informs the dancers (components) on what to do beforehand. The process definition is explicit.

The public process is the one everyone sees. The private process is the one that is given to the implementer.

== Orchestration
With orchestration (explicit support), a service is defined to implement each process and orchestrate other services in order to make sure the process is correctly performed.
The maestro tells the musicians (components) how to play their parts.

Either orchestration and composition can be used when defining a service architecture
BPMN is a process modelling language.

= Docker
Services must be able to be hosted and ran on the cloud.
== Cloud Computing
Cloud computing is a model for computing in which something is done "in the cloud". The cloud is an iconic representation of the internet.\
SOA was introduced as an architectural solution to enable cloud computing. It allows resources to be leveraged trough the internet as services in order to control IT costs and make IT more agile. This way, companies can focus on their core business.

- Software as a service
- Platform as a service
- Infrastructure as a service: a virtual machine
- AI as a service

== Containerization
Offers a location and operating system-independent runtime environment to applications. Applications are ran in these containers. It doesn't matter where the application is ran (web, cloud, local device).

Nowadays, an application can be ran on multiple devices. They should also be ran anytime and anywhere. Also, companies no longer want their own server room.

Instead of having one big application on the server, smaller services are hosted on the cloud.

Virtual machine VS container: the VM has more overhead, a container is just the environment where an application can be ran. Docker is a containerization engine.

Users can fully commit to containerization without having to worry about the engine used (currently docker).

== Docker
Docker is the most popular container technology available today.

An image describes a container. Images can be pulled from a docker hub. The daemon exposes an API, and the CLI communicates with the API. the CLI manages networking, data volumes, containers and images.

An image is a readonly template with instructions for creating a container.
A container is a runnable instance of an image. A container can be started, stopped, moved or deleted using the API or CLI. A container can be connected to one or more networks, and storage can be attached to it. A container is defined by its image and configuration options.
A registry is used to store and distribute Images.
The daemon listens for docker API requests and manages objects. It can also communicate with other daemons in clusters.

The bridge network is giving port exposure at `8080:80`.

== Docker Storage
Data stored in a container is lost when the container stops, since the image is immutable.
- Temporary mount: used for caching
- Bind mount: connects to the host's filesystem
- Volume: docker manages the storage of the container

== Docker in Practice

- Dockerfile: Describes the image/blueprint
- Docker image: snapshot of the container
- Docker repository:

the container runs the compiled java file defined in the image

In production, make the container as small as possible, with no root and non-shell. Always specify the version, never use `:latest`. Always use a repository proxy that allows caching. This way, when dockerHub is down, your infrastructure won't fail.

Solutions have been developed to support clusters of containers to facilitate their configuration and management.

#link("https://docs.docker.com/get-started/docker_cheatsheet.pdf
")

= Communication Protocols

/ Technical interoperability: technical connection to communicate and share information. They are project independent
/ Syntactic interoperability: coding and structure of messages (data formats: JSON, XML)
/ Semantic interoperability: meaning, common understanding of the messages

Before SOA there were proprietary protocols (RPC, CORBA). With SOA 1.0 internet standards are used: XML, SOAP. With SOA 2.0 there are lightweight solutions: JSON, JSON schema, REST, JSON-API and GraphQL
== Data formats
They are the foundation of syntactic interoperability.
/ XML: Documents that conform with XML grammar rules
/ XSD: XSD files define the structure of XML files. They can also be used as a blueprint for java classes. JAXB facilitates the marshalling (java object to XML document) and un-marshalling (XML to java object). Used to validate information from other services. An XML schema defines the structure of an XML document, and the rules for data content (what fields an element can contain, which sub elements it can contain, and how many items can be present).

XPath can be used to query XML files.

/ JSON: Lightweight, text-based language independent data. It's a human readable interchange format.
/ YAML: Has less overhead than XML, and consists of key-value pairs. YAML files are more flexible than json files.

== REST
Representation State Transfer is an *architectural style* for invoking services over the internet (list of styles and agreements).

The rest principles are:
- Stateless client-server architecture: request messages are self contained. All the necessary information is in the request message.
- Web services are viewed as resources identifiable by their URIs: URIs offer a global addressing space for services.
- Web service clients and providers choose a representation to send application content to each other (XML, JSON,...). Client and provider have a mutual understanding of the meaning of data since there is no formal way to describe web service interfaces.

Within rest, there are a set fo remote methods that describe the actions to be performed on the resource: CRUD (Create, Read, Update, Delete) actions.

#i[With REST, the state of an object is changed, and then the whole object is sent (update operation).]
== Rest URI design guidelines
+ URIs must point to resources
+ Relationships must be exposed in the URI
+ Different URIs are used for instances and collections
+ Allow filtering

Crud actions are related to HTTP methods. With PATCH you can only send the field that you want to change.

No additional protocol information is needed.

== GraphQL
REST is static in nature, with GraphQL you don't request all the data to the server, just the information you need (avoid over and under-fetching). A server-side runtime executes queries by using a type system defined for the data that is being requested.

Possible operations are:
- Query: retrieve data;
- Mutation: adapt data;
- Subscription: be notified of changes in data

GraphIQL is used to play with GraphQL APIs.

== OpenAPI
JSON:API is a specification on how a client should request resources and how a server should respond to those requests. It standardizes implementation of RESTful APIs and their requests/responses.

OpenAPI specification (OAS) is a language agnostic interface to discover RESTful APIs that allows humans and computers to discover and understand the capabilities of the service without access to source code or documentation. The consumers can understand and interact with the remote service with a minimal amount of implementation logic.

SWAGGER is an UI for displaying APIs according to OAS (also has an editor and codegen).

HATEOAS is an alternative to OpenAPI. Hypermedia is used as the engine of application state (the state is transferred trough hypermedia links).

POJO: plain old java object
Model or Data transfer object (DTO)
Database access object (DAO), use mock data

= REST vs WS-\*
The main differences between REST and WS-\* (also known as Big Web Services or SOAP/WSDL-based architectures) are articulated across various architectural, conceptual, and technological levels:
== Role of the Web and HTTP Protocol
REST considers the Web as the universal medium for publishing information and uses HTTP as an actual application protocol. Applications expose resources identified by URIs, and clients interact with them using the full semantics of the four HTTP verbs: GET, POST, PUT, and DELETE. WS-\* considers the Web primarily as a universal transport medium for messages. It uses HTTP as a transport-level tunneling protocol to bypass firewalls, exchanging SOAP messages between endpoints, usually relying on a single verb (POST) regardless of the actual operation.
== Interface Definition and Description
REST adopts a uniform and predefined interface. The possible operations are limited to the HTTP verbs, and there is no true standard interface description language; services mostly rely on human-oriented textual documentation. WS-\* uses WSDL (Web Services Description Language), a strongly typed and machine-processable XML language that explicitly defines service contracts and available operations. This allows software tools to automatically generate client code, hiding the complexity of the interaction.
== Transport Flexibility and Message Format
REST is inherently tied to the HTTP protocol. However, it offers great flexibility in the payload format, being able to return representations in XML, JSON, HTML, or even plain text, depending on the client requests. WS-\* is independent of the transport protocol: a message can travel over HTTP, but also over asynchronous protocols like JMS or message queues (MQ), SMTP, or TCP. However, it imposes a single standardized format for messages: XML-based SOAP.
== Complexity and Architectural Decision Management
REST appears simpler because it offers freedom from choice: many decisions are predetermined (e.g., the protocol is always HTTP, the interface is fixed). However, this lack of options often forces developers to implement custom do-it-yourself solutions for advanced features, increasing development costs and technical risks. WS-\* offers freedom of choice, providing a large number of alternatives and standards for defining message exchange patterns, transports, and behaviors. Although it seems more complex, this conceptual richness is well supported by mature tools (SOAP engines and WSDL tools) that handle the low-level work.
== Quality of Service (QoS): Transactions, Security, and Reliability
REST relies on the basic guarantees of the HTTP protocol (best effort delivery) and HTTPS for point-to-point security. It lacks standardized frameworks for managing distributed transactions or reliable messaging. WS-\* includes a suite of optional specifications (e.g., WS-Security, WS-ReliableMessaging, WS-AT for transactions) that guarantee an advanced end-to-end level of service regardless of the underlying transport.
== Ideal Use Cases
In summary, REST is particularly suited for tactical and ad hoc integrations on the Web (e.g., Web 2.0 and Mashup architectures) thanks to its lightweight infrastructure and low barrier to entry. Conversely, WS-\* is the preferred choice for enterprise application integration, where longer lifecycles, interactions with heterogeneous systems (e.g., older mainframes), and strict advanced quality of service requirements are necessary.

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

= Deployment
_How to automatically deploy and scale on the cloud? How to deploy multiple small applications?_

+ We assume that we have a self sustainable container that runs our application.
+ We infrastructure to manage our containers efficiently

When we're not working locally, and need to deploy multiple containers, we can use Docker Swarm or Kubernetes.

== Docker Swarm
Swarm mode is a feature to manage a cluster of docker daemons. It consists in #m(page:13)

== Kubernetes
Kubernetes is a portable extensible, open source platform for managing containerized workloads and services that facilitates declarative configuration and automation. Functionalities:
/ Service discovery (service routing) and load balancing:
/ Storage orchestration:
/ Automated rollouts and rollbacks: route traffic to new containers
/ Automatic bin packing: utilize resources on a node as efficient as possible
/ Self-healing: when a node is lost, Kubernetes will try to restore it
/ Horizontal Scaling: when more resources are needed, new containers are created
/ Secret and configuration management:

A cluster consists of nodes (pc, virtual machine, ...) that form a cluster. A node contains multiple pods. Each pod has multiple containers. With Kubernetes you start/stop multiple pods. All containers in a pod can communicate with each other.

The scheduler always tries to find the best place to run a pod. The cloud node controller manager requests new nodes to the service cloud provider (cloud provider API).

A kubelet is the controller of a node, it communicates information of a node trough the kube-api-server.

== Pods
A pod is the smallest deployable unit on a Kubernetes cluster. It's a group of one or more containers with shared storage and resources, and a specification on how to run the containers.

Pods can either run a single container or multiple that need to work together (frontend and backend can be ran in the same pod).

== Workloads
/ Deployment and ReplicaSet: managing a stateless application workload on your cluster.
/ StatefulSet: lets you run one or more related pods that track the same state. A pod can be linked to a PersistentVolume. A database is usually ran as a StatefulSet. They cannot scale horizontally.
/ DaemonSet: defines pods that provide facilities that are local to nodes. It runs on each cluster node.
/ Job and CronJob: provide different ways to define tasks that run to completion and then stop. A job can be used to define a task that runs to completion once. A CronJob runs the same job multiple times according to a schedule.
/ Horizontal scaling: running multiple instances of your app
/ Vertical scaling: resizing CPU and memory resources assigned to containers.

Auto scaling means moving one pod from a node to another. A schedule constantly moves pods around.

== Services and Networking

Each pod in a cluster has its own cluster-wide ip address.
/ The pod network: handles communication between pods.
/ The service API: provides a stable long lived IP address or hostname for a service implemented by one or more backend pods.
/ The gateway API: allows you to make services accessible to clients that are external to the cluster.
/ NetworkPolicy: is a built-in Kubernetes API that allows you to control traffic between pods, or between pods and the outside world.

In production, Kubernetes can be used with PAAS, kubeadm, KOPS. During development it can be used with *Minikube* and docker desktop.

== DevOps

DevOps is a philosophy that promotes better communication and collaboration between teams in an organization. It describes the adoption of iterative software development, automation and programmable infrastructure deployment and maintenance.

The process of building and deploying software is more integrated.
- Collaboration and communication;
- Development outcomes;
- Product quality;
- Deployment management;

=== CI/CD: continuous delivery, continuous deployment
- More reliable builds
- Faster merging, earlier bug detection
- Automatic deployment
- Infrastructure as code/configuration
- How to configure and access secrets
- Orchestration: automatic resource provisioning, scaling, resource management
- Monitoring
- Microservices
