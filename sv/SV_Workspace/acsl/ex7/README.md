# Runtime assertion checking with E-ACSL

| File | Exercise |
|---|---|
| `basic.c` | turn the comments in `fun` into assertions that show the program can fail |
| `add1.c` | contract and body of `add1`, then two buggy copies (`add1_caught.c`, `add1_missed.c`) |
| `run.sh` | builds a file with and without runtime checks and runs both |

## Running

Start Docker Desktop (it needs the image `sv-workspace:latest`). Then, from PowerShell
in `sv\SV_Workspace\acsl`:

```powershell
.\start-container.ps1 ex7
```

This opens a shell inside the container, in this folder. Then:

```bash
./run.sh basic.c
```

```bash
./run.sh add1.c
```

Edit the files on Windows as usual: the folder is shared with the container, so
just run `./run.sh` again. Type `exit` to leave the container.

You can also run a single file without opening a shell, from `sv\SV_Workspace\acsl`:

```powershell
docker run --rm -v "${PWD}:/w" -w /w/ex7 sv-workspace:latest bash run.sh basic.c
```

All outputs go to `build/` (ignored by git).

### The course commands

`run.sh` runs the course command. To run it by hand in the container shell
(in this image the script is called `e-acsl-gcc`, not `e-acsl-gcc.sh`):

```bash
e-acsl-gcc basic.c -c -O basic
./basic
./basic.e-acsl
```

By hand, this fails on a ghost array whose size is a variable
(`//@ ghost int copy[len];`): Frama-C 33 writes `int \ghost` into the generated
C, and gcc rejects it with "stray '\'". `run.sh` patches that and compiles again.

### Seeing the inserted checks

`build/<name>.frama.c` is the instrumented program: each annotation becomes a
call to `__e_acsl_assert`. The course's `frama-c-gui -e-acsl basic.c` needs a
display, so it only works in the desktop devcontainer (noVNC on port 6080):
`bash ../../run-frama-c.sh -e-acsl basic.c`.

## Reading the output

`run.sh` runs the plain build first, then the checked one, and prints each exit code.

- `Error: Assertion failed` (or `Precondition failed` / `Postcondition failed`)
  with the values at the failure point, then exit code 134: E-ACSL caught a
  violated annotation. The program stops at the first one. "(core dumped)" is
  just how bash reports the abort.
- Exit code 0 from both runs: no annotation was violated *on this run*.
- Exit code 136 (division by zero) or 139 (segfault): the program crashed by
  itself, without any check catching it first.
- `NOT CHECKED`: annotations E-ACSL skipped. They aren't checked, whatever the
  exit codes say.

## Gotchas

- Both builds use `-O2`, like the course command, so gcc may delete code whose
  result is never used, even a division by zero. A plain run that exits 0
  doesn't mean that line actually ran.
- E-ACSL never checks `assigns` clauses, so they always show up under
  `NOT CHECKED`. Keep them if you also want to prove the contract with WP.
- The natural postcondition for `add1`, with `\old(arr[i])` inside a `\forall`
  bounded by `len`, is skipped ("`\at` with logic variable linked to C
  variable is not yet supported"). `\old` there only works with a constant
  bound. To check the postcondition at runtime, keep a ghost copy of the array
  from the start of the function and compare against it. Either use a global
  `//@ ghost int old_arr[100];` together with `requires len <= 100;`, or a
  local `//@ ghost int old_arr[len];`.
