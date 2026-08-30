#import "../mono.typ": *
#import "@preview/fletcher:0.5.8" as fletcher: diagram, edge, node
#show: template.with(rgb("#00aa88"), rgb("#ffaa00"), [Software Testing and Risk Assessment])

= Introduction
== Testing Basics
A test consists of a setup, operations and actions to execute the program/system, and a check to see if the expected result has been obtained.

There are different levels of testing:
- User acceptance test (#sym.arrow.t cost #sym.arrow.b execution time)
- System/end-to-end tests
- Integration tests
- Unit test (#sym.arrow.b cost #sym.arrow.t execution time)

Focus on functional testing (what the system should do).
Tests can be classified by level of automation.
- Manual testing
- Automated testing (no human running the tests)
    - Recorded tests
    - Scripted testing
    - Keyword driven testing
    - Testing as part of behavior driven development
- Model based testing: testing generation is also automated.

#figure(
    table(columns: 3)[Methodology][Definition Effort][Execution Effort][Manual testing][High][High][Automated Testing][High][Low][Model Based Testing][Low][Low],
)
Different techniques should be used for different projects. Manual testing is unavoidable in legacy systems.

== Test Driven Development
Tests are written before the code. It's a design strategy focused on the what rather than the how. Issues are actively looked for, rather than confirming expectations. The quality of the project is increased trough small incremental changes. TDD is traditionally applied in unit testing, but it's also possible to use it in integration and system tests.

Rules:
+ No code before failing test is written
+ No more tests than sufficient to fail
+ No more code than sufficient to pass tests

TDD is a discipline, design details are needed. The expected result might be unknown.

== Regression Testing
Testing after every change to the source code guarantees that nothing broke between changes. This makes the behavior of code immediately recognizable, and allows to monitor the functioning of your software system. Potential introduced errors are detected earlier (less expensive in the long term).

Regression testing should be done
- After implementing a new feature to be sure that previously implemented features still work
- After refactorings to make sure that the functionality is not affected.

Automated tests are re-executed after each change in the code through a continuous integration (CI) pipeline.
- All tests are executed automatically after every push to the repository
- Avoid merging code with failing tests on the main branch
- Prevent bugs from carrying on into other features/development cycles.

== System Testing
Systems tests are used to test functionality/behavior/features at the system level, interactions between user and system. The entire software system is treated as a sealed container. They test what the system is supposed to do, not how it is built.

There are different ways to formulate a domain logic functionality/feature.
- Feature/requirement description
- User story
#note([User Story], supplement: [ex])[
    As a \<type of user\>\
    I want \<some goal\>\
    so that \<reason\> (optional)\
]
- Behavior-driven development scenario
#note([Behavior-Driven Development (BDD)])[
    In BDD, the expected behavior of a system is defined through textual descriptions called scenarios. BDD extends agile practices and facilitates collaboration and shared understanding among roles.

    BDD scenarios are defined trough examples, focusing on user interaction. The *Given-When-Then* structured natural language (Gherkin) is used to specify and test essential use cases.

    Given #w[precondition]\
    When #w[action(s)]\
    Then #w[post-condition or resulting action]
]
- Model
- Property

BDD Pipeline:
+ Start from agile approach: choose feature/user story from the current sprint
+ Discovery: the 3 amigos meet. They brainstorm and create concrete examples
+ Formulation: write scenarios in the given-then-when style
+ Automate: create tests from scenarios

