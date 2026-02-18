#import "_soaws.typ": *
#show: template
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
