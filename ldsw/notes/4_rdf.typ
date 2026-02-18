#import "_ldsw.typ": *
#show: template
= RDF
#note(supplement:[def])[Interoperability][The ability of two or more systems or components to exchange information and to use it.]
#note(supplement:[def])[Semantic Interoperability][#m(page: 7)]

== Naming

/ URI: sequence of characters to uniquely identify a resource.
/ IRI: extends URIs with unicode#footnote[URIs and IRIs will be used interchangeably].
/ URN: uniform resource name: resource identifiers with the specific requirements for enabling location independent #m(page:11)

== Syntaxes
/ RDF/XML: RDF syntax based on XML,
/ N-triples: simple syntax for line delimited N-triples
/ Turtle: Superset of N-triples, with shortcuts to facilitate readability
/ Notation3: Superset of of Turtle and RDF. Contains non-RDF features like rules, scoping graphs,...
/ RDFa: RDF in attributes, it allows to embed RDF into XHTML, HTML or XML in general. It's a mix of machine and human readable language. This was mainly used by Google to scrape the web. Has some issues regarding readability, maintainability and FAIR principles.
/ JSON-LD: JSON for Linked Data, created to facilitate the use of RDF by software developers.

RDF literals are used for values of predicates such as strings, numbers and dates (basic data types). All literals are between quotes and must have their data type specified in order to not be considered as strings (`"25"^^xmls#integer`).

== RDF Types

=== Blank Nodes
Blank nodes represent the existence of something that was not given an IRI. When you don't want to create an identifier, you can use `_:BlankNode`. Especially useful with nested objects in a data structure. Blank nodes can only be usd locally.

=== Containers
Containers are an unbounded resource type that contains groups of resources (members). Containers are open, there is no mechanism to know the number of members.
/ Bag: unordered set
/ Seq: ordered set
/ Alt: unordered set of alternatives (mutually exclusive), in which the first is the default option.

=== Collections
Collections are closed, members can be counted. They are linked lists (`rdf:List`). Some properties are `rdf:first`, `rdf: rest`, `rdf:nil`.

== RDFS
RDF Schema extends RDF with the possibility to define classes and associated properties. Allows RDF applications to agree on a common description vocabulary.

RDF defines specific relations, such as:
- `rdf:type` (`my:City` $stretch(arrow)^#raw("rdf:type")$ `rdfs:Class`)
- `rdf:property` and `rdf:subPropertyOf`
- `rdfs:domain`
- `rdfs:range`
