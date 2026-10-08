#import "../mono.typ": *
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

= Abstract Specifications --- §8.1, §8.3

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

== Ghost variables (§8.3)

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

Spec-only variables that *extend* the state; declared and updated only through `//@ ghost ...` statements, never seen by the compiler. Uses: count loop iterations or calls, track resources (memory, time), encode a *usage protocol* (a ghost `state` moving fresh $arrow.r$ active $arrow.r$ dead, with `requires state == ...` on each function).

#i[Model vs. ghost: a *model* variable (JML only --- ACSL support is future work) *abstracts* the existing state and changes implicitly with it (via `represents`); a *ghost* variable *adds* state and must be updated explicitly.]

== ACSL vs. JML at a glance

#table(
  columns: (auto, 1fr, 1fr),
  stroke: 0.4pt, inset: 3pt,
  [], [ACSL (C)], [JML (Java)],
  [termination], [`terminates T;` must terminate if `T`], [`diverges D;` may diverge only if `D`],
  [cases], [named: `behavior b:` + `assumes`; `complete`/`disjoint`], [unnamed, joined by `also`; nest with `{| |}`],
  [heavyweight], [---], [`behavior`: must terminate (throwing ok) #linebreak() `normal_behavior`: must return normally #linebreak() `exceptional_behavior`: must throw],
  [in specs], [`logic`/`predicate` only], [`pure` methods, `model` methods],
  [quantifier], [`\forall integer i; R ==> P`], [`(\forall int i; R; P)`, range optional],
  [constants], [`\true`, `\false`, `\null`], [`true`, `false`, `null`; refs *non-null by default* (`nullable`)],
  [frame], [`assigns`], [`assignable`/`modifies`],
  [invariants], [`global`/`type`; weak or `strong`], [`instance invariant`, always weak; `helper` exempt],
  [exceptions], [none in C], [`signals (E e) P;` #linebreak() `signals_only E1, E2;`],
  [extras], [`\at`, `\valid`, `\separated`, `ghost`], [`initially`, `constraint`, `spec_public`, `model` + `represents`, `ghost`],
)
