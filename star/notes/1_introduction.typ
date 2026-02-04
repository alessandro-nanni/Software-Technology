#import "_star.typ": *
#show: template
= Introduction
== Testing Basics
A test consists of a setup, operations and actions to execute the program/system, and a check to see if the expected result has been obtained.

There are different levels of testing:
- User acceptance test (#sym.arrow.t cost #sym.arrow.b execution time)
- System/end-to-end tests
- Integration tests
- Unit test (#sym.arrow.b cost #sym.arrow.t execution time)

Focus on functional testing (what the system should do).
Tests can be classified by level of automation.
- Manual testing
- Automated testing (no human running the tests)
    - Recorded tests
    - Scripted testing
    - Keyword driven testing
    - Testing as part of behavior driven development
- Model based testing: testing generation is also automated.

#figure(
    table(columns: 3)[Methodology][Definition Effort][Execution Effort][Manual testing][High][High][Automated Testing][High][Low][Model Based Testing][Low][Low],
)
Different techniques should be used for different projects. Manual testing is unavoidable in legacy systems.

== Test Driven Development
Tests are written before the code. It's a design strategy focused on the what rather than the how. Issues are actively looked for, rather than confirming expectations. The quality of the project is increased trough small incremental changes. TDD is traditionally applied in unit testing, but it's also possible to use it in integration and system tests.

Rules:
+ No code before failing test is written
+ No more tests than sufficient to fail
+ No more code than sufficient to pass tests

TDD is a discipline, design details are needed. The expected result might be unknown.

== Regression Testing
Testing after every change to the source code guarantees that nothing broke between changes. This makes the behavior of code immediately recognizable, and allows to monitor the functioning of your software system. Potential introduced errors are detected earlier (less expensive in the long term).

Regression testing should be done
- After implementing a new feature to be sure that previously implemented features still work
- After refactorings to make sure that the functionality is not affected.

Automated tests are re-executed after each change in the code through a continuous integration (CI) pipeline.
- All tests are executed automatically after every push to the repository
- Avoid merging code with failing tests on the main branch
- Prevent bugs from carrying on into other features/development cycles.

== System Testing
Systems tests are used to test functionality/behavior/features at the system level, interactions between user and system. The entire software system is treated as a sealed container. They test what the system is supposed to do, not how it is built.

There are different ways to formulate a domain logic functionality/feature.
- Feature/requirement description
- User story
#note([User Story], supplement: [ex])[
    As a \<type of user\>\
    I want \<some goal\>\
    so that \<reason\> (optional)\
]
- Behavior-driven development scenario
#note([Behavior-Driven Development (BDD)])[
    In BDD, the expected behavior of a system is defined through textual descriptions called scenarios. BDD extends agile practices and facilitates collaboration and shared understanding among roles.

    BDD scenarios are defined trough examples, focusing on user interaction. The *Given-When-Then* structured natural language (Gherkin) is used to specify and test essential use cases.

    Given #w[precondition]\
    When #w[action(s)]\
    Then #w[post-condition or resulting action]
]
- Model
- Property

BDD Pipeline:
+ Start from agile approach: choose feature/user story from the current sprint
+ Discovery: the 3 amigos meet. They brainstorm and create concrete examples
+ Formulation: write scenarios in the given-then-when style
+ Automate: create tests from scenarios

