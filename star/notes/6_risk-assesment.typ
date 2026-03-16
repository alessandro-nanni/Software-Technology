#import "_star.typ": *
#show: template
= Risk Assessment
#def[Risk][
    - The possibility tha positive expectations will not be realized;
    - Probability times impact (can result in oversimplifications)
    - The combination of the probability of an event and its consequences
    - *The effect of uncertainty on objectives*
    _All definitions have impact and uncertainty._
]

Effect/impact can be positive or negative. There's an emphasis on goals to help focus on important matters.

This definition is generic, can be applied too any domain, system or phase.

== Impact
Does risk affect:
+ Money?
+ Time?
+ Reputation?
+ Safety?
+ Quality?
Focus on the negative impact. The context determines the priority.

/ Qualitative impact: which impact?

/ Quantitative impact: how bad? Number/scale

== Uncertainty
#figure(table(columns: 2)[Scale][Probability of occurrence][*1*: very unlikely][Never occurred in our field][*2*: possible][Has occurred once in 10 years][*3*: once in a while][Every few years][*4*: Often][several times a year][*5*:Regularly][Several times a month])

/ Aleatoric/stochastic uncertainty: the effect of randomness.
/ Epistemic/bayesian uncertainty: effect of ignorance.

Risk mitigation doesn't affect the probability, but reduces the impact. There are some risks where you don't want to do anything about.


== Deming Cycle

#missing(page:"?")


== When to do risk assessment

The cost of fixing error increases in the development cycle, so threat identification should be done as soon as possible, or even better at every step of development.

== Risk Strategies

/ Tolerate: accept the risks
/ Terminate: stop/not start the activity.
/ Treat:
  - reduce the likelihood of occurrence:
  - reduce the impact
/ Transfer: transfer the risk to someone else.

== Model-based Risk Assessment
It is used to identify, classify and prioritize risks. It combines free brainstorming with thorough analysis.

FMEA, fault trees and dynamic fault trees are used to *make decisions*.

== Failure Mode & Effects Analysis (FMEA)

It's a tool used in the design stage to address the ways a system can fail and take appropriate measures. It allows to sort risks by risk priority number (RPN).
$ "RPN" = "probability" times "severity" times "detection" $

FMEA steps:
+ Determine a design tree (components): a 3 level tree with a root and 2 levels of subsystems
+ Determine the function tree (roles);
+ Determine failures for each function.
  - Failure Effect at level 1;
  - Failure Mode at level 2;
  - Failure Cause at level 3;
+ Quantify: assign *severity*, *probability* and *detection* on a scale 1-10. Detection is higher the harder it is to detect. 
+ Find measures
+ Reassess.
