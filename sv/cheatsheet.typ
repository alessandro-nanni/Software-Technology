#import "../mono.typ": *

//#align(center,text(fill:red, size:20pt)[! Unlike other PDFs, this is AI generated !\ #text(fill:red, size:12pt)[Exam cheat sheet for Ch. 6 (runtime monitoring, CIVL) and Ch. 7--10 (ACSL only), condensed from notes.typ, book.pdf, the CIVL manual (v1.21) and Assignment 2.]])

// Denser than mono.typ's template: 3 columns, small type, no outline.
#set page(paper: "a4", flipped: true, columns: 3, margin: 0.8cm, numbering: "1")
#set columns(gutter: 0.45cm)
#set text(size: 7.5pt, overhang: false, ligatures: false)
#set par(justify: true, leading: 0.45em, spacing: 0.65em)
#set heading(numbering: "1.1")
#show heading: set block(above: 0.9em, below: 0.5em)
#show heading.where(level: 1): set text(size: 9.5pt, fill: blue.darken(25%))
#show heading.where(level: 2): set text(size: 8pt)
#set list(spacing: 0.5em, indent: 0.2em)
#set enum(spacing: 0.5em, indent: 0.2em)
#set table(stroke: 0.4pt, inset: 2.5pt)
#show table.cell.where(y: 0): strong
#show raw: set text(size: 6.9pt)
#show raw.where(block: false): highlight.with(fill: red.lighten(85%), radius: 2pt, top-edge: 1em)
#show raw.where(block: true): it => block(
  breakable: false,
  width: 100%,
  stroke: 0.5pt + red.desaturate(50%),
  radius: 2pt,
  inset: 3pt,
  fill: red.desaturate(50%).transparentize(70%),
  it,
)
#show link: it => underline(text(fill: blue, it))
// Short tables stay in one piece; long ones may break across columns.
#show table: it => block(
  breakable: it.children.len() > 36 or (it.has("label") and it.label == <brk>),
  it,
)

// Examples and recipes stay in one piece.
#let ex(title, body) = block(breakable: false, n(supplement: [example], title, body))
#let howto(title, body) = block(breakable: false, n(supplement: [how to], title, body))

#place(top + center, scope: "parent", float: true, clearance: 0.8em, text(size: 13pt, weight: "bold")[
  System Validation --- Cheat Sheet: LTL/CTL, Ch. 6 (NuSMV Encoding, Monitoring, CIVL) \& Ch. 7--10 (ACSL)
])

= Which Technique?

#table(
  columns: (auto, 1fr, 1fr),
  [technique], [checks], [guarantee],
  [model checking #linebreak() Ch. 3--5, NuSMV], [LTL / CTL properties of a *finite abstract model*], [every execution of the *model* --- not of the code],
  [runtime monitoring #linebreak() §6.2, LarVa], [temporal *safety* property as an automaton over events of the running program], [only the runs you execute; can log or stop the program],
  [runtime annotation checking #linebreak() Ch. 9, E-ACSL], [contracts, asserts, invariants on executed calls], [only executed runs; no termination],
  [bounded symbolic execution #linebreak() §6.4, CIVL], [`$assert`s + default errors for *all inputs within bounds*], [every path inside the bounds, none outside],
  [static checking #linebreak() Ch. 10, Frama-C WP], [contracts for all inputs and paths], [proof (partial, or total with variants)],
)

#i[*Dynamic* (monitoring, RAC): easy, little expertise, works in an *unknown environment*, but sees only one execution. *Bounded*: all executions up to a bound, finds bugs, proves nothing beyond the bound. *Static*: full proof, but needs environment assumptions, loop invariants and expertise.]

== Model + LTL/CTL, or ACSL contract?

The book's split: a *model* + temporal logic (Ch. 3--5) checks *global* properties of an abstract *design* --- how the system may execute over time. A *contract* (Ch. 7) specifies the *detailed* behaviour of one function or class, with complex data and *unbounded* state spaces. They combine: global properties on the model, local contracts on the code.

#table(
  columns: (1.3fr, 1fr),
  [the requirement talks about ...], [choose],
  [order of events / phases across the system: "after", "before", "only after", "never again", "until"], [model + LTL (or CTL)],
  ["eventually", "always responds", "infinitely often"; fairness], [LTL (`G F`, `F G`, `G F a -> F b`)],
  ["it is *possible* to", "can always be reset", "may choose"], [CTL (`E`): branching],
  [interleaving of components, deadlock, mutual exclusion], [model (modules); on code: CIVL],
  [what one function needs and returns: result, array contents, "sorted", "the maximum", overflow], [ACSL `requires` / `ensures`],
  [what a function may (not) change], [ACSL `assigns`],
  [input cases of one function ("for a bachelor student ...")], [ACSL `behavior` + `assumes`],
  [data consistency that always holds (`credits >= 0`)], [ACSL `global`/`type invariant` #linebreak() (model: `G p` / `AG p`)],
  [allowed call order of an API (init before use)], [ACSL ghost state + `requires`; #linebreak() model: LTL; runtime: LarVa],
  [unbounded data (lists, trees, any `int`)], [ACSL: NuSMV needs every variable *bounded*],
  ["within 5 seconds"], [LarVa clocks (model: `q | X q | X X q` counts *steps*)],
) <brk>

#table(
  columns: (auto, 1fr, 1fr),
  [word], [in a model (NuSMV + LTL/CTL)], [in ACSL],
  [action / event], [a transition (`next`, `TRANS`); a free choice = non-determinism `{a, b}`], [a function call: `requires` = when allowed, `ensures` + `assigns` = effect],
  [behaviour], [the paths of the model: LTL = every path, CTL = the tree], [`behavior b: assumes A;` = one *input case* of one call --- *not* temporal],
  [state], [values of all (bounded) variables + `pc`], [memory at a point: `Pre`, `Post`, `Here`, ...],
  [invariant], [`G p` / `AG p`: every reachable state], [global/type: at call boundaries; loop invariant: every iteration],
  ["may"], [model text: non-determinism; property: `E`], ["may be called" $arrow.r$ `requires`; "may change" $arrow.r$ `assigns`],
  [guarantee], [push-button, every run *of the model* (code may differ, §6.1)], [proof for the *code* (WP), needs invariants; or RAC on runs],
)

#howto([choose and justify (exam)])[
  + Is there *code* (a C function) or only a *system description*? Design $arrow.r$ model; implementation $arrow.r$ contract (or CIVL / RAC on the code).
  + *Global* (several components, a whole run) or *local* (one call)?
  + *Temporal* (relates different moments: ordering, "eventually") or *functional* (input $arrow.r$ output of one call)?
  + *Finite* / easily bounded data, or unbounded structures?
  + Answer: formalism + construct + one-line reason + what the other one *can't* express.
]

#ex([one informal spec, three formalisms])[
  #table(
    columns: (1fr, 1.5fr),
    [requirement], [best fit],
    [a grade is registered only after the student enrolled], [LTL `(!graded U enrolled) | G !graded`; #linebreak() code: `requires enrolled(s, c);` on `addGrade`],
    [credits are never negative], [ACSL `type invariant`; model: `G credits >= 0`],
    [`addCredits(s, c)` adds exactly `c`], [ACSL `ensures s->credits == \old(s->credits) + c;`],
    [every request is eventually granted], [LTL `G (req -> F grant)`; no contract equivalent],
    [from every state, a reset is possible], [CTL `AG EF reset`; neither LTL nor ACSL],
  )
]

= LTL and CTL --- Ch. 4

Kripke structure $K = (S, I, arrow.r, lambda)$: finite states, initial states $I eq.not emptyset$, $arrow.r$ *left-total* (every path infinite), $lambda(s)$ = propositions true in $s$. $K$ satisfies $phi$ iff every initial state does.

#table(
  columns: (auto, 1fr),
  [kind], [test],
  [*safety* "nothing bad"], [violation shown by a *finite* prefix (incl. deadlock, bounded liveness "within 3 steps")],
  [*liveness* "something good eventually"], [violation needs an *infinite* path where it never happens],
)

== LTL (one path at a time; implicitly *all* paths)

#table(
  columns: (auto, 1fr),
  [op], [meaning (NuSMV `LTLSPEC`)],
  [`G p`], [at every position from now],
  [`F p`], [at some position from now (*now included*)],
  [`X p`], [at the next position],
  [`p U q`], [`q` *must* come; `p` at every position before it],
  [`p W q`], [weak until: `(p U q) | G p` (*no `W` in NuSMV*)],
)

