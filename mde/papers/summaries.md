# Paper summaries

Full-text conversions are next to each PDF (`*.txt`). Tables and pseudo-code in the BPMN paper came out of the PDF garbled, so check the PDF for Table 1, Table 4 and Algorithms 1–2.

---

## 1. Transforming BPMN Processes to SBVR Process Rules with Deontic Modalities

*Skersys, Danenas, Mickeviciute, Butleris. Applied Sciences 12(18), 8976, 2022.*

**Problem.** BPMN (process models) and SBVR (Semantics of Business Vocabulary and Business Rules, which uses controlled natural language) are both OMG standards, but neither refers to the other. Business people still prefer reading text over diagrams. The authors want every BPMN process to have an unambiguous natural-language equivalent that is consistent with the business vocabulary of the same domain.

**Key concepts.**
- A *behavioral business rule* in SBVR says what is **obligatory**, **permitted** or **prohibited** (deontic modalities).
- A *process rule* is a behavioral rule that constrains the flow of work, meaning the order and timing of activities. Example: *"It is obligatory that manager registers order after order is received."*
- SBVR is not expressive enough to represent BPMN on its own. Instead of **extending the SBVR metamodel**, the authors **import an extra SBVR vocabulary that describes BPMN concepts**. Changing the metamodel would mean re-applying the change whenever the standard is updated, being "closed in your own sandbox", and getting worse tool support.

**Approach.**
- The transformation runs in two stages. Stage 1 (earlier work) extracts the business vocabulary: noun concepts and verb concepts. Stage 2 (this paper) builds rules on top of that vocabulary. This follows the idea that "rules are built on facts, facts are built on terms". A business analyst then validates the result.
- The authors classify the transformation as deterministic, **hybrid** (part declarative, part imperative), **exogenous, horizontal, one-to-one**.
- There are **9 transformation rules** `Ti : PPi → RPi`. Each maps a BPMN *process pattern* (a diagram fragment) to an SBVR *rule pattern* written in EBNF:
  - T1, sequence flow: *obligatory … after …*
  - T2, exclusive gateway: a branch with a condition gives an *obligatory … and if \<cond\>* rule, a branch without a condition gives a *permitted* rule, and converging flows are joined with **or**
  - T3, inclusive gateway: every branch is *obligatory*, and converging flows are joined with **and**
  - T4, event-based gateway: *permitted*
  - T5, parallel gateway: *obligatory*, joined with **and**
  - T6, boundary events: *permitted … when …*. An interrupting event also produces a **prohibition**.
  - T7 and T8, data objects and data stores: an output gives *obligatory … is produced when …*, an input gives *permitted … only if … is provided*
  - T9, message flows between pools (black-box or white-box). The modality depends on the node type: a *send-message task* gives an obligation, a *manual task* gives a permission.
- **Cascading gateways** (a gateway feeding directly into another gateway) are handled by a backward-chaining recursive algorithm. It uses *activity-node neighbourhood* and *gateway-neighbourhood* tuples, starts from a "boundary gateway", builds partial rules, and turns default flows into `OTHERWISE`.
- Only a subset of BPMN is covered: pools/lanes, start/intermediate/end/boundary events, activities, the four gateway types, data objects/stores, messages/message flows, and (conditional) sequence flows. The complex gateway is excluded.

**Implementation.** The tool is a **MagicDraw** plug-in. SBVR is supported through a **UML profile for SBVR**, with "fact diagrams" as the graphical view and the VeTIS editor for textual SBVR. The transformation rules are written in **QVT** and run as both **M2M** (producing an SBVR model) and **M2T** (producing text for VeTIS). The authors rate it TRL 4.

**Evaluation.** The authors took 32 BPMN models from the internet, refactored some of them by hand (naming, missing lanes), and imported them into MagicDraw. The authors extracted rules manually and independently, which gave three result sets, and then agreed on one benchmark set. The automatic output **fully matched the benchmark** and covered the whole flow of every model.

**Limitations / threats.** The source models must:
- use pools/lanes, which become the rule subjects
- name every element
- write the full condition on each outgoing sequence flow, not a question on the gateway with yes/no answers on the branches

