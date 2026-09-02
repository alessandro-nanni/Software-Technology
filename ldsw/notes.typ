#import "../mono.typ": *
#show: template.with(rgb("#00aa88"), rgb("#ffaa00"), [Linked Data and Semantic Web])

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

#let kd = [Kadaster]
= #kd Knowledge Graph (KKG)
How is linked data is being used in the real world. #kd maintains a wide range of geographical (and not) registers. The knowledge graph is born to provide a faster way to make queries between registers, without having to rely on IDs. Can be used to detect tax evasion from different data.
Challenges:
- Accessing data from geo-spatial services
- Provide easy access to your own data to avoid copies

Linked data was used because:
- it provides the semantics of the data so that there is a share understanding of what the data means;
- it ensures data authenticity to users;
- it provides information about how the data should be used.

#kd uses only 5-star *open* data.

Model timeline:
/ First Experiments: no standardized ontologies, schema is based on the API schema
/ New Approach to LD publication: reuse of international standards, ontologies are manually defined based on information models, non-standardized KKG model
/ Production Ready: reuse of international *standards*, MIM#footnote[Meta model for information models] based ontologies, *standardized* KKG model.

There are key register silos for #kd, Topographies, Restrictions, Demographic data,....

Companies use either use knowledge graph or SQL database.

In triplestore, it should be possible to reference other knowledge graphs via SPARQL queries.

Lessons Learned
/ Governance:
  - Adoption Strategy
  - Linksets: how two datasets are connected, who should create and maintain them?
  - Ownership
/ Modelling:
  - Modelling for a given use case
  - Modelling resources
/ Scope:
  - Use case driven vs. data push driven: only use data that is useful

= Ontology

Ontology is a branch of philosophy that studies concepts such as existence, being, becoming and reality. Ontologies work on a system of categories (substances, relations, states of affairs) that provides an encompassing classification of all entities.

#n(
    supplement: [def],
)[Ontology][A data model that represents knowledge as a set of concepts within a domain and the relationships between these concepts.

    An ontology is a formal#footnote[Formal: grounded in formalism (some logic)] explicit#footnote[Explicit: explicitly specifying what is intended in the real world.] definition of a shared conceptualization#footnote[Shared conceptualization: common understanding of the concepts.].

    Conceptualization refers to the theory, while the ontology is the artefact that represents this theory.
]

Ontologies are needed to share conceptualizations and semantics (meaning). They improve the understanding between people *and machines*.

== Types of ontologies
/ Thesaurus: list of words in groups of synonyms and related concepts;
/ Taxonomy: categorization or classification of concepts;
/ Vocabulary: body of words used in a particular natural language;
/ Ontologies: concepts and their relations.

Thesauri, taxonomies and vocabularies are often seen as simpler forms of ontologies.

Ontologies can be classified based on their accuracy. Fine grained ontology is precisely defined to represent the intended models. Coarse grained ontology is a minimal set of axioms that rely on existing agreements.

#note[Ontology Quality][
    - Syntax correctness;
    - Semantic correctness: no logical inconsistencies, no unintended relations
    - Ontological commitment;
]


#note[Types of ontologies according to their generality][
    / Top level/foundational ontology: describes general concepts;
    / Domain ontology: describes concepts related to a domain;
    / Task ontology: describes concepts related to a task or activity;
    / Application ontology: describes concepts of a particular domain and task, specializing the related ontologies.
]

== Ontology Applications
Ontology is used to integrate originally disparate information systems and give them common meaning.

Ontology is a form of knowledge management. It captures the knowledge within an organization as a model, that can be queried by users to answer question and display relationships across an enterprise.

Data is found in many different forms. This makes it hard to understand existing relationships between existing data. Data needs to be represented in a format that allows relationships to be discovered. Ontologies allow these relationships to become visible.

== Ontology Contents

The two standards that govern the construction of ontologies are Resource Description Framework (RDF), Web Ontology Language (OWL).
In accordance with RDF and OWL, ontologies are made of classes and relationships. Classes and relationships can be combined to assert statements about the real world.

#i[Classes can have instances. I.e. Todd is an instance of the class Person.]
The combination of classes and relationships is known as a triple, composed of a subject, predicate and object.
Triples can be merged to provide a comprehensive view of the real world within an ontology.

Within an ontology concepts are defined in terms of relationships with other concepts.

