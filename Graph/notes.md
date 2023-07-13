Graph is probably the data structure that has the closest resemblance to our daily life.
There are many types of graphs describing the relationships in real life. 
For instance, our friend circle is a huge “graph”.

Types of “graphs”
There are many types of “graphs”. In this Explore Card,
we will introduce three types of graphs: undirected graphs, 
directed graphs, and weighted graphs.

Undirected graphs
The edges between any two vertices in an “undirected graph” do not have a direction, 
indicating a two-way relationship.

Figure 1 is an example of an undirected graph.

Directed graphs
The edges between any two vertices in a “directed graph” graph are directional.

Figure 2 is an example of a directed graph.

Weighted graphs
Each edge in a “weighted graph” has an associated weight. 
The weight can be of any metric, such as time, distance, size, etc. 
The most commonly seen “weighted map” in our daily life might be a city map. 
In Figure 3, each edge is marked with the distance, which can be regarded as the weight of that edge.

DSU or disjoint set union or simpy union-find is a data structure is used to
check the connectivity between two vertices in a graph.


In Graph theory, the depth-first search algorithm (abbreviated as DFS) is mainly used to:

Traverse all vertices in a “graph”;
Traverse all paths between any two vertices in a “graph

Previously, we discussed the “depth-first search” algorithm.
This section will talk about a closely related and equally popular algorithm called “breadth-first search”.
Similarly, the “breadth-first search” algorithm can traverse all vertices of a “graph” and traverse all paths between two vertices. 
However, the most advantageous use case of “breadth-first search” is to efficiently find the shortest path between two vertices 
in a “graph” where all edges have equal and positive weights.

Although the “depth-first search” algorithm can find the shortest path between two vertices in a “graph”
with equal and positive weights, it must traverse all paths between two vertices before finding the shortest one.
The “breadth-first search” algorithm, in most cases, can find the shortest path without traversing all paths.
This is because when using "breadth-first search", as soon as a path between the source vertex and target vertex is found,
it is guaranteed to be the shortest path between the two nodes.

In Graph theory, the primary use cases of the “breadth-first search” (“BFS”) algorithm are:

Traversing all vertices in the “graph”;
Finding the shortest path between two vertices in a graph where all edges have equal and positive weights.

DFS --> Stack
BFS --> Queue


Applications of DSU:

        1. Detecting cycle in a graph
        2. Checking connectivity of a graph
        3. Finding connected components in a graph
        4. Finding MST of a graph
        5. Finding the shortest path between two nodes in a graph
        6. Finding the number of connected components in a graph
        7. Finding the number of edges in a graph
        8. Finding the number of vertices in a graph
