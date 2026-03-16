#import "_ldsw.typ": *
#show: template
#let c(body) = $#text(body, font: "Calibri", weight: 5, size: 10pt)$
= Description Logics
A description logic (DL) is a structured fragment of first order logic. It's a representation oat a predicate level, without variables.
It claims to be a unifying formalism for other knowledge representation languages, such as frames-based systems, object oriented modelling, semantic data models,...
#i[DL is a declarative language to formulate theories and systems for expressing, accessing and reasoning with structured knowledge.]
It's used for terminologies, ontologies, logic based conceptual data modelling and information integration.

#note(supplement: [def])[Top and Bottom sets][
    In Description Logics, the top and bottom sets represent the absolute boundaries of your knowledge base: "Everything" and "Nothing."
    - Top Concept ($top$): This is the set of all individuals in your entire domain. Every single concept you create (like #c[Person], #c[Car], #c[Dog]) is automatically a subset (subconcept) of $top$.
    - Bottom Concept ($bot$): This is the set that contains absolutely no individuals. It represents an impossibility. Every concept is a superset of $bot$.
]

== $bold(cal("SROJQ"))$ DL
=== ABOX Axioms
#i[Knowledge about individuals]
/ Concept assertion: $"Mother"("Julia")->$ #c[Julia] is a #c[mother]. $C$ is #c[Mother], $a$ is #c[Julia], $C(a)$ means that #c[Julia] is a #c[Mother].

/ Role assertion: $"parentOf"("Julia","John")->$ #c[Julia] is a parent of #c[John]
/ Individual inequality: $"Julia"approx.not "John"->$ #c[Julia] and #c[John] are different individuals
/ Individual equality: $"John" approx "Johnny"->$ #c[John] and #c[Johnny] are the same individuals
=== TBOX Axioms
#i[Relationships between concepts]
/ Concept inclusion: $"Mother"subset.eq.sq "Parent"->$ all mothers are parents (#c[Mother] is subsumed by #c[Parent])
/ Concept equivalence: $"Person" equiv "Human"->$ #c[Person] and #c[Human] have the same instances
=== RBOX Axioms
#i[Relationships between roles]
/ Role inlcusion: $"parentOf" subset.eq.sq "ancestorOf"->$ #c[parentOf] is a subrole of #c[ancestorOf]
/ Role composition: $"brotherOf" compose "parentOf" subset.eq.sq "uncleOf"->$ the chain of #c[brotherOf] followed by #c[parentOf] is a subrole of #c[uncleOf]
/ Disjoint roles: $"Disjoint"("parentOf","childOf")->$ the roles #c[parentOf] and #c[childOf] are mutually exclusive; an individual cannot be both the #c[parentOf] and the #c[childOf] of the exact same person. Disjoint pairs are used to represent pairs that have no relationships with each other.
#i[$"parentOf" inter.sq "childOf" = emptyset$, or better $"parentOf" inter.sq "childOf" subset.eq.sq bot$]
Other characteristics are reflexivity, symmetry and transitivity.

=== Boolean concept constructors
/ Intersection (conjunction): $"Mother"equiv "Female" inter.sq "Parent"$
/ Union (disjunction): $"Parent"equiv "Father" union.sq "Mother"$
/ Complement (negation): $"Female" inter.sq not "Married"->$ unmarried woman
/ Top concept: $top subset.eq.sq "Male" union.sq "Female"->$ $top$ is the top concept, with every individual
/ Bottom concept: $"Parent" inter.sq "Childless" subset.eq.sq bot->$ $bot$ is the bottom concept (empty)

=== Role restrictions
/ Existential restriction: $"Parent" equiv exists "parentOf."top->$ set of elements that are parent of at least one individual.
$exists "parentOf.Female"->$ people who have (at least) a daughter

/ Universal restriction: $forall "parentOf.Female"->$ if a person has a child, then it is a daughter/no children other than female ones. In this case $forall$ indicates *only*, so individuals who are parents *only* to #c[Female]s.
$exists "parentOf."top inter.sq forall "parentOf.Female"->$ People who have daughters.

=== Role domain and range restrictions
$exists "sonOf."top subset.sq.eq "Male"$ (Domain of sonOf is Male)\
$top subset.sq.eq forall "sonOf.Parent"$ (Range of sonOf is a Parent)
/ At-least restriction: $gt.eq 2 "childOf.Parent"->$ children of at least two parents
/ At-most restriction: $lt.eq 2 "childOf.Parent"->$ children of at most two parents
/ Local reflexivity: $exists "talkTo.self"$

=== Role constructors/characteristics
/ Inverse role: $"parentOf"equiv"childOf"^- ->$ if an individual $A$ has a #c[parentOf] relationship to individual $B$, it inherently implies that individual $B$ has a #c[childOf] relationship to individual $A$. If a role is defined by the pair $chevron.l x,y chevron.r$, its inverse is $chevron.l y,x chevron.r$.
/ Role Transitivity: $"Trans"("ancestorOf")->$ the role #c[ancestorOf] has the characteristic of being transitive. $"Trans"("ancestorOf") equiv "ancestorOf" compose "ancestorOf" subset.sq.eq "ancestorOf"$ formally defines how a transitive role behaves.
/ Role symmetry: $"marriedTo"equiv"marriedTo"^- ->$ a role is symmetric if it is equivalent to its inverse.
/ Role asymmetry: $"Disjoint"("parentOf", "parentOf"^-)->$ a role is asymmetric if it's disjoint with its inverse.
=== Description Logics Semantics
Description logics semantics follow the open world assumption, i.e., what is unspecified is open (might be true or false).
#i[This is in opposition to the more common closed world assumption that what is not true is false.]

#figure(image("src/srojq constructors.png"), caption: [$bold(cal("SROJQ"))$ constructors])

#figure(image("src/srojq axioms.png", width: 50%), caption: [$bold(cal("SROJQ"))$ axioms])

=== Interpretation

/ $cal(I) models alpha$: axiom $alpha$ holds in the Interpretation.
/ $cal(I) models cal(O)$: interpretation $cal(I)$ satisfies ontology $cal(O)$, $cal(I)$ is a model of $cal(O)$
Ontology is consistent if it has at least one model.
/ $cal(O) models alpha$: axiom $alpha$ is a consequence of the interpretation if it holds in all models of $cal(O)$.

#note[General open world assumption][
    The ontology
    $
        & "parentOf"("Julia", "John") \
        & "manyChildren"("Julia") \
        & "manyChildren" subset.eq.sq gt.eq 3 "parentOf".top
    $
    is consistent because there may be a world state in which #c[Julia] has three children, but only #c[John] is named. And infinite other implementations may exist.
]

