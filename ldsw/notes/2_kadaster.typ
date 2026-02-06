#import "_ldsw.typ": *
#show: template
#let kd = [Kadaster]
= #kd Knowledge Graph (KKG)
How is linked data is being used in the real world. #kd maintains a wide range of geographical (and not) registers. The knowledge graph is born to provide a faster way to make queries between registers, without having to rely on IDs. Can be used to detect tax evasion from different data.
Challenges:
- Accessing data from geo-spatial services
- Provide easy access to your own data to avoid copies

Linked data was used because:
- it provides the semantics of the data so that there is a share understanding of what the data means;
- it ensures data authenticity to users;
- it provides information about how the data should be used.

#kd uses only 5-star *open* data.

Model timeline:
/ First Experiments: no standardized ontologies, schema is based on the API schema
/ New Approach to LD publication: reuse of international standards, ontologies are manually defined based on information models, non-standardized KKG model
/ Production Ready: reuse of international *standards*, MIM#footnote[Meta model for information models] based ontologies, *standardized* KKG model.

There are key register silos for #kd, Topographies, Restrictions, Demographic data,....

Companies use either use knowledge graph or SQL database.

In triplestore, it should be possible to reference other knowledge graphs via SPARQL queries.

Lessons Learned
/ Governance:
  - Adoption Strategy
  - Linksets: how two datasets are connected, who should create and maintain them?
  - Ownership
/ Modelling:
  - Modelling for a given use case
  - Modelling resources
/ Scope:
  - Use case driven vs. data push driven: only use data that is useful
