package graph;

import java.util.*;

public class DesignGraph {


    static class Graph {
        List<List<Edge>> graph;
        int INFINITY;
        int src, dest, cost;

        public Graph(int n, int[][] edges) {
            graph = new ArrayList<>();
            INFINITY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            src = edge[0];
            dest = edge[1];
            cost = edge[2];
            graph.get(src).add(new Edge(src, dest, cost));
        }

        public int shortestPath(int node1, int node2) {
            int[] distancesFromSrc = new int[graph.size()];
            Arrays.fill(distancesFromSrc, INFINITY);

            PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
            minHeap.offer(new Edge(node1, node1, 0));
            distancesFromSrc[node1] = 0;

            while (!minHeap.isEmpty()) {
                Edge currEdge = minHeap.poll();

                int source = currEdge.u;
                int destination = currEdge.v;
                int edgeCost = currEdge.d;

                if (edgeCost > distancesFromSrc[destination]) continue;

                distancesFromSrc[destination] = edgeCost;

                if (destination == node2) return distancesFromSrc[destination];

                for (Edge neighbor : graph.get(destination)) {
                    int neighborDest = neighbor.v;
                    int neighborCost = neighbor.d;

                    if (distancesFromSrc[neighborDest] != INFINITY) continue;

                    minHeap.offer(new Edge(destination, neighborDest, neighborCost + edgeCost));
                }
            }

            return distancesFromSrc[node2] == Integer.MAX_VALUE ? -1 : distancesFromSrc[node2];
        }
    }

    static class Edge {
        int u;
        int v;
        int d;

        public Edge(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }
    }

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
}