$G phi equiv not F not phi$, #h(0.3em) $F phi equiv "true" U phi$, #h(0.3em) $phi U psi equiv F psi and (phi W psi)$. #h(0.3em) $X$ commutes with $F, G, U$; $G F p$ (infinitely often) $eq.not$ $F G p$ (eventually forever), $F G p => G F p$.

#table(
  columns: (auto, 1fr),
  [given `p` at $i$], [when must `q` hold? (strongest first)],
  [`G (p -> q)`], [at $i$ itself],
  [`G (p -> X q)`], [exactly at $i + 1$],
  [`G (p -> X F q)`], [somewhere after $i$ (strictly)],
  [`G (p -> F q)`], [at $i$ or later],
)

== CTL (branching; NuSMV `SPEC`)

Every temporal operator *directly* after `A` (all paths) or `E` (some path): `AG AF AX A[p U q]`, `EG EF EX E[p U q]`. `& | ->` only between *state* formulas. Duals: `AG p = !EF !p`, `AF p = !EG !p`, `AX p = !EX !p`. Core set: `EX`, `EU`, `AF`.

#table(
  columns: (1fr, auto, auto),
  [English], [LTL], [CTL],
  [`p` always / never], [`G p` / `G !p`], [`AG p` / `AG !p`],
  [while `p`, `q`], [`G (p -> q)`], [`AG (p -> q)`],
  [`p` eventually], [`F p`], [`AF p`],
  [whenever `p`, eventually `q`], [`G (p -> F q)`], [`AG (p -> AF q)`],
  [whenever `p`, `q` next], [`G (p -> X q)`], [`AG (p -> AX q)`],
  [`p` infinitely often], [`G F p`], [`AG AF p`],
  [once `p`, always `p`], [`G (p -> G p)`], [`AG (p -> AG p)`],
  [`p` until `q` (must come)], [`p U q`], [`A[p U q]`],
  [`q` within 2 steps of `p`], [`G (p -> (q | X q | X X q))`], [same with `AX`],
  [`q` only after `p`], [`(!q U p) | G !q`], [`!E[!p U (q & !p)]`],
)

#table(
  columns: (1fr, auto),
  [CTL only (needs `E`)], [LTL only (no CTL equivalent)],
  [`EF p` can reach `p`; #linebreak() `AG EF p` can always get back to `p`; #linebreak() `AG (p -> EF q)`; `AG EX a`; `EG p`], [`F G p` eventually forever (`AF AG p` is stronger); #linebreak() `G F a -> F b`, `G F a -> G F b` (fairness-shaped)],
)

#i[*Pitfalls*: (1) no outer `G`: `p -> F q` only constrains the *initial* state. (2) `F` includes now; "afterwards" = `X F`. (3) `U` is strong; English "until" is often weak. (4) `(AG p) -> EF q` $eq.not$ `AG (p -> EF q)`. (5) `F p | G q` (LTL, per path) $eq.not$ `AF p | AG q` (CTL). (6) `G (p -> ...)` is vacuously true if `p` never happens: check `EF p` too. (7) "may" in a *model* = non-determinism; in a *property* = `E`.]

*Fairness*: `FAIRNESS p` / `JUSTICE p` keeps only paths where `p` holds infinitely often (weak); `COMPASSION (p, q)`: if `p` infinitely often then `q` infinitely often (strong). It changes the *semantics* of `A`/`E`; not expressible as a CTL formula, in LTL as `G F p -> phi`.

