package graph.shortest_path;

import java.util.*;

public class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<Edge>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            double w = succProb[i];

            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }

        double INF = Double.MIN_VALUE;
        double[] probs = new double[n];
        Arrays.fill(probs, INF);

        Queue<Edge> queue = new ArrayDeque<>();
        queue.offer(new Edge(start_node, 1));
        probs[start_node] = 1;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            int u = cur.v;
            double w = cur.w;

            if (u == end_node) return w;

            if (probs[u] > w) continue;

            for (Edge e : adjList[u]) {
                int v = e.v;
                double w1 = e.w;

                if ((w * w1) > probs[v]) {
                    probs[v] = w * w1;
                    queue.offer(new Edge(v, w * w1));
                }
            }
        }

        return 0;
    }
}

class Edge {
    final int v;
    double w;

    Edge(int v, double w) {
        this.v = v;
        this.w = w;
    }
}