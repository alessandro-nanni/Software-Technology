# Transformation diagrams for the three papers

Mermaid diagrams of each paper's transformations: chain, metamodel-based pattern, rule tree, dependencies, levels. Each section ends with a table of transformation properties: cardinality, direction, in-place/out-place, and so on.

Text versions of the same material are in [mde-breakdown.md](mde-breakdown.md).

**Legend** (used in every diagram):

```mermaid
flowchart LR
    M[("model")]:::model
    A["automatic transformation / rule"]:::auto
    H["manual step"]:::manual
    T[/"text or code artefact"/]:::text
    E{{"engine / tool"}}:::engine
    M -- "data: read / write" --> A
    A ==> H
    A -. "dependency / trace / conformsTo" .-> M
    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef auto fill:#dcfce7,stroke:#15803d,color:#000
    classDef manual fill:#ffedd5,stroke:#c2410c,color:#000
    classDef text fill:#f3e8ff,stroke:#7e22ce,color:#000
    classDef engine fill:#f1f5f9,stroke:#334155,color:#000
```

Thick arrows (`==>`) show execution order, plain arrows show data flow, and dotted arrows show dependencies, traces or conformance.

**In-place vs out-place:** an *out-place* transformation creates a new target model and leaves the source untouched. An *in-place* transformation modifies the source model itself, so source and target are the same model.

---

## 1. BPMN → SBVR process rules

### 1.1 Transformation chain (Fig. 1, p. 6)

```mermaid
flowchart TD
    BPMN[("BPMN process model<br/>«M2M input» · conforms to BPMN 2.0")]:::model

    subgraph S1["Stage 1 · vocabulary"]
        T11["1.1 Form general concepts<br/>noun concepts"]:::auto
        T12["1.2 Form verb concepts"]:::auto
    end

    subgraph S2["Stage 2 · rules"]
        T21["2.1 Form process rules<br/>T1–T9 + Algorithms 1–2"]:::auto
    end

    subgraph S3["Stage 3 · validation"]
        T31["3.1 Validate SBVR model<br/>manual · optional · business analyst"]:::manual
    end

    SBVR[("SBVR model<br/>vocabulary + process rules<br/>«M2M output»")]:::model
    M2T["Automatic M2T component<br/>rule patterns RP1–RP9 as text"]:::auto
    TXT[/"SBVR Structured English text<br/>for the VeTIS editor"/]:::text

    T11 ==> T12 ==> T21 ==> T31

    BPMN --> T11
    BPMN --> T12
    BPMN --> T21
    T11 -- "noun concepts" --> SBVR
    SBVR -. "reads noun concepts" .-> T12
    T12 -- "verb concepts" --> SBVR
    SBVR -. "reads vocabulary" .-> T21
    T21 -- "process rules" --> SBVR
    SBVR <--> T31
    BPMN --> M2T --> TXT

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef auto fill:#dcfce7,stroke:#15803d,color:#000
    classDef manual fill:#ffedd5,stroke:#c2410c,color:#000
    classDef text fill:#f3e8ff,stroke:#7e22ce,color:#000
```

Stage 1 comes from the authors' earlier papers; Stage 2 is the contribution of this paper. Stage 2 has **two inputs**, the BPMN model and the vocabulary already in the SBVR model. It writes back into that same SBVR model.

### 1.2 Metamodel-based transformation pattern

```mermaid
flowchart BT
    subgraph L3["M3"]
        MOF["MOF"]
    end
    subgraph L2["M2"]
        BMM["BPMN 2.0 metamodel<br/>in tool: UML + BPMN profile"]
        QMM["QVT metamodel"]
        SMM["SBVR metamodel<br/>in tool: UML + SBVR profile"]
    end
    subgraph L1["M1"]
        SRC[("Order Registration<br/>BPMN model · Fig. 5")]:::model
        TD["Transformation definition<br/>T1–T9 + Alg. 1–2 in QVT"]:::auto
        TGT[("SBVR vocabulary · Table 2<br/>+ process rules · Table 3")]:::model
    end
    subgraph EX["execution · not a meta-level"]
        ENG{{"QVT engine<br/>Model Integrator plug-in · MagicDraw"}}:::engine
    end

    BMM -. conformsTo .-> MOF
    QMM -. conformsTo .-> MOF
    SMM -. conformsTo .-> MOF
    SRC -. conformsTo .-> BMM
    TD -. conformsTo .-> QMM
    TGT -. conformsTo .-> SMM
    TD -. "refers to" .-> BMM
    TD -. "refers to" .-> SMM
    ENG -- executes --> TD
    ENG -- reads --> SRC
    ENG -- writes --> TGT

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef auto fill:#dcfce7,stroke:#15803d,color:#000
    classDef engine fill:#f1f5f9,stroke:#334155,color:#000
```

