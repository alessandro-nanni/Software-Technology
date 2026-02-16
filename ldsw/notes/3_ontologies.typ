#import "_ldsw.typ": *
#show: template
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
