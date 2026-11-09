# Guest lectures — content & exam relevance

Three guest lectures. NuSMV modelling (ex3 a/b-style "write the module") is left out on purpose.

| # | Lecture | Speaker | Core message | Feeds exam part |
|---|---|---|---|---|
| 1 | *Prevention is the best cure — applying formal methods in practice* (2026) | Ronald Bos, Technolution | Model checking (mCRL2) on 3 real industrial cases; where each formal technique sits in the V-model | ex1 (technique choice, model vs code), ex2 (property patterns), safety/liveness |
| 2 | *Model checking of industrial embedded control systems using timed automata* (SystemC → Uppaal) | Paula Herber, Münster / UTwente | Automatically translate design models to formal models, then model check; scalability limits; deductive verification when model checking fails | ex1 (state space explosion, bounded vs unbounded, model vs implementation), property types |
| 3 | *From documents to models: towards digital continuity* (18/09/2024) | Marcel Verhoef, ESA ESTEC | Why space needs V&V; famous failures; deep static analysis; model-based systems engineering (MBSE) | ex1 (advice essays, testing vs verification), ex4 link (runtime errors, `\valid`) |

The exam's ex1 ("Formal Tools and Techniques") is where these lectures matter most. The 2021 exam asks about the guest lecture directly (1a: *"the model checker couldn't check the property because it took too much time — what is the cause?"* → **state space explosion**).

---

## 1. Ronald Bos (Technolution) — Prevention is the best cure

### Content

**Motivating examples from his own career**
- *Electric motor controller*: safety property "switches may never be activated such that power supply and ground rails are connected" (a short circuit). This must hold on **all** execution paths.
- *Coffee machine*: an interrupt handler had to finish within one time slice; timing was not met. Property: "the duration of **all possible execution paths** through the interrupt handler must be at most one time slice".
- Basic idea of formal methods: *some property must hold for all possible execution paths* (testing only covers some).

**Formal methods in the product creation process**
- Defects cost money twice: during use (unsafe memory → security holes; unsafe behaviour → damage) and during creation (design error found only at integration test).
- Cost of fixing a defect grows with each phase (feasibility → definition → design → engineering → integration → field). He notes the evidence for this curve is mostly anecdotal, but research tentatively points that way.
- **V-model**: left side needs → specification → system design → subsystem design → component design → realization; right side the matching tests. *Validation* = checking against **needs** ("are we building the right thing"), *verification* = checking against the **specification** ("are we building it right").
- **Where each technique fits** (his V-model slide):

  | Technique | Example tool | Where in the V |
  |---|---|---|
  | Model checking | SPIN, mCRL2 | specification / system design (early, on models) |
  | Design by contract | Frama-C | component realization (code) |
  | Runtime monitoring | LarVa | software module / tests (running code) |
  | Model-based testing, unit tests | — | component / subsystem test |

- Early verification on models finds design errors before anything is built (cheapest point).

**mCRL2 primer**
- Model = communicating concurrent processes (process algebra); state space = all interleavings; properties in temporal logic (safety and liveness).
- Process operators: `a . b` (sequence), `a + b` (choice), synchronisation between processes.
- Logic: Hennessy–Milner with **diamond `<a>φ`** ("an a-step is *possible* after which φ holds" → like CTL **E**) and **box `[a]φ`** ("after *every* a-step φ holds" → like CTL **A**). Regular formulas allow sequences: `[true*]φ` ≈ `AG φ`, `<true*>φ` ≈ `EF φ`.
- Useful patterns from the slides, with the LTL/CTL you would write in this course:

  | Pattern | mCRL2 | LTL / CTL equivalent | Kind |
  |---|---|---|---|
  | b **can** happen after a | `[true*.a]<true*.b>true` | `AG(a -> EF b)` | liveness (possibility) |
  | b **must** happen after a | `[true*.a.(!b)*]<true*.b>true` | ≈ `G(a -> F b)` ¹ | liveness |
  | c must happen **between** a and b | `[true*.a.(!c)*.b]false` | `G(a -> X(!b W c))` | safety |
  | c is **not allowed** between a and b | `[true*.a.(!b)*.c]false` | `G(a -> X(!c W b))` | safety |

  ¹ Strictly, the mCRL2 formula says "b stays reachable as long as it hasn't happened"; with fairness this amounts to `G(a -> F b)`.

  Note: a safety property is written as `[...]false` ("this bad sequence can never happen"). A liveness property needs a `<...>true` ("something good can still happen").

