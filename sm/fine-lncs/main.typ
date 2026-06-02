#import "@preview/fine-lncs:0.6.4": author, institute, lncs, proof, theorem

#let inst_twente = institute(
  "Twente University",
  addr: "Drienerlolaan 5, 7522 NB Enschede, Netherlands",
)


#show: lncs.with(
  title: "Project Management and Software Development Techniques in Minecraft Datapack Development",
  // Alt: Adoption of GPL practices in datapack development
  running-title: "Datapack Project Management & Software Development",
  authors: (
    author(
      "Nanni Alessandro",
      insts: (inst_twente),
      oicd: "0000-1111-2222-3333",
    ),
  ),
  abstract: [
    The popular video game _Minecraft_ provides a Domain-Specific language (DSL) that allows to modify the default game behavior trough content bundles called _Datapacks_. The DSL however, has numerous syntactical and structural limitations. These shortcomings force developers to find interesting solutions to maintain an organized and scalable coding environment. Trough a primary study I understand which of the techniques the respondents apply can be validated by other literature that surveyed general purpose language (GPL) developers.
  ],
  keywords: ("Datapack", "Mcfunction", "Software Management", "Development Processes"),
  acknowledgements: [
    A bold run-in heading in small font size at the end of the paper is used for general acknowledgments #footnote([If EquinOCS, our proceedings submission system, is used, then the disclaimer can be provided directly in the system.]), for example: This study was funded by X (grant number Y).
  ],
  interests: [
    It is now necessary to declare any competing interests or to specifically state that the authors have no competing interests. Please place the statement with a bold run-in heading in small font size beneath the (optional) acknowledgments4, for example: The authors have no competing interests to declare
    that are relevant to the content of this article. Or: Author A has received research grants from Company W. Author B has received a speaker honorarium from Company X and owns stock in Company Y. Author C is a member of committee Z
  ],
  bibliography: bibliography("refs.bib"),
  // optional configuration of page (takes all page parameter)
  // page_config: (paper: "a4")
)

#show "minecraft": [_Minecraft_]

= Introduction
minecraft is a highly successful 3D sandbox game created by Markus Persson and Mojang Studios. It's set in a procedurally generated voxel world with no fixed storyline, where players are free to gather resources, build structures, and survive on their own terms. Thanks to its flexibility and massive global community, it has transcended traditional gaming to become the best-selling video game of all time and a major cultural phenomenon.

Since its early years, minecraft has included a suite of commands that allowed players to bypass standard gameplay limitations and manipulate the environment. Over a series of major updates, this rudimentary system evolved into a Turing-complete DSL. As a consequence, developers were no longer restricted to physically placing _Command Blocks_#footnote[A block that can execute a single command (https://minecraft.wiki/w/Command_Block)] within the 3D game world. Instead, utilizing external code editors, they could write structured sequences of commands into plain-text `.mcfunction` files. These script files are then organized into modular, distributable bundles known as datapacks. This transition decoupled the logic from individual world save files, unlocking the advantages of portability, version control, and formal software engineering practices."

However, despite this shift to modern development environments, the _mcfunction_ DSL still retains numerous syntactical and structural limitations. These unique shortcomings force developers to find creative solutions to maintain organized and scalable codebases. To understand how creators navigate these constraints, I conducted a primary study. Through this research, I investigate which software engineering techniques the respondents organically apply, and evaluate whether their approaches align with established literature focused on GPL developers.

While Minecraft is natively written in Java, this study focuses strictly on the game's internal DSL rather than external source code modifications, commonly known as mods. They are written in a GPL and distributed as compiled Java Archive (`.jar`) files, mods directly alter the underlying game engine. Although this traditional modding community boasts a much wider audience of developers and consumers than the datapack ecosystem, it operates entirely outside the structural constraints of the DSL. Interestingly, while Java based mods offer a technically superior and unrestricted development environment, qualitative survey data (Q24) reveals that many datapack developers actively avoid them because traditional Java coding too closely mirrors their daily professional jobs. Three respondents explicitly noted that the severe limitations of the _mcfunction_ DSL are exactly what draws them to the medium, turning the act of bypassing these constraints into a "welcome challenge".

The remainder of this paper is structured as follows:\
Chapter 2 discusses the limitations of the DSL, explaining why it doesn't feel like a high level language and what structural constraints it has.\
Chapter 3 discusses \
In chapter 4 we analyze the results of the survey \
In chapter 5 we compare the collected result with other practices devised by the academia \
Chapter 6 shines light on the conclusion \


= Theoretical Background

== Definitions

A command is the basic instruction that is capable of modifying a part of game behavior. The most powerful ones, that more closely resemble typical programming elements are:
- `scoreboard`: allows to perform arithmetic operations;
- `data`: allows to manipulate data structures;
- `execute`: allows conditional execution of commands.

A function is a file with the `.mcfunction` extension, which contains one command per line. When a function is invoked, the commands inside it are ran one after another.

A datapack is a directory containing functions and related developmental resources. Because the game engine is capable of natively loading and executing datapacks from compressed archives, this format serves as the ideal medium for sharing and distributing completed packages.

