#!/usr/bin/env bash
# Runtime assertion checking with E-ACSL: build a C file with and without
# runtime checks, then run both.
# Run inside the sv-workspace container, from this folder:
#   ./run.sh <file.c> [program arguments]
# Writes into build/:
#   <name>           the program as is (annotations are just comments)
#   <name>.e-acsl    the same program with every annotation checked at runtime
#   <name>.frama.c   the instrumented C code, to see which checks were inserted
#   <name>.log       E-ACSL and gcc output
set -u

eval "$(opam env 2>/dev/null)" || true

src="${1:?usage: ./run.sh <file.c> [program arguments]}"
shift
name="$(basename "${src%.c}")"
out="build/$name"
mkdir -p build
rm -f "$out" "$out.e-acsl"

# The course's `e-acsl-gcc.sh <file.c> -c -O <output_file>` (the script is
# called e-acsl-gcc in this image). -o keeps the instrumented code in build/.
if ! e-acsl-gcc -c -o "$out.frama.c" -O "$out" "$src" > "$out.log" 2>&1; then
  # Frama-C 33 prints ghost arrays as e.g. `sizeof(int \ghost)` in the
  # instrumented code, which gcc rejects. Drop the qualifier and compile again.
  if [ -f "$out.frama.c" ]; then
    sed -i 's/ \\ghost\b//g' "$out.frama.c"
    e-acsl-gcc -C -O "$out" "$out.frama.c" >> "$out.log" 2>&1
  fi
fi
if [ ! -x "$out" ] || [ ! -x "$out.e-acsl" ]; then
  cat "$out.log"
  exit 1
fi

# Annotations E-ACSL can't translate are skipped with only a warning.
if grep -q '^\[e-acsl\].*Warning' "$out.log"; then
  echo "== NOT CHECKED: E-ACSL skipped these annotations"
  awk '/^\[e-acsl\].*Warning/ { w = 1; print; next } w && /^ / { print; next } { w = 0 }' "$out.log"
  echo
fi

echo "== $out   (no runtime checks)"
"./$out" "$@"
echo "-> exit code $?"
echo
echo "== $out.e-acsl   (runtime checks)"
"./$out.e-acsl" "$@"
echo "-> exit code $?"