### 1.3 Rule tree: BPMN pattern → rule → SBVR rule pattern and modality (Table 1)

```mermaid
flowchart LR
    ROOT(["BPMN process pattern PPi"])

    ROOT --> P1["Sequence flow A → B"] --> T1["T1"]:::auto
    T1 --> R1["B after A, and if cond"]:::obl

    ROOT --> P2["Exclusive gateway"] --> T2["T2"]:::auto
    T2 --> R2a["branch with condition:<br/>B after A and if cond"]:::obl
    T2 --> R2b["branch without condition:<br/>B after A"]:::perm
    T2 --> R2c["converging: antecedents joined with OR"]:::obl

    ROOT --> P3["Inclusive gateway<br/>or conditioned flows from an activity"] --> T3["T3"]:::auto
    T3 --> R3["every branch, and if cond;<br/>converging joined with AND"]:::obl

    ROOT --> P4["Event-based gateway"] --> T4["T4"]:::auto
    T4 --> R4["each possible event after A"]:::perm

    ROOT --> P5["Parallel gateway"] --> T5["T5"]:::auto
    T5 --> R5["every branch;<br/>converging joined with AND"]:::obl

    ROOT --> P6["Boundary event on activity"] --> T6["T6"]:::auto
    T6 --> R6a["event when activity"]:::perm
    T6 --> R6b["next step after (event when activity)"]:::obl
    T6 --> R6c["interrupting only:<br/>activity after event"]:::pro

    ROOT --> P7["Data object"] --> T7["T7"]:::auto
    T7 --> R7a["output: data object is produced when …"]:::obl
    T7 --> R7b["input: activity only if data object<br/>is provided to participant"]:::perm

    ROOT --> P8["Data store"] --> T8["T8"]:::auto
    T8 --> R8a["output: data store is provided with data when …"]:::obl
    T8 --> R8b["input: activity only if data store<br/>is available to participant"]:::perm

    ROOT --> P9["Message flow between pools"] --> T9["T9 · 1 flow → 2 rules"]:::auto
    T9 --> R9a["send rule: obligatory for send task / event,<br/>permitted e.g. for manual task"]:::mix
    T9 --> R9b["receive rule: obligatory for receive task / event,<br/>permitted otherwise"]:::mix

    ROOT --> P10["Gateway → gateway cascade"] --> A12["Algorithms 1–2"]:::auto
    A12 --> R10["one rule combining all conditions;<br/>default flow → OTHERWISE / not(cond)"]:::obl

    classDef auto fill:#dcfce7,stroke:#15803d,color:#000
    classDef obl fill:#bfdbfe,stroke:#1e3a8a,color:#000
    classDef perm fill:#bbf7d0,stroke:#166534,color:#000
    classDef pro fill:#fecaca,stroke:#991b1b,color:#000
    classDef mix fill:#fef9c3,stroke:#a16207,color:#000
```

Colours: **blue = obligatory**, **green = permitted**, **red = prohibited**, **yellow = depends on the node type**.

**Element-level cardinality differs per rule:**
- T1: 1 flow → 1 rule
- T2–T5: 1 gateway → one rule per branch
- T9: 1 message flow → 2 rules
- cascades: N gateways → 1 rule

### 1.4 Dependencies: vocabulary, rules and the cascading-gateway recursion (§3.1, §3.3)

