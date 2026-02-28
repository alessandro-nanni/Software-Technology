#import "@preview/fletcher:0.5.5" as fletcher: diagram, edge, node
#import "_star.typ": *
#show: template
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

#figure(image("src/underspecification.png"))

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
