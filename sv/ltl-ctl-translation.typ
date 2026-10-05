#import "../mono.typ": *
#show: template.with(blue, red, [LTL / CTL Translation Guide])
#show table: it => block(breakable: false, it)

//#align(center,text(fill:red, size:20pt)[! Unlike other PDFs, this is AI generated !\ #text(fill:red, size:12pt)[Natural language $arrow.l.r$ LTL / CTL, based on Ch. 4 of the book. Formulas are in NuSMV syntax (`!` not, `&` and, `|` or, `->` implies). Every "equivalent / differs" claim was checked with NuSMV 2.7.1.]])

= Natural Language $arrow.r$ LTL / CTL

== Step 1 --- Atomic Propositions

Underline the conditions that are true or false in a *single state* and name them: "the light is green" $arrow.r$ `green`, "a request is pending" $arrow.r$ `req`.

- *Events* must become state conditions: "a message is sent" $arrow.r$ "the sender is in its sending state".
- *No time words inside a proposition*: "eventually green" is not a proposition.

== Step 2 --- Time Words $arrow.r$ Temporal Operators

#table(
  columns: (1fr, auto),
  stroke: 0.4pt,
  inset: 4pt,
  [English], [Operator],
  [always, at all times, never (with `!`), invariably], [`G`],
  [whenever X, ...; every time X, ...], [`G (X -> ...)`],
  [eventually, at some point, sooner or later], [`F` (includes *now*)],
  [afterwards, later, strictly after], [`X F`],
  [next, in the next step, immediately after], [`X`],
  [until (and Y must come)], [`U`],
  [until (Y may never come), unless], [weak until: `(p U q) | G p`],
  [infinitely often, again and again], [`G F`],
  [eventually forever, stabilises, from some point on], [`F G`],
  [before, only after, not before], [precedence pattern (catalogue)],
)

== Step 3 --- Path Words $arrow.r$ `A` / `E`

#table(
  columns: (1fr, auto),
  stroke: 0.4pt,
  inset: 4pt,
  [English], [Quantifier],
  [can, possible, there is a way, may, has the option to], [`E` $arrow.r$ *CTL only*],
  [inevitably, necessarily, no matter what, must, on every run], [`A`],
  [nothing said], [all paths (LTL default, `A` in CTL)],
)

== Step 4 --- Decide Which Logic

+ A *possibility* ("can", "possible")? Needs `E` $arrow.r$ *CTL only*.
+ A condition on a *whole execution* ("eventually stays forever" = `F G`; "if X happens infinitely often then ..." = fairness)? $arrow.r$ *LTL only*.
+ Otherwise usually *both*: write the LTL formula, then make the CTL version (Step 7).

== Step 5 --- Build Outside-In

Usual shape: *`G (trigger -> response)`*.

- The outermost operator usually comes from "always", "whenever", "at any time".
- The condition becomes the left side of `->`.
- The inner temporal operator says *when* the response happens.

Use parentheses to fix exactly what each `G` and `->` covers.

== Step 6 --- Choose the Strength

- Response may happen at the same moment? `F`. Strictly later? `X F`.
- "Until" target must actually happen? `U`. If not: weak until.
- Immediate (`X`), eventually (`F`), or within $n$ steps? For $n$ steps, spell it out: `q | X q | X X q`.

== Step 7 --- CTL Rules

- *Every temporal operator directly after an `A` or `E`*: `AG`, `AF`, `EX`, `A[p U q]`, ...
- `&`, `|`, `->` may only join *state formulas* (formulas starting with `A`/`E`, or plain propositions) --- never bare path formulas.

#i[LTL $arrow.r$ CTL by putting `A` before every operator (`G (p -> F q)` $arrow.r$ `AG (p -> AF q)`) only works in simple cases. It *breaks* when:
- the formula contains `F G`: `AF AG p` is *stronger* than `F G p` (§4.9);
- an `|` or `->` sits *between temporal subformulas*: `F p | G q` is not `AF p | AG q`, and fairness-shaped implications have no CTL version at all (pitfall 6).]

