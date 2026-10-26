# Model answers to the questions in exam-prep.md

Every question from [exam-prep.md](exam-prep.md) with a worked answer. The answers use the paper's own names (rule numbers, listings, figures), because the examiners want to see MDE applied to the paper, not recited.

> **Use these to learn the argument, not the wording.** The exam ignores text copied from the paper, the book or the slides, and the same applies to anything memorised from here. Practise saying each answer in your own words.

Where an answer depends on my interpretation rather than on something the paper states, it says so. OCL and transformation code are sketches; metamodel names follow the real standards where possible.

---

## Paper 1: BPMN → SBVR process rules

### P1.1 [Q1] Why is MDE a good fit for keeping process models and business rules consistent? Why does the paper treat this as a model transformation rather than plain NLP text generation?

**Answer.** The problem is that the same business knowledge exists twice: as a BPMN diagram (for analysts) and as natural-language rules (for business people, who prefer text). Maintained by hand, the two drift apart.

MDE fits because:
- **Both sides have metamodels.** BPMN and SBVR are OMG standards defined in MOF, so each has a precise abstract syntax. The correspondence can be defined **once, at metamodel level** (rules T1–T9) and then applied to *any* process model.
- **Automation gives consistency.** When the diagram changes, the rules are regenerated instead of rewritten, which removes manual effort and copy errors.
- **Two concrete forms for two audiences.** The graphical BPMN view and the textual SBVR view present the same knowledge, and each reader picks the form that suits them.
- **Integration.** Diagram, vocabulary and rules live in one MagicDraw project, linked by the transformation. That is a small digital thread, and it ties the process rules to the rest of the company's business vocabulary.

**Why a model transformation and not NLP generation:** generating sentences from diagram labels with NLP produces *free text*, which is ambiguous and can't be processed further. Here the target is an **SBVR model**. SBVR is a controlled language with a formal (logic-based) meaning, so the output is itself a model: it can be validated, queried, transformed further (to OWL, SQL, UML) or transformed back into BPMN. The *structure* of each rule comes from the *structure* of the source model (flows, gateways, lanes), which is reliable. NLP would only be needed for the text inside labels, and the related work shows NLP in business-process management is still unreliable.

*Critical note:* the approach is only as good as its input. Badly named or badly structured diagrams still give bad rules.

### P1.2 [Q2] What are the scope and preconditions of the approach? What happens if a BPMN model violates them?

**Answer.**

**Scope**
- Only **process rules**: behavioural rules about the flow of work. Structural rules and other kinds of business rules are excluded.
- Only a **BPMN subset**: pools/lanes, start/intermediate/end events, interrupting and non-interrupting boundary events, activities, exclusive/inclusive/event-based/parallel gateways, data objects, data stores, messages, message flows, and sequence flows with or without conditions. The **complex gateway** is excluded because it can't be interpreted automatically.
- The **vocabulary is assumed to exist** already (Stage 1, published earlier).
- Unidirectional; grammar and NLP issues are ignored; the tool is a lab prototype (TRL 4).

**Preconditions on the input model**
1. Participants must be modelled as **pools/lanes**. They become the subjects of the verb concepts ("**provider** analyzes order").
2. **Every element must be named.**
3. **Full conditions go on the outgoing sequence flows** ("order has extra conditions"), not as a question on the gateway with yes/no labels on the branches.

**If they are violated:**
- Without a lane there is no subject, so no verb concept and no rule.
- Without names the rules are invalid.
- With yes/no labels you get meaningless rules such as "… and if yes".

The authors saw exactly this: the original models produced invalid or missing rules, so they refactored them by hand before the experiment.

**Improvement:** check the preconditions **before** running the transformation, as OCL invariants on the BPMN metamodel. The implicit assumptions then become an explicit contract of the transformation:

```ocl
context Activity inv InLane:
  self.lanes->notEmpty()

context FlowNode inv Named:
  self.name <> null and self.name.size() > 0

context ExclusiveGateway inv ConditionsOnBranches:
  self.outgoing->size() > 1 implies
    self.outgoing->forAll(f | f <> self.default implies f.conditionExpression <> null)
```

### P1.3 [Q3] Describe the transformation chain of Fig. 1. Identify source and target models and metamodels, the transformation definitions, the language, the engine, and the manual steps.

**Answer.**

```
BPMN model ──► Stage 1 (auto) ──► vocabulary ──► Stage 2 (auto) ──► process rules ──► Stage 3 (manual)
   │           1.1 noun concepts   in SBVR model    2.1 T1–T9 + Alg. 1–2  in SBVR model     validation
   │           1.2 verb concepts        ▲                │
   │                                    └─── reads ──────┘
   └──► M2T ──► SBVR Structured English text ──► VeTIS editor
```

| Element | In this paper |
|---|---|
| Source model | A BPMN process model, e.g. "Order Registration" (Fig. 5) |
| Source metamodel | BPMN 2.0; in MagicDraw realised as UML + a BPMN profile |
| Target model | An SBVR model: vocabulary (noun and verb concepts, Table 2) + process rules (Table 3); plus Structured English text |
| Target metamodel | SBVR; in MagicDraw a UML profile for SBVR (fact diagrams) |
| Transformation definitions | Stage 1 rules (earlier papers); Stage 2: nine rules `Ti : PPi → RPi` (a BPMN pattern mapped to an SBVR rule pattern written in EBNF) + Algorithms 1–2 for cascading gateways |
| Language | QVT |
| Engine | The QVT engine provided by the Model Integrator plug-in in MagicDraw; the transformations are started from the context menu |
| Intermediate model | The vocabulary: output of Stage 1, input of Stage 2 |
| Manual step | Stage 3: a business analyst validates the SBVR model (optional) |
| Extra output | An M2T component produces Structured English text for the external VeTIS editor |

The stages are **sequential with a data dependency**: rules are built on facts (verb concepts), and facts on terms (noun concepts). The authors classify the whole thing as deterministic, hybrid, exogenous, horizontal and one-to-one (see P1.4).

### P1.4 [Q3, critical] The authors classify the transformation as exogenous, horizontal, one-to-one and hybrid. Discuss each label. Do you agree?

**Answer.**
- **Exogenous** (source and target metamodels differ). *Conceptually yes*: BPMN and SBVR are different languages. *At implementation level it's debatable*: in MagicDraw both are realised as **UML profiles**, so source and target conform to the same UML metamodel, and the transformation is technically UML → UML. The label depends on which metamodel you look at.
- **Horizontal** (no change in abstraction level). *Agree.* Both models describe the same flow of work at business (CIM) level, and no design or platform decisions are added. The authors even claim the rules contain enough to reconstruct the process, which supports "horizontal".
- **One-to-one** (one source model, one target model). *Debatable.* Fig. 1 shows that Stage 2 reads the BPMN model **and** the vocabulary already in the SBVR model, then writes rules into that same model. In practice it is **two inputs → one output (N-to-1)**, or an in-place update of the SBVR model with BPMN as an extra input.
- **Hybrid** (declarative + imperative). *Agree.* T1–T9 are declarative pattern rules (source pattern → target pattern), but they depend on elements created by other rules. The cascading-gateway handling is an imperative, recursive algorithm.

**Conclusion:** the classification is reasonable at the conceptual level, but "one-to-one" ignores the vocabulary input, and "exogenous" only holds for the conceptual metamodels, not for the tool.

### P1.5 [Q3] How would you implement T1 (or T2, or T5) in QVTo or ATL? Which part is the source pattern, which is the guard, and how do you reach the verb concepts created in Stage 1?

**Answer.** T1 maps "a sequence flow between two non-gateway nodes" to "It is obligatory that *target* after *source* [and if *condition*]".

- **Source pattern:** a `SequenceFlow` with its `sourceRef` and `targetRef` (and the lane of each node).
- **Guard:** neither end is a `Gateway` (gateways are handled by T2–T5 and the cascading algorithm).
- **Target pattern:** a `ProcessRule` with modality *obligatory*, connective *after*, consequent = the verb concept of the target node, antecedent = the verb concept of the source node, and optionally the condition.

In QVTo, over a simplified target metamodel, with the SBVR model as `inout` because Stage 2 adds to the existing vocabulary:

```
modeltype BPMN uses 'http://www.omg.org/spec/BPMN/20100524/MODEL';
modeltype SBVR uses 'http://example/sbvr-processrules';   -- simplified, illustrative

transformation Bpmn2ProcessRules(in bpmn : BPMN, inout sbvr : SBVR);

main() {
  bpmn.objectsOfType(SequenceFlow)->map toObligation();
}

mapping SequenceFlow::toObligation() : ProcessRule
  when { not self.sourceRef.oclIsKindOf(Gateway) and
         not self.targetRef.oclIsKindOf(Gateway) }
{
  modality   := Modality::OBLIGATORY;
  connective := Connective::AFTER;
  consequent := self.targetRef.verbConcept();
  antecedent += self.sourceRef.verbConcept();
}

-- Stage 1 already created the verb concepts; find the one made from this node
query FlowNode::verbConcept() : VerbConcept =
  sbvr.objectsOfType(VerbConcept)->any(v | v.sourceElementId = self.id);
```

**Reaching the Stage 1 verb concepts:**
- **Stage 1 in a separate run** (as in the paper): look them up in the SBVR model with a query, using the meta-information that links each concept to its BPMN element (`sourceElementId` above is illustrative).
- **Stage 1 in the same transformation:** use the trace, e.g. `self.targetRef.resolveoneIn(FlowNode::toVerbConcept, VerbConcept)`.
- **In ATL:** a matched rule `from s : BPMN!SequenceFlow (guard) to r : SBVR!ProcessRule (consequent <- s.targetRef, …)`. ATL's automatic trace resolution turns `s.targetRef` into the VerbConcept created from that node by another rule in the same module.

