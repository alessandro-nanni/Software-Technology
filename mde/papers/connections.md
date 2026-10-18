# Papers ↔ MDE notes: connections

Section numbers (§) refer to `mde/notes.pdf`. Summaries of the papers are in [summaries.md](summaries.md).

The code blocks below are **sketches I wrote to show how each concept from the notes would apply to the paper**. They are not taken from the papers. Metamodel element names follow the real standard (BPMN 2.0, UML 2.5) where possible and are marked as illustrative otherwise.

---

## Overview

| | BPMN → SBVR | Context Mapper | Game use cases |
|---|---|---|---|
| **MDA level** (§1.3) | CIM → CIM (business process → business rules) | CIM → PIM → PSM → code (use cases → subdomains → feature/system contexts → JHipster) | CIM (requirements elicitation only) |
| **Metamodel(s)** (§2) | BPMN 2.0 and SBVR (both OMG/MOF). SBVR is used through a UML profile in MagicDraw | Own DDD metamodel (UML class diagram) → Ecore via Xtext | UML 2.5.1 use-case metamodel + 2 metaclasses + 2 enumerations |
| **Concrete syntax** (§4.2) | BPMN diagrams; SBVR Structured English (text) + "fact diagrams" | Textual DSL (CML); generated graphical context maps / UML | Graphical (icons, stereotypes) + form-based textual template |
| **Constraints** (§3) | Implicit (naming, lanes, conditions on flows) | "Semantic rules" implemented as validators | 11 strict + 5 soft well-formedness rules |
| **Transformations** (§5–7) | M2M **and** M2T, written in **QVT** | Chain of model transformations + architectural refactorings + code generation | None implemented (proposed as future work) |
| **Tooling** | MagicDraw plug-ins (commercial CASE tool) | Xtext / EMF on Eclipse and VS Code | Custom Unity/C# web tool, JSON files (not EMF) |

---

## 1. Transforming BPMN Processes to SBVR Process Rules

This is the paper closest to the **transformation half** of the course (§5–§7). Its rules are written in **QVT** (§6), and it produces both models (M2M) and text (M2T, §7).

### 1.1 MDA framing and abstraction levels (§1.2, §1.3, §1.5)
- The authors explicitly place their work "under the unified framework of OMG's Model-Driven Architecture". BPMN and SBVR are both **Computation Independent Business Models**: they describe the business "independently of automated support" (§1.3, step 1).
- The paper argues that both a graphical and a natural-language view should exist so that business people and IT people can both read the same knowledge. This is the MDE goal "model languages intended for the domain experts … better communication between problem domain experts and solution domain experts" (§1.5).
- §1.5 lists **digital threads** (system models linked to each other) as a modern MDE application. Here the BPMN model, the SBVR vocabulary and the process rules live in one MagicDraw project, connected by the transformation. The planned **reverse transformation** (SBVR → BPMN) is the kind of "reverse engineering" activity that MDE adds on top of MDD (§1.5).

### 1.2 Metamodels and meta-levels (§1.4, §2.2–§2.4)

| Level | In this paper |
|---|---|
| M3 | MOF |
| M2 | BPMN 2.0 metamodel; SBVR metamodel (in the tool: UML metamodel + SBVR profile) |
| M1 | The "Order Registration" BPMN diagram; the extracted SBVR vocabulary and process rules |
| M0 | The real order-handling process carried out by customers and managers |

Something subtle happens with levels. To make SBVR expressive enough, the authors build an **SBVR vocabulary that describes BPMN concepts** (activity, gateway, event…). That vocabulary is an M1 model (an instance of SBVR) whose *subject* is the BPMN metamodel (M2). It is therefore literally a **model of a model**. §2.1 says "a model can be seen as a role or may be the subject of modelling (model of a model)", and §2.2 says "a metamodel is a model of a model".

### 1.3 How do you extend a language? (§2.5, §4)
The paper compares two options:
1. **Extend the SBVR metamodel** (new M2 metaclasses). The authors reject this because it costs effort at every new version of the standard, risks being "closed in your own sandbox", and gets worse tool support.
2. **Import an additional vocabulary** (stay inside the language). This is the option they choose.

The tool also relies on a **UML profile for SBVR**, meaning SBVR is implemented on top of UML's metamodel using stereotypes. This connects to §2.5: MOF and UML were designed so that UML tools can express new languages.

