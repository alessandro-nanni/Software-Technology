#import "../mono.typ": *
#import "@preview/mannot:0.4.0": *
#show: template.with(blue, red, [System Validation])

//#align(center,text(fill:red, size:20pt)[! Unlike other PDFs, this is AI generated !\ #text(fill:red, size:12pt)[It's a summary of questions I asked Claude, formatted as a cheat sheet.]])

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

#let Sat(x) = $"Sat"_(#x)$
#let el(x) = $"el"(#x)$
#let trn(x) = $attach(arrow.r, br: #x)$
#show table: it => block(breakable: false, it)

= Model Checking Algorithms --- Ch. 5

Both algorithms decide $K tack.r.double phi$ for $K = (S, I, arrow.r, lambda)$ by computing *sets of states*. $Sat(phi)$ is the set of states where $phi$ holds; $"succ"(s) = {s' | s arrow.r s'}$ is never empty ($arrow.r$ is left-total).

#table(
  columns: (auto, 1fr, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [], [CTL (§5.1)], [LTL (§5.3, tableau)],
  [Idea], [fill in $"Sat"$ sets bottom-up along the parse tree], [$K tack.r.double psi$ iff *no* path of $K$ satisfies $not psi$: build tableau $T$, product $P = T times K$, look for a *fair* infinite path in $P$],
  [Verdict], [$K tack.r.double Phi$ iff $I subset.eq Sat(Phi)$], [$K tack.r.double psi$ iff $P$ has *no* fair path from $I_P$],
)

== CTL --- basic algorithm (§5.1)

+ #strong[Convert to core CTL] ($not$, $and$, EX, EU, AF). Replace one operator at a time, outermost first:

  #table(
    columns: (1fr, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [formula], [rewrite as],
    [$"AG" Phi$], [$not "EF" not Phi equiv not "EU"("true", not Phi)$],
    [$"EF" Phi$], [$"EU"("true", Phi)$],
    [$"EG" Phi$], [$not "AF" not Phi$],
    [$"AX" Phi$], [$not "EX" not Phi$],
    [$"AU"(Phi_1, Phi_2)$], [$not "EU"(not Phi_2, not (Phi_1 or Phi_2)) and "AF" Phi_2$],
    [$Phi_1 or Phi_2$], [$not (not Phi_1 and not Phi_2)$],
    [$Phi_1 => Phi_2$], [$not (Phi_1 and not Phi_2)$],
  )

  Finish by cancelling double negations ($not not Phi arrow.r Phi$) and, if it shortens things, De Morgan --- as in the exercise.

+ #strong[Draw the parse tree.] One node per subformula, root = the whole formula. Children: $not Phi$, EX $Phi$, AF $Phi$ have the child $Phi$; $Phi_1 and Phi_2$ and $"EU"(Phi_1, Phi_2)$ have the children $Phi_1, Phi_2$. Leaves are atomic propositions (and $"true"$). Write a repeated subformula once.

+ #strong[Compute $"Sat"$ bottom-up.] Start at the leaves; a node is computed only once all its children are known. Each result is a set of states of $K$:

  #table(
    columns: (auto, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [node], [$"Sat"$],
    [$p in "AP"$], [${s in S | p in lambda(s)}$ #h(1em) ($"true"$: all of $S$)],
    [$not Phi_1$], [$S without Sat(Phi_1)$],
    [$Phi_1 and Phi_2$], [$Sat(Phi_1) inter Sat(Phi_2)$],
    [$"EX" Phi_1$], [${s | "succ"(s) inter Sat(Phi_1) eq.not emptyset}$ --- some successor in $Sat(Phi_1)$],
    [$"EU"(Phi_1, Phi_2)$], [iterate, see below],
    [$"AF" Phi_1$], [iterate, see below],
  )

  *Iteration scheme (EU and AF).* Both are fixed-point loops with the same skeleton: start with $"Sat" = emptyset$ and $Z$ = a start set. While $Z eq.not emptyset$: add $Z$ to $"Sat"$, then compute the new $Z$ and strip off whatever is already in $"Sat"$. Only the start set and the "new $Z$" rule differ:

  #table(
    columns: (auto, 1fr, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [], [$"EU"(Phi_1, Phi_2)$], [$"AF" Phi_1$],
    [start $Z$], [$Sat(Phi_2)$], [$Sat(Phi_1)$],
    [new $Z$], [${s in Sat(Phi_1) | "succ"(s) inter Z eq.not emptyset} without "Sat"$], [${s in S | "succ"(s) subset.eq "Sat"} without "Sat"$],
    [by hand], [list the *predecessors* of the states in $Z$ (last round only), keep those in $Sat(Phi_1)$], [test *every* state outside $"Sat"$: are *all* its successors in $"Sat"$?],
    [joins when], [*one* successor is in $Z$ (one route suffices)], [*all* successors are in $"Sat"$ (every route leads there)],
    [round $N$ =], [length of the *shortest* path to $Phi_2$ through $Phi_1$-states], [length of the *longest* route until $Phi_1$ is forced],
  )

  Write each loop as a table with columns $N$ | $"Sat"$ | new $Z$ | why. Row 0: $"Sat" = emptyset$, $Z$ = start set. Row $N$: $"Sat"$ = previous $"Sat"$ $union$ previous $Z$; then compute the new $Z$ and note why each candidate joined or was rejected. Stop when $Z = emptyset$; that row's $"Sat"$ is the answer.

  - The "$without "Sat"$" stops a state from joining twice. It is what ends the loop on cycles, and bounds it by $|S|$ rounds.
  - EU only needs the *previous round's* $Z$: older states already had their predecessors checked. AF must test against the *whole* $"Sat"$: a state needs all its successors in, and they may have joined in different rounds.
  - Empty start set: the body never runs, $"Sat" = emptyset$.
  - AF: one arrow to a state that never joins (a self-loop, or a cycle outside $"Sat"$) keeps a state out for good. $arrow.r$ is left-total, so $"succ"(s) eq.not emptyset$ and nothing joins vacuously.

+ #strong[Verdict.] $K tack.r.double Phi$ iff $I subset.eq Sat(Phi)$. A state in $I without Sat(Phi)$ shows the violation.

#n(supplement: [example], [EU and AF on the roller coaster])[
  $s_0$ idle, $s_1$ maintenance, $s_2$ moving, $s_3$ broken; $I = {s_0}$.

  #table(
    columns: (auto, auto, auto),
    stroke: 0.4pt, inset: 4pt,
    [state], [succ], [pred],
    [$s_0$], [$s_1, s_2$], [$s_1, s_2$],
    [$s_1$], [$s_0$], [$s_0, s_3$],
    [$s_2$], [$s_0, s_3$], [$s_0$],
    [$s_3$], [$s_1$], [$s_2$],
  )

  *$"EU"("true", "broken")$* (= EF broken). $Sat("true") = S$, so the $Phi_1$ filter removes nothing: plain backward reachability from $Sat("broken") = {s_3}$.

  #table(
    columns: (auto, auto, auto, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [$N$], [$"Sat"$], [new $Z$], [why],
    [0], [$emptyset$], [${s_3}$], [start],
    [1], [${s_3}$], [${s_2}$], [pred($s_3$) $= {s_2}$],
    [2], [${s_2, s_3}$], [${s_0}$], [pred($s_2$) $= {s_0}$],
    [3], [${s_0, s_2, s_3}$], [${s_1}$], [pred($s_0$) $= {s_1, s_2}$, $s_2$ already in],
    [4], [$S$], [$emptyset$], [pred($s_1$) $= {s_0, s_3}$, both in: stop],
  )

  $"Sat" = S$: every state can reach $s_3$.

  *$"AF" "idle"$*. Start $Z = Sat("idle") = {s_0}$. A state joins only when *all* its successors are in $"Sat"$.

  #table(
    columns: (auto, auto, auto, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [$N$], [$"Sat"$], [new $Z$], [why],
    [0], [$emptyset$], [${s_0}$], [start],
    [1], [${s_0}$], [${s_1}$], [$s_1$: succ ${s_0}$ ok; $s_2$ lacks $s_3$; $s_3$ lacks $s_1$],
    [2], [${s_0, s_1}$], [${s_3}$], [$s_3$: succ ${s_1}$ ok; $s_2$ still lacks $s_3$],
    [3], [${s_0, s_1, s_3}$], [${s_2}$], [$s_2$: succ ${s_0, s_3}$ ok, joins only now],
    [4], [$S$], [$emptyset$], [stop],
  )

  $"Sat" = S$. $s_2$ joins last because its worst route is $s_2 arrow.r s_3 arrow.r s_1 arrow.r s_0$ (3 steps).
]

#i[*Under fairness* (§5.2) the algorithm is unchanged; only the path quantifiers $A$, $E$ range over *fair* paths, i.e. paths that visit every constraint set $F_j subset.eq S$ infinitely often. `JUSTICE` $phi$: $F = Sat(phi)$. `COMPASSION` $(phi, psi)$: visiting $Sat(phi)$ infinitely often requires visiting $Sat(psi)$ infinitely often.]

== LTL --- tableau method (§5.3)

Pipeline: $psi arrow.r$ tableau $T$ $arrow.r$ product $P$ $arrow.r$ fairness constraints $arrow.r$ "does $P$ have a fair path?" (the CTL question $"EG" "true"$ under fairness). The tableau holds every path that could satisfy $not psi$; the product keeps those that $K$ can really perform.