*Which logic?* Needs "possible" $arrow.r$ CTL. Stabilisation / fairness shape / checked on one observed run (monitoring) / Spin $arrow.r$ LTL. Both possible $arrow.r$ either (CTL checking is linear in $|K| dot |phi|$, LTL exponential in $|phi|$).

= Encoding a Program in NuSMV --- §6.1

#howto([program $arrow.r$ NuSMV model (§6.1.1)])[
  + *Label* every instruction `l0`, `l1`, ... (label = "about to execute this"), plus one label for "terminated".
  + `pc : {l0, ..., ln};` with `init(pc) := l0;` --- the labels are the control states.
  + Every program variable $arrow.r$ a `VAR` with a *bounded* type matching its domain (`byte` $arrow.r$ `-128..127`, or a smaller range). Leave its `init` free: before its declaration runs, its value is unknown.
  + `next(pc)`: in a sequence, go to the next label. At a `while (c)` / `if (c)` label `l`, use two cases: `pc = l & c : <first body label>;` and `pc = l : <label after it>;`. The end of a loop body jumps back to the test label; the final label loops to itself (keeps $arrow.r$ left-total).
  + `next(v)`: one case per label that assigns `v` (`pc = l : E;`), else `TRUE : v;`. *Guard* expressions that could leave the range (`pc = l3 & x > 0 : x - 1`): NuSMV checks *all* states, not just reachable ones, and aborts with `cannot assign value -1 to variable x`.
  + Properties: termination `AF pc = l5`; post `G (pc = l5 -> Q)`; loop invariant *at the test label* `G (pc = l2 -> I)`. A plain `G I` fails on the uninitialised start values.
]

#block(breakable: false)[
```
/* l0 */ x = 5;
/* l1 */ y = 0;
/* l2 */ while (x > 0) {
/* l3 */   x = x - 1;
/* l4 */   y = y + 2;
         }
/* l5 */
```

```
MODULE main
VAR
  pc : {l0, l1, l2, l3, l4, l5};
  x  : 0..5;
  y  : 0..10;
ASSIGN
  init(pc) := l0;
  next(pc) := case
      pc = l0         : l1;
      pc = l1         : l2;
      pc = l2 & x > 0 : l3;
      pc = l2         : l5;      -- loop exit
      pc = l3         : l4;
      pc = l4         : l2;      -- back to the test
      TRUE            : l5;      -- l5 loops forever
    esac;
  next(x) := case
      pc = l0         : 5;
      pc = l3 & x > 0 : x - 1;   -- guard keeps 0..5
      TRUE            : x;
    esac;
  next(y) := case
      pc = l1          : 0;
      pc = l4 & y <= 8 : y + 2;  -- guard keeps 0..10
      TRUE             : y;
    esac;
SPEC    AF pc = l5                        -- true
LTLSPEC G (pc = l5 -> y = 10)             -- true
LTLSPEC G (pc = l2 -> y = 2 * (5 - x))    -- true
LTLSPEC G (y = 2 * (5 - x))               -- false
```
]

The last one fails in the very first state (`x`, `y` still arbitrary) and also at `l4` (`x` already decremented, `y` not yet incremented). Checked with NuSMV 2.7.1.

*Challenges* (§6.1.2): exceptions (a branch per instruction that may throw); threads (one transition = one *atomic* step); calls (jump to the callee and back, late binding); scopes; floats, objects, overflow. The model explodes $arrow.r$ hence monitoring, bounded analysis (CBMC, CIVL), abstraction (CEGAR) and test generation.

= Runtime Monitoring --- §6.2

A *monitor* runs next to the program and tracks its *abstract state* with an automaton. Program *events* (call, return, ...) make it take transitions; reaching a *bad state* (or being unable to move, depending on the model) = violation. Then it either *logs* the trace for later analysis, or *interrupts* the program before the violation takes effect (security monitoring).

Typical properties: at most one file open at a time; every send preceded by a read; protected data only for authorised users; an SMS only after asking authorisation; 3 wrong PINs in a row block the card.

- *Safety only* (something bad never happens). Liveness can't be refuted on a finite run; only *bounded* liveness ("within 5 s"), via clocks.
- *Non-intrusive*: the program drives the monitor, never the other way; low overhead. So guards and actions must be *side-effect free* on the program state.
- Pros: unknown environment, easy, no proof effort, finds many bugs; can also *enforce* control (block an elevator after the maintenance limit). Con: no correctness guarantee.
- Two uses: (1) encode the *model* itself as a monitor and check conformance; (2) encode only its *safety properties* (enough only if they characterise the model).

== LarVa (Java)

The LarVa compiler turns the `.lrv` spec into a monitor and AspectJ *weaves* event-sending code into the program at every relevant call / return. The monitor runs in parallel and logs every event (trace file `output_XXX.txt` in `bin/`).

```
javac -d bin/ src/pkg/*.java              # program
java -jar larva.jar Spec.lrv -o ./bin     # monitor
ajc ... ; aj5 -cp ./bin pkg.Main          # weave, run
```

#table(
  columns: (auto, 1fr),
  [part], [meaning],
  [`STARTING { s }`], [initial state: *exactly one*],
  [`NORMAL { s }`], [other acceptable states],
  [`BAD { s }`], [must never be reached (drawn as hexagons)],
  [`s { System.out.println(..); }`], [optional code run on entering `s` (logging)],
  [`VARIABLES { int n = 0; }`], [monitor-only variables, Java syntax; also `Clock`, `Channel`],
  [`FOREACH (C x) { ... }`], [one monitor *per instance* of `C`],
  [`*.m()`], [the call `m()` on *any* object: one global monitor],
)

