#import "@preview/fletcher:0.5.8" as fletcher: diagram, edge, node

#align(center, text(size: 20pt)[Homework 3])
= Exercise 2
== 2.a
#align(center, diagram({
    node((0, 0), stroke: 1pt + black, [$t_0$])
    node((-1, 0))
    node((0, 2), stroke: 1pt + black, [$t_1$])
    node((0, 4), stroke: 1pt + black, [$t_2$])
    node((-2, 1), [fail])
    node((2, 1), [fail])
    node((-2, 3), [pass])
    node((2, 3), [pass])
    node((-2, 5), [pass])
    node((2, 5), [fail])
    edge((0, 0), (0, 2), [play?], label-side: left, "->")
    edge((0, 2), (0, 4), [repeat?], label-side: left, "->")
    edge((0, 0), (-2, 1), [quit?], label-side: left, "->")
    edge((0, 0), (2, 1), [quitRepeat?], label-side: left, "->")
    edge((0, 2), (-2, 3), [song!], label-side: left, "->")
    edge((0, 2), (2, 3), [quit!], label-side: left, "->")
    edge((0, 4), (-2, 5), [song!], label-side: left, "->")
    edge((0, 4), (2, 5), [play?], label-side: left, "->")
}))
== 2.b
#align(center, diagram({
    node((0, 2), stroke: 1pt + black, [$q_0$])
    node((-1, 2))
    node((2, 2), stroke: 1pt + black, [$q_1$])
    edge((-1, 2), (0, 2), "->")
    edge((0, 2), (2, 2), [song!], label-side: left, "->")
    edge((2, 2), (2, 2), [$delta$], label-side: left, "->", bend: 140deg, loop-angle: 0deg)
}))
We check ioco nonconformity with $exists sigma in "traces"(S^delta): "out"(I^delta "after" sigma) subset.eq.not "out"(S^delta "after" sigma)$.
In this case:
- $"out"(I^delta "after" sigma)= {"song!"}$
- $"out"(S^delta "after" sigma)={delta}$ because the only output is the quiescent state
${"song!"} subset.eq.not {delta}$ therefore $I "ioco" S$ isn't true.
== 2.c
#figure(align(
    center,
    diagram({
        node((-2, 2))
        node((-1, 2), stroke: 1pt + black, [$q_0$])
        node((1, 2), stroke: 1pt + black, [$q_1$])
        node((-1, 4), stroke: 1pt + black, [$q_2$])
        edge((-2, 2), (-1, 2), "->")
        edge((-1, 2), (1, 2), [repeat?], label-side: left, "->")
        edge((-1, 4), (-1, 2), [endPlaylist!], label-side: left, "->")
        edge((1, 2), (-1, 4), [play?], label-side: left, "->", bend: 36deg)
    }),
),caption:[New implementation])


#align(center, diagram({
    node((-1, 2), stroke: 1pt + black, [$t_0$])
    node((-1, 4), stroke: 1pt + black, [$t_1$])
    node((-1, 6), stroke: 1pt + black, [$t_2$])
    node((-1, 8), [fail])
    edge((-1, 2), (-1, 4), [repeat?], label-side: left, "->")
    edge((-1, 4), (-1, 6), [play?], label-side: left, "->")
    edge((-1, 6), (-1, 8), [endPlaylist!], label-side: left, "->")
}))
$t_2={q_3}$, and $q_3 cancel(stretch(arrow)^"endPlaylist!")$ as indicated by the specification, therefore the result is fail.
= Exercise 4
== 4.a

Yes, $I^(delta 1) "ioco" S^delta$ holds. The ioco relation dictates that an implementation must only provide allowed outputs for the exact input traces explicitly defined in the specification.

For all valid traces defined in $S^delta$ (such as the sequence `coin?` #sym.arrow `song?`), the outputs of $I^(delta 1)$ are a subset of the allowed outputs in $S^delta$ (for example outputting `AfricaByTOTO!`).

$I^(delta 1)$ contains unallowed outputs (like `error!`), but these only occur after unspecified inputs, such as inputting `song` right at the starting state $q_0$. Since ioco allows an implementation to have arbitrary behavior following inputs that are not explicitly defined in the specification, they do not cause ioco to fail.

== 4.b
$I^(delta 2) "ioco" S^delta$ fails.
The input sequence `coin?` #sym.arrow `song?` #sym.arrow `song?` is valid. After this sequence, $S^delta$ stays in state $q_2$, where the only allowed output is `AfricaByTOTO!`
    $ "out"(S^delta "after" "coin?" "after" "song?" "after" "song?") = {"AfricaByTOTO!"} $

When given that exact same sequence of inputs, $I^(delta 2)$ transitions from state $q_2$ to a new state, $q_3$. From state $q_3$, it produces the output `error!`.
    $ "out"(I^(delta 2) "after" "coin?" "after" "song?" "after" "song?") = {"error!"} $

Ioco nonconformity is determined by $exists sigma in "traces"(S^delta): "out"(I^delta "after" sigma) subset.eq.not "out"(S^delta "after" sigma)$. And in this case $ {"error!"} subset.eq.not {"AfricaByTOTO!"}$.

== 4.c
Parallel composition links the test case and the implementation into a single paired model where both must execute every observable action together. If the implementation produces any output the test case doesn't expect, the synchronization stops and the test fails.
=== Execution on $I^(delta 1)$
+ The starting state is $(t_0, q_0)$.
+ The test triggers the `coin?` transition, shifting the state to $(t_1, q_1)$.
+ The test applies the `song?` transition, updating the state to $(t_2, q_2)$.
+ The test sends another `song?` command. Since $I^(delta 1)$ has a self-loop at $q_2$ for this specific input, the system moves to $(t_3, q_2)$.
+ The test now listens for an output. $I^(delta 1)$ emits `AfricaByTOTO!`, which matches the test's expected path and leads to the new state $(t_4, q_0)$.
+ The test looks for a $delta$ step. Since $q_0$ in the implementation has no outgoing outputs available, it fulfills this condition. The test terminates by arriving at the `pass` node.

=== Execution on $I^(delta 2)$
+ The execution follows the same initial path as the other implementation, moving from $(t_0, q_0)$ to $(t_2, q_2)$ via the `coin?` and `song?` inputs.
+ The test issues the second `song?` command. This implementation is programmed to the state $q_3$. The paired state is now $(t_3, q_3)$.
+ At this location, the test case is waiting to either observe `AfricaByTOTO!` or $delta$. Instead, $I^(delta 2)$ generates an `error!` output.
+ Since `error!` is an unauthorized output that is not mapped to the test case's pass trajectory, it forces a transition into a `fail` state. The synchronization stops, terminating the test with a fail verdict.