+ #strong[Reduce to core LTL] ($not$, $and$, X, U; $or$ may stay, $"true"$ is a constant): $F phi equiv "true" U phi$, #h(0.5em) $G phi equiv not F not phi$, #h(0.5em) $phi_1 W phi_2 equiv (phi_1 U phi_2) or G phi_1$, #h(0.5em) $phi_1 or phi_2 equiv not (not phi_1 and not phi_2)$. Keep $psi$ itself --- the negation only enters at step 6.

+ #strong[Elementary subformulae] $el(psi)$ --- only atomic propositions and X-formulas survive:

  #table(
    columns: (auto, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [$phi$], [$el(phi)$],
    [$p$], [${p}$ #h(1em) ($"true"$: $emptyset$)],
    [$not phi_1$], [$el(phi_1)$],
    [$phi_1 and phi_2$, $phi_1 or phi_2$], [$el(phi_1) union el(phi_2)$],
    [$X phi_1$], [${X phi_1} union el(phi_1)$],
    [$phi_1 U phi_2$], [${X(phi_1 U phi_2)} union el(phi_1) union el(phi_2)$],
  )

  Let $n = |el(psi)|$. #h(0.5em) *Naming:* $psi$ = the whole (core) formula; a subformula $phi_1 U phi_2$ shows up in $el(psi)$ as $X(phi_1 U phi_2)$, and in exercises it is abbreviated $phi := phi_1 U phi_2$, so the elementary formula is $X phi$ (not $X psi$). $psi = phi$ only when the whole formula is a single U, e.g. $F "moving" = "true" U "moving"$.

+ #strong[Tableau states] $S_T$: every subset of $el(psi)$, so $2^n$ states. Write them as a truth table, one column per elementary formula, rows $t_0, dots, t_(2^n - 1)$ (1 = formula is in the state). $lambda_T (t)$ = the atomic propositions in $t$.

+ #strong[Sat sets on the tableau.] Steps 5--7 need: $Sat(phi)$ for the argument $phi$ of every $X phi in el(psi)$ (transitions), $Sat(psi)$ and its complement (initial states), and $Sat(phi_2)$ and $Sat(phi_1 U phi_2)$ for every U in $psi$ (fairness). Compute them bottom-up along the parse tree of $psi$; elementary formulas are read straight off the state table, everything else is built with:

  #table(
    columns: (auto, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [formula], [$Sat$ (subset of $S_T$)],
    [elementary ($p$ or $X phi_1$)], [states that *contain* it (read the column)],
    [$"true"$], [$S_T$],
    [$not phi_1$], [$S_T without Sat(phi_1)$],
    [$phi_1 and phi_2$], [$Sat(phi_1) inter Sat(phi_2)$],
    [$phi_1 or phi_2$], [$Sat(phi_1) union Sat(phi_2)$],
    [$phi_1 U phi_2$], [$Sat(phi_2) union (Sat(phi_1) inter Sat(X(phi_1 U phi_2)))$],
  )

  $phi_1, phi_2$ are placeholders for any two subformulas: for $"true" U "moving"$ take $phi_1 = "true"$, $phi_2 = "moving"$.

+ #strong[Tableau transitions.] $t trn(T) t'$ iff for every $X phi in el(psi)$: $X phi in t <=> t' in Sat(phi)$. In words, per $X phi$: a state that *contains* $X phi$ may only go to states in $Sat(phi)$; a state that does *not* contain it may only go to states *outside* $Sat(phi)$. With several X-formulas, intersect the allowed successor sets. Draw every allowed arrow (green $arrow.r$ red, yellow $arrow.r$ white in the exercise). Finally delete states without successors, repeating until none are left --- no infinite path is lost.

+ #strong[Initial states] $I_T = Sat(not psi) = S_T without Sat(psi)$ --- we search for paths that *violate* $psi$.

+ #strong[Fairness constraints.] Only needed if $psi$ contains $phi_1 U phi_2$. For each such subformula take $F_j = Sat(not (phi_1 U phi_2) or phi_2) = (S_T without Sat(phi_1 U phi_2)) union Sat(phi_2)$. A path is fair if it visits *each* $F_j$ infinitely often; this rules out paths that stay in $X(phi_1 U phi_2)$ forever without $phi_2$ ever happening. No U in $psi$: no constraints.

+ #strong[Product] $P = (S_P, I_P, trn(P), lambda_P)$ of $T$ and $K$:
  - *Restrict labels:* tabulate $lambda(s) inter "AP"_psi$ for every $s in S$ --- atomic propositions not in $psi$ are invisible.
  - *States:* $S_P = {(t, s) | t in S_T, s in S, lambda(s) inter "AP"_psi = lambda_T (t)}$. Group tableau and model states by label to list the pairs.
  - *Initial:* $I_P = {(t, s) in S_P | t in I_T and s in I}$.
  - *Transitions:* $(t, s) trn(P) (t', s')$ iff $t trn(T) t'$ *and* $s arrow.r s'$ (both components move together). $lambda_P ((t, s)) = lambda_T (t)$.
  - *Clean up:* delete states without successors (repeat) --- $P$ can have them even when $T$ has none; also drop everything not reachable from $I_P$.
  - *Lift fairness:* $F_j^P = {(t, s) in S_P | t in F_j}$.

+ #strong[Decide.] Is there an infinite path from $I_P$ that visits every $F_j^P$ infinitely often (i.e. does $P$ satisfy $"EG" "true"$ under fairness)? By hand: from $I_P$, look for a reachable cycle (strongly connected set with at least one arrow) that contains a state of *every* $F_j^P$.
  - *Found:* $K tack.r.double.not psi$. Counter-example = path to the cycle, then the cycle forever, read off as the $s$-components.
  - *None:* $K tack.r.double psi$.

#i[Verdict polarity: CTL says yes when $I subset.eq Sat(Phi)$; LTL says yes when $P$ has *no* fair path. Also: tableau sets live in $S_T$, model sets in $S$ --- never mix them, and all $F_j$ must be visited, not just one.]

#show table: set par(justify: false)

= Function Contracts in ACSL --- Ch. 7

A contract is a special comment placed *directly before* the function: #box[`/*@ ... */`] or #box[`//@ ...`] (the `@` marks it as an annotation). Every clause ends in `;`. Clause bodies are side-effect-free C expressions: no `=`, no `++`, and (unlike JML) no calls to C functions.

```
/*@ requires P;      // precondition: caller's duty
    terminates T;    // must terminate when T holds
    assigns L;       // frame: what may be modified
    ensures Q;       // postcondition: callee's promise
*/
int f(int *a, int n) { ... }
```

#strong[Clause order] (ACSL grammar): `requires` $arrow.r$ `terminates` $arrow.r$ `assigns`/`ensures` (any mix) $arrow.r$ `behavior`s $arrow.r$ `complete`/`disjoint`.

== Clauses \& defaults

#table(
  columns: (auto, 1fr, auto),
  stroke: 0.4pt, inset: 4pt,
  [clause], [meaning], [default],
  [`requires P;`], [precondition: must hold on entry; the *caller* must establish it], [`\true`],
  [`ensures Q;`], [postcondition: holds on exit --- *if* entered with $P$ and it terminates], [`\true`],
  [`assigns L;`], [frame: the *only* locations the function may modify (over-approximating is fine)], [everything],
  [`terminates T;`], [total correctness: must terminate whenever $T$ holds on entry], [none (partial)],
)

Several `requires` (or `ensures`) clauses are joined by `&&`: `requires A; requires B;` $equiv$ `requires A && B;`.

#strong[Partial correctness] (plain `requires`/`ensures`): if started in a state satisfying $P$ *and* it terminates, the end state satisfies $Q$. A function that never terminates vacuously satisfies every such contract. \
#strong[Total correctness]: it must also terminate --- add a `terminates` clause.

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [clause], [meaning],
  [ACSL `terminates T;`], [*must* terminate whenever $T$ holds on entry],
  [JML `diverges D;`], [*may* run forever only when $D$ holds on entry],
)

`terminates T` $equiv$ `diverges !T`, e.g. `terminates x >= 0;` $equiv$ `diverges x < 0;`. Always terminate: `terminates \true;` / `diverges false;`.

#i[Degenerate contracts: `requires \false;` --- nobody can legally call it (marks a deprecated function). `ensures \false;` --- it never returns normally. Called outside its precondition $arrow.r$ *no* guarantee at all. That is what allows "offensive" programming: drop the defensive argument checks from the body and check every call site instead.]

== Specification expressions

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [syntax], [meaning],
  [`\result`], [return value --- only in `ensures`],
  [`\old(e)`], [value of `e` on entry --- only in postconditions; sugar for `\at(e, Old)`],
  [`\at(e, L)`], [value of `e` at label `L` (table below, or any C label)],
  [`\true`, `\false`], [mathematical Booleans --- not C's `0`/`1`],
  [`\null`], [`(void*)0`],
  [`==>`, `<==>`], [implication, equivalence --- on top of `&&`, `||`, `!`],
  [`0 <= i < n`], [chained comparison $=$ `0 <= i && i < n`],
  [`c ? a : b`], [conditional expression],
  [`integer`], [mathematical (unbounded) integer, no overflow --- use it in specs; `int` is the machine type],
)