== Other Description Logics
Fragments of DLs to achieve specific computational properties, such as:
/ $cal("ALC")$: Attribute Language with Concept negation
/ $cal("ALCJ")$: $cal("ALC")$ plus Inverses
/ $cal("ALCH")$: 𝒜ℒ𝒞 plus Hierarchy of roles
/ $cal("ALCHQ")$: 𝒜ℒ𝒞 plus Inverses, Hierarchy of roles and Qualified number restrictions
/ $cal("EL")$: Existential quantifiers and concept intersection (no unions, complements or universal quantifiers, no relations axioms)


=== Standard Reasoning Services
/ Consistency of the knowledge base: $cal("KB") cancel(models) top subset.sq.eq bot->$ no contradiction when instantiating concepts and roles.
/ Concept and role satisfiability: $cal("KB") cancel(models) C subset.eq.sq bot->$ $C$ has no empty extension
/ Concept and role subsumption: $cal("KB") models C subset.eq.sq D->$ all instances of $C$ are also instances of $D$
/ Instance checking: $cal("KB")models C(a) or cal("KB") models R(a,b)$
/ Instance retrieval: ${a|cal("KB")models C(a)}$
= OWL 2 Syntaxes
How description logics are implemented in OWL. Logics require tools to serialize the ontologies (logical expressions) and perform reasoning. *OWL is a language to serialize ontologies*.
== Differences between OWL and DL languages

#figure(image("src/owl2 axioms.png"), caption: [OWL2 axioms])

OWL uses URI references as names. OWL gathers information in documents stored in RDF/XML format, including imports from other files.
- A DL concept is called class;
- DL roles is called object property, because it's defining relations between objects;
- Data properties are defined to represent attributes.
- Allows the use of RDF data types and XML schema types to the ranges of attributes.

== OWL 2 Languages

/ OWL 2 DL: 'species' based on $cal(S R O I Q)(cal(D))$ DL, which is more expressive than $cal(S H O I N)(cal(D))$ of OWL DL
/ OWL 2 EL: based on the $cal(E L)^(++)$ language, for large simple type ontologies
/ OWL 2 QL: based on the $"DL-Lite"_"R"$ language, for handling and querying large amounts of instances
/ OWL 2 RL: inspired by Description Logic Programs, for ontologies with rules and data in RDF triple format

== OWL 2 Syntaxes examples
$"FirstYearCourse" subset.eq.sq forall "isTaughtBy.Professor"$
#figure(```xml
<owl:Class rdf:about="&exOKB17;FirstYearCourse">
    <rdfs:subClassOf rdf:resource="&owl;Thing"/>
    <rdfs:subClassOf>
        <owl:Restriction>
            <owl:onProperty rdf:resource="&exOKB17;isTaughtBy"/>
            <owl:allValuesFrom rdf:resource="&exOKB17;Professor"/>
        </owl:Restriction>
    </rdfs:subClassOf>
</owl:Class>
```,caption:[RDF/XML])

#figure(```
Declaration(Class(:FirstYearCourse))
SubClassOf(:FirstYearCourse owl:Thing)
SubClassOf(:FirstYearCourse ObjectAllValuesFrom(:isTaughtBy :Professor))
```,caption:[Functional])

#figure(```
FirstYearCourse SubClassOf isTaughtBy only Professor
```,caption:[Manchester])

== Tool support (protégé)
Knowledge of the OWL terminologies is required, but not the specific OWL 2 syntaxes.
+ Define classes and their relations
+ Define object and data properties and their relations
+ Define additional axioms (for example object relation restrictions)
+ Define individuals and possible classes based on them.