```mermaid
flowchart TD
    PRE["Input preconditions<br/>participants in pools/lanes<br/>every element named<br/>conditions on outgoing flows"]:::manual
    BV["BPMN vocabulary in SBVR<br/>task, event, gateway, …<br/>not shown in the paper"]:::model
    NC["Noun concepts · 1.1<br/>customer, provider, order"]:::model
    VC["Verb concepts · 1.2<br/>provider analyzes order"]:::model
    RULES["Rules T1–T9"]:::auto
    PR[("Process rules")]:::model

    PRE --> NC
    PRE --> VC
    NC -- "facts are built on terms" --> VC
    BV -. "tags concepts with BPMN type" .-> NC
    BV -. "tags concepts with BPMN type" .-> VC
    NC -- "gc(…)" --> RULES
    VC -- "vc(…) · rules are built on facts" --> RULES
    RULES --> PR

    subgraph CASC["Cascading gateways · backward chaining"]
        A1["Algorithm 1<br/>extractComplexRules(el)"]:::auto
        A2["Algorithm 2<br/>createPartialRule(GN)"]:::auto
        T25["T2–T5 on the boundary gateway<br/>extractSimpleRule"]:::auto
    end

    VC --> A1
    A1 -- "no gateway before el" --> T1c["T1"]:::auto
    A1 -- "for each gateway before el" --> A2
    A2 -- "recurse on GN_inc" --> A2
    A2 -- "GN_inc empty = boundary gateway" --> T25
    T25 -- "partial rule" --> A2
    A2 -- "partial antecedent + IF / OTHERWISE" --> A1
    A1 --> PR
    T1c --> PR

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef auto fill:#dcfce7,stroke:#15803d,color:#000
    classDef manual fill:#ffedd5,stroke:#c2410c,color:#000
```

### 1.5 Tool interaction (Fig. 2, p. 17)

```mermaid
sequenceDiagram
    actor BA as Business analyst
    participant BM as MagicDraw BPMN Modeler
    participant TP as Transformation plug-in
    participant MI as Model Integrator · QVT engine
    participant SM as SBVR Modeler · SBVR profile
    participant VT as VeTIS editor

    BA->>BM: model BPMN process
    BA->>TP: run M2M from context menu
    TP->>MI: execute QVT rules
    MI->>BM: read BPMN model
    MI->>SM: read vocabulary
    MI->>SM: write process rules
    BA->>TP: run M2T
    TP->>VT: SBVR Structured English text
    BA->>SM: validate vocabulary and rules (Stage 3)
```

### 1.6 Properties

| Property | Value | Source |
|---|---|---|
| Kind | M2M (BPMN → SBVR model) **and** M2T (BPMN → Structured English) | paper |
| Source / target metamodels | BPMN 2.0 / SBVR | paper |
| Endogenous / exogenous | Exogenous; arguably endogenous in the tool, where both are UML profiles | paper / my remark |
| Horizontal / vertical | Horizontal (CIM → CIM) | paper |
| Model cardinality | One-to-one per the authors; Stage 2 actually reads BPMN + vocabulary, so N-to-1 | paper / Fig. 1 |
| Element cardinality | 1→1 (T1), 1→n (T2–T5 per branch, T9 → 2 rules), n→1 (cascades) | Table 1, §3.3 |
| Direction | Unidirectional; SBVR → BPMN is future work | paper |
| In-place / out-place | Out-place for BPMN (read-only). **In-place update** of the SBVR model: Stage 2 adds rules to the vocabulary model | inferred from Fig. 1 |
| Style | Hybrid: declarative patterns + imperative recursion | paper |
| Rule scheduling | Deterministic; Stage 1 must finish before Stage 2 | paper |
| Automation | Stages 1–2 automatic, Stage 3 manual and optional | paper |
| Traceability | Concepts carry meta-information on their originating BPMN type; QVT trace implicit | §3.2 |
| Incremental | Not discussed | — |
| Language / engine | QVT / Model Integrator plug-in in MagicDraw | paper |

---

## 2. Context Mapper

### 2.1 Transformation chain (Fig. 3, p. 262)