The sample is small and was chosen by hand, and there is no shared naming convention across sources.

**Future work.** Planned next steps are NLP support, merging the process vocabulary with the business vocabulary, and the reverse transformation (SBVR rules → BPMN).

---

## 2. Domain-Driven Architecture Modeling and Rapid Prototyping with Context Mapper

*Kapferer, Zimmermann. MODELSWARD 2020, CCIS 1361, pp. 250–272, Springer 2021.*

**Problem.** Splitting a system into well-sized (micro)services is hard. Strategic Domain-Driven Design (DDD) patterns help, but they are interpreted ambiguously. The paper tests two hypotheses:
1. Designers benefit from a **precise interpretation** of the strategic DDD patterns.
2. Designers benefit from a **tool that models them rigorously** and can **transform and evolve** the models iteratively.

**DDD essentials (as interpreted in the paper).**
- **Subdomains** come in three kinds: *core*, *supporting* and *generic*.
- A **Bounded Context** is an explicit boundary around one domain model. It contains **Aggregates**, which group Entities, Value Objects and Services.
- The **Context Map** relates Bounded Contexts:
  - symmetric relationships: *Partnership*, *Shared Kernel*
  - asymmetric relationships: *upstream/downstream*, with *Customer/Supplier* as a special case
- Roles on each side of an upstream/downstream relationship: the upstream offers an *Open Host Service* (OHS) and/or a *Published Language* (PL), while the downstream applies an *Anticorruption Layer* (ACL) or is a *Conformist* (CF).
- The authors express all of this as a **metamodel** (a UML class diagram) plus **semantic rules** that say which pattern combinations are allowed. The rules are implemented as validators.
- A context type (FAST) gives architectural viewpoints, mapped to the 4+1 view model and to C4:
  - *Feature*: the scenario view
  - *Application*: the logical/development view
  - *System*: the physical/process view; C4 containers
  - *Team*: Conway's law

**Context Mapper DSL (CML).** CML is a textual DSL built with **Xtext**, and its models are **EMF** models. It has syntax for:
- `Domain` / `Subdomain`
- `BoundedContext X implements Y`, with Aggregates (tactical DDD syntax borrowed from Sculptor)
- a `ContextMap`, with relationships written like `A [U,OHS,PL]->[D,CF] B`, `[P]<->[P]`, `[SK]<->[SK]` or `[C,ACL]<-[S,PL]`

The new contribution in this paper is **requirements in the DSL**:
- `UserStory`, using the Connextra *As a … I want to … so that …* template, extended with *with its* (attributes) and *for a* (references)
- `UseCase`, in Cockburn's brief format: actor, interactions, benefit, scope, level

