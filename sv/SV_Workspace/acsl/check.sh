#!/usr/bin/env bash
# Prove the ACSL annotations of a C file with Frama-C/WP.
# Run inside the sv-workspace container, from this folder:
#   ./check.sh <file.c> [extra frama-c options, e.g. -wp-fct test_reverse]
set -e

eval "$(opam env 2>/dev/null)" || true
[ -f "$HOME/.why3.conf" ] || why3 config detect > /dev/null 2>&1

# -wp-rte            also prove absence of runtime errors (overflow, out of bounds)
# -wp-smoke-tests    flag contracts that are inconsistent, e.g. `ensures \false`
#                    (these would make every caller's assert "provable")
# -wp-model ...+real treat float/double as mathematical reals (no rounding)
# -wp-cache none     don't write a .frama-c/ cache folder next to the sources
exec frama-c -wp -wp-rte -wp-smoke-tests \
  -wp-model typed+real \
  -wp-prover alt-ergo,z3 -wp-timeout 10 -wp-cache none \
  -wp-warn-key pedantic-assigns=inactive \
  "$@"