```mermaid
flowchart TD
    W["Domain modeller writes<br/>use cases / user stories"]:::manual
    REQ[("Use cases / user stories<br/>CML · functional requirements")]:::model
    SD[("Subdomain<br/>CML · domain analysis")]:::model
    FBC[("Bounded Context · type FEATURE<br/>CML · strategic DDD")]:::model
    ABC[("Bounded Context · type APPLICATION")]:::model
    SYS[("2 Bounded Contexts · type SYSTEM<br/>frontend + backend + ContextMap<br/>CML · deployment")]:::model
    SUB[("More SYSTEM contexts<br/>e.g. logic tier + database tier")]:::model
    AR["Architectural refactorings<br/>split / merge / extract<br/>endogenous · horizontal"]:::auto
    CODE[/"JHipster microservices<br/>one per Bounded Context"/]:::text
    DIA[/"Graphical context maps<br/>UML / PlantUML"/]:::text

    W --> REQ
    REQ -- "Step 1 · N→1 · user picks use cases" --> SD
    SD -- "Step 2 · N→1 · user picks subdomains" --> FBC
    FBC -. "manual: resolve TODOs, set type APPLICATION" .-> ABC
    FBC -- "Step 3 · 1→2 + context map" --> SYS
    ABC -- "Step 3 · 1→2 + context map" --> SYS
    SYS -- "Steps 4..N · 1→2" --> SUB
    SUB -- "Steps 4..N · 1→2" --> SUB
    AR -. rewrites .-> FBC
    AR -. rewrites .-> SYS
    FBC == "M2T" ==> CODE
    SYS == "M2T" ==> DIA

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef auto fill:#dcfce7,stroke:#15803d,color:#000
    classDef manual fill:#ffedd5,stroke:#c2410c,color:#000
    classDef text fill:#f3e8ff,stroke:#7e22ce,color:#000
```

### 2.2 Element-level derivation and trace links for the worked example (Listings 5.1–5.4)

```mermaid
flowchart LR
    UC["UseCase Get_paid_for_car_accident<br/>actor Claimant · 6 interactions"]:::model
    SD["Subdomain ClaimsManagement<br/>Entities Claim, Policy, Contract, Agent, Claimant<br/>Service with 6 operations"]:::model
    BC["BoundedContext ClaimsManagement<br/>type FEATURE<br/>Aggregate ClaimsManagementAggregate"]:::model
    BE["BoundedContext ClaimsManagementBackend<br/>type SYSTEM · Java, Spring Boot"]:::model
    FE["BoundedContext ClaimsManagementFrontend<br/>type SYSTEM · Angular · Aggregate ViewModel"]:::model
    REL["Relationship Backend PL → CF Frontend<br/>RESTful HTTP · exposes ClaimsManagementAggregate"]:::model

    UC -- "Step 1" --> SD
    SD -- "Step 2" --> BC
    BC -- "Step 3" --> BE
    BC -- "Step 3" --> FE
    BC -- "Step 3" --> REL

    BC -. implements .-> SD
    BE -. implements .-> SD
    FE -. implements .-> SD
    REL -. upstream .-> BE
    REL -. downstream .-> FE

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
```

The `implements` links are **explicit trace links stored in the model**. They point back to the subdomain whatever step created the context.

### 2.3 Step 1 mapping: interaction → subdomain elements (Fig. 4, p. 264)

```mermaid
flowchart LR
    subgraph IN["One interaction of the use case"]
        V["verb: submit"]
        E["entity: Claim"]
        A["with its: date, amountClaimed, desc"]
        R["for a: Policy"]
    end
    subgraph OUT["Subdomain ClaimsManagement"]
        EN["Entity Claim<br/>created once per distinct name"]
        AT["attributes of Claim"]
        RF["reference on Policy:<br/>list of Claim"]
        OP["operation submitClaim<br/>on the subdomain Service"]
    end
    E --> EN
    A --> AT
    R --> RF
    V --> OP
    E --> OP
    AT -. "belong to" .-> EN
```

Entities that appear in several interactions are **merged by name**: `Claim` gets contributions from interactions 1, 3 and 6. There is **one operation per interaction**.

### 2.4 Metamodel-based transformation pattern (endogenous)