== Step 8 --- Check the Answer

- *Quick:* write one execution that should satisfy the property and one that should violate it; test both.
- *LTL, rigorous:* a NuSMV model whose variables can take any value decides equivalence. "true" = equivalent; "false" comes with a trace where they differ:

```
MODULE main
VAR p : boolean; q : boolean;
LTLSPEC G (p -> F q) <-> G (p -> X F q)
-- false: they differ
```

- *CTL:* that trick doesn't work (CTL depends on branching). Build a tiny model with 2--3 states and a branch instead (see pitfalls 5 and 6).

= Pattern Catalogue

== Both LTL and CTL

#table(
  columns: (1fr, auto, auto),
  stroke: 0.4pt,
  inset: 4pt,
  [English], [LTL], [CTL],
  [p always holds], [`G p`], [`AG p`],
  [p never happens], [`G !p`], [`AG !p`],
  [never both p and q], [`G !(p & q)`], [`AG !(p & q)`],
  [while p, q holds], [`G (p -> q)`], [`AG (p -> q)`],
  [p eventually holds], [`F p`], [`AF p`],
  [whenever p, eventually q], [`G (p -> F q)`], [`AG (p -> AF q)`],
  [whenever p, q strictly afterwards], [`G (p -> X F q)`], [`AG (p -> AX AF q)`],
  [whenever p, q in the next step], [`G (p -> X q)`], [`AG (p -> AX q)`],
  [p infinitely often], [`G F p`], [`AG AF p`],
  [once p, always p], [`G (p -> G p)`], [`AG (p -> AG p)`],
  [p until q, q must come], [`p U q`], [`A[p U q]`],
)

#table(
  columns: (1fr, 1fr),
  stroke: 0.4pt,
  inset: 4pt,
  [English], [LTL / CTL],
  [q within 2 steps of p], [`G (p -> (q | X q | X X q))` \ `AG (p -> (q | AX q | AX AX q))`],
  [p until q, or p forever (weak until)], [`(p U q) | G p` \ `!E[!q U (!p & !q)]`],
  [q only after p (precedence)], [`(!q U p) | G !q` \ `!E[!p U (q & !p)]`],
)

== CTL Only

#table(
  columns: (1fr, auto),
  stroke: 0.4pt,
  inset: 4pt,
  [English], [CTL],
  [it is possible to reach p], [`EF p`],
  [from anywhere, p can be reached again], [`AG EF p`],
  [whenever p, it's possible to get q], [`AG (p -> EF q)`],
  [at any time, a can happen next], [`AG EX a`],
  [some execution keeps p forever], [`EG p`],
  [possible to reach a point after which p always holds], [`EF AG p`],
)

== LTL Only

#table(
  columns: (1fr, auto),
  stroke: 0.4pt,
  inset: 4pt,
  [English], [LTL],
  [p eventually holds forever], [`F G p`],
  [if a infinitely often, then eventually b], [`G F a -> F b`],
  [if a infinitely often, then b infinitely often], [`G F a -> G F b`],
)

= Pitfalls (All Tested)

+ *Missing the outer `G`.* `p -> F q` is only checked in the initial state; not equivalent to `G (p -> F q)`.
+ *`F` includes the present.* `G (p -> F q)` is satisfied if `q` holds at the same moment as `p`, so it differs from `G (p -> X F q)`. Use `X F` for "after".
+ *`U` is strong.* `p U q` requires `q` to happen; English "until" is often weak. `p U q` differs from `(p U q) | G p`. Also, `p U q` doesn't require `p` at the moment `q` becomes true.
+ *`G F` vs. `F G`.* "Infinitely often" and "eventually forever" are not equivalent.
+ *CTL scope.* `(AG p) -> EF q` is not `AG (p -> EF q)`: the first is checked only in the initial state and is trivially true whenever `p` isn't always true. On a test model with a p-state that can never reach `q`: first *true*, second *false*.
+ *Boolean operators between path formulas in CTL.*
  - Model branching into a p-branch and a q-branch: LTL `F p | G q` *true*, CTL `AF p | AG q` *false*. In LTL each path may satisfy a different side of the `|`; in CTL one side must hold on *all* paths.
  - Model with a branch that sends forever without receiving and a branch that never sends: LTL `(G F send) -> F receive` *false*, CTL `(AG AF send) -> AF receive` *true* (trivially satisfied once any branch stops sending).
  - Fairness conditions like this are *not CTL-expressible* (§4.8).
