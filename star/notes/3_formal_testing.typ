#import "_star.typ": *
#show: template
= Formal Testing
Focus on black box system level testing. Rely only on inputs and outputs without looking at the code.

#note(supplement: [def])[Test Case][A test case is formally defined as a specification that dictates:
    - Which inputs to provide to the SUT.
    - Which outputs are expected from the SUT.
    - A final verdict (pass or fail) returned upon the completion of a finite execution.
]
A test case is a cycle of providing input, waiting for output, or stopping with a verdict.

Test cases can be modeled as Labeled Transition Systems with specific rules:
/ Angelic Completion: Test cases include a special label $delta$ representing quiescence or timeouts.
/ Pass/Fail States: There are two distinct states, Pass and Fail, which have self-loops for all outputs (to handle any subsequent behavior harmlessly) but no transitions for inputs.
/ Structure: A test case must be deterministic and acyclic (except for the recursion in the Pass/Fail states) to ensure a finite execution.

#note[Test Case formal definition][
    A test case for an LTS $S^delta$ is an LTS $t=(Q^t,L_I,L_O union {delta},T^t,q_0^t)$ such that:
    + $t$ uses the same labels as $S^delta$
    + There are two special states: $"pass", "fail" in Q^t$
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

Alongside quiescence, we have to deal with *underspecification*: What if our specification doesn't mention what happens when I press a button? In ioco, this is treated as underspecification. We assume "anything is allowed" for missing input transitions. This is modelled by adding a "Chaos state" ($cal(X)$). If the specific doesn't forbid it, the implementation is free to do it.

#let ioco = $"ioco"$
#let tr = $"traces"$
#let aft = $"after"$
#let exp-1 = $forall sigma in tr(S_delta)$
#let exp-2 = $"out"(I_delta aft sigma)$
#let exp-3 = $ "out" (S_delta aft sigma)$

Ioco defines whether a system implementation ($I$) correctly follows it specification ($S$). The implementation is not allowed to have new behaviors or inputs.

    Mathematically, the relationship is defined between an IELTS $I$ and a specification $S$. They are considered compliant ($I ioco S$) if and only if $ #exp-1:#exp-2 subset.eq #exp-3 $

    - $#exp-1$: we only check for traces (sequences of actions) that are actually present in the specification.
    - $#exp-2$: this is a set of all outputs (including quiescence) the implementation produces after the sequence $sigma$.
    - $#exp-3$: this is the set of all allowed outputs (including silence) that the specification permits after a specific history of events ($sigma$).

#i[
    The outputs produced by the implementation must be a subset of the outputs allowed by the specification.
]
