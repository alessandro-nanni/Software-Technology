#import "_ldsw.typ": *
#show: template
= Ontology Matching

In the semantic web, resourced used in different ways must be reconciled before being used. Mismatches can occur when operating with different languages, terminologies and models.

The heterogeneity problem
/ Syntactic heterogeneity: using different ontology languages (RDF, OWL)
#a[#text(size: 9pt)[Reduced by ontology matching]][
    / Terminological heterogeneity: different terms refer to the same concept. The same term can also refer to different concepts.
    / Conceptual (semantic) heterogeneity: difference in granularity, coverage and perspective
]
/ Semiotic (pragmatic) heterogeneity: different interpretations with regards to different context

Ontology matching finds correspondences between semantically related entities of the ontologies.

#def[Correspondence][
    Given two ontologies $o$ and $o prime$, a correspondence between $o$ and $o prime$ is defined as $chevron.l "id", e , e prime, r, n chevron.r$, where
    - $"id"$ is a unique identifier of the correspondence
    - $e$ and $e prime$ are entities of $o$ and $o prime$ respectively (i.e. classes, properties, instances...)
    - $r$ is a relation
        - equivalence: $=$;
        - more general: $supset.eq.sq$;
        - more specific: $subset.eq.sq$;
        - disjointness: $bot$
        - ...
    - $n$ is a confidence measure in the range of $[0,1]$ for the correspondence between $e$ and $e prime$.
]

#def[Alignment][
    Given two ontologies $o$ and $o prime$, an alignment between $o$ and $o prime$ is a set of correspondences on $o$ and $o prime$ with some additional metadata like
    - multiplicity (`1:1`, `1:m`, `m:n`)
    - method
    - date
    - creator
]


== Terminology
/ Matching: is the process of finding relationships or correspondences between entities of different ontologies.
/ Alignment: is a set of correspondences between two or more (in case of multiple matching) ontologies. The alignment is the output of the matching process.
/ Correspondence: is the relation supposed to hold according to a particular matching algorithm or individual, between entities of different ontologies.
/ Mapping: is the oriented, or directed, version of an alignment.

#figure(image("src/om appl.png"), caption: [Ontology matching applications])

== Data Integration

/ Schema matching: focuses on finding the correspondence among schema elements in two semantically correlated schemata
/ Schema mapping: describes how a source database schema relates to a target database schema
/ Record linkage: (also known as entity resolution and deduplication) identifies records that refer to the same logical entity
/ Data fusion: focuses on resolving conflicts and determining the true data values, leveraging information in heterogeneous data sources

Some data integration challenges are
- attribute values are not the same;
- structural heterogeneity
- multiplicity for entities and attributes
- multilingual and cultural differences
- matching score and threshold
- scalability issues (big datasets)

== Schema and Instance Matching

A schema is a structure of metadata that describes how data (instances) can be stored, accessed and interpreted by users and applications. A *schema matches* when two concepts or two properties are the same. *Instances match* when they refer to the same real-world entity in a given domain.

=== Categories of matching techniques

/ Element-level techniques: consider ontology entities or their instances in isolation from their relations with other entities or their instances
  - String based: matching names or descriptions of entities (Hamming distance or N-gram)
  - Linguistic based: tokenization, lemmatisation, elimination
  - Constrained based: datatype and multiplicity comparison
  - Resource based: sense-based (WordNet)
  - Levenshtein distance represents the number of insertions, deletions, and substitutions required to change one word to another.
  - Phonetic based: phonetic encoding consists in encoding homophones in the same representation so that they can be matched despite minor differences in spelling.
  - Background knowledge-based matching
/ Structure-level techniques: consider the ontology entities or their instances to compare their relations with other entities or their instances.
  - Graph-based: consider ontologies as labelled graphs, assumption: if nodes are similar then their neighbours must be similar
  - Taxonomy-based: consider only specialisation/generalization relation
  - Model-based: take into account semantic interpretation of the ontologies, assumption: if two entities are the same then they share the same interpretation
  - Instance-based: use individual representation of classes, i e., classes are considered similar if they share many instances
/ Value oriented techniques: the similarity level of two records (entities) can be derived by matching the values of their comparable attributes. #h[Strong focus on similarity of string attributes].

=== Classification of matching vs non-matching

When the similarity of each pair of corresponding attribute values is computed, a decision engine is needed to classify whether two entities match or not trough:
/ Learning based techniques:
/ Similarity based techniques:
/ Rule based techniques:
/ Context based techniques:
