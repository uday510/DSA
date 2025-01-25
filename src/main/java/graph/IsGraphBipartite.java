/*
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent
sets such that every edge connects a node in one and a node in the other.

 */
package graph;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};

        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(int index, int[][] graph, int[] color) {
         if (color[index] == 0) { // not visited
            color[index] = 1; // mark as visited
         }

        int[] edges = graph[index];

        for (int edge : edges) {
           if (color[edge] == 0) { // not visited
               color[edge] = -color[index]; // mark as visited and opposite color i.e 1 -> -1
               if (!dfs(edge, graph, color)) {
                   return false;
               }
           } else if (color[edge] == color[index]) { // if already visited and color is same
               return false;
           }
        }

        return true;
    }
}
