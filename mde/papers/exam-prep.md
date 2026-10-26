# MDE exam prep: what to study and likely questions

Companion to [summaries.md](summaries.md) (what each paper says) and [connections.md](connections.md) (how each paper maps onto the course notes, with OCL/QVT/Xtext/Acceleo sketches). This file is about **the exam itself**: what the 8 generic questions will turn into for each paper, and what you must be able to draw.

---

## 1. How the exam is built

The exam specification fixes **8 generic questions**. Each will be specialised to the selected paper, and there may be several concrete questions per generic one.

| # | Generic question | ILO | What they are really testing |
|---|---|---|---|
| Q1 | Why and how can MDE be applied to the problem in the paper? | 1, 3, 4 | Can you name MDE's benefits (abstraction, automation, communication, consistency, standards) **and tie each to this problem** |
| Q2 | What are the scope or requirements of the proposed solution? | 3 | What it covers, what it excludes, what it assumes about its inputs and users |
| Q3 | What are the elements of the transformation chain? | 1 | Source/target models and metamodels, transformation definitions, language, engine, manual steps, M2M vs M2T, classification |
| Q4 | What are the instances of a metamodel of the paper? | 1 | **Draw an object diagram** of a paper example that conforms to a metamodel |
| Q5 | What is the relation between the different levels of modelling? | 1 | M0–M3, conformsTo vs representationOf, MDA CIM/PIM/PSM, abstraction levels vs meta-levels |
| Q6 | How can the proposed metamodel be used for other purposes? | 1, 3 | Other analyses, generators, views or tools built on the same metamodel |
| Q7 | How to apply other solutions (technology or modelling)? | 3, 4 | ATL vs QVT vs Java, EMF vs MagicDraw, profile vs metamodel, textual vs graphical, and **justify** the trade-off |
| Q8 | How to generalise the proposed solution to other domains? | 1, 3, 4 | What part is domain-specific, what part is a reusable pattern |

**Weights:** ILO 1 (explain MDE concepts) ≈ 60 %, ILO 3 (evaluate alternative solutions) ≈ 30 %, ILO 4 (critically select tools/technologies) ≈ 10 %. Q3, Q4 and Q5 are pure ILO 1, so **the transformation chain, metamodel instances and meta-levels are where most of the points are**.

**Marking rules that change how you write:**
- Copied text from the paper, book or slides is ignored. Paraphrase, then apply.
- Answers that are too short are ignored. The examiners already know MDE and want to see that you do.
- Bring paper and pencils: you will draw diagrams.

**A good answer shape:** (1) define the MDE concept in one or two sentences of your own, (2) apply it with the paper's concrete names (T2, Listing 5.3, Fig. 9, "Order Registration"), (3) add one critical remark (a limitation, an alternative, or a mismatch between the paper's claim and the theory).

---

## 2. Course concepts to have ready (all papers)

Be able to explain each of these in your own words **and** point to where it shows up in each paper (see the overview table in [connections.md](connections.md)).

**Models and metamodels**
- Model, system under study, `representationOf` vs `conformsTo`/`instanceOf`
- Purposes of models: sketch, blueprint, program
- Metamodel = abstract syntax. Concrete syntax (textual/graphical) and semantics are separate
- Four meta-levels M0–M3, MOF and Ecore at M3, why the tower stops at M3 (self-description)
- Object diagrams as instances of a metamodel (class diagram)
- Extending a language: **UML profile** (stereotypes, tagged values; lightweight) vs **new metaclasses via MOF** (heavyweight) vs **staying inside the language** (SBVR vocabulary import)

**Constraints**
- OCL invariants as well-formedness rules: what the metamodel's multiplicities can't express
- Errors vs warnings (strict vs soft rules, Xtext validators)

**DSLs**
- Abstraction gap vs implementation gap, GPML vs DSML, "Babel tower" risk
- Xtext workflow: grammar → MWE2 → parser, editor, validator **and Ecore metamodel**

