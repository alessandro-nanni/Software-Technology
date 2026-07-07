#import "@preview/fine-lncs:0.6.4": author, institute, lncs
#let inst_twente = institute(
  "Twente University",
  addr: "Drienerlolaan 5, 7522 NB Enschede, Netherlands",
)

#show: lncs.with(
  title: "A Primary Study of Software Management Practices in Minecraft's DSL",
  running-title: "Minecraft DSL Software Management",
  authors: (
    author(
      "Nanni Alessandro",
      insts: (inst_twente),
    ),
  ),
  abstract: [
    The popular video game _Minecraft_ features an internal domain specific language (DSL) that allows developers to modify the game's default behavior through content bundles called _Datapacks_. Minecraft's DSL, however, has numerous syntactical and structural limitations. These shortcomings force developers to find creative solutions to maintain an organized and scalable codebase. Through a primary study, I surveyed datapack developers to identify which software project management and development techniques they organically adopt, and evaluate whether these techniques align with established literature on general purpose language (GPL) and end user software engineering (EUSE) developers.
  ],
  keywords: ("Datapack", "Domain Specific Language", "End User Software Engineering", "Software Project Management", "Primary Study"),
  acknowledgements: [
    I would like to thank the domain experts who participated in the pilot phase of this study for their invaluable feedback in refining the survey questions. I also extend my gratitude to the members of the Minecraft datapack development community who generously volunteered their time to participate in this research.

    Generative AI (Gemini 3.5) was used to generate python scripts that were ran to visualize and analyze gathered data. Specifically @avg-responses, @dp-distr, and the hypothesis testing figures (@h1-techniques, @h2-zero-released, @h3-released-experience, @h4-commenting, @h5-refactor-cycle, @h6-experience-abstraction, @h7-compensation). It was used as well to rewrite sections of the paper to give it a more academic tone.
  ],
  interests: [
    I am an active participant in the Minecraft datapack community. However, this affiliation did not influence the data collection or analysis processes. I declare no competing financial interests.
  ],
  bibliography: bibliography("refs.bib"),
)

#show "minecraft": [_Minecraft_]

= Introduction
Minecraft is a highly successful 3D sandbox game created by Markus Persson and Mojang Studios. It is set in a procedurally generated voxel world with no fixed storyline, where players are free to gather resources, build structures, and survive on their own terms. Thanks to its flexibility and a massive global community, it has transcended traditional gaming to become the best selling video game of all time and a major cultural phenomenon.

Since its early years, Minecraft has included a suite of commands that allowed players to bypass standard gameplay limitations and manipulate the environment. Over a series of major updates, this rudimentary system evolved into a Turing complete DSL. As a consequence, developers were no longer restricted to physically placing _Command Blocks_#footnote[A block that can execute a single command (https://minecraft.wiki/w/Command_Block)] within the 3D game world. Instead, using external code editors, they could write structured sequences of commands into plain text `.mcfunction` files. These script files are then organized into modular, distributable bundles known as datapacks. This transition decoupled the logic from individual world save files, unlocking the advantages of portability, version control, and formal software engineering practices.

However, despite this shift to modern development environments, the _mcfunction_ DSL still retains numerous syntactical and structural limitations. These unique shortcomings force developers to find creative solutions to maintain organized and scalable codebases. To understand how creators navigate these constraints, I conducted a primary study. Through this research, I investigate which software engineering techniques the respondents organically apply, and evaluate whether their approaches align with established literature focused on GPL and EUSE#footnote[EUSE is a software engineering paradigm designed specifically for individuals who write code primarily to achieve a personal task or to support their own domain of expertise, rather than to produce software for public or commercial distribution.] developers.

While Minecraft is natively written in Java, this study focuses strictly on the game's internal DSL rather than external source code modifications, commonly known as mods. Because mods are written in a GPL and distributed as compiled Java Archive (`.jar`) files, they directly alter the underlying game engine. Although this traditional modding community boasts a much wider audience of developers and consumers than the datapack ecosystem, it operates entirely outside the structural constraints of the DSL. Interestingly, while mods written in Java offer a technically superior and unrestricted development environment, qualitative survey data (Q24) reveals that many datapack developers actively avoid them because traditional Java coding too closely mirrors their daily professional jobs. Three respondents explicitly noted that the severe limitations of the _mcfunction_ DSL are exactly what draws them to the medium, turning the act of bypassing these constraints into a "welcome challenge".

The remainder of this paper is structured as follows. Section 2 provides the theoretical background of the Minecraft DSL, detailing its syntactical limitations and structural constraints. Section 3 reviews related literature in DSL usability, video game development, and end user software engineering. Section 4 presents the survey methodology and descriptive results. In Section 5, I discuss these findings by contrasting them against established academic paradigms and performing a quantitative analysis of my research hypotheses. Finally, Section 6 concludes the paper.


= Theoretical Background

== An Overview of DSLs

To contextualize the constraints of the Minecraft _mcfunction_ environment, it is crucial to first understand DSLs in general. A DSL is a programming language tailored to a specific application domain, designed to offer substantial gains in expressiveness and ease of use compared to GPLs @KOSAR201677#footnote[Identified via the systematic literature search and selection protocol described in @lit-selection]. DSLs are foundational to modern software methodologies like Generative Programming#footnote[An approach that automates the creation of program variants from reusable, configurable components, reducing the effort of writing each similar piece of software by hand.], Software Factories#footnote[An approach that combines DSLs, templates, and design patterns into an assembly line-like process for producing a specific family of software products, analogous to how a physical factory mass-produces configurable goods.], and Model Driven Engineering#footnote[A methodology in which high-level models, rather than hand-written code, serve as the primary development artifact, with concrete implementations automatically generated from these models.] @KOSAR201677.

When evaluating a DSL in practice, researchers look at specific success factors: reliability, usability, productivity, learnability, expressiveness, and reusability @hermans2009#footnote[Also identified via the search protocol described in @lit-selection]. For instance, industrial use of DSLs has been shown to successfully automate trivial tasks, significantly reduce time to market, and improve software maintainability @hermans2009. However, systematic mapping studies reveal a gap in the literature: while the DSL community heavily focuses on developing new implementation techniques, there is a distinct lack of rigorous empirical evaluation, validation, and maintenance research @KOSAR201677. By surveying actual datapack developers, my study aims to address this empirical gap. The Minecraft DSL presents a unique case because it organically evolved from simple console commands into a Turing complete language, yet it still forces developers to rely on external workarounds due to its lack of high level constructs and traditional control flow.

== Definitions