### 1.4 Abstract vs concrete syntax (§2.3, §4.2)
SBVR is a good example of "one abstract syntax, several concrete syntaxes":
- **Textual:** SBVR Structured English (*"It is obligatory that …"*).
- **Graphical:** the "fact diagrams" in MagicDraw.

Both are views of the same SBVR model, which matches the notes' point that the metamodel "does *not* define the concrete representation" (§4.2).

### 1.5 Constraints and formality: SBVR rules vs OCL (§3)
- §3.1 says formal languages are preferred over natural language, with the footnote *"no 'Please no underaged employees'"*. SBVR tries to have it both ways: it is a **controlled natural language with a formal (logic-based) meaning**. The text reads like English, but every sentence maps to a logical formulation.
- **Differences from OCL:**
  - An OCL invariant restricts **which models are valid**, is declarative, and has no side effects (§3.1).
  - An SBVR **behavioral rule** restricts **what people may or must do**, using the deontic modalities *obligatory / permitted / prohibited*. OCL has no notion of modality: an OCL constraint simply holds or does not hold.
  - OCL `pre`/`post` conditions (§3.2) are the closest thing in OCL to "X must happen after Y".
- Gateway conditions in the paper (*"if order has extra conditions"*) play the role of **guards**, the same idea as ATL guards (§5.4) and QVT `when` clauses (§6.6).

### 1.6 Classifying the transformation (§5.1, §5.3)
The paper classifies itself using the same taxonomy as the notes:

| Feature (§5.3) | This paper |
|---|---|
| Programming style | **Hybrid** (declarative and imperative). The notes say the same of ATL (§5.4) and QVT (§6.4) |
| Direction | Unidirectional (BPMN → SBVR). Reverse is future work; bidirectionality was an *optional* QVT requirement (§6.3) |
| Cardinality | **One-to-one** (one source model, one target model) |
| Vertical / horizontal | **Horizontal**: same abstraction level, different language. The notes (§5.3) mostly discuss *vertical* refinement chains, so this is a useful counterexample |
| Endogenous / exogenous | **Exogenous** (source and target metamodels differ) |

### 1.7 The rule shape = declarative ATL/QVT rules (§5.4, §6.6)
- Each rule is `Ti : PPi → RPi`. The input `PPi` is a **source pattern**: BPMN element types plus conditions. The output `RPi` is a **target pattern**: an SBVR rule template. This is exactly the shape of an ATL declarative (matched) rule in §5.4: "a source pattern to be matched … and a target pattern to be created … for each match".
- Rules **depend on elements created by other rules**: process rules reference noun and verb concepts created in Stage 1. In ATL this is handled by **automatic traceability**: "attributes are resolved into columns by the automatic traceability support" (§5.4). In QVTo it is handled with `resolveIn` / `resolveoneIn` over the **trace** (§6.8).
- Building the vocabulary first and the rules second follows the same ordering idea as the QVT flattening example (§6.9). There, classes are created in `init` and properties are assigned in `end`, so that they can point to classes that already exist.

### 1.8 Cascading gateways ↔ recursive helpers (§6.7)
`createPartialRule` walks **backwards, recursively,** through chains of gateways. It stops at a *boundary gateway* (one with no incoming gateways) and builds the rule on the way back. This is the same recursion as the QVT helper that computes **derived attributes** by walking up the superclass chain (§6.7), and both need flattening when the recursion branches. The *gateway neighbourhood* tuple is what you would write as a set of **helpers/queries for complex navigation over the source model** (§6.7).

### 1.9 M2T: the rule patterns are templates (§7)
- The tool implements **both** an M2M transformation (BPMN model → SBVR model in MagicDraw) **and** an M2T transformation (BPMN → text for the VeTIS editor).
- The EBNF rule patterns are effectively **Acceleo-style templates** (§7.3): fixed text (*"It is obligatory that"*, *"after"*, *"and if"*) with **gaps** (`vc(...)`) filled in from the model.

### 1.10 Model quality (§1.5, §3)
The evaluation found that **invalid or badly named source models produced invalid or missing rules**. The authors had to refactor the models first. Their three prerequisites (participants in pools/lanes, named elements, conditions on outgoing flows) are exactly what **OCL invariants** on the BPMN metamodel could check *before* running the transformation (§3: "an OCL constraint limits the set of valid models").

### Sketches

