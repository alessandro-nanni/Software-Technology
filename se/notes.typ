#import "@preview/fletcher:0.5.8" as fletcher: diagram, edge, node
#import "../mono.typ": *
#show "cobol": it => smallcaps(it)
#show: template.with(blue, red, [Software Evolution])
#show heading.where(level: 1): set heading(numbering: "Level 1")
=
== Definition
#i[Evolution is studying software that already exists.]
70% of software is maintenance. 90% of the costs of software are in maintenance. 43% of existing banking systems are built on cobol. 200B lines of code in cobol exist. Replacement costs 25\$ per line.

#def[Maintenance][
  Modification of a software project after delivery to:
  - correct faults (bug fixing)
  - improve performance (50%)
  - adapt the product to a modified environment
  - _prevent future issues_: 4% of all maintenance efforts, because you cannot plan for future issues.
]

#def[Legacy Software][
  A large#footnote[Small software can be rewritten from scratch.] and complex system that took years to build and even longer to debug. It has to be business critical#footnote[Bugs cannot be tolerated.], old and valuable.
]

If the software is not business critical, it can be retired or sold to someone else. As software evolves, it becomes harder to maintain.

== The Laws

#def[S-type programs][
  *Specifiable* software: once it's implemented and tested it's finished. This type of software does not evolve.
]
#def[P-type programs][
  *Problem solving* software: it _imperfectly_ models a real world task. The acceptance can only be qualitative: "this solution is good enough". They can evolve continuously.
]
#def[E-type programs][
  *Embedded* software: the solution is a part of the world, acceptance is subjective. Some people may accept it and some may not. They are inherently evolutionary.
]

P-types are usually solved only once. E-types can change because the world they are situated in can change.

=== Lehman's Laws
+ *Continuing Change*: an e-system *rots*#footnote[Becomes less useful] unless it's adapted. This process never stops. This is true for P-programs.
+ *Increasing Complexity*: an e-system becomes more complex as it evolves, unless we explicitly do something.
+ *Self Regulation*: an e-system is a self regulating process (SRP). It obeys certain statistical laws: trends and invariances. The distribution is close to normal
+ *The Work Rate is Invariant*: the activity of developers stay the same (conservation of organizational stability).
+ *Invariant Perceived Complexity*: the number of new features per release is statistically invariant (low of conservation of familiarity). Not overwhelm or bore the user.
+ *Continuing Growth*: the e-system must add new features overtime to keep the users satisfied.
+ *Declining Quality*: the perceived quality of the system declines for both the customers and the developer (unless constantly maintained).
+ *Feedback System*: a developed system evolves trough a feedback system. It can be multi-level, multi-loop or multi-agent.

== Challenges

=== Cyber Physical Systems
(CPS): a view on a software system where you go beyond it just being software. It's a *feedback system* with a lot of agents that don't work on one machine, there are delays. It can be adaptive and predictive. The agents can be intelligent (human or AI). Feedback systems often work in real time, so there is a definition of time, urgency and concern on where data will be at a certain time. *Humans* are also involved. There are ecosystems, communities, individuals. Human behavior is hard to model and to express. The *context* is also in the loop: consider energy consumption, carbon *footprint*, water usage and sustainability driven solutions.
The costs must also be considered.

=== Bit Flips
Especially for software that is running in space.

=== Consistency
Consistency means having no contradictions.
- Structural consistency: conform to the metamodels
- Behavioral consistency: consistent with expected behavior
- Conditional consistency
- Trace/perfect equivalence
- Inner Consistency: the artefact doesn't contradict itself
- Outer Consistency: the contract between two or more artifacts must not be broken.
Some form of (in)consistency management is required. I.e. compute and sync views on models in model driven software engineering, maintaining GUIs in MVC, syncing data in different formats, updatable views in DBMS, (de)serialization...

=== Quality
Goal-question-metric. Ask questions to achieve goals. Then on the quantitative level find some piece of data that can be used to find answer.

