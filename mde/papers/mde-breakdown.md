# MDE breakdown of the three papers

For each paper: the context, the goal, the languages and metamodels, the transformation stack, the levels (meta-levels, MDA levels, abstraction), the tooling, and the main critical points. Page numbers are the ones printed in each paper.

See also [summaries.md](summaries.md) (content), [connections.md](connections.md) (links to the course notes, with code sketches) and [exam-prep.md](exam-prep.md) (likely questions).

---

## At a glance

| | BPMN → SBVR | Context Mapper | Game use cases |
|---|---|---|---|
| **Goal** | Generate natural-language process rules from process diagrams | Model DDD architectures precisely and prototype them from requirements | Give game teams a simple shared requirements notation |
| **Source language** | BPMN 2.0 | CML (use cases / user stories) | — |
| **Target language** | SBVR (vocabulary + rules), SBVR text | CML (subdomains, bounded contexts), then code | — |
| **Metamodel work** | None new; imports a BPMN *vocabulary* into SBVR | Own DDD metamodel + Xtext grammar | UML use-case metamodel + 2 metaclasses + 2 enums |
| **Transformations** | M2M + M2T in QVT | Chain of M2M steps + refactorings + code generation | None |
| **Exo / endo** | Exogenous | Endogenous | — |
| **Horizontal / vertical** | Horizontal | Vertical (chain), horizontal (refactorings) | — |
| **MDA level** | CIM → CIM | CIM → PIM → PSM → code | CIM only |
| **M3** | MOF | Ecore | MOF |
| **Tool** | MagicDraw plug-ins | Eclipse / VS Code (Xtext, EMF) | GUCM (Unity/C#, web) |
| **Evaluation** | 32 models vs a hand-made benchmark | Case studies, workshop, students | 4 example games, survey of 29 |

---

## 1. Transforming BPMN Processes to SBVR Process Rules with Deontic Modalities

*Skersys, Danenas, Mickeviciute, Butleris. Applied Sciences 12(18), 8976, 2022.*

### Context
- BPMN (process diagrams) and SBVR (business vocabulary and rules in controlled natural language) are both **OMG standards**, but neither refers to the other.
- Business people still prefer reading text over diagrams, and people differ in which form they understand best.
- The work is part of a long-term research line at KTU (VeTIS, VEPSEM projects) on integrating business models "under the unified framework of OMG's MDA".

### Goal
- **Automatically derive SBVR process rules from a BPMN process**, so the same business knowledge exists as a diagram *and* as unambiguous structured English.
- The rules must be consistent with the **business vocabulary** of the same domain.
- Each rule carries a **deontic modality**: obligatory, permitted or prohibited.

### Languages and metamodels
| Role | Language | How it exists in the tool |
|---|---|---|
| Source | BPMN 2.0 (subset: pools/lanes, events incl. boundary, activities, 4 gateway types, data objects/stores, messages, sequence flows with conditions) | BPMN profile in MagicDraw |
| Target | SBVR (noun concepts, verb concepts, behavioural rules) | UML profile for SBVR (fact diagrams) |
| Target (text) | SBVR Structured English | Text for the external VeTIS editor |
| Extension | A **BPMN vocabulary written in SBVR**, imported into the domain vocabulary (instead of changing the SBVR metamodel) | Not shown in the paper |
| Transformation | QVT | QVT engine from the Model Integrator plug-in |

### Transformation stack (Fig. 1, p. 6)

```
BPMN process model  («M2M input»)
   │
   ├─ Stage 1: form SBVR business vocabulary          [automatic, previous papers]
   │     1.1 form general (noun) concepts   e.g. customer, provider, order
   │     1.2 form verb concepts             e.g. provider analyzes order
   │
   ├─ Stage 2: form SBVR business rules               [automatic, THIS paper]
   │     2.1 T1–T9 (Table 1) + Algorithms 1–2 for cascading gateways
   │         reads: BPMN model + vocabulary from Stage 1
   │         writes: process rules
   │
   └─ Stage 3: validate SBVR model                    [manual, optional, business analyst]
   │
   ▼
SBVR model: vocabulary + process rules  («M2M output»)

In parallel:  BPMN model ──M2T──▶ SBVR Structured English text ──▶ VeTIS editor
```

**The rules.** Each rule is `Ti : PPi → RPi`. The source is a BPMN *process pattern* (a diagram fragment) and the target is an SBVR *rule pattern* written in EBNF. The EBNF patterns work like M2T templates: fixed text ("It is obligatory that", "after", "and if") with gaps filled from the model (`vc(...)`, `gc(...)`).

**Classification**

| Feature | Authors' claim | Remark |
|---|---|---|
| Rule application | Deterministic | — |
| Style | Hybrid (declarative + imperative) | Rules depend on elements created by other rules; the cascading-gateway algorithm is imperative recursion |
| Metamodels | Exogenous | In MagicDraw both BPMN and SBVR are UML profiles, so at implementation level they share the UML metamodel |
| Abstraction | Horizontal | Both are business-level descriptions of the same flow |
| Cardinality | One-to-one | Stage 2 reads the BPMN model **and** the Stage 1 vocabulary, so arguably N-to-1 |
| Direction | Unidirectional | The reverse (SBVR → BPMN) is future work |
| Kind | M2M **and** M2T | Two separate components in the plug-in (Fig. 2) |

### Metamodel-based transformation pattern

```
M3                               MOF
                  ┌───────────────┼────────────────┐
M2            BPMN 2.0           QVT              SBVR
                  ▲               ▲                 ▲
              conforms        conforms          conforms
                  │               │                 │
M1   "Order Registration" ──▶ T1–T9 + Alg. 1–2 ──▶ vocabulary (Table 2)
        (Fig. 5)              run by the QVT        + process rules (Table 3)
                              engine in MagicDraw
```

The transformation definition conforms to the QVT metamodel and *refers to* the BPMN and SBVR metamodels. The engine reads the source model and writes the target model.

### Levels

**Meta-levels**

| Level | Artefacts |
|---|---|
| M3 | MOF |
| M2 | BPMN 2.0, SBVR, QVT metamodels; in the tool: UML + BPMN profile + SBVR profile |
| M1 | Order Registration BPMN model; SBVR vocabulary and process rules; the QVT transformation definition; the BPMN vocabulary (an M1 model *about* the M2 BPMN metamodel) |
| M0 | The real order handling carried out by customers and providers |

**MDA level.** CIM → CIM. Both models describe the business independently of any IT support. The transformation changes the notation, not the abstraction level.

**Purpose of the models.** Both are descriptive business models, meant to be read and validated by people. They are not executable.

### Tooling (Fig. 2, p. 17)
- **MagicDraw**: commercial CASE tool with an open Java API. It supports BPMN and UML natively, but not SBVR.
- **SBVR Modeler plug-in**: UML profile for SBVR; vocabulary shown as fact diagrams.
- **VeTIS**: external SBVR text editor with syntactic validation and WordNet synonyms.
- **Transformation plug-in** (this paper): QVT rules exposed as M2M and M2T commands in the context menu. TRL 4 (validated in the lab).
- **Model Integrator plug-in**: model integration and the QVT engine.
- Source code: bitbucket.org/pauliusdan/sbvr-extraction; experiment data: github.com/paudan/bpmn2sbvr.

### Assumptions on the input
- Participants must be modelled as pools/lanes (they become the subjects of the rules).
- Every element must be named.
- Full conditions go on the outgoing sequence flows, not as a question on the gateway with yes/no branches.

These could be checked with OCL invariants on the BPMN metamodel before the transformation runs.

### Main critical points
- **Evaluation:** the benchmark was built by the same authors using the same rules, so it shows the implementation matches the specification, not that the rules are useful to business people.
- **Input preparation:** models were hand-picked and refactored first. Invalid models gave invalid or missing rules.
- **Missing enabler:** the BPMN vocabulary that replaces a metamodel extension is never shown.
- **No NLP:** grammar (plurals, tenses) is not handled.

---

## 2. Domain-Driven Architecture Modeling and Rapid Prototyping with Context Mapper

*Kapferer, Zimmermann. MODELSWARD 2020, CCIS 1361, pp. 250–272, Springer 2021.*

### Context
- Splitting a system into well-sized (micro)services is hard.
- Strategic DDD patterns (Subdomain, Bounded Context, Context Map, relationship patterns) help, but practitioners **interpret them differently**.
- Earlier work by the same authors introduced a DDD metamodel and the Context Mapper DSL (CML). This paper extends it.

### Goal
- Give the DDD patterns a **precise interpretation**: a metamodel plus semantic rules (hypothesis 1).
- Provide a **tool that models DDD rigorously and evolves models with transformations** (hypothesis 2).
- **New in this paper:** write requirements (user stories, use cases) in CML and **derive subdomains and bounded contexts automatically**, i.e. rapid prototyping.

### Languages and metamodels
| Element | What it is |
|---|---|
| Abstract syntax | Strategic DDD metamodel (Fig. 2, p. 255): ContextMap, BoundedContext, Subdomain (Core/Supporting/Generic), symmetric relationships (Partnership, SharedKernel), upstream/downstream relationships (CustomerSupplier, generic), roles (OHS, PL, ACL, CF) |
| Tactical part | Aggregates, Entities, Services, borrowed from the Sculptor DSL |
| New concepts | `UserStory` (role-feature-reason, extended with "with its" / "for a"), `UseCase` (Cockburn's brief format) |
| Concrete syntax | Textual CML, defined as an **Xtext** grammar; models are **EMF** models |
| Constraints | Semantic rules on allowed pattern combinations, implemented as **validators** |
| Other views | Generated graphical context maps, UML/PlantUML diagrams |

### Transformation stack (Fig. 3, p. 262)

```
Use cases / user stories (CML)                  functional requirements
   │  Step 1  N→1   user picks which use cases go together
   ▼
Subdomain (CML)                                 domain analysis
   │  Step 2  N→1   one Aggregate per subdomain; adds IDs,
   │                parameter/return types, TODO hints
   ▼
Bounded Context, type FEATURE (CML)             strategic DDD
   │  (manual refinement → type APPLICATION, optional)
   │  Step 3  1→2   frontend + backend, plus a new context map
   │                Backend [PL]->[CF] Frontend, "RESTful HTTP"
   ▼
2 Bounded Contexts, type SYSTEM (CML)           deployment perspective
   │  Steps 4..N  1→2   split a system into subsystems
   ▼                    (e.g. domain-logic tier + database tier)
More SYSTEM contexts

Side transformations:  Architectural Refactorings (split/merge/extract contexts and aggregates)
Last step (M2T):       JHipster microservice per Bounded Context; diagrams
```

**Worked example:** Cockburn's "Get paid for car accident" (Listing 5.1) → Subdomain `ClaimsManagement` (5.2) → Feature context (5.3) → frontend/backend System contexts (5.4).

**Step 1 mapping (Fig. 4, p. 264).** Each interaction "*verb* a *Entity* with its *attributes* for a *Entity*" becomes an Entity with attributes and a reference, plus a Service operation `verbEntity`. For example, "submit a Claim" becomes Entity `Claim` and operation `submitClaim`.

**Classification**

| Feature | Rapid-prototyping steps | Architectural refactorings |
|---|---|---|
| Metamodels | **Endogenous** (CML → CML) | Endogenous |
| Abstraction | **Vertical** (requirements → analysis → design → deployment) | **Horizontal** |
| Cardinality | N-1, N-1, 1-2, 1-2 | Varies (split 1-2, merge 2-1) |
| Automation | **Semi-automatic**: the user chooses inputs and refines `TODO`s | Semi-automatic |
| Traceability | Explicit in the model: `BoundedContext X implements Subdomain Y` | — |
| Language | Not named in the paper (EMF models, so ATL, QVT or Java would all fit) | — |

**Endogenous yet vertical.** The abstraction level is encoded *inside* the one metamodel, through the context `type` (Feature/Application/System) and `implementationTechnology`. The chain goes down in detail without ever changing language.

### Metamodel-based transformation pattern (endogenous version)

```
M3                            Ecore
                     ┌──────────┴──────────┐
M2             CML metamodel        transformation language
           (from the Xtext grammar)    (not named in the paper)
             ▲               ▲               ▲
         conforms         conforms        conforms
             │               │               │
M1   use case model ──▶  Step 1..N  ──▶  subdomain / bounded-context model
     (Listing 5.1)                         (Listings 5.2–5.4)
```

Source and target metamodels are the same box.

### Levels

**Meta-levels**

| Level | Artefacts |
|---|---|
| M3 | Ecore |
| M2 | CML metamodel (conceptual: Fig. 2; technical: the Ecore model Xtext generates); the Xtext grammar as the concrete-syntax definition |
| M1 | `insurance.cml`, the "Get paid for car accident" use case and everything derived from it |
| M0 | The real insurance company's software systems and teams |

**MDA levels (all inside M1, all in CML)**

| MDA | Context Mapper artefact |
|---|---|
| CIM | Use cases, user stories, subdomains |
| PIM | Bounded context of type Feature / Application |
| PSM | Bounded contexts of type System with `implementationTechnology` (Angular, Spring Boot) |
| Code | JHipster-generated microservices |

**Viewpoints (Table 1, p. 256).** The context types map onto architecture viewpoints:
- **Feature:** scenario view (4+1); system context (C4)
- **Application:** logical/development view; C4 components
- **System:** physical/process view; C4 containers
- **Team:** Conway's law; no 4+1 or C4 equivalent

**Purpose of the models.** They move along the chain from *sketch* (Feature context full of `TODO`s) to *blueprint* (refined System context map) to *program* (generated code).

### Tooling
- Xtext + EMF; available for Eclipse, VS Code and browser IDEs (Gitpod, Theia).
- Open source, 50 releases since November 2018.
- Generators for graphical context maps, UML/PlantUML, JHipster (one microservice per bounded context).

### Main critical points
- **Model–code gap:** generated code drifts away from the model. Planned fix: reverse engineering from code.
- **Cost:** IDE support has to be built and maintained for every editor.
- **Agile tension:** "working software over comprehensive documentation".
- **Workshop feedback:** a graphical notation might be better, and the tool must not become an excuse not to talk to users.
- **Validation:** mostly by the tool authors themselves, with users who already know DDD.
- **Metamodel vs grammar mismatch:** Fig. 2 models Subdomain kinds as subclasses and roles as classes, while CML uses a `type` attribute and keywords.

---

## 3. A Use Case Driven Approach to Game Modeling

*Albaghajati, Hassine. Requirements Engineering 27:83–116, Springer 2022.*

### Context
- Game teams mix game designers, artists, level designers and programmers. Communication between them is one of the industry's top problems.
- Designers find models hard to learn and fear they restrict creativity.
- Earlier game-modelling approaches are too technical (class/state/sequence diagrams), combine many diagram types, or target one niche (serious or educational games).

### Goal
- A **simple, general, game-oriented requirements notation** that technical and non-technical team members can share.
- Built by **extending the standard UML use-case diagram**, used mainly in the **requirements elicitation** stage.
- Shown on four genres; perceived understandability, learnability and usefulness assessed by a survey.

### Languages and metamodels
| Element | What it is |
|---|---|
| Base language | UML 2.5.1 use-case metamodel: UseCase, Actor, Include, Extend, ExtensionPoint, Constraint, Classifier (subject) |
| Extension (Fig. 1, p. 89) | `GameActor` (subclass of Actor) with `type: GameActorType` {User, PlayerCharacter, NonPlayerCharacter}; `GameUseCase` (subclass of UseCase) with `type: GameUseCaseType` {Function, LoadScene, PlayAnimation, PlayAudio, CreateObject}, priority, sketch, pre/post-conditions, flow of events |
| Extension mechanism | **New metaclasses via MOF** (heavyweight), but shown with **stereotype notation** («Function» …) |
| Concrete syntaxes | Graphical (icons on ovals and stick figures) + textual form-based template |
| Constraints | 11 **strict** rules (errors, enforced by the tool) + 5 **soft** rules (warnings), written in natural language |
| Pre/post-conditions | Deliberately **not OCL**, to keep the learning curve low |

### Transformation stack

**The paper defines none.** What it provides:

```
Graphical + textual editing (GUCM)
   │  validation: strict rules block the action, soft rules give warnings
   ▼
Game use-case model
   ├──▶ save as JSON          (serialisation; not XMI, not EMF)
   └──▶ export as PNG         (rendering of the diagram)
```

The paper only hints at transformations:
- "can be adapted and integrated within a game based MBD process (using model transformations and code generation)" (p. 85)
- survey suggestions: generate **test scenarios** from the textual use cases, reuse **templates** for common mechanics (p. 111)

**A possible chain** (my proposal, not in the paper):

```
GUCM JSON ──(text-to-model)──▶ Game use-case model (Ecore/XMI)            CIM
     ├──(ATL/QVTo, exogenous, vertical)──▶ UML class + state-machine model PIM
     │        └──(Acceleo, M2T)──▶ Unity C# MonoBehaviour skeletons       code
     ├──(Acceleo, M2T)──▶ test scenarios from flow of events + extends
     └──(M2M/M2T)──▶ task list per discipline
                       PlayAnimation → artists, PlayAudio → audio team,
                       LoadScene → level designers, Function → programmers
```

### Metamodel-based pattern (for the proposed Unity generator)

```
M3                              MOF / Ecore
                   ┌─────────────────┼─────────────────┐
M2      UML use case + game ext.    Acceleo MM      (target: C# text)
                   ▲                  ▲
               conforms           conforms
                   │                  │
M1        Super Mario model ──▶ Acceleo templates ──▶ Mario.cs, Goomba.cs, …
             (Fig. 9)
```

### Levels

**Meta-levels**

| Level | Artefacts |
|---|---|
| M3 | MOF |
| M2 | UML 2.5.1 use-case metamodel + `GameActor`, `GameUseCase` and the two enumerations |
| M1 | The Super Mario Bros model (Fig. 9) and its textual descriptions (Figs. 10–13); Tetris, Just Dance, The Walking Dead |
| M0 | The running game (Mario and Goombas at runtime, every fireball instance) **and** the human players |

**The M0 subtlety.**
- *User* actors stand for real people outside the software.
- *PlayerCharacter* and *NonPlayerCharacter* actors stand for software entities inside the game, which is why they are drawn inside the system boundary.
- The game is itself a model of a fictional world ("software systems as models"). UML, however, defines actors as **external** to the subject.

**MDA level.** CIM only: requirements, with no platform or design decisions. Design (classes, state machines, timing) is explicitly left to later stages.

**Purpose of the models.** *Sketches* for communication. The authors say the example models cover neither all aspects nor all components, and the template even has a literal "sketch" field.

### Tooling
- **GUCM**: web tool built with **Unity / C#** (74 classes, 9,152 lines of code).
- Palette-based editor, textual description forms, sketch upload.
- Error dialog for strict rules, warnings for soft rules.
- Saves to JSON, exports to PNG.
- Not built on a modelling framework, so no XMI, no OCL engine, no transformation languages.

### Main critical points
- **No automation:** of the MDE benefits, only *communication* is used.
- **Heavyweight extension, lightweight look:** the extension is defined with metaclasses but drawn as stereotypes. A UML profile would have worked in existing UML tools (Papyrus, Enterprise Architect).
- **Redundant attributes:** `gameActorName` / `gameUseCaseName` duplicate the inherited `name`.
- **Rules outside the metamodel:** rules 9–11 are about where symbols are drawn (concrete syntax), so they cannot be expressed on the metamodel.
- **Narrowed multiplicity:** strict rule 6 restricts UML's `extensionLocation 1..*` to exactly one.
- **Weak evaluation:** perceived, self-assessed answers from 29 people, mostly programmers. Nobody used the tool, and the introduction was short.
- **Scalability:** use-case diagrams scale poorly, and Fig. 9 is already crowded.

---

## Cross-paper view

**Where each sits in the transformation taxonomy**

| | Horizontal | Vertical |
|---|---|---|
| **Exogenous** | BPMN → SBVR | Game use cases → code (proposed) |
| **Endogenous** | Context Mapper refactorings | Context Mapper prototyping chain |

**How each extends or creates a language**
- **BPMN → SBVR:** stays inside SBVR by importing a vocabulary (M1). No metamodel change.
- **Context Mapper:** creates a new DSL with its own metamodel (M2) and an Xtext grammar.
- **Game paper:** adds metaclasses to an existing metamodel (M2, heavyweight) and shows them as stereotypes.

**Graphics and text in each paper**
- **BPMN → SBVR:** generates text *from* diagrams.
- **Context Mapper:** generates diagrams *from* text.
- **Game paper:** attaches a text template to each diagram element.

All three are cases of one abstract syntax with several concrete syntaxes.

**Input quality decides output quality**
- **BPMN → SBVR:** implicit modelling conventions.
- **Context Mapper:** semantic rules as Xtext validators.
- **Game paper:** strict and soft rules.

In course terms, these are all OCL-style well-formedness constraints on the source models.