**Rapid-prototyping transformation chain** (shown on Cockburn's *"Get paid for car accident"* use case):
1. **Use cases / stories → Subdomain.** Nouns become Entities with attributes and references, and verbs become Service operations. The user chooses which use cases go into one subdomain.
2. **Subdomains → Bounded Context of type *Feature*.** Each subdomain becomes an Aggregate. The step adds IDs, parameter and return types, and `TODO` hints for the modeler. The user picks which subdomains are merged.
3. **Feature/Application context → two *System* contexts**, a frontend and a backend (e.g. Angular and Spring Boot). It also creates a context map: `Backend [PL]->[CF] Frontend` over RESTful HTTP.
4. **Steps 4 to N:** "split system context into subsystems", e.g. a domain-logic tier and a database tier.

There are also **Architectural Refactorings** (split or merge contexts and aggregates, extract contexts). JHipster can then generate one microservice per Bounded Context.

**Validation.** The authors followed Shaw's research guidelines and used prototyping, action research and case studies: Lakeside Mutual, DDD Cargo Tracking, a healthcare project, and a document-management system. They also ran a workshop with 5 architects and an exercise with about 20 students, and have published 50 releases. The tool was judged **useful for teaching and early project stages**, but it should **not replace business analysis** or talking to users. Round-tripping and keeping manual and generated steps in sync were seen as critical.

**Pros / cons.**
- Pros: the language follows the DDD patterns faithfully, makes iterative context mapping faster, and can produce visualizations at several levels of abstraction.
- Cons: the **model-code gap** (generated code drifts from the model), the cost of building IDE support, and tension with the agile value of "working software over documentation".

**Future work.** Planned work includes reverse engineering from code to close the gap, and automatic decomposition suggestions in the style of Service Cutter.

---

## 3. A Use Case Driven Approach to Game Modeling

*Albaghajati, Hassine. Requirements Engineering 27:83–116, Springer 2022.*

**Problem.** Game teams mix people from different backgrounds: game designers, artists, level designers and programmers. Communication between them is one of the industry's top problems. Game designers say models are hard to learn and restrict creativity. Earlier game-modeling approaches have three weaknesses:
- they are too technical (class, state or sequence diagrams)
- they combine too many diagram types
- they target one niche (serious or educational games)

**Approach: extend the UML 2.5.1 use-case metamodel.**
- The extension adds new metaclasses **`GameUseCase`** and **`GameActor`**, each with a type enumeration:
  - `GameUseCaseType`: **Function, LoadScene, PlayAnimation, PlayAudio, CreateObject**. These are shown as stereotypes (`«Function»` …) with an icon on the oval.
  - `GameActorType`: **User** (stick figure), **PlayerCharacter** (stick figure + joystick), **NonPlayerCharacter** (stick figure + computer).
- **Subject placement:** *User* actors stay outside the system boundary. Player and non-player characters go **inside**, because they are part of the game (treated like software agents).
- There are **no new relationships**. The standard `include` and `extend` are used, and extension points carry the triggering condition.
- Each actor and use case has a **textual template**: name, description, type, actors, priority (1–5), an artistic **sketch**, pre- and post-conditions, included and extending use cases, and the flow of events. Pre- and post-conditions are **deliberately not in OCL**, to keep the learning curve low.
- **Well-formedness rules:**
  - **11 strict rules**, enforced by the tool. Examples: an actor is linked to at least one use case; names are unique; a use case cannot both include and extend the same use case; no self-include or self-extend; one extension point per extend; correct placement inside or outside the boundary.
  - **5 soft rules**, which only produce warnings. Examples: *User* actors only take part in non-gameplay use cases; `LoadScene` is never *included*; `PlayAnimation` and `LoadScene` include nothing; `LoadScene` may only extend `Function` or `PlayAnimation`; nothing extends `PlayAudio` or `CreateObject` with a `LoadScene`.

**Tool: GUCM.** GUCM is a web tool built in **Unity/C#** (74 classes, about 9k lines of code). It offers a palette-based editor, the textual descriptions, sketch upload, an error dialog for strict rules, warnings for soft rules, saving to JSON, and export to PNG.

**Examples.** The approach is applied to *Super Mario Bros*, *Tetris*, *Just Dance* and *The Walking Dead*, which are four different genres. In the Mario model, for example, `Jump` includes `Play jump animation`, `Die` is extended by `Load current level` or `Load main scene` depending on the `has health` extension point, and the fireball is a non-player character created by a `CreateObject` use case.

**Evaluation.** An online survey on Twitter (#gamedev, #indiedev) collected **29 respondents**, mostly programmers. 55% said they had faced problems communicating requirements.

| What was rated | Agreed |
| --- | --- |
| Easy to understand | 72% |
| Graphical elements are self-descriptive | 83% |
| Textual descriptions help | 79% |
| Quick to learn | 79% |
| Useful for team effectiveness, communication and productivity | about 76–80% |

Mann–Whitney U tests found:
- a **significant difference** between people with and without prior modeling experience; the approach appealed *more* to those without. For learnability the difference was borderline (p = 0.05).
- **no difference** between people who had used UML use-case diagrams and people who had used other diagrams

**Threats.** Answers are self-assessed on closed questions, the sample is small, the introduction given to respondents was short, use-case diagrams scale poorly, and the metamodel may miss some game aspects.

**Future work.** Planned work includes a coloring scheme and a controlled experiment. Survey suggestions included deriving test scenarios from the textual use cases, reusable templates for common mechanics, and plugging the models into an MBD pipeline with transformations and code generation.