**Transformations**
- **The metamodel-based transformation pattern** (draw it from memory): MOF at the top; source MM, target MM and transformation-language MM all conform to MOF; the transformation definition conforms to the language MM and *refers to* source and target MMs; the engine executes it, reading Ma (conforms to MMa) and writing Mb (conforms to MMb)
- Classification: endogenous/exogenous, horizontal/vertical, 1-1/1-N/N-1/M-N, uni/bidirectional, declarative/imperative/hybrid, M2M vs M2T, in-place vs out-place
- Transformation chains, model composition, traceability (implicit traces in ATL/QVT vs explicit trace links in the model)
- ATL: matched / lazy / unique lazy / called rules, guards, automatic trace resolution
- QVTo: `mapping … when {…}`, helpers/queries, `resolve`/`resolveIn`, `init`/`end` sections
- Acceleo: templates, `[for]`, `[if]`, `[file]`, queries; M2T as the last step of a chain
- MDA: CIM → PIM → PSM → code, the platform concept

**Critical-evaluation vocabulary**
- Construct / internal / external validity, sample size, self-assessment bias
- Model–code gap, round-trip engineering, synchronisation of manual and generated parts
- Standard compliance vs tool lock-in ("closed in your own sandbox")
- Scalability of notations, learning curve, who reads the models

---

## 3. Paper 1: BPMN → SBVR process rules (Skersys et al., 2022)

### Must know
- The **9 rules** `Ti : PPi → RPi` and which modality each produces (table in [summaries.md](summaries.md)). Know why: exclusive branch with condition → *obligatory … and if*, without → *permitted*; parallel and inclusive → *obligatory* joined with *and*; event-based → *permitted*; interrupting boundary event → extra *prohibited*.
- The **three-stage scenario** in Fig. 1: Stage 1 (vocabulary: 1.1 general concepts, 1.2 verb concepts, automatic, earlier work), Stage 2 (2.1 business rules, automatic, this paper), Stage 3 (3.1 validate, manual, optional).
- **Cascading gateways**: backward chaining, activity-node and gateway neighbourhoods, boundary gateway, `OTHERWISE` for default flows.
- **Implementation** (Fig. 2): MagicDraw; SBVR via a UML profile; **BPMN in MagicDraw is also a profile**; QVT; both M2M and M2T (text for VeTIS); Model Integrator plug-in provides the QVT engine.
- The worked example: "Order Registration" (Fig. 5, Tables 2 and 3).
- **Input requirements**: pools/lanes, every element named, full conditions on outgoing sequence flows.
- The **evaluation**: 32 models, benchmark built by the authors by hand, automatic output fully matched it.

### Drawings to practise
1. **The metamodel-based transformation pattern** instantiated for this paper: MOF; BPMN 2.0 MM and SBVR MM (in the tool: UML + profiles); QVT MM; the T1–T9 definition; the MagicDraw QVT engine; Order Registration (BPMN) → vocabulary + process rules (SBVR).
2. **A simplified BPMN-subset metamodel.** The paper has no metamodel figure, so you must produce one: `Process`, `Lane`, `FlowNode` {`Activity`, `Event` {Start, Intermediate, End, Boundary(interrupting)}, `Gateway`(kind)}, `SequenceFlow`(condition, isDefault), `DataObject`, `DataStore`, `MessageFlow`, `Pool`.
3. **A simplified SBVR process-rule metamodel**: `ProcessRule`(modality: {obligatory, permitted, prohibited}) → `consequent: VerbConcept`, `antecedent: VerbConcept[1..*]`, `condition: VerbConcept[0..*]`, `connective` {after, when, only if}; `VerbConcept` → roles → `NounConcept`.
4. **An object diagram** for one rule, e.g. *"It is obligatory that provider analyzes order after order is received"*: a source BPMN instance (Lane *provider*, Event *order is received*, SequenceFlow, Task *analyze order*) and the target SBVR instance (ProcessRule obligatory, two VerbConcepts, NounConcepts *provider*, *order*). Draw the trace links between them.

### Potential questions
1. **[Q1]** Why is MDE a good fit for keeping process models and business rules consistent? Why does the paper treat this as a model transformation rather than plain NLP text generation?
   - Cover: both are OMG/MOF standards, so metamodel-to-metamodel mapping is possible; formal target (SBVR has logic semantics) avoids NLP ambiguity; automation keeps text in sync when the diagram changes; one project holds both views (digital thread); two concrete syntaxes for two audiences.
