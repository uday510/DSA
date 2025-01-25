/**
 * Problem Description
 * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 *
 * NOTE:
 *
 * The cycle must contain atleast two nodes.
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 *
 *
 * Problem Constraints
 * 2 <= A <= 105
 *
 * 1 <= M <= min(200000,A*(A-1))
 *
 * 1 <= B[i][0], B[i][1] <= A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 *
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 *
 *
 *
 * Output Format
 * Return 1 if cycle is present else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = [  [1, 2]
 *         [4, 1]
 *         [2, 4]
 *         [3, 4]
 *         [5, 2]
 *         [1, 3] ]
 * Input 2:
 *
 *  A = 5
 *  B = [  [1, 2]
 *         [2, 3]
 *         [3, 4]
 *         [4, 5] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
 * Explanation 2:
 *
 *  The given graph doesn't contain any cycle.
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}};
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int[][] B) {
        // O(V + E) time complexity | O(V) space complexity
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < A; ++i) { // initialize graph
            graph.add(new ArrayList<>());
        }
        for (int[] edge : B) { // build graph
            graph.get(edge[0] - 1).add(edge[1] - 1);
        }
        boolean[] visited = new boolean[A]; // visited array
        boolean[] recStack = new boolean[A]; // recursion stack

        for (int i = 0; i < A; ++i) { // check for cycle in each component
            if (isCyclic(i, graph, visited, recStack)) {
                return 1; // if cycle is found, return true
            }
        }
        return 0;
    }
    public static boolean isCyclic(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) { // if node is already in recursion stack, then there is a cycle
            return true;
        }
        if (visited[node]) { // if node is already visited, then there is no cycle
            return false;
        }
        visited[node] = true; // mark node as visited and add it to recursion stack
        recStack[node] = true; // mark node as visited and add it to recursion stack

        for (int adj : graph.get(node)) { // check all adjacent nodes
            if (isCyclic(adj, graph, visited, recStack)) {
                return true; // if cycle is found, return true
            }
        }
        recStack[node] = false; // remove node from recursion stack
        return false; // if no cycle is found, return false
    }
}
