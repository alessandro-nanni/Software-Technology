#!/usr/bin/env bash
# Open a shell in the sv-workspace container with this acsl folder mounted at /w
# and Frama-C/E-ACSL already on the PATH.
# Run on the host (Git Bash on Windows), from any folder:
#   ./start-container.sh              # shell in /w
#   ./start-container.sh runtime_ex   # shell in /w/runtime_ex
# Then e.g.: ../rac.sh basic.c
set -e

image=sv-workspace:latest

# Windows path of this script's folder (C:/...); plain pwd elsewhere.
here="$(cd "$(dirname "$0")" && { pwd -W 2>/dev/null || pwd; })"

docker info > /dev/null 2>&1 || { echo "Docker isn't running: start Docker Desktop first." >&2; exit 1; }
docker image inspect "$image" > /dev/null 2>&1 || { echo "Image $image not found: build it from ../.devcontainer first." >&2; exit 1; }

# Only ask for a terminal when there is one, so commands can also be piped in.
tty=(-i)
[ -t 0 ] && tty=(-it)

# Stop Git Bash from rewriting /w into a Windows path.
export MSYS_NO_PATHCONV=1
exec docker run --rm "${tty[@]}" -v "$here:/w" -w "/w/${1:-}" "$image" \
  bash -c 'eval "$(opam env 2>/dev/null)"; exec bash'