**Case 1 — tunnel safety system (Blankenburg tunnels)**
- Context: after the 2001 Gotthard tunnel fire, the Dutch tunnel standard (LTS) prescribes safety systems (barriers, sprinklers, fans). Faults in automation can cost lives.
- Modelled part: the *liquid disposal coordinator*.
- Requirement: *after a tunnel calamity, the liquid disposal state can only be switched back to normal via a (manual) confirmation.*
- **Property derivation process** (mCRL2 book p.113), the same method you use for ex2:
  1. Formulate the property in natural language.
  2. Rephrase it in terms of the model's actions/interactions, still in natural language ("the transition from calamity to normal can only go via a confirmation").
  3. Translate into a formula: `[true* . naarCalamiteit . (!(bevestig || naarNormaalHand))* . naarNormaal] false` ("between" pattern).
- Result: a **counterexample**. Someone manually put the system in calamity, then switched to automatic mode, after which the system went back to normal by itself. Obscure but possible.
- Value: **2 specification errors** found that would have gone unnoticed; reported back to improve the standard. V position: **specification**.

**Case 2 — sensor firmware update**
- Sensor in electrical substations; firmware write = check downgrade → mark invalid → remember length+version in RAM → receive chunks into flash + SHA256 → check hash → check signature → store length+version in flash and mark valid.
- Bug: if a write is aborted and a new one started, the new write stores the **old** length/version (still in RAM).
- Modelled as a UML state machine (Idle / Receiving; inputs FirstChunk, NextChunk, LastChunk with guards like `[isADowngrade]`).
- Properties:
  - "Between two `rememberFirmwareInfo`, a first chunk must be received": `[true*.rememberFirmwareInfo.(!receivedFirstChunk)*.rememberFirmwareInfo]false`.
  - "Between two `storeFirmwareInfoInFlash`, a `rememberFirmwareInfo` must happen."
  - "After the first chunk, the info must eventually be stored to flash" (the "must happen after" pattern).
- V position: **component design**.

**Case 3 — concurrent Java software (deadlock)**
- Meter frontend + readings database; code evolved without redesign (agile contract with no redesign sprints), two Java locks (`ReentrantLock`, `ReentrantReadWriteLock`) used recursively → deadlock in production.
- Idea: model the locking behaviour and verify the fix with model checking instead of only testing.
- **Pitfall**: `ReentrantReadWriteLock` behaves differently than its Javadoc says (a read lock is *not* given while a writer is waiting). *For model checking to be valid, the modelled behaviour must be correct → model the behaviour as observed, not as documented.*
- Process: first gain confidence in the lock model, then model the problematic class and experiment with fixes. V position: **component realization**.

**Reflection**
- Model checking helps to (1) gain insight (building the model itself, stepping through states), (2) verify a design, (3) verify changes, (4) all without building the system. It can be done for **part** of a system, so it scales.
- Considerations: the modelled parts were still overseeable, while the real value is for systems that aren't; model checking is specialist work → standardise on patterns or hide it behind a front-end; often other problems (contracts, unclear specs, missing test plans) matter more; good system design can avoid complexity.
- Routes to robust systems: formal verification; correct by construction (model-driven development, synthesis); LLMs generating/testing code; traditional testing, reviews, proofs.

### How it relates to exam questions