2. **[Q2]** What are the scope and preconditions of the approach? What happens if a BPMN model violates them?
   - Cover: only process rules (not structural rules); BPMN subset, complex gateway excluded; vocabulary must already exist (Stage 1); lanes, names, conditions on flows; the paper reports invalid/missing rules from unrefactored models. Then propose **OCL invariants** to check these preconditions *before* running the transformation.
3. **[Q3]** Describe the transformation chain of Fig. 1. Identify source and target models and metamodels, the transformation definitions, the language, the engine, and the manual steps.
4. **[Q3, critical]** The authors classify the transformation as exogenous, horizontal, one-to-one and hybrid. Discuss each label. Do you agree?
   - Exogenous: true conceptually, but in MagicDraw both BPMN and SBVR are **UML profiles**, so at the implementation level source and target conform to the same UML metamodel.
   - Horizontal: both are CIM-level business models, so it changes language but not abstraction level.
   - One-to-one: Stage 2 reads the BPMN model **and** the vocabulary produced by Stage 1 (Fig. 1 arrows), so it is arguably N-1 or an in-place update of the SBVR model.
   - Hybrid: rules depend on elements created by other rules, and the cascading-gateway algorithm is imperative recursion.
5. **[Q3]** How would you implement T1 (or T2, or T5) in QVTo or ATL? Which part is the source pattern, which is the guard, and how do you reach the verb concepts created in Stage 1?
   - Cover: matched rule / `mapping` from `SequenceFlow` with a `when` guard on source and target types; `resolve`/trace to find the VerbConcept created for an Activity; the EBNF RP is effectively an M2T template. See the QVTo/Acceleo sketch in [connections.md](connections.md).
6. **[Q4]** Draw the instance of the BPMN metamodel and of the SBVR metamodel for a fragment of Fig. 5 (e.g. the parallel gateway with *schedule order production* and *schedule order delivery date*) and show which rule creates which target elements.
7. **[Q5]** Place every artefact of the paper on M0–M3: MOF; BPMN, SBVR, UML, QVT metamodels; Order Registration model; SBVR vocabulary and rules; **the QVT transformation definition itself** (an M1 model conforming to the QVT MM); the real order handling at M0.
   - Bonus: the "SBVR vocabulary describing BPMN concepts" is an M1 model *about* an M2 metamodel (a model of a model). SBVR is itself a vocabulary that can describe its own concepts (meta-circular like MOF).
8. **[Q5]** Where is this work in MDA? Is SBVR a CIM, a PIM or neither? Could the generated rules feed a PIM?
9. **[Q6]** What else can be done with the produced SBVR model or with the BPMN-vocabulary?
   - Cover: requirements specification and work instructions (paper says so); generating OWL ontologies, SQL constraints, UML use cases from SBVR (refs 29–32); compliance/conformance checking of event logs against the rules; reverse transformation SBVR → BPMN (future work, and refs 42–46: one of them is co-authored by the course teacher).
10. **[Q7]** Re-engineer the solution with the course stack: Eclipse BPMN2 Ecore + an SBVR Ecore MM, ATL or QVTo for M2M, Acceleo for the Structured English text, Xtext for an SBVR editor so the text can be parsed back. What do you gain and lose compared with MagicDraw?
    - Gain: open tooling, XMI interchange, OCL validation, testable transformations. Lose: commercial diagram quality, existing VeTIS/WordNet support, the authors' existing profile.
11. **[Q7, modelling]** Why did they import a BPMN vocabulary instead of extending the SBVR metamodel? Compare with the UML profile vs metaclass choice in the game paper.
12. **[Q7, alternative target]** Could a formal declarative process language (e.g. Declare/LTL templates such as *response* and *precedence*) be a better target than SBVR? What would be lost? (Readability for business people, which is the whole motivation.)
13. **[Q8]** Generalise to UML activity diagrams (the paper suggests it), EPCs, Petri nets, or to another controlled natural language/language than English. Which parts of the solution change (source MM, patterns PPi), which stay (the scenario of Fig. 1, rule patterns RPi)?
14. **[Critical]** The evaluation says the output "fully matched the benchmark". What does that actually prove? 
    - The benchmark was produced by the same authors applying the same rules, so it verifies that the **implementation matches the specification**, not that the rules are correct, complete or useful to business people. Models were hand-picked and refactored first. No users validated readability.