**OCL**: the paper's prerequisites as invariants (BPMN 2.0 metamodel names):
```ocl
-- participants must be defined: every activity lies in a lane
context Activity inv InLane:
  self.lanes->notEmpty()

-- elements must be named (otherwise no verb concept can be formed)
context Activity inv Named:
  self.name <> null and self.name.size() > 0

-- conditions go on the outgoing flows of a diverging exclusive gateway
context ExclusiveGateway inv ConditionsOnBranches:
  self.outgoing->size() > 1 implies
    self.outgoing->forAll(f | f <> self.default implies f.conditionExpression <> null)
```

**QVTo**: rule T1 (plain sequence flow → obligation) as a mapping with a guard, targeting a simplified `RULES` metamodel:
```
modeltype BPMN  uses 'http://www.omg.org/spec/BPMN/20100524/MODEL';
modeltype RULES uses 'http://example/processrules';   -- illustrative target

transformation Bpmn2ProcessRules(in bpmn : BPMN, out rules : RULES);

main() {
  bpmn.objectsOfType(SequenceFlow)->map toObligation();
}

mapping SequenceFlow::toObligation() : ProcessRule
  when { not self.sourceRef.oclIsKindOf(Gateway) and not self.targetRef.oclIsKindOf(Gateway) }
{
  modality   := Modality::OBLIGATORY;
  consequent := self.targetRef.verbConcept();
  antecedent := self.sourceRef.verbConcept();
  condition  := self.name;          -- the paper allows the condition in Name or Guard
}

-- "manager" + "registers order" for activities, just the name for events
query FlowNode::verbConcept() : String =
  if self.oclIsKindOf(Activity) then self.lanes->any(true).name + ' ' + self.name
  else self.name endif;
```

**Acceleo**: rendering the rule as Structured English (the M2T half):
```
[template public render(r : ProcessRule)]
It is [r.modality.toString().toLower()/] that [r.consequent/] after [r.antecedent/][if (not r.condition.oclIsUndefined())] and if [r.condition/][/if].
[/template]
```

---

## 2. Domain-Driven Architecture Modeling with Context Mapper

This is the paper closest to the **DSL half** of the course (§4). CML is an **Xtext** language over **EMF**, which is exactly the stack used in the course labs.

### 2.1 Xtext and EMF (§4.3)
- "The Context Mapper DSL (CML) is based on the Xtext language framework. The models behind the textual representation are … EMF models." This is the **default Xtext workflow** in §4.3: write the grammar, run MWE2, and get a parser, editor, validator **and an Ecore metamodel**.
- The DSL is available in Eclipse **and** VS Code / browser IDEs. This shows Xtext's point that it "provides a runtime architecture and a full-blown … IDE" for the language (§4.3).
- The **semantic rules** that encode which DDD pattern combinations are allowed are implemented as **validators**. This is Xtext's "compiler checks and static analysis (validation)" (§4.3).

### 2.2 Metamodel, abstract syntax, concrete syntax (§2.3, §4.1, §4.2)
- Fig. 2 of the paper (the strategic DDD metamodel as a UML class diagram) is the **abstract syntax**. CML text is **one** concrete syntax. The generated graphical Context Maps and UML/PlantUML diagrams are **more** concrete syntaxes / views. This is the notes' "a DSL is a coordinated set of models built around [the metamodel]" (§4.2).
- Meta-levels: **M3** Ecore · **M2** CML metamodel · **M1** `insurance.cml` · **M0** the insurance system and its teams.

### 2.3 Abstraction gap and DSL purpose (§4)
- DDD's **ubiquitous language** is the DSL ideal: the vocabulary of the problem domain, "familiar for the domain experts, there is no (or a small) abstraction gap" (§4).
- The **implementation gap** is bridged with transformations, ending in JHipster code generation. This is the take-home message "model transformations can be used to bridge this gap" (§4).
- The workshop architects warned that a tool must not become "an excuse for not engaging with end users". This is a reminder that a DSL lowers the abstraction gap but does not replace the people who know the domain.
- The paper also gives **semantics** to DDD (§4, "Semantics definition remains an interesting topic in MDE!"). Its first hypothesis is about removing ambiguity from the patterns by giving them a precise metamodel and rules.

