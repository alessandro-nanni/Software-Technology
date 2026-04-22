#show "cobol": it => smallcaps(it)
#import "_se.typ": *
#show: template
= Level 1
== Definition
Evolution: studying software that already exists. 70% of software is maintenance. 90% of the costs of software are in maintenance. 

43% of existing banking systems are built on cobol. 200B lines of code in cobol exist. Replacement costs 25\$ per line.

#def[Maintenance][
Modification of a software project acter delivery to:
- correct faults (bug fixing)
- improve performance (50%)
- adapt the product to a modified enviornment
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
This type of software does not evolve