#i[Binders have the *lowest* precedence: a `\forall`/`\exists` body extends as far right as possible. `==>` binds weaker than `&&`/`||` (and is right-associative). So parenthesise a quantifier that is just one conjunct: `(\forall integer i; ...) && n > 0`.]

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [label], [state it refers to],
  [`Pre`], [entry of the current function],
  [`Old`], [entry, as seen by the contract --- `\old(e)` $=$ `\at(e, Old)`],
  [`Here`], [where the annotation is written],
  [`Post`], [exit of the current function],
  [`LoopEntry`], [just before the current loop's first iteration],
  [`LoopCurrent`], [start of the current loop iteration],
  [`Init`], [before `main` runs, once globals are initialised],
)

== Quantifiers

`\forall type x, y; body` #h(1em) `\exists type x; body` --- declare the bound variables, then `;`, then the body. Quantify over `integer`.

```
\forall integer i; 0 <= i < n ==> P(i)
\exists integer i; 0 <= i < n && P(i)
```

#i[*Pairing rule:* `\forall` goes with `==>` (in range implies property), `\exists` goes with `&&` (in range and property). Swapping them is a classic bug: `\exists i; range ==> P` is made true by any `i` *outside* the range, and `\forall i; range && P` is made false by that same `i`.]

#block(sticky: true)[Patterns over an array `a` of length `n`:]

```
// sorted (all pairs)
\forall integer i, j; 0 <= i < j < n ==> a[i] <= a[j]
// sorted (neighbours --- equivalent by transitivity)
\forall integer i; 0 <= i < n-1 ==> a[i] <= a[i+1]
// all zero
\forall integer i; 0 <= i < n ==> a[i] == 0
// contains x
\exists integer i; 0 <= i < n && a[i] == x
// no duplicates
\forall integer i, j; 0 <= i < j < n ==> a[i] != a[j]
// \result is the maximum: an upper bound AND attained
(\forall integer i; 0 <= i < n ==> a[i] <= \result) &&
(\exists integer i; 0 <= i < n && a[i] == \result)
// array unchanged
\forall integer i; 0 <= i < n ==> a[i] == \old(a[i])
```

`\sum` and `\num_of` also exist, but tool support for them is experimental.

== Pointers \& memory

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [syntax], [meaning],
  [`\valid(p)`], [`*p` may safely be read *and* written],
  [`\valid(a+(0..n-1))`], [all of `a[0]`, ..., `a[n-1]` are valid --- `a+(i..j)` is a *set* of pointers],
  [`\valid_read(p)`], [`*p` may only be read (e.g. a string literal); `\valid` $arrow.r.double$ `\valid_read`, not conversely],
  [`\null`], [`\valid(\null)` and `\valid_read(\null)` are always false],
  [`\separated(p, q)`], [what `p` and `q` point to does not overlap (ranges allowed)],
)

#block(sticky: true)[Typical array-parameter prelude:]

```
requires n >= 0 && \valid(a + (0..n-1));
requires \separated(a + (0..n-1), b + (0..n-1));
```

== Frame --- `assigns` (§10.3)

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [clause], [may modify],
  [`assigns \nothing;`], [nothing: no side effects at all],
  [`assigns *p;`], [only the cell `p` points to],
  [`assigns s->credits;`], [only that field],
  [`assigns a[0..n-1];`], [a slice of an array (`a[i..j]`)],
  [`assigns x, *p;`], [a list: any of these],
)

#i[No `assigns` $=$ *anything* may change. So `addCredits` with only `ensures s->credits == \old(s->credits) + c;` may legally overwrite the name or the status (Ex. 7.3). Adding `ensures s->name == \old(s->name);` for every untouched variable works but doesn't scale; `assigns s->credits;` says it once.]

== Behaviours --- §7.4

```
/*@ requires P;               // shared by all cases
    behavior b1:
      assumes A1;             // when does b1 apply?
      requires R1;            // extra duty if it does
      ensures E1;
    behavior b2:
      assumes A2;
      requires R2;
      ensures E2;
    complete behaviors b1, b2;  // P ==> (A1 || A2)
    disjoint behaviors b1, b2;  // P ==> !(A1 && A2)
*/
```

- `assumes` *selects* the case: if $A$ is false the behaviour simply doesn't apply (no error). A `requires` inside a behaviour is an *obligation* on the caller whenever the behaviour applies.
- Behaviour `b` reads as `requires A ==> R; ensures \old(A) ==> E;` --- the assumption is evaluated on entry.
- `complete` $=$ the cases cover every input allowed by $P$; `disjoint` $=$ at most one case applies; both $=$ a partition. With no names listed they refer to *all* behaviours.
- Clauses outside any `behavior` (incl. `assigns`, `ensures`) apply in every case.

```
/*@ requires \valid(p);
    assigns *p;
    behavior pos:
      assumes *p >= 0;
      ensures *p == \old(*p);
    behavior neg:
      assumes *p < 0;
      requires *p > INT_MIN;   // -INT_MIN overflows
      ensures *p == -\old(*p);
    complete behaviors;
    disjoint behaviors;
*/
void absInPlace(int *p);
```

== Data invariants --- §7.3

