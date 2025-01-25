/**
 * Problem Description
 *
 * Given a weighted undirected graph having A nodes, a source node C and destination node D.
 *
 * Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
 *
 * You are expected to do it in Time Complexity of O(A + M).
 *
 * Note:
 *
 * There are no self-loops in the graph.
 *
 * No multiple edges between two pair of vertices.
 *
 * The graph may or may not be connected.
 *
 * Nodes are Numbered from 0 to A-1.
 *
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 * 0 <= B[i][0], B[i][1] < A
 *
 * 1 <= B[i][2] <= 2
 *
 * 0 <= C < A
 *
 * 0 <= D < A
 *
 *
 *
 * Input Format
 *
 * The first argument given is an integer A, representing the number of nodes.
 *
 * The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
 *
 * The third argument given is an integer C, representing the source node.
 *
 * The fourth argument is an integer D, representing the destination node.
 *
 * Note: B[i][2] will be either 1 or 2.
 *
 *
 *
 * Output Format
 *
 * Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 * A = 6
 * B = [   [2, 5, 1]
 *         [1, 3, 1]
 *         [0, 5, 2]
 *         [0, 2, 2]
 *         [1, 4, 1]
 *         [0, 1, 1] ]
 * C = 3
 * D = 2
 * Input 2:
 *
 * A = 2
 * B = [   [0, 1, 1]
 *     ]
 * C = 0
 * D = 1
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The path to be followed will be:
 *     3 -> 1 (Edge weight : 1)
 *     1 -> 0 (Edge weight : 1)
 *     0 -> 2 (Edge weight : 2)
 * Total length of path = 1 + 1 + 2 = 4.
 * Explanation 2:
 *
 *  Path will be 0-> 1.
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AnotherBFS {
    public static void main(String[] args) {
        int[][] B = {{4, 10, 2},
                    {4, 5, 2},
                    {3, 9, 2},
                    {3, 10, 1},
                    {5, 6, 1},
                    {1, 4, 2},
                    {7, 10, 1},
                    {4, 8, 1},
                    {0, 6, 2},
                    {1, 5, 1},
                    {5, 9, 2},
                    {1, 10, 2},
                    {0, 7, 1}};
        int A = 11;
        int C = 5;
        int D = 10;
        System.out.println(solve(A, B, C, D));
    }
    public static int solve(int A, int[][] B, int C, int D) {
         // O(V + E) time complexity | O(V + E) space complexity
        int n = 200009;
        List<ArrayList<Integer>> adjList = new ArrayList<>(); // adjacency list
        boolean[] visited = new boolean[200009]; // visited array

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int src = ints[0];
            int dest = ints[1];
            int weight = ints[2];

            if (weight == 1) {
                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            } else {
                adjList.get(src).add(src + A); // add A to the node
                adjList.get(src + A).add(dest); // add the destination node

                adjList.get(dest).add(dest + A); // add A to the node
                adjList.get(dest + A).add(src); // add the source node
            }
        }
        visited[C] = true; // mark the source node as visited
        Queue<Edge> queue = new java.util.LinkedList<>(); // queue for BFS
        queue.add(new Edge(C, 0)); // add the source node

        while (!queue.isEmpty()) {
            Edge curr = queue.poll();
            int currNode = curr.dest;
            int currWeight = curr.weight;

            if (currNode == D) { // if the current node is the destination node
                return currWeight; // return the weight
            }

            for (int nextNode : adjList.get(currNode)) { // get the adjacent nodes
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new Edge(nextNode, currWeight + 1));
                }
            }
        }

        return -1;
    }
    static class Edge {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
