#import "_soaws.typ": *
#show: template
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



