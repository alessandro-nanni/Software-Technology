#import "../mono.typ": *
#show: template.with(blue, red, [System Validation])

#align(center,text(fill:red, size:20pt)[! Unlike other PDFs, this is AI generated !\ #text(fill:red, size:12pt)[It's a summary of questions I asked Claude, formatted as a cheat sheet.]])

= Propositional Logic --- Implication

$P arrow.r Q$ is a *promise*: "if $P$, then $Q$." It is broken in exactly one case: $P$ true, $Q$ false. Everywhere else, nothing broke the promise, so it counts as true (even vacuously, when $P$ is false).

#table(
  columns: (auto, auto, auto),
  align: center,
  stroke: 0.4pt,
  [$P$], [$Q$], [$P arrow.r Q$],
  [T], [T], [T],
  [T], [F], [*F*],
  [F], [T], [T],
  [F], [F], [T],
)

#strong[Rule of thumb:] false only in the $(T,F)$ row, true everywhere else. \
#strong[Algebraic shortcut:] $P arrow.r Q equiv (not P) or Q$.

== Quantifiers \& Binding

$forall x med P(x)$: $P$ holds for *every* $x$ (like a giant $and$ over the domain). \
$exists x med P(x)$: $P$ holds for *some* $x$ (like a giant $or$).

A quantifier *binds* its variable; an unbound occurrence is *free*. The quantifier's *scope* is everything after its dot (or bracket) --- not just the small domain restriction attached to it (e.g. "$in Sigma$").

#i[Nesting order matters: in $forall x med exists y med P(x,y)$, $y$ may depend on $x$ (chosen after, inside its scope). Swapping to $exists y med forall x$ is a strictly stronger, usually different claim.]

== Substitution --- Def. 2.4 \& 2.5

Notation: $"expr"[x := E]$ reads "substitute $E$ for $x$ in expr." $E$ replaces $x$; it is never itself decomposed or substituted into --- it is always dropped in wholesale.

#strong[Def. 2.4] (single variable, the base case):
$ y[x:=E] = cases(E & "if" x=y, y & "otherwise") $

#strong[Def. 2.5] (whole formula, recursive):
- $P(x_1,...,x_n)[x:=E] = P(x_1[x:=E],...,x_n[x:=E])$ --- substitution *maps* over the arguments; the predicate symbol itself is untouched.
- $(not phi)[x:=E] = not(phi[x:=E])$, and similarly $and$ just recurses; shape is preserved.
- $(forall y. phi)[x:=E] = forall y. phi$ #h(4pt) if $x = y$ (those occurrences are bound by this quantifier, not "yours" to replace) --- else $forall y.(phi[x:=E])$.

#i[2.5 is a structural recursion over the formula grammar; 2.4 is the leaf rule it calls once it reaches an actual variable. Because $E$'s own free variables are never inspected, dropping $E$ under a quantifier that rebinds one of them causes *variable capture* --- this naive definition has no built-in guard against it.]

= Finite State Machines --- Ch. 3

== Def. 3.1 --- FSM

$ M = (Sigma, hat(sigma), arrow.r.double, A) $
- $Sigma$: finite set of states #linebreak() $hat(sigma) in Sigma$: initial state #linebreak() $A$: set of events
- $arrow.r.double subset.eq Sigma times A times Sigma$: transition relation --- a *relation*, not a function, so the same (state, event) may legally lead to several next states (non-determinism).
- #strong[Left-total:] $forall sigma in Sigma. exists sigma' in Sigma, a in A. (sigma,a,sigma') in arrow.r.double$ --- every state has $>=1$ outgoing transition; no dead ends.

#i[A triple is "valid" simply by bautoeing *in* $arrow.r.double$ --- there is no separate notion of validity to check against.]

== Def. 3.2 --- FSM Execution

$ pi = sigma_0, sigma_1, ... quad "s.t." quad sigma_0 = hat(sigma), quad forall i in NN. exists a in A. (sigma_i,a,sigma_(i+1)) in arrow.r.double $

An infinite sequence where every consecutive pair is linked by a legal transition. Left-totality is exactly what guarantees this can always be extended one more step, forever.

== Example 3.2 --- Determinism