A *command* is the basic instruction that is capable of modifying a part of game behavior. The most powerful ones, that more closely resemble typical programming elements are:
- `scoreboard`: allows to perform arithmetic operations;
- `data`: allows to manipulate data structures;
- `execute`: allows conditional execution of commands.

A function is a file with the `.mcfunction` extension, which contains one command per line. When a function is invoked, the commands inside it are ran one after another.

A datapack is a directory containing functions and related developmental resources. Because the game engine is capable of natively loading and executing datapacks from compressed archives, this format serves as the ideal medium for sharing and distributing completed packages.

A function has its own resource location within a datapack.
#figure(
  ```
  my_datapack/data/my_namespace/function/my_function.mcfunction
  ```,
  caption: [Function location path in a datapack.],
)
When mapped to conventional Java development paradigms, this directory hierarchy closely mirrors standard project architectures. Specifically, `my_datapack` functions as the project's root directory, `my_namespace` operates as the Java package or namespace to prevent naming collisions, and `my_function.mcfunction` acts as the individual source file.

== Weaknesses of the DSL

Because the _mcfunction_ DSL was not initially conceived as a Turing complete language, it still carries some limitations from its original design as a simple way to bypass gameplay obstacles.
At first, each command was designed to give users advantages in a specific domain of the game, unrelated to the others. For this reason, to this day, each command is strongly decoupled from the next, there is no proper way to carry context over without relying on an external data source.

To precisely characterize these limitations, the remainder of this section borrows terminology from the Cognitive Dimensions of Notations (CDN) framework#footnote[A collection of properties, such as Viscosity, Diffuseness, and Hidden Dependencies, used to evaluate and compare the usability of any notational system, textual or otherwise, independently of its specific domain.], which Albuquerque et al. instantiated into a quantitative metric suite for evaluating DSL usability during software maintenance @ALBUQUERQUE2015#footnote[Likewise identified via the search protocol described in @lit-selection].

This design philosophy can be seen in the command in charge of math operations, `scoreboard`. Not only is it limited to performing only the 4 basic arithmetic operations on integers, it also cannot singlehandedly compute operations that involve more than two values. In addition to that, division and multiplication don't natively support constants, so they have to be declared as variables#footnote[By convention, community members typically prefix fake player names representing variables with `$` and those representing constants with `#`, as seen in the figure below; neither symbol carries any special meaning to the game engine itself.] before being used. This is a clear case of high Viscosity, the resistance a notation offers to small changes, since altering a single constant requires editing multiple statements spread across the file rather than a single value @ALBUQUERQUE2015. An example that illustrates how `int x = (y*2)/4-2` is calculated in _mcfunction_ can be seen in @scoreboard_set_const.
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

As previously mentioned, the _mcfunction_ DSL lacks traditional local variables, so developers must utilize external data sources to pass information between commands. These sources can either be tangible, world specific objects like blocks and entities#footnote[Entities refer to any moving or dynamic object not restricted to the block grid (https://minecraft.wiki/w/Entity).], or purely virtual data structures maintained entirely in the game's memory. In either case, the data is structured as Named Binary Tags (NBT#footnote[https://minecraft.wiki/w/NBT_format]). This type of data can be stringified and manually edited by developers as SNBT. Its structure is quite similar to that of a JSON object, but without double quotes surrounding the keys. Because context is carried through blocks, entities, or scoreboards rather than through the command sequence itself, the relations between a command and the state it depends on are not visible in the code. This is a clear case of high Hidden Dependencies, the extent to which relations between entities are not visible directly in the notation itself @ALBUQUERQUE2015.

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

At the time of writing, the Minecraft DSL lacks native support for traditional block level control flow structures, such as `if-else` statements or iterative loops, within a single `.mcfunction` file. Consequently, developers must emulate looping behavior through recursive function calls.
#figure(
  ```
  ## Contents of function loop.mcfunction ##

  # decrease $count by 1
  scoreboard players remove $count temp 1
  # Invoke the function again if $count >=1
  execute if score $count temp matches 1.. run function loop

  ```,
  caption: [_mcfunction_ code to run a function a `$count` amount of times.],
) <recursion-ex>


While the example in @recursion-ex illustrates a basic loop, real world scenarios usually involve additional commands that run before or after the loop and must not be repeated. For this reason, the iterative block must be extracted into an entirely separate function file. This necessity severely complicates the development experience. Given how fundamental iteration is for tasks like traversing arrays or implementing function approximation algorithms, having to create a new physical file every single time a loop is required adds massive management overhead to the project.
Furthermore, each individual branch of an `if-else` construct must reside in its own distinct function file. This is because the `execute if` command only supports the conditional execution of a single instruction. Therefore, if developers need to run multiple commands under the same condition, those commands must be grouped together and called via a separate function. This forced fragmentation exemplifies Diffuseness, since expressing a single logical unit, whether a loop or a conditional branch, demands far more symbols and physical files than an equivalent construct in a GPL with native control flow @ALBUQUERQUE2015.

== High Risk of Incompatibility

Previously namespaces were mentioned as a means to avoid naming collisions. However, creating files (functions) in different namespaces doesn't guarantee conflicts in other aspects of the datapack.
#quote(
  block: true,
  attribution: [Nathan Adams#footnote[Minecraft developer, part of the team that develops datapack related features.]],
  [This isn't a new concept, but I thought I should reiterate what a "namespace" is. Most things in the game has a namespace, so that if we add `something` and a mod (or map, or whatever) adds `something`, they're both different `something`s. Whenever you're asked to name something, for example a loot table, you're expected to also provide what namespace that thing comes from. If you don't specify the namespace, we default to `minecraft`. This means that `something` and `minecraft:something` are the same thing.],
)
Since there is no datapack specific or local scope for variables (`scoreboard`s), every defined `scoreboard` must be declared with a namespace prefix (e.g. `foo.math`), to prevent collisions with other scoreboards called `math`. The same concept applies to `tag`s, which are a means to identify a game entity or item as "belonging" or "being used" by a certain datapack. Tags are commonly used inside of target selectors#footnote[A selector, such as `@e` (all entities) or `@a` (all players), is a query that resolves to the set of entities matching the criteria placed within its square brackets, such as `type` or `tag`.], as shown below.
#figure(
  ```
  # datapack foo:
  execute as @e[type=cat,tag=foo.entity] run function foo:my_entity

  # datapack bar:
  execute as @e[type=cat,tag=bar.entity] run function bar:my_entity
  ```,
  caption: [Example on how namespaces are used in tags to differentiate entities used in two separate datapacks. ],
)

