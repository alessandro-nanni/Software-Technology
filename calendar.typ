#set page(margin: 0pt, flipped: true)
#set text(font: "Arial")
#let q(num) = align(center, text(size: 20pt, weight: "bold")[Q#num])
#let y(num) = table.cell(rowspan: 3, align(horizon, rotate(90deg, reflow: true, text(
    size: 20pt,
    weight: "bold",
)[Year #num])))

#let courses = (
    "mandatory": yellow,
    "core": red,
    "mantle": blue,
    "elective": green,
    "orientation": purple,
)

#let c(name, type, rowspan: 1, colspan: 1) = table.cell(
    fill: courses.at(type),
    rowspan: rowspan,
    colspan: colspan,
    align(center + horizon, text(
        size: 15pt,
        name,
        weight: "bold",
    )),
)

#table(
    columns: (auto, 1fr, 1fr, 1fr, 1fr),
    rows: (auto, 1fr, 1fr, 1fr, 1fr, 1fr, 1fr, 1fr, 1fr, 1fr),
    [], q(1), q(2), q(3), q(4),
    y(1), table.cell(rowspan: 3, colspan: 2)[],
    c([Software Testing and Risk Assessment], "core"),
    c([Software Evolution], "core"),
    c([Service-oriented Architecture with Web services], "mantle"),
    c([Software Management], "mantle"),
    c([Linked Data and Semantic Web], "elective"),
    c([Distributed Systems], "elective"),
    y(2),
    c([System Validation], "core"),
    c([Design of Software Architecture], "core"),
    c(colspan: 2, [Research Topic], "mandatory"),
    c([Model Driven Engineering], "mantle"),
    c([Computer Ethics], "mandatory"),
    c([Quantitative Evaluation of Systems], "mantle"),
    c([192130112 / 202001579 ], "elective"),
    c(
        colspan: 2,
        [Industrial Software Engineering Project
        ],
        "orientation",
    ),
    c(
        [
            201700079 / 202001492 / 202300300 / 202100114
        ],
        "elective",
    ),
    c([Capita Selecta Software Technology], "elective"),
    y(3),
    c([Final Project], "mandatory", colspan: 2, rowspan: 3), table.cell(rowspan: 3, colspan: 2)[],
)