15. **[Critical]** Rules in an SBVR rule set are unordered, but the meaning of a process is in its order. Can the rule set really represent the process (the authors claim it allows reverse engineering)? What extra information (BPMN concept types in the vocabulary) does that need?

---

## 4. Paper 2: Context Mapper (Kapferer & Zimmermann, 2021)

### Must know
- The **two hypotheses** (precise interpretation of DDD patterns; a rigorous tool that transforms and evolves models).
- **Fig. 2 metamodel** in detail:
  - `ContextMap` shows `BoundedContext` (1..*) and `BoundedContextRelationship` (0..*)
  - `BoundedContext` (type, knowledge level, vision statement) *implements part of* `Subdomain` (1..*), has `Responsibility`
  - `Subdomain` specialised into `CoreDomain`, `SupportingSubdomain`, `GenericSubdomain`
  - abstract `BoundedContextRelationship` → `SymmetricRelationship` (participant1/2) {`Partnership`, `SharedKernel`} and `UpstreamDownstreamRelationship` (upstream/downstream) {`CustomerSupplierRelationship`, `GenericUpstreamDownstreamRelationship`}
  - "Upstream has" 0..* and "Downstream has" 0..1 `RelationshipRole` → `UpstreamRole` {PL, OHS}, `DownstreamRole` {ACL, Conformist}
- CML syntax for every relationship type (Listings 4.3–4.10), user stories (4.11) and use cases (4.12).
- The **rapid-prototyping chain** (Fig. 3, Listings 5.1–5.4) and the **Architectural Refactorings**.
- Context types **F**eature / **A**pplication / **S**ystem / **T**eam and their mapping to 4+1 and C4.
- Validation: Shaw's guidelines, case studies, workshop with 5 architects, ~20 students; conclusion "useful for education and early stages, not a replacement for analysis".

### Drawings to practise
1. **Object diagram of a CML context map** as an instance of Fig. 2. Good candidates:
   - `CustomerManagementContext [U,OHS,PL]->[D,CF] PolicyManagementContext`: one `ContextMap`, two `BoundedContext`, one `GenericUpstreamDownstreamRelationship` with `upstream`/`downstream` links, `OHS` and `PL` objects via "Upstream has", one `Conformist` via "Downstream has".
   - `SelfServiceContext [C,ACL]<-[S,PL] CustomerMgmtContext`: a `CustomerSupplierRelationship` instead.
   - `RiskManagementContext [P]<->[P] PolicyManagementContext`: a `Partnership` with participant1/participant2.
2. **The transformation chain** of Fig. 3 annotated with: input/output model types, cardinality (N-1, N-1, 1-2, 1-2), vertical vs horizontal, MDA level, and which steps are manual.
3. **The metamodel-based transformation pattern** for one step: CML MM (Ecore, generated by Xtext) is both source and target MM, so draw the endogenous version.
4. **An extension of Fig. 2** with the new requirement concepts it does not show: `UserStory`/`UseCase` → `Feature`/`Interaction` (verb, entity, attributes, reference) and the tactical part `Aggregate` → `Entity`, `Service`/`Operation`.

### Potential questions
1. **[Q1]** Why does a DSL plus model transformations help with service decomposition? What does MDE add over drawing context maps on a whiteboard?
   - Cover: removes ambiguity of the patterns (precise metamodel + semantic rules); machine-checkable; transformations make iterative evolution cheap; several views generated from one model; ubiquitous language ≈ small abstraction gap.
2. **[Q2]** What is the scope of Context Mapper and of the rapid-prototyping chain? What does it explicitly not do?
   - Cover: strategic DDD (plus tactical via Sculptor syntax); early phases and teaching; transformations "do not aim at replacing human design work"; Application contexts stay manual; code generation is out of the paper's scope; requires an IDE.
3. **[Q3]** Describe the transformation chain from use case to subsystems. For each step give input, output, cardinality, what information is added and who decides what.
   - Step 1 N-1 (user picks use cases → one Subdomain); Step 2 N-1 (subdomains → one Feature BC, one Aggregate each; adds IDs, parameter/return types, `TODO`s); Step 3 1-2 plus a new ContextMap (`Backend [PL]->[CF] Frontend`, `implementationTechnology`); Steps 4..N 1-2; ARs split/merge/extract. M2T at the end: JHipster microservice per BC, diagrams.
