#!/usr/bin/env bash
# Runtime assertion checking: build a C file with E-ACSL and run the checked binary.
# Run inside the sv-workspace container:
#   ./rac.sh <file.c> [program arguments]
# Produces <file>.frama.c (instrumented code), <file>.e-acsl and <file>.log.
set -e

eval "$(opam env 2>/dev/null)" || true

src="$1"
shift || { echo "usage: $0 <file.c> [program arguments]" >&2; exit 2; }
name="${src%.c}"
log="$name.log"

# 1. Instrument only (-n), so the generated code can be patched before gcc sees it.
if ! e-acsl-gcc -n -o "$name.frama.c" "$src" > "$log" 2>&1; then
  cat "$log"
  exit 1
fi

# 2. Frama-C 33 prints ghost types as e.g. `sizeof(int \ghost)` in the generated
#    C, which gcc rejects. Drop the qualifier; it means nothing to gcc anyway.
sed -i 's/ \\ghost\b//g' "$name.frama.c"

# 3. Compile the (already instrumented) code.
if ! e-acsl-gcc -C -O "$name" "$name.frama.c" >> "$log" 2>&1; then
  cat "$log"
  exit 1
fi

# Annotations E-ACSL can't translate are skipped with only a warning; show them.
grep -A3 '^\[e-acsl\].*Warning' "$log" || true

case "$name" in
  /*) exe="$name.e-acsl" ;;
  *)  exe="./$name.e-acsl" ;;
esac
exec "$exe" "$@"