#table(
  columns: (auto, 1fr),
  [event], [fires],
  [`m()`], [when `m` is called],
  [`m().uponReturning()`], [just after `m` returns normally],
  [`m().uponThrowing(ex)`], [just after `m` throws `ex`],
  [`m().uponHandling(ex)`], [on entry of the `catch` block for `ex`],
  [`{c@5}`], [clock `c` reaches 5 s (since its last `c.reset()`)],
  [`{d.receive(from)}`], [message on channel `d`; *send* is an action: `d.send("..");`],
)

#table(
  columns: (auto, 1fr),
  [transition `s -> t [...]`], [meaning],
  [`[e\g\a;]`], [on event `e`, if guard `g` holds, do action `a`],
  [`[e\\a;]`], [no guard],
  [`[e\g]`], [no action],
  [`[e]`], [neither],
)

#i[Transitions are tried *in order*; the first enabled one fires, so a guarded transition must come *before* the unguarded catch-all for the same event. An event with no enabled transition leaves the state unchanged. Actions use Java syntax and end in `;`; guards and actions may *read* program variables.]

#block(sticky: true)[*Skeleton* (format of the assignment):]

```
IMPORTS { import gradeAdministration.*; }
GLOBAL {
  VARIABLES { int count = 0; }
  EVENTS {
    graded(Course course, int grade) =
      {Course c.addGrade(Student s, int g)}
      where {course = c; grade = g;}
  }
  PROPERTY validGrade {
    STATES {
      BAD      { invalid }
      STARTING { start }
    }
    TRANSITIONS {
      start -> invalid [graded\grade < 1 || grade > 10\
        System.out.println("VIOLATION " + grade);]
    }
  }
}
```

`where` binds the event's parameters to the values of the intercepted call (target object, arguments).

== Recipe: English $arrow.r$ monitor

+ *Events*: which method calls / returns can change the property's truth? Name each in `EVENTS`, binding the data you need.
+ *States*: one per phase of the property (closed / open, idle / waiting); the violation becomes a `BAD` state.
+ *Monitor variables* for counts and remembered values (e.g. a `HashSet` of IDs seen so far).
+ *Scope*: per object $arrow.r$ `FOREACH (C x)`; system-wide $arrow.r$ `GLOBAL` with `*.m()`.
+ *Transitions*: guarded / bad ones first, catch-alls last; update counters in actions; add `println` to actions to debug.
+ Run a scenario that *should* violate it; read the trace: which events led into the `BAD` state.

#ex([at most one file open --- global])[
  ```
  EVENTS { open() = {*.open()}  close() = {*.close()} }
  PROPERTY oneFile {
    STATES { BAD { twoOpen } NORMAL { opened }
             STARTING { closed } }
    TRANSITIONS {
      closed -> opened  [open]
      opened -> twoOpen [open]
      opened -> closed  [close]
    }
  }
  ```
]

#ex([never more than 6 users per bank --- Fig. 6.6/6.7])[
  ```
  FOREACH (Bank b) {
    VARIABLES { int users = 0; }
    EVENTS {
      add() = {Bank b1.addUser()} where {b = b1;}
      del() = {Bank b1.deleteUser()} where {b = b1;}
    }
    PROPERTY max6 {
      STATES { BAD { tooMany  badDelete }
               NORMAL { ok }  STARTING { start } }
      TRANSITIONS {
        start -> ok        [add\\users++;]
        start -> badDelete [del]
        ok -> tooMany [add\users >= 6]    // before ok->ok!
        ok -> ok      [add\\users++;]
        ok -> start   [del\users == 1\users--;]
        ok -> ok      [del\\users--;]
      }
    }
  }
  ```
  The book binds with `{b1.addUser() where b = b1}`. Its text version guards with `userCnt > 6` (lets a 7th user in); the picture has `> 5`.
]

#ex([response within 5 s --- clocks (Fig. 6.8)])[
  ```
  VARIABLES { Clock c = new Clock(); }
  EVENTS { req()  = {*.startUpdate()}
           resp() = {*.askNextCommand()}
           late() = {c@5} }
  PROPERTY within5 {
    STATES { BAD { tooSlow } NORMAL { waiting }
             STARTING { idle } }
    TRANSITIONS {
      idle    -> waiting [req\\c.reset();]
      waiting -> idle    [resp]
      waiting -> tooSlow [late]
    }
  }
  ```
  Reset the clock when the wait *starts*; a `c@5` event in `idle` matches nothing and is ignored. Elapsed time in a guard: `c.compareTo(1) >= 0`.
]

== Temporal safety formula $arrow.r$ automaton (§6.2.3)

#block(breakable: false)[
The event is "after *any* method" (`all`); guards test the formula's state predicates.

#table(
  columns: (auto, auto, auto, auto),
  [formula], [from], [guard], [to],
  table.cell(rowspan: 2)[$G phi$], [start, ok], [$phi$], [ok],
  [start, ok], [$not phi$], [*fail* (BAD)],
  table.cell(rowspan: 3)[$phi W psi$], [start, $phi$-holds], [$psi$], [$psi$-holds (then `all` loop)],
  [start, $phi$-holds], [$phi$], [$phi$-holds],
  [start, $phi$-holds], [$not phi and not psi$], [*bad*],
)
]

Other safety patterns by instantiation: "never $p$" $= G not p$; "$q$ only after $p$" (precedence) $= not q W p$; "while $p$, never $q$" $= G(p -> not q)$. Anything more complex: build the automaton by hand from these.

== Monitoring with ghost annotations --- §9.5

Same automaton, but *woven into the code* as ACSL and checked by E-ACSL (and also *statically*, Ch. 10 --- drop runtime checks wherever the proof succeeds):

+ ghost constants for the states, incl. the bad one;
+ a ghost variable for the current state (+ counters);
+ `global invariant`: the *allowed* states only (bad state left out $arrow.r$ reaching it violates the invariant);
+ per function: `requires` = states it may be called in, `ensures` = the transition;
+ ghost assignments in the bodies = the events.