**ex1, "which technique and why":**
- *Model checker vs program verifier (2021 1b)*: the model is an interpretation of the program and can be wrong. Case 3 is the perfect example: the lock model had to follow observed behaviour, otherwise the proof is worthless.
- *Advice questions (2023 1a voting software, 2025 1a hotel database)*: use the V-model table. Design-level problems → model checking early; code-level data structure bugs → design by contract / static verification (Frama-C); production behaviour → runtime monitoring (LarVa). Mention the cost-of-defects argument for doing it early.
- *Possibility vs necessity (2021 1c, 2022 1b "a property expressible in CTL, not LTL")*: mCRL2's diamond `<a>` is exactly the "E" that LTL lacks. "b **can** happen after a" = `AG(a -> EF b)` has no LTL equivalent.
- *Validation vs verification*: needs vs specification (V-model).

**ex2, specifications:** his patterns are the ones the exams keep asking for:
- "between" → `G(a -> X(!b W c))` (the pattern you missed in rounds 2, 4 and 5);
- "can happen after" → `AG(a -> EF b)`;
- "must happen after" → `G(a -> F b)`;
- "never at the same time" (motor controller) → `AG !(highSide & lowSide)`;
- "all paths finish within a time slice" (coffee machine) → a timing property: LarVa with `c@slice` on a run, or a real-time model checker (Uppaal) on all paths.

**Safety vs liveness (2021 3c-style):** "bad sequence never happens" (`[...]false`, between patterns, never-at-the-same-time) = **safety**; "something good eventually/possibly happens" (`<...>true`) = **liveness**.

---

## 2. Paula Herber — Model checking of industrial embedded control systems (SystemC → Uppaal)

### Content

**Problem**
- Embedded control systems (98% of processors) interact with a physical environment through sensors and actuators; failures make the news.
- Gap between theory and practice: formal methods are automatic and complete but used on small examples and high abstraction levels; industry uses simulation and testing (a car: ~100 control units, 1 GB of software, ~1M lines of code).
- Challenges: heterogeneous models and languages, HW/SW intertwined; concurrency, reactivity, real-time; many components; partially unknown environments.

**Transformation-based formalization**
- Design languages like **SystemC** (C++ extension for HW/SW co-simulation) and **Matlab/Simulink** only have *informally* defined semantics.
- Previous formalizations were manual, supported small subsets, or produced unreadable models.
- Her approach: define a semantic mapping once → **automatic transformation** (rules + predefined components) from the design to a formal model → off-the-shelf verification tool → *satisfied* or *counterexample*.
- Targets: SystemC → **Uppaal** (real-time model checker), **uclid** (bit-precise SMT), CPAchecker (software model checker), **VerCors** (deductive verifier for concurrent software); Simulink → uclid, **KeYmaera X** (theorem prover for hybrid systems).

**SystemC and Uppaal basics**
- SystemC: discrete-event simulation; code lives in concurrent processes triggered by events; notification is immediate, delta-delayed or timed; communication through channels (separating computation and communication). Example: producer/consumer with a FIFO channel that blocks on full/empty.
- The SystemC scheduler (initialize → evaluate → update → advance time) runs ready processes in an **unspecified order**.
- Uppaal timed automata: finite-state machines with **clocks**, clock guards/invariants (`x <= maxtime`, `x >= mintime`), networks of automata with interleaving semantics, synchronisation over channels (`request?` / `ack!`), bounded data variables, urgent/committed locations.

**The STATE tool (SystemC to Timed Automata Transformation Engine)**
- Each method becomes a timed automaton (assignments → updates, control flow → guards, method calls → channel synchronisation; a `while(i <= n)` loop becomes locations with guards `i <= n` / `i > n`).
- Predefined templates for processes, events (immediate / delta / timed notification) and the scheduler.
- The scheduler model chooses the order of ready processes **nondeterministically** → the model checker covers **all possible execution orders** (simulation only tries one).
- **Assumptions** needed for the transformation: no recursion, no dynamic process creation, no pointer arithmetic, no function pointers/casts, only int/bool/arrays/structs, and a **statically determinable maximum** of processes, method calls and memory. In short, the model has to be finite.
- Both the transformation and the verification are fully automatic.