**For T5 (parallel gateway):**
- *Diverging:* one mapping per outgoing flow, each giving an obligation "branch target after the node before the gateway".
- *Converging:* one rule whose antecedent is the *set* of nodes before the gateway, rendered with "and".

The EBNF rule patterns RPi are really text templates, so the textual output would naturally be an Acceleo template.

### P1.6 [Q4] Draw the instance of the BPMN metamodel and of the SBVR metamodel for a fragment of Fig. 5 (e.g. the parallel gateway) and show which rule creates which target elements.

**Answer.** Fragment: *order estimate is approved* → parallel split → *schedule order production* and *schedule order delivery date* (lane *provider*) → parallel join → *order is ready for production*.

**BPMN side** (instances of BPMN 2.0 metaclasses):

```
provider : Lane {name = "provider"}       flowNodeRefs = {t1, t2}
e1 : IntermediateCatchEvent {name = "order estimate is approved"}
g1 : ParallelGateway {gatewayDirection = Diverging}
t1 : Task {name = "schedule order production"}
t2 : Task {name = "schedule order delivery date"}
g2 : ParallelGateway {gatewayDirection = Converging}
e2 : EndEvent {name = "order is ready for production"}
f1 : SequenceFlow  sourceRef = e1  targetRef = g1
f2 : SequenceFlow  sourceRef = g1  targetRef = t1
f3 : SequenceFlow  sourceRef = g1  targetRef = t2
f4 : SequenceFlow  sourceRef = t1  targetRef = g2
f5 : SequenceFlow  sourceRef = t2  targetRef = g2
f6 : SequenceFlow  sourceRef = g2  targetRef = e2
```

**SBVR side** (over a simplified process-rule metamodel, my sketch):

```
provider : NounConcept      order : NounConcept   ...
vc1 : VerbConcept {"order estimate is approved"}
vc2 : VerbConcept {"provider schedules order production"}     roles → provider, order production
vc3 : VerbConcept {"provider schedules order delivery date"}  roles → provider, delivery date
vc4 : VerbConcept {"order is ready for production"}

r1 : ProcessRule {modality = obligatory, connective = after}  consequent = vc2  antecedent = {vc1}
r2 : ProcessRule {modality = obligatory, connective = after}  consequent = vc3  antecedent = {vc1}
r3 : ProcessRule {modality = obligatory, connective = after}  consequent = vc4  antecedent = {vc2, vc3}  ("and")
```

**Which rule created what (trace):**
- `vc1`–`vc4` and the noun concepts come from Stage 1 (1.1, 1.2), from `e1, t1, t2, e2` and the lane.
- **T5, diverging**, applied at `g1`, creates `r1` and `r2`: "It is obligatory that provider schedules order production after order estimate is approved", and the same for the delivery date.
- **T5, converging**, applied at `g2`, creates `r3`: "It is obligatory that order is ready for production after provider schedules order production and provider schedules order delivery date".
- (The data object *order [scheduled]* produced by `t1` would add a T7 rule: "It is obligatory that scheduled order is produced when provider schedules order production".)

Note that the gateways `g1`, `g2` have **no counterpart object** in SBVR. They are compiled into the modality and the "and".

### P1.7 [Q5] Place every artefact of the paper on M0–M3.

**Answer.**

| Level | Artefacts |
|---|---|
| **M3** | MOF |
| **M2** | BPMN 2.0 metamodel; SBVR metamodel; QVT metamodel. In the tool: the UML metamodel with the BPMN and SBVR profiles |
| **M1** | The Order Registration BPMN model; the SBVR vocabulary and process rules; **the QVT transformation definition** (an M1 model conforming to the QVT metamodel); the BPMN vocabulary written in SBVR |
| **M0** | The real order handling: customers sending orders, the provider analysing them, and so on |

The relations: each M1 model **conforms to** its M2 metamodel, every metamodel conforms to MOF, MOF conforms to itself, and the M1 models **represent** the M0 process.

**Two subtleties worth mentioning:**
- **The BPMN vocabulary is a model of a model.** It conforms to SBVR (so it sits at M1), but its subject is the BPMN *metamodel* (M2).
- **SBVR describes itself.** Its own concepts are defined as an SBVR vocabulary, much as MOF is defined in MOF. That is how the tower stops.

### P1.8 [Q5] Where is this work in MDA? Is SBVR a CIM, a PIM or neither? Could the generated rules feed a PIM?

**Answer.** The CIM describes the business independently of any automated support. Both models here are CIM:
- the BPMN process is a descriptive business model (not an executable BPMN for a workflow engine);
- the SBVR vocabulary and rules describe business knowledge in business terms.

So the transformation is **CIM → CIM**, i.e. horizontal. MDA mostly emphasises the vertical path CIM → PIM → PSM; this paper instead **enriches the CIM** with a second, textual view.

**The rules could feed a PIM.** SBVR specifications have been transformed into UML class diagrams and use-case models, OWL ontologies and SQL (refs 30–32). Process rules could become PIM-level behaviour, for example:
- pre/post-conditions (OCL) on the operations of a service,
- UML activity diagrams or state machines,
- input for a rule engine (which would already be PSM).

The paper itself mentions using the rules for **requirements specification**, which is the usual starting point for a PIM.

*Nuance:* BPMN can also be used at PSM level, as executable process models for engines such as Camunda. In this paper it isn't.

### P1.9 [Q6] What else can be done with the produced SBVR model or with the BPMN vocabulary?

**Answer.**
1. **Requirements specification.** The rules are a textual, validated statement of what the process must do (the paper suggests this).
2. **Work instructions and documentation** for the people performing the process.
3. **Further transformations from SBVR:** to OWL ontologies, SQL constraints or UML models (related work, refs 29–32), linking business rules to IT artefacts.
4. **Compliance checking.** Deontic rules describe how the *real* process (M0) should behave, so event logs of real executions can be checked against "obligatory B after A" to find violations.
5. **Reverse transformation SBVR → BPMN** (future work). The authors claim the rules plus a vocabulary enriched with BPMN types allow rebuilding the process. Refs 42–46 work in that direction, one of them co-authored by the course teacher.
6. **Merging** the process vocabulary with the company's existing business vocabulary, so static and dynamic knowledge live in one SBVR specification (future work).
7. **The BPMN vocabulary itself** can be reused by any SBVR project to talk about processes, or to transform other process notations into SBVR (e.g. UML activity diagrams, see P1.13).

### P1.10 [Q7] Re-engineer the solution with the course stack. What do you gain and lose compared with MagicDraw?

**Answer.** **Architecture:**
- **Metamodels:** the Eclipse BPMN2 project provides BPMN 2.0 as an Ecore metamodel. SBVR needs an Ecore metamodel too: an existing one, or a simplified process-rule metamodel like the one in P1.6.
- **Preconditions:** OCL invariants on BPMN (see P1.2), checked before the transformation runs.
- **M2M:** T1–T9 as ATL matched rules or QVTo mappings. The cascading-gateway algorithm becomes a recursive helper/query. The "add to the existing vocabulary" behaviour fits QVTo `inout` or ATL refining mode.
- **M2T:** Acceleo templates for the Structured English text. The EBNF rule patterns translate almost directly into templates.
- **Editors:** an **Xtext** grammar for SBVR Structured English, so the rules can also be *parsed back* into the model (round trip). Optionally Sirius for fact diagrams.

**Gains**
- Open source, no licence.
- Standard Ecore/XMI interchange.
- Transformations that can be tested and versioned.
- Reuse of the whole ecosystem (validation, comparison, other transformations).
- Easier for other researchers to reproduce.

**Losses**
- MagicDraw's mature BPMN editor and diagram quality.
- The authors' existing SBVR profile, the VeTIS editor and its WordNet support.
- Porting effort: MOF/profile-based definitions must be flattened to Ecore (CMOF features such as subsets are lost).
- Business users may find Eclipse less approachable.

**Verdict:** for research and reproducibility the Eclipse stack is better. For a company that already uses MagicDraw/Cameo, the plug-in fits better.

### P1.11 [Q7, modelling] Why did they import a BPMN vocabulary instead of extending the SBVR metamodel? Compare with the game paper.

**Answer.** SBVR on its own can't express BPMN concepts (gateways, lanes…). The authors had two options:

**Option 1: extend the SBVR metamodel** (new M2 metaclasses). They reject it for three reasons:
- the extension must be re-applied for **every new version** of the standard;
- you risk being **"closed in your own sandbox"**, because others won't accept a modified standard;
- **tool support** for metamodel-level extensions is limited.

**Option 2: write a BPMN vocabulary in SBVR** (an M1 model) and **import** it, which is SBVR's normal way of reusing vocabularies. This is what they chose. The metamodel stays standard, so any SBVR tool understands the result.

**The cost of option 2:** the meaning of "gateway" or "task" is no longer enforced by the metamodel's structure (types, multiplicities). It is just a term with a definition, so correctness depends on the transformation and on conventions. And the paper doesn't actually show this vocabulary.

**Compared with the game paper:** it takes the heavyweight route, adding new metaclasses to the UML metamodel, although nothing in its extension needs more than a UML profile. The BPMN authors' arguments apply directly. GUCM models can't be used in standard UML tools, so the authors had to build their own tool.