```
//@ ghost int st = 0;        // 0 closed, 1 open, 2 bad
//@ global invariant okSt: st == 0 || st == 1;

/*@ requires st == 0;  ensures st == 1; */
void open(void) {
  ...
  //@ ghost st = 1;
}
/*@ requires st == 1;  ensures st == 0; */
void close(void) {
  ...
  //@ ghost st = 0;
}
```

LarVa: separate automaton, code untouched, Java. Ghost encoding: one place with the other contracts, provable statically.

= Bounded Symbolic Execution --- §6.4 (CIVL)

== Symbolic execution

Run the program on *symbols* instead of values: every `$input` gets a symbolic constant ($X$, $Y$, ...). A symbolic state = symbolic values of the variables + the *path condition* $"pc"$ (how this path was reached).

- At a branch on $c$: if $"pc" => c$ (or $"pc" => not c$) follow one side; otherwise *fork*: $"pc" and c$ / $"pc" and not c$. Paths with an unsatisfiable $"pc"$ are pruned (SMT provers: CVC4, Z3).
- `$assert(e)` fails iff $"pc" and not e$ is satisfiable on some path; the model gives concrete input values.
- One symbolic path = *all* concrete runs that satisfy its $"pc"$.

#ex([conditional swap --- Ex. 6.6])[
  `if (x > y) { t = x; x = y; y = t; }` from $(X, Y)$:
  #table(
    columns: (auto, auto),
    [path condition], [final $(x, y)$],
    [$X > Y$], [$(X', Y')$ with $X' = Y and Y' = X$],
    [$not (X > Y)$], [$(X, Y)$],
  )
  Both final states satisfy $x <= y$, so `$assert(x <= y)` holds for *all* inputs.
]

== Why *bounded*

A loop whose guard depends on a symbol never stops forking: `while (i < e)` gives $I < E$ / $not(I < E)$ in every iteration $arrow.r$ infinite tree (Ex. 6.7, `exponent`). Bound it:

```
$input int e = 24;                 // one concrete value
$input int e;  $assume(23 <= e && e < 46);   // a range
civl verify -inpute=24 exp.c       // value on command line
```

#i[The verdict only holds *within the bounds*. In `exponent` (`r = r * n`, `e` times), `$assert(x >= 0)` fails; the trace shows `n < 0`. With `$assume(n >= 0)` it is verified --- for the bounded `e` only.]

Bounded model checking (CBMC, §6.3) bounds the *path length* (loop unwindings) and asks a SAT solver; CIVL bounds the *input values* and explores symbolically. Both: bug finding, no full proof.

#ex([dining philosophers --- Ex. 6.8])[
  ```
  $input int B = 4;   // upper bound
  $input int n;       // number of philosophers
  $assume(2 <= n && n <= B);
  _Bool forks[n];     // $true = on the table
  void dine(int id) {
    int l = id, r = (id + 1) % n;
    while (1) {
      $when (forks[l]) forks[l] = $false;
      $when (forks[r]) forks[r] = $false;
      forks[r] = $true; forks[l] = $true;
    }
  }
  void main() {
    $for (int i : 0 .. n-1) forks[i] = $true;
    $parfor (int i : 0 .. n-1) dine(i);
  }
  ```
  CIVL explores every interleaving for every $n in [2, 4]$ and reports a *deadlock* (all hold their left fork) with a trace. Without the `$assume`, the analysis does not terminate.
]

== CIVL-C constructs (`#include <civlc.cvh>`)

#table(
  columns: (auto, 1fr),
  [construct], [meaning],
  [`$input int n;`], [input (file scope): symbolic, any value of its type],
  [`$input int n = 5;`], [default value; overridable with #box[`-inputn=7`]],
  [`$input int a[n];`], [input array of symbolic length and contents],
  [`$output int r;`], [output, for `civl compare` (equivalence)],
  [`$assume(e);`], [only keep executions where `e` holds; never reported],
  [`$assert(e);`], [*check* `e` on every path; `$assert(e, "x=%d", x)` adds a message],
  [`p => q`], [implication, $equiv$ `!p || q` (parenthesise both sides)],
  [`$forall (int i : 0 .. n-1) e`], [for all `i` in the range],
  [`$forall (int i, j | R) e`], [for all `i`, `j` satisfying restriction `R`],
  [`$exists (...) e`], [same syntax, existential],
  [`lo .. hi`, `lo .. hi # s`], [range `lo`, ..., `hi` (empty if `lo > hi`), with step `s`],
  [`$true`, `$false`, `_Bool`], [Booleans],
  [`$choose_int(n)`], [nondeterministic int in $[0, n-1]$ --- *all* are explored],
  [`$choose { s1 s2 default: s3 }`], [run one *enabled* branch nondeterministically],
  [`$when (g) s;`], [guarded: blocks until `g`; `s` atomic with the test],
  [`$for (int i : 0 .. n-1) s`], [loop over a range],
  [`$parfor (int i : 0 .. n-1) s`], [one process per `i`; waits for all],
  [`$proc p = $spawn f(i);` `$wait(p);`], [create / join a process],
  [`$atomic { ... }`], [no interleaving inside],
)

Side-effect-free C functions may be called inside `$assert` / `$assume` (e.g. a recursive `reachable(from, to)`).

== Checked by default

Absence of: *deadlocks*, assertion violations, division / modulo by 0, illegal pointer dereferences, out-of-bounds array indexing, invalid casts, reading uninitialised variables, memory leaks.

== Commands

```
civl verify file.c                 # explore all paths
civl verify -inputB=5 -min file.c  # set input, shortest cex
civl verify -errorBound=3 file.c   # don't stop at 1st error
civl replay file.c                 # replay saved trace
civl replay -showTransitions -id=1 file.c
civl run file.c                    # one random execution
civl show / civl help
```