#figure(
    caption: [TDD vs BDD],
    table(columns: 3)[Feature][TDD][BDD][Focus][Code/Implementation Correctness. (White Box)][Behavior/Requirement Correctness. (Black Box)][Level][Micro: Unit level (Implementation details).][Macro: System level (User behavior).][Language][Code (Java, Python, C\#).][English/Natural Language (Given-When-Then).][Audience][Developers only.][Developers, Testers, and Product Owners.],
)

== Three Amigos
/ The Product Owner: Defines the requirements and manages the project scope.\ The Product Owner ensures the team builds the right thing by providing User Stories that are clear, valuable, and scope-limited. Instead of vague requests, they must provide specific Acceptance Criteria. This clarity prevents "scope creep" and ensures the developers and testers know exactly when a feature is considered "done."
/ The Developer: Implements the product, handles deployment, and writes technical documentation.\ The Developer ensures the requirements are technically feasible. To smooth the process, they must write code that is testable by design (e.g., adding unique IDs to UI elements so automation tools can find them). Furthermore, they bridge the gap between the English scenarios and the code by writing the "glue code" (step definitions) that allows the automated tests to actually drive the application.
/ The Tester / QA: Evaluates the product quality and identifies potential issues.\ The Tester brings a critical, "destructive" mindset to the planning phase. They improve the process by identifying edge cases and "unhappy paths" (e.g., "What if the user enters a negative number?") that the Product Owner and Developer might miss. They act as the custodian of the "Living Documentation," ensuring that the test suite remains clean, relevant, and trustworthy over time.

== Black-box Testing
/ Exploratory Testing: Explore the system, observe behavior, adjust tests on the fly based on previous results. Attempt to identify critical parts:
    - unclear requirements;
    - developed by unexperienced programmer;
    - complex code according to software metrics;
    - apply risk analysis to identify high risk code
/ Equivalence partitioning: Divide all possible inputs into a finite number of equivalence classes (partitions). An arbitrary representative is picked for each equivalence class. Choose classes that are assumed to:
    - Function analogously for inputs in the same class;
    - Have sufficient tests with one input per class
    - All cause the same fault\
    #n([Example])[
        Test a program that:
        $
            "for any" N, max in ZZ:
            "sum"(N,max) = cases(
                sum^(|n|)_(k=0) "if" sum^(|n|)_(k=0) lt.eq max,
                #raw("error") "otherwise"
            )
        $
        Equivalence classes for the inputs#footnote[These tests ensure the function handles the type and quantity of data correctly before it even tries to do the math.]:
        + Provide values for both
        + Too few or too many values
        + Integers
        + A non-integer
        + Positive values
        + Negative values
        Equivalence classes for the output#footnote[These tests ensure the logical branching inside the function works.]:
        7. Values for each of the cases
    ]
/ Boundary Value Analysis: Test inputs on, or directly above or below class boundaries. Also consider output boundaries.\ Some edge cases for $ "for any" N, max in ZZ:
    "sum"(N,max) = cases(
        sum^(|n|)_(k=0) "if" sum^(|n|)_(k=0) lt.eq max,
        #raw("error") "otherwise"
    ) $\
    - Empty sum for $N = 0$
    - Absolute value for $N = 0$, or $N = -1$
    - A value for max such that $"result" = max$, or $"result" = max + 1$
    - Integer overflow boundary
/ Random Testing: Try many random values: use random generators, used to avoid bias. It's easy to implement for numbers, more challenging for: strings, lists, trees, complicated data structures, large data files, constrained data,...
== White-box testing
This type of testing depends on the internal structure of the code and the language it is written in. The code *coverage* is measured trough test cases:
#figure(table(columns: (
        2fr,
        3fr,
        3fr,
    ))[Metric][Difficulty][What it guarantees][Statement][Low][Every executable statement was executed at least once.][Branch][Medium][Each possible outcome of a decision has been taken at least once.][Modified Decision/Decision Coverage][High][The conditions within the decision independently affect the decision outcome][Path][Extreme][Each possible execution path was covered])
/ Statement Coverage: measures the number of source code statements that execute when the code runs. This type of coverage is used to determine whether every statement in the program has been invoked at least once.\ The percentage of statement coverage is represented by $("Number of executed statements" / "Total number of statements") times 100$.\ #i[This metric is satisfied if every single executable line of code is run at least once. It doesn't care how you got there, just that the line was touched.]
/ Condition coverage: analyzes statements that include conditions in source code. Conditions are boolean expressions that contain relation operators (`<`, `>`, `<=`, or `>=`), equation operators (`!=` or `==`), or logical negation operators (`!`), but that do not contain logical operators (`&&` or `||`). This type of coverage determines whether every condition has been evaluated to all possible outcomes at least once. Conditions that are inside branching constructs, such as `if`, `while`, and `do-while`, report decision coverage instead of condition coverage. \ The percentage of condition coverage is represented by $("Number of executed condition outcomes" / "Total number of condition outcomes") times 100$.\ #i[ This metric is satisfied only if every "Decision" (like an `if` or `while`) has evaluated to `TRUE` at least once and `FALSE` at least once. You must go down both paths at every fork in the road.]
/ Decision coverage: analyzes statements that represent decisions in source code. Decisions are boolean expressions composed of conditions and one or more of the logical operators `&&` or `||`. Conditions within branching constructs (`if/else`,` while`, and `do-while`) are decisions. Decision coverage determines the percentage of the total number of decision outcomes the code exercises during execution. This type of coverage is used to determine whether all decisions, including branches, in the code are tested.\ The percentage of decision coverage is represented by $("Number of executed decision outcomes" / "Total number of decision outcomes") times 100$.

