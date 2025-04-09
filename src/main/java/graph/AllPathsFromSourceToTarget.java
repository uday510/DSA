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

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
    }

    // O(2^V * V) time | O(V) space where V is the number of vertices in the graph
    /**
     * There are 2^V possible paths in the graph,
     * and each path can have at most V vertices,
     * we need O(V) time to build each path,
     */

    int n;
    List<Integer>[] adjList;
    List<List<Integer>> paths;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        initialize(graph);
        dfs(0, new ArrayList<>());
        return paths;
    }
    private void dfs(Integer node, List<Integer> path) {
        path.add(node);
        if (node == n - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (Integer v : adjList[node]) {
            dfs(v, path);
            path.removeLast();
        }
    }

    private void initialize(int[][] graph) {
        this.n = graph.length;
        adjList = new ArrayList[n];
        paths = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            for (int v : graph[i]) {
                adjList[i].add(v);
            }
        }

    }

}