```
//@ global invariant cntPos: count >= 0;

/*@ type invariant posCredits(Student *s) =
      s->credits >= 0;
*/
```

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [kind], [meaning],
  [`global invariant`], [property of *global variables*: `global invariant name: pred;`],
  [`type invariant`], [property of every value of a (typedef'd) type: `type invariant name(T x) = pred;`],
  [weak (default)], [holds at function *boundaries*: silently added to every function's `requires` and `ensures`; may be broken temporarily inside a body],
  [`strong`], [prefix, e.g. `strong global invariant ...`: must hold at *every* program point],
)

#i[A weak invariant must be re-established *before every call* --- even a call in the middle of the body --- because it is part of the callee's precondition (callback problem, Ex. 7.16). Weak invariants only make sense for sequential code; with threads every state is visible. Frama-C's static checker does not verify type invariants yet.]

= Abstract Specifications --- Ch. 8

A contract should say *what* a function does, not *how*. Every sorting algorithm gets the same contract (input: an array; output: sorted, and a permutation of the input), so callers can rely on it whatever the implementation. Abstraction also lets you specify code that doesn't exist yet: the spec then guides the implementation.

#table(
  columns: (auto, 1fr, auto),
  stroke: 0.4pt, inset: 4pt,
  [feature], [idea], [ACSL #linebreak() JML],
  [§8.1 #linebreak() functions], [hide details behind a spec-only function --- no new state], [`logic`, `predicate` #linebreak() `pure`, `model` methods],
  [§8.2 #linebreak() model vars], [*abstract* the state: a value computed from the concrete fields], [future work #linebreak() `model` + `represents`],
  [§8.3 #linebreak() ghost vars], [*extend* the state: extra info, updated explicitly], [`ghost` #linebreak() `ghost`],
)

== Functions in contracts --- §8.1

ACSL can't call C functions inside specs. Instead, define *mathematical*, spec-only functions: pure definitions that are never executed and can't change the state.

```
/*@ logic integer _abs(int x) = (x > 0) ? x : -x; */

/*@ requires x > INT_MIN;     // -x would overflow
    ensures \result == _abs(x);
*/
int abs(int x) { ... }

/*@ predicate validDate(struct date *d) =
      \valid(d) && 0 < d->day < 32
                && 0 < d->month <= 12;
*/
//@ requires validDate(d);
```

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [declaration], [meaning],
  [`logic T f(params) = e;`], [value-returning math function; returning `integer` $arrow.r$ no overflow. The leading `_` avoids a clash with the C function `abs`],
  [`predicate p(params) = pred;`], [Boolean-valued; bundles e.g. "this struct is valid" into one name to reuse in `requires` and invariants],
)

JML can use any `pure` method in a spec, or a spec-only *model method* (JML leaves overflow up to the tool):

```
/*@ model int math_abs(int x) {
      return (x > 0) ? x : -x;
    }
*/
```

#i[Not a real abstraction of the state space: it only hides details from the reader. For a tiny function the definition looks like the code; for big ones it keeps the contract readable.]

#strong[Abstract logic functions] (slides). If the implementation isn't known yet, *declare* a logic function without a body and specify in terms of it; the definition comes once the concrete code exists. Phone example: how many queue slots a message takes depends on its protocol (SMS, MMS) and contents, which `send` shouldn't have to know:

```
struct message {
  ...
  //@ logic integer slots_used();   // no body yet
};
//@ ghost int slots_available;

/*@ requires m.slots_used() < slots_available;
    ensures \result == slots_available;
    ensures slots_available + m.slots_used()
              == \old(slots_available);
*/
int send(message *m) {
  ...
  /*@ ghost slots_available =
        slots_available - m.slots_used(); */
}
```

#i[That is slide pseudo-syntax. In real ACSL the message is a parameter (`slots_used(m)`), and a `logic` declaration without a body goes inside an `/*@ axiomatic Name { ... } */` block.]

== Model variables --- §8.2 (JML only)

A *model* variable is a spec-only field whose value is *defined by* the concrete state (Hoare's data abstraction). It changes implicitly whenever that state changes. ACSL support is future work, so Frama-C has none. Two uses:

+ the concrete state isn't defined yet, e.g. an *interface* that will be implemented in different ways;
+ a more abstract, mathematical view of a value spread over several fields.

```
public interface Student {
  //@ public instance model int credits;
  //@ public instance model int status;
  //@ public invariant credits >= 0;

  //@ ensures \result == credits;
  /*@ pure */ public int getCredits();

  /*@ requires c >= 0;
      ensures credits == \old(credits) + c; */
  public void addCredits(int c);
}

class CreditListStudent implements Student {
  private List<Integer> credit_list;
  /*@ represents credits <- sum();
      represents status <-
        (sum() < 180 ? bachelor : master);
  */
  ...
}
```

`instance` is needed because interface fields are `static` by default. The class inherits the interface's specs; `represents` links each model field to the class's own fields. Tools *substitute* it, so `ensures \result == credits` is checked as `ensures \result == sum();`. A simpler `BasicStudent` just writes `represents credits <- this.credits;`.

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [clause], [meaning],
  [`represents m <- e;` #linebreak() (or `= e`)], [functional: $m$ *is* $e$, computed from the concrete fields],
  [`represents m \such_that P;`], [non-functional: only a relation $P$ between abstract and concrete state, e.g. "`_credit_list` and `credit_list` have the same elements" (two nested `\forall`/`\exists`). JML also has dependency clauses, not covered],
)

#i[`spec_public` is sugar for a model variable: `/*@ spec_public */ private int x;` $equiv$ `//@ model int _x;` + `//@ represents _x <- this.x;`. The client gets the same abstract view either way.]

#block(sticky: true)[#strong[Mathematical abstraction] (`Decimal`): two fields encode one number; the spec talks only about the number.]

```
public static final short PRECISION = 1000;
/*@ spec_public */ private short intPart = 0;
/*@ spec_public */ private short decPart = 0;
//@ model int value;
//@ represents value = intPart * PRECISION + decPart;

//@ ensures value == \old(value) + e * PRECISION + f;
public void add(short e, short f);
```

#block(sticky: true)[ACSL workaround (slides): a `logic` function over the fields plays the model variable.]

```
//@ logic integer value() = intPart * PRECISION + decPart;
```

== Ghost variables --- §8.3

Spec-only variables that *extend* the state; declared and updated only through `//@ ghost ...` statements, never seen by the compiler. A ghost statement may be more complex (`if`, `?:`) as long as it only writes ghost variables: erasing all ghost code must leave the program's behaviour unchanged. Three typical uses:

#block(sticky: true)[*Control flow* --- count loop iterations (e.g. to bound them):]

```
//@ ghost int z;

//@ requires x >= 0;
//@ ensures z == x;
void doLoop(int x) {
  int y = 0;
  //@ ghost z = 0;
  while (x > 0) {
    x = x - 1;
    y = y + 2;
    //@ ghost z = z + 1;
  }
}
```

#i[In `doLoop`, `ensures z == x` compares with the *entry* value of `x`: a parameter in a postcondition always means its value on entry. The book omits `requires x >= 0`, but without it the contract fails for negative `x` (then `z == 0`).]

#block(sticky: true)[*Resources* --- memory, time (each `int` is 4 bytes; matters on smart cards and other small devices):]

```
//@ ghost int MEM = 0;
//@ ghost int MAX = ...;

//@ requires MEM + 400 <= MAX;
//@ ensures MEM <= MAX;
void m() {
  ptr = (int*) malloc(100 * sizeof(int));
  //@ ghost MEM = MEM + 400;
}
```

#block(sticky: true)[*Protocol* --- in which order functions may be called (fresh $arrow.r$ active $arrow.r$ dead):]

```
//@ ghost int state = 0;   // 0 fresh, 1 active, 2 dead

/*@ requires state == 0;
    ensures  state == 1; */
void init() {
  ...
  //@ ghost state = 1;
}

/*@ requires state == 1;
    ensures  state == 1; */
void execute() { ... }

/*@ requires state == 1;
    ensures  state == 2; */
void finalize() {
  //@ ghost state = 2;
  ...
}
```

- Transitions = ghost updates in the body; "may this be called now?" = `requires`.
- JML can also add an `invariant` (legal values of `state`) and a `constraint` relating `\old(state)` to `state` (never back to fresh; dead stays dead).
- Like a LarVa automaton (§6.2), but the protocol is *woven* into the code and combines with the other contracts. Main application: security automata (§9.5).

== Model vs. ghost --- §8.4

#block(sticky: true)[Both are spec-only and don't exist when the program runs.]

#table(
  columns: (auto, 1fr, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [], [model], [ghost],
  [relation to state], [*abstracts* the existing state], [*extends* the state with info not derivable from it],
  [value given by], [`represents`: a function, a relation, or only a dependency], [explicit `ghost` assignments],
  [changes], [implicitly, with the concrete state], [only when you update it],
  [tied to], [data / objects (e.g. max size of a message)], [state / history (e.g. space left in a buffer; which methods were called, how often)],
  [ACSL], [not supported (use a `logic` function)], [supported],
)

#i[Rule of thumb (slides): if you need one per `x` and `x` is defined in your program, use a model variable. If it records what has *happened* (events, counts, resources used), use a ghost variable.]

== ACSL vs. JML at a glance

#table(
  columns: (auto, 1fr, 1fr),
  stroke: 0.4pt, inset: 3pt,
  [], [ACSL (C)], [JML (Java)],
  [termination], [`terminates T;` must terminate if `T`], [`diverges D;` may diverge only if `D`],
  [cases], [named: `behavior b:` + `assumes`; `complete`/`disjoint`], [unnamed, joined by `also`; nest with `{| |}`],
  [heavyweight], [---], [`behavior`: must terminate (throwing ok) #linebreak() `normal_behavior`: must return normally #linebreak() `exceptional_behavior`: must throw],
  [in specs], [`logic`/`predicate` only], [`pure` methods, `model` methods],
  [abstract state], [`logic` function over the fields], [`model` fields + `represents`],
  [quantifier], [`\forall integer i; R ==> P`], [`(\forall int i; R; P)`, range optional],
  [constants], [`\true`, `\false`, `\null`], [`true`, `false`, `null`; refs *non-null by default* (`nullable`)],
  [frame], [`assigns`], [`assignable`/`modifies`],
  [invariants], [`global`/`type`; weak or `strong`], [`instance invariant`, always weak; `helper` exempt],
  [exceptions], [none in C], [`signals (E e) P;` #linebreak() `signals_only E1, E2;`],
  [extras], [`\at`, `\valid`, `\separated`, `ghost`], [`initially`, `constraint`, `spec_public`, `model` + `represents`, `ghost`],
)

= Runtime Annotation Checking --- Ch. 9

Instrument the program so every annotation becomes a check: evaluate the predicate at the right point, and abort if it is false.

- *precondition*: on entry, before the body runs;
- *postcondition*: after the body, before control returns to the caller --- at *every* exit point;
- several behaviours / spec cases are first desugared into one pre and one post (§7.4).

It validates the spec against *one* execution: no guarantee for runs you didn't try. For that you need static checking (Ch. 10).

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [tool], [history],
  [Eiffel], [first: Meyer's Design by Contract, a compiler option inserts pre/post checks for testing],
  [JML], [developed together with its checker; checks first added to the source, now to the bytecode],
  [ACSL / Frama-C], [designed for runtime *and* static checking; runtime checking only for the executable subset *E-ACSL*],
)

== By hand --- §9.2

```
/*@ requires c >= 0;
    ensures s->credits == \old(s->credits) + c; */
void addCredits(Student *s, int c) {
  assert(c >= 0);                        // pre
  int oldCredits = s->credits;           // save \old yourself
  s->credits = s->credits + c;
  assert(s->credits == oldCredits + c);  // post
}
```

Niño \& Hosch only assert the *precondition*: the callee can never trust its callers, while the postcondition is the implementer's own job (to be shown by other means, e.g. static checking). Real checkers test both.

#block(sticky: true)[What makes it hard (book + slides), i.e. what a checker has to handle:]

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [problem], [why],
  [multiple exit points], [the postcondition must be checked at every `return`],
  [abnormal termination], [temporarily recover, check invariants / exceptional post, then re-raise the error (the runtime version of `try`/`catch`/`finally`)],
  [spec-only constructs], [not valid in `assert`: quantifiers become loops, `\old` needs saved copies, `\valid` needs memory tracking],
  [global specs], [one invariant becomes checks in many places],
  [spec itself fails], [`requires 1/x > 0;` divides by zero when `x == 0`: evaluation must be guarded],
  [concurrency], [the checks change the interleavings, and interleavings can change whether a spec holds],
  [source changes], [the code that runs is not the code you wrote],
)

== Requirements --- §9.3

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [requirement], [meaning],
  [*transparent*], [no violation $arrow.r$ same behaviour with or without checking (apart from speed)],
  [*isolation*], [a violation is reported when it happens, and traceable to where it went wrong],
  [*trustworthy*], [no false alarms: every reported violation is a real one],
  [overhead], [(slides) keep it as low as possible],
)

== E-ACSL

A Frama-C plugin for an *executable subset* of ACSL: every E-ACSL spec can be executed. It:

- wraps each function body in spec checks; checks the post at every exit;
- copies values when you use `\old(...)`;
- tracks allocated memory at run time, to evaluate `\valid`;
- computes `integer` with the GMP library (real mathematical integers, so no overflow inside the check);
- guards expressions that would themselves fail, and reports them instead of crashing;
- *enumerates* quantifiers, so they must be bounded and of the right shape: `\forall integer i; lo <= i < hi ==> ...`.

```
e-acsl-gcc.sh file.c -c -O out   # instrument + compile
./out.e-acsl                      # run; aborts on violation
```

*Pre-deployment:* debug with the checks on, ship without them. #h(0.5em) *Post-deployment:* keep them as a monitor for unwanted situations.

#strong[Limitations.] Only executable specs; unbounded quantification (e.g. over all objects) is problematic. A bug is caught only if a spec covers it *and* the run you execute actually violates it.

== Using the checker --- §9.4

You need an executable *driver* (`main`) that steers the component into the violating state. As in testing, corner cases are where bugs hide, so aim for coverage of all execution paths; the annotations suggest the cases. Test generation from annotations: Frama-C *PathCrawler*, JML *JmlUnitNG* (a JUnit extension).

#n(supplement: [example], [activity bonus --- Ex. 9.3])[
  Active students get up to 5 bonus credits, but a Bachelor student may never get past 180 that way. The implementation forgets the cap:

  ```
  /*@ requires 0 <= bonus <= 5 && s->active;
      behavior bachelor:
        assumes s->status == bachelor;
        ensures s->credits ==
          (\old(s->credits) + bonus > 180 ? 180
             : \old(s->credits) + bonus);
      behavior master:
        assumes s->status == master;
        ensures s->credits == \old(s->credits) + bonus;
  */
  void activityBonus(Student *s, int bonus) {
    if (active(s)) addCredits(s, bonus);   // no cap!
  }

  void main() {
    Student s;
    studentInit(&s, 0, "Marieke");
    becomeActive(&s);
    addCredits(&s, 178);   // get close to the cap first
    activityBonus(&s, 5);  // 183, spec says 180
  }
  ```

  A lone `activityBonus(&s, 5)` from 0 credits never reaches the cap. So the driver first uses `addCredits`, which has no bound, to get to 178.

  #i[The book writes `requires` where `assumes` is meant, so *both* behaviours apply to every student. E-ACSL then reports `Precondition failed ... s->status == master`: an error in the *spec*, not the code. With `assumes` you get the intended postcondition failure (183 $eq.not$ 180).]
]

#block(breakable: false, n(supplement: [example], [abs and max (slides)])[
  ```
  /*@ requires x > INT_MIN;      // only in the last run
      ensures (x >= 0 ==> \result == x) &&
              (x <  0 ==> \result == -x);
      assigns \nothing; */
  int absval(int x) { return (x > 0) ? x : (-x); }
  ```

  #table(
    columns: (1fr, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [driver], [result],
    [no contract; `n = absval(3);` then `//@ assert n == 2;`], [assertion failure (an `assert` in the code is checked too)],
    [contract without `requires`; `absval(0)`, `absval(3)`], [no error],
    [same, plus `absval(INT_MIN)`], [*postcondition* violation],
    [with `requires`, same calls], [*precondition* violation: blame moves to the caller],
  )

  `-INT_MIN` overflows in C, but the check computes `-x` as a mathematical `integer`, so `\result == -x` fails.

  ```
  /*@ ensures \result >= x && \result >= y;
      ensures \result == x || \result == y; */
  int maxval(int x, int y) { return x; }
  ```

  Driver `maxval(INT_MAX, INT_MIN)`, `maxval(5, 3)`, `maxval(0, 0)`: *no error*. Every call has `x >= y`, and the bug only shows with `x < y`.
])

== Monitoring behavioural properties --- §9.5

Runtime monitoring (§6.2) done with a runtime annotation checker: (1) encode the automaton as annotations, (2) write a `main` and run it. If an annotation of the automaton is violated, the checker terminates the application.

Smart card *life cycle property*: initialise the PIN once; before each payment the right PIN must be entered; three wrong PINs in a row block the card.

+ ghost constants for the automaton states, including a bad state (`BLOCKED`) that must never be reached;
+ ghost variables for the current state (starts `FRESH`) and extra counters (`attempts = 0`);
+ a `global invariant` listing the allowed states --- *without* the bad one, so reaching it is a violation; another one links the counter to it;
+ per function: `requires` = in which states it may be called, `ensures` = the transitions;
+ ghost assignments in the bodies = the automaton's events (they make the code follow the spec).

#block(sticky: true)[States, counters and invariants:]

```
//@ ghost static const int FRESH = 0;
//@ ghost static const int READY_FOR_USE = 1;
//@ ghost static const int READY_FOR_PAYMENT = 2;
//@ ghost static const int BLOCKED = 3;
//@ ghost int state = FRESH;
//@ ghost int attempts = 0;

/*@ global invariant allowed:
      state == FRESH || state == READY_FOR_USE
                     || state == READY_FOR_PAYMENT;
    global invariant I:
      state == BLOCKED <==> attempts == 3;
*/
```

#block(sticky: true)[Contracts (transitions) and ghost updates (events):]

```
/*@ requires state == FRESH;
    ensures state == READY_FOR_USE && attempts == 0; */
void initialiseCard() {
  ...
  //@ ghost state = READY_FOR_USE;
  //@ ghost attempts = 0;
}

/*@ requires state == READY_FOR_PAYMENT;
    ensures state == READY_FOR_USE; */
void makePayment() {
  ...
  //@ ghost state = READY_FOR_USE;
}
```

```
/*@ requires state == READY_FOR_USE && attempts < 3;
    ensures \result == true ==>
      state == READY_FOR_PAYMENT && attempts == 0;
    ensures \result == false ==>
      attempts == \old(attempts) + 1;
    ensures \result == false && attempts < 3 ==>
      state == READY_FOR_USE;
    ensures \result == false && attempts == 3 ==>
      state == BLOCKED;
*/
bool enterPin(int pin) {
  bool rslt = false;
  ...
  //@ ghost attempts = (rslt ? 0 : attempts + 1);
  /*@ ghost state = (rslt ? READY_FOR_PAYMENT
        : (attempts == 3 ? BLOCKED : READY_FOR_USE));
  */
  return rslt;
}
```

The third wrong PIN sets `state = BLOCKED`, which breaks invariant `allowed` at the exit of `enterPin`. A blocked card stays blocked: no function accepts `BLOCKED` in its `requires`.

#block(sticky: true)[JML can state the whole automaton in one place, with `initially` (holds right after construction) and a `constraint` (relates the pre- and post-state of *every* method):]

```
//@ initially state == FRESH;
/*@ public constraint
    (\old(state) == FRESH ==>
       state == FRESH || state == READY_FOR_USE) &&
    (\old(state) == READY_FOR_USE ==>
       state == READY_FOR_USE ||
       state == READY_FOR_PAYMENT ||
       state == BLOCKED) &&
    (\old(state) == READY_FOR_PAYMENT ==>
       state == READY_FOR_PAYMENT ||
       state == READY_FOR_USE) &&
    (\old(state) == BLOCKED ==> state == BLOCKED);
*/
```

#i[Advantage over a LarVa monitor (§6.2): the same annotations can also be checked *statically* (Ch. 10). Monitoring has a significant overhead; wherever static analysis proves the property can't be violated, the runtime check can be dropped. Systematic translations exist (AutoJML; security automata $arrow.r$ JML, proven correct by Huisman \& Tamalet).]

// Ch. 10 colours: one meaning per colour, used in every annotated formula.
#let cP = rgb("#1565c0") // precondition: what is assumed
#let cS = rgb("#e65100") // statement: the program
#let cQ = rgb("#2e7d32") // postcondition: what must be reached
#let cR = rgb("#00838f") // intermediate predicate
#let cI = rgb("#6a1b9a") // loop invariant
#let cV = rgb("#c62828") // variant: termination

// mannot annotations take no space: reserve it, and keep the equation in one piece.
#let room(top: 0em, bottom: 0em, body) = block(
  breakable: false,
  width: 100%,
  inset: (top: top, bottom: bottom),
  body,
)