*Deterministic* $=$ each event sequence yields at most one execution. Equivalent, checkable criterion: *no state has two outgoing transitions with the same label.* (Two different event sequences *can* still produce the same execution --- that direction is allowed; it's the reverse, event-seq $arrow.r$ execution, that must never branch.)

= FSMs in NuSMV

== `ASSIGN`/`case` vs. `TRANS`

#table(
  columns: (1fr, 1fr),
  stroke: 0.4pt,
  inset: 4pt,
  [*`ASSIGN`/`case`*], [*`TRANS` (predicate)*],
  [Ordered, first-match-wins], [Unordered Boolean formula, `|`-joined disjuncts],
  [NuSMV auto-checks completeness $arrow.r$ left-totality guaranteed], [Only `INIT`-satisfiability \& left-totality are checkable (opt-in) --- no automatic overlap/coverage check],
  [Ambiguity structurally impossible], [Overlapping guards $=$ legal non-determinism, *not* flagged as an error],
)

Each `TRANS` disjunct has shape *"guard \& next(v) = ..."*, one per transition --- directly writing $arrow.r.double$ as a formula. To verify coverage/no-overlap by hand: enumerate all (state, input) combinations; check some guard fires (coverage) and no two fire together unless non-determinism is intended (overlap).

== `init(v)` / `next(v)`

Not function calls --- temporal *reference* operators. Bare $v$ = "now"; `init(v)` = "at time 0"; `next(v)` = "one step later." Needed because current and next state share the same variable name within one `TRANS` formula.

== `DEFINE` Declarations

A named *macro* for an expression over the real state variables --- substituted at every point of use, recomputed fresh each time, never stored.

- #strong[Not] a state variable: adds *zero* dimensions to $Sigma$.
- Uses: pass derived info between module instances; name atomic propositions for specs; avoid needless state-space growth for info already derivable.

#i[Test: would this be a real `VAR` just storing something already computable from other variables? If yes $arrow.r$ make it a `DEFINE`.]

= Kripke Structures --- Def. 3.3 \& 3.4

$ K = (S, I, arrow.r, lambda) $

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt,
  inset: 4pt,
  [$S$], [finite states --- same role as $Sigma$],
  [$I subset.eq S$, $I eq.not emptyset$], [*set* of initial states (generalizes the single $hat(sigma)$)],
  [$arrow.r subset.eq S times S$], [left-total, *binary* (drops the event label $A$ had --- properties care about *what's true*, not *why*)],
  [$lambda : S arrow.r 2^"AP"$], [labels each state with its true propositions --- entirely new, no FSM analogue],
)

#strong[Def. 3.4 (Path):] $s_0 s_1 s_2 ... $ with $s_0 in I$ and $forall i >= 0. s_i arrow.r s_(i+1)$ --- mirrors Def. 3.2, minus the event witness.

A Kripke structure captures the *combined* behaviour of one or more composed FSMs/modules --- hence state-space explosion for realistic models.

== Atomic Propositions \& $lambda$

An atomic proposition is the smallest, *indivisible* unit of a formula --- always reduces to a plain Boolean (true/false), never a raw value, because $lambda(s) subset.eq "AP"$ is a set-membership test.

$lambda(s)$ is *not* global --- recomputed per state; the same proposition can be true at one state and false at another.

`DEFINE` is the concrete NuSMV mechanism that supplies $lambda$'s rule: #raw("even := state=zero | state=two") says exactly when $"even" in lambda(s)$.

= Fairness --- §4.5

#strong[Problem:] some legal-but-unrealistic infinite paths (e.g. resetting forever) can make an otherwise-true liveness property look false.

- #strong[Weak fairness:] enabled unboundedly long $arrow.r$ must eventually be taken.
- #strong[Strong fairness:] enabled infinitely often (not nec. continuously) $arrow.r$ must eventually be taken.

#table(
  columns: 2,
  stroke: 0.4pt,
  inset: 4pt,
  [`JUSTICE` $phi$ / `FAIRNESS` $phi$], [`COMPASSION` $(phi,psi)$],[discard paths where $phi$ doesn't hold infinitely often #linebreak() $=$ weak fairness, with $phi = $ "not enabled $or$ taken"],
   [discard paths where $phi$ holds infinitely often but $psi$ doesn't #linebreak() $=$ strong fairness, $phi=$"enabled", $psi=$"taken"],
)

Fairness filters *which infinite paths are considered* --- it never edits $arrow.r.double$/`TRANS` itself. Example: `FAIRNESS !(ctr.state = zero);` rules out only the path that stays at `zero` forever, unbroken.

#strong[Keep non-determinism (+ fairness) when] it's a genuine abstraction (real detail deliberately omitted) or real uncertainty, verifying under it covers *every* concrete resolution at once, and the only excluded case is a physically-impossible infinite idealization.

#strong[Remove non-determinism when] you actually know/want the specific rule, fairness would have to do so much work the non-determinism added no value, or the "bad" pattern might be a *real* risk --- fairness would then hide a bug rather than exclude a fiction.

