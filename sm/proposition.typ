*Are software development processes and project management techniques applicable in the development, release and maintaining of minecraft datapacks?*

_A datapack is a third party content bundle that can be downloaded as a zip file and installed in a save file to add or modify game content. They are written using a domain specific language (DSL) called mcfunction._

The proposition is to conduct a primary study where we discuss how development processes and project management relate with minecraft datapack development and management: what tools are used to facilitate/automate development and releases, how is the code quality and project organization maintained, is there a development process or team structure?

The proposition is to use google forms to gather answers from online communities with members with different experience levels. The goal is to get at least 50-60 answers, with the following questions (the form will use options wherever possible to ensure consistent results and reduce the amount of data cleaning)

= Questions
== Demographics and context
- How old are you?
- How long have you been developing minecraft datapacks for?
- Are you a computer science student/work in the field of computer science?
-  Do you develop datapacks purely as a hobby, or do you receive financial compensation?
== Software Development Processes & Tools
- What code editor do you use, and which specific features (e.g., syntax highlighting, autocomplete) actively speed up your development process
- Do you use a precompiler or external scripts to automate file generation?
- Do any of your projects rely on external libraries?

== Software Project Management & Agile Approaches
- Do you work in a team?
- Do you use a formal version control system (such as Git) to manage your codebase and track changes?
- Do you utilize an automated pipeline (CI/CD) building (zipping), and deploying your datapack releases?
- Do you release your datapacks iteratively (releasing frequent, small updates to gather community feedback) or do you use a traditional "waterfall" approach (one massive final release)? 
== Quality & Maintenance
- How much do you comment your code?
- Do you have beta testers to ensure code quality before release?
- On average, how long do you spend maintaining a datapack (fixing bugs, updating to new Minecraft versions) after its initial release?
- Roughly what percentage of your total development time is dedicated to optimizing code performance versus writing new features?
- Do you adhere to code conventions (i.e.,namespacing, Smithed,...)
- How do you track and manage bugs or feature requests from your users (e.g., GitHub Issues, Discord channels, informal feedback)?


A datapack development enviornment is typically large and messy, due to the strict compiler rules when it comes to structure and verbosity of the DSL.
We want to see how people have adapted to make development easier in a system never intended to be used for big, "enterprise level" projects;

This is an extremely niche community, so no papers on the process of developing and maintaining minecraft datapacks exist.

However, can review existing literature on agile approaches, release pipelines, versioning systems, effort extimation and discuss how these are traditionally applied in standard environments, then use the gathered data to see how they compare in this niche development environment.

We can apply the quality appraisal criteria that Kitchenham outlines for evaluating survey based studies

There is the possibility to do interview with developer with one of the oldest and biggest datapacks ever, with one of the biggest teams and the most intricate publishing pipelines.

= Possible Index

+ Illustrate the process used for literature review, data gathering, source inclusion
+ Explain how the DSL works and the typical problems user facilitate
+ Shine typical software development processes citing the papers, then review/criticize the them with the aid of primary data to see if these processes are applicable in the development of datapacks
+ Illustrate how software is typically managed using the papers as source, and use the data gathered to see if these techniques are also applied or are applicable in the development/release of datapacks.
+ Conclusion