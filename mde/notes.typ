#import "../mono.typ": *
#show: template.with(blue, red, [Model Driven Engineering])

= Introduction
== Why model driven engineering
In the 90's #sym.arrow software was becoming expensive to build, even harder to maintain, failed to meet planned targets. 
How do you cope with different business requirements, changing personnel and changing technologies? High impact on software systems. There is a need to port software to new technologies. Business logic and functionality are too intertwined.

Since requirements and technologies change, you can decouple them (using technology agnostic models). Models are stable assets (business models) and then you use a strategy to generate the technological aspects (the implementation).

== Model Driven Architecture
Model engineers would define the models, and developers would ignore them and implement the functionality however they wanted (model burning party). There was no way to generate the implementation from the model.

The OMG#footnote[Object Management Group] proposed model driven architecture. They eventually even supported UML (from version 1.3).

#def[Model Driven Architecture][An approach to IT system specification that separates the specification of functionality from the specification of the implementation of that functionality on a specific *platform*.]

#i[Separate functionality from implementation.]

Initially java code was generated from class diagrams, it was seen as a sophisticated way to use UML. But it's also a well founded model support, and it increases the *level of abstraction*.

The idea of MDA was to have models that went beyond the implementation. Models are specified at a higher abstraction level than implementation logic. The implementation(s) are then obtained from models via model transformations. This way, when a new technology is adopted, you just re-implement the transformation. This works well if there are different instances of a system being generated.

== Model 
#def[Model][A model is a formal specification of the function, structure and/or behavior of an application or system.

A model is information selectively representing some aspect of a system
based on a specific set of concerns (current OMG definition)

A model is an abstraction (also called representation or denotation) of an
object system (also called system under study) expressed in some
language. An interpretation of a model gives the meaning of the model
relative to the object system.
]

*Typical MDA-Based development*
+ Computation independent business model: concerns the business aspects independently of automated support.
+ Platform independent model: concerns the application independently of the specific platform
+ Platform specific model: concerns the application and is targeted to a specific platform
+ Programming language specific code: code written in a specific programming language.

#def[Platform][A set of subsystems/technologies that provide a coherent set of
functionality through interfaces and specified usage patterns that any
subsystem that depends on the platform can use without concern for the
details of how the functionality provided by the platform is implemented‘
(old definition)]

Trough a platform independent models, you have application architectural stability.

== Metamodels
Four layer meta-modelling architecture:\
#merge[M0: System (real world)][M1: model (UML model)][M2: Model of a model (UML metamodel)][M3: Model of a model of a model (MOF)]

(You can use UML to specify UML itself)

#def[Model Transformation][The process of converting one model (source model) to another model (target model) of the same system (OMG, MDA guide). ]

For example, UML to Java. 

Still, MDA was not a methodology. It was a collection of viewpoints. Any practical use of MDA requires the adoption of a development process. 

- MDD is a development paradigm with models as primary artifact
- MDA is an MDD approach based on OMG standards
- MDE goes beyond development, including other engineering tasks
- MBE is more relaxed with respect to the role of models (not necessarily primary artifacts)
- MDSE is about MDE for Software Systems

== Model Driven Engineering

MDE is an engineering approach in which models are the primary artifacts. Beyond development, involving engineering tasks like model and system evolution, reverse engineering,...


MDE should be used to 
- raise the level of abstraction via modelling
  - helps manage complexity
- model languages intended for the domain experts, not for developers
  - better communication between problem domain experts solution domain experts.
- Rigorous techniques for reasoning on models
  - Increase system quality
- Better automation via model transformations
  - Improve the productivity and time to market.
- Mature engineering disciplines employ strong modelling techniques

Modern MDE applications are:
- Digital Threads: collection of system models related to each other.
- Low Code Programming is supported under the hood by DSLs and code generation.

= Models and Metamodels
#def[Model][A model is purposely abstracted, clear. precise and unambiguous *conception*.

A model *denotation* is a precise and unambiguous representation of a model, in some appropriate formal or semi-formal language.

A model is a *representation of a concept*. The representation is purposeful: the model purpose is used to abstract from the reality the irrelevant details.]

== General Characteristics of Models
- They represent something in the real world (some system)
- Simplification (abstraction)
- Conception *and* concrete representation
- Purpose: often descriptive, prescriptive or predictive
- Desired qualities: precise, unambiguous, allows analysis

A model requires a part of the real world that is modelled (a system being modelled, `modelOf` relation). A model can be seen as a role or may be the subject of modelling (model of a model).

Abstraction is a powerful tool for mastering complexity. In models, some of the characteristics are ignored (abstracted from)

=== Nature of the `modelOf` relation.
-Denotation: some of the properties of the system are represented or denoted in the model.
- Demonstration: knowledge is obtained from the model in the terms of the model elements.
- Interpretation: the obtained knowledge is translated in terms of the system.

=== Working definition of model
A model:
- represents a part of the reality called the object system;
- is expressed in a modelling language;
- provides knowledge for a certain purpose.

This knowledge can be interpreted in terms of the object system

=== Purpose of models
+ Sketches: used for communication, often partial/incomplete views of the object system.
+ Blueprints: used to provide detailed and complete specification as prescription of what should be built.
+ Programs: used to develop the system, as opposed to code

=== Software Systems as Models
A running software system can be considered a model of a system (in OOP). However, it may interact and change the real world (they *control* it).

=== Software Artifacts as Models
The original OMG definition is too general

== Metamodel 
#def[Metamodel][A metamodel is a model of a model.]

Metamodel as a model of a modelling language. A meta model is a model of models expressed in a given modelling language.

In MDE, the view that a metamodel represents a modelling language is widely accepted. We assume that a metamodel is a model of a modelling language.

== Definition of a Metamodel
Language is a set of sentences (models). A metamodel models the valid members of the set. A metamodel constrains the valid models expressible in a given modelling language.

Language has concrete syntax, abstract syntax and semantics. A metamodel should focus on the concepts that can be expressed with the language and their relationships. It very roughly corresponds to the language's abstract syntax#footnote[Syntax elements without considering how they are represented].

A metamodel is a model of a model. Different characteristics of a model can in principle be chosen to be modelled in a metamodel.
What are the concepts that can be used to define the model, and how are these related between each other.

In MDE, meta-modelling considers the types of the model elements and consequently the abstract syntax of the modelling language as the characteristic represented in the metamodel!

A model is an instance of a meta-model, because it can only use elements defined by the meta model? 

There are different (language-specific) `instanceOf` relations. It allows to interpret a metamodel formally (systematically). 

== Metalevels
Hierarchy of metamodels, can be infinite ($cal(L)$). In practice, we stop at level 3. There are two ways to stop the recursive tower.
+ Assume that some language is just given (i.e. XML)
+ Model the top language in itself (most popular)#footnote[For example, you use UML to specify UML.].

#merge[Real world][Model][Metamodel][Metametamodel]

== Meta Object Facility
Metadata management framework, data about data. The idea was to have a language to define new languages. UML metamodel is defined via MOF. MOF 2.0 is a subset of UML 2.0. The idea was to use UML tools to express a metamodel.

Ecore is used in Eclipse, and is compatible with MOF 1.x, and allows EMOF metamodels to be imported via XMI. Ecore is a metamodelling language. You can specify classes of objects, its attributes, relationships and operations, simple constraints (essentially a subset of the UML class diagram).

