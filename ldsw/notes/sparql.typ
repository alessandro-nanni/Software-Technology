#import "_ldsw.typ": *
#show: template
#let sp = [SPARQL]
= #sp
#sp Protocol and RDF Query Language (#sp) is an SQL like query language for RDF data. It's used to query remote databases over HTTP and has a syntax close to turtle.

At the core of #sp are triple patterns, which are RDF triples that include variables (denoted by a `?`) to match against triples in the target graph. For example, `?movie rdf:type schema:Movie` is a triple pattern.

A standard #sp query contains several structured components:
/ Prefix declarations: (optional) to create shortcuts for URIs;
/ Query results clause: (`SELECT`, `ASK`, `DESCRIBE`, or `CONSTRUCT`);
/ Dataset definition: (`FROM`), which is optional;
/ Query pattern: defined within a `WHERE { ... }` block.
/ Query modifiers: such as `GROUP BY`, `HAVING`, `ORDER BY`, `LIMIT`, `OFFSET`, and `VALUES`.

SPARQL supports four primary *types of queries*:
/ `ASK`: Evaluates whether a query pattern has any matches in the dataset. It returns a simple boolean result (`true` or `false`).
/ `CONSTRUCT`: Generates and returns a new RDF graph constructed from the matching triple patterns.
/ `DESCRIBE`: Returns an RDF graph that "describes" the specified resources. The exact interpretation of what describes a resource (e.g., concise-bounded descriptions or named graphs) is left up to the server implementation.
/ `SELECT`: Returns results as a tabular projection of variables and expressions, where each selected variable forms a column and each match forms a row.

You can use `SELECT *` to return all variables defined in the query. You can project specific variables (e.g., `SELECT ?actor`) which returns a table of just that variable, though it may contain duplicate rows. Using `SELECT DISTINCT` removes duplicate rows from the results.

== Advanced Query Keywords
SPARQL provides several keywords to refine how patterns are matched:
/ `UNION`: Combines the results of multiple graph patterns. If a match is found in either pattern, it is included in the final results.
/ `OPTIONAL`: Allows you to request additional information if it exists, without failing the entire query if it does not. If the optional data is missing, the variable simply remains "unbound".
/ `FILTER`: Applies constraints to variables, restricting the results. For example, a `FILTER` can be used to ensure a date variable falls within a specific numeric or chronological range.

==  Named Graphs
An RDF dataset is a collection of triples (a graph). By default, triples are added to a single "default graph" (also called an unnamed graph). However, subsets of triples can be separated into "named graphs", which can be serialized using formats like TriG.
When querying, every SPARQL query runs against at least the default graph, one or more named graphs, or a merged set of both.
The `FROM` clause defines the default graph for the query. If multiple `FROM` clauses are used, the specified graphs are merged, and they lose their individual named identities during the query.
The `FROM NAMED` clause specifies active named graphs to be used in the query, maintaining their named identity. To query specifically within these bounds, the `GRAPH <graph_name> { ... }` keyword must be used inside the `WHERE` clause. If `FROM NAMED` is used without a `GRAPH` block, the query targets the default graph and may return no results.
== Federated Queries
Federated queries allow you to dynamically integrate data from multiple sources by querying multiple SPARQL endpoints within a single query. This requires a "linking point," which is a common identifier shared across the multiple sources. This is achieved using the `SERVICE` clause, which directs a specific part of the query block to execute against a specified remote SPARQL endpoint, while the rest of the query can execute against the local source.
