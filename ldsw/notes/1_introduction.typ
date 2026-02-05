#import "_ldsw.typ": *
#show: template
= Introduction
== Semantic Web
Create an infrastructure that can be navigated in a coherent way. Resources are interconnected by links. World Wide Web human processable information is made of linked resources. It doesn't matter how they are linked.
A web page is a rendering of an html document. A machine doesn't interpret what a link is. They are all treated the same.
Machines were limited in navigating information, because they can't tell the difference between them.

The semantic web has interconnected meaningful resources. Semantic web is an extension of the current web, where information and services are well defined, and can be shared and used by machines and humans.

Semantic web links make the relation explicit, they give them meaning. Resources can be interlinked regardless of their location (dynamic linking). There are multiple data sources.

== Linked Data
How data is represented in the semantic web. LD is a set of best practices for publishing and connecting structured data on the web using standard formats and interfaces. It supports easy combination of multiple linked data sources.

Everything on the web right now is at least 1 star linked data.
/ #sym.star: Has to be linked/available on the web.
/ #sym.star#sym.star: Has a machine readable structure
/ #sym.star#sym.star#sym.star: Machine readable but in a non-proprietary format
/ #sym.star#sym.star#sym.star#sym.star: W3C standard approved (systematic approach)
/ #sym.star#sym.star#sym.star#sym.star#sym.star: Is linked to other data. *NOT* that it's open access.

== RDF
Data model for linked data.
/ Resource: pages, concepts, ideas (everything that can have an URI)
/ Description: attributes, features and *relations* of the resources
/ Framework: model, languages and syntaxes for these descriptions
RDF is a standard format for data exchange on the web.

XML is a tree model, RDF is a triple model. Formed by a *subject*, a *predicate* (relation), and an *object*#footnote[The object can be the subject in another or multiple triples.]. Triples can be combined to form complicated knowledge graphs.

Linked Open Data (LOD) is LD which is released under an open license.

== How to publish data as LD
LD principles:
- Use URIs as names for things;
- Use HTTP URIs so that people can look up those names;
- When someone looks up an URI, provide useful information using the standards (RDF, SPARQL)
- Include links to other URIs, so people can discover more things (5#sym.star rule).

Steps:
+ Create our own URIs
+ Look at knowledge graphs/ontology repositories to reuse existing vocabularies
+ Convert the concepts from natural language to another term in the coding language (abstract from the real item). Machine just need the encoding/identifiers of concepts.
+ In the definitions, put links to other sources.

== RDFS
It's *not* RDF-schema. It extends RDF with the possibility to define classes and associated properties. It allows RDF applications to agree on a common data description vocabulary. The most used RDF syntax is *turtle*.

== SPARQL
SPARQL Protocol and RDF Query Language is a SQL-like query language for RDF data. It's a simple protocol for querying remote database over HTTP. It has different queries:
- `select`: projections of variables and expressions;
- `construct`: create triples based on query results
- `ask`: check whether a query returns results
- `describe`: describe resources in the graph

== OWL
Web Ontology Language: knowledge representation language designed to formulate, exchange and reason with knowledge about a domain of interest.