== Integration Testing
Integration Testing is the phase of testing where individual software modules (which have already been unit tested) are combined and tested as a group. Component integration testing involves
/ Components: a class or set of classes;
/ Component interfaces: public methods used by other components;
/ Successful integration: component interface is used as expected by other components.
Integration testing is performed by incrementally combining components, and then test each increment with tests.

If one of the components is not implemented or is external the system, test drivers, stubs and mocks are used in its place.
The *Test Driver* calls the component under test, provides input data and collects and evaluates results. Test doubles for external components replace real, missing or external components.\ A stub is a simple actor that returns hard-coded responses, and has no decision-making logic. A mock is a more sophisticated actor that imitates the behavior of the intended component. It can make decisions, register and validate interactions.

There are different approaches to integration testing:
/ Top Down: simulates the complete application structure early on. It uses Stubs to replace missing lower-level workers
/ Bottom Up: Validates the Core Logic and Data Integrity first. It verifies that the complex calculations, database saves, and utility functions work perfectly before building a user interface around them.
/ Sandwich: use a mix of stubs/mocks and drivers
/ Big Bang: put all components together and test the whole system.

== Software Testability
Software design influences it's testability, during integration testing. A design pattern specialized for integration is *dependency injection*. Dependencies are injected in the using class. This aims to separate configuration from use, achieve separation of concerns, loose coupling, high cohesion and the flexibility needed for stubbing and mocking.

#n[Difference Between Integration and System Test][
    / Integration Testing: operates under the hood. It tests subsets of components to ensure they communicate correctly. It verifies the technical "wiring" between modules.
    / System Testing: operates at the highest level. It ignores the wiring and treats the software as a complete, sealed box. It verifies that the product as a whole delivers value to the user.
]

= LTS, VLTS & STS
Model Based Testing: tests that can be executed automatically are generated from a model.

== Labeled Transition Systems

#figure(caption: [Coffee machine LTS], diagram(node-stroke: 1pt, {
    node((0, 1), [$q_1$])
    node((2, 1), [$q_2$])
    node((0, -1), [$q_0$])
    node((2, -1), [$q_3$])
    node((0, -2))
    node((-2, 1), [$q_4$])
    edge((0, 1), (2, 1), [$"pads?"$], label-side: right, "->")
    edge((0, -1), (0, 1), [$"water?"$], label-side: left, "->")
    edge((2, 1), (2, -1), [$"button?"$], label-side: right, "->")
    edge((0, -2), (0, -1), "->")
    edge((2, -1), (0, -1), [$"coffee!"$], label-side: right, "->")
    edge((0, -1), (-2, 1), [$"button?"$], label-side: left, "->")
    edge((0, 1), (-2, 1), [$"button?"$], label-side: left, "->")
    edge((-2, 1), (0, -1), [$"error!"$], label-side: left, shift: 0.15, "->", bend: 54deg)
    edge((0, 1), (2, 1), [$tau$], label-side: right, shift: 0.15, "->", bend: -70deg)
}))

LTS can be deterministic or non-deterministic. If from the same label there are multiple of the same transitions, the LTS is non deterministic.\
Actions marked with `?` are inputs, and ones with `!` are outputs.\
$tau$ is a non-deterministic internal action, that cannot be seen externally.

