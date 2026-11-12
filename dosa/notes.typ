#import "../mono.typ": *
#show: template.with(blue, red, [Design of Software Architectures])

= What is software architecture?

There is no single definition. The course uses three.

#def[Textbook][
  The bridge between abstract *business goals* and the concrete *final system*.

  Architecture is a *set of structures* (modules, components and connectors, allocation) that helps you *reason about the system's properties* that matter to some stakeholders.
]

#def[Deckers and ISO 42010][
  A *collection of statements* (software elements, relations, guidelines, ...) that gives direction to the *application*, the *design* and the *realisation* of the software in its *environment*.
]

#def[ISO 42010 (2022)][
  The *fundamental concepts or properties* of an entity in its environment, plus the *governing principles* for its realisation and evolution.
]

An architecture can be about:
- the parts of the entity and how they interact;
- how the entity interacts with its environment;
- its behaviour and structure;
- the principles behind its design, use, operation and evolution.

#i[
  - Architecture is an *abstraction* of a system: it leaves out details.
  - Architecture *is* design, but *not all design is architecture*. Only the fundamental, hard to change choices are.
]

== Concept or property?

ISO says "concepts *or* properties" on purpose, to allow two views:
- *Architecture as concept*: an idea of the entity in someone's mind.
- *Architecture as property*: something the entity actually has.

Organisations use four metaphors for architecture: *blueprint*, *literature*, *language*, *decision*. The standard works with all of them.

== Architecture vs architecture description

#table(
  columns: (1fr, 1fr),
  [Architecture], [Architecture Description (AD)],
  [Abstract, intangible], [Concrete, tangible work product],
  [Understood through concepts, properties, principles], [Written for a specific purpose and audience],
  [One per entity], [Can be many per architecture (per stakeholder group, time period, context)],
)

An AD *expresses* an architecture. Writing an AD is the main output of *architecting*: conceiving, defining, documenting, communicating, checking and improving an architecture over the whole life cycle of an entity.

== Software, system and enterprise architecture

Three levels that overlap:
- *Enterprise*: business and organisation. Build or buy? Which teams work together?
- *System*: the whole product, hardware plus software. Which sensors and computers? End to end timing.
- *Software*: the software parts and how they communicate.

#n[Example: autonomous parking in a new car][
  #table(
    columns: (1fr, auto),
    [Decision], [Level],
    [Develop the parking software in house or outsource it?], [Enterprise],
    [Which cameras, ultrasonic sensors and computing hardware?], [System],
    [How perception, planning and vehicle control components communicate], [Software],
    [Which engineering teams must work together to deliver and maintain it?], [Enterprise],
    [Max time between detecting an obstacle and braking], [System],
  )
  If management buys a closed solution that only works with the supplier's own sensors and platform, an enterprise decision fixes the system choices and removes control over the software.
]

#i[The levels are not independent: a decision at one level constrains the others, so all three need a say.]

== What makes a good architecture?

- Based on a *prioritised* list of quality requirements.
- Delivers the system's important *quality attributes* (QAs).
- *Documented* (views, rationale, ...).
- Made of well defined modules based on *information hiding* and *separation of concerns*.
- Allows *incremental* implementation.
- Lets you find problems *early*.
- Defines *interfaces* so teams can develop parts independently.
- Never depends on a *specific version* of a commercial product or tool.
- Uses a *small number of simple* interaction patterns between components.
- Has a small, explicit set of places where parts *compete for shared resources*.

== Why is architecture important?

- Supports *communication* with stakeholders.
- Fixes the system's driving *QAs*.
- Holds the most fundamental, *hardest to change* decisions.
- Sets *constraints* on the implementation.
- Focuses on *assembling* components, not only building them.
- Shapes the *structure of the organisation* (and the other way round).
- Lets you reason about *cost and schedule*.
- Is a *reusable* model, the core of product lines.
- Is a base for *training* new team members.

ISO adds more uses of an AD: basis for design and development, comparing alternatives, maintenance docs, input to tools and simulation, contracts and tenders, planning migration from a legacy system, compliance and certification, sharing lessons learned.

