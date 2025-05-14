/**
 * Problem Description
 * Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 *
 * You have to find an integer array D of size A such that:
 *
 * D[i]: Shortest distance from the C node to node i.
 * If node i is not reachable from C then -1.
 * Note:
 *
 * There are no self-loops in the graph.
 * There are no multiple edges between two pairs of vertices.
 * The graph may or may not be connected.
 * Nodes are numbered from 0 to A-1.
 * Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 *
 *
 * Problem Constraints
 * 1 <= A <= 1e5
 *
 * 0 <= B[i][0],B[i][1] < A
 *
 * 0 <= B[i][2] <= 1e3
 *
 * 0 <= C < A
 *
 *
 *
 * Input Format
 * The first argument is an integer A, representing the number of nodes in the graph.
 * The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
 * The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.
 *
 *
 * Output Format
 * Return the integer array D.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 6
 * B = [   [0, 4, 9]
 *         [3, 4, 6]
 *         [1, 2, 1]
 *         [2, 5, 1]
 *         [2, 4, 5]
 *         [0, 3, 7]
 *         [0, 1, 1]
 *         [4, 5, 7]
 *         [0, 5, 1] ]
 * C = 4
 * Input 2:
 *
 * A = 5
 * B = [   [0, 3, 4]
 *         [2, 3, 3]
 *         [0, 1, 9]
 *         [3, 4, 10]
 *         [1, 3, 8]  ]
 * C = 4
 */
package graph.dijkstra;

import java.util.*;

public class _Dijkstra {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { {0, 4, 9},
                          {3, 4, 6},
                          {1, 2, 1},
                          {2, 5, 1},
                          {2, 4, 5},
                          {0, 3, 7},
                          {0, 1, 1},
                          {4, 5, 7},
                          {0, 5, 1} };

        int src = 4;
        int[] res = dijkstra(n, edges, src);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
    public static int[] dijkstra(int n, int[][] edges, int source) {
        // O(ElogV) time complexity | O(E + V) space complexity

        Map<Integer, List<int[]>> graph = new HashMap<>(); // adjacency list
        int[] distancesFromSrc = new int[n]; // distancesFromSrc array
        int INFINITY = Integer.MAX_VALUE;

        Arrays.fill(distancesFromSrc, INFINITY); // fill the distancesFromSrc array with infinity

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        for (int[] edge : edges) {
           int src = edge[0]; // source node
           int dest = edge[1]; // destination node
           int cost = edge[2]; // cost of the edge

           graph.putIfAbsent(src, new ArrayList<>()); // add the source node to the graph
           graph.get(src).add(new int[]{dest, cost}); // add the destination node and the cost to the source node

           graph.putIfAbsent(dest, new ArrayList<>()); // add the destination node to the graph
           graph.get(dest).add(new int[]{src, cost}); // add the source node and the cost to the destination node
        }

        minHeap.offer(new Edge(source, 0)); // source node
        distancesFromSrc[source] = 0; // distance to the source node is 0

        while (!minHeap.isEmpty()) {
            Edge currEdge = minHeap.poll(); // poll the current edge

            int dest = currEdge.destination; // destination node
            int cost = currEdge.cost; // cost of the edge

            if (cost > distancesFromSrc[dest]) continue; // if the cost is greater than the current distance, then we have already found a better path

            distancesFromSrc[dest] = cost; // update the distance of the current node [dest

            if (!graph.containsKey(dest)) continue; // if the current node is not in the graph, then we have already found the shortest path to it (since we are using a minHeap

            for (int[] neighbor : graph.getOrDefault(dest, new ArrayList<>())) {
                int neighborDest = neighbor[0];
                int neighborCost = neighbor[1];

                // if the cost is less than the current cost to reach the node from the source
                if (distancesFromSrc[neighborDest] != INFINITY) { continue; }

                minHeap.offer(new Edge(neighborDest, neighborCost + cost));
            }
        }
        for (int i = 1; i < distancesFromSrc.length; i++) {
            if (distancesFromSrc[i] == INFINITY) distancesFromSrc[i] = -1;
        } // if the distance is still infinity, then we have not found a path to it

        return distancesFromSrc;
    }
    static class Edge {
        int destination;
        int cost;
        Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}