A function has it's own resource location within a datapack.
#figure(``` 
my_datapack/data/my_namespace/function/my_function.mcfunction
```,caption:[Function location path in a datapack.])
When mapped to conventional Java development paradigms, this directory hierarchy closely mirrors standard project architectures. Specifically, `my_datapack` functions as the project's root directory, `my_namespace` operates as the Java package or namespace to prevent naming collisions, and `my_function.mcfunction` acts as the individual source file.

== Weaknesses of the DSL 

Because the _mcfunction_ DSL was not initially concieved as a Turing-complete language, it still carries some limitations of it's original design of a simple way to bypass game obstacles.
At first, each command was designed to give users advantages in a specific domain of the game, unrelated to the others. For this reason, to this day, each command is strongly decoupled from the next, there is no proper way to carry context over without relying on an external data source.

This design philosophy can be seen in the command in charge of math operations, `scoreboard`. Not only is it limited to performing only the 4 basic arithmetic operations on integers, it also cannot singlehandedly compute operations that involve more than two values. In addition to that, division and multiplication don't natively support constants, so they have to be declared as variables before being used. An example that illustrates how `int x = (y*2)/4-2` is calculated in _mcfunction_ can be seen in @scoreboard_set_const.
#figure(
  ```
  # data initalization
  scoreboard objectives add math dummy
  scoreboard players set #2 math 2
  scoreboard players set #4 math 4
  # computation
  scoreboard players set $y math 10
  scoreboard players operation $y math *= #2 math
  scoreboard players operation $y math /= #4 math
  scoreboard players remove $y math 2
  scoreboard players operation $x math = $y math
  ```,
  caption: [Example with $y=10$],
)<scoreboard_set_const>

This is unusual for modern DSLs, since they are defined by having a significant amount of abstractions and high level constructs. 5 participants specifically mentioned how instead it feels like they are writing an assembly level language, such as the snippet reported in @asm-ex.
#figure(
  ```asm
  mov eax, 10  ; eax = 10
  mov ebx, eax ; ebx = eax

  add eax, ebx ; eax += ebx
  sub eax, ebx ; eax -= ebx
  mul eax, ebx ; eax *= ebx
  div eax, ebx ; eax /= ebx
  ```,
  caption: [Assignment and operations in Assembly x86.],
)<asm-ex>

As previously mentioned, DSL lacks traditional local variables, so developers must utilize external data sources to pass information between commands. These sources can either be tangible, world-specific objects like blocks and entities#footnote[Entities refer to any moving or dynamic object not restricted to the block grid (https://minecraft.wiki/w/Entity).], or purely virtual data structures maintained entirely in the game's memory. In either case, the data is structured as Named Binary Tags (NBT#footnote[https://minecraft.wiki/w/NBT_format]). This type of data can be stringified and manually edited by developers as SNBT. It's structure is quite similar to that of a JSON object, albeit without the double quotes between the pair's key.

#figure(
  grid(
    columns: 2,
    grid.cell(
      ```
      {
          IsActive: 1b,
          Score: 1500,
          Name: "PlayerOne",
          Coordinates: [
            10.5d,
            64.0d,
            -22.3d
            ],
          Inventory: {
              Coins: 50,
              Keys: 2b
          }
      }```,
      inset: (right: 10pt),
    ),
    grid.vline(stroke: 0.5pt, x: 1),
    grid.cell(
      ```c
      struct Inventory {
          int32_t Coins;
          int8_t Keys;
      };

      struct PlayerData {
          bool IsActive;
          int32_t Score;
          char Name[16];
          double Coordinates[3];
          struct Inventory Inventory;
      };
      ```,
      inset: (left: 10pt),
    ),
  ),
  caption: [SNBT and C structures compared.],
)

With the mechanics of computation and data manipulation detailed, the final essential characteristic of a traditional programming language to address is control flow.

At the time of writing, the Minecraft DSL lacks native support for traditional block-level control flow structures, such as `if-else` statements or iterative loops, within a single `.mcfunction` file. Consequently, developers must emulate looping behavior through recursive function calls.
#figure(```
## Contents of function loop.mcfunction ##

# decrease $count by 1
scoreboard players remove $count temp 1
# Invoke the function again if $count >=1
execute if score $count temp matches 1.. run function loop 