= System scope and environment

== System scope

Define what your system is:
- what is *inside* and what is *outside*;
- the *external entities* it interacts with;
- its essence in a few sentences (or a diagram).

#i[The system *boundary is your choice*. Make it explicit what your architecture covers and what is *out of scope*. This can change during the project.]

== Architecture Reasoning Model (Deckers)

Three rings around the system. Each inner area is linked to an outer one:

#table(
  columns: (auto, 1fr, auto),
  [Inner (system)], [Questions], [Outer (environment)],
  [Application], [Who uses it? For what? In which context?], [Customer value],
  [Technical design], [Which technologies? Platforms?], [Resource technology],
  [Realisation activity], [Which process? Organisations? Activities?], [Process and organisation],
)

The system also has a *life cycle*: idea, concept, development, use, maintenance, end of life. The architecture must make sense across all of it.

== Environment

#def[Environment][
  The context of surrounding things, conditions or influences on an entity.
]

Influences can be technical, business, operational, organisational, political, economic, legal, ecological, social or physical. The environment covers what acts *on* the system and what the system does *to* its surroundings, over its whole life.

What to describe (as in ISO 42010):
- *stakeholders* and their *concerns*;
- main *requirements*, *use cases* and *QAs*;
- *related systems* and organisations;
- *trends and developments*.

= ISO/IEC/IEEE 42010

A standard for *architecture descriptions* of any entity: software, systems, enterprises, product lines, systems of systems, ...

It says *what an AD must contain*. It does *not* say:
- what a good architecture is;
- which process, method, notation or tool to use;
- which format or medium to use;
- which viewpoints to use.

Words used in requirements: *shall* = required, *should* = recommended, *may* = allowed.

#n[2011 vs 2022][
  The lecture diagrams use the 2011 version. The 2022 version renames some terms:
  - system of interest #sym.arrow *entity of interest* (EoI);
  - architecture model #sym.arrow *view component*;
  - architecture framework #sym.arrow *architecture description framework* (ADF);
  - correspondence rule #sym.arrow *correspondence method*.
  It also adds *aspects*, *stakeholder perspectives* and *legends*, and a viewpoint can now govern more than one view.
]

== Conceptual model

#figure(
  image("img/iso-ad.png", width: 100%),
)

Main relations:
- A *system* (EoI) is *situated in* exactly one *environment*.
- *Stakeholders* have interests in the system and *have concerns*.
- The system *exhibits* an *architecture*; an *AD expresses* it.
- The AD identifies the system, its stakeholders and concerns.
- The AD contains *viewpoints*, *views*, *rationale* and *correspondences*.
- A *viewpoint frames* concerns and *governs* views.
- A *view addresses* concerns and is made of models (view components).
- A *model kind governs* a model, and a viewpoint uses model kinds.

== Key terms

#table(
  columns: (auto, 1fr),
  [Term], [Meaning],
  [Entity of interest (EoI)], [The subject of the AD: the thing being described.],
  [Stakeholder], [Person, role, group or organisation with an interest, right or claim in the EoI.],
  [Concern], [A matter that is relevant or important to a stakeholder.],
  [Stakeholder perspective], [A way of thinking about the EoI.],
  [Aspect], [A part of the EoI's character (structure, behaviour, ...).],
  [Viewpoint], [Conventions to create, read and use a view that frames some concerns.],
  [View], [A part of the AD that addresses concerns, following one viewpoint.],
  [View component], [A separable part of one or more views.],
  [Model kind], [A category of model with its own conventions (use case, data flow, ...).],
  [Legend], [Informal description of the conventions of a view component.],
  [AD element], [Any named part of an AD: stakeholders, concerns, views, ...],
  [Correspondence], [A named relation between two or more AD elements.],
  [ADF], [Conventions and practices for describing architectures in a domain.],
  [ADL], [A language (syntax and semantics) to describe architectures.],
)

== Stakeholders and concerns

Stakeholders are anyone with a direct or indirect interest: those who *control or influence* the EoI and those *affected* by it.

