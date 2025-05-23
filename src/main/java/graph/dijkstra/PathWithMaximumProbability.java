package graph.dijkstra;

import java.util.*;

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double INTL = 1;
        List<Edge>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];

            adjList[u].add(new Edge(v, prob));
            adjList[v].add(new Edge(u, prob));
        }

        double[] probs = new double[n];

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(k -> k.prob));
        pq.offer(new Edge(start_node, INTL));
        probs[start_node] = INTL;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (probs[curr.node] > curr.prob) continue;

            for (Edge next : adjList[curr.node]) {
                double newProb = next.prob * curr.prob;

                if (newProb > probs[next.node]) {
                    probs[next.node] = newProb;
                    pq.offer(new Edge(next.node, newProb));
                }
            }
        }

        return probs[end_node] == INTL ? 0 : probs[end_node];
    }

    class Edge {
        int node;
        double prob;

        Edge(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
