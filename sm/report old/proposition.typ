*Are software development processes and project management techniques applicable in the development, release and maintaining of minecraft datapacks?*

Alessandro Nanni `a.nanni@student.utwente.nl`

_A datapack is a third party content bundle that can be downloaded as a zip file and installed in a save file to add or modify game content. They are written using a domain specific language (DSL) called mcfunction._

The proposition is to conduct a primary study where I discuss how development processes and project management relate with minecraft datapack development and management: what tools are used to facilitate/automate development and releases? How is the code quality and project organization maintained? Is there a development process or team structure?

I plan to use google forms to gather answers from online communities with members with different experience levels. The goal is to get at least 50-60 answers, with the following questions (the form will use options wherever possible to ensure consistent results and reduce the amount of data cleaning)


Clustering? 
= Questions
== Demographics and context
- What year were you born in?
- How skilled would you consider yourself 0 to 5?
- Where are you from?
- Are you a computer science student/work in the field of computer science?
-  Do you develop datapacks purely as a hobby, or do you receive financial compensation?
- How many datapacks have you released?
== Software Development Processes & Tools
- What code editor do you use, and which specific features (e.g., syntax highlighting, autocomplete) actively speed up your development process? VScode, Notepad++, Sublime, default text editor.
- Do you use a precompiler or external scripts to automate file generation?
- Do any of your projects rely on external libraries?
- Do you use AI to generate commands?
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
- Do you adhere to code conventions (i.e.,namespacing, Smithed,...)?
- How do you track and manage bugs or feature requests from your users (e.g., GitHub Issues, Discord channels, informal feedback)?


Related works on similar questions in other areas? See the best practices.

A datapack development enviornment is typically large and messy, due to the strict compiler rules when it comes to structure and verbosity of the DSL.
I want to see how people have adapted to make development easier in a system never intended to be used for big, "enterprise level" projects;

This is an extremely niche community, so no papers on the process of developing and maintaining minecraft datapacks exist. Most sources from this topic would come from the #link("https://minecraft.wiki/w/Data_pack")[Minecraft Technical Wiki] or websites for the tools/conventions (i.e. #link("https://docs.smithed.dev/conventions/index.html"))

However, can review existing literature on agile approaches, release pipelines, versioning systems, effort extimation and discuss how these are traditionally applied in standard environments, then use the gathered data to see how they compare in this niche development environment.

We can apply the quality appraisal criteria that Kitchenham outlines for evaluating survey based studies

There is also the possibility to do an interview with the developer of one of the oldest and biggest datapacks ever, with one of the biggest teams and the most intricate CI/CD pipelines.

= Possible Index
+ Introduction tell story, put index
what dsl is, what the techniques are, what processes are used.

+ Illustrate the process used for literature review, data gathering, source inclusion
+ Explain how the DSL works and the typical problems users face and how they try to circumnavigate them
+ Shine light on typical software development processes citing the papers, then review/criticize the them with the aid of primary data to see if these processes are applicable in the development of datapacks
+ Illustrate how software is typically managed using the papers as source, and use the data gathered to see if these techniques are also applied or are applicable in the development/release of datapacks.
+ Conclusion

Cite pressman because data is software

Related work: 

= Papers
Software life cycle process
https://ieeexplore.ieee.org/search/searchresult.jsp?queryText=software%20development%20process&highlight=true&returnFacets=ALL&returnType=SEARCH&matchPubs=true&ranges=2020_2026_Year
A Taxonomy of Contextual Factors in Continuous Integration Processes
https://ieeexplore.ieee.org/document/11010154
Let's Supercharge the Workflows: An Empirical Study of GitHub Actions
https://ieeexplore.ieee.org/document/9742138
A Comprehensive Approach to Evaluating Software Code Quality Through a Flexible Quality Model
https://ieeexplore.ieee.org/document/10215004
Scrum Software Maintenance Model: Efficient Software Maintenance in Agile Methodology
https://ieeexplore.ieee.org/document/8593152



Experiences from conducting semi-structured interviews in empirical software engineering research
https://ieeexplore.ieee.org/document/1509301

Reasons for software effort estimation error: impact of respondent role, information collection approach, and data analysis method
https://ieeexplore.ieee.org/document/1377193

The study on competency characteristic of JAVA software engineer of the Internet enterprise
https://ieeexplore.ieee.org/document/7385971


A Survey on a State of the Practice in Video Game Development
https://www.researchgate.net/publication/242659876_A_Survey_on_a_State_of_the_Practice_in_Video_Game_Development

Exploring Quality Assurance Practices and Tools for Indie Games
https://ieeexplore.ieee.org/document/10190458

Understanding Similarities and Differences in Software Development Practices Across Domains
https://ieeexplore.ieee.org/document/8807455

Domain-Specific Languages in Practice: A User Study on the Success Factors
https://link.springer.com/chapter/10.1007/978-3-642-04425-0_33


https://doiserbia.nb.rs/Article.aspx?id=1820-02141002247K

https://www.sciencedirect.com/science/article/pii/S0950584915001858

https://www.sciencedirect.com/science/article/pii/S0164121214002799