**The general rule:** use the **lightest mechanism that can express what you need**. From lightest to heaviest:
1. a library or vocabulary inside the language (M1),
2. a profile (stereotypes on existing metaclasses),
3. new metaclasses (M2 change),
4. a new language.

### P1.12 [Q7, alternative target] Could a formal declarative process language (e.g. Declare/LTL) be a better target than SBVR? What would be lost?

**Answer.** **Declare** describes a process as a set of constraints on activities, built from templates with a formal meaning in **linear temporal logic (LTL)**. The SBVR rules map onto its templates quite well:
- "obligatory B after A" ≈ **response(A, B)** or **succession**;
- "permitted B only if A" ≈ **precedence(A, B)**;
- a prohibition ≈ **not-succession**.

**Gains:**
- **Precise temporal semantics.** SBVR's "after" is a word, not a temporal operator.
- **Automatic verification** (model checking, finding conflicting constraints).
- **Automatic compliance checking** against event logs.
- Constraint models can even be **executed**.

**Losses:**
- **Readability for business people**, which is the paper's whole motivation. LTL formulas and Declare diagrams are not something a manager validates.
- The link to the **business vocabulary** (terms, facts).
- The **deontic nuance**. Declare constraints are simply "must"; there is no explicit permission, because everything not constrained is allowed.
- It is not an OMG standard alongside BPMN.

**My conclusion:** don't *replace* SBVR. Add Declare as a **second exogenous target**, either from BPMN or from the SBVR rules: SBVR for people, Declare for machines.

### P1.13 [Q8] Generalise to UML activity diagrams, EPCs, Petri nets, or another controlled language. Which parts change and which stay?

**Answer.**

**What changes: the source metamodel and the source patterns PPi.**
- **UML activity diagrams** (the paper suggests this) map almost one-to-one:

  | BPMN | UML activity diagram |
  |---|---|
  | lane | ActivityPartition |
  | exclusive gateway | DecisionNode / MergeNode |
  | parallel gateway | ForkNode / JoinNode |
  | data object | ObjectNode / ObjectFlow |
  | intermediate event | AcceptEventAction |

  T1–T9 are rewritten against those metaclasses, and Stage 1 is adapted.
- **EPCs:** events and functions alternate; XOR/OR/AND connectors map to T2/T3/T5; organisational units play the role of lanes.
- **Petri nets** generalise badly: no participants (so no subjects for verb concepts), no data objects, and labels without business meaning.

**What stays:**
- the overall scenario of Fig. 1 (vocabulary first, then rules, then validation);
- the **target side**: the rule patterns RPi and the SBVR metamodel;
- the logic for choosing modality ("a choice point gives permission; a mandatory step gives obligation");
- the backward-chaining idea for cascades.

**Another target language:**
- **Another controlled language** (e.g. RuleSpeak, or Structured English in another natural language) changes the **target side and the templates**.
- **Lithuanian**, for example, needs morphology (declension), so NLP becomes unavoidable.

**The reusable idea:** a *catalogue of patterns PPi → RPi* between two metamodels, kept separate from the engine that applies them.

### P1.14 [Critical] The evaluation says the output "fully matched the benchmark". What does that actually prove?

**Answer.** How the benchmark was built:
- **The authors themselves** extracted the rules **by hand from the same 32 models, applying the same rules T1–T9** and the cascading algorithm.
- The three sets were reconciled into one.
- The models were **hand-picked from the internet and refactored first** to satisfy the preconditions.

**What it shows:** the **implementation matches the specification**. It is a correctness test of the QVT code (verification), and also shows the rules cover every flow in those models.

**What it does *not* show:**
1. **That the rules are correct or useful.** Whether the modalities chosen are right, and whether business people understand the text better than the diagram, was never tested.
2. **That it works on real models.** Unmodified industrial models were not used; invalid ones gave missing rules and were excluded.
3. **That it generalises.** 32 small models, selected by the authors (they acknowledge this).
4. **Grammatical quality.** It was explicitly ignored.

**A stronger evaluation would:**
- have **independent** experts write the benchmark without seeing T1–T9, and measure precision and recall on **unmodified** models;
- run a **user study** where business people validate processes from the text vs the diagram, measuring errors found and time;
- run a **round trip** BPMN → SBVR → BPMN, to test whether information is preserved.

### P1.15 [Critical] SBVR rule sets are unordered, but a process is about order. Can the rule set really represent the process? What extra information does that need?

**Answer.** The paper itself says SBVR rules are, by definition, unordered (Table 3 is ordered only for readability). The order is **not lost**, though: it is encoded **inside each rule** through "after" and "when", which link two verb concepts. The rule set is effectively a list of the process graph's edges, and from the edges you can rebuild the graph. So in principle the flow can be recovered.

What is lost or ambiguous **without extra information**:
1. **The gateways disappear.** They are compiled into modality and connectives. You must infer the gateway type from them, and that is ambiguous:
   - *permitted* comes from both an unconditioned exclusive branch (T2) and an event-based gateway (T4);
   - *obligatory … and if* comes from both exclusive and inclusive gateways.
2. **Node types:** whether "order estimate is sent" was a task or an event, a send task or a manual task.
3. **Layout and lane order**, which carry no meaning.

That is why the authors say the reverse transformation needs the **vocabulary enriched with BPMN concept types** (the meta-information on each concept).

**Conclusion:** the rules plus that enriched vocabulary are close to lossless for the covered subset; the rules alone are lossy. In MDE terms, the question is whether the transformation is **information-preserving** (invertible). Only a round-trip experiment would show that.

---

## Paper 2: Context Mapper

### P2.1 [Q1] Why does a DSL plus model transformations help with service decomposition? What does MDE add over drawing context maps on a whiteboard?

**Answer.** The problem: splitting a system into services is hard. The strategic DDD patterns help, but practitioners interpret them differently, and context maps drawn by hand differ from person to person and are tedious to keep up to date.

**What the DSL adds:**
- **Precise meaning.** The metamodel (Fig. 2) fixes which relationship types exist and which roles belong to which side. The semantic rules (validators) forbid invalid combinations. This is hypothesis 1: a precise interpretation of the patterns.
- **Small abstraction gap.** CML's keywords *are* the DDD vocabulary (BoundedContext, `[U,OHS,PL]->[D,CF]`), so DDD practitioners read it as their own language.

**What MDE adds over a whiteboard:**
- **Validation:** the tool detects inconsistent maps, e.g. ACL on the upstream side.
- **Several views from one model:** graphical context maps and UML/PlantUML are generated, so they are always consistent with each other.
- **Cheap evolution** (hypothesis 2):
  - transformations automate tedious steps (entities and operations from use cases, frontend/backend split);
  - refactorings (split/merge) keep references consistent, where a drawing would have to be redone.
- **Code generation** (JHipster) gives a running prototype quickly.
- **Text under version control:** models can be diffed and merged in git.

**Where the whiteboard is still better:** early brainstorming with stakeholders. The workshop architects warned that a tool must not replace talking to users.

### P2.2 [Q2] What is the scope of Context Mapper and of the rapid-prototyping chain? What does it explicitly not do?

**Answer.**

**Covers**
- Strategic DDD: domains, subdomains, bounded contexts, context maps and all relationship patterns.
- Tactical DDD inside aggregates (syntax borrowed from Sculptor).
- **New in this paper:** user stories and use cases as input.
- Three new transformations (requirements → subdomain → Feature context → System contexts) plus "split into subsystems"; the Architectural Refactorings (described in another paper); generators (only mentioned).

**Intended for:** early project stages, teaching, and architects who already know DDD, working iteratively.

**Does not**
- **Replace human design.** "The transformations do not aim at replacing human design work": the user chooses the grouping and refines the `TODO`s.
- Design *Application* contexts. That stays manual (it needs creativity).
- Find good boundaries automatically. That is future work (Service Cutter).
- Reverse-engineer code into models, or round-trip.
- Replace business analysis, conversations with users, or real coding (workshop conclusion).
- Cover code generation in this paper.

**Implicit requirement:** requirements must be written in the structured syntax (`"verb" a "Entity" with its "attr" for a "Other"`), and an IDE with CML support is needed.

### P2.3 [Q3] Describe the transformation chain from use case to subsystems. For each step give input, output, cardinality, information added, and who decides.

**Answer.**

| Step | Input → output | Cardinality | Information added | Who decides |
|---|---|---|---|---|
| (0) | — → use cases / user stories | — | Requirements in structured syntax | Modeller (manual) |
| **1** | Selected use cases → **Subdomain** | **N→1** | Entities with attributes and references, one Service with one operation per interaction (`submitClaim`…), vision statement from `benefit` | User picks which use cases go together |
| **2** | Selected subdomains → **Bounded Context, type FEATURE** | **N→1** | One Aggregate per subdomain, IDs (`ClaimId`), parameter and return types, `TODO` hints, `implements` link | User picks which subdomains form one context |
| (manual) | Feature → **Application** context | 1→1 | Design decisions | Modeller |
| **3** | Feature/Application context → **two System contexts** + a context map | **1→2** | Frontend (Angular, ViewModel aggregate) and backend (Spring Boot, aggregate); relationship `Backend [PL]->[CF] Frontend`, "RESTful HTTP", `exposedAggregates` | Automatic |
| **4..N** | One System context → two | **1→2** | Deployment units / tiers (e.g. logic + database) | User picks what to split |
| ARs | Any context or aggregate → refactored model | split 1→2, merge 2→1, extract | Restructuring at the same level | User |
| M2T | Context model → JHipster microservice per context, diagrams | 1→N files | Implementation code | Automatic |