=== Adaptability
The ability of a system to adapt itself when it changes. Adaptation is critical for survival of the software and to improve it's quality. Types of adaptation:
/ Parametric: tweak parameters over time:
/ Algorithmic: choose the most appropriate algorithm:
/ Resource: reallocate utilized resources.
Adaptable Software Factors:
/ Extensibility: how easy it is to change the _amount_ of capabilities;
/ Flexibility: how easy it is to change the _kind_ of capabilities;
/ Tunability: how easy is it to _tweak_.
/ Fixability: if we encounter _one_ problem, how easy it is to fix it without affecting other things.
Adaptation can be possible *trough tolerance* by preserving the original behavior when a new change comes from the environment or *trough adjustment* by making unchanged artifacts sync when welcome changes occur.

=
== Elements of Software Evolution
=== Software Engineering Lifecycle
*Phases*:
- *R*\equirements
- *D*\esign/architecture
- *C*\onstruction/implementation
- *T*\esting/integration
- *O*\perations/deployment: connecting the stakeholders to the built system.
- *M*\aintenance
No longer phases, due to AGILE development (the happen weekly/biweekly in sprints).

=== Requirements #sym.arrow Requirements Creep
The most significant risk in SE. Environment changes unexpectedly, so the requirements change. This can make a system useless or allow to pursue new opportunities.\ The amount of errors introduced in Requirements & Design grew from 40% in 1984 to 70% in 2002. Rework cost is 300$times$.\
It is common for requirements to change.
/ Stable/Enduring requirements: technical core of business.
/ Changing requirements:
  - Mutable: the market has changed, it is possible to improve the system or cutoff unused features.
  - Emergent: occur when stakeholders are involved in requirement elicitation.
  - Consequential: directly caused by delivery#footnote[From Lehman's 7th law: the perceived value of the system decreases when no changes are made.], more features are demanded.
  - Adaptive: variation in the tasks, more things to do than expected
  - Migration: move from one piece of hardware to another, or from one database to another. Some requirements can be retired after the migration.

=== Design #sym.arrow Model Management
#merge[Models are used to manage complexity][they are used in complex projects][they become complex][they need to change/evolve][they need to be managed].\
Types of model management:
- Quality check: slight improvement
- Transform with intent
- Version control: merge changes in one version.
#def[Model][A model is a simplified representation of a part of the world from a particular view.]

A *model change* can be triggered by:
- world changes #sym.arrow the model becomes incorrect;
- when more data becomes available, the model incorrectly represents reality/becomes uncertain.
- the needs for the model change: and it must adapt to fit the new view
- the focus widens, and the model becomes too detailed
- the focus narrows, and the model becomes too abstract
- a bad representation

=== Construction #sym.arrow Evolution of Code
/ Refactoring: changing the code without changing it's behavior. _Correctness must be guaranteed_ by the tool used, testing or proofs.\
/ Restructuring: change the behavior, but _maintain some form of structure_.\
/ Reengeneeing: happens on the design level. What design pattern should be used, what should the level of visibility be...?\
/ Rearchitecting: can be based on rewriting or reengeneeing. It means recovering the architectural models while disregarding the implementation.
=== Testing #sym.arrow Test Code Smells
Badly written tests:
/ Mystery Guest: test is not self contained;
/ Resource Optimism: wrong optimistic assumptions;
/ Test Run War: two test pass independently, but fail when run together;
/ General Fixture: test classes contain broad functionality in their setup;
/ Eager Test: tests multiple things at the same time;
/ Lazy Test: test for things in the same equivalence class;
/ Assertion Roulette: assertion with multiple big conditions;
/ Indirect Testing: mismatch between class and test class;
=== Operation #sym.arrow Runtime Evolution
- Customization/Personalization of the program while it's running.
- Resource discovery
- Hotswap plugins
- Late binding
=== Maintenance #sym.arrow Data Migration
Data migration occurs because:
- the database version upgrades
- the existing setup is insufficient
- company policy changes
- cutbacks