In conclusion, simply working in a separate folder isn't enough to guarantee compatibility with other datapacks.

= Related Works

== Selection and Overview of Reference Literature <lit-selection>

Due to the complete absence of prior scientific literature focusing specifically on Minecraft datapack development, reference papers were systematically selected from broader software engineering research areas. To ensure a reproducible and unbiased selection process, I adapted the systematic literature review protocol proposed by Kitchenham and Charters @kitchenham2007, scoping their guidelines to the needs of a focused background review rather than an exhaustive SLR. A search was conducted across digital databases (including Google Scholar, the ACM Digital Library, IEEE Xplore, ScienceDirect, and SpringerLink) using combinations of search terms such as: "DSL usability evaluation", "indie game QA practices", "end user programming", "hobbyist developer productivity", and terms targeting empirical "surveys" or "primary studies".

Candidate papers were then screened against two inclusion criteria (IC) and one exclusion criterion (EC), defined in advance to keep the selection process reproducible and aligned with my research goals.

- *IC1*: The study presents a survey design, instrument, or evaluation metric adaptable to my own primary study. This encompasses empirical research surveying independent and traditional video game development practices, software engineering methodologies across different domains, and productivity factors in both corporate and open source environments. It also includes empirical user studies and controlled experiments that specifically evaluated DSL success factors and developer comprehension.
- *IC2*: The study establishes metrics for evaluating software processes in informal or constrained environments. This includes literature detailing metrics for quantifying DSL usability and complexity, as well as frameworks for analyzing testing, continuous integration, and Agile project management in unconventional or end user software engineering (EUSE) environments.
- *EC1*: Studies focusing solely on compiler construction, formal grammar theory, or programming language specifications were excluded, since these highly technical implementation studies lack adaptable empirical methods or process metrics. As highlighted by a systematic mapping study of the DSL domain, the vast majority of DSL literature falls into this category, with only a small fraction (under 15%) dedicated to empirical evaluation or measurement.

Applying these criteria yielded a final group of thirteen core papers, structured around three thematic pillars to establish my methodological framework:

1. *Domain Specific Languages (DSLs) Usability and Mapping*: Because Minecraft's `mcfunction` is an internal DSL embedded within a game engine, I required frameworks to evaluate how its severe language constraints impact developer experience. Papers addressing DSL usability measurement, success factors, and mapping studies were selected. Specifically, Kosar et al. @KOSAR201677 is used to address the literature gap regarding empirical DSL evaluation; Albuquerque et al. @ALBUQUERQUE2015 provides a framework for quantifying usability and maintainability; and Hermans et al. @hermans2009 provides a model for mapping survey questions to subjective success factors.
2. *Video Game Development and Quality Assurance*: Datapack development is inherently a creative endeavor with practices akin to game development. Thus, I selected research focusing on indie and unconventional software development environments, which often suffer from unstructured processes and improvised testing. Musil et al. @musil2010 provides a baseline for evaluating the state of practice in video games; Cho et al. @cho2023 offers validated methodologies for studying quality assurance in indie/hobbyist contexts; and Viggiato et al. @viggiato2019 helps analyze how development and integration practices vary across creative domains.
3. *End User Software Engineering (EUSE) and Project Management*: Since most datapack developers are hobbyists without formal programming training or corporate contracts, I must model their work using paradigms tailored to informal environments. I selected studies on how non professional programmers build and debug software (Ko et al. @ko_state_2011, Burnett et al. @burnett_2004), how Agile and Continuous Integration (CI) scale down to small or hobbyist teams (Noteboom et al. @noteboom_agile_2021, Chen et al. @chen_continuous_2025, Banker et al. @banker_software_1998), and how metrics apply to corporate versus open source environments (McGuire @mcguire1996, Canedo et al. @canedo2019).

== Empirical Survey Methodologies in Related Literature

In designing my survey, I analyzed how other researchers evaluate software engineering in niche or creative domains. To ensure my data serves a measurable purpose, I am adopting the Goal-Question-Metric (GQM) framework, a structured approach that prevents the collection of irrelevant data by mapping every question to a specific objective. This methodology was successfully used by Musil et al. to assess the state of the practice and identify ad-hoc processes in the video game industry @musil2010.

When constructing survey instruments, researchers carefully utilize targeted metrics. For instance, Hermans et al. evaluated a commercial DSL by mapping survey questions directly to DSL success factors using 5-point Likert scales @hermans2009. Similarly, Cho et al. utilized Likert scale prompts combined with qualitative open ended questions to identify differences between indie and non indie game testing practices, noting that indie developers often lack formal testing plans @cho2023. 
Viggiato et al. extended this approach to surveying across multiple domains, conducting interviews and web surveys to discover that development practices are highly context dependent; for example, financial and e-commerce domains frequently interrupt Continuous Integration (CI) during critical periods like Black Friday @viggiato2019.

Finally, deploying an effective survey requires a rigorous validation phase. Cho et al. tested their survey with diverse game developers and conducted debriefing interviews to refine the flow and phrasing before wide deployment @cho2023.

== Empirical Surveys in Software Houses

While datapack creation shares many characteristics with independent and unstructured game development, my study also aims to evaluate formal project management and software engineering practices. To do this effectively, I examined how empirical surveys are conducted within corporate software houses where structured development processes are critical.

In traditional corporate environments, researchers frequently utilize surveys to measure an organization's structural maturity and project management efficacy. For example, McGuire surveyed 64 software development professionals within a large, multinational organization to assess their transition from a chaotic, "ad hoc" development environment, classified as Level 1 in the Capability Maturity Model (CMM), to a structured, repeatable process @mcguire1996.
To efficiently collect this data, McGuire utilized 5-point Likert-scale surveys covering 79 distinct factors across categories like project management, teamwork, change management, and quality focus @mcguire1996. While McGuire noted that Likert scales are inherently limited to capturing subjective perceptions rather than objective facts, they remain a highly effective means of quickly gathering data and revealing overarching trends in developer thinking @mcguire1996. I apply this same principle in my primary study: using linear scales to gauge datapack developers' perceptions of their own process maturity, even if their coding environment fundamentally lacks corporate structure.

To complement this rigid corporate perspective, I also examined how modern surveys measure productivity in flexible environments without formal contracts. Canedo et al. conducted an empirical study combining a systematic literature review with an online survey of software practitioners to evaluate 37 different factors that influence team productivity @canedo2019. Similarly to Hermans et al., they heavily relied on closed questions using 5-point Likert scales to capture the opinions of the developers.

