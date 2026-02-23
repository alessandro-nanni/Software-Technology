#import "_star.typ": *
#show: template
= Model Based Testing with Axini

Boehm's law: the cost of bugs grows exponentially with time. Most of the testing is done in the integration/acceptance test.

Model based testing is a type of black box testing. It works with expectations of what the SUT should do without having access to the source code. It has higher coverage and more automation.

The model is a reflection of the informal requirements. There is a correctness criterion between the model and the implementation, in this case it's IOCO.

Models are written in the Axini modelling language (AML). *The models are always from the perspective of the system*.

The SmartDoor code has to be memorized somewhere. Write to when lock, check when unlock.
SECLOC-07 -> quiescence (slides p.12)