- OK: `The standard properties hold for all executions.`
- Error: violation kind (`DEADLOCK`, `ASSERTION_VIOLATION`, ...), source location, *path condition*, input values; then `The program MAY NOT be correct. See CIVLREP/file_log.txt`. Traces: `CIVLREP/file_0.trace`.
- Certainty `PROVEABLE` = real; `MAYBE` = the prover couldn't decide (possible false alarm).
- Useful options: `-showPathCondition`, `-showStates`, #box[`-timeout=60`], #box[`-enablePrintf=false`].

== Recipe: verify a property with CIVL

+ `#include <civlc.cvh>`; every unknown becomes a file-scope `$input`.
+ *Bound* sizes: `$input int N = 5; $input int n; $assume(1 <= n && n <= N);` then `$input int a[n];` --- covers *every* length $1..N$.
+ Unknown index / choice: `$input int k; $assume(0 <= k && k < n);` or `int k = $choose_int(n);` (any valid index).
+ Preconditions $arrow.r$ `$assume` (e.g. distinct elements, valid indices). *Justify each*: without it, which input breaks the code or the property?
+ Property $arrow.r$ `$assert` at the point where it must hold (after the call, end of `main`, before `return`), with quantifiers over the bounded ranges.
+ `civl verify`. On a violation, read the path condition / input values (`civl replay`) and decide: *bug in the code* (report the trace) or *missing assumption* (add `$assume`, explain).
+ Conclusion *with the bounds*: "holds for all arrays of length $1..5$ and all values".

```
// all positive / sorted
$assert($forall (int i : 0 .. n-1) a[i] > 0);
$assert($forall (int i : 0 .. n-2) a[i] <= a[i+1]);
// distinct elements (two bound variables)
$assume($forall (int i, j | 0 <= i && i < j && j < n)
          a[i] != a[j]);
// m is the minimum of a[lo..hi]: bound AND attained
$assert($forall (int k : lo .. hi) m <= a[k]);
$assert($exists (int k : lo .. hi) a[k] == m);
// conditional: only when a result exists
$assert((res != 0) => (res->data == m));
// every node: one $assert per index, nodes looked up
// with a side-effect-free helper
$for (int i : 0 .. n-1) {
  struct Node *p = lookup(root, i);
  $assert((p->left != 0) => (p->data < p->left->data));
}
```

#i[`$assume` is *not* checked: a wrong or contradictory assumption (`$assume(n < 0 && n > 0)`) makes every assertion "hold" vacuously. Keep assumptions minimal and explain each one.]

= Contracts in ACSL --- Ch. 7

Placed directly before the function in `/*@ ... */` or `//@`; every clause ends in `;`; clauses are side-effect-free (no `=`, `++`, no C calls). Order: `requires`, `terminates`, `assigns`/`ensures`, `behavior`s, `complete`/`disjoint`.

#table(
  columns: (auto, 1fr, auto),
  [clause], [meaning], [default],
  [`requires P;`], [holds on entry; *caller's* duty], [`\true`],
  [`ensures Q;`], [holds on exit, if entered with $P$ and it terminates], [`\true`],
  [`assigns L;`], [the *only* locations it may modify], [everything],
  [`terminates T;`], [must terminate whenever $T$ holds on entry], [none],
)

- Several `requires` (`ensures`) are joined by `&&`.
- *Partial* correctness: *if* it terminates, $Q$ holds (a non-terminating function satisfies any contract). *Total*: also terminates (`terminates`).
- Called outside its precondition $arrow.r$ *no* guarantee at all. `requires \false;` = nobody may call it; `ensures \false;` = never returns normally.

== Expressions

#table(
  columns: (auto, 1fr),
  [syntax], [meaning],
  [`\result`], [return value (only in `ensures`)],
  [`\old(e)`], [value on entry (`\at(e, Old)`); a parameter in `ensures` already means its entry value],
  [`\at(e, L)`], [value at label `Pre`, `Post`, `Here`, `Old`, `LoopEntry`, `LoopCurrent`, `Init`, or a C label],
  [`==>`, `<==>`], [implication, equivalence (weaker than `&&`, `||`)],
  [`0 <= i < n`], [chained comparison],
  [`integer`, `real`], [mathematical types: no overflow --- use in specs],
  [`\true`, `\false`, `\null`], [constants],
  [`\valid(p)`, `\valid(a+(0..n-1))`], [safe to read *and* write (one cell / a range)],
  [`\valid_read(p)`], [safe to read only],
  [`\separated(p, q)`], [no overlap (ranges allowed)],
)

#i[*Pairing:* `\forall` with `==>`, `\exists` with `&&`. `\exists integer i; 0 <= i < n ==> P` is true via any `i` *outside* the range. Binders extend as far right as possible: write `(\forall integer i; ...) && n > 0`.]

```
\forall integer i, j; 0 <= i < j < n ==> a[i] <= a[j]
\forall integer i; 0 <= i < n-1 ==> a[i] <= a[i+1]
\exists integer i; 0 <= i < n && a[i] == x
\forall integer i, j; 0 <= i < j < n ==> a[i] != a[j]
// \result is the max: upper bound AND attained
(\forall integer i; 0 <= i < n ==> a[i] <= \result) &&
(\exists integer i; 0 <= i < n && a[i] == \result)
\forall integer i; 0 <= i < n ==> a[i] == \old(a[i])
```

== Frame: `assigns`

`assigns \nothing;` (pure) #h(0.4em) `assigns *p;` #h(0.4em) `assigns s->credits;` #h(0.4em) `assigns a[0..n-1];` #h(0.4em) `assigns x, *p;`. Without it *anything* may change, so callers can conclude nothing about other variables (e.g. `addCredits` might rename the student).

== Behaviours --- §7.4

```
/*@ requires \valid(p);          // shared by all cases
    assigns *p;
    behavior pos:
      assumes *p >= 0;           // when it applies
      ensures *p == \old(*p);
    behavior neg:
      assumes *p < 0;
      requires *p > INT_MIN;     // extra duty in this case
      ensures *p == -\old(*p);
    complete behaviors;          // P ==> (A1 || A2)
    disjoint behaviors;          // P ==> !(A1 && A2)
*/
void absInPlace(int *p);
```