Canedo et al. specifically analyzed open source projects, finding that the "lack of contractual relationships" in these communities can actually improve productivity by freeing contributors from administrative overhead, allowing them to spend their time directly on development @canedo2019. This finding strongly parallels the core environment of my primary study: Minecraft datapack developers operate entirely outside of corporate contracts, driven by community engagement and personal motivation rather than formal employment @canedo2019.

By combining the maturity metrics used by McGuire to evaluate professional software houses with the open source productivity factors explored by Canedo et al. and the survey designs used in indie game development, I believe my questionnaire is able to capture all aspects of the datapack engineering experience.

= Survey Details and Results

== My Proposed Survey Preparation Process

Drawing from these established methodologies, I have designed a survey preparation process tailored specifically to the Minecraft datapack community:

/ Phase 1: Defining Goals via GQM. I established four primary goals for my research: (G1) characterizing the demographic profile of the developers, (G2) assessing software development processes and tooling, (G3) evaluating project management techniques, and (G4) analyzing quality assurance practices.
/ Phase 2: Adapting DSL and Game Dev Metrics. To capture the unique constraints of the `mcfunction` DSL, I incorporated metrics based on known DSL success factors, such as the usability of external tooling @hermans2009 and the expressiveness and conciseness of the code, the two usability characteristics Albuquerque et al. identify as central to a DSL's design @ALBUQUERQUE2015. Because datapack creation shares similarities with the chaotic, unstructured testing approaches commonly seen in independent game development @cho2023, relying solely on predefined checkboxes and linear scales is insufficient. To capture the highly unconventional and improvised practices of these creative environments, the survey incorporates an "Other" field into these questions. This ensures that respondents have the option to write in a custom response if their specific methods are not available in the predefined choices.
/ Phase 3: Testing and Piloting. Inspired by empirical practices, my questionnaire underwent a review and piloting phase. This ensured that questions regarding tools and standard practices were interpreted correctly by the respondents @cho2023. Before making the survey public, a small group of domain experts completed the survey and provided feedback that helped make the questions clearer for a broader audience.
/ Phase 4: Execution and Community Targeting. I distributed the survey within specialized online datapack communities. While this introduces a selection bias toward more "hardcore" or professional hobbyists, it ensures high external validity, providing me with substantial answers from dedicated developers who actively interact with the DSL's limitations and workarounds.

== Goal-Question-Metric
_G1: Get background context for those who typically develop datapacks._\
Q1: How old are you (optional)? #sym.arrow Short answer.\
Q2: Indicate your level of experience in the domain of datapack development. #sym.arrow Linear scale.\
Q3: How many datapacks have you released? #sym.arrow Short answer.\
Q4: Indicate your familiarity with computer programming outside of Minecraft datapacks. #sym.arrow Linear scale.\
Q5: How often do you develop datapacks as a hobby (with no financial compensation)? #sym.arrow Linear scale.\
Q6: How often do you develop datapacks for financial compensation (for other people)? #sym.arrow Linear scale.

_G2: Identify software development processes and tools datapack developers utilize._\
Q7: Which code editor(s) do you use? (select all that apply) #sym.arrow Checkbox.\
Q8: Which productivity features from your code editor do you value? (select all that apply and are present in your code editor) #sym.arrow Checkbox.\
Q9: Do you use a precompiler or external scripts to automate file generation? #sym.arrow Multiple choice.\
Q10: How often do you rely on libraries (player motion, string uuid, floating point math...) written by others? #sym.arrow Linear scale.\
Q11: How often do you use LLMs (AI chatbots, agentic coding) to write datapack code? #sym.arrow Linear scale.

_G3: Assess which software project management techniques are applied by datapack developers._\
Q12: How many people do you usually work with in datapack development (excluding yourself)? #sym.arrow Short answer.\
Q13: Indicate which features from a formal version control system (such as Git) you use to manage your codebase and track changes? (leave blank if none apply) #sym.arrow Checkbox.\
Q14: Do you release your datapacks in cycles (iteratively, excluding beta tests), or do you release them only once they are ready? #sym.arrow Linear scale.\
Q15: If you work in a group, what type of software development process do you use? (leave blank if you work alone) #sym.arrow Multiple choice.

_G4: Assess if datapack developers focus on code quality and project maintainability._\
Q16: How often do you comment your code? #sym.arrow Linear scale. \
Q17: If you comment, how much do you comment your code? #sym.arrow Linear scale.\
Q18: How many beta testers test your code quality and project functionality before release? #sym.arrow Short answer.\
Q19: On average, how long do you spend maintaining a datapack (fixing bugs, updating to new Minecraft versions) after its initial release? #sym.arrow Multiple choice.\
Q20: Estimate the percentage of time optimization/refactoring consumes in your overall datapack development process. #sym.arrow Short answer.\
Q21: To which coding conventions do you adhere to? (select all that apply) #sym.arrow Checkbox.\
Q22: How do you track and manage bugs or feature requests from your users (e.g., GitHub Issues, Discord channels, informal feedback)? #sym.arrow Multiple choice.

Two optional open questions were made available.\
Q23: Open space for additional comments on methodologies, software processes,...
Q24: Open space for comments on what aspect of developing datapacks you dislike the most.

== Data Analysis

Before interpreting the implications of the survey responses, it is standard empirical practice to first conduct a basic evaluation using descriptive statistics to present the most interesting aspects of the dataset @musil2010. In this section, my main objective is to report the gathered data exactly as it is, establishing a clear, factual foundation of the datapack community's demographics, habits, and methodologies.

Following the structured methodologies seen in related DSL and software engineering studies, this section is dedicated to presenting the quantitative and qualitative data obtained from the respondents. Therefore, I will not be comparing these results against other domains here. Instead, the comparative analysis where I contextualize these findings against the established literature on general purpose languages, independent game development, and formal DSL practices will be entirely delegated to the subsequent @discussion_ch @ALBUQUERQUE2015 @cho2023.

It's immediately noticeable how most of the respondents consider themselves very experienced in both datapack and broader computer programming (Q2 & Q4). This helps guarantee the overall validity of the survey, since the answers provided will be backed up by concrete experience within the domain of the Minecraft DSL as well as other GPLs.

On average, respondents reported releasing $M=7.85$ datapacks ($"SD"=12.59$). However, the median number of releases was considerably lower at $"Mdn"=5.0$. While the typical developer has contributed a modest number of projects, a minority of highly prolific contributors is present within the ecosystem, with the absolute maximum reaching 86 released datapacks. These extreme outliers are primarily responsible for pulling the sample mean significantly higher than the median. It is important to note, however, that this metric does not account for the size or complexity of individual datapacks. Therefore, it is highly likely that analyzing the average lines of code or overall development effort would yield a considerably different distribution.