4. **[Q3, critical]** Classify the transformations. They are all **endogenous** (same CML metamodel) but described as moving from analysis to design to deployment. Are they vertical or horizontal? How can a vertical transformation be endogenous?
   - Cover: abstraction level is encoded *inside* one metamodel (the `type` attribute and `implementationTechnology`), so vertical refinement happens within M1 without changing the M2 language. The ARs are endogenous horizontal (refactoring).
5. **[Q3]** The paper calls the transformations semi-automatic. Does that fit the course definition of a model transformation ("target models automatically generated … according to a transformation definition")? How are the user's choices captured, and how is traceability kept (`implements`)?
6. **[Q4]** Draw the instance of Fig. 2 for Listing 4.3 (or 4.9, or the context map of Listing 5.4).
7. **[Q4, critical]** Fig. 2 models Subdomain kinds as **subclasses** and roles as **classes**, but CML writes `type = CORE_DOMAIN` and roles as keywords inside brackets. What does that tell you about the relation between the conceptual metamodel and the Ecore metamodel Xtext generates from the grammar?
8. **[Q4/OCL]** The metamodel lets "Upstream has" point to any `RelationshipRole`. Write OCL constraints that (a) upstream roles are `UpstreamRole`s, (b) downstream roles are `DownstreamRole`s, (c) a relationship is not between a context and itself, (d) every context in a relationship is contained in the map. Which of these could the grammar enforce instead?
9. **[Q5]** Place on M0–M3: Ecore; CML metamodel (and the Xtext grammar as concrete-syntax definition); `insurance.cml`; the real insurance system and its teams. Then relate the *abstraction* levels (requirements → subdomain → feature → system) to MDA CIM/PIM/PSM, and explain why these are **not** meta-levels.
10. **[Q6]** What else can be built on the CML metamodel?
    - Cover: visual context maps, UML/PlantUML diagrams; code generation (JHipster); API contracts (the authors do this in another paper); automatic decomposition suggestions (Service Cutter, future work); team topology / Conway's-law analysis from Team contexts; coupling/cohesion metrics; consistency checks against code (reverse engineering, future work).
11. **[Q7, technology]** Implement the chain with the course tools: ATL or QVTo over the Xtext-generated Ecore; Acceleo for code. Or give CML a graphical syntax with Sirius over the same metamodel. What changes, what stays?
12. **[Q7, modelling]** Compare a textual DSL with a **UML profile for DDD** (Rademacher, related work) and with a graphical notation (the workshop architects asked for one). Argue for one.
13. **[Q8]** Generalise: the "requirements → domain model → logical components → deployment units" chain is not DDD-specific. Apply it to e.g. IoT systems, modular monoliths, data-pipeline design. What must change in the metamodel?
14. **[Critical]** The authors list the **model–code gap** and the agile "working software over documentation" tension as weaknesses. How would round-tripping or reverse engineering address them, and what does it cost? Connect to the "model burning party".
15. **[Critical]** Evaluate the validation: action research and self-experiments by the tool authors, 5 architects already familiar with DDD, ~20 students, download counts. What would a stronger evaluation look like?

---

## 5. Paper 3: Game use-case modeling (Albaghajati & Hassine, 2022)

### Must know
- **Fig. 1 metamodel**: the UML 2.5.1 use-case metamodel (`UseCase`, `Actor`, `Include` with `addition`/`includingCase`, `Extend` with `extendedCase`/`extension`/`extensionLocation 1..*`/`condition 0..1 Constraint`, `ExtensionPoint`, `Classifier` as subject) plus four red additions:
  - `GameActor` (subclass of `Actor`): `type: GameActorType`, `gameActorName`, `gameActorDescription`
  - `GameUseCase` (subclass of `UseCase`): `type: GameUseCaseType`, name, description, `priority: INT`, `gameUseCaseSketch`, `preConditions[]`, `postConditions[]`, `flowOfEvents[]`
  - `GameActorType` {User, PlayerCharacter, NonPlayerCharacter}
  - `GameUseCaseType` {Function, PlayAnimation, PlayAudio, LoadScene, CreateObject}