#note(supplement: [def])[LTS][
    A Labeled Transition System with inputs, outputs is the tuple
    ($Q$,$L_I$,$L_O$,$T$,$q_0$), where
    - $Q$ is the set of states
    - $L_I$ is the set of input labels
    - $L_O$ is the set of output labels such that $L_I inter L_0 = emptyset$
    - $T subset.eq Q times (L_I union L_= union {tau})$ is the transition relation
    - $q_0$ is the initial state
    Label sets are divided in inputs and outputs, and they cannot overlap ($L_I union L_O = L$).
]
The coffee machine in the LTS is defined as the touple:
$
    ( & {q_0,q_1,q_2,q_3,q_4}, \
      & {"water?","pads?","button?","coffee!","error!"}, \
      & {(q_0,"water?",q_1),(q_0,"button?",q_4),(q_4,"error!",q_0),...}, \
      & q_0
        )
$
And the transition functions are
$
    & T(q_0)={("water?",q_1),("button?",q_4)} \
    & ... \
    & T(q_4) = ...
$
#let aft = $text("after", weight: "bold")$
#note(supplement: [def])[After][
    Let $epsilon$ be the empty sequence, $a in L$ an action, and $omega in L^*$ a sequence of actions. Then states after these sequence, starting in $q in Q$ are:
    $
        & q aft epsilon = {q} \
        & q aft a = {q'|q stretch(=>)^a q'} \
        & q aft a sigma = union.big {q' aft sigma | q' in q aft a}
    $
]
== Quiescence
Quiescence is the absence of output. A state is quiescent if it has no output transitions. The SUT will not produce any output until the next input arrives. A different state may cause a different output.

#grid(columns: (1fr,) * 2, column-gutter: 20pt)[#note(supplement: [def])[Quiescence][
    A state $q in Q$ is quiescent iff $forall o! in L_0 : q cancel(=>^(a!))$.\
    We write $L^delta = L union (delta)$, and $L^delta_O = L_O union {delta}$
]][#figure(caption: [Explicit quiescent state], diagram({
    node(stroke: 1pt, (0, 0), [$q_0$])
    edge((0, 0), (0, 0), [$delta$], label-side: left, "->", bend: 140deg, loop-angle: 0deg)
}))]

Quiescent states are denoted with $delta(q)$. $delta$ can be made explicit by adding them to the LTS. If a state has no outputs (denoted by `!`, a quiescent transition must be made explicit by adding a $delta$ transition from the node to itself).
#i[There's always either a quiescent transition or an output transition outgoing from a state.]

A non-quiescent state after $delta$ is always $emptyset$.

An LTS is deterministic if $forall q in Q, forall rho in "traces"(q): |q aft rho| lt.eq 1$. A non-deterministic state refers to a situation where the future behavior of the system cannot be uniquely determined by its current state and the input label alone.

A state $q$ is considered non-deterministic if one of the following conditions is met:
/ Multiple Transitions for the same label: From state $q$, there are two or more outgoing transitions with the exact same label leading to different destination states.
#note(
    supplement: [ex],
)[Non deterministic state][If the system is in State A and receives input 'x', it can go to State B OR it can go to State C. You cannot predict which one it will choose.
]
/ Hidden Transitions ($tau$-transitions): The system can transition from state $q$ to another state without consuming any input label (denoted as $tau$). This means the system can change states "silently" or spontaneously.

== Paths and Traces

#note(supplement: [def])[Path and Trace][
    A path $pi$ is an infinite sequence $q_0a_0q_1a_1...$ such that $forall i in NN: (q_i, a_i, q_(i+1)) in T$.
    We define $"traces"(q) = {sigma in L^*| q stretch(=>)^sigma}$.\
    A trace is a projection of paths to its labels excluding $tau$.
    - $"trace"(epsilon)= epsilon$\
    - $"trace"(q a q')=cases(epsilon "if" a = tau, a "otherwise")$
    - $"trace"(q a q'pi)= "trace"(q a q')"trace"(pi)$
    We write $"traces"(S) = "traces"(q_0)$.\
]
Equivalent definition of traces and #aft:
- $"traces"(q) = {"trace"(pi)|"first"(pi) = q and pi "is a finite path"}}$
- $q aft sigma = "last"({pi in "trace"^(-1)(sigma)|"first"(pi)= q})$

#note(supplement: [def])[Angelic completion][
    The angelic completion of an LTS $S=(Q,L_I,L_O,T,q_0)$ is the LTS $S^delta = (Q,L_I,L_O,T prime,q_0)$ where $T prime = T union {(q,delta,q)| q in Q and delta(q)}$. We define the *suspension traces* of $S$ as $"Straces"(S)= "traces"(S^delta)$.
]

