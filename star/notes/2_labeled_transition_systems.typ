#import "_star.typ": *
#import "@preview/fletcher:0.5.8" as fletcher: diagram, edge, node
#show: template
= LTS, VLTS & STS
Model Based Testing: tests that can be executed automatically are generated from a model.

== Labeled Transition Systems

#figure(caption: [Coffee machine LTS], diagram({
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

#note(supplement: [def])[Quiescence][
    A state $q in Q$ is quiescent iff $forall o! in L_0 : q cancel(=>^(a!))$.\
    We write $L^delta = L union (delta)$, and $L^delta_O = L_O union {delta}$
]

Quiescent states are denoted with $delta(q)$. $delta$ can be made explicit by adding them to the LTS.
#i[There's always either a quiescent transition or an output transition.]

An LTS is deterministic if $forall q in Q, forall rho in "traces"(q): |q aft rho| lt.eq 1$.

#note(supplement: [def])[Path and Trace][
    A path $pi$ is an infinite sequence $q_0a_0q_1a_1...$ such that $forall i in NN: (q_i, a_i, q_(i+1)) in T$.
    We define $"traces"(q) = {sigma in L^*| q stretch(=>)^sigma}$.\
    A trace is a projection of paths to its labels excluding $tau$.
    - $"trace"(epsilon)= epsilon$\
    - $"trace"(q a q')=cases(epsilon "if" a = tau,a "otherwise")$
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
LTS are simple models.

How to write large LTS in a compact form.

Large LTS can be built on top of small components.

Parallel composition - Parallel execution of communicating LTS

$"Prod"_1 || "Prod"_2$
$tau$ is an unobservable, silent action.

$"SV"$: synchronization vector, a list of all the things that are synchronized

== LTS with variables
Real systems work with data (VLTS)

Parallel composition of VLTS can also be denoted

== Symbolic Transition Systems (STS)
Actions now have parameters. Variables are no longer just in the states. States are locations with va
