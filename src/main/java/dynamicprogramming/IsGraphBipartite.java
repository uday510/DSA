/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 *
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
 */
package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3,4},{0, 3, 4}, {0, 3}, {0, 1, 2, 4}, {0, 1, 3}};

        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] color = new int[nodes];

        Arrays.fill(color, -1);

        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(new int[]{graph[i][j], 0});
            }
        }

        for (int i = 0; i < nodes; i++) {
            if (color[i] == -1) {
                if (!dfs(i, adjList, color)) {
                    return false;
                }
            }
        } return true;
    }
    public static boolean dfs(int i, List<List<int[]>> graph, int[] color) {
        if (color[i] == -1) {
            color[i] = 0;
        }

        for (int[] adj : graph.get(i)) {
            if (color[adj[0]] == -1) {
                color[adj[0]] = 1 - color[i];
                if (!dfs(adj[0], graph, color)) {
                    return false;
                }
            } else if (color[adj[0]] == color[i]) {
                return false;
            }
        } return true;
    }
}