== Networks of LTS

Labeled Transition Systems (LTS) are foundational and simple models for describing the behavior of concurrent systems. They consist of states and labeled transitions, but using them explicitly to represent large systems can be unwieldy. To address this, large LTS are often expressed in compact forms by constructing them from smaller, modular components. This is achieved through parallel composition (denoted as $P_1 parallel P_2$), which allows independent processes to execute simultaneously while interacting through specific points. These interactions are defined by synchronization vectors, which list the actions that must occur together across different components. Internal computations or unobservable steps within the system are abstracted away using the silent action ($tau$), ensuring that the model focuses only on externally visible behavior.

#figure(image("notes/src/lts_par_comp.png"))

== LTS with variables
Real systems work with data (VLTS)
#figure(image("notes/src/lts_var.png"))
Parallel composition of VLTS can also be denoted

== Symbolic Transition Systems (STS)
Actions now have parameters. Variables are no longer just in the states. States are locations with variables.

A gate is the label or the interaction mechanism that is used during a transition, and is divided between input and output gates. Switches are the actual movement from one state (called location in an STS) to another, defined by a switch relation ($R$).

#note(supplement: [def])[Switch][
    A switch is a tuple containing:
    - $l_1$: the starting location
    - $lambda$ (gate): the "label" used
    - $p_0 dots p_k$: the data parameters
    - $phi.alt$ (guard): the condition that must be true to take this path. If implicit resolves to true
    - $psi$ (update): changes made to variables
    - $l_2$: the target location

    The gate is just the name of the event, the switch is the entire event.
]

#figure(caption: [Coffee machine STS], diagram(node-stroke: 1pt, {
    node(stroke: none, (-2, -1), text(fill: green)[$x=0$])
    node(stroke: blue, (-1, -1), text(fill: blue)[$I_0$])
    node(stroke: blue, (1, -1), text(fill: blue)[$I_2$])
    node(stroke: blue, (-1, 1), text(fill: blue)[$I_1$])
    edge((-2, -1), (-1, -1), "->")
    edge((-1, -1), (1, -1), [#text(fill: purple)[coffee!]\ #text(fill: orange)[$x>15$]], label-side: left, "->")
    edge(
        (-1, -1),
        (-1, 1),
        [
            #text(fill: red)[water?] #text(fill: gray)[$p$]\
            #text(fill: orange)[$1 lt.eq p lt.eq 10$]\
            #text(fill: teal)[$x:=x+p$]
        ],
        label-side: right,
        "->",
        bend: -36deg,
    )
    edge(
        (-1, 1),
        (-1, -1),
        [#text(fill: purple)[ok!] #text(fill: gray)[$q$] \ #text(fill: orange)[$x=q$]],
        label-side: right,
        "->",
        bend: -36deg,
    )
}))

- #text(fill: blue)[Locations]
- #text(fill: green)[Initial assignment (assigns values to location variables)]
- #text(fill: red)[Input gates]
- #text(fill: purple)[Output gates]
- #text(fill: gray)[Gate parameters]
- #text(fill: orange)[Guards (boolean expressions)]
- #text(fill: teal)[Assignments to location variables]
- Switches

#let ref-note(color, content) = [(] + text(fill: color, content) + [)]

