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


Spanning Tree:
    
    A spanning tree is a connected subgraph in an undirected graph where all vertices are connected 
    with the minimum number of edges. In Figure 9, all pink edges [(A, B), (A, C), (A, D), (A, E)] form a tree,
    which is a spanning tree of this undirected graph. Note that [(A, E), (A, B), (B, C), (C, D)] is also 
    a spanning tree of the undirected graph. Thus, an “undirected graph” can have multiple spanning trees.

Minimum Cost Spanning Tree:

    A minimum spanning tree is a spanning tree with the minimum possible total edge weight in a “weighted undirected graph”.

To Construct Minimum Spanning Tree, below are the algorithms:

    1. Kruskal’s Algorithm (https://leetcode.com/problems/min-cost-to-connect-all-points/editorial/)
    2. Prim’s Algorithm (https://leetcode.com/problems/min-cost-to-connect-all-points/editorial/)

Cut Property:

    cut is a partition of vertices in a “graph” into two disjoint subsets.

Kruskal’s Algorithm:

    Kruskal’s Algorithm builds the spanning tree by adding edges one by one into a growing spanning tree.
    Kruskal's algorithm follows greedy approach as in each iteration it finds an edge which has least weight and add it to the growing spanning tree.
    Algorithm Steps:

        1. Sort the graph edges with respect to their weights.
        2. Start adding edges to the MST from the edge with the smallest weight until the edge of the largest weight.
        3. Only add edges which doesn't form a cycle , edges which connect only disconnected components.
        4. So now the question is how to check if two vertices are connected or not ? We can use Disjoint sets here to check if two vertices are connected or not.
        5. If the two vertices are connected then adding an edge between them will create a cycle , otherwise it won't.
        6. Initially all vertices are disconnected , so first step is to make each of them a separate disjoint set.
        7. Now iterate over all the edges and keep adding all those edges whose vertices are not in the same disjoint set.
        8. Stop when we have v-1 edges in the spanning tree , where v is the number of vertices in the graph.

Prim’s Algorithm:

    Prim’s Algorithm also use Greedy approach to find the minimum spanning tree.
    In Prim’s Algorithm we grow the spanning tree from a starting position.
    Unlike an edge in Kruskal's, we add vertex to the growing spanning tree in Prim's.
    We randomly select a vertex from the graph and then add the least weighted edge connecting the vertex to the growing spanning tree.
    After the first vertex is added to the growing spanning tree, we add the next least weighted edge which has one vertex from the growing spanning tree and other from the vertices which are not yet added to the spanning tree.
    This process continues until all the vertices are added to the spanning tree.
    Algorithm Steps:

        1. Maintain two disjoint sets of vertices. One containing vertices that are in the growing spanning tree and other that are not in the growing spanning tree.
        2. Select the cheapest vertex that is connected to the growing spanning tree and is not in the growing spanning tree and add it into the growing spanning tree. This can be done using Priority Queues. Insert all the edges that are connected to growing spanning tree in the Priority Queue and the edge with the smallest weight is the root of the Priority Queue.
        3. Remove the edge with the smallest weight from the Priority Queue. If the removed edge connects two vertices that are in the different sets then add it into the minimum spanning tree and merge two sets into one. Otherwise discard the removed edge.
        4. Repeat step 2 and step 3 until there are no more edges left in the Priority Queue.



Single Source Shortest Path:

    Single source shortest path is a path between a source vertex and all other vertices in the graph.
    The source vertex is the first vertex in the path and the destination vertex is the last vertex in the path.
    There can be many paths between the source and destination vertices.
    The shortest path is the path with minimum number of edges in the graph.
    There can be many shortest paths between the source and destination vertices.
    The shortest path can also be defined as the path with minimum weight in the graph.
    There can be many paths with minimum weight between the source and destination vertices.
    The shortest path can also be defined as the path with minimum weight in the graph.
    There can be many paths with minimum weight between the source and destination vertices.
    The shortest path can also be defined as the path with minimum weight in the graph.
    There can be many paths with minimum weight between the source and destination vertices.
    The shortest path can also be defined as the path with minimum weight in the graph.
    There can be many paths with minimum weight between the source and destination vertices.
    The shortest path can also be defined as the path with minimum weight in the graph.
    There can be many paths with minimum weight between the source and destination vertices.
    The shortest path can also be defined as the path with minimum weight in the graph.
    There can be many paths with minimum weight between the source and destination vertices.
    The shortest path can also be defined as the path with minimum weight in the graph.
    There can be many paths with minimum weight between the source and destination vertices.

Algorithms to find Single Source Shortest Path:

    1. Dijkstra’s Algorithm
    2. Bellman-Ford Algorithm
    3. Floyd-Warshall Algorithm (All pairs shortest path)


Dijkstra’s Algorithm:
        
    Dijkstra’s Algorithm is used to find the shortest path from a source vertex to all other vertices in a graph.
    It works only for the graphs with non-negative edge weights.
    It is a Greedy Algorithm.
    It finds a shortest path tree for a weighted undirected graph.
    This means it finds the shortest paths between nodes in a graph, which may represent, for example, road networks.
    It was conceived by computer scientist Edsger W. Dijkstra in 1956 and published three years later.
    The algorithm exists in many variants. Dijkstra's original algorithm found the shortest path between two given nodes,
    but a more common variant fixes a single node as the "source" node and finds shortest paths from the source to all other nodes in the graph,
    producing a shortest-path tree.
    For a given source node in the graph, the algorithm finds the shortest path between that node and every other.
    It can also be used for finding the shortest paths from a single node to a single destination node by stopping the algorithm once the shortest path to the destination node has been determined.
    For example, if the nodes of the graph represent cities and edge path costs represent driving distances between pairs of cities connected by a direct road (for simplicity, ignore red lights, stop signs, toll roads and other obstructions),
    Dijkstra's algorithm can be used to find the shortest route between one city and all other cities.
    A widely used application of shortest path algorithm is network routing protocols, most notably IS-IS (Intermediate System to Intermediate System) and Open Shortest Path First (OSPF).
    It is also employed as a subroutine in other algorithms such as Johnson's.
    The importance of shortest path algorithm derives from the fact that shortest paths are widely used in application-level routing and as a subroutine in other graph algorithms.
    It is also sometimes used to solve the Travelling Salesman Problem.
    For a given source vertex (node) in the graph, the algorithm finds the path with lowest cost (i.e. the shortest path) between that vertex and every other vertex.
    It can also be used for finding costs of shortest paths from a single vertex to a single destination vertex by stopping the algorithm once the shortest path to the destination vertex has been determined.
    For example, if the vertices of the graph represent cities and edge path costs represent driving distances between pairs of cities connected by a direct road (for simplicity, ignore red lights,


Bellman-Ford Algorithm:

    Bellman-Ford algorithm is used to find the shortest paths from the source vertex to all other vertices in a weighted graph.
    It depends on the following concept: Shortest path contains at most n-1 edges, because the shortest path couldn't have a cycle.
    So why shortest path shouldn't have a cycle ?
    There is no need to pass a vertex again, because the shortest path to all other vertices could be found without the need for a second visit for any vertices.
    So, in order to relax all edges (shorten the paths) of a graph, Bellman-Ford uses relaxation principle over and over again.
    In the beginning all vertices have a weight of infinity, except the source vertex, weigth of source vertex is 0.
    So, the algorithm relaxes all edges n-1 times, where n is the number of vertices in the graph.
    This algorithm is correct, and it works for graphs with negative edges, but if there is a negative cycle, it fails.
    Because, as we said before, shortest path couldn't have a cycle, but if there is a negative cycle, pathes could be shorten infinitely.
    So, Bellman-Ford algorithm can detect negative cycles.
    If there is a negative cycle, it reports it.
    So, Bellman-Ford algorithm reports the shortest path from the source vertex to all other vertices, and it also reports if there is a negative cycle reachable from the source.
    Bellman-Ford algorithm is slower than Dijkstra.
    Dijkstra is a greedy algorithm, and Bellman-Ford is not a greedy algorithm.
    Bellman-Ford algorithm is slower than Dijkstra, because it checks all edges n-1 times for relaxation.
    So, the time complexity of Bellman-Ford is O(VE), which is asymptotically equal to O(V^2), since E is O(V^2).
    Bellman-Ford algorithm is slower than Dijkstra, because it checks all edges n-1 times for relaxation.
    So, the time complexity of Bellman-Ford is O(VE), which is asymptotically equal to O(V^2), since E is O(V^2).
    Bellman-Ford algorithm is slower than Dijkstra, because it checks all edges n-1 times for relaxation.
    So, the time complexity of Bellman-Ford is O(VE), which is asymptotically equal to O(V^2), since E is O(V^2).



Floyd-Warshall Algorithm:


    Floyd-Warshall algorithm is used to find all pair shortest path problem from a given weighted graph.
    As a result of this algorithm, it will generate a matrix, which will represent the minimum distance from any node to all other nodes in the graph.
    It is used for finding the shortest paths between nodes in a graph, which may represent, for example, road networks.
    It was published by Robert Floyd and Stephen Warshall in 1962.
    The algorithm is an example of dynamic programming.
    Floyd-Warshall algorithm is a good example of dynamic programming, because it solves a sub-problem, then saves the result of this sub-problem to solve the next sub-problem.
    So, it uses the results of the previous sub-problems to solve the next sub-problems.
    Floyd-Warshall algorithm is a good example of dynamic programming, because it solves a sub-problem, then saves the result of this sub-problem to solve the next sub-problem.
    So, it uses the results of the previous sub-problems to solve the next sub-problems.
    Floyd-Warshall algorithm is a good example of dynamic programming, because it solves a sub-problem, then saves the result of this sub-problem to solve the next sub-problem.
    So, it uses the results of the previous sub-problems to solve the next sub-problems.
    Floyd-Warshall algorithm is a good example of dynamic programming, because it solves a sub-problem, then saves the result of this sub-problem to solve the next sub-problem.
    So, it uses the results of the previous sub-problems to solve the next sub-problems.
    Floyd-Warshall algorithm is a good example of dynamic programming, because it solves a sub-problem, then saves the result of this sub-problem to solve the next sub-problem.
    So, it uses the results of the previous sub-problems to solve the next sub-problems.
    Floyd-Warshall algorithm is a good example of dynamic programming, because it solves a sub-problem, then saves the result of this sub-problem to solve the next sub-problem.
    So, it uses the results of the previous sub-problems to solve the next sub-problems.
    Floyd-Warshall algorithm is a good example of dynamic programming, because it solves a sub-problem, then saves the result of this sub-problem to solve the next sub


Chromatic Number

    In graph theory, the chromatic number of a graph is the smallest number of colors needed to color the vertices of so that no two adjacent vertices share the same color.

Bipartite graph

    Any graph with chromatic number 2 is called a bipartite graph.

        Eg: A graph is bipartite if and only if it is 2-colorable, which means that its vertices can be colored with two colors (i.e., the graph is 2-colorable).
            Tree, Even length cycle graph, Complete graph with even number of vertices are bipartite graphs.


--> There is no shortest path in negative edge cycle.
--> BFS only finds shortest path in unweighted graph.