FROM --platform=linux/amd64 mcr.microsoft.com/devcontainers/base:noble

# NOTE: This does not verify any signatures whatsoever.
#       Use at your own risk and check the Dockerfile before you use it to make
#       sure that you agree with it.


# You might have to run 'why3 config detect' after starting the container
# if Frama-C cannot find the provers.

# Install basics
RUN apt-get update && apt-get -y install \
    curl \
    git

# ----------------------
# NuSMV
# ----------------------
# 2.7.1, not the older 2.6.0: the -int interactive shell in the 2015-era 2.6.0
# build segfaults on any command when run under a real terminal on modern
# Linux (reproduced independent of file/command - even bare 'quit' crashes it).
# 2.7.1 fixes this. It's dynamically linked against libedit.so.0, which no
# longer exists on Ubuntu Noble (only libedit.so.2), so a compat symlink is
# needed - libedit's core API has stayed stable across that soname bump.
RUN apt-get -y install libedit2 \
    && ln -s /usr/lib/x86_64-linux-gnu/libedit.so.2 /usr/lib/x86_64-linux-gnu/libedit.so.0
ENV NUSMV_URL=https://nusmv.fbk.eu/distrib/2.7.1/NuSMV-2.7.1-linux64.tar.xz
RUN curl -fsSL "$NUSMV_URL" -o NuSMV_2_7_1.tar.xz
RUN tar -xJf NuSMV_2_7_1.tar.xz
ENV PATH="$PATH:/NuSMV-2.7.1-linux64/bin"
RUN rm -r NuSMV_2_7_1.tar.xz

# ----------------------
# Larva
# ----------------------
# The implementation of Larva is provided in the 'given'-folder of the assignment
RUN apt-get -y install \
    openjdk-17-jdk \
    aspectj


# ----------------------
# CIVL
# ----------------------
ENV CIVL_URL=https://vsl.cis.udel.edu/lib/sw/civl/1.22/r5854/release/CIVL-1.22_5854.tgz
RUN apt-get -y install \
    cvc4 \
    z3
RUN curl -fsSL "$CIVL_URL" -o /opt/CIVL-1_22.tgz
RUN tar -xzf /opt/CIVL-1_22.tgz -C /opt/
ENV PATH="$PATH:/opt/CIVL-1.22_5854/bin"
RUN rm -r /opt/CIVL-1_22.tgz


# ----------------------
# FramaC
# ----------------------
RUN apt -y install \
    autoconf \
    opam \
    graphviz \
    libcairo2-dev \
    libgmp-dev \
    libgtk-3-dev \
    libgtksourceview-3.0-dev \
    pkg-config
ENV OPAMROOT=/.opam
RUN opam -y init --compiler 4.14.1
RUN eval $(opam env)
RUN opam -y install frama-c
# The devcontainer connects as the non-root 'vscode' user, but the opam root
# above was created by root during the image build. Hand it over so Ivette
# (Frama-C's GUI) can install itself into it at runtime.
RUN chown -R vscode:vscode "$OPAMROOT"
