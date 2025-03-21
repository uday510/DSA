/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
package graph;

import java.util.*;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
    static List<List<Integer>> paths;
    static List<Integer>[] adjList;
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // O(2^V * V) time | O(V) space where V is the number of vertices in the graph
        /**
         * There are 2^V possible paths in the graph,
         * and each path can have at most V vertices,
         * we need O(V) time to build each path,
         */
        paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }
        adjList = new ArrayList[graph.length];

        for (int idx = 0; idx < graph.length; ++idx) {
            adjList[idx] = new ArrayList<>();
            for (int node : graph[idx]) {
                adjList[idx].add(node);
            }
        }

        dfs(0, graph.length - 1, new ArrayList<>());
        return paths;
    }
    private static void dfs(int node, int dest, ArrayList<Integer> path) {
        path.add(node);
        if (node == dest) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : adjList[node]) {
            dfs(neighbor, dest, path);
            path.removeLast();
        }
    }

}
