#import "_star.typ": *
#show: template


#show "fail": smallcaps[*fail*]
#show "pass": smallcaps[*pass*]

= IOCO & Test Generation for STS
#def[Soundness][
  A test case $t$ for an LTS $S$ is sound if for any IELTS $I$:
  $ I "ioco" S "implies that execution of " t "on" I "yields" bold("pass") $
  A test suite TS is sound if all its test cases $t in "TS"$ are sou#image("/assets/image.png")nd
]

#def[Exhaustiveness][
  A test suite TS for LTS $S$ is exhaustive if for any IELTS $I$:
  $ I cancel("ioco") S "implies that there is a " t in "TS such that execution of" t  "on" I "yields" bold("fail") $
]