#note(supplement: [def])[Symbolic Transition System][
    A symbolic transition system (STS) with inputs and outputs is a touple $(cal(L),cal(V)_l,cal(V)_p,Gamma_I,Gamma_O, cal(R), l_0,"ini")$ where:
    - $cal(L)$ is a finite set of locations #ref-note(blue)[${I_0,I_1,I_2}$],
    - $cal(V)_l$ is a finite set of location variables #ref-note(green)[${x}$],
    - $cal(V)_p$ is a finite set of gate parameters such that $cal(V)_p inter cal(V)_l=emptyset$ #ref-note(gray)[${p,q}$],
    - $Gamma_I$ is a finite set of input gates #ref-note(red)[${"water?"}$],
    - $Gamma_O$ is a finite set of output gates such that $Gamma_I inter Gamma_O = emptyset$ #ref-note(purple)[${"ok!","coffee!"}$],
    - $cal(R) subset.eq cal(L) times (Gamma_I union Gamma_O) times V^*_p times cal(T)_"bool" (cal(V)_l union V_p) times cal(T)_"bool" (cal(V)_l union V_p)^(cal(V)_l) times cal(L)$ is the switch relation with a finite number of elements,
    - $l_0 in cal(L)$ is the initial location #ref-note(blue)[$I_0 in cal(L)$],
    - $"ini" in cal(T)^(cal(V)_l)$ is the initialization #ref-note(green)[$"ini" in cal(T)(emptyset)^(cal(V)_l)= (x:=0)$]

    Each gate $lambda$ is only used with a fixed sequence of parameters $p_0,dots, p_k$. The pair $(lambda,p_0,dots,p_k) in Gamma times cal(V)^*_p$ is called an interaction.\
    For any switch $(l_1,lambda,p_0 dots p_k, phi.alt, psi,l_2) in cal(R)$ we require that:
    - $p_0 dots p_k$ is a sequence of distinct variables
    - $phi.alt in cal(T)_"bool" (cal(V)_l union {p_0,dots,p_k})$
    - $psi in cal(T)(cal(V)_l union {p_0,dots,p_k})^(cal(V)_l)$
    - For assignment $psi arrow.r.bar := e$ we have $"type"(x) = "type"(e)$
]

Assignments on switches happen simultaneously ($x:=y,y:=x$).\
If a location variabile is not assigned by a switch, its value stays the same ($c:=c$).
#note[Scope][Location variables have global scope (whole STS). Gate parameters are local to the guards and switch assignments.]

#note(supplement: [def])[Interpretation of $S$][
    Let $S = (cal(L),cal(V)_l,cal(V)_p,Gamma_I,Gamma_O, cal(R), l_0,"ini")$ be an STS. The interpretation of $S$ is defined as the LTS $ [|S|]=(cal(L) times cal(U)^(cal(V)_l),Gamma_I times cal(U)^*, Gamma_O times cal(U)^*,->,(l_0,"ini")) $ where $->= {(q,i,q prime)| q in cal(L) times cal(U)^(cal(V)_l),i in Gamma times U^*, q prime in q aft i}$
]

= Formal Testing
Focus on black box system level testing. Rely only on inputs and outputs without looking at the code.

#show "fail": smallcaps[*fail*]
#show "pass": smallcaps[*pass*]

#note(supplement: [def])[Test Case][A test case is formally defined as a specification that dictates:
    - Which inputs to provide to the SUT.
    - Which outputs are expected from the SUT.
    - A final verdict (pass or fail) returned upon the completion of a finite execution.
]
A test case is a cycle of providing input, waiting for output, or stopping with a verdict.

Test cases can be modeled as Labeled Transition Systems with specific rules:
/ Angelic Completion: Test cases include a special label $delta$ representing quiescence or timeouts.
/ pass/fail States: There are two distinct states, pass and fail, which have self-loops for all outputs (to handle any subsequent behavior harmlessly) but no transitions for inputs.
/ Structure: A test case must be deterministic and acyclic (except for the recursion in the pass/fail states) to ensure a finite execution.

#note[Test Case formal definition][
    A test case for an LTS $S^delta$ is an LTS $t=(Q^t,L_I,L_O union {delta},T^t,q_0^t)$ such that:
    + $t$ uses the same labels as $S^delta$
    + There are two special states: pass, fail $in Q^t$
    + States pass and fail have self-loops for all outputs, including $delta$
    + States pass and fail have no transitions for inputs
    + $t$ has no cycles except those in pass and fail
    + $t$ is deterministic
    + Every state enables all outputs $L_O$, and either one input or $ delta:forall q in Q^t :(|"in"(q)| = 0 and "out"(q) = L_O union {delta}) or (|"in"(q)| = 1 and "out"(q)=L_O) $
]

== IOCO
ioco stands for *Input Output COnformance*. It is a mathematical relation that indicates if an Implementation (I) conforms to, or obeys, its Specification (S).

It relies on two rules regarding behavior:
/ Inputs: The implementation must accept the same or more inputs than the specification. (It shouldn't crash just because we pressed a button we usually don't press).
/ Outputs: The implementation must produce the same or fewer outputs than the specification. (It shouldn't invent behaviors we didn't authorize).