+ *Implications can be trivially true.* `G (p -> ...)` holds if `p` never happens. When it matters, add a check like `EF p`.
+ *"May" means different things.* In a *property*, "may"/"can" $arrow.r$ `E` (CTL). In a *model description*, "may" $arrow.r$ non-determinism (`{a, b}`), not a property.
+ *No weak until in NuSMV.* Write `(p U q) | G p`.

= LTL / CTL $arrow.r$ Natural Language

== Step 1 --- Classify

- Contains `A` or `E`? $arrow.r$ CTL: read each quantifier explicitly.
- No quantifiers? $arrow.r$ LTL: start with "on every execution ..." (usually left implicit).

== Step 2 --- Parse Outside-In

Find the outermost operator, then what each `G`, `F`, `->`, `U` covers --- use the parentheses, or draw the syntax tree.

== Step 3 --- Replace Known Operator Pairs

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt,
  inset: 4pt,
  [Formula], [Reading],
  [`G F p` / `AG AF p`], [p happens infinitely often],
  [`F G p`], [p eventually holds forever],
  [`G (p -> F q)`], [every p is eventually followed by q],
  [`AG EF p`], [p can always be reached again (reset always possible)],
  [`EF AG p`], [you *can* reach a point after which p holds whatever happens],
  [`AF AG p`], [you *inevitably* reach a point after which p holds whatever happens],
  [`AF EG p`], [you inevitably reach a point from which *some* continuation keeps p forever],
  [`EG p`], [there is an execution on which p always holds],
  [`A[p U q]`], [on every execution, p holds until q, and q does happen],
  [`AG (p -> AX q)`], [whenever p, every next state has q],
)

== Step 4 --- Read Each Operator

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt,
  inset: 4pt,
  [Operator], [Reading],
  [`G`], [at every moment / always],
  [`->` under a `G`], [whenever ... then ...],
  [`F`], [eventually (now or later)],
  [`X`], [in the next step],
  [`U`], [... holds until ..., which must happen],
  [`A`], [no matter how the system continues],
  [`E`], [the system can continue in such a way that],
)

== Step 5 --- Rewrite as One Sentence

Natural, but keep the meaning exact:
- eventually (`F`) vs. next (`X`)
- inevitably (`A`) vs. possibly (`E`)
- "until it must happen" (`U`) vs. "until, if ever" (weak until)

== Step 6 --- Check the Sentence

Think of a trace (or for CTL, a small tree) that satisfies your sentence; check it against the formula. Repeat with a violating one.

== Examples

#table(
  columns: (auto, 1fr),
  stroke: 0.4pt,
  inset: 4pt,
  [Formula], [Sentence],
  [`AG (req -> A[req U grant])`], [Once a request is made, it stays pending until it is granted, and it will be granted however the system continues.],
  [`G (p -> X (!p U q))`], [Every time p happens, p does not happen again until q has happened, and q must happen.],
  [`EF AG p`], [The system can reach a point after which p holds forever, whatever happens next.],
  [`AG (open -> EF closed)`], [Whenever the door is open, it is *possible* to close it. ("Possible" $arrow.r$ `E`, so no LTL version.)],
)

= Applied: `ex/2.typ`

- *CTL \#3* `(A G p => (E F q and E F r))` is the scope mistake (pitfall 5). Should be `AG (p -> (EF q & EF r))`.
- *CTL \#6* `A G A F "send" => A F "receive"` is the fairness shape (pitfall 6) --- not expressible in CTL. Expected answer is probably "LTL only: `G F send -> F receive`".
- *Meaning, 2nd bullet* has two sentences. If they are two separate formulas, the second is `EF EG p`.
