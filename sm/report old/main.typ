#import "@preview/fine-lncs:0.6.4": author, institute, lncs, proof, theorem

#let inst_princ = institute(
  "Princeton University",
  addr: "Princeton NJ 08544, USA",
)
#let inst_springer = institute(
  "Springer Heidelberg",
  addr: "Tiergartenstr. 17, 69121 Heidelberg, Germany",
  email: "lncs@springer.com",
  url: "http://www.springer.com/gp/computer-science/lncs",
)
#let inst_abc = institute(
  "ABC Institute",
  addr: "Rupert-Karls-University Heidelberg, Heidelberg, Germany",
  email: "{abc,lncs}@uni-heidelberg.de",
)

#show: lncs.with(
  title: "Contribution Title",
  // Opt.: Set this, if the title is too long to avoid linebreaks in the header of odd pages
  // running-title: "Short version of contribution title",
  // running-author: "Override the default author shortening",
  thanks: "Supported by organization x.",
  authors: (
    author("First Author", insts: (inst_princ), oicd: "0000-1111-2222-3333"),
    author(
      "Second Author",
      insts: (inst_springer, inst_abc),
      oicd: "1111-2222-3333-4444",
    ),
    author("Third Author", insts: (inst_abc), oicd: "2222-3333-4444-5555"),
  ),
  abstract: [
    The abstract should briefly summarize the contents of the paper in
    15--250 words.
  ],
  keywords: ("First keyword", "Second keyword", "Another keyword"),
  bibliography: bibliography("../../template/refs.bib"),
)

= First Section

My awesome paper ...

#outline()

= Introduction
// contextualize
= Theoretical Background
// what are minecraft datapacks, what limitations do they have
= Related works
// what methotologies were used to gather this type of data in other fields
= Survey Details and Results
// what information does the survey give us (profiles, techniques,...), result description
= Discussion
// results contextualized with other papers
= Conclusion
// including future developments