**Results**
- *AMBA AHB bus* (ARM, 2400 LOC, 9 processes): found a **deadlock** in minutes. Verified deadlock freedom, "only one master active", "bus granted to M1/M2", timing, type-safe memory access, no null pointer access. Verification time for deadlock freedom grows from ~6 minutes (1 master, 1 slave) to ~1.5 hours (2 masters, 2 slaves).
- *UART* (400 LOC) with uclid: "all sent data correctly received". **BMC** ~10 minutes, **k-induction** ~7 hours, independent of bit width. Uppaal managed only 4-bit width (2h42) and failed for 8+ bits.
- *ABS/ASR (anti-lock braking)*: could **not** be verified by existing model-checking approaches. With **VerCors** (deductive) it worked in minutes, for **parameterized** designs (arbitrary distances, FIFO sizes), using manually written invariants.
- *Simulink distance warner* → uclid: requirement "no division by zero, no overflow" → **overflow found** at an integrator; Matlab Design Verifier failed at all bit widths.
- *Simulink → differential dynamic logic (KeYmaera X)*: temperature control, infusion pump ("no critical dosage", "warning on empty tank"), robot collision freedom. Manual effort ranges from 0.5 to 70 hours.

**Conclusion / outlook**
- Automatic formalization makes existing tools usable on industrial designs.
- Open challenges: **bridge the gap from system model to implementation** (test automation, real-time OS semantics), scalability via **contract-based deductive verification**, safe integration of learning components.

### How it relates to exam questions

**ex1:**
- *State space explosion (2021 1a; 2022 1e "disadvantage of CIVL: grows quickly with state space")*: the AMBA times (minutes → hours when adding a master and a slave) and Uppaal failing on wider UART data are concrete examples. More processes or wider data mean exponentially more states (all interleavings × all values).
- *Bounded vs unbounded guarantees (2021 1d CIVL vs Frama-C; 2024 1c/1d bounded analysis for a traffic light with n roads)*:
  - BMC (like CIVL) only checks up to a bound: fast, but no proof beyond k.
  - k-induction / deductive verification (VerCors, Frama-C WP, KeYmaera X) proves it for **all** sizes, at the cost of more time or manual invariants.
  - ABS/ASR is the answer pattern for 2024 1d: when behaviour depends on unbounded data (number of cars), bounded techniques no longer suffice → static/deductive verification.
- *Why a model checker needs finite models (2022 1c left-total; general)*: the STATE assumptions (no recursion, static maximum of processes) exist to keep the state space finite.
- *Model vs implementation (2025 1b, 2021 1b)*: deriving the formal model **automatically** from the design removes the "the model may not match the code" problem. Advantage: no manual modelling errors, push-button. Disadvantage: only a language subset is supported, and the result can still be too large to check.
- *Simulation/testing vs model checking*: the nondeterministic scheduler shows the difference. Simulation runs one schedule; model checking explores all of them, which is how the AMBA deadlock was found.

**Property kinds (ex2/ex3 spec parts):**
- Deadlock freedom, "only one master active" (mutual exclusion, like *"the two buses can never be at the same station"* in 2024 or *"the two bridges are never open at the same time"* in 2025) → **safety**, `AG !(m1 & m2)`.
- "Bus granted to M1" → **liveness**, `AG(req1 -> AF grant1)`.
- Timing properties → in this course you'd use a **LarVa monitor with a clock** (one run). Uppaal checks them over **all** runs of the model.
- Background, not on the slides: Uppaal queries map to CTL as `A[] p` = `AG p`, `E<> p` = `EF p`, `A<> p` = `AF p`, `E[] p` = `EG p`, `p --> q` = `AG(p -> AF q)`.

