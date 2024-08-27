package Graph;

import java.util.*;

public class MaxProbability {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0, end = 2;
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        // 1. Brute Force
//        double[] prob = new double[n];
//        prob[start] = 1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < edges.length; j++) {
//                int u = edges[j][0];
//                int v = edges[j][1];
//                double p = succProb[j];
//                prob[v] = Math.max(prob[v], prob[u] * p);
//                prob[u] = Math.max(prob[u], prob[v] * p);
//            }
//        }
//        return prob[end];

        // 2. Dijkstra's Algorithm
        Map<Integer, List<Hop<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
           double prob = succProb[i];
           graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Hop<>(v, prob));
           graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Hop<>(u, prob));
        }

        double[] prob = new double[n];
        prob[start] = 1;

        PriorityQueue<Hop<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        pq.add(new Hop<>(start, 1.0));

        while (!pq.isEmpty()) {
            var edge = pq.poll();
            int u = edge.getKey();
            double p = edge.getValue();
            if (u == end) return p;

            for (var next : graph.getOrDefault(u, new ArrayList<>())) {
                System.out.println(STR."\{u} --> \{next.destination} prob: \{next.weight}");
                int v = next.destination;
                double nextProb = next.weight;
                if (prob[v] < p * nextProb) {
                    prob[v] = p * nextProb;
                    pq.add(new Hop<>(v, prob[v]));
                }
            }
        }
        return 0d;
    }
    static class Hop<T1, T2> {
        public T1 destination;
        public T2 weight;

        public Hop(T1 node, T2 distance) {
            this.destination = node;
            this.weight = distance;
        }

        public T1 getKey() {
            return destination;
        }

        public T2 getValue() {
            return weight;
        }
    }
}