Worked example: Cockburn's "Get paid for car accident" (Listing 5.1) → Subdomain `ClaimsManagement` (5.2) → Feature context (5.3) → backend and frontend System contexts (5.4).

### P2.4 [Q3, critical] Classify the transformations. They are all endogenous but move from analysis to design to deployment. Are they vertical or horizontal? How can a vertical transformation be endogenous?

**Answer.** **Every step is endogenous:** each reads and writes CML models conforming to the same CML metamodel.

**Steps 1–4..N are vertical**, because each adds detail and goes down in abstraction:
- requirements → domain model (step 1, borderline: both are still business level);
- domain → software decomposition (step 2, CIM → PIM);
- logical → physical (step 3, PIM → PSM, adding technologies and tiers).

The **Architectural Refactorings are horizontal**: they restructure at the same level.

**Endogenous and vertical at once** works because the two classifications measure different things:
- endo/exo asks whether the **metamodel** changes;
- horizontal/vertical asks whether the **abstraction level** changes.

CML **encodes the abstraction level inside the model**, through the context `type` (FEATURE, APPLICATION, SYSTEM) and `implementationTechnology`. One language can therefore hold every level, and refinement happens within M1 without switching languages.

*Critical remark:* the language allows mixing levels. Listing 4.2 shows a FEATURE context that already has `implementationTechnology`. Nothing in the metamodel stops PSM information from appearing in a "PIM" model, so the separation of levels relies on discipline.

### P2.5 [Q3] Does "semi-automatic" fit the course definition of a model transformation? How are the user's choices captured, and how is traceability kept?

**Answer.** The course defines a model transformation as target models **automatically generated** from source models according to a transformation definition.

- **Each individual step fits.** Once the user has selected the inputs (which use cases, which subdomains), the output follows deterministically from the transformation definition.
- **The chain as a whole is interactive**:
  - the user supplies parameters (the selection);
  - between steps the user edits the models by hand (resolving `TODO`s, turning a Feature context into an Application context);
  - Application design is entirely manual.

So it is a **chain of automatic transformations with human decisions in between**. That is common in practice and deliberate here, since the authors want to support design, not replace it.

**How the user's choices are captured:** only implicitly, in the **shape of the output** (which entities ended up in which subdomain, which subdomains in which context). There is no separate record of the decisions. Re-running a step means selecting again.

**Traceability:**
- **explicit** links in the model: `BoundedContext X implements Subdomain Y`, and `exposedAggregates` on relationships;
- Listing 5.2 shows **no link from the subdomain back to the use case** (only the vision statement copied from `benefit`).

*Critical point:* manual edits plus no round-tripping means that if a use case changes, re-running a step may duplicate or lose the refinements. The workshop flagged synchronising manual and generated steps as critical for adoption.

### P2.6 [Q4] Draw the instance of Fig. 2 for Listing 4.3.

**Answer.** Listing 4.3:

```
ContextMap {
  contains CustomerManagementContext, PolicyManagementContext
  CustomerManagementContext [U,OHS,PL]->[D,CF] PolicyManagementContext {
    implementationTechnology = "RESTful HTTP"
  }
}
```

Object diagram (instances of the Fig. 2 metaclasses):

```
map : ContextMap
 ├── shows all relevant ──► cm : BoundedContext {name = "CustomerManagementContext"}
 ├── shows all relevant ──► pm : BoundedContext {name = "PolicyManagementContext"}
 └── shows relationships ─► rel : GenericUpstreamDownstreamRelationship

rel ── upstream ─────────► cm
rel ── downstream ───────► pm
rel ── Upstream has ─────► ohs : OpenHostService      (an UpstreamRole)
rel ── Upstream has ─────► pl  : PublishedLanguage    (an UpstreamRole)
rel ── Downstream has ───► cf  : Conformist           (a DownstreamRole)
```

Points to make while drawing:
- The arrow `->` in the text is **concrete syntax**. In the instance, direction is stored in the `upstream` and `downstream` links. `PolicyManagementContext [D,CF]<-[U,OHS,PL] CustomerManagementContext` would produce **the same** object diagram.
- `implementationTechnology = "RESTful HTTP"` **has no place in Fig. 2**. The grammar (and its generated Ecore) contains more than the published metamodel.
- For Listing 4.9 (`SelfServiceContext [D,C,ACL]<-[U,S,PL] CustomerMgmtContext`), `rel` would be a **CustomerSupplierRelationship**, with an `AnticorruptionLayer` downstream role.

### P2.7 [Q4, critical] Fig. 2 models Subdomain kinds as subclasses and roles as classes, but CML writes `type = CORE_DOMAIN` and roles as keywords. What does that tell you about the conceptual metamodel vs the Ecore metamodel Xtext generates?

**Answer.** **Fig. 2 is a conceptual metamodel** drawn as a UML class diagram, i.e. documentation of the authors' interpretation of DDD. **The metamodel the tool actually runs on is the Ecore model Xtext generates from the CML grammar:**
- each parser rule becomes an `EClass`;
- each assignment becomes an attribute or reference;
- each enum rule becomes an `EEnum`.

