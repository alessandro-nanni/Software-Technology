#import "_soaws.typ": *
#show: template
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
