#import "_star.typ": *
#import "@preview/fletcher:0.5.8" as fletcher: diagram, edge, node
#show: template
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

Quiescent states are denoted with $delta(q)$. $delta$ can be made explicit by adding them to the LTS. If a state has no outputs (denoted by !, a quiescent transition must be made explicit by adding a $delta$ transition from the node to itself).
#i[There's always either a quiescent transition or an output transition outgoing from a state.]

A non-quiescent state after $delta$ is always $emptyset$.

An LTS is deterministic if $forall q in Q, forall rho in "traces"(q): |q aft rho| lt.eq 1$. A non-deterministic state refers to a situation where the future behavior of the system cannot be uniquely determined by its current state and the input label alone.

A state $q$ is considered non-deterministic if one of the following conditions is met:
/ Multiple Transitions for the same label: From state $q$, there are two or more outgoing transitions with the exact same label leading to different destination states.
#note(supplement:[ex])[Non deterministic state][If the system is in State A and receives input 'x', it can go to State B OR it can go to State C. You cannot predict which one it will choose.
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

#figure(image("src/lts_par_comp.png"))

== LTS with variables
Real systems work with data (VLTS)
#figure(image("src/lts_var.png"))
Parallel composition of VLTS can also be denoted

== Symbolic Transition Systems (STS)
Actions now have parameters. Variables are no longer just in the states. States are locations with variables.
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