The syntax `type = CORE_DOMAIN` and the role keywords suggest that subdomain kind and roles are **enumeration values** there, not subclasses. (This is inferred from the syntax; the paper doesn't show the grammar.)

Lessons:
1. **The same concept can be modelled in several ways.** Subclasses vs an enumeration attribute:
   - *Subclasses* allow kind-specific attributes and constraints enforced by typing.
   - *An enumeration* is simpler and **allows reclassification**: a supporting subdomain can become core without replacing the object (an EMF object can't change its class).
2. **In a grammar-first Xtext workflow, the concrete syntax shapes the abstract syntax.** The course warns that "metamodel or syntax reengineering may be needed".
3. **When asked "what is the M2 here?", be precise:** the published Fig. 2, or the Ecore the tool runs. They are semantically close but structurally different.

### P2.8 [Q4/OCL] Write OCL constraints that (a) upstream roles are UpstreamRoles, (b) downstream roles are DownstreamRoles, (c) a relationship is not between a context and itself, (d) every context in a relationship is contained in the map. Which could the grammar enforce instead?

**Answer.** (Role end names `upstreamRoles` and `downstreamRoles` stand for Fig. 2's "Upstream has" and "Downstream has".)

```ocl
context UpstreamDownstreamRelationship
inv UpstreamRolesOnly:   self.upstreamRoles->forAll(r | r.oclIsKindOf(UpstreamRole))
inv DownstreamRolesOnly: self.downstreamRoles->forAll(r | r.oclIsKindOf(DownstreamRole))
inv NotSelf:             self.upstream <> self.downstream

context SymmetricRelationship
inv NotSelf: self.participant1 <> self.participant2

context ContextMap
inv RelatedContextsContained:
  self.relationships->forAll(r |
    (r.oclIsKindOf(UpstreamDownstreamRelationship) implies
       self.boundedContexts->includesAll(Set{
         r.oclAsType(UpstreamDownstreamRelationship).upstream,
         r.oclAsType(UpstreamDownstreamRelationship).downstream}))
    and
    (r.oclIsKindOf(SymmetricRelationship) implies
       self.boundedContexts->includesAll(Set{
         r.oclAsType(SymmetricRelationship).participant1,
         r.oclAsType(SymmetricRelationship).participant2})))
```

**Grammar vs constraint:**
- **(a), (b): the grammar can enforce these.** The upstream bracket accepts only an enum of upstream roles (OHS, PL), the downstream bracket only downstream roles (ACL, CF). A wrong role is then a *syntax* error.
- **(c): needs a validator or OCL.** A context-free grammar can't compare two references.
- **(d): can be enforced by Xtext *scoping*.** Only offer the contexts listed after `contains` as valid targets of a relationship. Otherwise use a validator.
- **ACL together with CF** (a contradiction, see P2.6) is already excluded **structurally** if "Downstream has" is 0..1 as drawn in Fig. 2. If the grammar allows a list of downstream roles, it needs a validator.

### P2.9 [Q5] Place on M0–M3 and relate the abstraction levels to MDA. Why are these not meta-levels?

**Answer.**

| Level | Artefacts |
|---|---|
| **M3** | Ecore |
| **M2** | CML metamodel: conceptually Fig. 2, technically the Ecore generated by Xtext. The **Xtext grammar** belongs here too, as the definition of the concrete syntax |
| **M1** | `insurance.cml`: the use case `Get_paid_for_car_accident`, Subdomain `ClaimsManagement`, the bounded contexts and the context map |
| **M0** | The real insurance company: its claims process, its software systems and the teams that build them |

**Abstraction levels mapped to MDA** (my reading; the paper doesn't use these terms):

| MDA | Context Mapper |
|---|---|
| CIM | use cases, user stories, subdomains |
| PIM | FEATURE / APPLICATION context |
| PSM | SYSTEM contexts with `implementationTechnology` |
| code | JHipster output |

**Why these are not meta-levels:** all those models are at **M1** and conform to the **same metamodel**. Meta-levels describe *conformance* (a model is written in the language of the level above). Abstraction levels describe *detail* (how many design and platform decisions a model contains). A vertical transformation changes the level of detail and stays at M1.

### P2.10 [Q6] What else can be built on the CML metamodel?

**Answer.**
1. **Visualisations:** graphical context maps, UML/PlantUML class and component diagrams. These already exist and give different views for different audiences.
2. **Code generation:** a microservice skeleton per context (JHipster), or other platforms.
3. **API contracts:** the authors generate service contracts from CML in a separate paper.
4. **Automatic decomposition suggestions** in the style of Service Cutter: compute coupling and cohesion from entity usage and propose a better context map (future work).
5. **Architecture metrics:** number of relationships per context, conformist dependencies, shared kernels, to spot risky coupling.
6. **Organisational analysis:** TEAM contexts plus relationships give a picture of team dependencies (Conway's law).
7. **Conformance checking:** compare the model with the actual code base, using the planned reverse-engineering library, to detect architecture drift.
8. **Documentation generation** for architecture decision records or onboarding.

### P2.11 [Q7, technology] Implement the chain with the course tools, or give CML a graphical syntax with Sirius. What changes, what stays?

**Answer.** CML models are already EMF models (the Xtext-generated Ecore), so the course tools can work on them directly.

- **ATL:**
  - *Step 1:* a matched rule per `Interaction` creates the Service operation. Entities are created **once per distinct name** with a unique lazy rule (or a helper that groups interactions by entity name).
  - *Step 3:* one matched rule from a BoundedContext with **three target elements** (backend context, frontend context, relationship), which ATL allows in one `to` section.
  - Because the steps are endogenous, ATL's **refining mode** (or QVTo `inout`) can update the CML model in place.
- **Acceleo:** templates per Aggregate/Entity generating Spring classes, or generating the JDL file that JHipster consumes.
- **Sirius:** a **graphical editor over the same Ecore metamodel**. That gives an editable context-map diagram next to the text, which answers the workshop's "a graphical representation might be better". Text and diagram are two concrete syntaxes of one model, so they never drift apart.

**What stays:** the metamodel, the CML textual syntax and all existing models.
**What changes:** how the transformations are implemented, and the tooling.

**Trade-offs:**
- *Gain:* declarative ATL/QVTo rules are easier to read and verify than general-purpose code.
- *Loss:* interactive selection (which use cases or subdomains) is harder. It needs transformation parameters or a small UI, which a Java implementation inside the IDE handles more naturally.

### P2.12 [Q7, modelling] Compare a textual DSL with a UML profile for DDD and with a graphical notation. Argue for one.

**Answer.**

| | Textual DSL (CML) | UML profile (Rademacher) | Graphical DSL (e.g. Sirius) |
|---|---|---|---|
| Strengths | Compact, quick to write; diff/merge in git; easy to transform and generate from; Xtext gives editor and validation cheaply; keywords = DDD terms | Reuses existing UML tools and XMI; familiar notation; integrates with other UML models | Context maps *are* pictures (Vernon, Brandolini); best for workshops and communicating with non-developers |
| Weaknesses | Less approachable for business stakeholders; diagram layout isn't part of the model; needs an IDE | DDD concepts don't map cleanly onto UML (relationship roles become stereotypes on associations); profiles are clumsy; Rademacher's profile covers only tactical DDD | Slow for large models; merging diagrams in version control is hard; more tooling effort |

**My argument:** keep **one metamodel with two concrete syntaxes**. Text is the primary one, for architects, versioning and transformations. A graphical view serves communication. That is the MDE principle "one abstract syntax, several concrete syntaxes".

If forced to pick one: **textual**. The paper's users are architects who evolve models iteratively with transformations, and text supports that best.

### P2.13 [Q8] Generalise the chain "requirements → domain model → logical components → deployment units" to another domain. What must change in the metamodel?

**Answer.** **The generalisable pattern:** an endogenous, vertical chain inside one DSL, where model elements carry a **viewpoint type** (Feature, Application, System). Each step refines the model under user control, and explicit trace links connect the levels.

**Examples:**
- **IoT systems:** use cases → capabilities → logical services → deployment on device, edge gateway or cloud node.
  - *The System type becomes* Device / Gateway / Cloud.
  - *Relationships become* protocols (MQTT, CoAP) instead of OHS/ACL.
- **Data platforms (data mesh):** use cases → data domains → data products → pipelines and storage.
  - *DDD carries over directly:* domain ownership is the same idea.
  - *Relationships become* data contracts.
- **Modular monoliths:** the same chain, but the last step creates modules inside one deployable instead of microservices. Only the generators change.

**What must change in the metamodel:**
- the **relationship patterns** (OHS, PL, ACL, CF are DDD-specific);
- the **context types / viewpoints** (whatever the target domain needs);
- the values of `implementationTechnology`;
- the **generators** (target platforms).

**What can stay:**
- the user-story / use-case syntax (generic);
- the Step 1 heuristic: verbs become operations, nouns become entities;
- the split/merge refactorings;
- the `implements` trace links.

### P2.14 [Critical] The authors list the model–code gap and the agile tension as weaknesses. How would round-tripping or reverse engineering address them, and what does it cost? Connect to the "model burning party".

**Answer.** **The model–code gap:** after generation, developers change the code but not the model. The model goes stale and stops being trusted. That is the modern version of the course's **"model burning party"**, where developers ignored the models and implemented as they liked.

**Ways to close it:**
1. **Reverse engineering** (the paper's future work): derive CML from existing code. Packages and services become bounded contexts, classes become entities, calls become relationships. This also opens brownfield use: refactoring a monolith towards microservices.
2. **Round-trip engineering:** propagate changes in both directions, model → code and code → model.
3. **Keep generated and hand-written code apart:** protected regions, or the *generation gap* pattern (generated base classes plus hand-written subclasses). Regeneration then never overwrites manual work.
4. **Model as source of truth:** change the model and regenerate. This only works if the model is complete enough.
5. **Conformance checks in CI:** fail the build when the code violates the model (e.g. an undeclared dependency between contexts).

**Costs:**
- Reverse engineering is **heuristic**: code doesn't contain design intent (is this dependency an ACL or a conformist?).
- Round-tripping needs bidirectional mappings and conflict resolution.
- All of it is significant tool effort.

**The agile tension** ("working software over comprehensive documentation"):
- Context Mapper's answer is that models are cheap to change (transformations) and produce working software (generation).
- If the model drifts away from the code, it becomes documentation debt, and the agile objection holds.
- So closing the gap is exactly what decides whether the approach is agile.

### P2.15 [Critical] Evaluate the validation. What would a stronger evaluation look like?

**Answer.** **What they did** (Shaw's "experience" validation):
- prototyping and **action research by the authors** (self-experiments);
- case studies: *Lakeside Mutual* (their own sample application), *Cargo Tracking* (Evans' sample), a healthcare project (a bachelor thesis) and a document-management system together with its architect;
- a **2-hour workshop with 5 architects who already knew DDD**;
- an exercise with **~20 students**;
- feedback from the community: GitHub issues, about 40 installs a month.

**Weaknesses:**
- **Mostly evaluated by the tool's authors**, so there is a bias risk (internal validity).
- **No quantitative measures and no control group:** no comparison with whiteboard modelling or other tools.
- **Participants already knew DDD** (external validity; the authors acknowledge it).
- **Several case studies are sample applications**, not systems of real complexity.
- **Hypothesis 1 isn't really measured.** "Discussions confirm the controversy" is anecdotal, and download counts measure interest, not benefit.

**A stronger evaluation:**
- **A controlled experiment.** Two groups decompose the same case, one with Context Mapper and one with whiteboard or plain DDD.
  - Measure **time**.
  - Measure **quality**: coupling and cohesion metrics, plus expert rating.
  - Measure **agreement between participants**: does a precise interpretation reduce disagreement, which is exactly what hypothesis 1 claims?
- **An industrial case study by independent researchers**, over a longer period.
- **Usability measures**, e.g. SUS questionnaires.
- **Comparing the transformations' output** with decompositions made by experts.

---

## Paper 3: Game use-case modeling

### P3.1 [Q1] Why could MDE help game development teams? Which MDE promise is this paper testing, and which MDE benefits does it not yet use?

**Answer.** **The problem:**
- Game teams mix designers, artists, level designers and programmers, and communication between them is one of the industry's top problems.
- Waterfall-style natural-language documents are huge and error-prone; agile teams lose the big picture.
- Designers find models hard and fear they restrict creativity.

**What MDE offers:**
- Models raise the level of abstraction and give a **shared, visual, precise notation**.
- If the notation speaks the domain's language (scene, animation, audio, player and non-player characters), it becomes a **DSML for the domain experts**, which narrows the gap between artists or designers and programmers.

**The promise being tested** is the MDE claim of **"model languages intended for the domain experts → better communication between problem-domain and solution-domain experts"**. The survey measures exactly that: understandability, learnability, usefulness, and improved communication.

**MDE benefits not used:**
- **automation:** no transformations, no code generation;
- **rigorous analysis:** no formal semantics, rules in natural language, pre/post-conditions in natural language;
- **models as primary development artefacts:** the models are **sketches** for elicitation, not blueprints or programs.

So this is really *model-based requirements engineering*. The full MDE chain is only mentioned as possible future integration.

### P3.2 [Q2] What are the scope and requirements of the approach? Why did the authors keep it this simple?

**Answer.**

**Scope**
- The **requirements-elicitation** stage (models may be updated during post-production).
- **Functional and behavioural** game requirements: characters (actors) and their behaviour (functions, scene loading, animation, audio, object creation).
- **All genres:** shown on a platformer, a puzzle game, a rhythm game and an interactive drama.
- Users include **non-software-engineers**.

**Out of scope**
- detailed design: structure (class diagrams), state, timing ("left to the design stage");
- menus and UI layout (only the functions behind them);
- non-functional requirements;
- the assets themselves (only a sketch field).

**Design requirements of the solution**
- simple, general (genre-independent), practical;
- a low learning curve;
- both graphical and textual;
- builds on existing knowledge of UML use cases.

**Why so simple:**
- The users are partly non-technical.
- Earlier approaches failed by being **too technical or using too many diagram types**.
- Practitioners mainly want a low learning curve.
- A small metamodel is easier to adopt **and to extend later without restructuring**.

This is why there are no new relationship types and pre/post-conditions are not written in OCL.

### P3.3 [Q3] The paper defines no transformation chain. Which MDE elements does it provide, and which elements of a chain are missing?

**Answer.**

**Provided**
- **Abstract syntax:** the extended metamodel (Fig. 1).
- **Two concrete syntaxes:** graphical (type icons, stereotype labels, actor icons) and a textual form template.
- **Static semantics:** 11 strict and 5 soft well-formedness rules.
- **A tool** (GUCM): editor plus validator (errors for strict rules, warnings for soft rules).
- **Serialisation** (JSON) and **rendering** (PNG export).
- **Example M1 models** for four games.

**Missing for a transformation chain**
- A **machine-processable metamodel** in a metamodelling framework (Ecore/MOF). Fig. 1 is a picture; GUCM's C# classes are the de-facto metamodel.
- A **standard interchange format** (XMI). The JSON format is undocumented, so a text-to-model "injector" would be needed first.
- **Target metamodels** (no design or code model is defined).
- **Transformation definitions, language and engine.**
- **Formal semantics** for pre/post-conditions and flow of events. As free text they can't drive generation or verification.
- **Trace links** to assets or code.

### P3.4 [Q3, design] Propose a transformation chain that uses the game use-case model. For each step give source/target metamodel, M2M or M2T, language, and classification.

**Answer.** (My proposal.)

```
GUCM JSON ─T0─► Game UC model (Ecore/XMI, CIM) ─T1─► UML class + state machine model (PIM) ─T2─► Unity C# (code)
                         │
                         ├─T3─► test scenarios
                         └─T4─► task list per discipline
```

| Step | Source → target | Kind | Language | Classification |
|---|---|---|---|---|
| T0 | GUCM JSON → GameUC model | text-to-model injection | Java/EMF parser | exogenous, horizontal, 1→1 |
| T1 | GameUC → UML class + state machines | M2M | ATL / QVTo | exogenous, vertical (CIM → PIM), 1→1, out-place, unidirectional |
| T2 | UML → Unity C# | M2T | Acceleo | exogenous, vertical (PIM → code), 1 model → N files |
| T3 | GameUC → test scenarios | M2T | Acceleo | exogenous, horizontal (same requirements, other form) |
| T4 | GameUC → task list | M2T | Acceleo | exogenous, horizontal; groups by `GameUseCaseType` |

**Example mapping for Mario (T1 + T2):**

| Model element | Unity C# |
|---|---|
| `Mario : GameActor {PlayerCharacter}` | `class Mario : MonoBehaviour` (a player-controlled script) |
| «Function» `Jump` | method `Jump()` |
| `includes` «PlayAnimation» `Play jump animation` | call `animator.Play("Jump")` inside `Jump()` |
| `extend` with extension-point condition "mario's health >= 0" | `if (health >= 0) LoadCurrentLevel();` |
| «LoadScene» | `SceneManager.LoadScene(...)` |
| «CreateObject» `Create fireball` | `Instantiate(fireballPrefab, …)` |
| «PlayAudio» | `audioSource.PlayOneShot(...)` |

**T3:** each path through a use case and its extensions (each extension-point condition true or false) becomes one test scenario; the survey participants suggested this.

**T4:** PlayAnimation → artists, PlayAudio → audio team, LoadScene → level designers, Function → programmers.

**Limitation:** natural-language pre/post-conditions can only be copied into the code as comments or TODOs. That is an argument for semi-formal conditions.

### P3.5 [Q4] Draw the instance of Fig. 1 for a fragment of Fig. 9. Mark which objects are instances of the new metaclasses and which of standard UML metaclasses.

**Answer.** Fragment: Mario's `Die` use case.
- `Die` includes `Play die animation`.
- `Die` is extended by `Load current level` (condition *mario's health >= 0*) and by `Load main scene` (condition *mario's health < 0*).

```
NEW metaclasses (game extension)
  mario : GameActor   {name = "Mario", type = PlayerCharacter}
  die   : GameUseCase {name = "Die", type = Function}
  pda   : GameUseCase {name = "Play die animation", type = PlayAnimation}
  lcl   : GameUseCase {name = "Load current level", type = LoadScene}
  lms   : GameUseCase {name = "Load main scene", type = LoadScene}

STANDARD UML metaclasses
  inc  : Include         includingCase = die,  addition = pda          (owned by die)
  ep1  : ExtensionPoint  {name = "has health"}                          (owned by die)
  ep2  : ExtensionPoint  {name = "no health"}   ← name illustrative     (owned by die)
  ext1 : Extend          extension = lcl, extendedCase = die, extensionLocation = {ep1}   (owned by lcl)
  c1   : Constraint      {"mario's health >= 0"}      = ext1.condition
  ext2 : Extend          extension = lms, extendedCase = die, extensionLocation = {ep2}   (owned by lms)
  c2   : Constraint      {"mario's health < 0"}       = ext2.condition
  a1   : Association     memberEnds typed by GameActor (mario) and UseCase (die)
```

Points to make while drawing:
- **Two extension points, not one.** Strict rule 8 forbids sharing one between two extends.
- **Each extend has exactly one extension location.** Strict rule 6 narrows UML's `1..*`.
- **The actor–use case `Association` is not in Fig. 1.** It comes from the general UML metamodel.
- **The `Extend` is owned by the extending use case**, while the `ExtensionPoint` is owned by the base use case (`Die`).

### P3.6 [Q4/OCL] Express strict rules 4, 5, 6, 8 and soft rules 2–4 in OCL. Which rules can't be written against the abstract syntax, and why? How would a tool distinguish strict from soft?

**Answer.**

```ocl
-- Strict 4: a use case does not both include and extend the same use case
context UseCase inv NotIncludeAndExtend:
  self.include.addition->asSet()
      ->intersection(self.extend.extendedCase->asSet())->isEmpty()

-- Strict 5: no self include / extend
context UseCase inv NoSelfReference:
  self.include->forAll(i | i.addition <> self) and
  self.extend->forAll(e | e.extendedCase <> self)

-- Strict 6: exactly one extension point per extend
context Extend inv OneExtensionPoint:
  self.extensionLocation->size() = 1

-- Strict 8: an extension point is not shared by several extends
context ExtensionPoint inv NotShared:
  Extend.allInstances()->select(e | e.extensionLocation->includes(self))->size() <= 1

-- Soft 2: nothing includes a LoadScene
context Include inv NoIncludedLoadScene:
  self.addition.oclIsKindOf(GameUseCase) implies
    self.addition.oclAsType(GameUseCase).type <> GameUseCaseType::LoadScene

-- Soft 3: PlayAnimation and LoadScene include nothing
context GameUseCase inv StandaloneTypes:
  (self.type = GameUseCaseType::PlayAnimation or self.type = GameUseCaseType::LoadScene)
    implies self.include->isEmpty()

-- Soft 4: LoadScene extends only Function or PlayAnimation
context GameUseCase inv LoadSceneExtendsOnly:
  self.type = GameUseCaseType::LoadScene implies
    self.extend->forAll(e |
      e.extendedCase.oclIsKindOf(GameUseCase) and
      Set{GameUseCaseType::Function, GameUseCaseType::PlayAnimation}
        ->includes(e.extendedCase.oclAsType(GameUseCase).type))
```

**Rules that are hard or impossible to write:**
- **Strict 7** (extension points only on extends) is **already guaranteed** by the metamodel: only `Extend::extensionLocation` refers to extension points. It is really about attaching the note symbol to the right link in the diagram.
- **Strict 9** (use cases inside the boundary) **can** be written, as `context GameUseCase inv: self.subject->notEmpty()`.
- **Strict 10–11** (PlayerCharacter/NPC inside, User outside) **can't** be written. `Actor` has **no relation to the subject** in the metamodel, so "inside" vs "outside" exists only in the diagram: it is **concrete syntax**. Enforcing it would need a metamodel change (e.g. an ownership link to the subject) or diagram-level checks.
- **Strict 1** (actor linked to at least one use case) needs the generic UML `Association`, which Fig. 1 doesn't show.

**Strict vs soft in a tool:** OCL has no notion of severity, so put the constraints in two groups.
- **Strict** rules raise an **error**. Either the action is rejected (as GUCM does), or saving and further processing are blocked.
- **Soft** rules raise a **warning**: listed, but the model stays valid.

EMF validation (error vs warning diagnostics), Sirius validation rules and Xtext validators (`error()` vs `warning()`) all support this.

### P3.7 [Q4, critical] Criticise the modelling choices in Fig. 1.

**Answer.**
1. **Redundant attributes.** `gameActorName` and `gameUseCaseName` duplicate the `name` inherited from `NamedElement`, so a model can hold two different names for the same element.
2. **Heavyweight extension, lightweight notation.**
   - The extension is defined as **new metaclasses** but drawn with **stereotype notation** («Function»).
   - A **UML profile** (stereotypes with tagged values `type`, `priority`, …) would give the same expressiveness, since no new associations are added.
   - It would also stay standard UML, so models would open in Papyrus, Enterprise Architect or MagicDraw and could be exchanged as XMI.
   - The heavyweight route forced the authors to build their own tool.
3. **An enumeration `type` instead of subclasses.**
   - *For:* simpler, and easy to extend with a new literal.
   - *Against:* type-specific rules (e.g. "LoadScene includes nothing") can't follow from typing and must be OCL (soft rules), and types can't have their own attributes.
   - *The alternative:* five subclasses `FunctionUseCase`, `LoadSceneUseCase`, ….
4. **Strict rule 6 narrows UML** (`extensionLocation 1..*` → exactly 1). That's legitimate as a constraint, but it means the extension restricts UML as well as adding to it, which should be stated explicitly.
5. **The textual template lives in the abstract syntax as `String[]`.** Pre/post-conditions and flow of events are lists of free text with no structure, so they can't be checked, linked or transformed.
6. **A changed meaning of "actor" is not represented.** Putting PlayerCharacter/NPC inside the boundary changes UML's semantics (actors are external), yet the metamodel has no way to record it (see P3.6 and P3.9).

### P3.8 [Q5] Place on M0–M3 and discuss the subtleties of M0.

**Answer.**

| Level | Artefacts |
|---|---|
| **M3** | MOF |
| **M2** | UML 2.5.1 use-case metamodel + `GameActor`, `GameUseCase`, `GameActorType`, `GameUseCaseType` |
| **M1** | The Super Mario Bros use-case model (Fig. 9) with its textual descriptions (Figs. 10–13); the Tetris, Just Dance and Walking Dead models |
| **M0** | The running game and the people playing it |

**The subtleties at M0:**
- **Two kinds of things are represented.**
  - The *User* actor stands for **real people** outside the software.
  - *PlayerCharacter* and *NonPlayerCharacter* actors stand for **software entities inside the game**: Mario as the player controls him, the Goombas.
- **The game is itself a model of a fictional world.** The course's "software systems as models" applies: the system under study simulates a world in which Mario is an "agent".
- **One M1 element stands for many M0 objects.** The single *Fireball* actor represents every fireball created at run time (via «CreateObject»). Actors behave like types or roles, not instances.

### P3.9 [Q5, critical] UML defines an actor as external to the subject. Is putting PlayerCharacter and NPC actors inside the boundary consistent? Is a fireball really an actor?

**Answer.** **Not consistent with UML.** UML defines an actor as a role played by something that interacts with the subject but is **external** to it. Mario and the Goombas are part of the game software, so by UML's definition they are internal components, not actors.

**The authors' justification:** literature on **software agents** in use-case diagrams places autonomous agents inside the boundary (refs 60, 61).
- *Arguments for:* characters behave autonomously and have "abilities" that designers want to list; drawing them inside signals that they belong to the game.
- *Arguments against:*
  - their behaviour **is** the system's behaviour, while use cases are meant to describe what the system offers to its *environment*;
  - the boundary loses its meaning;
  - the metamodel can't even record inside vs outside (P3.6).

**A cleaner alternative:** treat each character as its own **subject (subsystem)**. Fig. 9's boundary is already labelled «Sub system» Mario system. Each character's use cases then describe what that subsystem offers, and the player (User) is the only true actor. Or model characters in a class or component diagram at design time.

**The fireball:**
- *Why it isn't an actor:* it has no goals and makes no decisions. It is a short-lived object created many times («CreateObject») with trivial behaviour (destroy itself on collision). It is better seen as an **entity or object**. The paper's NPC definition ("any game object that behaves and makes decisions on its own") is stretched here.
- *Why the authors did it anyway:* it gives the fireball's behaviour a place in the diagram without introducing another diagram type. That is the price of the "single diagram" approach.

### P3.10 [Q6] What else can the metamodel be used for?

**Answer.**
1. **Test-scenario generation** from the flow of events and extension conditions (suggested by participants).
2. **Planning and estimation:** count use cases per type and weight them by `priority`, to size the work per discipline.
3. **Task assignment:** the type tells you which team owns the work (animation → artists, audio → audio team, scenes → level designers, functions → programmers).
4. **Code skeletons:** Unity classes and methods per actor and function (P3.4).
5. **Reusable mechanic templates:** stored model fragments for common mechanics (jump, collect power-up), as participants suggested.
6. **Consistency checking** against the game design document, or between levels.
7. **Traceability to assets:** the `gameUseCaseSketch` field could link to the actual animation or audio asset, so missing assets can be found.
8. **Documentation:** generating parts of the game design document from the textual templates.

### P3.11 [Q7, technology] Rebuild GUCM with MDE tools. What do you gain and lose?

**Answer.** **Architecture:**
- **Metamodel:** an **Ecore** metamodel. Either the real UML metamodel via Eclipse UML2 plus a **profile**, or a small dedicated Ecore DSL that mirrors Fig. 1.
- **Graphical editor:** **Sirius**, with a palette, type icons and conditional styles per `GameUseCaseType`.
- **Textual template:** Sirius property views (forms) for the description fields; optionally Xtext for the flow of events.
- **Rules:** **OCL**, with strict rules as errors and soft rules as warnings (Sirius or EMF validation).
- **Storage:** **XMI** instead of ad-hoc JSON.
- **Downstream:** ATL / Acceleo for transformations (P3.4), EMF Compare for versioning.
- **A web tool is still possible:** Sirius Web runs in the browser, so the "web-based" advantage isn't lost.

**Gains:**
- far less hand-written code (GUCM is about 9,150 lines of C#);
- standard formats, and the metamodel becomes an executable artefact;
- validation, querying and transformations come for free;
- interoperability with other UML tools (especially with the profile option).

**Losses:**
- the full UI freedom and game-like look they built in Unity;
- a tool built in an engine the target users already know;
- Eclipse-based tools can feel heavy to non-technical users;
- the tool builders must learn the EMF stack.

### P3.12 [Q7, modelling] Compare with the alternatives in related work. When is a single extended use-case diagram enough, and when is it not?

**Answer.**

| Approach | Strength | Weakness (according to the paper) |
|---|---|---|
| **MML** (Pleuss & Hussmann): task, structure, scene, presentation and interaction models | Complete, model-driven, supports generation, acts as a contract between teams | Five model types, needs software-engineering background |
| **Lope et al.**: class, state, activity and sequence diagrams for educational games | Uses standard UML | Many diagrams; misses audio, animation, objects |
| **Eberos GML2D**: graphical DSL for 2D games (sprites, entities, logic, controllers, collisions) | Close to implementation, ready for generation | No textual descriptions; only 2D |
| **GaML**: formal language with OCL for gamification | Precise and verifiable | No game objects, animations or scenes; no textual descriptions |
| **Cooper & Longstreet**: use-case extension for serious educational games | Same basic idea | Only scene-based educational games; no extends, no boundary |

**A single extended use-case diagram is enough for:**
- early elicitation and scoping;
- shared understanding across disciplines and estimation;
- small and medium games.

**It is not enough when you need:**
- behavioural detail (state, timing, physics);
- data structures;
- UI flow;
- generation or verification.

**My position:** the approaches are **complementary, not competitors**. Use the game use-case diagram for requirements, and design-level models (MML- or Eberos-like) later, connected by a transformation. The authors themselves suggest integrating with MML.

### P3.13 [Q8] Generalise the pattern "domain stereotypes + textual templates + strict/soft rules" to another domain.

**Answer.** **The reusable pattern:**
1. Identify the domain's kinds of participants → **actor types**, including autonomous agents inside the system.
2. Identify the kinds of behaviour → **use-case types**.
3. Add domain fields to a **textual template**.
4. Write **strict rules** (validity) and **soft rules** (good practice) for how the types may be combined.
5. Validate with practitioners.

**Example: VR/AR training simulators**
- **Actor types:**
  - *Trainee* (User, outside the boundary)
  - *Avatar* (controlled by the trainee, inside)
  - *VirtualInstructor* / NPC (inside)
- **Use-case types:** Function, LoadScenario, PlayInstruction (audio/video), SpawnHazard (≈ CreateObject), AssessPerformance.
- **Template fields:** learning objective, safety level, pass criteria.
- **Soft rules:**
  - "AssessPerformance is never included by LoadScenario".
  - "SpawnHazard must be extended by a feedback use case".

**Other candidates:**
- robotics or smart homes: Resident as User; Robot or Device as autonomous agents; Sense / Actuate / Notify / Schedule as use-case types;
- interactive storytelling.

The related work already applies the same idea to security (misuse cases with «security» stereotypes), safety, context-aware systems and adaptive web services, which shows the pattern is general.

**Caveats:**
- Actors inside the boundary only make sense where the system really contains autonomous agents.
- For reuse across tools, a **profile** generalises better than new metaclasses.

### P3.14 [Critical] Evaluate the survey. Why might people without modelling experience rate it higher? What controlled experiment would you design?

**Answer.** **How the survey was run:**
- Google Forms, shared on Twitter (#gamedev, #indiedev), open for three weeks.
- **29 respondents, 16 of them programmers.**
- A short introduction plus the Mario example; **no use of the tool**.
- **Closed 5-point Likert questions (self-assessment)** plus one open question.
- Mann–Whitney U tests between groups. Group sizes: 9 never used diagrams, 11 used other diagrams, 9 used UML use cases.

**Weaknesses:**
- **Perceived, not measured.** Nobody performed a task, so understanding was never tested.
- **Self-selection and positive bias.** People interested in the topic answer.
- **Wrong sample.** Programmers dominate, while designers and artists, the non-technical users the approach targets, are under-represented. Few demographics were collected.
- **Small groups and many tests.** Groups of 9–11, about 16 tests, no correction for multiple testing, and learnability sits exactly at p = 0.05.
- **No baseline.** No comparison with plain UML use cases or natural-language specifications.

**Why non-modellers might rate it higher:**
- Novices don't know the typical problems of modelling (scalability, ambiguity, maintenance), so a short, simple example looks easy. This is the authors' own explanation.
- Experienced modellers compare it with richer notations and see what's missing (state, timing).
- For novices, "anything is better than pages of text".

**A controlled experiment:**
- **Participants:** game developers with balanced roles (designers, artists, programmers).
- **Design:** between-subject, or a counterbalanced crossover. Treatment = game use-case diagram + template; control = plain UML use cases or a natural-language specification. Same game for everyone.
- **Tasks:**
  1. **Comprehension:** questions about a given model; measure correctness and time.
  2. **Modelling:** model a described mechanic in GUCM; measure rule violations, completeness and time.
  3. **Communication:** a designer models, a programmer answers questions or sketches an implementation from the model; count misunderstandings.
- **Extra measures:** usability (SUS) and perceived effort (NASA-TLX).
- **Statistics:** suitable tests with correction for multiple comparisons.

### P3.15 [Critical] Use-case diagrams scale badly. How would modularisation help, and does it hurt the "one diagram for everyone" goal?

**Answer.** **The problem:**
- Plain use-case diagrams already scale poorly.
- The game version adds even more elements: each function pulls in its animation, audio and scene use cases.
- Fig. 9 covers only a few Mario features and is already crowded.
- The paper also notes that heavily interconnected use cases make changes ripple.

**Modularisation options:**
- **Use-case packages:** by actor (Mario, Goomba, Fireball), by level or feature, or by discipline.
- **One diagram per subject or character:** Fig. 9 already uses a «Sub system» boundary.
- **Levels of detail:** summary diagrams showing only «Function» use cases, with included animation and audio use cases moved into the textual template or detail diagrams.
- **Tool support:** filter by use-case type, collapse included use cases, layers.

**Does it hurt the goal?** Partly: more diagrams mean more navigation. But the authors' real criticism of the related work was **many *languages*** (class + state + sequence + …), not many *pictures*. Several diagrams in **one notation** over **one model** are just several *views*. That is standard MDE (one model, many views), and it keeps the learning curve low as long as the views stay consistent, which a model-based tool guarantees.

---

## Cross-paper questions

### X.1 Compare the three ways of extending a language: import a vocabulary (BPMN→SBVR), define a new DSL (Context Mapper), add metaclasses to UML (game). When is each appropriate?

**Answer.**

| Mechanism | Where | When appropriate | Cost |
|---|---|---|---|
| **Library / vocabulary inside the language** (BPMN → SBVR) | M1, metamodel unchanged | The language has its own reuse mechanism and you only need new *terms*, not new structure; standard compliance and tool support matter | The meaning of the new concepts is only a convention, not enforced by structure |
| **Profile** (not used, but the obvious comparison) | Stereotypes on existing metaclasses | The new concepts are specialisations of existing UML concepts and need extra properties; you want to keep using UML tools | Limited to what stereotypes and tagged values can say; clumsy for very different concepts |
| **New metaclasses** (game) | M2 change of a standard | You need new structure (associations, metaclasses with their own semantics) on top of a standard and accept custom tooling | Loses compatibility with standard tools; must be maintained against new versions of the standard |
| **New DSL** (Context Mapper) | A new M2 | The domain doesn't fit any general modelling language, the users have their own vocabulary (DDD), and you want a tailored syntax and transformations | You build all tooling (Xtext reduces this); no standard interchange with other tools |

**The rule:** choose the **lightest mechanism that can express the concepts you need**.

**Judging the papers:**
- **BPMN → SBVR:** a good choice. The domain is standards-driven, and changing a standard would isolate them.
- **Context Mapper:** a good choice. The DDD patterns have no natural UML counterpart, and architects benefit from a textual DSL.
- **Game paper:** questionable. A profile would have expressed everything and kept standard UML tools.

### X.2 Each paper pairs a graphical and a textual syntax. Which direction does each generate, and why?

**Answer.**

**BPMN → SBVR: text generated *from* diagrams** (M2T, BPMN → Structured English).
- Analysts model in BPMN; business people validate in text, which they prefer.
- *Precision:* these are **two different abstract syntaxes** (BPMN and SBVR) connected by a transformation, not two notations for one model.

**Context Mapper: diagrams generated *from* text** (CML → graphical context maps, PlantUML).
- Text is efficient to write, version and transform; diagrams communicate better.
- The diagrams are **read-only views**, a second concrete syntax of the **same** model.

**Game paper: text attached *to* each diagram element**, both edited by hand.
- The diagram gives the overview; the template gives designers and artists the details (pre/post-conditions, sketch, flow of events).
- Both are part of **one model**: the template fields are attributes in the metamodel.

**The MDE principle** behind Context Mapper and the game paper is *one abstract syntax, several concrete syntaxes*. BPMN → SBVR achieves the same effect for readers *across* two languages.

### X.3 Where does each paper sit on the formality spectrum (OCL → SBVR → CML → free-text templates), and is that the right choice for its readers?

**Answer.** The spectrum, from most to least formal:

| Language | Formality | Readers |
|---|---|---|
| **OCL** | Fully formal | Engineers and tools only |
| **SBVR** (BPMN paper) | Controlled natural language with formal logical semantics | Business people can read it; tools can process it |
| **CML** (Context Mapper) | Formal textual DSL in domain vocabulary | Architects |
| **Game templates** | Free natural language for pre/post-conditions and flow | Mixed technical and non-technical teams |

**Is each choice right?**
- **BPMN → SBVR: yes.** Validation by business people needs readability. The formality enables tool processing and the reverse transformation.
- **Context Mapper: yes** for architects. The semi-structured interaction syntax is a clever compromise: readable, but structured enough to automate Step 1.
- **Game paper: understandable for elicitation**, but it blocks automation (test and code generation) and any verification. A middle path would keep the readability and enable generation, for example controlled templates in the style of SBVR, or *Given/When/Then* (Gherkin) for conditions and flow.

**The general trade-off:** precision vs accessibility. Decide by asking who reads and writes the models, and whether machines must process them.

### X.4 In all three, output quality depends on input-model quality. Which well-formedness rules does each need, and where should they be enforced?

**Answer.** **Rules each paper needs:**
- **BPMN → SBVR:** participants in lanes, every element named, full conditions on outgoing flows. Today these are only **implicit conventions**, fixed by refactoring by hand.
- **Context Mapper:** semantic rules on which pattern combinations are allowed (as **validators**); syntactic structure enforced by the **grammar**.
- **Game paper:** **11 strict and 5 soft** rules enforced by the tool, written in natural language.

**Where to enforce them, from cheapest to most expensive:**
1. **The metamodel's structure:** types, multiplicities, containment. Always enforced, for free (e.g. "Downstream has 0..1").
2. **The grammar**, for textual languages: e.g. separate role enums for upstream and downstream.
3. **OCL invariants / validators** for rules that span several elements, with **error vs warning** severities.
4. **The tool UI:** prevent invalid edits as they happen (GUCM rejects the action).
5. **Transformation preconditions:** check before running and refuse invalid input.

**Weakest of the three:** the BPMN paper. Its preconditions should be OCL checks that run before the transformation.

### X.5 Tool choice: MagicDraw plug-in, Eclipse/Xtext/EMF, custom Unity web tool. Which is most sustainable for researchers and for industrial adoption?

**Answer.**

**MagicDraw (commercial CASE tool)**
- *Pros:* mature and full OMG standard support (BPMN, UML); fits companies that already use MagicDraw/Cameo, e.g. in systems engineering.
- *Cons:* licence costs and vendor lock-in through the plug-in API; hard for others to reproduce (reviewers need a licence); prototype level only (TRL 4).

**Eclipse / Xtext / EMF (open source)**
- *Pros:* free; standard Ecore/XMI; a large ecosystem (ATL, Acceleo, Sirius, OCL); reproducible; open to community contributions. Context Mapper shows it: 50 releases, Eclipse **and** VS Code and browser IDEs.
- *Cons:* the Eclipse platform is heavy; maintaining integrations for several IDEs costs effort (the authors say so).

**Custom Unity web tool**
- *Pros:* full control over the user experience; familiar to the audience; nothing to install.
- *Cons:* everything is hand-built (about 9,150 lines of code); no standard formats, no ecosystem, nothing to build further tools on. The least sustainable of the three.

**Verdict:**
- **For researchers:** the Eclipse stack is the most sustainable and reproducible.
- **For industry:** it depends on the audience. Systems-engineering organisations use MagicDraw/Cameo, so a plug-in fits there. Developers increasingly prefer VS Code or web tools, which makes Context Mapper's multi-IDE strategy the most promising.

### X.6 Evaluation quality: benchmark by the authors, action research by the authors, small online survey. Which is weakest and why?

**Answer.**
- **BPMN → SBVR:** an objective check that the implementation is correct (it matches the hand-made benchmark). But the benchmark was made by the same authors with the same rules, on hand-picked refactored models, and **no user ever judged the readability**, which is the paper's motivation (P1.14).
- **Context Mapper:** qualitative and largely self-evaluated: action research, a 5-person workshop, students. No control group or measurements. Still, it is the **most varied** evidence: real projects, practitioners, community use (P2.15).
- **Game paper:** 29 self-assessments of *perceived* understandability, with no tasks and no baseline (P3.14).

**My answer:** **weakest relative to its claims is BPMN → SBVR.** It concludes that the results give "a solid background for the practical application", yet its only evidence verifies the implementation against the authors' own specification. Whether the generated text helps business people was never tested.

The game survey comes a close second: perception is not understanding, but at least it asks the target community.

*(Any of the three can be argued. What matters is naming what each evaluation does and doesn't show.)*