Behaviour $b$ $equiv$ `requires A ==> R; ensures \old(A) ==> E;`. `assumes` *selects*; a false `assumes` is no error. Confusing `assumes` with `requires` makes every behaviour apply to every call.

== Data invariants --- §7.3

```
//@ global invariant cntPos: count >= 0;
//@ type invariant posCr(Student *s) = s->credits >= 0;
```

*Weak* (default): added to every function's pre *and* post; may be broken inside a body, but must be restored *before every call* (callee's pre). `strong ...`: at every program point.

== Recipe: English $arrow.r$ contract

+ What must the *caller* guarantee? $arrow.r$ `requires`: pointer validity (`\valid(a+(0..n-1))`), ranges (`n >= 0`), separation, *overflow guards* (`x > INT_MIN` for `-x`).
+ What may change? $arrow.r$ `assigns` (`\nothing` for queries).
+ What is promised? $arrow.r$ `ensures` with `\result`, `\old`.
+ "If ... then ..." in the text $arrow.r$ `behavior`s + `complete`/`disjoint`.
+ Strong enough? Max: bound *and* attained. Sort: sorted *and* permutation. Search: `<==>`, not only `==>` (otherwise `return false;` satisfies it).

= Abstract Specifications --- Ch. 8

Say *what*, not *how*: every sort gets the same contract; specs can exist before the code.

```
/*@ logic integer _abs(int x) = x > 0 ? x : -x;
    predicate validDate(struct date *d) =
      \valid(d) && 0 < d->day < 32 && 0 < d->month <= 12;
*/
//@ requires validDate(d);
```

- `logic` = math function (no state change, never executed); `predicate` = Boolean-valued, reusable in `requires` / invariants.
- No body yet: declare it inside `/*@ axiomatic Name { logic integer f(...); } */` and specify in terms of it.
- *Model variables* (abstract the state; defined by the concrete fields) are not in ACSL: use a `logic` function over the fields, e.g. `logic integer value() = intPart * PRECISION + decPart;`.

== Ghost variables --- §8.3

Spec-only variables that *extend* the state: `//@ ghost int z;`, updated by `//@ ghost z = z + 1;`. Ghost code may only write ghost variables; erasing it must not change the program.

#table(
  columns: (auto, 1fr),
  [use], [example],
  [control flow], [count iterations: `ghost z = z + 1;` in the loop, `ensures z == x;`],
  [resources], [`ghost MEM = MEM + 400;` after `malloc`; `requires MEM + 400 <= MAX;`],
  [protocol], [`ghost state = 1;`; `requires state == 1;` = "may be called now"],
)

#i[Rule of thumb: a value *derivable* from program data $arrow.r$ model (ACSL: `logic` function). A record of what *happened* (events, counts, resources used) $arrow.r$ ghost.]

= Runtime Annotation Checking --- Ch. 9

Turn every annotation into a check at the right point; abort on failure: pre on entry, post at *every* exit, invariants at boundaries, `\old` saved on entry. Validates the spec on *one* execution only.

```
void addCredits(Student *s, int c) {   // by hand, §9.2
  assert(c >= 0);                        // pre
  int old = s->credits;                  // \old
  s->credits = s->credits + c;
  assert(s->credits == old + c);         // post
}
```

Hard parts: multiple exits; exceptions (check, then re-raise); spec-only constructs (quantifiers $arrow.r$ loops, `\old` $arrow.r$ copies, `\valid` $arrow.r$ memory tracking); global invariants $arrow.r$ many checks; a spec that itself fails (`1/x`) must be guarded; concurrency (checks change interleavings).

*Requirements*: *transparent* (no violation $arrow.r$ same behaviour), *isolation* (reported where it happens), *trustworthy* (no false alarms), low overhead.

== E-ACSL

Executable subset of ACSL: GMP for `integer` (no overflow *in the check*), memory tracking for `\valid`, copies for `\old`, *bounded* quantifiers only (`\forall integer i; lo <= i < hi ==> ...`).

```
e-acsl-gcc.sh file.c -c -O out    # instrument + compile
./out.e-acsl                       # aborts on violation
```

Pre-deployment: debug with checks, ship without. Post-deployment: keep as monitor.

== Recipe: finding a bug with a driver

+ Write `main` that calls the function with inputs *satisfying* its `requires`.
+ Target corner cases: 0, negative, `INT_MIN`/`INT_MAX`, empty / one-element arrays, equal elements, both orders (`x < y` and `x > y`).
+ Reach required states first via other functions (e.g. `addCredits(&s, 178)` before testing the 180 cap).
+ Interpret: *precondition* violation $arrow.r$ blame the caller (or the spec is too strong); *postcondition* violation $arrow.r$ implementation (or spec) wrong; *no error* $arrow.r$ proves nothing (`maxval` returning `x` passes if every test has `x >= y`).

#table(
  columns: (1fr, auto),
  [`absval` (`x > 0 ? x : -x`), post $|x|$], [result],
  [`absval(0)`, `absval(3)`], [no error],
  [`absval(INT_MIN)`, no `requires`], [*post* fails (GMP computes $-x$ exactly)],
  [same, with `requires x > INT_MIN`], [*pre* fails: blame moves to the caller],
)

= Static Checking --- Ch. 10

Prove annotations for *all* inputs without running: code + contract $arrow.r$ verification condition (VC) $arrow.r$ prover (Z3, Alt-Ergo, CVC). Tool: Frama-C *WP*.

```
frama-c -wp -wp-rte file.c     # -wp-rte: also overflow,
frama-c-gui -wp file.c         #   out-of-bounds, ...
```

== Hoare logic

${P} S {Q}$ (partial): from a $P$-state, *if* $S$ terminates, it ends in $Q$. $[P] S [Q]$ (total): it also terminates. `requires P; ensures Q;` on body $B$ = ${P} B {Q}$. $P => Q$: $P$ *stronger* (fewer states); `false` strongest, `true` weakest.

