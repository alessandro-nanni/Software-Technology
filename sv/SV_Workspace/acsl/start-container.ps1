# Open a shell in the sv-workspace container with this acsl folder mounted at /w
# and Frama-C/E-ACSL already on the PATH. Command line only: no GUI.
# Run from PowerShell, from any folder:
#   .\start-container.ps1              # shell in /w
#   .\start-container.ps1 static_ex    # shell in /w/static_ex
# Then e.g.: ../check.sh file.c   or   ../rac.sh file.c
param([string]$Folder = "")

$image = "sv-workspace:latest"

docker info *> $null
if ($LASTEXITCODE -ne 0) { Write-Error "Docker isn't running: start Docker Desktop first."; exit 1 }
docker image inspect $image *> $null
if ($LASTEXITCODE -ne 0) { Write-Error "Image $image not found: build it from ..\.devcontainer first."; exit 1 }

# Only ask for a terminal when there is one.
$tty = if ([Console]::IsInputRedirected) { "-i" } else { "-it" }

docker run --rm $tty -v "${PSScriptRoot}:/w" -w "/w/$Folder" $image bash -c 'eval $(opam env 2>/dev/null); exec bash'