- The **11 strict** and **5 soft** rules, and which ones are about the abstract syntax vs only about where symbols are drawn (rules 9–11).
- **Why PlayerCharacter/NPC actors go inside the boundary** (software agents are part of the system).
- The Super Mario model (Fig. 9): `Jump` includes `Play jump animation`; `Die` extended by `Load main scene` (health < 0) and `Load current level` (health >= 0); fireball NPC created by `Create fireball` «CreateObject» included in `Throw fire ball`.
- GUCM: Unity/C#, JSON storage, PNG export, error dialog for strict rules, warnings for soft rules.
- The survey: 29 respondents, mostly programmers; Mann–Whitney U; significant difference between "used models" vs "not used" (approach liked *more* by people without modelling experience); no difference UML-UCD vs other diagrams.
- **There is no transformation in this paper.** Expect Q3 to become "propose one".

### Drawings to practise
1. **Object diagram** for part of Fig. 9 as an instance of Fig. 1. Best candidate, because it uses every extension concept:
   - `mario: GameActor {type = PlayerCharacter}`
   - `die: GameUseCase {type = Function}`, `pda: GameUseCase {type = PlayAnimation, name = "Play die animation"}`, `inc: Include {includingCase = die, addition = pda}`
   - `lcl: GameUseCase {type = LoadScene, name = "Load current level"}`, `ep: ExtensionPoint` owned by `die`, `ext: Extend {extension = lcl, extendedCase = die, extensionLocation = ep}`, `c: Constraint {"mario's health >= 0"}` as `ext.condition`
   - the association between `mario` and `die` (note Fig. 1 does not show the actor–use case association; it comes from the generic UML `Association`)
2. **A proposed transformation chain** (see question 4 below), drawn with metamodels and the metamodel-based transformation pattern.
3. **The same extension as a UML profile**: stereotypes «GameUseCase» extends metaclass `UseCase` with tagged values `type`, `priority`, …; «GameActor» extends `Actor`. Compare with Fig. 1.

### Potential questions
1. **[Q1]** Why could MDE help game development teams? Which MDE promise is this paper testing, and which MDE benefits does it *not* yet use?
   - Cover: communication between technical and non-technical roles (models for domain experts); abstraction over engine details; but no automation, no transformations, no code generation, so only the "communication" benefit is used. Designers' fear of restricted creativity ≈ model burning party.
2. **[Q2]** What are the scope and requirements of the approach? Why did the authors keep it this simple?
   - Cover: requirements-elicitation stage only; all genres; usable by non-engineers (no OCL, no new relationships, one diagram type); later design (class diagrams, state machines, timing) left to other techniques.
3. **[Q3]** The paper defines no transformation chain. Identify which MDE elements it does provide (metamodel, two concrete syntaxes, constraints, a tool, a serialisation format) and which elements of a chain are missing.
4. **[Q3, design]** Propose a transformation chain that uses the game use-case model. For each step give source/target metamodel, M2M or M2T, language, and classification.
   - Example: GUCM JSON → (text-to-model injection) → Ecore GameUC model; GameUC → UML class diagram / state machine skeleton (ATL/QVTo, exogenous, vertical); GameUC → Unity C# `MonoBehaviour` skeletons (Acceleo, M2T); GameUC → test scenarios from flow of events (M2T, suggested by survey respondents); GameUC → task list per discipline (PlayAnimation → artists, PlayAudio → audio, LoadScene → level designers).
5. **[Q4]** Draw the instance of Fig. 1 for a fragment of Fig. 9 (see drawing 1). Mark which objects are instances of the new metaclasses and which of standard UML metaclasses.
6. **[Q4/OCL]** Express strict rules 4, 5, 6, 8 and soft rules 2–4 in OCL over Fig. 1. Which rules cannot be written against the abstract syntax at all (9–11, placement) and why? How would you distinguish strict (error) from soft (warning) rules in a tool?
7. **[Q4, critical]** Fig. 1 has some modelling choices worth criticising:
   - `gameActorName`/`gameUseCaseName` duplicate the inherited `NamedElement::name`
   - **subclass + metaclass extension** in the abstract syntax, but **stereotype notation** in the concrete syntax. Why not a UML profile, which existing UML tools (Papyrus, Enterprise Architect) already support?
   - **enumeration `type`** instead of five subclasses: simpler, but soft rules then need OCL instead of being enforced by typing
   - strict rule 6 (exactly one extension point) **narrows** UML's `extensionLocation 1..*`
   - the textual template (pre/post-conditions, flow of events) is stored as `String[]` attributes, so it is part of the abstract syntax but has no structure