In description logics (used in OWL2), ontologies can be separated in two parts:
/ TBox: for universally quantified assertions (classes, properties and axioms)
/ ABox: for assertions on individual objects (instance assertions)

#note[Ontology Engineering][
    Many methodologies have been defined in literature, with different approaches. Different scenarios can be implemented by combining steps as described in the NeOn project.
]

Ontologies can be developed:
/ top-down: from scratch, by extending foundation ontologies or by reusing ontological patters.
/ bottom-up: by extracting knowledge from available resources.

*Ontologies are easily extensible*: instead of rewriting lines of code new relationships can be added to existing ontologies.
Using ontologies for knowledge management is an alternative to source code. This approach is hard to manage, and can be managed only by a small group of engineers. Ontologies are a new way to manage knowledge and capture relationships. Ontologies are a suitable choice for a large changing organization because it allows more individuals to get directly involved and ease of modification.

== Systematic Approach for Building Ontologies
SABIO is an ontology engineering methodology inspired by software engineering principles. It focuses on a specific scenario, usually the development of reference ontologies and their corresponding operational ontologies. The use of OntoUML is recommended for defining reference ontologies. It also recommends to ground ontologies in foundational ontologies. These simplify the modelling task due to their expressiveness and precision. The development phases are indicated as sequential, but any model can be used.

/ Reference ontology: is a conceptual model mainly for communication and analysis.
/ Operational ontology: is a computational artefact with some desirable computational properties.

These next steps are important for domain experts and ontology users.
=== Purpose and Requirements
Functional requirements are captured with competency questions: questions that the ontology is supposed to answer. Non-functional requirements are not related to contents. Complex ontologies should be decomposed in sub-ontologies.

=== Capture and Formalization
This process is supported by knowledge acquisition. It defines concepts, relations and constraints. A natural language definition of the axioms is written, followed by a formalization (first order logic or OCL). This step is formally iterative and results in a reference ontology.

=== Design and Implementation
The reference ontology and non-functional requirements are used to derive a compliant operational ontology design specification to be implemented. The operational ontology is then coded in the indented operational language (OWL2). Tools can help to translate the reference ontology to the language of the operational ontology.

=== Testing
In this phase, there is a strong involvement from the ontology tester and ontology user. Sub-ontologies should be tested separately fist (unit, integration and system tests). Tests should be _competency-questions driven_ and black box. The ontology should be tested considering its intended use. Individuals are then generated to check whether the intended models are correctly represented.

=== Support Processes
/ Knowledge acquisition: brainstorming, inspection of sources, interviews;
/ Reuse: looking for similar ontologies, reuse of foundation ontologies, ontology patterns.
/ Documentation: uniformity via document templates, naming conventions;
/ Evaluation: verification (built correctly) and validation (right ontology);

= RDF
#note(supplement:[def])[Interoperability][The ability of two or more systems or components to exchange information and to use it.]
#note(supplement:[def])[Semantic Interoperability][
  Focus on implementation of shared data in an unambiguous way, ensuring that the understanding of information is the same for the senders and the receivers.
]

== Naming

/ URI: sequence of characters to uniquely identify a resource.
/ IRI: extends URIs with unicode#footnote[URIs and IRIs will be used interchangeably].
/ URN: uniform resource name: resource identifiers with the specific requirements for enabling location independent identification for a resource
/ URL: uniform resource locator, subset of URIs that in addition to identifying a resource, provide the means to locating the resource by describing its primary access mechanism.

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
Collections are closed, members can be counted. They are linked lists (`rdf:List`). Some properties are `rdf:first`, `rdf:rest`, `rdf:nil`.

== RDFS
RDF Schema extends RDF with the possibility to define classes and associated properties. Allows RDF applications to agree on a common description vocabulary.