== Emergent Language Design
How languages evolve trough time.
+ Human computes, machine helps
+ Machine computes, program dictates steps
+ Machine computes, program prescribes tasks
+ Machine runs tasks, program instructs
+ Machine runs tasks, instructions grouped into functions, program calls functions
+ ... functions from a machine, which computes

== Coupled Software Evolution
When two artifacts are consistent, if one of them evolves, the other one *co*\evolves (coupled evolution).

=== Coupled Evolution Examples
/ Cooperative Editing: the changes must sync and be distributed. I.e. shared Google doc.;
/ Source code and runnables: one way consistency: the executable artefact is destroyed and recreated from the source code;
/ Consistency management in software modelling: how to keep the diagrams and models in sync to make them provide a consistent view of the system;
/ Co-evolution of design & implementation:
/ View-update translation: only part of a thing is visible for security reasons. It should be possible to propagate the change from the view to the data source.
/ Structural/projectional editing:
/ Negotiated program transformations:

=== Patterns

*No reconciliation*: $g$ is a transformation that doesn't endanger the consistency.
#figure(diagram(node-stroke: 1pt, node-corner-radius: 8pt, {
  node((0, 0), [$a:A$])
  node((0, 2), [$a prime : A$])
  node((3, 0), [$b:B$])
  edge((0, 0), (0, 2), [$g$], label-side: left, "->")
  edge((0, 2), (3, 0), "<|--|>")
  edge((0, 0), (3, 0), "<|--|>")
}))

*Trivial Reconciliation*: $b$ is discarded, $b prime$ is generated from scratch.
#figure(diagram(node-stroke: 1pt, node-corner-radius: 8pt, {
  node((-2, -1), [$a:A$])
  node((2, -1), [$b:B$])
  node((-2, 1), [$a prime : A$])
  node((2, 1), [$b prime : B$])
  edge((-2, -1), (-2, 1), [$g$], label-side: left, "->")
  edge((-2, -1), (2, -1), "<|--|>")
  edge((-2, 1), (2, 1), "<|--|>")
  edge((-2, -1), (2, -1), "-|>", bend: -30deg)
  edge((-2, 1), (2, 1), [$t:A-> B$], label-side: left, "-|>", bend: 30deg)
}))

*Symmetric Reconciliation*: occurs when a transformation means something conceptually, and the transformation is two functions together.

*Asymmetric Reconciliation*: a transformation can be reapplied to a newly created diagram.

#i[Evolution is not always triggered from the outside, with coevolution it is triggered within the code.]

== Software Product Portfolios
A product family/line is a group of products advertised with the same methods, but have different consumers.

*Domain engineering*: what are the building blocks that can be used later to put together an application.\ 
*Application engineering*: make a model out of the requirements, which is conformed to the variability model.  
=== Software Product Line Evolution
+ Specifics: 
  - Longer Life Span
  - Bigger size and complexity
  - More interdependencies
+ Assets: 
  / Common: present everywhere
  / Variable: configuration dependant 
  / Specific: only for a particular product
+ Adding products
=== Variability Models #sym.arrow Feature Model
#def[Feature][A feature is a distinguishable characteristic of a concept relevant to some stakeholder(s).]
It's usually drawn as a tree with or/xor-groups, requires or excludes.

#i[Domain engineering and application engineering are separated.]

=

== Software Quality Models

Code quality can refer to:
/ Quality in use: bugs that manifest;
/ External quality: that can be benchmarked;
/ Internal quality: the code is examined, not ran;
/ Process quality: the process that was followed in order to create the code. i.e. AGILE.


Process quality models: the way software is handled.\
Product quality models: how good a software system is.

=== SQuaRE (Product)
_Software and systems Quality Requirements and Evaluation_
/ Suitability: functional requirements: completeness, correctness, appropriateness.
/ Efficiency: time behavior, resource utilization, capacity.
/ Compatibility: co-existence of pieces or systems of software, interoperability.
/ Usability: how easy it is to learn and use the system, how does it look, how accessible is it.
/ Reliability: availability and maturity of the system, it's fault tolerance and recoverability.
/ Security: who is accountable when something bad happens, is the person that is using the software who they say they are
/ Maintainability: the ability to do something with the system.
/ Portability: can you do something at runtime to adapt to changes in the environment.