#note[Test Assumptions][
    We assume the System Under Test (SUT) can be modeled as an Input-Enabled LTS (IELTS).

    This means that in any state, the implementation is ready to accept any input from the logical set ($L_I$). Even if the button shouldn't work right now, the system physically accepts the press (even if it just ignores it): $forall q in Q: "in"(q) = L_I$
]

Alongside quiescence, we have to deal with *underspecification*: What if our specification doesn't mention what happens when I press a button? In ioco, this is treated as underspecification. We assume "anything is allowed" for missing input transitions. This is modelled by adding a "Chaos state" ($chi$). If the specific doesn't forbid it, the implementation is free to do it.

Underspeicification is made explicit with demonic completion by adding the chaos state $chi$.

#figure(image("notes/src/underspecification.png"))

#let ioco = $"ioco"$
#let tr = $"traces"$
#let aft = $"after"$
#let exp-1 = $forall sigma in tr(S_delta)$
#let exp-2 = $"out"(I_delta aft sigma)$
#let exp-3 = $"out" (S_delta aft sigma)$

Ioco defines whether a system implementation ($I$) correctly follows it specification ($S$). The implementation is not allowed to have new behaviors or inputs.

$ "ioco": "IELTS" times "LTS"-> "bool" $

Mathematically, the relationship is defined between an IELTS $I$ and a specification $S$. They are considered compliant ($I ioco S$) if and only if $ #exp-1:#exp-2 subset.eq #exp-3 $

- $#exp-1$: we only check for traces (sequences of actions) that are actually present in the specification.
- $#exp-2$: this is a set of all outputs (including quiescence) the implementation produces after the sequence $sigma$.
- $#exp-3$: this is the set of all allowed outputs (including silence) that the specification permits after a specific history of events ($sigma$).

#i[
    The outputs produced by the implementation must be a subset of the outputs allowed by the specification.
]

#let bg = `batchGen`
== Test Generation
Test generation is used to bridge the gap between the specification and the actual testing.
=== Batch Test Generation
#bg involves creating the entire test case as a complete diagram or data structure before interacting with the real system. This algorithm works recursively to build a tree-like test case from the specification.

#note(supplement: [function])[#bg][
    The algorithm looks at the current states of the specification and makes a nondeterministic choice to do one of the following:
    + Stop: end the test case at the current point;
    + Input: choose a valid input (e.g. `button?`) and add it to the test case
    + Observe: create branches for all possible outputs (including $delta$) that the specification allows at that point

    The output is a complete test case (LTS graph) that typically ends in pass or fail states.
]

#note(supplement: [example])[#bg][
    + The generator starts at the initial state $q_0$;
    + it adds a `button?` input and then creates two branches to handle the possible responses `coffee!` and `error!`;
    + It continues adding steps like `water?` until it decides to stop, resulting in a complete tree structure
]

=== On-the-fly Test Generation
#let otfg = `onTheFlyGen`
#otfg combines generation and execution. Instead of building a full map beforehand, the algorithm generates a single step, executes it against the SUT immediately, and then decides what to do based on the result.


#note(supplement: [function])[#otfg][
    The algorithm sits in a loop with the real system. At each step, it checks the current state $Q prime$:
    + pass: it can decide to stop and return a pass verdict;
    + Observe input: it waits to see if the system produces an output $x!$
        - If the output occurs, it checks if $x!$ is allowed by the specification $(x! in "out"(Q prime))$
        - If the output is not allowed, it immediately returns fail
        - If the output is allowed, it updates its current state ($Q prime #aft x!$) and continues
    + Supply input: it can choose to send an input (`button?`) to the system, provided the system hasn't already produced an output.

    This approach doesn't produce a reusable graph. Instead, it produces a single verdict (pass or fail) for that specific run.
]

#note(supplement: [example])[#otfg][
    + The tester sends `button?`
    + The SUT returns `coffee!`
    + The SUT returns `error!`
    + Since `error!` is not allowed at that specific moment in the specification, the test stops immediately with fail.
]

Summary:
#i[
    / Batch: You build the whole test case first, then send the execution through it later. You can save these test cases and reuse them.
    / On-the-fly: You build the path one step at a time while walking it. You generate a test step and execute it immediately.
]

== Special Test cases
=== Test Cases for Non-deterministic Systems