Examples: users, operators, buyers, owners, suppliers, architects, developers, maintainers, testers, regulators, the public, competitors, adversaries.

#i[Some stakeholders work *against* the EoI (protesters, attackers). Their concerns still matter: handle them with a negotiated solution or with preventive measures.]

*Concerns*:
- The relation stakeholder to concern is *many to many*.
- They can appear at any point of the life cycle.
- They show up as needs, goals, requirements, constraints, assumptions, dependencies, QAs, risks, ...
- Write them as *questions*: easier to communicate. E.g. "How is the system maintained?", "Which behaviours are safety critical?", "What does it cost to operate?"

The term comes from Dijkstra's *separation of concerns*: study one concern at a time, knowing the others exist.

== Stakeholder perspectives and aspects

#def[Stakeholder perspective][
  A way of thinking about the EoI, shaped by role, training, experience, culture, ... It is *subjective*.

  E.g. operational vs financial view of a factory; developer vs user view of an app.
]

#def[Aspect][
  A part of the EoI's character or nature. It is more *objective*: it comes from experts agreeing on good practice in a domain.

  E.g. structural, behavioural, functional, informational aspects.
]

#table(
  columns: (1fr, 1fr),
  [Perspective], [Aspect],
  [*How* you look at the EoI], [*What* you look at in the EoI],
  [Comes from the stakeholder], [Comes from the domain and experience],
  [Each one leads to concerns], [Refines concerns; many to many],
  [Rows of an ADF grid], [Columns of an ADF grid],
)

Why aspects are useful:
- You often *don't know all stakeholders* at the start. Build views for the usual aspects, show them around, and stakeholders will reveal their concerns.
- Quality attributes ("ilities", non functional requirements) are concerns structured through aspects. E.g. security can be checked through the behavioural, structural and organisational aspects.

#i[Don't let aspects and perspectives from past projects hide *new* concerns.]

*Architecture considerations* is the umbrella term for concerns, perspectives, aspects and other factors (can the stakeholders read the chosen notation? how formal must it be? which tools, time and resources are there?).

== Viewpoints and views

#def[Architecture viewpoint][
  A set of conventions to *create*, *interpret* and *use* a view that frames one or more concerns.
]

#def[Architecture view][
  A part of the AD that expresses the architecture from one viewpoint and *addresses* its concerns.
]

- The viewpoint *frames* the concerns (states the problem). The view *addresses* them (solves it).
- A viewpoint is *reusable* across many systems; a view is that viewpoint *applied to one* system.
- Each view follows *exactly one* viewpoint. A viewpoint can govern several views.
- A viewpoint is a *contract* between architect and stakeholders: agree on notation before the work starts.

#n[Analogy][
  In a building, "electrical plan" is a viewpoint (symbols, rules, who reads it). The electrical plan of *your* house is a view.
]

=== View components, model kinds and legends

A view is made of one or more *view components*:
- *Model based* component: governed by a *model kind* (use case, activity model, threat model, component model, ...).
- *Non model* component (e.g. text, expert opinion): documented by a *legend*.

A component can be *shared* by several views. This avoids repeating information and reduces inconsistencies.

E.g. a functional view can contain a data flow diagram, a control flow diagram and some text explaining them. The data flow diagram can also appear in a security view.

=== View methods

Guidance attached to a viewpoint:
- *Construction*: how to build the view (steps, templates, patterns).
- *Interpretation*: how stakeholders should read it.
- *Analysis*: how to check, reason about and evaluate it.

=== Building views

- *Synthetic*: build each view separately, then link them with correspondences.
- *Projective*: derive each view from one shared underlying model.

=== Known viewpoint sets

- *Kruchten 4+1*: logical, development, process, physical, tied together by scenarios.
- *Views and Beyond* (Clements): module, component and connector, allocation.
- *Rozanski and Woods*: functional, information, concurrency, development, deployment, operational.

=== Specifying a viewpoint

