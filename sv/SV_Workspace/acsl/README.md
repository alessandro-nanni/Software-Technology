# ACSL contract exercises (Ch. 7)

| File | Exercise |
|---|---|
| `ex1_segments.c` | six ACSL expressions about the segment `b[j..k]` |
| `ex2_reverse.c` | contract for `void reverse(int b[], int N)` |
| `ex3_sum.c` | contract for the sum of a `double` array, using `\sum` |
| `check.sh` | runs Frama-C/WP with the right options |

Write your answers where the `TODO`s are. Everything below the
"don't edit below this line" marker is a test harness.

## Checking your answers

The tests are `//@ check` annotations on small concrete arrays. WP proves
them from your expressions/contracts alone (a `check`, unlike an `assert`, is
not assumed afterwards, so one wrong answer doesn't hide the others).

### From PowerShell (Docker Desktop running, image `sv-workspace:latest`)

Run from this folder (`sv\SV_Workspace\acsl`):

```powershell
docker run --rm -v "${PWD}:/w" -w /w sv-workspace:latest bash check.sh ex1_segments.c
```

```powershell
docker run --rm -v "${PWD}:/w" -w /w sv-workspace:latest bash check.sh ex2_reverse.c -wp-fct test_reverse
```

```powershell
docker run --rm -v "${PWD}:/w" -w /w sv-workspace:latest bash check.sh ex3_sum.c
```

Anything after the file name is passed on to `frama-c`. From Git Bash, use
`MSYS_NO_PATHCONV=1 docker run --rm -v "$(pwd -W):/w" ...` instead.

### Inside the devcontainer (`SV_Workspace/.devcontainer`)

```bash
cd acsl && bash check.sh ex1_segments.c
```

For the GUI (desktop devcontainer, noVNC on port 6080):
`bash ../run-frama-c.sh -wp -wp-model typed+real ex1_segments.c`.

## Reading the output

- `Proved goals: N / N`: all good.
- `[Timeout] typed_real_test_q4_check_q4_three_zeros`: the check
  `q4_three_zeros` in `test_q4` failed, so your `q4` gives the wrong answer for
  that array. Wrong answers show up as `Timeout`/`Unknown` (the provers give up
  after 10 s), never as "false".
- `..._requires`: a call in the test breaks your precondition (it is too
  strong).
- A failed smoke test / `(Doomed)`: your contract is inconsistent (e.g. it
  ensures something impossible), which would make every check after the call
  vacuously true.
- `reverse` goals such as `terminates`, `rte_mem_access`,
  `rte_signed_overflow`, `loop_invariant`: only relevant when you check the
  implementation (`-wp-fct reverse`); they need loop annotations (Ch. 10).

Passing the checks is strong evidence, not a proof: they test your
expressions on a handful of arrays, not on all of them.

## Notes on `check.sh`

- `-wp-model typed+real` treats `float`/`double` as mathematical reals.
  Needed for Exercise 3: this image's Alt-Ergo can't handle floating-point
  goals.
- WP in Frama-C 33 can't reason about `\sum`/`\lambda`, so the `\sum` contract
  of Exercise 3 is only parsed and type-checked. Part B of `ex3_sum.c` is a
  provable variant with your own recursive `logic` function.