#figure(
  image("process/stats_plot.png"),
  caption: [Distribution of the number of released Minecraft datapacks among surveyed developers (N=97). (A) Histogram showing response frequency. (B) Boxplot illustrating the median, interquartile range, and extreme outliers.],
) <dp-distr>

In response to Q7, almost 90% of the participants have claimed to use Visual Studio Code with datapack specific extensions#footnote[#link("https://marketplace.visualstudio.com/items?itemName=SPGoding.datapack-language-server")]. This is an expected outcome since it's the tool that most closely resembles an IDE for datapack development, with Q8 highlighting that all of its core features are used.

#figure(
  table(
    columns: 2,
    table.hline(),
    [*Percentage*], [*Feature*], table.hline(),
    [91.8%], [Syntax highlighting], table.hline(),
    [78.4%], [Syntax validation], table.hline(),
    [64.9%], [Code completion], table.hline(),
    [40.2%], [Missing resource creation], table.hline(),
    [3%], [Resource jumping#footnote[The ability to press `ctrl+click` to open in a new tab the used resource as if it were a hyperlink.]], table.hline(),
  ),
  caption: [The most reported valued code editor functionalities (Q8).
  ],
)

When examining coding practices (Q9), the data reveals that a slight majority of the developers (50.5%) does not rely solely on plain mcfunction. They improve their workflows by using GPLs (18.6%) for metacompilation or running custom scripts (32%) to generate repetitive boilerplate.

Regarding version control system usage (Q13), the survey indicates a strong adoption of Git features.

#figure(
  table(
    columns: 2,
    table.hline(),
    [*Percentage*], [*Feature*], table.hline(),
    [89.7%], [Code recovery and storage], table.hline(),
    [80.5%], [Access previous versions of the codebase], table.hline(),
    [55.2%], [Release artifact hosting], table.hline(),
    [54%], [Bug and issue tracking], table.hline(),
    [49.4%], [Use branches], table.hline(),
    [34.5%], [Wiki hosting], table.hline(),
    [25.3%], [CI/CD pipeline hosting], table.hline(),
    [5.7%], [Project board usage], table.hline(),
  ),
  caption: [The most reported used version control system features (Q13).
  ],
) <git-features>

In response to Q15, more than half (55.8%) of the people that work in groups don't have a structured development process. No one claimed to use Scrum, and only two respondents use extreme programming.

With regard to coding conventions (Q21), 81.4% of the respondents claimed to use different namespaces, and 48.5% also use the more advanced _Smithed_ conventions#footnote[Smithed is a community-maintained set of naming and structural conventions, along with a library ecosystem, for datapack development (https://docs.smithed.dev/index.html).]. Six users stated that they don't know what coding conventions are or that they don't use them. Two responses also mentioned the use of IMP-doc, a comment convention similar to Javadoc, but applied to datapack functions.

When asked about their habits for bug tracking and feature requests (Q22), two out of three claimed to use informal methods such as Discord channels, and 52.6% used GitHub issues.

To analyze the open ended feedback from Q23 and Q24, I employed Reflexive Thematic Analysis (RTA)#footnote[A qualitative coding method in which the researcher iteratively identifies patterns across the data without a fixed, predefined codebook, treating their own interpretive judgment as an explicit part of the analysis rather than a source of bias to be eliminated.] to systematically code the responses @cho2023. These responses were then gathered into overarching themes representing the most common concepts expressed by the developers.