A viewpoint specification lists: name and overview, concerns framed (and what it is *not* for), perspectives, aspects, typical stakeholders, model kinds, correspondence methods, view methods, examples, sources.

A model kind is often defined by a *metamodel*: its entities, attributes, relationships and constraints.

== Correspondences

#def[Correspondence][
  A named relation between two or more AD elements, inside one AD or across several.
]

Used for: composition, refinement, consistency, traceability, dependency, constraint, satisfaction, obligation.

#def[Correspondence method][
  A rule that correspondences must satisfy.
]

#n[Example][
  Correspondence "bundled on": a matrix that maps software applications (Autopilot, Braking, GPS, ...) to ECUs 1 to 4.

  Method M1: every application must be bundled on at least one ECU. If every row of the matrix has a mark, M1 holds.
]

For each method the AD records whether it *holds* or lists its *violations*. The AD must also record any *known inconsistencies*.

== Decisions and rationale

#def[Architecture decision][
  A set of choices made for the architecture: styles, patterns, tactics, layering, technologies, frameworks, ...
]

#def[Rationale][
  *Why* a decision was taken: its basis, impact on QAs, alternatives and tradeoffs considered, consequences, principles, sources.
]

Decisions worth recording are those that:
- concern architecturally significant requirements or fundamental concerns (performance, safety, ...);
- need a big investment or affect many or key stakeholders;
- need non obvious reasoning;
- are sensitive to change or *costly to change*;
- are the base for planning;
- replace assumptions with facts;
- relate to compliance, standards or vulnerabilities.

For each decision, consider recording: an ID, a clear statement, its owner, constraints and assumptions, the concerns it addresses, the elements it affects, its rationale, links to other decisions (constrains, enables, conflicts with, ...), consequences, dates, sources.

#i[Also record *rejected alternatives* and why. If the reasons change later, you know what to revisit.]

== What an AD must contain

#table(
  columns: (auto, 1fr),
  [Part], [Requirement],
  [Overview], [EoI, its environment, purpose of the AD, identifying info (version, authors, ...).],
  [Stakeholders], [Those with concerns fundamental to the architecture; impact on them; limits that stopped you from covering some.],
  [Perspectives], [Linked to the stakeholders who hold them and to their concerns.],
  [Concerns], [Linked to the stakeholders who hold them.],
  [Aspects], [Linked to the concerns they apply to.],
  [Viewpoints], [Every concern framed by at least one viewpoint.],
  [Views], [At least one per viewpoint. Every concern, perspective and aspect addressed by at least one view.],
  [Consistency], [Correspondences, correspondence methods, known inconsistencies.],
  [Decisions], [Essential decisions with their rationale.],
)

Each view must state its viewpoint, its components, and its *known issues* (open problems, risks, deviations). A view does not need to cover the whole EoI.

== Frameworks and languages

#def[Architecture Description Framework (ADF)][
  Conventions, principles and practices for describing architectures in a *specific domain or community* (defence, banking, ...). It must define typical stakeholders, typical concerns and the viewpoints that frame them.

  E.g. Zachman, TOGAF, UAF, NAF, RM-ODP, GERAM.
]

- Usually organised as a *grid*: rows are perspectives, columns are aspects.
- ADFs go from *generic* (any domain) to *partial* (one domain) to *particular* (one project). The more specific, the less you need to adapt it.
- An AD can follow zero, one or more ADFs.

#def[Architecture Description Language (ADL)][
  A way of expressing architectures, with *syntax and semantics*.

  E.g. UML, SysML, ArchiMate, AADL, BPMN.
]

- An AD can use several ADLs (even one per model kind), but mixing them needs care.
- Older ADLs only covered structure (components, connectors). Newer ones cover more concerns.

== AD in the life cycle

- Architecting happens across the *whole life* of the EoI, not only at the start: concept, development, use, refurbishment, retirement.
- The architecture should stay stable for long periods. It evolves in small steps, and sometimes needs full rearchitecting.
- The AD has its own life cycle: drafted, elaborated, evaluated, released, updated.
- Architects talk with stakeholders *both ways*: to learn from them and to inform them.