When a Specification allows for multiple different outputs after the same input (nondeterminism), a standard linear test might not work. Specific test cases designed to "observe" specific transitions are needed.

=== Distinguishing Test Cases
A distinguishing test case is a test case designed to distinguish between two different start states (is the system currently in state A or state B?). In order to function, you send an input that produces a different output depending on which state the system is currently in. By observing the output, you can identify the initial state.

=== Homing Test Cases
A homing test case is defined as a test case that transitions the system to a particular "home" state like $q_0$ from *any* starting state. The goal is to synchronize the system to force it back to a known state.

= Model Based Testing with Axini

Boehm's law: the cost of bugs grows exponentially with time. Most of the testing is done in the integration/acceptance test.

Model based testing is a type of black box testing. It works with expectations of what the SUT should do without having access to the source code. It has higher coverage and more automation.

The model is a reflection of the informal requirements. There is a correctness criterion between the model and the implementation, in this case it's IOCO.

Models are written in the Axini modelling language (AML). *The models are always from the perspective of the system*.

The SmartDoor code has to be memorized somewhere. Write to when lock, check when unlock.
SECLOC-07 -> quiescence (slides p.12)

= IOCO & Test Generation for STS
#def[Soundness][
  A test case $t$ for an LTS $S$ is sound if for any IELTS $I$:
  $ I "ioco" S "implies that execution of " t "on" I "yields" bold("pass") $
  A test suite TS is sound if all its test cases $t in "TS"$ are sound
]

#def[Exhaustiveness][
  A test suite TS for LTS $S$ is exhaustive if for any IELTS $I$:
  $ I cancel("ioco") S "implies that there is a " t in "TS such that execution of" t  "on" I "yields" bold("fail") $
]

= Risk Assessment
#def[Risk][
    - The possibility tha positive expectations will not be realized;
    - Probability times impact (can result in oversimplifications)
    - The combination of the probability of an event and its consequences
    - *The effect of uncertainty on objectives*
    _All definitions have impact and uncertainty._
]

Effect/impact can be positive or negative. There's an emphasis on goals to help focus on important matters.

This definition is generic, can be applied too any domain, system or phase.

== Impact
Does risk affect:
+ Money?
+ Time?
+ Reputation?
+ Safety?
+ Quality?
Focus on the negative impact. The context determines the priority.

/ Qualitative impact: which impact?

/ Quantitative impact: how bad? Number/scale

== Uncertainty
#figure(table(columns: 2)[Scale][Probability of occurrence][*1*: very unlikely][Never occurred in our field][*2*: possible][Has occurred once in 10 years][*3*: once in a while][Every few years][*4*: Often][several times a year][*5*:Regularly][Several times a month])

/ Aleatoric/stochastic uncertainty: the effect of randomness.
/ Epistemic/bayesian uncertainty: effect of ignorance.

Risk mitigation doesn't affect the probability, but reduces the impact. There are some risks where you don't want to do anything about.


== Deming Cycle

#figure(image("notes/src/deming cycle.png"),caption:[Deming Cycle])

== When to do risk assessment

The cost of fixing error increases in the development cycle, so threat identification should be done as soon as possible, or even better at every step of development.

== Risk Strategies

/ Tolerate: accept the risks
/ Terminate: stop/not start the activity.
/ Treat:
  - reduce the likelihood of occurrence:
  - reduce the impact
/ Transfer: transfer the risk to someone else.

== Model-based Risk Assessment
It is used to identify, classify and prioritize risks. It combines free brainstorming with thorough analysis.

FMEA, fault trees and dynamic fault trees are used to *make decisions*.

== Failure Mode & Effects Analysis (FMEA)

It's a tool used in the design stage to address the ways a system can fail and take appropriate measures. It allows to sort risks by risk priority number (RPN).
$ "RPN" = "probability" times "severity" times "detection" $

FMEA steps:
+ Determine a design tree (components): a 3 level tree with a root and 2 levels of subsystems
+ Determine the function tree (roles);
+ Determine failures for each function.
  - Failure Effect at level 1;
  - Failure Mode at level 2;
  - Failure Cause at level 3;
+ Quantify: assign *severity*, *probability* and *detection* on a scale 1-10. Detection is higher the harder it is to detect.
+ Find measures
+ Reassess.