#figure(
  table(
    columns: 2,
    align: left + bottom,
    table.hline(),
    [*Occurrences*], [*Concept*],
    table.hline(),
    [6],
    [Add lots of abstractions with precompilers as to write as little raw mcfunction as possible, while using design patterns.],
    table.hline(),
    [3],
    [Uses website code generators (developed by 3rd parties), also because LLMs are terrible at generating datapack code.],
    table.hline(),
    [2],
    [Makes content that will only be viewable on youtube, so they don't care about testing/efficiency as long as it works and looks good.],
    table.hline(),
    table.hline(),
    [2], [Agile methodology: planning, conceptualization, refining code, quality check, big testing, feedback, repeat.],
    table.hline(),
    [2], [Precompilers have high entry barrier, low documentation, not always updated.],
    table.hline(),
    [2], [Writes pseudocode before actually implementing it in mcfunction.],
    table.hline(),
    [1], [Writes some sort of mcfunction unit tests.],
    table.hline(),
    [1], [Uses multiple namespaces to reduce nesting levels.],
    table.hline(),
    [1], [Uses fail fast methodology#footnote[The fail fast methodology is a philosophy focused on rapid experimentation to minimize wasted time, effort, and resources. It operates on the premise that discovering a flaw or an unviable idea as early as possible is a successful outcome.]: quick testing and iteration of ideas to rapidly determine their viability.],
    table.hline(),
    [1], [Premature optimization is pointless, will make code more unreadable.],
    table.hline(),
    [1], [Focus on readability rather than using abbreviations.],
    table.hline(),
    [1], [Uses preprocessors/scripts to generate hardcoded values rather than using variables for more efficiency.],
    table.hline(),
    [1],
    [Most knowledge is found in experimentation, discussion. Flow of knowledge is like in a company where the more experienced users act as senior developers.],
    table.hline(),
    [1], [Works in teams, but in separate domains (artist, programmer, composer,...).],
    table.hline(),
    [1], [Releases hotfixes frequently between major updates.],
    table.hline(),
    [1], [Writes custom linting scripts that run in CI/CD.],
    table.hline(),
    [1],
    [When working with groups, sets up a server that pulls a built datapack from a GitHub repository. Vital for quick iteration when working in a big group.],
    table.hline(),
    [1], [Originally developed everything together, after a while split content and library.],
    table.hline(),
  ),
  caption: [Responses for Q23.],
)

#figure(
  table(
    columns: 2,
    align: left + bottom,
    table.hline(),
    [*Occurrences*], [*Concept*],
    table.hline(),
    [14], [Lack of complex math operations.],
    table.hline(),
    [7], [Not possible to define multiple resources in a single file.],
    table.hline(),
    [5],
    [Despite being a DSL, mcfunction feels similar to a low level language (C/assembly), feels very repetitive to write.],
    table.hline(),
    [5], [Lack of control flow.],
    table.hline(),
    [4], [With each update there is a chance of things breaking (syntax changes).],
    table.hline(),
    [4], [Lots of workarounds are required to implement seemingly basic features.],
    table.hline(),
    [4], [Constantly having to worry about performance.],
    table.hline(),
    [3], [High risk of incompatibility across datapacks.],
    table.hline(),
    [2],
    [Sometimes not even precompilers can overcome the innate limitations of mcfunction, certain things are just unfeasible (e.g. RSA algorithm).],
    table.hline(),
    [2],
    [Struggle with keeping code functional across different Minecraft versions, barely doable with different branches.],
    table.hline(),
    [2], [Sometimes it's more efficient to hardcode function outputs rather than calculating them at runtime.],
    table.hline(),
    [2], [Lack of version resolution.],
    table.hline(),
    [1], [Large projects are difficult to navigate.],
    table.hline(),
    [1], [Lack of string manipulation.],
    table.hline(),
    [1], [Limited documentation/information.],
    table.hline(),
  ),
  caption: [Responses for Q24.],
)


Based on the reported methodologies and frustrations with the system, the typical datapack creator can be profiled as a highly technical, modern software engineer engaging in a complex, problem solving hobby. This individual possesses an advanced understanding of general programming paradigms but is paradoxically drawn to the restrictive, assembly language environment of the Minecraft DSL precisely for the intellectual challenge it presents. Rather than accepting the language's severe limitations#footnote[In particular, the absence of native control flow, complex mathematics, and string manipulation.], they engineer sophisticated workarounds by building custom abstractions and utilizing external precompilers. They approach this video game modification platform with an almost professional rigor, organically adapting informal agile principles, writing pseudocode, and rejecting artificial intelligence in favor of reliable, accurate third party tools. However, this ambition is frequently coupled with persistent frustration regarding software maintenance, as they constantly battle structural disorganization, cross version or backward incompatibility, and the need to write repetitive boilerplate code.


To further analyze community demographics and development habits, @avg-responses illustrates the average responses to Q2, Q4, Q5, Q6, Q10, Q11, Q14, Q16 and Q17 using a linear scale, categorized by the respondents' age groups.

#figure(
  image("process/survey_averages.png"),
  caption: [Average response to questions that use a linear scale. It is evident how users under the age of 18 are more reliant on external libraries and rely more on LLMs. They also indicated their experience in computer programming and datapack development to be less, compared to the other age groups. They are also the ones that comment code the less, probably because they are unaware of the benefits of commenting in the long term. It's also interesting to notice how the younger group is the one that develops datapacks for compensation the most. This perhaps could be related to the fact that they are looking for a small source of income, whereas older developers with a steady source of income develop datapacks purely as a hobby.],
) <avg-responses>

=== Conclusion

The survey captures a largely "hardcore" and dedicated user base, primarily composed of experienced hobbyists.
Because the game's DSL lacks standard structural features, developers organically adapt by utilizing modern programming tools and informal community standards.

Ultimately, the datapack community operates similarly to unstructured open source or indie game development spaces. While they lack rigid management frameworks, these developers are highly technically proficient, relying heavily on modern coding environments and advanced abstractions to bypass or make sense of the strict limitations of the Minecraft engine.

== Threats to Validity
This section outlines the study's methodological design choices, participant demographics, and potential threats to validity. Internal validity concerns the structure of the survey and the reliability of the collected responses. External validity addresses the generalizability of these findings to the broader developer community and their longevity over time.

=== Internal Validity
- Insufficient knowledge for young developers. 13.4% of the respondents are either 18 years or younger. It's very unlikely for people at that age to be familiar with software development or project management concepts, which are usually learnt in higher education or through work experience.
- To reduce the amount of data processing after gathering the results, many questions asked participants to select from predefined choices rather than writing open ended answers. However, they still had the option to type a custom response if their preferred answer was not listed.
- In Q23, three participants commented that they would have liked more questions to be checkboxes rather than multiple choice, since not always one option excluded the others. However, this doesn't mean that the data gathered for these users is wrong or unusable, just incomplete.
- Social Desirability Bias: Developers know they should comment their code, use Git, and adhere to coding conventions#footnote[Additionally, the use of LLMs to generate code is seen as bad practice since it doesn't produce valid syntax and takes the fun out of what is generally seen as a passion project.]. Therefore, it is likely that Q11, Q13, Q16 and Q21 are skewed towards the "good" choices since the participants want to appear professional.

=== External Validity
- The survey was undertaken by members of online communities specialized in the development of datapacks. This made the risk of getting empty or incomplete forms significantly low, with only one participant commenting that they felt like an outlier while completing the form.
- Selection Bias: The people who choose to voluntarily fill out this specific type of survey are different from those who ignore it. The datapack community has people ranging from 12 year old newcomers to 30 year olds who do this type of development professionally. The results are heavily skewed toward the "hardcore," professional side of the community. Therefore, my findings will have high external validity for dedicated datapack developers. However, this can be considered beneficial for the survey since it will include substantial answers from people with a significant amount of experience in the field.
- Temporal Validity: The syntax and capabilities of the _mcfunction_ DSL are constantly changing. It may very well be that in the upcoming years most of the complaints, tools and processes will change based on the language's updates.

= Discussion <discussion_ch>

This section contrasts the software engineering practices observed among Minecraft datapack developers with established paradigms in professional GPL environments and standard End User Software Engineering (EUSE).

== Requirements, Design, and Agile Adaptation

In professional software development, project management frequently relies on formalized Agile methodologies. These environments emphasize structured, independant teams, strict acceptance criteria, and critical management influence to adapt to rapidly changing requirements @noteboom_agile_2021. Furthermore, professional GPL development incorporates explicit design specifications and systematic requirement collecting phases @ko_state_2011.

Conversely, datapack developers operate without formal organizational hierarchies. Their requirements tend to be opportunistic and emergent, with a strong resemblance to standard EUSE paradigms where the programmer's intent is primarily for personal or community use rather than commercial deployment @ko_state_2011.

Despite their lack of formal structure, survey results indicate that datapack creators organically replicate some Agile principles. For instance, many rely on iterative release cycles, "fail fast" methodologies, and rapid viability testing via pseudocode. In contrast to professional Agile project management, which requires daily meetings, divided tasks, and strictly scheduled development cycles @noteboom_agile_2021, datapack developers collaborate at their own pace using informal communication platforms such as Discord and GitHub issues, engaging in feedback loops that fit their highly personalized workflows.

== Complexity and the Role of Code Generators

A major distinction between standard GPL programming and datapack development lies in how language constraints are managed. Professional developers often utilize code generators and third party software to improve productivity and manage component complexity. While code generators save time by handling repetitive boilerplate, research warns that they frequently complicate the program's underlying control flow. Developers must rely on complex conditional statements to trigger their unique custom code, creating a tangled web of logic (or "decision volatility") that makes debugging and long term maintenance much more difficult @banker_software_1998.

Datapack developers encounter a more extreme version of this phenomenon. Due to the lack of the previously described programming features, writing standard procedural code is not always possible. Instead, they rely heavily on third party precompilers, metacompilation, and external scripts to generate the necessary boilerplate. While these tools allow developers to bypass the DSL's limitations, they introduce significant maintenance overhead.

When dealing with such generated complexities, users frequently introduce new faults; studies categorize most of these human programming errors as stemming from poor strategies, cognitive overload, or paying attention to the wrong part of the program @burnett_2004. In specialized end user programming paradigms, realtime data validation is used to continually monitor the values the program produces, reasoning about expected properties to automatically alert users to potential discrepancies @burnett_2004. While these precompilers allow developers to bypass the DSL's limitations, the generated boilerplate adds layers of abstraction that obscure the underlying logic. In other end user environments, the complexity introduced by such abstractions is typically managed using live runtime checks to catch errors immediately. However, because the Minecraft ecosystem lacks any native validation mechanisms#footnote[If a command fails, no error is sent to the console, unless you manually add a print statement for every possible failure scenario.], these hidden layers of code make debugging exceptionally difficult, resulting in a significant debugging effort.

== Testing, Integration, and Quality Assurance

In modern professional GPL development, Continuous Integration (CI) is a foundational practice. CI environments rely on automated build processes, robust version control, and comprehensive testing frameworks (unit, integration, and security testing) to detect defects early and increase deployment reliability @chen_continuous_2025. This systematic approach is driven by the need to support large teams, scale complex infrastructure, and actively reduce software fault rates.

In contrast, standard end user programmers tend to be overconfident in their code and debug opportunistically rather than systematically @ko_state_2011. To support them, researchers advocate for the "What You See Is What You Test" (WYSIWYT) methodology, where users incrementally validate any value as correct at any point during the development process @burnett_2004. Behind the scenes, these validations measure the quality of testing against an adequacy criterion#footnote[A measurable standard, such as the percentage of statements or branches exercised by existing tests, used to decide how much of the program has actually been checked.] and project the results via visual devices to guide the user's focus @burnett_2004. EUSE systems also employ "Help-Me-Test" algorithms, which analyze the program's logical structure in the background and automatically generate test inputs to force execution down unexplored logic paths @burnett_2004.

Datapack developers occupy a middle ground between these two extremes. While they exhibit high technical proficiency, with a vast majority utilizing formal version control systems, only a small fraction (around 25%) implement formal CI/CD pipelines. Because establishing robust CI infrastructure requires high initial costs and architectural planning @chen_continuous_2025, datapack quality assurance processes instead depend heavily on manual beta testing and informal community feedback. They do not have access to automated fault localization capabilities that visually prioritize which suspicious code snippet to investigate first @burnett_2004. Furthermore, because the environment lacks "Help-Me-Test" algorithms to analyze command structures (such as `execute if` conditions) and automatically simulate test scenarios, developers must manually open the game, set up complex entity states or scoreboards, and verify every edge case individually.

This low CI/CD adoption rate should not be read purely as a symptom of insufficient resources or technical maturity. Viggiato et al. found that CI is not adopted as a rigid, universal practice even within professional, well resourced organizations: developers in the banking and e-commerce domains deliberately interrupt their CI pipelines during critical commerce periods, such as Black Friday, the weeks before the new year, and salary payment cycles, to avoid the risk of introducing bugs when reliability matters most @viggiato2019. This validated, cross domain finding shows that even mature corporate environments calibrate CI adoption against real external risk rather than applying it uniformly. More broadly, the same study found that a company's policy and culture, rather than the intrinsic technical demands of a domain, are what most strongly shape which development practices get adopted and how @viggiato2019. Applying this lens to datapack development, the community's informal and inconsistent use of CI/CD can be read less as a maturity deficit and more as a rational adaptation: lacking both a company level policy structure and any external commercial risk to hedge against, datapack developers have little structural pressure to adopt the standardized pipelines seen in industry.

To improve the testing and QA practices of the datapack community, future tooling could benefit from the "Surprise-Explain-Reward" strategy. It's a cognitive tutoring framework designed to encourage end user programmers (who are usually focused on getting their code to work rather than writing clean tests) to adopt good software engineering habits @burnett_2004. An example can be seen in editors that underline code detected as deprecated, improvable or unsafe#footnote[This is already partly implemented in the Spyglass VSCode extension when using expensive selectors. Warnings are raised when inefficient, broad selections (or queries) are used.]. Since it is unreasonable to expect hobbyists to actively seek out formal testing frameworks, this strategy gently attempts to interest end users in appropriate software engineering behaviors at suitable moments @burnett_2004.

== Quantitative Analysis of Specific Survey Hypotheses

While the preceding subsections contrast datapack development against established software engineering and end user programming literature, I  must evaluate whether these observed trends hold true under rigorous statistical testing. Therefore, this section presents an analysis of seven research hypotheses concerning developer demographics, coding abstractions, team collaboration, and refactoring efforts.

=== A Brief Overview of Statistical Measures
Before presenting the quantitative findings, I outline the statistical metrics used in this analysis:
- *Spearman's Rank Correlation Coefficient ($rho$)*: Measures how well two variables move together in a consistent trend, even if the relationship is not a straight line. It works by ranking the values, making it robust to outliers and ideal for analyzing rating scales (1-7). Values range from $-1.0$ (perfect opposite trend) to $+1.0$ (perfect matching trend), with $0.0$ showing no relationship.
- *The $p$-value (Probability Value)*: Indicates whether a finding is likely a real pattern or just random chance. It represents the probability that the observed relationship occurred purely by accident. By scientific convention, a $p$-value below $0.05$ is considered statistically significant, meaning there is less than a 5% chance the pattern is an accident.
- *Descriptive Averages and Variation*: To describe central tendencies, I report the mean ($M$, the arithmetic average) and the median ($"Mdn"$, the middle value of the ordered dataset). To measure the dispersion or spread of responses, I report the standard deviation ($"SD"$), which quantifies how much individual data points vary from the mean.

=== Demographic Verification (Hypotheses 1 & 2)
To validate the reliability of the survey responses, I categorized the participants into three age groups: G1 (ages 18 or younger, representing developers who typically lack formal higher education or professional experience; $N = 13$), G2 (university students aged 19-23; $N = 42$), and G3 (mature developers aged 24 or older; $N = 21$). Since Q1 was optional, the remaining 21 respondents did not disclose their age and are therefore excluded from this and the following age based analyses.

I hypothesized that developers who had released fewer datapacks would match G1, implying that the answers of G2 and G3 are backed by more practical experience. As shown in @h2-zero-released, the data supports this trend: G1 has the highest percentage of developers with no releases (23.1%), followed by G2 (16.7%), and G3 (4.8%). This validates my analytical focus on the G2 and G3 groups. However, G1 also contains prolific developers (with up to 68 releases), indicating that youth does not strictly equate to lack of experience.

#figure(
  image("process/h2_zero_released.png",),
  caption: [Percentage and counts of developers within each age group who have released zero datapacks.],
) <h2-zero-released>