// Proof-tree node: premises side by side (bottom-aligned), a line, the conclusion.
#let infer(..prems, concl) = context {
  let ps = prems.pos()
  let p = grid(columns: ps.len(), column-gutter: 1.5em, align: bottom, ..ps)
  let w = calc.max(measure(p).width, measure(concl).width)
  box(width: w, stack(
    dir: ttb,
    spacing: 3pt,
    align(center, p),
    line(length: w, stroke: 0.5pt),
    align(center, concl),
  ))
}

= Static Annotation Checking --- Ch. 10

Runtime checking (Ch. 9) only checks the runs you actually execute. *Static* checking proves the annotations for *every* input and every path, without running anything: a *program logic* turns code + contract into first-order formulas, and an automated theorem prover (Z3, CVC3, Simplify) proves them.

#table(
  columns: (auto, auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [who], [when], [contribution],
  [Floyd], [1960s], [pre- and postconditions: reason about a program without running it],
  [Hoare], [1969], [concrete proof rules $arrow.r$ *Hoare logic*; needs *invented* intermediate predicates],
  [Dijkstra], [1976], [*weakest preconditions*: *compute* those predicates instead $arrow.r$ automation],
)

Tools: Frama-C's *WP* plugin (ACSL); *OpenJML* (recommended by the book) and *KeY* (JML). Older Java tools: ESC/Java, LOOP, Krakatoa, Jack. Other languages: Spec\#, CodeContracts. Frama-C (CEA, from 2009) reasons effectively about C, long thought impossible because of C's under-specified semantics.

#block(sticky: true)[The chapter builds a tower. Each level only uses the levels above it in this table:]

