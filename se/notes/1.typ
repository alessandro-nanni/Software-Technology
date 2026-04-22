#show "cobol": it => smallcaps(it)
#import "_se.typ": *
#show: template
#let solved-q = false

= Level 1
== Definition
Evolution: studying software that already exists. 70% of software is maintenance. 90% of the costs of software are in maintenance.

43% of existing banking systems are built on cobol. 200B lines of code in cobol exist. Replacement costs 25\$ per line.

#def[Maintenance][
  Modification of a software project after delivery to:
  - correct faults (bug fixing)
  - improve performance (50%)
  - adapt the product to a modified environment
  - _prevent future issues_: 4%, because you cannot plan for future issues.
]

#def[Legacy Software][
  A large#footnote[Small software can be rewritten from scratch.] and complex system that took years to build and even longer to debug. It has to be business critical#footnote[Bugs cannot be tolerated.], old and valuable.
]

If the software is not business critical, it can be retired or sold to someone else.

As software evolves, it becomes harder to maintain.

== The Laws

#def[S-type programs][
  *Specifiable* software: once it's implemented and tested it's finished.
]
This type of software does not evolve.


#def[P-type programs][
  *problem solving* software: it _imperfectly_ models a real world task. The acceptance can only be qualitative: "this solution is good enough". They can evolve continuously.
]
#def[E-type programs][
  *embedded* software: the solution is a part of the world, acceptance is subjective. Some people may accept it and some may not. They are inherently evolutionary.
]

=== Lehman's Laws
+ *Continuing Change*: an e-system *rots*#footnote[Becomes less useful] unless it's adapted. This process never stops. This is true for P-programs.
+ *Increasing Complexity*: an e-system becomes more complex as it evolves, unless we explicitly do something.
+ *Self Regulation*: an e-system is a self regulating process (SRP). It obeys certain statistical laws: trends and invariances. The distribution is close to normal
+ *The Work Rate is Invariant*: the activity of developers stay the same (conservation of organizational stability).
+ *Invariant Perceived Complexity*: the number of new features per release is statistically invariant (low of conservation of familiarity). Not overwhelm or bore the user.
+ *Continuing Growth*: the e-system must add new features overtime to keep the users satisfied.
+ *Declining Quality*: the perceived quality of the system declines for both the customers and the developer (unless constantly maintained).
+ *Feedback System*: an e-system evolves trough a feedback system. It can be multi-level, multi-loop or multi-agent.

== Challenges

*Cyber Physical Systems* (CPS): a view on a software system where you go beyond it just being software. It's a *feedback system* with a lot of agents that don't work on one machine, there are delays. It can be adaptive and predictive. The agents can be intelligent (human or AI). Feedback systems often work in real time, so there is a definition of time, urgency and concern on where data will be at a certain time.

*Humans* are also involved. There are ecosystems, communities, individuals. Human behavior is hard to model and to express.\
The *context* is also in the loop: consider energy consumption, carbon *footprint*, water usage and sustainability driven solutions.\
The costs must also be considered.

=== Main Challenges
/ Bit flips: especially for software that is running in space.
/ Consistency: having no contradictions.
  - Structural consistency: conform to the metamodels
  - Behavioral consistency: consistent with expected behavior
  - Conditional consistency
  - Trace/perfect equivalence
  - Inner Consistency: the artefact doesn't contradict itself
  - Outer Consistency: the contract between two or more artifacts must not be broken.\
  Some form of (in)consistency management is required.\
  For example: compute and sync views on models in model driven software engineering, maintaining GUIs in MVC, syncing data in different formats, updatable views in DBMS, (de)serialization...
/ Quality: goal-question-metric. Ask questions to achieve goals. Then on the quantitative level find some piece of data that can be used to find answer.
/ Adaptability: it's the ability of a system to adapt itself when it changes. Adaptation is critical for survival of the software and to improve it's quality. Types of adaptation:
  - Parametric: tweak parameters over time:
  - Algorithmic: choose the most appropriate algorithm:
  - Resource: reallocate utilized resources.\
  Adaptable Software Factors:
  / Extensibility: how easy it is to change the _amount_ of capabilities;
  / Flexibility: how easy it is to change the _kind_ of capabilities;
  / Tunability: how easy is it to _tweak_.
  / Fixability: if we encounter _one_ problem, how easy it is to fix it without affecting other things.\
  Kinds of adaptation:
  / trough tolerance: preserve the original behavior when a new change comes from the environment
  / trough adjustment: unchanged artifacts must sync #q(solved: false)[what does sync mean in this case?] when welcome changes occur.