```,caption:[_mcfunction_ code to run a function a `$count` amount of times.]) <recursion-ex>


While the example in @recursion-ex illustrates a basic loop, real-world scenarios usually involve additional commands that run before or after the loop and must not be repeated. For this reason, the iterative block must be extracted into an entirely separate function file. This necessity severely complicates the development experience. Given how fundamental iteration is for tasks like traversing arrays, function approximation algorithms, having to create a new physical file every single time a loop is required adds massive management overhead to the project.
Furthermore, each individual branch of an `if-else` construct must reside in its own distinct function file. This is because the execute if command only supports the conditional execution of a single instruction. Therefore, if developers need to run multiple commands under the same condition, those commands must be grouped together and called via a separate function.



= Related works
// what methodologies were used to gather this type of data in other fields
= Survey Details and Results
== Preparation Processes
The Goal-Question-Metric approach was used to devise questions for the survey.

_G1: Get background context for those who typically develop datapacks._\
Q1: How old are you (optional)? #sym.arrow Short answer.\
Q2: Indicate your level of experience in the domain of datapack development. #sym.arrow Linear scale.\
Q3: How many datapacks have you released? #sym.arrow  Short Answer.\
Q4: Indicate your familiarity with computer programming outside of minecraft datapacks. #sym.arrow Linear Scale.\
Q5: How often do you develop datapacks as a hobby (with no financial compensation)? #sym.arrow Linear Scale.\
Q6: How often do you develop datapacks for financial compensation (for other people)? #sym.arrow Linear Scale.

_G2: Identify software development processes and tools datapack developers utilize._\
Q7: Which code editor(s) do you use? (select all the apply) #sym.arrow Checkbox.\
Q8: Which productivity features from your code editor do you value? (select all that apply and are present in your code editor) #sym.arrow Checkbox.\
Q9: Do you use a precompiler or external scripts to automate file generation? #sym.arrow Multiple Choice.\
Q10: How often do you rely on libraries (player motion, string uuid, floating point math...) written by others? #sym.arrow Linear Scale.\
Q11: How often do you use LLMs (AI chatbots, agentic coding) to write datapack code? #sym.arrow Linear Scale.

_G3: Assess which software project management techniques are applied by datapack developers._\
Q12: How many people do you usually work with in datapack development (excluding yourself)? #sym.arrow Short answer.\
Q13: Indicate which features from a formal version control system (such as Git) you use to manage your codebase and track changes? (leave blank if none apply) #sym.arrow Checkbox.\
Q14: Do you release your datapacks in cycles (iteratively, excluding beta tests), or do you release them only once they are ready? #sym.arrow Linear scale.\
Q15: If you work in a group, what type of software development process do you use? (leave blank if you work alone) #sym.arrow Multiple choice.

_G4: Assess if datapack developers focus code quality and project maintainability._\
Q16: How often do you comment your code? #sym.arrow Linear scale. \
Q17: If you comment, how much do you comment your code? #sym.arrow.\
Q18: How many beta testers test your code quality and project functionality before release? #sym.arrow Short answer.\
Q19: On average, how long do you spend maintaining a datapack (fixing bugs, updating to new Minecraft versions) after its initial release? #sym.arrow Multiple choice.\
Q20: Estimate the percentage of time optimization/refactoring consumes in your overall datapack development process. #sym.arrow Short answer.\
Q21: To which coding conventions to you adhere to? (select all that apply) #sym.arrow Checkbox\
Q22: How do you track and manage bugs or feature requests from your users (e.g., GitHub Issues, Discord channels, informal feedback)? #sym.arrow Multiple choice.

Two optional open questions were made available.\
Q23: Open space for additional comments on methodologies, software processes,...
Q24: Open space for comments on what aspect of developing datapacks you dislike the most.

== Data Analysis
== Threats to Validity
This section discusses potential validity threats to
this study and how they will be mitigated.

*Internal Validity*. To ensure internal validity
the following measures have been taken:
- To reduce the amount of data processing after gathering the results, many questions asked participants to select from predefined choices rather than writing open ended answers. However, they still had the option to type a custom response if their preferred answer was not listed.
- In Q23, three participants commented that they would have liked more questions to be checkboxes rather than multiple choice, since not always one option excluded the others. However, this doesn't mean that the data gathered for these users is wrong or unusable, just incomplete.
- Social Desirability Bias: Developers know they should comment their code, use Git, and adhere to coding conventions#footnote[Additionally, the use of LLMs to generate code is seen as bad practice since it doesn't produce valid syntax and takes the fun out of what is generally seen as a passion project.]. Therefore, it is likely that Q11, Q13, Q16 and Q21 are skewed towards the "good" choices since the participants want to appear professional.

*External Validity*. To ensure internal validity
the following measures have been taken:
- The survey was undertaken by members of online communities specialized in the development of datapacks. This made the risk of getting empty or incomplete forms significantly low, with only one participant commenting that they felt like an outlier while completing the form.
- Selection Bias: The people who choose to voluntarily fill out this specific type of survey are different from those who ignore it. The datapack community has people ranging from 12 year old newcomers, to 30 year olds that do this type of development professionally. Our results are heavily skewed toward the "hardcore," professional side of the community. Therefore, your findings will have high external validity for dedicated datapack developers. However, this can be considered beneficial for the survey since it will include substantial answers from people with a significative amount of experience in the field.
- Temporal Validity: The syntax and capabilities of the _mcfunction_ DSL are constantly changing. It may very well be that in the upcoming years most of the complaints, tools and processes will change based on the language's updates.

// what information does the survey give us (profiles, techniques,...), result description
= Discussion
// results contextualized with other papers
= Conclusion
// including future developments

For citations of references, we prefer the use of square brackets and consecutive numbers. Citations using labels or the author/year convention are also acceptable. The following bibliography provides a sample reference list with entries for journal articles @PAPER:1, a book @BOOK:2, and a homepage @WEBSITE:1. Multiple citations are grouped @BOOK:2@ARTICLE:1@BOOK:1.