```mermaid
flowchart BT
    subgraph L3["M3"]
        ECORE["Ecore"]
    end
    subgraph L2["M2"]
        CMLMM["CML metamodel<br/>Ecore generated from the Xtext grammar"]
        TL["Transformation language<br/>not named in the paper"]
    end
    subgraph L1["M1"]
        SRC[("Use-case model<br/>Listing 5.1")]:::model
        TDEF["Step 1 … N definitions"]:::auto
        TGT[("Subdomain / Bounded Context model<br/>Listings 5.2–5.4")]:::model
    end
    subgraph EX["execution · not a meta-level"]
        ENG{{"Context Mapper plug-in<br/>Eclipse / VS Code"}}:::engine
    end

    CMLMM -. conformsTo .-> ECORE
    TL -. conformsTo .-> ECORE
    SRC -. conformsTo .-> CMLMM
    TGT -. conformsTo .-> CMLMM
    TDEF -. conformsTo .-> TL
    TDEF -. "refers to, as source AND target" .-> CMLMM
    ENG -- executes --> TDEF
    ENG -- reads --> SRC
    ENG -- writes --> TGT

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef auto fill:#dcfce7,stroke:#15803d,color:#000
    classDef engine fill:#f1f5f9,stroke:#334155,color:#000
```

### 2.5 Abstraction levels vs meta-levels: vertical **and** endogenous

```mermaid
flowchart LR
    subgraph M2L["M2"]
        MM["CML metamodel"]
    end
    subgraph M1L["M1 · all CML models"]
        direction TB
        CIM["CIM<br/>use cases, subdomains"]:::model
        PIM["PIM<br/>FEATURE / APPLICATION context"]:::model
        PSM["PSM<br/>SYSTEM contexts + implementationTechnology"]:::model
        CIM -- "Steps 1–2" --> PIM
        PIM -- "Step 3" --> PSM
    end
    CODE[/"Code<br/>JHipster microservices"/]:::text

    PSM == "M2T" ==> CODE
    CIM -. conformsTo .-> MM
    PIM -. conformsTo .-> MM
    PSM -. conformsTo .-> MM

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef text fill:#f3e8ff,stroke:#7e22ce,color:#000
```

The chain goes **down in abstraction** while every model **conforms to the same metamodel**. The abstraction level is encoded in the context `type` and `implementationTechnology`, not in a change of language.

### 2.6 Properties

| Property | Rapid-prototyping steps | Architectural refactorings | Code / diagram generation | Source |
|---|---|---|---|---|
| Kind | M2M | M2M | M2T | paper |
| Source / target metamodels | CML / CML | CML / CML | CML / Java project, diagrams | paper |
| Endogenous / exogenous | Endogenous | Endogenous | Exogenous (to text) | paper |
| Horizontal / vertical | Vertical | Horizontal | Vertical | my classification |
| Model cardinality | Step 1 N→1, Step 2 N→1, Step 3 1→2 (+ map), Steps 4..N 1→2 | split 1→2, merge 2→1, extract 1→2 | 1 BC → 1 microservice | paper |
| Direction | Unidirectional | Unidirectional | Unidirectional; reverse engineering from code is future work | paper |
| In-place / out-place | **In-place update**: derived elements are added to the same CML model, inputs kept | **In-place**: the CML model is rewritten | Out-place | inferred (not stated) |
| Automation | Semi-automatic: user selects inputs, output has `TODO` hints | Semi-automatic | Automatic | paper |
| Traceability | Explicit `implements` (BC → Subdomain); `exposedAggregates` on relationships | — | — | listings |
| Incremental | Not discussed | — | — | — |
| Language / engine | Not named / Context Mapper plug-in | Not named | JHipster | paper |

---

## 3. Game use-case modeling

**The paper defines no transformations.** The diagrams show what the tool does, the metamodel any transformation would read, the constraint tree, and a *proposed* chain (my proposal, marked as such).

### 3.1 What GUCM does (§5, p. 92–95)