=== CMMI (Process)
_Capability Maturity Model Integration_: level of maturity available in a project or organization.
/ Level 1: Initial: unpredictable, reactive, poorly controllable.
/ Level 2: Managed: reactive, project specific.
/ Level 3: Defined: proactive, organization specific and tailored processes.
/ Level 4: Measured: measured, controlled, quantitatively managed.
/ Level 5: Optimizing: improving with experiments.

== Technical Debt

#merge[Poor code in the codebase][task based on it takes longer][system doesn't evolve timely][business suffers, company makes less money][less money for developers][developers become overstressed].

Technical debt is a process that happens when you try to take time from your future self.\
With self admitted technical debt you admit to borrowing time from someone else. Studies found no correlation with internal quality. 

=== Backlog

#i[The backlog is composed of things you know should be doing very soon or should have done already.]

#figure(table(columns: 3)[][Visible][Invisible][*Positive*][Feature][Architecture][*Negative*][Bug][Debt])

Debt makes actions less efficient, if removed no user will notice, only the developers.

Every corner of this table has a different stakeholder:
/ Developers: want to improve the architecture
/ Managers: want to see more features
/ User: complains about bugs
/ No one: is stakeholder of the technical debt, no one wants to tackle the debt.

#figure(table(columns: 3)[][Reckless][Careful][*Deliberate*][_We don't have time for design!_][_We can ship now and clean up later._][*Accidental*][There is a lack of knowledge or expertise][_Now we know what not to do next time_#footnote[Learn from a previous experience.]],caption: [Technical Debt Quadrant])

#figure(table(columns: 3)[][Evolution][Maintainability][*Visible*][Improve functionality][Improve quality][*Invisible*][Architecture][Code smells],caption: [Technical Debt Landscape])

== Software Metrics

#i[Measurement is quantitatively expressed reduction of uncertainty based on one or more observations.]

/ Direct quantification: measurement;
/ Indirect quantification: calculation.

Without measurements there would be no requirements. All software would be reliable or user friendly. The component (design, code, test) costs would be fused. There would be no business promises#footnote[i.e. how fast or reliable a system is.].

Metrics are based on abstractions (models).

=== Evolution of Measurements
With scale you can compare previous results, quantitative not qualitative comparisons. A scale should be physically defined.

Measurement is a *mapping*. Empirical relations must be preserved under the mapping done by the measurement. If A is hotter than B, B can't measure 50#sym.degree\C and A 10#sym.degree\C.

=== Scales
Scales define what you are allowed to do with your measurements.
/ Nominal: classification with no order#footnote[i.e. S, P, E systems].
/ Ordinal: different classes and rankings, ordering is possible but no other operations.
/ Interval: explicit ordering and differences. Addition and subtraction work, but not multiplication.
/ Ratio: ordering, difference, ratios. Can be measured in intervals.
/ Absolute: number of actual occurrences of something in a real world entity, the observed reality.


=== Maintainability with mixed paradigms
The paradigms are kept apart and interleaved locally. The focus is not on how much mix there is, but how the mixture is arranged.

A metric is how many times the paradigm changes (switch count). Stretch: how long did the code stay in a certain paradigm.

Mixed paradigm fragmentation can be considered a code smell.


== Code Review
_Statistically, the best way to fix bugs._

It forces you to share a mental model with another person. It also helps to:
- Catch bugs
- Improve code quality
- Share knowledge
- Enforce standards
- Improve estimates of how hard it is to implement something
- Mentor new engineers
- Build a better team

=== Types of Code Review
/ Tool assisted: agents & linters.
/ Instant: pair programming.
/ Synchronous: over the shoulder: work on it first, ask for feedback later.
/ Asynchronous: lightweight.
/ Team review: hour of code.
/ Formal review: artefact evaluation.