Additionally, @h1-techniques compares the adoption of software engineering techniques across these groups. While version control (Git) usage is high across all groups (ranging from 69.2% in G1 to 85.7% in G3), mature developers (G3) show a higher adoption of precompilers and external scripts (52.4% vs. 30.8% in G1), formal coding conventions (85.7% vs. 61.5% in G1), and frequent code commenting (61.9% vs. 38.5% in G1). This suggests that technical knowledge acquired in university or professional settings (G2/G3) correlates with more structured development habits.

#figure(
  image("process/h1_techniques.png"),
  caption: [Adoption rates of software engineering techniques by age group.],
) <h1-techniques>

=== Developer Experience and Project Output (Hypothesis 3)
I analyzed the correlation for G2 and G3 between the number of datapacks released and their perceived knowledge. As illustrated in @h3-released-experience, I observed a moderate positive correlation (Spearman's $rho = 0.468$, $p < 0.001$), showing that developers' self assessed experience aligns with their historical project output.

#figure(
  image("process/h3_released_vs_experience.png"),
  caption: [Correlation between perceived experience and number of datapacks released for G2 & G3.],
) <h3-released-experience>

=== Team Collaboration and Documentation (Hypothesis 4)
I investigated if working in a team increases the frequency and depth of code commenting. As shown in @h4-commenting, developers working in teams report significantly higher comment frequency (5.10 vs. 3.79) and commenting quantity (3.88 vs. 3.31). This confirms that team collaboration shifts developer behavior toward more professional documentation practices to facilitate communication and clarity.