#figure(
    caption: [TDD vs BDD],
    table(columns: 3)[Feature][TDD][BDD][Focus][Code/Implementation Correctness. (White Box)][Behavior/Requirement Correctness. (Black Box)][Level][Micro: Unit level (Implementation details).][Macro: System level (User behavior).][Language][Code (Java, Python, C\#).][English/Natural Language (Given-When-Then).][Audience][Developers only.][Developers, Testers, and Product Owners.],
)

== Three Amigos
/ The Product Owner: Defines the requirements and manages the project scope.\ The Product Owner ensures the team builds the right thing by providing User Stories that are clear, valuable, and scope-limited. Instead of vague requests, they must provide specific Acceptance Criteria. This clarity prevents "scope creep" and ensures the developers and testers know exactly when a feature is considered "done."
/ The Developer: Implements the product, handles deployment, and writes technical documentation.\ The Developer ensures the requirements are technically feasible. To smooth the process, they must write code that is testable by design (e.g., adding unique IDs to UI elements so automation tools can find them). Furthermore, they bridge the gap between the English scenarios and the code by writing the "glue code" (step definitions) that allows the automated tests to actually drive the application.
/ The Tester / QA: Evaluates the product quality and identifies potential issues.\ The Tester brings a critical, "destructive" mindset to the planning phase. They improve the process by identifying edge cases and "unhappy paths" (e.g., "What if the user enters a negative number?") that the Product Owner and Developer might miss. They act as the custodian of the "Living Documentation," ensuring that the test suite remains clean, relevant, and trustworthy over time.

== Black-box Testing
/ Exploratory Testing: Explore the system, observe behavior, adjust tests on the fly based on previous results. Attempt to identify critical parts:
    - unclear requirements;
    - developed by unexperienced programmer;
    - complex code according to software metrics;
    - apply risk analysis to identify high risk code
/ Equivalence partitioning: Divide all possible inputs into a finite number of equivalence classes (partitions). An arbitrary representative is picked for each equivalence class. Choose classes that are assumed to:
    - Function analogously for inputs in the same class;
    - Have sufficient tests with one input per class
    - All cause the same fault\
    #n([Example])[
        Test a program that:
        $
            "for any" N, max in ZZ:
            "sum"(N,max) = cases(
                sum^(|n|)_(k=0) "if" sum^(|n|)_(k=0) lt.eq max,
                #raw("error") "otherwise"
            )
        $
        Equivalence classes for the inputs#footnote[These tests ensure the function handles the type and quantity of data correctly before it even tries to do the math.]:
        + Provide values for both
        + Too few or too many values
        + Integers
        + A non-integer
        + Positive values
        + Negative values
        Equivalence classes for the output#footnote[These tests ensure the logical branching inside the function works.]:
        7. Values for each of the cases
    ]
/ Boundary Value Analysis: Test inputs on, or directly above or below class boundaries. Also consider output boundaries.\ Some edge cases for $ "for any" N, max in ZZ:
    "sum"(N,max) = cases(
        sum^(|n|)_(k=0) "if" sum^(|n|)_(k=0) lt.eq max,
        #raw("error") "otherwise"
    ) $\
    - Empty sum for $N = 0$
    - Absolute value for $N = 0$, or $N = -1$
    - A value for max such that $"result" = max$, or $"result" = max + 1$
    - Integer overflow boundary
/ Random Testing: Try many random values: use random generators, used to avoid bias. It's easy to implement for numbers, more challenging for: strings, lists, trees, complicated data structures, large data files, constrained data,...
== White-box testing
This type of testing depends on the internal structure of the code and the language it is written in. The code *coverage* is measured trough test cases:
#figure(table(columns: (
        2fr,
        3fr,
        3fr,
    ))[Metric][Difficulty][What it guarantees][Statement][Low][Every executable statement was executed at least once.][Branch][Medium][Each possible outcome of a decision has been taken at least once.][Modified Decision/Decision Coverage][High][The conditions within the decision independently affect the decision outcome][Path][Extreme][Each possible execution path was covered])

== Integration Testing
Integration Testing is the phase of testing where individual software modules (which have already been unit tested) are combined and tested as a group. Component integration testing involves
/ Components: a class or set of classes;
/ Component interfaces: public methods used by other components;
/ Successful integration: component interface is used as expected by other components.
Integration testing is performed by incrementally combining components, and then test each increment with tests.

If one of the components is not implemented or is external the system, test drivers, stubs and mocks are used in its place.
The *Test Driver* calls the component under test, provides input data and collects and evaluates results. Test doubles for external components replace real, missing or external components.\ A stub is a simple actor that returns hard-coded responses, and has no decision-making logic. A mock is a more sophisticated actor that imitates the behavior of the intended component. It can make decisions, register and validate interactions.

There are different approaches to integration testing:
/ Top Down: simulates the complete application structure early on. It uses Stubs to replace missing lower-level workers
/ Bottom Up: Validates the Core Logic and Data Integrity first. It verifies that the complex calculations, database saves, and utility functions work perfectly before building a user interface around them.
/ Sandwich: use a mix of stubs/mocks and drivers
/ Big Bang: put all components together and test the whole system.

== Software Testability
Software design influences it's testability, during integration testing. A design pattern specialized for integration is *dependency injection*. Dependencies are injected in the using class. This aims to separate configuration from use, achieve separation of concerns, loose coupling, high cohesion and the flexibility needed for stubbing and mocking.

#n[Difference Between Integration and System Test][
  / Integration Testing: operates under the hood. It tests subsets of components to ensure they communicate correctly. It verifies the technical "wiring" between modules.
  / System Testing: operates at the highest level. It ignores the wiring and treats the software as a complete, sealed box. It verifies that the product as a whole delivers value to the user.
]