### 2.4 Grammar elements (§4.3 "Grammar elements")
CML's relationship syntax `A [U,OHS,PL]->[D,CF] B` uses every grammar element listed in the notes. A **simplified** Xtext rule (not the real CML grammar):
```xtext
UpstreamDownstreamRelationship:
  upstream=[BoundedContext]                                 // reference by name
  '[' 'U' (',' upstreamRoles+=UpstreamRole)* ']'            // keyword + multiple (0..*)
  '->'
  '[' 'D' (',' downstreamRoles+=DownstreamRole)* ']'
  downstream=[BoundedContext]
  ('{' 'implementationTechnology' '=' implementationTechnology=STRING '}')?;  // optional

enum UpstreamRole:   PUBLISHED_LANGUAGE='PL' | OPEN_HOST_SERVICE='OHS';
enum DownstreamRole: ANTICORRUPTION_LAYER='ACL' | CONFORMIST='CF';
```
Splitting the roles into two enums makes *"OHS/PL belong to the upstream, ACL/CF to the downstream"* a **syntax/metamodel guarantee**. Rules that cannot be expressed in the grammar need **constraints** (§3). One illustrative example is that ACL ("protect yourself from the upstream") and CF ("simply conform to the upstream") contradict each other:
```ocl
context UpstreamDownstreamRelationship inv NotBothAclAndConformist:
  not (self.downstreamRoles->includes(DownstreamRole::ANTICORRUPTION_LAYER) and
       self.downstreamRoles->includes(DownstreamRole::CONFORMIST))

context UpstreamDownstreamRelationship inv NoSelfRelationship:
  self.upstream <> self.downstream
```

### 2.5 The transformation chain (§5.1, §5.3)
The rapid-prototyping steps are a textbook **transformation chain** (§5.3, "How is the transformation chain defined?"):

| Step | Input → output | Cardinality (§5.3) | Kind |
|---|---|---|---|
| 1. Use cases → Subdomain | selected use cases/stories → 1 subdomain | **N-1** | vertical (requirements → analysis) |
| 2. Subdomains → Feature BC | selected subdomains → 1 context (1 aggregate each) | **N-1** | vertical (analysis → design) |
| 3. Feature BC → System BCs | 1 context → frontend + backend + context map | **1-N** | vertical (logical → physical) |
| 4…N. Split into subsystems | 1 → 2 | **1-N** | vertical |
| Architectural refactorings | split / merge / extract | — | **horizontal** |

- **Endogenous:** source and target are all CML models (the same metamodel). The notes' remark that "in refactoring the models can be instance of the same metamodel" (§5.3) applies directly to the architectural refactorings.
- **Vertical refinement:** "Each transformation refines the input model (applies patterns, adds platform specific details)… each step moves to a lower level of abstraction" (§5.3). Step 2 adds IDs, parameter and return types. Step 3 adds `implementationTechnology "Java, Spring Boot"` / `"Angular"`, which is platform detail. Mapped onto MDA (§1.3): use cases / subdomains ≈ **CIM**, Feature/Application context ≈ **PIM**, System context with technologies ≈ **PSM**, JHipster output ≈ **code**.
- **Semi-automatic:** the user decides what to group, and the output contains `TODO` comments. This differs from the notes' definition, where target models are *"automatically generated"* (§5.1). The paper explicitly says the transformations "do not aim at replacing human design work".
- **Traceability:** the `implements` keyword (BoundedContext → Subdomain) is an **explicit trace link** kept in the model. Compare the engine-managed traces in ATL (§5.4) and QVTo (§6.8).
- The paper does not name the transformation language. Because the models are EMF models, any of ATL/QVT (§5–6) or plain Java over EMF (§6.13) would fit.

### 2.6 Step 1 as a mapping
Step 1 is a pattern-based mapping (Fig. 4 in the paper). Each interaction becomes an Entity plus a Service operation: *"submit" a "Claim" with its "date", "amountClaimed"* → `Entity Claim { date; amountClaimed }` + operation `submitClaim`. In ATL terms (§5.4), this is a matched rule from `UseCase` to `Subdomain`, with a lazy rule per `Interaction` that creates the Entity and the operation.

### 2.7 Code generation and the model-code gap (§1.2, §2.1, §7)
- One microservice is generated per Bounded Context with JHipster, plus diagrams. As in §7.7, M2T is "the last step of a transformation chain".
- The **"model-code gap"** the authors list as a weakness (generated code drifts away from the model) is the modern form of the **"model burning party"** in §1.2, where developers ignored the models. Their planned fix, reverse engineering from code, is an MDE activity "beyond development" (§1.5).
- The purposes of models in §2.1 appear one after the other: a Feature context full of `TODO`s is a **sketch**, a refined System context map is a **blueprint**, and the generated JHipster project treats the model like a **program**.
- The agile objection ("working software over comprehensive documentation") is the same tension behind §1.1: models are meant to be **stable assets** that are independent of technology, which the paper claims too ("independent of any programming languages, architectural styles, or frameworks").

---

