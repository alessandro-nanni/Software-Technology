#let lighten = 85%


#let primary-color = state("primary-color", blue)
#let secondary-color = state("secondary-color", green)

#let template(primary-color, secondary-color, title, doc) = context {
  set page(columns: 2, flipped: true, numbering: "1")

  // heading
  set heading(numbering: "1.1")

  // table first raw
  show table.cell.where(y: 0): strong

  // text and paragraph
  set par(justify: true)
  set text(overhang: false, ligatures: false)

  let outline-color = secondary-color.desaturate(50%)

  set highlight(fill: primary-color.transparentize(50%).lighten(20%))

  show raw.where(block: false): highlight.with(
    fill: secondary-color.lighten(lighten),
    radius: 2pt,
    top-edge: 1em,
  )
  show raw.where(block: true): it => box(
    stroke: 0.5pt + outline-color,
    radius: 2pt,
    inset: 2pt,
    fill: outline-color.transparentize(70%),
    it,
  )

  show link: it => underline(text(fill: blue, it))


  // outline
  show outline.entry.where(level: 1): it => {
    show repeat: none
    v(0.2cm)
    strong(it)
  }
  set outline(title: none)

  // content
  align(center, text(size: 20pt, title))
  block(outline(depth: 2))
  // pagebreak(weak: true)

  doc
}

#let important(content) = context {
  let color = primary-color.get()
  show: block.with(
    stroke: (left: 1.5pt + color),
    width: 100%,
    inset: 5pt,
    fill: color.lighten(lighten),
  )
  content
}

#let annotate(bracket, note, body) = layout(size => context {
  show: box.with()
  place(
    horizon + left,
    dx: -55pt,
    box(width: 45pt, text(hyphenate: true, fill: primary-color.get(), note)),
  )
  place(
    horizon + left,
    dx: -10pt,
    text(
      fill: primary-color.get(),
      $stretch(size: #{ measure(body, width: size.width).height + 0.5em }, #bracket)$,
    ),
  )
  body
})


#let merge(separator: sym.arrow, ..content) = {
  content.pos().join(separator)
}

#let note(supplement: none, title, body) = context {
  let color = primary-color.get()
  let header = []
  if (supplement != none) {
    header = smallcaps(lower(supplement)) + [: ]
  }
  header += title
  show: block.with(stroke: 1pt + color, width:100%, fill: color.lighten(lighten), inset: 5pt, radius: 2pt)
  strong(header)
  v(1pt)
  body
}
#let delimiters = (
  "<": ">",
  "(": ")",
  "[": "]",
  "{": "}",
)

#let wrap(delimiter: "<", content) = delimiter + content + delimiters.at(delimiter)

#let missing(page: none) = box(stroke: 1pt + red, inset: 2pt, baseline: 25%, text(fill: red, {
  smallcaps[Missing]
  if (page != none) {
    [ p.] + [#page]
  }
}))

// shortcuts
#let h(content) = highlight(content)
#let u(content) = underline(content)
#let i(content) = important(content)
#let n(supplement: none, title, body) = note(supplement: supplement, title, body)
#let a(bracket: ${$, note, body) = annotate(bracket, note, body)
#let w(delimiter: "<", content) = wrap(delimiter: delimiter, content)
#let m(page: none) = missing(page: page)
#let def(title, body) = note(supplement: [def], title, body)