#table(
  columns: (auto, 1fr),
  [rule], [form],
  [assignment], [${Q[x := E]} med x := E med {Q}$ --- *backwards*],
  [sequence], [${P} S_1 {R}$, ${R} S_2 {Q}$ $tack$ ${P} S_1; S_2 {Q}$ ($R$ invented)],
  [if], [${P and c} S_1 {Q}$, ${P and not c} S_2 {Q}$ $tack$ ${P}$ if $c$ ... ${Q}$],
  [consequence], [$P => P'$, ${P'} S {Q'}$, $Q' => Q$ $tack$ ${P} S {Q}$],
)

== Weakest preconditions

$"wp"(S, Q)$ = exactly the start states from which $S$ ends in $Q$; any valid $P$ satisfies $P => "wp"(S, Q)$.

#table(
  columns: (auto, 1fr),
  [$S$], [$"wp"(S, Q)$],
  [$x := E$], [$Q[x := E]$],
  [$S_1; S_2$], [$"wp"(S_1, "wp"(S_2, Q))$],
  [if $c$ $S_1$ else $S_2$], [$(c => "wp"(S_1, Q)) and (not c => "wp"(S_2, Q))$],
  [`assert P`], [$P and (P => Q)$: prove here, assume after],
  [call `m(x)`], [$"Pre"_m and forall v in cal(A)_m . ("Post"_m => Q)$],
)

*VC* for `requires P; ensures Q;` with body $B$: $P => "wp"(B, Q)$ --- no program left, a plain formula for the prover.

#howto([compute wp by hand])[
  Start at the *bottom* with $Q$, substitute *upwards* one statement at a time; at an `if`, compute both branches and combine. E.g. `x = x + 1; y = 2 * x;`, $Q: y > 2$:
  $ "wp" = (2 x > 2)[x := x + 1] = 2(x + 1) > 2 equiv x > 0 $
  Then check $P => x > 0$.
]

== Calls and the frame

Modular: a call is replaced by the callee's *contract*, never its body. Prove (1) $"Pre"_m$ holds at the call; (2) $"Post"_m$ + facts about locations *outside* `assigns` give $Q$. The $forall$ forgets everything in $cal(A)_m$: without `assigns`, *all* of it is forgotten and e.g. `isHorizontal()` after `moveHorizontal` is unprovable.

== Loops

The user gives a *loop invariant* $I$; the verifier replaces the loop by it. For `S1; while (c) S; S2` (pre $P$, post $Q$):

#table(
  columns: (auto, 1fr),
  [obligation], [formula],
  [establish (base)], [$P => "wp"(S_1, I)$],
  [preserve (step)], [$c and I => "wp"(S, I)$],
  [use (exit)], [$not c and I => "wp"(S_2, Q)$],
)

After the loop you know *only* $not c and I$ + "nothing outside `loop assigns` changed". Whatever isn't in $I$ is lost --- the most common reason a proof fails.

```
/*@ requires 0 <= n <= 1000;
    ensures \result == n * (n + 1) / 2;
    assigns \nothing; */
int sum(int n) {
  int s = 0, i = 0;
  /*@ loop invariant 0 <= i <= n;
      loop invariant s == i * (i + 1) / 2;
      loop assigns i, s;
      loop variant n - i; */
  while (i < n) { i++; s += i; }
  return s;
}
```

Establish: $i = s = 0$ ✓ (needs $n >= 0$). Preserve: $s + (i+1) = ((i+1)(i+2)) slash 2$ ✓. Use: $not(i < n) and i <= n => i = n$ ✓ (without $i <= n$ you'd only get $i >= n$). The upper bound on $n$ keeps `s` from overflowing (`-wp-rte`).

#howto([find a loop invariant])[
  + Take the post and replace the bound by the loop counter: $s = n(n+1)/2$ $arrow.r$ $s = i(i+1)/2$; "all of `a[0..n-1]`" $arrow.r$ "all of `a[0..i-1]`" (the part done so far).
  + Add the *counter range* `0 <= i <= n` (always needed, never enough).
  + Add facts the post needs that the loop doesn't change (validity, `\at(x, Pre)` values) --- or list the changed ones in `loop assigns`.
  + Check the three obligations; if *preserve* fails, the invariant is too weak: add what the step needs (e.g. $v = 3k^2 + 3k + 1$ in `thirdPower`).
  + `\at(e, LoopEntry)`, `\at(e, Pre)`: values before the loop / at function entry.
]

== Termination --- §10.5

Liveness: runtime checking can't show it, static can. Loops need a *variant* $V$: $V >= 0$ at every iteration start and *strictly decreasing* each iteration (well-founded). Usually `bound - counter`: `n - i`, `length - i`. ACSL: `loop variant V;` plus `terminates` for the function.

== Annotation $arrow.r$ proof obligation

#table(
  columns: (auto, 1fr),
  [annotation], [proved / used],
  [`requires P` / `ensures Q`], [$P => "wp"(B, Q)$],
  [`\old(e)`], [logical variable fixed on entry],
  [call `m(x)`], [$"Pre"_m$ at the call; after it only $"Post"_m$ about $cal(A)_m$],
  [`assigns L`], [callee writes only $L$; callers keep the rest],
  [`assert P`], [prove $P$ here, assume it after],
  [`loop invariant I`], [establish, preserve, use],
  [`loop assigns L`], [an iteration writes only $L$],
  [`loop variant V`], [$V >= 0$ and strictly decreasing],
  [`terminates T`], [total correctness when $T$ holds],
)

#table(
  columns: (auto, 1fr, 1fr),
  [], [runtime (E-ACSL)], [static (WP)],
  [covers], [executed runs], [all inputs, all paths],
  [loops], [run as often as needed], [need invariants],
  [termination], [no], [yes, with variants],
  [quantifiers], [bounded only], [any],
  [failure means], [real violation], [real bug *or* weak spec / prover gave up],
)