**ex4 link:** "no null pointer access", "type-safe memory access", "no overflow" are the same runtime-error properties you express with `\valid(...)` preconditions and overflow checks in Frama-C.

---

## 3. Marcel Verhoef (ESA) — From documents to models: towards digital continuity

### Content

**Why space is different**
- Spacecraft are one-of-a-kind ("we fly models!"), must survive launch, operate 10 years in vacuum and radiation, use only proven (slow) hardware, take 5–10 years to develop, are controlled from Earth and need on-board autonomy for communication outages. **You cannot fix hardware after launch.**

**Failures (safety and dependability)**
- **Ariane 501** (1996): the inertial guidance software was **reused** from Ariane 4, but Ariane 5's flight profile was different; to save cost and time, **essential tests were skipped** despite engineers' advice; a **floating-point overflow** in the guidance system made the computer malfunction; rocket and the Cluster mission were lost.
- **Mars rover reset**: the software was written under huge time pressure after the original supplier went bankrupt; an error showed up during testing but **could not be reproduced**, and the mission launched anyway because of the launch window; on Mars the rover kept halting and resetting; it was diagnosed from household telemetry and fixed by uploading a small software patch.
- Apollo 11 ("touch and go"), Mars Climate Orbiter, Huygens/Titan, rovers as further examples; discussion on safety.

**V&V of spacecraft**
- "Models versus product" over the mission lifecycle: requirements validation and model validation early; product verification and validation late; then flight and operational certification.
- "Test as we fly, fly as we test": put the spacecraft in a representative environment (thermal, acoustic, vibration) and operate it only through a "phone line", as in orbit. Not all testing succeeds.

