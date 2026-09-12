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

= Safety vs. Liveness --- §4.2

#strong[Safety] ("nothing bad happens"): counter-example is always *finite* --- a path prefix that reaches the bad state. \
#strong[Liveness] ("something good eventually happens"): counter-example is always *infinite* --- a whole path along which the good thing never occurs.

#i[Test: can a violation be witnessed by a finite trace? Yes $arrow.r$ safety. If disproof needs "...and it simply never happens, ever" $arrow.r$ liveness.]

- #strong[Bounded liveness] ("closed within 10 steps") is secretly safety --- the deadline makes the counter-example finite again.
- #strong[Deadlock absence] counts as safety: the counter-example is the finite path ending in the stuck state --- even though the deadlock itself then blocks all future good things.

= Linear Temporal Logic --- §4.4

$ phi ::= p | not phi | phi and phi | phi or phi | G phi | F phi | X phi | phi U phi | phi W phi $

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [$G phi$], [globally --- $phi$ holds at *every* position from here on],
  [$F phi$], [eventually --- $phi$ holds at *some* position from here on (now included)],
  [$X phi$], [next --- $phi$ holds at exactly the *next* position],
  [$phi_1 U phi_2$], [until --- $phi_2$ *must* eventually hold; $phi_1$ holds at every position before that],
  [$phi_1 W phi_2$], [weak until --- like $U$, but $phi_2$ is never guaranteed: $phi_1$ may just hold forever instead],
)

#strong[Core LTL] ($X$, $U$ suffice --- everything else derives):
$ G phi equiv not F not phi quad quad F phi equiv "true" U phi $
$ phi_1 W phi_2 equiv (phi_1 U phi_2) or G phi_1 quad quad phi_1 U phi_2 equiv F phi_2 and (phi_1 W phi_2) $

== Strictness ladder for $G (p_1 arrow.r ...)$

Given $p_1$ holds at position $i$, when must $p_2$ hold?

#table(
  columns: (1fr, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [$G (p_1 arrow.r p_2)$], [exactly at $i$, same instant --- strongest],
  [$G (p_1 arrow.r X p_2)$], [exactly at $i+1$, one step later, no more no less],
  [$G (p_1 arrow.r X F p_2)$], [anywhere from $i+1$ on --- strictly after, unbounded],
  [$G (p_1 arrow.r F p_2)$], [anywhere from $i$ on --- now or later, weakest],
)

Each row strictly implies the one below it. #strong[Bare] $p_1 arrow.r p_2$ (no $G$) is a different animal: LTL evaluates a naked formula only at position $0$ of the path, so it constrains nothing but the *initial* state --- incomparable to the ladder above.

#i[$X$ is a plain one-step shift, so it *commutes* with $F$, $G$, $U$: $X F p equiv F X p$ (both just mean "$p$ holds at some position $>= 1$"). This does *not* extend to $F$ and $G$ commuting with each other: $G F p$ ("$p$ infinitely often", gaps allowed) and $F G p$ ("$p$ eventually holds forever") are genuinely different --- $F G p arrow.r G F p$ but never the reverse.]

== Tool syntax

#table(
  columns: (auto, auto, auto),
  stroke: 0.4pt, inset: 4pt,
  [], [*NuSMV*], [*Promela*],
  [section], [`LTLSPEC`], [`ltl name { ... }`],
  [$G$ / $F$], [`G` / `F`], [`[]` / `<>`],
  [$X$], [`X`], [not supported],
  [$U$ / $W$], [`U` / (derive via $G,U$)], [`U` / `W`],
)

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

= Computation Tree Logic --- §4.7

Two levels, always alternating: #strong[state formulas] $Phi$ (true *at* a state) and #strong[path formulas] $phi$ (true *along* a path).

$ Phi ::= p | not Phi | Phi and Phi | Phi or Phi | A phi | E phi $
$ phi ::= G Phi | F Phi | Phi U Phi | X Phi $

$s$ satisfies $A phi$ iff *every* path $pi$ starting at $s$ satisfies $phi$; $s$ satisfies $E phi$ iff *some* path starting at $s$ satisfies $phi$.

#i[$A$/$E$ answer *which path* --- they resolve non-determinism by picking a branch out of the tree rooted at the state. $G$/$F$/$X$/$U$ answer *where in time*, once a branch is already fixed. That's why the grammar forces alternation: bare $A p$ or bare $G p$ is meaningless alone --- "for all paths, $p$" doesn't say *when*, and "always $p$" doesn't say *for which futures*.]

#strong[Example] --- a state with a black-forever loop *and* a white-forever loop as its two options: $E G "black"$ is true (the black branch exists), but $A G "black"$ is false (the white branch breaks it). Same $G$-property, different quantifier $arrow.r$ different verdict.

== Common patterns

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [$A G p$], [$p$ holds forever, no matter how execution unfolds --- true invariant],
  [$E G p$], [*some* execution keeps $p$ forever],
  [$E F p$], [*some* execution reaches $p$],
  [$A F p$], [$p$ is unavoidable, on every execution],
  [$A G (E F p)$], [no matter what happens, it's always still *possible* to get back to $p$],
)

== Dualities \& core set

$ A G Phi equiv not E F not Phi quad quad A F Phi equiv not E G not Phi quad quad A X Phi equiv not E X not Phi $

Core CTL (used by the Ch. 5 model-checking algorithm) is just three operators --- $E X$, $E U$, $A F$ --- everything else reduces to these.

`SPEC` in NuSMV; combined syntax `AG AF AX AU EG EF EX EU`. #strong[Spin has no CTL support] --- LTL only.

== Fairness and CTL --- §4.8

Fairness can't be written as a CTL formula at all --- it would need a connective like $arrow.r$ *inside* a path formula, which the grammar forbids. NuSMV's `FAIRNESS`/`COMPASSION` sidestep this by changing the *semantics* of $A$/$E$ to quantify only over fair paths, instead of adding a formula.

= LTL vs. CTL --- §4.9

Incomparable expressive power:

- #strong[CTL-only] --- anything using $E$ ("there exists a path such that..."). LTL is always implicitly "for all paths" --- no syntax to assert path *existence*.
- #strong[LTL-only] --- $F G p$ ("eventually stabilizes forever") has *no* CTL equivalent: $A F A G p$ is too strong (stabilization on literally every branch, no escape ever), $A F E G p$ is too weak (only demands the *option* exists somewhere).

CTL\* (Emerson \& Halpern) subsumes both by dropping the alternation restriction --- theoretical interest only, no tool support here.

== When to prefer which

- #strong[Property needs "there's a way to…"] ($E$) $arrow.r$ *CTL*.
- #strong[Persistence / stabilization / fairness-shaped pattern] on a single trace $arrow.r$ *LTL*.
- #strong[Checked at runtime] against one observed trace $arrow.r$ *LTL* --- a single trace is linear; $E$/$A$ need the full branching structure, unobservable from one run.
- #strong[Tool is Spin] $arrow.r$ *LTL* (forced, no CTL support).
- #strong[Expressible in both, check-time efficiency matters] $arrow.r$ *CTL* --- linear in $|K| times |phi|$, vs. LTL's Büchi-automaton construction, exponential in $|phi|$.

#i[No universal winner --- match the logic to how you're actually thinking about the property: "what happens as this runs" $arrow.r$ LTL; "what remains reachable / possible" $arrow.r$ CTL.]

