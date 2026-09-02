#!/usr/bin/env bash
# Run this inside the devcontainer to get straight to the Frama-C GUI.
set -e

eval "$(opam env)"

if [ ! -f "$HOME/.why3.conf" ]; then
    echo "No why3 config found, detecting provers..."
    why3 config detect
fi

# Electron's setuid sandbox helper needs root ownership + mode 4755, which
# doesn't survive npm/yarn extracting the package as a non-root user. Docker's
# own container isolation is the real security boundary here, so just disable it.
export ELECTRON_DISABLE_SANDBOX=1

# There's no real GPU in this container, and letting Electron try/fail to
# negotiate one crashes the whole app instead of just falling back cleanly.
# Skip GPU negotiation entirely and force software rendering.
export LIBGL_ALWAYS_SOFTWARE=1

exec frama-c-gui --disable-gpu "$@"