## 3. A Use Case Driven Approach to Game Modeling

This is the paper closest to the **metamodel + constraints half** of the course (§2, §3). It extends a standard metamodel and defines well-formedness rules, but it does not implement any transformations.

### 3.1 Extending a metamodel (§2.2, §2.3, §2.5)
- Fig. 1 of the paper is the **UML 2.5.1 use-case metamodel (abstract syntax)** with four additions: the metaclasses `GameUseCase` and `GameActor`, plus the enumerations `GameUseCaseType` and `GameActorType`. This is "a metamodel … constrains the valid models expressible in a given modelling language" (§2.3) in practice.
- The paper's background section names the **two ways to extend UML**:
  1. a **profile** (stereotypes, tagged values, constraints)
  2. **new metaclasses defined with MOF** (§2.5)

  It uses the second for the metamodel but shows the result with **stereotype notation** (`«Function»`, `«LoadScene»` …). Compare the BPMN→SBVR paper, which *avoided* changing a metamodel altogether.
- Meta-levels: **M3** MOF · **M2** UML use-case metamodel + game extension · **M1** the Super Mario use-case model · **M0** the actual game.

### 3.2 "Software systems as models" (§2.1)
The paper puts **PlayerCharacter and NonPlayerCharacter actors *inside* the system boundary**, because Mario and the Goombas are part of the system. This only makes sense if you accept the notes' point that "a running software system can be considered a model of a system" (§2.1): a game is software that models a (fictional) world, so its "actors" are model elements, not external users. Only the human **User** stays outside.

### 3.3 Domain-specific modelling language (§4, §4.1)
- The game use-case notation is a **DSML built by specializing a GPML** (UML). It sits between "UML: … still does not talk in a domain language" and a full DSL (§4). The vocabulary (scene, animation, audio, spawn object, NPC) is the game team's own, which narrows the abstraction gap for designers and artists.
- It has **two concrete syntaxes** (§4.1, §4.2): graphical (oval with type icon, stick figure with joystick or computer) and **textual** (the form-based template). This matches "several concrete syntaxes (typically textual or diagrammatical)".
- The related-work critique is an argument against "language cacophony / Babel tower" (§4, take-home messages). The authors reject approaches that need class, state, activity and sequence diagrams together (MML, Lope et al.), because several notations make communication *worse* for non-engineers.
- Tooling: GUCM is a custom Unity/C# tool that stores models as JSON. With the course stack you would define Fig. 1 as an **Ecore** metamodel and build the graphical editor with **Sirius/Graphiti** (§4.2). You would then get XMI models and access to ATL/QVT/Acceleo for free.

### 3.4 Well-formedness rules = OCL invariants (§3)
The **11 strict rules** are exactly what OCL is for: "an OCL constraint limits the set of valid models" (§3.1). Several of them can be written directly against the real UML metamodel (`UseCase::include`, `Include::addition`, `UseCase::extend`, `Extend::extendedCase`, `Extend::extensionLocation`):
```ocl
-- Strict rule 3: names are unique (nested forAll, §3.4)
context UseCase inv UniqueName:
  UseCase.allInstances()->forAll(a, b | a <> b implies a.name <> b.name)

-- Strict rule 4: a use case cannot both include and extend the same use case
context UseCase inv NotIncludeAndExtend:
  self.include.addition->asSet()
      ->intersection(self.extend.extendedCase->asSet())->isEmpty()

-- Strict rule 5: no self-include / self-extend
context UseCase inv NoSelfReference:
  self.include->forAll(i | i.addition <> self) and
  self.extend->forAll(e | e.extendedCase <> self)

-- Strict rule 6: exactly one extension point per extend
context Extend inv OneExtensionPoint:
  self.extensionLocation->size() = 1

-- Soft rule 2: LoadScene is never included (attribute name `type` is illustrative)
context UseCase inv NoIncludedLoadScene:
  self.include->forAll(i |
    i.addition.oclIsKindOf(GameUseCase) implies
      i.addition.oclAsType(GameUseCase).type <> GameUseCaseType::LoadScene)
```
Things worth noticing:
- **Strict vs soft:** OCL invariants either hold or fail. The paper's *soft* rules (warnings) correspond to Xtext-style validation with severity levels: error vs warning.
- **Rules 9–11** (what goes inside or outside the boundary) are about **where symbols are drawn**, which is concrete syntax, unless the metamodel records containment. A good exercise is deciding which rules belong to the abstract syntax (§2.3) and which only to the notation.
- **Pre/post-conditions are deliberately *not* OCL.** The authors choose natural language "to minimize the learning curve for non-software engineering team members". This is the opposite trade-off from §3.1 ("formal languages … are preferred", the *"Please no underaged employees"* footnote). The BPMN→SBVR paper takes a middle path with *controlled* natural language.