=== Elements
- Clear and shared objectives.
- Defined and followed process.
- Constructive and actionable feedback. Descriptive feedback: share your comprehension process.   


= 
 
== Legacy Languages
/ 1GL: First generation languages, basically machine code;
/ 2GL: Assembly languages, 1-1 mapped to machine code but with names to refer to bytes and registers.
/ 3GL: Most languages, from Cobol to C++ and Java.
/ 4GL: Focus on efficiency, expressivity. 3GL code was used to patch leaky abstractions.
/ DSL: the opposite of a general purpose language (GPL). Abstractions targeted to a problem domain, the opposite to a library. They are 4GL languages.

=== Advantages of a DSL
+ Domain specific notations and abstractions, to facilitate reuse in a specific solution domain.
+ Tool support.
+ Conciseness, self-documentation
+ Reliability, portability, testability
+ Designed lifespan
+ Configurable per costumer

== Refactoring
#def[Refactoring][
  - _I'm refactoring my code because..._ I'm collapsing the hierarchy, extracting methods, moving code from one field to another...#footnote[Stick to one type of refactoring.]
  - Automated code change supported by your IDE
  - Changing the internals without changing the externals (behavior)
]

A refactoring that breaks code isn't real refactoring.

=== Refactoring Best Practices
+ Remove dead code (code that is never ran)
+ Extract function/method
+ Combine functions into class
+ Replace loop with pipeline (steams, maps)
+ Collapse hierarchy
+ Inline variable
+ Move a field (inappropriate intimacy)
+ Before refactoring, ensure you have a solid suite of tests
+ Since refactoring changes things in small steps, its easy to find where the bug is.
+ First you refactor the program to make it easy to add the feature, then add the feature
+ If code breaks when doing refactoring, then you're not doing refactoring
+ Refactoring is not limited to code, can also be applied to grammars, data...

Not always IDE related, sometimes language dependant.

== Software renovation
=== Realities of working with legacy software
- Source code may be lost, or only bytecode is available
- Documentation is not available or outdated
- Old technology was extended _ad hoc_
- Don't know why it works
- Language or notation mixture and interoperability
- The design has been decided beforehand, no choice but to implement it like this
- Painful choices // ?

=== Legacy System Renovation Paths

*Path 1: Rewrite* -  _Why don't we just rewrite it?_\
/ Question: If something took 30 years to build, how long would it take to rebuild it?
/ Pro: Software engineering is more efficient now than 30 years algorithm
/ Cons: you are still biased to the technology you're using, you need to invest in reverse engineering first. Tools to verify the same functionality are required.
/ Thus: It's possible if flexibility is tolerable or in specific project parts.

*Path 2: Refactor*\
Massive refactoring is possible: GO TO elimination, objectification, wrapping.
/ Pro: possible to automate, can use transformation languages
/ Con: you are still using the same tech
/ Thus: often feasible, sometimes satisfactory.

*Path 3: Dethrone*\
Generate a 3GL from a 4GL for the last time, then you refactor it and improve it. This way you remove the 4GL.
/ Pros: full automation, retires a language, represents semantics
/ Cons: per language approach, hard to generalize across multiple 4GLs.

*Path 4: Migration*\
Restructure the original program so that it's ready for a syntax swap. Only then you restructure the target program to use it's features. You change the language while keeping the logic.
/ Pro: sounds perfect
/ Cons: must restructure the original and target, syntax swap must be feasible, native constructs map to simulated ones.
/ Thus: it's feasible under very specific circumstances.

*Path 5: Upgrade*\
Keep the language, but you change the platform/ecosystem where it operates.
/ Pros: no change to the code, executes in a new environment, empowers later change
/ Cons: technological dependencies remain, it's harder to develop solutions.
/ Thus: can build a business.

*Path 6: Reinvent*\
Take the language and re-develop the compiler (cover a language's subset).
/ Pros: code mostly stays the same, get modern development and execution environments, full control over the target environment.
/ Cons: documentation may not exist, substantial effort
/ Thus: perfect for a combination of rich client and expert migrator company