#table(
  columns: (auto, 1fr, auto),
  stroke: 0.4pt, inset: 4pt,
  [level], [adds], [§],
  [0 predicates], [formulas over program variables; $=>$ as "stronger than"; substitution], [Ch. 2],
  [1 triples], [${P} S {Q}$: what "correct" means], [10.2],
  [2 proof rules], [how to *derive* triples, one rule per statement form], [10.2],
  [3 wp calculus], [*compute* the precondition $arrow.r$ one formula for the prover], [10.2],
  [4 calls, frame], [use the callee's *contract*, not its body; say what it may change], [10.3],
  [5 annotations], [`assert`, loop invariants: what wp can't compute], [10.4],
  [6 termination], [loop variants: total correctness], [10.5],
)

#i[Colours in the annotated formulas below: #text(fill: cP)[*precondition*] (assumed), #text(fill: cS)[*statement*] (the program), #text(fill: cQ)[*postcondition*] (to reach), #text(fill: cR)[*intermediate*], #text(fill: cI)[*invariant*], #text(fill: cV)[*variant*].]

== Level 0: predicates --- the building blocks

A *state* gives every program variable a value, e.g. $x |-> 3, y |-> 5$. A *predicate* (assertion) $P$ is a first-order formula over the program variables, such as $x > y$ (connectives and quantifiers: see the first section). Each state satisfies it or not, so a predicate *is* a set of states.

#room(top: 0.3em, bottom: 0.3em)[$
  markhl(P, #<str>, #cP) quad => quad markhl(Q, #<wk>, #cQ)
  #annot(<str>, pos: left, dx: -1.5em)[stronger: \ fewer states]
  #annot(<wk>, pos: right, dx: 1.5em)[weaker: \ more states]
$]

$P => Q$ (valid) means every state satisfying $P$ also satisfies $Q$: $P$ says *more*. Extremes: $"false"$ is the strongest predicate (no state), $"true"$ the weakest (every state).

*Substitution* (Def. 2.5) is the one operation on predicates this chapter needs:

#room(top: 1.3em, bottom: 1.3em)[$
  mark(Q, #<sq>, #cQ) [ mark(x, #<sx>, #cS) := mark(E, #<se>, #cP) ]
  #annot(<sq>, pos: left, dx: -1.5em)[a predicate]
  #annot(<sx>, pos: bottom, dy: 0.6em)[every free $x$ in $Q$ ...]
  #annot(<se>, pos: top, dy: -0.8em)[... is replaced by $E$]
$]

E.g. $(x > 0)[x := y + 2] = (y + 2 > 0)$.

*Logical variables* ($A$, $B$, ...) are not program variables: the program never assigns them. They are implicitly $forall$-quantified over the whole triple and *remember* a value --- Hoare logic's version of `\old`.

== Level 1: Hoare triples --- §10.2

#room(top: 1.6em, bottom: 2em)[$
  {markhl(P, #<hp>, #cP)} quad markhl(S, #<hs>, #cS) quad {markhl(Q, #<hq>, #cQ)}
  #annot(<hp>, pos: bottom + left, dy: 0.6em)[precondition: \ assumed at the start]
  #annot(<hs>, pos: top, dy: -0.8em)[statement: any program fragment]
  #annot(<hq>, pos: bottom + right, dy: 0.6em)[postcondition: \ guaranteed at the end]
$]

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [triple], [meaning],
  [${P} S {Q}$ #linebreak() partial], [*if* $S$ starts in a state satisfying $P$ *and* terminates, the final state satisfies $Q$. Running forever satisfies it vacuously.],
  [$[P] S [Q]$ #linebreak() total], [if $S$ starts in a state satisfying $P$, it *does* terminate, and the final state satisfies $Q$.],
)

A contract is a verbose Hoare triple: `requires P; ensures Q;` on body $B$ means ${P} B {Q}$ (with `terminates`: $[P] B [Q]$). A proof covers *all* input states and arguments at once, without executing anything.

#n(supplement: [example], [swap --- Ex. 10.1])[
  ```
  //@ ensures x == \old(y) && y == \old(x);
  void swap() { int t = x; x = y; y = t; }
  ```
  As a triple, with logical variables for the old values:
  #room(top: 0.2em, bottom: 1.3em)[$
    {x = mark(A, #<la>, #cP) and y = mark(B, #<lb>, #cP)} quad "swap"() quad {x = B and y = A}
    #annot((<la>, <lb>), pos: bottom, dx: 1.6em, dy: 0.8em)[logical variables: the initial values]
  $]
  It holds for *every* $A$, $B$: whatever $x$ and $y$ were, they end up swapped.
]

== Level 2: proof rules (Hoare logic) --- §10.2

A rule says: to get the triple *below* the line, it suffices to prove what is *above* it. A rule with nothing above is an *axiom*. There is one rule per statement form, so the proof of a compound statement splits into proofs about its parts.

#room(top: 0.3em, bottom: 0.3em)[$
  (markrect(H_1 quad H_2 quad dots quad H_n, #<prem>, #luma(90))) / (markrect(C, #<concl>, #luma(90)))
  #annot(<prem>, pos: right, dx: 1.5em)[premises: what you prove]
  #annot(<concl>, pos: right, dx: 1.5em)[conclusion: what you get]
$]

#strong[Assignment axiom] --- the base case: no premises.

#room(top: 1.4em, bottom: 1.4em)[$
  {markhl(Q[x := E], #<aq>, #cP)} quad markhl(x := E, #<as>, #cS) quad {markhl(Q, #<aqq>, #cQ)}
  #annot(<aq>, pos: top + left, dy: -0.8em)[$Q$, with $E$ in place of $x$]
  #annot(<as>, pos: bottom, dy: 0.6em)[the assignment]
  #annot(<aqq>, pos: top + right, dy: -0.8em)[$Q$ about the new $x$]
$]

After `x := E`, $x$ holds the value $E$ had *before*. So $Q$ holds afterwards iff $Q$ with $E$ in place of $x$ held before. That is why the rule runs *backwards*: from the post you get the pre. E.g. for `x := y + 2` and $Q = x > 0$: ${y + 2 > 0} med x := y + 2 med {x > 0}$.

#i[A forward rule like ${P} med x := E med {P and x = E}$ is wrong: for `x := x + 1` it gives $x = x + 1$. The old $x$ is gone; substituting backwards never has that problem.]

#strong[Sequence.] Split $S_1; S_2$ at a predicate $R$ that holds in between:

#room(top: 1.6em, bottom: 0.2em)[$
  ({P} med S_1 med {markhl(R, #<r1>, #cR)} quad {markhl(R, #<r2>, #cR)} med S_2 med {Q}) / ({P} med S_1; S_2 med {Q})
  #annot((<r1>, <r2>), pos: top, dx: 1.5em, dy: -0.8em)[intermediate predicate: has to be *invented*]
$]

#strong[Conditional.] Each branch may assume the outcome of the test, and both must reach the *same* $Q$:

#room(top: 1.5em, bottom: 0.2em)[$
  ({P and markhl(c, #<ct>, #cP)} med S_1 med {Q} quad {P and markhl(not c, #<cf>, #cP)} med S_2 med {Q}) / ({P} med "if" c "then" S_1 "else" S_2 med {Q})
  #annot(<ct>, pos: top, dy: -0.8em)[then: $c$ was true]
  #annot(<cf>, pos: top, dy: -0.8em)[else: $c$ was false]
$]

#strong[Function.] Proving a function's contract $=$ proving its body: $ ({P} "body" {Q}) / ({P} #raw("void m() { body }") {Q}) $

#strong[Consequence] (only in a footnote of the book, but every real proof needs it): glue the triple you *derived* to the one you *want*.

#room(top: 1.5em, bottom: 0.2em)[$
  (markhl(P => P', #<cs>, #cP) quad {P'} med S med {Q'} quad markhl(Q' => Q, #<cw>, #cQ)) / ({P} med S med {Q})
  #annot(<cs>, pos: top, dy: -0.8em)[strengthen the pre]
  #annot(<cw>, pos: top, dy: -0.8em)[weaken the post]
$]

#block(breakable: false, n(supplement: [example], [proof tree for swap --- Ex. 10.2])[
  Abbreviate $P := x = A and y = B$, #h(0.3em) $R_1 := x = A and y = B and t = A$, #h(0.3em) $R_2 := x = B and y = B and t = A$, #h(0.3em) $Q := x = B and y = A$.

  #align(center, infer(
    ${P} #raw("int t = x") {R_1}$,
    infer(${R_1} #raw("x = y") {R_2}$, ${R_2} #raw("y = t") {Q}$, ${R_1} #raw("x = y; y = t") {Q}$),
    ${P} #raw("swap()") {Q}$,
  ))

  Read *bottom-up*: the goal is split by the sequence rule, twice. Each leaf is an assignment axiom, plus consequence: e.g. the axiom gives ${R_2[x := y]} med #raw("x = y") med {R_2}$, and $R_1 => R_2[x := y] = (y = B and y = B and t = A)$. Note that $R_1$ and $R_2$ had to be *guessed*.
])

== Level 3: weakest preconditions --- §10.2

The sequence rule needs an $R$ that someone has to *invent*: no good for a tool. Dijkstra: don't invent it, *compute* it, backwards from $Q$.

#room(top: 1.4em, bottom: 0.3em)[$
  markhl("wp", #<wpn>, #cP) (markhl(S, #<wps>, #cS), markhl(Q, #<wpq>, #cQ))
  #annot(<wpn>, pos: left, dx: -1.5em)[weakest \ precondition]
  #annot(<wps>, pos: top, dy: -0.8em)[statement]
  #annot(<wpq>, pos: right, dx: 1.5em)[postcondition \ to reach]
$]

$"wp"(S, Q)$ describes *exactly* the start states from which $S$ (if it terminates) ends in a $Q$-state. Two properties:
- it *works*: ${"wp"(S, Q)} med S med {Q}$ holds;
- it is the *weakest*: whenever ${P} med S med {Q}$ holds, $P => "wp"(S, Q)$.

#block(sticky: true)[Computed by recursion on $S$, from the back to the front:]

#room(top: 0.2em, bottom: 0.2em)[$
  "wp"(S_1; S_2, Q) & = "wp"(S_1, markhl(#$"wp"(S_2, Q)$, #<w2>, #cR)) \
  "wp"(x := E, Q) & = Q[x := E] \
  "wp"("if" c "then" S_1 "else" S_2, Q) & = markhl(#$(c => "wp"(S_1, Q))$, #<wt>, #cP) \
  & #h(1em) and markhl(#$(not c => "wp"(S_2, Q))$, #<we>, #cP)
  #annot(<w2>, pos: right, dx: 0.8em)[the computed $R$]
  #annot(<wt>, pos: right, dx: 0.8em)[$c$: $S_1$ \ reaches $Q$]
  #annot(<we>, pos: right, dx: 0.8em)[$not c$: $S_2$ \ reaches $Q$]
$]

#block(sticky: true)[To verify a function with `requires P; ensures Q;` and body $B$, prove the *verification condition*:]

#room(top: 1.4em, bottom: 1.4em)[$
  markhl(P, #<vp>, #cP) quad => quad "wp"(markhl(B, #<vb>, #cS), markhl(Q, #<vq>, #cQ))
  #annot(<vp>, pos: top + left, dy: -0.8em)[`requires`]
  #annot(<vb>, pos: bottom + left, dy: 0.6em)[the body]
  #annot(<vq>, pos: top + right, dy: -0.8em)[`ensures`]
$]

No program is left in it: it is a plain first-order formula, which an automated prover (Z3, CVC3, Simplify) can decide. Why it suffices: $"wp"$ gives ${"wp"(B, Q)} med B med {Q}$, and consequence with $P => "wp"(B, Q)$ turns it into ${P} med B med {Q}$.

Pipeline: code + contract $arrow.r$ wp rules $arrow.r$ $P => "wp"(B, Q)$ $arrow.r$ prover $arrow.r$ proved / not proved. Real tools extend the rules to C/Java: side effects, `return`, `break`, exceptions.

#n(supplement: [example], [swap, computed instead of guessed])[
  Start at the bottom with $Q$ and substitute upwards, one assignment at a time:

  #table(
    columns: (auto, 1fr, auto),
    stroke: 0.4pt, inset: 4pt,
    [statement], [predicate before it], [computed as],
    [`int t = x;`], [$y = B and x = A$], [$[t := x]$],
    [`x = y;`], [$y = B and t = A$], [$[x := y]$],
    [`y = t;`], [$x = B and t = A$], [$Q[y := t]$],
    [(end)], [$x = B and y = A$], [$Q$],
  )

  VC: $x = A and y = B => y = B and x = A$ #h(0.3em) ✓. The $R_1, R_2$ the proof tree had to guess are just rows of this table (or weaker).
]

#n(supplement: [example], [conditional])[
  `if (x < 0) y = -x; else y = x;` with $Q = y >= 0$:
  $ "wp" = (x < 0 => -x >= 0) and (not(x < 0) => x >= 0) equiv "true" $
  so it holds under any precondition (with mathematical integers; in C, `-x` must also not overflow, cf. `abs` in Ch. 8).
]

#i[Strictly, Dijkstra's wp also demands termination (total correctness); the partial version is the weakest *liberal* precondition (wlp). For loop-free code they coincide.]

== Level 4: function calls --- §10.3

Verification is *modular*: each function is verified on its own, and a call inside a body is replaced by the callee's *contract*, never by its body (no inlining). The callee's code can change freely as long as it keeps its contract.

#room(top: 1.7em, bottom: 1.6em)[$
  (markhl(P => "Pre"_m (bold(x)), #<cp>, #cP) quad markhl(P and "Post"_m (bold(x)) => Q, #<cq>, #cQ)) / ({P} med m(mark(bold(x), #<cx>, #cS)) med {Q})
  #annot(<cp>, pos: top + left, dy: -0.8em)[caller establishes $m$'s pre]
  #annot(<cq>, pos: top + right, dy: -0.8em)[$m$'s post yields $Q$]
  #annot(<cx>, pos: bottom, dy: 0.6em)[actual arguments, in place of the parameters]
$]

#n(supplement: [example], [`activityBonus` calls `addCredits` --- Ex. 10.3])[
  Case `\old(s->credits) + bonus <= 180` (no cap needed). The call is replaced by the contract of `addCredits` (`requires c >= 0; ensures s->credits == \old(s->credits) + c;`):

  #table(
    columns: (1fr, auto),
    stroke: 0.4pt, inset: 4pt,
    [fact], [source],
    [`0 <= bonus <= 5`], [pre `activityBonus`],
    [`s->active && s->status == bachelor`], [pre `activityBonus`],
    [`\old(s->credits) + bonus <= 180`], [case],
    [`s->credits == \old(s->credits) + bonus`], [post `addCredits`],
    [$=>$ `s->credits == \old(s->credits) + bonus`], [post `activityBonus`],
  )

  Left premise: `c >= 0` for `c = bonus` follows from `0 <= bonus`. ✓
]

== Level 4b: the frame problem --- §10.3

The rule above keeps *all* of $P$ after the call ($P and "Post"_m$). That is only sound if $m$ changes nothing $P$ talks about --- and a plain pre/post contract doesn't say what $m$ changes.

```
class Point {                         // Fig. 10.3
  //@ requires dx >= 0;
  //@ ensures x == \old(x) + dx;
  void moveHorizontal(int dx) { x = x + dx; }
}
class Line {                          // Fig. 10.4
  Point begin, end;
  //@ ensures \result == (begin.getY() == end.getY());
  /*@ pure */ boolean isHorizontal() { ... }

  //@ requires dx >= 0 && isHorizontal();
  //@ ensures isHorizontal();
  void stretchLine(int dx) { end.moveHorizontal(dx); }
}
```

After the call the verifier only knows `end.x == \old(end.x) + dx`. Nothing about `end.y`: `moveHorizontal` *might* have changed it, so `isHorizontal()` can't be proved, although the code is fine. (The book's Fig. 10.3 already contains the fix, `assignable x;`.)

- *frame* = the locations a function may change; *anti-frame* = all the others, which must stay unchanged.
- Fix 1: `ensures y == \old(y);` --- one clause per untouched variable per function, and every new variable means editing every contract. Verbose and error-prone.
- Fix 2: list only what *may* change, `assignable x;` (JML; also `modifiable`, `modifies`) $=$ `assigns x;` (ACSL). Everything else is implicitly unchanged. Syntax: see "Frame --- `assigns`" in Ch. 7.

#block(sticky: true)[With $cal(A)_m$ the assignable set of $m$, the wp rule for a call:]

#room(top: 1.5em, bottom: 2em)[$
  "wp"(x.m(), Q) = markhl("Pre"_m, #<fp>, #cP) and (markhl(forall v in cal(A)_m, #<fa>, #cS) . med markhl("Post"_m => Q, #<fq>, #cQ))
  #annot(<fp>, pos: bottom + left, dy: 0.6em)[(1) must hold \ at the call]
  #annot(<fa>, pos: top, dy: -0.8em)[what $m$ may assign: new, *unknown* values]
  #annot(<fq>, pos: bottom + right, dy: 0.6em)[(2) only $"Post"_m$ \ says what they are]
$]

- The $forall$ *forgets* the assignable locations: the proof must work for *every* value they might have afterwards, as long as $"Post"_m$ holds.
- Locations *outside* $cal(A)_m$ are not quantified: what $Q$ says about them passes back unchanged, so it must already hold before the call.
- Two obligations per call: (1) the code before the call establishes $"Pre"_m$ (i.e. the caller's pre implies $"wp"("code before", "Pre"_m)$); (2) $"Post"_m$ alone, plus untouched facts, gives $Q$.

#n(supplement: [example], [`stretchLine` with the frame])[
  With `assignable x;` we get $cal(A) = {"end.x"}$ and $Q = ("begin.y" = "end.y")$:
  $ "dx" >= 0 and forall "end.x". med ("end.x" = #raw("\\old") ("end.x") + "dx" => "begin.y" = "end.y") $
  `end.y` is not quantified, so $"begin.y" = "end.y"$ comes straight from `requires isHorizontal()`. ✓ #linebreak()
  Without `assignable`, $cal(A)$ = everything: `end.y` is quantified too, and some value breaks $Q$. ✗
]

== Level 5: statement annotations --- §10.4

The wp rules handle assignments, sequences, ifs and calls automatically. Two things need help from the user, written as annotations *inside* the body.

#strong[`//@ assert P;`] --- give an intermediate predicate explicitly, e.g. to guide the prover through complex arithmetic (JavaCard class `Decimal`). It means two things:

#room(top: 0.3em, bottom: 2.2em)[$
  "wp"(#raw("assert P"), Q) = markhl(P, #<ap>, #cP) and markhl((P => Q), #<aq>, #cQ)
  #annot(<ap>, pos: bottom + left, dy: 0.6em)[prove: $P$ holds whenever \ control reaches this point]
  #annot(<aq>, pos: bottom + right, dy: 0.6em)[use: $P$ may be assumed \ by the code after it]
$]

(Logically that is just $P and Q$; the point is that the prover gets $P$ as a stepping stone, like a lemma.)

#strong[Loops.] $"wp"("while" c "do" S, Q)$ would have to know how often the loop runs --- statically unknown. So the user supplies a *loop invariant* $I$, and the verifier replaces the loop by $I$:

#room(top: 2.3em, bottom: 2.3em)[$
  ({markhl(c and I, #<lc>, #cP)} med S med {markhl(I, #<li>, #cI)}) / ({markhl(I, #<lpre>, #cI)} med "while" c "do" S med {markhl(not c and I, #<lpost>, #cQ)})
  #annot(<lc>, pos: top + left, dy: -0.8em)[an iteration starts: \ $c$ true, $I$ holds]
  #annot(<li>, pos: top + right, dy: -0.8em)[$I$ holds again]
  #annot(<lpre>, pos: bottom + left, dy: 0.6em)[holds when the \ loop is reached]
  #annot(<lpost>, pos: bottom + right, dy: 0.6em)[after the loop: \ *all* you know]
$]

$I$ is true before the loop and preserved by every iteration, hence still true when the loop exits --- together with $not c$, since that is why it exited.

#block(sticky: true)[Three proof obligations, for `S1; while (c) S; S2` in a function with pre $P$ and post $Q$ (it is induction on the number of iterations):]

#table(
  columns: (auto, auto, auto),
  stroke: 0.4pt, inset: 4pt,
  [obligation], [formula], [induction],
  [establish: $I$ holds at loop entry], [$P => "wp"(S_1, I)$], [base case],
  [preserve: one iteration keeps $I$], [$c and I => "wp"(S, I)$], [step],
  [use: $I$ gives the post], [$not c and I => "wp"(S_2, Q)$], [conclusion],
)

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [ACSL (before the loop)], [meaning],
  [`loop invariant I;`], [holds before every iteration and after the loop],
  [`loop assigns L;`], [frame of the loop: everything else is unchanged --- no need to put that in $I$],
  [`loop variant V;`], [termination (§10.5); JML: `decreases V;`],
)

#i[A runtime checker just runs the loop as often as that execution needs (it can check $I$ each time, but doesn't need it). A static checker doesn't know the iteration count, so it *abstracts the loop by its invariant*: after the loop it only knows $not c and I$ and that nothing outside `loop assigns` changed. Whatever isn't in $I$ is lost --- the most common reason a proof fails.]

#strong[`\old` inside a loop invariant.] JML: `\old(E)` is the value *before the loop started* (book), not at the previous iteration. ACSL makes you say which: `\at(E, Pre)` (function entry), `\at(E, LoopEntry)` (before the first iteration), `\at(E, LoopCurrent)` (start of the current iteration).

#block(breakable: false, n(supplement: [example], [`thirdPower` --- Fig. 10.5, 10.7, Ex. 10.6])[
  ```
  /*@ requires n >= 0;
      ensures \result == n * n * n;
      assigns \nothing; */
  int thirdPower(int n) {
    int u = 0, v = 1, w = 6, k = 0;
    /*@ loop invariant 0 <= k <= n;
        loop invariant u == k * k * k;
        loop invariant v == 3 * k * k + 3 * k + 1;
        loop invariant w == 6 * (k + 1);
        loop assigns k, u, v, w;
        loop variant n - k; */
    while (k < n) {
      u = u + v; v = v + w; w = w + 6; k = k + 1;
    }
    return u;
  }
  ```
  Computes $n^3$ with additions only. Each invariant pins one variable down as a function of the counter $k$:

  #table(
    columns: (auto, 1fr),
    stroke: 0.4pt, inset: 4pt,
    [invariant], [meaning],
    [$0 <= k <= n$], [range of the counter],
    [$u = k^3$], [the result so far],
    [$v = 3k^2 + 3k + 1 = (k+1)^3 - k^3$], [the next increment of $u$],
    [$w = 6(k + 1)$], [the next increment of $v$],
  )

  - *establish:* $k = 0$ gives $u = 0, v = 1, w = 6$ ✓; $0 <= n$ needs `requires n >= 0`.
  - *preserve:* $u + v = (k+1)^3$, #h(0.3em) $v + w = 3(k+1)^2 + 3(k+1) + 1$, #h(0.3em) $w + 6 = 6(k + 2)$ ✓
  - *use:* $not(k < n) and k <= n => k = n$, so $u = n^3$ ✓. Without $k <= n$ the exit only gives $k >= n$.
])

#n(supplement: [example], [`search` --- Fig. 10.6, 10.7])[
  ```
  /*@ requires \valid(a + (0..length-1));
      requires a != \null && 0 < length;
      assigns a[0..length-1];
      ensures \result == true ==>
        \exists integer i; 0 <= i < length && a[i] == val;
  */
  bool search(int *a, int val, int length) {
    bool found = false;
    int i = 0;
    /*@ loop invariant found ==>
          (\exists integer j; 0 <= j < i && a[j] == val);
        loop invariant 0 <= i <= length;
        loop invariant a != \null;
        loop assigns found, i;
        loop variant length - i; */
    while (i < length && !found) {
      if (a[i] == val) { found = true; }
      i++;
    }
    return found;
  }
  ```
  The standard *array pattern*: (1) a property of the part examined so far, `a[0..i-1]`; (2) the range of the index, `0 <= i <= length` --- almost always needed, never enough on its own. At exit, combining both gives a statement about the array as a whole.

  #i[The book says `found` is true *iff* `val` was seen, but invariant and post only state $=>$. So `return false;` also satisfies this contract: the spec says nothing about the `false` case.]
]

#n(supplement: [example], [counting resources with a ghost --- Fig. 10.8, Ex. 10.7])[
  ```
  //@ ghost int countThings;
  /*@ assigns countThings;
      ensures countThings == \old(countThings) + 1; */
  struct thing *thingInit() {
    //@ ghost countThings = countThings + 1;
    return malloc(sizeof(struct thing));
  }

  /*@ requires p >= 0 && \valid(storage + (0..p-1));
      requires countThings + p <= MAX;
      assigns storage[0..p-1], countThings;
      ensures countThings == \old(countThings) + p; */
  void makeThings(struct thing *storage[], int p) {
    /*@ loop invariant 0 <= i <= p;
        loop invariant countThings ==
                       \at(countThings, Pre) + i;
        loop assigns i, storage[0..p-1], countThings;
        loop variant p - i; */
    for (int i = 0; i < p; i++)
      storage[i] = thingInit();
  }
  ```
  `\at(countThings, Pre)` is the value at function entry; after $i$ iterations, $i$ things were made. To verify it completely, `malloc` needs a contract saying it does not change `countThings` --- otherwise, by the frame rule, the call may change *anything*.
]

