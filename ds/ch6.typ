= Naming in Distributed Systems

== Names, Addresses, and Identifiers
In distributed systems, a name is a string of bits or characters used to refer to an entity, which can be practically anything, such as a host, file, or network connection. To operate on an entity, a process must access it through an access point. The name of this access point is known as an address. Because entities can move or change access points (e.g., a mobile computer getting a new IP address), it is highly inflexible to use an address as the primary name for an entity. Instead, systems prefer location-independent names that remain valid even if the entity's address changes.

A true identifier is a special type of name with three strict properties: it refers to at most one entity, each entity is referred to by at most one identifier, and an identifier is never reused. Identifiers make it easy to unambiguously refer to entities, whereas human-friendly names (like "John Smith" or "www.utwente.nl") are generally represented as character strings and are designed for human convenience. The core challenge of any naming system is name resolution: the process of mapping a name or identifier to the address of the associated entity.

== Flat Naming
Flat names are random bit strings or identifiers that contain no intrinsic information on how to locate the access point of the entity they represent. Several techniques exist to resolve flat names:

-   *Broadcasting and Multicasting:* A request containing the identifier is broadcast to all machines on a network, and only the machine hosting the entity replies with the address. This is simple but highly unscalable, though multicasting can reduce the overhead by targeting only specific groups.
-   *Forwarding Pointers:* When an entity moves, it leaves behind a reference (pointer) at its old location pointing to its new address. While simple, this creates long, unbounded chains that are highly vulnerable to broken links; if a single pointer is lost, the entity becomes unreachable.
-   *Home-Based Approaches:* Popularized by Mobile IP, an entity is assigned a stable "home location" that keeps track of its current whereabouts. When the entity moves, it registers a temporary "care-of address" with the home agent. Packets sent to the home are tunneled to the care-of address. The main drawbacks are increased communication latency (if the entity is far from home) and the fact that the home acts as a single point of failure.
-   *Distributed Hash Tables (DHTs):* Entities and nodes are assigned random identifiers from a massive space (e.g., 160-bit keys in Chord). By using mathematical structures like an overlay ring and finger tables, lookups can be deterministically routed to the node responsible for a specific key in $O(log N)$ network hops, avoiding centralized bottlenecks.

== Structured Naming and DNS
Unlike flat names, structured names are composed of human-readable labels organized into a name space, which is typically represented as a directed acyclic graph or a hierarchical tree. 

The Domain Name System (DNS) is the most prominent structured naming system, organizing names in a rooted tree where each label is a case-insensitive string. A node in the DNS tree represents a domain and contains various Resource Records. Crucial record types include `A` records (IPv4 addresses), `MX` records (mail servers), `SRV` records (specific services), `NS` records (name servers for the zone), and `CNAME` records (symbolic links to a primary canonical name).

*Name Resolution Strategies:*
When resolving a path name across distributed name servers, two primary strategies are used:
-   *Iterative Name Resolution:* A client's resolver queries the root server, which resolves as much of the name as possible and returns the address of the next-level name server. The client must then independently contact this next server, repeating the process until the final address is found. This places less burden on high-level servers but increases network traffic for the client.
-   *Recursive Name Resolution:* A server receives a query and directly asks the next-level server to resolve the remainder of the path, eventually passing the final result all the way back up the chain to the client. This approach allows servers to cache intermediate lookup results effectively and drastically reduces long-distance communication costs, but it places a massive computational burden on high-level global servers.

== Location in Mobile and Large-Scale Systems
Because mobile entities change addresses far faster than DNS caches can update, alternative mechanisms like Hierarchical Location Services (HLP) are utilized. In an HLP, the network is divided into non-overlapping leaf domains, which are grouped into higher-level domains forming a tree of directory nodes. 

A leaf node stores the actual address of an entity currently residing in its domain. Higher-level directory nodes store a simple pointer directing requests to the subdomain where the entity is located. When looking up an entity, the search begins at the client's local leaf node and moves upward to the parent if the entity is not found locally. This inherently exploits locality: an entity is searched in a gradually expanding area centered around the client, minimizing wide-area network traffic if the entity is nearby. Modern Content Delivery Networks (CDNs) solve a related problem by replicating content physically closer to users, using Anycast routing to automatically direct clients to the nearest identical server.

== Network Routing vs. Name Resolution
RFC 791 conceptually divides communication into three layers: a *name* indicates what we seek, an *address* indicates where it is, and a *route* indicates how to get there. The Internet Protocol (IP) deals exclusively with addresses. Higher-level protocols (like DNS) map names to addresses, while lower-level protocols (like BGP for global routing, or OSPF for local subnets) map addresses to physical routes. Routing protocols essentially behave as distributed algorithms that discover optimal paths and fill the forwarding tables of local network routers. 

== Named-Data Networking (NDN)
Information-Centric Networking (ICN) and Named-Data Networking (NDN) challenge the traditional IP paradigm by questioning the need for name-to-address resolution altogether. Instead of resolving a name to an IP address and routing a connection to a specific host, NDN applications simply request data by its structured name (e.g., `/distributed-systems.net/books/...`). The network itself routes the request toward a location where the data is stored and returns a copy to the requester.

An NDN router relies on three primary components:
1.  *Content Store:* A local cache for previously retrieved data. If incoming named data is already cached here, the router immediately returns it.
2.  *Pending Interest Table (PIT):* Tracks incoming requests ("interests") and the network interfaces they originated from. It allows the router to remember exactly where to send the data back once it is found, and then clear the entry.
3.  *Forwarding Information Base (FIB):* Tells the router where to forward a request if the data is not in the Content Store (e.g., passing it to neighboring routers). 