#figure(
  image("process/h4_commenting.png"),
  caption: [Comparison of average comment frequency and quantity between solo and team developers.],
) <h4-commenting>

=== Refactoring and Release Cycle Frequency (Hypothesis 5)
I tested the hypothesis that a higher percentage of development time spent optimizing or refactoring correlates with more frequent, iterative release cycles. As shown in @h5-refactor-cycle, the Spearman correlation is virtually zero ($rho = 0.017$, $p = 0.896$). This indicates that refactoring effort is independent of release agility in the datapack ecosystem.

#figure(
  image("process/h5_refactor_vs_cycle.png"),
  caption: [Scatter plot of refactoring effort vs. release cycle frequency for G2 & G3.],
) <h5-refactor-cycle>

=== Experience and Levels of Abstraction (Hypothesis 6)
I examined the relationship between experience and the level of code abstraction (Plain mcfunction #sym.arrow Custom scripts #sym.arrow Precompilers). As illustrated in @h6-experience-abstraction, experience correlates positively with abstraction level (Spearman's $rho = 0.400$, $p < 0.001$). The median experience rises from $"Mdn" = 4.0$ for plain mcfunction users to $"Mdn" = 6.0$ for precompiler users, showing that advanced workarounds are primarily adopted by more experienced creators.

#figure(
  image("process/h6_experience_vs_abstraction.png"),
  caption: [Distribution of perceived datapack experience across levels of code abstraction.],
) <h6-experience-abstraction>

=== Commercial Motivation and Code Quality (Hypothesis 7)
Lastly, I compared developers who mostly work for financial compensation ($N = 10$) with those who develop purely as a hobby ($N = 87$). I hypothesized that paid developers would write disposable "S-type" code#footnote[Lehman classifies programs into three types: S-programs, which are fully specified and provably correct with no need for future change; P-programs, which solve a practical problem whose solution's implementation can change overtime; and E-programs, which are embedded in and continuously evolve alongside a real-world domain @lehman1980. "S-type" code here refers to a one-off, throwaway solution written to satisfy a fixed specification rather than to evolve over time.] with lower maintenance focus, fewer releases, and minimal comments.

However, the empirical data in @h7-compensation strongly refutes this hypothesis. Paid developers spend more time refactoring (40.0% vs. 30.4%), release more datapacks (13.2 vs. 7.2), and comment their code more frequently (5.20 vs. 4.24). This indicates that financial incentives encourage more professional, contract oriented behaviors rather than quick, dirty and disposable code.

#figure(
  image("process/h7_compensation.png"),
  caption: [Comparison of refactoring effort, released datapacks, and comment frequency between hobbyist and paid developers.],
) <h7-compensation>

== Summary
Ultimately, the datapack community demonstrates a unique blend of practices. They confront the informal challenges that arise from the DSL limitations, but tackle them using simplified versions of professional GPL methodologies. By adapting version control, code generation workarounds, and iterative agile feedback loops to fit a highly restricted DSL, datapack developers prove that rigorous software engineering principles can organically emerge and thrive even in entirely decentralized, hobbyist domains.

= Conclusion
This study investigated the software engineering practices and project management methodologies adopted by the Minecraft datapack community.
Despite operating within a DSL characterized by severe structural limitations, datapack developers exhibit a remarkably high degree of technical proficiency. 
The survey results demonstrate that these creators organically compensate for the engine's constraints by adopting sophisticated, almost professional workarounds, such as relying on third party precompilers, utilizing version control systems, and adapting Agile methodologies. 
Ultimately, this research highlights a unique intersection between End User Software Engineering (EUSE) and professional development paradigms. 
The datapack ecosystem proves that rigorous software engineering principles, such as iterative feedback loops and abstracted code generation, can successfully emerge and thrive even in self organized, non commercial hobbyist domains.
While this primary study establishes a qualitative baseline of developer behavior, there remains a significant gap regarding objective code analysis. 
Future research could employ Mining Software Repositories (MSR) techniques to empirically analyze publicly available datapack codebases. By analyzing the code directly, researchers can measure its size and quality, and spot common coding mistakes (e.g. slow loops, missing namespaces,...) that survey answers might miss.
