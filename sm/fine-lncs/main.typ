#import "@preview/fine-lncs:0.6.4": author, institute, lncs, proof, theorem

#let inst_twente = institute(
  "Twente University",
  addr: "Drienerlolaan 5, 7522 NB Enschede, Netherlands",
)

#show: lncs.with(
  title: "Project Management and Software Development Techniques in Minecraft Datapack Development",
  // Opt.: Set this, if the title is too long to avoid linebreaks in the header of odd pages
  running-title: "Datapack Project Management & Software Development",
  // running-author: "Override the default author shortening",
  authors: (
    author(
      "Nanni Alessandro",
      insts: (inst_twente),
      oicd: "0000-1111-2222-3333",
    ),
  ),
  abstract: [
    The popular video game _Minecraft_ provides a domain specific language (DSL) that allows to modify the default game behavior trough content bundles called _Datapacks_. The DSL however, has numerous syntactical and structural limitations. These shortcomings force developers to find interesting solutions to maintain an organized and maintainable coding environment. Trough a primary study we see which of the techniques the respondents apply can be validated by other literature that surveyed general purpose language (GPL) developers.    
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

= Introduction
// contextualize
= Theoretical Background
// what are minecraft datapacks, what limitations do they have
= Related works
// what methodologies were used to gather this type of data in other fields
= Survey Details and Results
// what information does the survey give us (profiles, techniques,...), result description
= Discussion
// results contextualized with other papers
= Conclusion
// including future developments

For citations of references, we prefer the use of square brackets and consecutive numbers. Citations using labels or the author/year convention are also acceptable. The following bibliography provides a sample reference list with entries for journal articles @PAPER:1, a book @BOOK:2, and a homepage @WEBSITE:1. Multiple citations are grouped @BOOK:2@ARTICLE:1@BOOK:1.