== Level 6: termination --- §10.5

Termination is a *liveness* property: no finite run shows that it fails, so runtime checking can't touch it, but static checking can. Straight-line code always terminates; loops need a *variant* $V$. The total-correctness rule for loops is the partial one plus $V$:

#room(top: 2.3em, bottom: 0.3em)[$
  ([c and I and markhl(V = v, #<vv>, #cV)] med S med [I and markhl(V < v, #<vd>, #cV)]) / ([I] med "while" c "do" S med [not c and I])
  #annot(<vv>, pos: top + left, dy: -0.8em)[$v$: logical variable, \ $V$'s value before the body]
  #annot(<vd>, pos: top + right, dy: -0.8em)[strictly smaller \ after the body]
$]

- $[dots]$ = total-correctness triples. For every other statement form the partial and total rules are the same.
- $V$ must be *well-founded*: it can't decrease forever (typically an integer that stays $>= 0$). Decreasing at every iteration, but not forever $arrow.r$ finitely many iterations.
- ACSL `loop variant V;` proves: $V >= 0$ whenever an iteration starts, and every iteration makes it strictly smaller. JML: `decreases V;`.
- Like invariants, variants can't be found automatically in general; some tools suggest them.

#table(
  columns: (auto, auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [loop], [variant], [why it works (Ex. 10.8)],
  [`thirdPower`], [`n - k`], [`k` grows by 1 per iteration; positive while `k < n`],
  [`search`], [`length - i`], [`i++` every iteration; positive while `i < length`],
  [`makeThings`], [`p - i`], [`i++` every iteration; positive while `i < p`],
)

*Further reading* (§10.6): all of this is for *sequential* code. For threads you must also specify that one thread can't disturb another: *concurrent separation logic* (Hoare logic + which part of the heap each code fragment accesses). Tools: VerCors, VeriFast, Viper.

== Summary: annotation $arrow.r$ proof obligation

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt, inset: 4pt,
  [annotation], [what the verifier proves / uses],
  [`requires P` + `ensures Q` #linebreak() on body $B$], [$P => "wp"(B, Q)$],
  [`\old(e)`], [a logical variable fixed at entry],
  [call `m(x)`], [$"Pre"_m$ at the call; afterwards, only $"Post"_m$ is known about $cal(A)_m$],
  [`assigns L`], [callee: writes only $L$ #linebreak() callers: everything else is unchanged],
  [`assert P`], [prove $P$ here, assume it after],
  [`loop invariant I`], [establish, preserve, use],
  [`loop assigns L`], [an iteration writes only $L$],
  [`loop variant V`], [$V >= 0$ at every iteration start, and strictly decreasing],
  [`terminates T`], [total correctness $[P] B [Q]$ when $T$ holds],
)