```mermaid
flowchart LR
    ED["Graphical + textual editing<br/>palette and description forms"]:::manual
    CHK{"strict rule<br/>violated?"}
    REJ["action rejected<br/>error dialog"]:::manual
    MOD[("Game use-case model<br/>C# objects in GUCM")]:::model
    SOFT{"soft rule<br/>violated?"}
    WARN["warning listed<br/>model stays valid"]:::manual
    JSON[/"JSON file"/]:::text
    PNG[/"PNG image"/]:::text

    ED --> CHK
    CHK -- yes --> REJ --> ED
    CHK -- no --> MOD
    MOD --> SOFT
    SOFT -- yes --> WARN
    MOD == save ==> JSON
    JSON == load ==> MOD
    MOD == export ==> PNG

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef manual fill:#ffedd5,stroke:#c2410c,color:#000
    classDef text fill:#f3e8ff,stroke:#7e22ce,color:#000
```

Saving and loading are **serialisation**, not transformation. PNG export renders the concrete syntax.

### 3.2 Source metamodel for any transformation (Fig. 1, p. 89, simplified)

```mermaid
classDiagram
    class Actor
    class UseCase
    class Include
    class Extend
    class ExtensionPoint
    class Constraint
    class GameActor {
        type : GameActorType
        gameActorName : String
        gameActorDescription : String
    }
    class GameUseCase {
        type : GameUseCaseType
        gameUseCaseName : String
        gameUseCaseDescription : String
        priority : Integer
        gameUseCaseSketch : String
        preConditions : String [*]
        postConditions : String [*]
        flowOfEvents : String [*]
    }
    class GameActorType {
        <<enumeration>>
        User
        PlayerCharacter
        NonPlayerCharacter
    }
    class GameUseCaseType {
        <<enumeration>>
        Function
        LoadScene
        PlayAnimation
        PlayAudio
        CreateObject
    }
    Actor <|-- GameActor
    UseCase <|-- GameUseCase
    GameActor ..> GameActorType
    GameUseCase ..> GameUseCaseType
    UseCase "1" *-- "*" Include : include
    Include --> "1" UseCase : addition
    UseCase "1" *-- "*" Extend : extend
    Extend --> "1" UseCase : extendedCase
    UseCase "1" *-- "*" ExtensionPoint : extensionPoint
    Extend --> "1..*" ExtensionPoint : extensionLocation
    Extend *-- "0..1" Constraint : condition
```

### 3.3 Well-formedness rule tree (§4.2, p. 91–92)

```mermaid
flowchart LR
    WF(["Well-formedness rules"])
    WF --> ST["11 strict rules<br/>error · enforced by GUCM"]:::pro
    WF --> SO["5 soft rules<br/>warning only"]:::mix

    ST --> SA["abstract syntax · rules 1–8<br/>expressible in OCL"]
    SA --> s1["1 actor linked to ≥ 1 use case"]
    SA --> s2["2 use case linked to ≥ 1 actor or use case"]
    SA --> s3["3 names present and unique"]
    SA --> s4["4 not include AND extend the same use case"]
    SA --> s5["5 no self include / extend"]
    SA --> s6["6 exactly 1 extension point per extend<br/>narrows UML 1..*"]
    SA --> s7["7 extension points only on extend"]
    SA --> s8["8 extension point not shared"]

    ST --> CS["concrete syntax · rules 9–11<br/>placement, not in the metamodel"]
    CS --> s9["9 game use cases inside boundary"]
    CS --> s10["10 PlayerCharacter / NPC inside boundary"]
    CS --> s11["11 User actors outside boundary"]

    SO --> AU["actor–use case · rule 1<br/>User only with non-gameplay use cases"]
    SO --> UU["use case–use case · rules 2–5"]
    UU --> o2["2 nothing includes LoadScene"]
    UU --> o3["3 PlayAnimation and LoadScene include nothing"]
    UU --> o4["4 LoadScene extends only Function / PlayAnimation"]
    UU --> o5["5 LoadScene never extends PlayAudio,<br/>CreateObject or LoadScene"]

    classDef pro fill:#fecaca,stroke:#991b1b,color:#000
    classDef mix fill:#fef9c3,stroke:#a16207,color:#000
```

**Which relationships the soft rules allow between use-case types** (row → column):