**Software practice**
- Languages: C (efficient, portable, good tools), **Ada** (strong typing, packages, tasks, exception handling, **run-time checking and self-monitoring**), µPython.
- Design & implementation: unit tests with **100% branch and statement coverage**, code inspections (defensive programming), static analysis (safe subsets MISRA-C / Ravenscar, complexity metrics, **abstract interpretation = deep static analysis**), timing measurements, worst-case execution time (WCET).
- **Deep static analysis (abstract interpretation)**:
  - *not* about functional requirements, *not* about implementation matching requirements, *not* about tests (code isn't executed);
  - a program inspecting the mission code and finding **all** potential issues of certain classes that humans missed;
  - finds requirement-independent bugs: **out-of-bounds** computations, **uninitialised memory**, **invalid memory access** (NULL), decisions that depend on invalid accesses;
  - *"testing can never prove the absence of bugs (not even with 100% coverage), because the state space is infinite"*;
  - tools: Clang Static Analyzer, Infer, CBMC (open source); Coverity, Polyspace, Astrée (commercial); SPARK in Ada toolchains; easy to add to the build.
- **Avionics Test Bed**: an open facility for validating technologies and standards in context (software-only up to hardware-in-the-loop, with model reuse across phases).

**Model-Based Systems Engineering (MBSE)**
- Document-based workflow: documents are snapshots, expensive, hard to maintain and **hard to analyse**.
- MBSE gives an explicit notation for models, continuous **verification** (internal consistency) and **validation** (external consistency). The vision: from informal documents reviewed by humans to models with automated analysis, across the whole lifecycle ("digital continuity").
- Concurrent Design Facility: experts co-located, iterative, model driven (200+ studies). CHEOPS mission: 4 years, €50M, built "from model to model".
- Challenges: iteration across contracts costs money, documents (not models) are the formal deliverables, model heterogeneity, information explosion, IP concerns, models are useless without their tools.
- Tool chain: SysML / Capella (architecture), AADL (architecture and real-time properties), **TASTE** (ASN.1 data types, AADL architecture, **SDL state machines**, **code generation** to C/Ada/SPARK, build and deploy, **runtime monitoring** of the binary), COMPASS/FAME (fault behaviour verified with **nuSMV**), schedulability analysis.
- Conclusions: MBSE helps with complexity; quick iteration and immediate automatic feedback are key; human inspection and stakeholder-specific views are still needed.

### How it relates to exam questions

**ex1 advice essays (2023 1a, 2025 1a/1b):**
- *Why formal methods at all*: you can't patch hardware in orbit; defects found late are costly; testing can't prove absence of bugs. This is the standard motivation sentence for any "give advice" question.
- *Ariane 501 as an example of "which technique would have helped"*:
  - **Design by contract**: the Ariane 4 software assumed bounded horizontal velocity (from the inquiry report, not on the slide). Written as a `requires` clause, reusing the code with a different profile becomes a visible precondition violation (static verification would flag the caller).
  - **Static verification with overflow / runtime-error checks** (Frama-C WP + RTE, or abstract interpretation) would have found the possible overflow without running the code.
  - **Runtime assertion checking** (E-ACSL / Ada run-time checks) during the skipped tests would have caught it, but only on the inputs actually tested.
- *Mars rover*: an error that **can't be reproduced** points to nondeterminism or concurrency. Model checking explores **all interleavings**; runtime monitoring/logging (the household telemetry) helps diagnose it in operation.
- *Testing vs verification*: 100% coverage ≠ correctness; static analysis checks all paths without executing.
- *Model vs implementation (2025 1b)*: TASTE's **code generation from verified models** (correct by construction) is one approach. Advantage: the code matches the model by construction. Disadvantage: you depend on the generator and toolchain, and the generated code still runs on a real OS and hardware that the model abstracts away. **Runtime monitoring** of the generated binary is another.
- *Verification vs validation*: internal consistency (does it meet the spec/model?) vs external consistency (does it meet the real needs?).

**ex4 link (static verification):** the deep static analysis bug classes are exactly what ACSL preconditions guard against: `\valid(a + (0..n-1))`, array bounds `0 <= i < n`, initialised values, no overflow. Missing `\valid` or bounds is a typical lost point (round 5 (o)).

---

## Cross-lecture cheat sheet for ex1 essay questions

| Technique | Checks | Guarantee | + | − | Lecture example |
|---|---|---|---|---|---|
| Model checking (NuSMV, mCRL2, Uppaal) | all paths of a **model** | complete for the (finite) model; counterexample if false | automatic, early in the V, finds concurrency bugs and spec errors | state space explosion; model may not match the code; needs a finite model | tunnel spec errors, AMBA deadlock, Java lock model |
| Deductive static verification (Frama-C WP, VerCors, KeYmaera X) | the **code** against contracts | proof for all inputs, unbounded | strongest guarantee, parameterized systems | manual annotations and invariants, expert effort (up to 70 h) | ABS/ASR, infusion pump |
| Bounded symbolic analysis (CIVL, CBMC, BMC in uclid) | code up to a bound | only up to the bound | few annotations, automatic | no guarantee beyond the bound; grows quickly | UART BMC (k-induction for the full proof) |
| Abstract interpretation / deep static analysis (Astrée, Polyspace, Infer) | runtime errors, no spec needed | all paths, for those error classes | no annotations, fits in the build | false positives; doesn't check functional requirements | ESA flight software |
| Runtime verification (LarVa, E-ACSL, Ada run-time checks) | the actual execution | only the observed run | real system, real environment, timing | can't prove absence of bugs; can't check liveness or "possible"; overhead | TASTE monitoring, rover telemetry |
| Testing / model-based testing | chosen inputs | none (*"can never prove absence of bugs"*) | cheap, familiar | incomplete even at 100% coverage | Ariane skipped tests |

**Ways to make an implementation match a model (2025 1b asks for ≥2, each with a + and a −):**
1. **Generate code from the model** (TASTE/SDL, model-driven development). + consistent by construction; − trust in the generator, abstraction of OS/hardware.
2. **Extract the model from the code automatically** (Herber's SystemC → Uppaal). + no manual modelling errors; − limited language subset, can still explode.
3. **Runtime monitoring** of the implementation against the model's properties (LarVa). + checks the real system; − only observed runs, after the fact.
4. **Static verification of the code** against the same properties as contracts (Frama-C). + all inputs; − annotation effort.
5. **Model-based testing**: generate tests from the model. + automatic, systematic; − still testing, incomplete.

---

## Practice questions based on the lectures

### ex1-style

1. In the guest lecture, adding one master and one slave to the AMBA bus model raised verification time from minutes to over an hour. Explain why.
2. Why did Bos model `ReentrantReadWriteLock` "as observed, not as documented"? What does this say about the guarantees of model checking?
3. Which formal technique(s) could have prevented the Ariane 501 failure? Motivate your answer.
4. The ABS/ASR system could not be verified with model checking but could with VerCors. Explain why, and name a disadvantage of the VerCors approach.
5. Why does the SystemC → Uppaal transformation require a statically determinable maximum number of processes and no recursion?
6. An error appeared during testing of the Mars rover but could not be reproduced. Which technique is best suited to find such errors, and why?
7. "Testing can never prove the absence of bugs." Explain, and name two techniques that can give stronger guarantees.

<details>
<summary>Short model answers</summary>

1. State space explosion: every extra process multiplies the number of interleavings, and data adds more states.
2. A model checker only proves properties **of the model**. If the model doesn't match the real behaviour, the proof says nothing about the real system.
3. Design by contract (the Ariane 4 assumption as a `requires`, so the reuse becomes a visible violation) plus static verification with overflow checks (finds the overflow without running it). Runtime assertion checking only if the tests had been run with the Ariane 5 profile.
4. It is parameterized (arbitrary sizes) → infinite or too large state space for a model checker; deductive verification proves it for all sizes. Disadvantage: invariants must be written by hand (expertise, effort).
5. A model checker needs a finite state space; recursion and dynamic process creation make it unbounded.
6. Model checking: it explores all interleavings and schedules, while testing only sees one. Runtime monitoring/logging helps in operation.
7. The state space is infinite, so tests cover only some executions, even at 100% coverage. Deductive static verification (all inputs) and model checking (all paths of a model) give stronger guarantees.

</details>

### ex2-style (write a formal specification)

1. *(tunnel)* After a calamity, the liquid disposal system may only return to normal after a manual confirmation.
2. *(firmware)* After the first chunk of a firmware image is received, the firmware info must eventually be stored to flash.
3. *(firmware)* Between two times the firmware info is remembered, a first chunk must be received.
4. *(motor controller)* The high-side and the low-side switch are never closed at the same time.
5. *(coffee machine)* The interrupt handler always finishes within one time slice of 2 ms.
6. *(AMBA bus)* At most one master is granted the bus at any time.
7. *(AMBA bus)* A master that requests the bus will eventually be granted it.
8. *(mCRL2 pattern)* After an `a`, it is always possible that a `b` happens later.

<details>
<summary>Answers</summary>

1. `G(calamity -> X(!normal W confirmation))`
2. `G(firstChunk -> F storeInfoInFlash)`
3. `G(rememberInfo -> X(!rememberInfo W firstChunk))`
4. `AG !(highClosed & lowClosed)` or `invariant !(highClosed && lowClosed);`
5. LarVa with clock `c`: `idle -> handling [enterHandler\\c.reset();]`, `handling -> idle [exitHandler\\]`, `handling -> bad [c@2\\]` (time unit ms)
6. `G !(grant1 & grant2)`
7. `G(request1 -> F grant1)`
8. `AG(a -> EF b)` (CTL only; there is no LTL equivalent)

</details>