> ⚠ **About the notes.** §3.5 describes `oclIsTypeOf(t)` as true "if `t` is either the direct type or one of the supertypes". That is the definition of **`oclIsKindOf`**. `oclIsTypeOf` is true **only** for the exact type. The sketch above uses `oclIsKindOf` for that reason.

### 3.5 Where transformations would fit (§5, §7)
The paper says the approach "can be adapted and integrated within a game based MBD process (using model transformations and code generation)", and survey participants asked for **test scenarios generated from use cases**. Both are transformations the course covers:
- **M2M (§5–6):** game use-case model → design model. The Context Mapper paper's Step 1 is a worked example of turning use cases into entities and operations.
- **M2T (§7):** the **Acceleo "Simple Activity Language" example** maps almost one-to-one onto this notation:

| Acceleo Fibonacci example (§7.4) | Game use-case model |
|---|---|
| each action → a method | each `«Function»` use case → a method on the actor's `MonoBehaviour` |
| "go to next action" → call next method | `include` → unconditional call |
| condition → `if`/`else` | `extend` + extension point condition → `if (cond) …` |
| stop action prints variables | `«LoadScene»` → `SceneManager.LoadScene(...)` |

A sketch (illustrative metamodel, assuming the Ecore version from §3.3):
```
[template public generateActor(a : GameActor)]
[file (a.name + '.cs', false, 'UTF-8')]
using UnityEngine;

public class [a.name/] : MonoBehaviour {
[for (uc : GameUseCase | a.useCases->select(u | u.type = GameUseCaseType::Function))]
    public void [uc.name.replaceAll(' ', '')/]() {
    [for (i : Include | uc.include)]
        [i.addition.name.replaceAll(' ', '')/]();
    [/for]
    }
[/for]
}
[/file]
[/template]
```

### 3.6 MDE motivation (§1.2, §1.5, §2.1)
- Game designers' reluctance ("models … would restrict creativity") is a domain-specific version of the **model burning party** (§1.2).
- The whole paper is about the MDE promise of "model languages intended for the domain experts … better communication" (§1.5). Its survey measures that promise (understandability, learnability, usefulness). The approach appealed **more** to people *without* prior modeling experience.
- In terms of §2.1, these diagrams are **sketches**: "used for communication, often partial/incomplete views". The authors say their example models "do neither cover fully all aspects nor all components", and the template even has a literal *sketch* field. They are not blueprints, and they are certainly not programs.

---

## Cross-cutting themes

### Transformation taxonomy (§5.3)

| | **Horizontal** (same abstraction level) | **Vertical** (refinement, details added) |
|---|---|---|
| **Exogenous** (different metamodels) | **BPMN → SBVR** (translation between languages) | *game use cases → code* (proposed, §3.5 above) |
| **Endogenous** (same metamodel) | **Context Mapper architectural refactorings** | **Context Mapper rapid-prototyping chain** |

### Graphics *and* text
All three papers pair a graphical notation with a textual one:
- **BPMN → SBVR:** generates text *from* diagrams.
- **Context Mapper:** generates diagrams *from* text.
- **Game use cases:** attaches a textual template to each diagram element.

In each case this is "one abstract syntax, several concrete syntaxes" (§4.2), chosen because different readers prefer different forms.

### Precision vs accessibility (§3, §4)
A spectrum from formal to free:
- OCL (§3), fully formal
- SBVR controlled natural language (formal semantics, English surface)
- CML (a formal textual DSL in domain vocabulary)
- game use-case templates (free natural language)

Each paper picks its point on this spectrum depending on who must read the models.

### Model quality decides output quality (§1.5, §3)
- **BPMN → SBVR:** invalid inputs produced invalid rules.
- **Context Mapper:** validators enforce the semantic rules.
- **Game use cases:** strict and soft rules.

All three need **well-formedness constraints on the source models**, which is the job of OCL and of Xtext validators.

### One language or many (§4 take-home messages)
- **BPMN → SBVR:** *integrates two* existing standards.
- **Context Mapper:** puts requirements, analysis and design *in one* DSL.
- **Game use cases:** *refuses* multi-diagram approaches.

These are three different answers to the "language cacophony" risk.