RDF defines specific relations, such as:
- `rdf:type` (`my:City` $stretch(arrow)^#raw("rdf:type")$ `rdfs:Class`)
- `rdf:property` and `rdf:subPropertyOf`
- `rdfs:domain`
- `rdfs:range`
- `rdfs:subClassOf`

#let c(body) = $#text(body, font: "Calibri", weight: 5, size: 10pt)$
= Description Logics
A description logic (DL) is a structured fragment of first order logic. It's a representation oat a predicate level, without variables.
It claims to be a unifying formalism for other knowledge representation languages, such as frames-based systems, object oriented modelling, semantic data models,...
#i[DL is a declarative language to formulate theories and systems for expressing, accessing and reasoning with structured knowledge.]
It's used for terminologies, ontologies, logic based conceptual data modelling and information integration.

#note(supplement: [def])[Top and Bottom sets][
    In Description Logics, the top and bottom sets represent the absolute boundaries of your knowledge base: "Everything" and "Nothing."
    - Top Concept ($top$): This is the set of all individuals in your entire domain. Every single concept you create (like #c[Person], #c[Car], #c[Dog]) is automatically a subset (subconcept) of $top$.
    - Bottom Concept ($bot$): This is the set that contains absolutely no individuals. It represents an impossibility. Every concept is a superset of $bot$.
]

== $bold(cal("SROJQ"))$ DL
=== ABOX Axioms
#i[Knowledge about individuals]
/ Concept assertion: $"Mother"("Julia")->$ #c[Julia] is a #c[mother]. $C$ is #c[Mother], $a$ is #c[Julia], $C(a)$ means that #c[Julia] is a #c[Mother].

/ Role assertion: $"parentOf"("Julia","John")->$ #c[Julia] is a parent of #c[John]
/ Individual inequality: $"Julia"approx.not "John"->$ #c[Julia] and #c[John] are different individuals
/ Individual equality: $"John" approx "Johnny"->$ #c[John] and #c[Johnny] are the same individuals
=== TBOX Axioms
#i[Relationships between concepts]
/ Concept inclusion: $"Mother"subset.eq.sq "Parent"->$ all mothers are parents (#c[Mother] is subsumed by #c[Parent])
/ Concept equivalence: $"Person" equiv "Human"->$ #c[Person] and #c[Human] have the same instances
=== RBOX Axioms
#i[Relationships between roles]
/ Role inlcusion: $"parentOf" subset.eq.sq "ancestorOf"->$ #c[parentOf] is a subrole of #c[ancestorOf]
/ Role composition: $"brotherOf" compose "parentOf" subset.eq.sq "uncleOf"->$ the chain of #c[brotherOf] followed by #c[parentOf] is a subrole of #c[uncleOf]
/ Disjoint roles: $"Disjoint"("parentOf","childOf")->$ the roles #c[parentOf] and #c[childOf] are mutually exclusive; an individual cannot be both the #c[parentOf] and the #c[childOf] of the exact same person. Disjoint pairs are used to represent pairs that have no relationships with each other.
#i[$"parentOf" inter.sq "childOf" = emptyset$, or better $"parentOf" inter.sq "childOf" subset.eq.sq bot$]
Other characteristics are reflexivity, symmetry and transitivity.

=== Boolean concept constructors
/ Intersection (conjunction): $"Mother"equiv "Female" inter.sq "Parent"$
/ Union (disjunction): $"Parent"equiv "Father" union.sq "Mother"$
/ Complement (negation): $"Female" inter.sq not "Married"->$ unmarried woman
/ Top concept: $top subset.eq.sq "Male" union.sq "Female"->$ $top$ is the top concept, with every individual
/ Bottom concept: $"Parent" inter.sq "Childless" subset.eq.sq bot->$ $bot$ is the bottom concept (empty)

=== Role restrictions
/ Existential restriction: $"Parent" equiv exists "parentOf."top->$ set of elements that are parent of at least one individual.
$exists "parentOf.Female"->$ people who have (at least) a daughter

/ Universal restriction: $forall "parentOf.Female"->$ if a person has a child, then it is a daughter/no children other than female ones. In this case $forall$ indicates *only*, so individuals who are parents *only* to #c[Female]s.
$exists "parentOf."top inter.sq forall "parentOf.Female"->$ People who have daughters.

=== Role domain and range restrictions
$exists "sonOf."top subset.sq.eq "Male"$ (Domain of sonOf is Male)\
$top subset.sq.eq forall "sonOf.Parent"$ (Range of sonOf is a Parent)
/ At-least restriction: $gt.eq 2 "childOf.Parent"->$ children of at least two parents
/ At-most restriction: $lt.eq 2 "childOf.Parent"->$ children of at most two parents
/ Local reflexivity: $exists "talkTo.self"$

=== Role constructors/characteristics
/ Inverse role: $"parentOf"equiv"childOf"^- ->$ if an individual $A$ has a #c[parentOf] relationship to individual $B$, it inherently implies that individual $B$ has a #c[childOf] relationship to individual $A$. If a role is defined by the pair $chevron.l x,y chevron.r$, its inverse is $chevron.l y,x chevron.r$.
/ Role Transitivity: $"Trans"("ancestorOf")->$ the role #c[ancestorOf] has the characteristic of being transitive. $"Trans"("ancestorOf") equiv "ancestorOf" compose "ancestorOf" subset.sq.eq "ancestorOf"$ formally defines how a transitive role behaves.
/ Role symmetry: $"marriedTo"equiv"marriedTo"^- ->$ a role is symmetric if it is equivalent to its inverse.
/ Role asymmetry: $"Disjoint"("parentOf", "parentOf"^-)->$ a role is asymmetric if it's disjoint with its inverse.
=== Description Logics Semantics
Description logics semantics follow the open world assumption, i.e., what is unspecified is open (might be true or false).
#i[This is in opposition to the more common closed world assumption that what is not true is false.]

#figure(image("notes/src/srojq constructors.png"), caption: [$bold(cal("SROJQ"))$ constructors])

#figure(image("notes/src/srojq axioms.png", width: 50%), caption: [$bold(cal("SROJQ"))$ axioms])

=== Interpretation

/ $cal(I) models alpha$: axiom $alpha$ holds in the Interpretation.
/ $cal(I) models cal(O)$: interpretation $cal(I)$ satisfies ontology $cal(O)$, $cal(I)$ is a model of $cal(O)$
Ontology is consistent if it has at least one model.
/ $cal(O) models alpha$: axiom $alpha$ is a consequence of the interpretation if it holds in all models of $cal(O)$.

#note[General open world assumption][
    The ontology
    $
        & "parentOf"("Julia", "John") \
        & "manyChildren"("Julia") \
        & "manyChildren" subset.eq.sq gt.eq 3 "parentOf".top
    $
    is consistent because there may be a world state in which #c[Julia] has three children, but only #c[John] is named. And infinite other implementations may exist.
]

== Other Description Logics
Fragments of DLs to achieve specific computational properties, such as:
/ $cal("ALC")$: Attribute Language with Concept negation
/ $cal("ALCJ")$: $cal("ALC")$ plus Inverses
/ $cal("ALCH")$: 𝒜ℒ𝒞 plus Hierarchy of roles
/ $cal("ALCHQ")$: 𝒜ℒ𝒞 plus Inverses, Hierarchy of roles and Qualified number restrictions
/ $cal("EL")$: Existential quantifiers and concept intersection (no unions, complements or universal quantifiers, no relations axioms)


=== Standard Reasoning Services
/ Consistency of the knowledge base: $cal("KB") cancel(models) top subset.sq.eq bot->$ no contradiction when instantiating concepts and roles.
/ Concept and role satisfiability: $cal("KB") cancel(models) C subset.eq.sq bot->$ $C$ has no empty extension
/ Concept and role subsumption: $cal("KB") models C subset.eq.sq D->$ all instances of $C$ are also instances of $D$
/ Instance checking: $cal("KB")models C(a) or cal("KB") models R(a,b)$
/ Instance retrieval: ${a|cal("KB")models C(a)}$
= OWL 2 Syntaxes
How description logics are implemented in OWL. Logics require tools to serialize the ontologies (logical expressions) and perform reasoning. *OWL is a language to serialize ontologies*.
== Differences between OWL and DL languages

#figure(image("notes/src/owl2 axioms.png"), caption: [OWL2 axioms])

OWL uses URI references as names. OWL gathers information in documents stored in RDF/XML format, including imports from other files.
- A DL concept is called class;
- DL roles is called object property, because it's defining relations between objects;
- Data properties are defined to represent attributes.
- Allows the use of RDF data types and XML schema types to the ranges of attributes.

== OWL 2 Languages

/ OWL 2 DL: 'species' based on $cal(S R O I Q)(cal(D))$ DL, which is more expressive than $cal(S H O I N)(cal(D))$ of OWL DL
/ OWL 2 EL: based on the $cal(E L)^(++)$ language, for large simple type ontologies
/ OWL 2 QL: based on the $"DL-Lite"_"R"$ language, for handling and querying large amounts of instances
/ OWL 2 RL: inspired by Description Logic Programs, for ontologies with rules and data in RDF triple format

== OWL 2 Syntaxes examples
$"FirstYearCourse" subset.eq.sq forall "isTaughtBy.Professor"$
#figure(```xml
<owl:Class rdf:about="&exOKB17;FirstYearCourse">
    <rdfs:subClassOf rdf:resource="&owl;Thing"/>
    <rdfs:subClassOf>
        <owl:Restriction>
            <owl:onProperty rdf:resource="&exOKB17;isTaughtBy"/>
            <owl:allValuesFrom rdf:resource="&exOKB17;Professor"/>
        </owl:Restriction>
    </rdfs:subClassOf>
</owl:Class>
```,caption:[RDF/XML])

#figure(```
Declaration(Class(:FirstYearCourse))
SubClassOf(:FirstYearCourse owl:Thing)
SubClassOf(:FirstYearCourse ObjectAllValuesFrom(:isTaughtBy :Professor))
```,caption:[Functional])

#figure(```
FirstYearCourse SubClassOf isTaughtBy only Professor
```,caption:[Manchester])

== Tool support (protégé)
Knowledge of the OWL terminologies is required, but not the specific OWL 2 syntaxes.
+ Define classes and their relations
+ Define object and data properties and their relations
+ Define additional axioms (for example object relation restrictions)
+ Define individuals and possible classes based on them.

= Ontology Matching

In the semantic web, resourced used in different ways must be reconciled before being used. Mismatches can occur when operating with different languages, terminologies and models.

The heterogeneity problem
/ Syntactic heterogeneity: using different ontology languages (RDF, OWL)
#a[#text(size: 9pt)[Reduced by ontology matching]][
    / Terminological heterogeneity: different terms refer to the same concept. The same term can also refer to different concepts.
    / Conceptual (semantic) heterogeneity: difference in granularity, coverage and perspective
]
/ Semiotic (pragmatic) heterogeneity: different interpretations with regards to different context

Ontology matching finds correspondences between semantically related entities of the ontologies.

#def[Correspondence][
    Given two ontologies $o$ and $o prime$, a correspondence between $o$ and $o prime$ is defined as $chevron.l "id", e , e prime, r, n chevron.r$, where
    - $"id"$ is a unique identifier of the correspondence
    - $e$ and $e prime$ are entities of $o$ and $o prime$ respectively (i.e. classes, properties, instances...)
    - $r$ is a relation
        - equivalence: $=$;
        - more general: $supset.eq.sq$;
        - more specific: $subset.eq.sq$;
        - disjointness: $bot$
        - ...
    - $n$ is a confidence measure in the range of $[0,1]$ for the correspondence between $e$ and $e prime$.
]

#def[Alignment][
    Given two ontologies $o$ and $o prime$, an alignment between $o$ and $o prime$ is a set of correspondences on $o$ and $o prime$ with some additional metadata like
    - multiplicity (`1:1`, `1:m`, `m:n`)
    - method
    - date
    - creator
]


== Terminology
/ Matching: is the process of finding relationships or correspondences between entities of different ontologies.
/ Alignment: is a set of correspondences between two or more (in case of multiple matching) ontologies. The alignment is the output of the matching process.
/ Correspondence: is the relation supposed to hold according to a particular matching algorithm or individual, between entities of different ontologies.
/ Mapping: is the oriented, or directed, version of an alignment.

#figure(image("notes/src/om appl.png"), caption: [Ontology matching applications])

== Data Integration

/ Schema matching: focuses on finding the correspondence among schema elements in two semantically correlated schemata
/ Schema mapping: describes how a source database schema relates to a target database schema
/ Record linkage: (also known as entity resolution and deduplication) identifies records that refer to the same logical entity
/ Data fusion: focuses on resolving conflicts and determining the true data values, leveraging information in heterogeneous data sources

Some data integration challenges are
- attribute values are not the same;
- structural heterogeneity
- multiplicity for entities and attributes
- multilingual and cultural differences
- matching score and threshold
- scalability issues (big datasets)

== Schema and Instance Matching

A schema is a structure of metadata that describes how data (instances) can be stored, accessed and interpreted by users and applications. A *schema matches* when two concepts or two properties are the same. *Instances match* when they refer to the same real-world entity in a given domain.

=== Categories of matching techniques

/ Element-level techniques: consider ontology entities or their instances in isolation from their relations with other entities or their instances
  - String based: matching names or descriptions of entities (Hamming distance or N-gram)
  - Linguistic based: tokenization, lemmatisation, elimination
  - Constrained based: datatype and multiplicity comparison
  - Resource based: sense-based (WordNet)
  - Levenshtein distance represents the number of insertions, deletions, and substitutions required to change one word to another.
  - Phonetic based: phonetic encoding consists in encoding homophones in the same representation so that they can be matched despite minor differences in spelling.
  - Background knowledge-based matching
/ Structure-level techniques: consider the ontology entities or their instances to compare their relations with other entities or their instances.
  - Graph-based: consider ontologies as labelled graphs, assumption: if nodes are similar then their neighbours must be similar
  - Taxonomy-based: consider only specialisation/generalization relation
  - Model-based: take into account semantic interpretation of the ontologies, assumption: if two entities are the same then they share the same interpretation
  - Instance-based: use individual representation of classes, i e., classes are considered similar if they share many instances
/ Value oriented techniques: the similarity level of two records (entities) can be derived by matching the values of their comparable attributes. #highlight[Strong focus on similarity of string attributes].

=== Classification of matching vs non-matching

When the similarity of each pair of corresponding attribute values is computed, a decision engine is needed to classify whether two entities match or not trough:
/ Learning based techniques:
/ Similarity based techniques:
/ Rule based techniques:
/ Context based techniques:

#let sp = [SPARQL]
= #sp
#sp Protocol and RDF Query Language (#sp) is an SQL like query language for RDF data. It's used to query remote databases over HTTP and has a syntax close to turtle.

At the core of #sp are triple patterns, which are RDF triples that include variables (denoted by a `?`) to match against triples in the target graph. For example, `?movie rdf:type schema:Movie` is a triple pattern.

A standard #sp query contains several structured components:
/ Prefix declarations: (optional) to create shortcuts for URIs;
/ Query results clause: (`SELECT`, `ASK`, `DESCRIBE`, or `CONSTRUCT`);
/ Dataset definition: (`FROM`), which is optional;
/ Query pattern: defined within a `WHERE { ... }` block.
/ Query modifiers: such as `GROUP BY`, `HAVING`, `ORDER BY`, `LIMIT`, `OFFSET`, and `VALUES`.

SPARQL supports four primary *types of queries*:
/ `ASK`: Evaluates whether a query pattern has any matches in the dataset. It returns a simple boolean result (`true` or `false`).
/ `CONSTRUCT`: Generates and returns a new RDF graph constructed from the matching triple patterns.
/ `DESCRIBE`: Returns an RDF graph that "describes" the specified resources. The exact interpretation of what describes a resource (e.g., concise-bounded descriptions or named graphs) is left up to the server implementation.
/ `SELECT`: Returns results as a tabular projection of variables and expressions, where each selected variable forms a column and each match forms a row.

You can use `SELECT *` to return all variables defined in the query. You can project specific variables (e.g., `SELECT ?actor`) which returns a table of just that variable, though it may contain duplicate rows. Using `SELECT DISTINCT` removes duplicate rows from the results.

== Advanced Query Keywords
SPARQL provides several keywords to refine how patterns are matched:
/ `UNION`: Combines the results of multiple graph patterns. If a match is found in either pattern, it is included in the final results.
/ `OPTIONAL`: Allows you to request additional information if it exists, without failing the entire query if it does not. If the optional data is missing, the variable simply remains "unbound".
/ `FILTER`: Applies constraints to variables, restricting the results. For example, a `FILTER` can be used to ensure a date variable falls within a specific numeric or chronological range.

==  Named Graphs
An RDF dataset is a collection of triples (a graph). By default, triples are added to a single "default graph" (also called an unnamed graph). However, subsets of triples can be separated into "named graphs", which can be serialized using formats like TriG.
When querying, every SPARQL query runs against at least the default graph, one or more named graphs, or a merged set of both.
The `FROM` clause defines the default graph for the query. If multiple `FROM` clauses are used, the specified graphs are merged, and they lose their individual named identities during the query.
The `FROM NAMED` clause specifies active named graphs to be used in the query, maintaining their named identity. To query specifically within these bounds, the `GRAPH <graph_name> { ... }` keyword must be used inside the `WHERE` clause. If `FROM NAMED` is used without a `GRAPH` block, the query targets the default graph and may return no results.
== Federated Queries
Federated queries allow you to dynamically integrate data from multiple sources by querying multiple SPARQL endpoints within a single query. This requires a "linking point," which is a common identifier shared across the multiple sources. This is achieved using the `SERVICE` clause, which directs a specific part of the query block to execute against a specified remote SPARQL endpoint, while the rest of the query can execute against the local source.