| includes → | Function | LoadScene | PlayAnimation | PlayAudio | CreateObject |
|---|---|---|---|---|---|
| **Function** | ✓ | ✗ | ✓ | ✓ | ✓ |
| **PlayAudio** | ✓ | ✗ | ✓ | ✓ | ✓ |
| **CreateObject** | ✓ | ✗ | ✓ | ✓ | ✓ |
| **PlayAnimation** | ✗ | ✗ | ✗ | ✗ | ✗ |
| **LoadScene** | ✗ | ✗ | ✗ | ✗ | ✗ |

| extends → | Function | LoadScene | PlayAnimation | PlayAudio | CreateObject |
|---|---|---|---|---|---|
| **LoadScene** | ✓ | ✗ | ✓ | ✗ | ✗ |
| **any other type** | ✓ | ✓ | ✓ | ✓ | ✓ |

### 3.4 Proposed transformation chain (my proposal; the paper only hints at it on p. 85 and p. 111)

```mermaid
flowchart TD
    JSON[/"GUCM JSON file"/]:::text
    GUC[("Game use-case model<br/>Ecore / XMI · CIM")]:::model
    UML[("UML class + state-machine model<br/>PIM")]:::model
    CS[/"Unity C# MonoBehaviour skeletons<br/>one file per actor"/]:::text
    TS[/"Test scenarios<br/>flow of events + extend conditions"/]:::text
    TL[/"Task list per discipline<br/>animation → artists · audio → audio team<br/>scene → level designers · function → programmers"/]:::text

    JSON -- "T0 · text-to-model injection · 1→1" --> GUC
    GUC -- "T1 · ATL / QVTo · exogenous · vertical · 1→1 · out-place" --> UML
    UML == "T2 · Acceleo M2T · 1→N files" ==> CS
    GUC == "T3 · Acceleo M2T · 1 use case → 1 scenario" ==> TS
    GUC == "T4 · M2T · group by GameUseCaseType" ==> TL

    classDef model fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef text fill:#f3e8ff,stroke:#7e22ce,color:#000
```

### 3.5 Properties (of the proposed chain)

| Property | T1 GameUC → UML | T2 UML → C# | T3 GameUC → tests |
|---|---|---|---|
| Kind | M2M | M2T | M2T |
| Endogenous / exogenous | Exogenous | Exogenous | Exogenous |
| Horizontal / vertical | Vertical (CIM → PIM) | Vertical (PIM → code) | Horizontal (same requirements, different form) |
| Cardinality | 1→1 model; per element `Function` → operation, `extend` + condition → guarded transition | 1 model → N files | 1 use case (+ its extends) → 1 scenario |
| Direction | Unidirectional | Unidirectional | Unidirectional |
| In-place / out-place | Out-place | Out-place | Out-place |

---

## 4. Cross-paper view

```mermaid
flowchart TB
    subgraph EXO["Exogenous · different metamodels"]
        direction LR
        H1["Horizontal<br/>BPMN → SBVR"]:::p1
        V1["Vertical<br/>game use cases → Unity code<br/>proposed"]:::p3
    end
    subgraph ENDO["Endogenous · same metamodel"]
        direction LR
        H2["Horizontal<br/>Context Mapper refactorings"]:::p2
        V2["Vertical<br/>Context Mapper prototyping chain"]:::p2
    end

    classDef p1 fill:#dbeafe,stroke:#1d4ed8,color:#000
    classDef p2 fill:#dcfce7,stroke:#15803d,color:#000
    classDef p3 fill:#ffedd5,stroke:#c2410c,color:#000
```

| | BPMN → SBVR | Context Mapper | Game use cases |
|---|---|---|---|
| Transformations | M2M + M2T | M2M chain + refactorings + M2T | none (proposed only) |
| Exo / endo | exogenous | endogenous | — |
| Horizontal / vertical | horizontal | vertical + horizontal | — |
| Model cardinality | 1-1 claimed, N-1 in practice | N-1, N-1, 1-2, 1-2 | — |
| Direction | unidirectional | unidirectional | — |
| In-place / out-place | out-place for BPMN, in-place update of SBVR | in-place update of the CML model (inferred) | — |
| Style | hybrid | not stated | — |
| Human in the loop | optional validation | input selection + `TODO` refinement | all modelling is manual |
| Traceability | BPMN type tags on concepts | explicit `implements` links | — |