8. **[Q5]** Place on M0–M3: MOF; UML use-case MM + game extension; the Mario model; at M0 both the running game (Mario character at runtime, many fireball instances) **and** the human player. Discuss the subtlety: User actors represent real people, PlayerCharacter/NPC actors represent software entities, so the "system under study" is a model of a fictional world (software systems as models).
9. **[Q5, critical]** UML defines an actor as something **external** to the subject. Is putting PlayerCharacter and NPC actors inside the boundary consistent with UML's semantics? Is a fireball really an actor?
10. **[Q6]** What else can the metamodel be used for?
    - Cover: test-scenario generation; effort estimation and planning (priority field, per-type counts); assigning work to teams by use-case type; checking consistency between game design document and model; traceability to assets (sketch field); generating Unity skeletons; generating documentation/game design documents.
11. **[Q7, technology]** Rebuild GUCM with MDE tools: Ecore metamodel, Sirius graphical editor, OCL validation, XMI instead of ad-hoc JSON. What do you gain (validation, interchange, transformations for free) and what do you lose (a web tool built in a game engine the target users already know)?
12. **[Q7, modelling]** Compare with the alternatives in related work: multi-diagram approaches (MML, Lope et al.), a dedicated graphical DSL (Eberos GML2D), GaML with OCL. When is a single extended use-case diagram enough, and when is it not?
13. **[Q8]** Generalise the pattern "extend UML use cases with domain-specific stereotypes + textual templates + strict/soft well-formedness rules" to another domain: VR/AR training simulators, interactive storytelling, robotics, smart homes. The related work already shows this for security (misuse cases), safety and context-aware systems.
14. **[Critical]** Evaluate the survey: self-assessed Likert answers, 29 respondents mostly programmers, short introduction, no use of the tool, perceived (not measured) understandability. Why might people *without* modelling experience rate it higher? What controlled experiment would you design?
15. **[Critical]** Use-case diagrams scale badly (Fig. 9 is already crowded). How would modularisation (packages) or splitting per actor help, and does that hurt the "one diagram for everyone" goal?

---

## 6. Cross-paper questions (any paper can trigger them)

- Compare the three ways of extending a language: **import a vocabulary** (BPMN→SBVR), **define a new DSL** (Context Mapper), **add metaclasses to UML** (game). When is each appropriate?
- Each paper pairs a graphical and a textual concrete syntax. Which direction does each generate (text from diagrams, diagrams from text, text attached to diagrams), and why?
- Where does each paper sit on the formality spectrum OCL → SBVR → CML → free-text templates, and is that the right choice for its readers?
- In all three, output quality depends on input-model quality. Which well-formedness rules does each need, and where should they be enforced (metamodel, grammar, OCL, tool)?
- Tool choice: commercial CASE plug-in (MagicDraw), Eclipse/Xtext/EMF, custom Unity web tool. Argue which is most sustainable for researchers and for industrial adoption.
- Evaluation quality: benchmark by the authors, action research by the authors, small online survey. Which is weakest and why?

---

## 7. Study plan (suggested)

1. Learn the **metamodel-based transformation pattern** and the **M0–M3 tower** until you can draw both from memory. They are useful for every paper.
2. For each paper, practise the **object diagram** (section "Drawings to practise") on paper, by hand, within ~10 minutes.
3. For each paper, write a half-page answer to its Q3 and Q5 questions in your own words, then compare with [connections.md](connections.md).
4. Prepare one **alternative technology** argument (Q7) and one **generalisation** (Q8) per paper with a concrete second domain.
5. Prepare two **critical remarks** per paper (the "[Critical]" questions above).
6. Decide which book you bring and tab the chapters on metamodelling, transformations (classification, ATL/QVT), DSLs and M2T. Brambilla, Cabot & Wimmer is the recommended one.
