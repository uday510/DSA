package graph;

import java.util.*;

public class MaxProbability {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0, end = 2;
        System.out.println(calculateMaxProbability(edges, succProb, start, end, n));
    }

    private static final double INITIAL_PROBABILITY = 1.0;
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

    /**
     * Calculates the maximum probability path from the start node to the end node.
     *
     * @param edges          the edges of the graph
     * @param succProb       the success probabilities of the edges
     * @param start          the starting node
     * @param end            the ending node
     * @param n              the number of nodes
     * @return the maximum probability of reaching the end node
     */
    public static double calculateMaxProbability(int[][] edges, double[] succProb, int start, int end, int n) {
        Map<Integer, List<Hop<Integer, Double>>> adjacencyList = buildGraph(edges, succProb);

        double[] probabilities = new double[n];
        probabilities[start] = INITIAL_PROBABILITY;

        PriorityQueue<Hop<Integer, Double>> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b.getWeight(), a.getWeight()));
        priorityQueue.add(new Hop<>(start, INITIAL_PROBABILITY));

        while (!priorityQueue.isEmpty()) {
            var currentHop = priorityQueue.poll();
            int currentNode = currentHop.getDestination();
            double currentProbability = currentHop.getWeight();

            if (currentNode == end) {
                return currentProbability;
            }

            for (var nextHop : adjacencyList.getOrDefault(currentNode, Collections.emptyList())) {
                int nextNode = nextHop.getDestination();
                double nextProbability = nextHop.getWeight() * currentProbability;

                System.out.println(STR."nextNode: " + nextNode + " nextProbability: " + nextProbability);

                if (nextProbability > probabilities[nextNode]) {
                    probabilities[nextNode] = nextProbability;
                    priorityQueue.add(new Hop<>(nextNode, nextProbability));
                }
            }
        }
        return 0d;
    }
    private static Map<Integer, List<Hop<Integer, Double>>> buildGraph(int[][] edges, double[] succProb) {
        Map<Integer, List<Hop<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new Hop<>(v, p));
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(new Hop<>(u, p));
        }
        return graph;
    }
    private static class Hop<T1, T2> {
        public T1 destination;
        public T2 weight;

        public Hop(T1 node, T2 distance) {
            this.destination = node;
            this.weight = distance;
        }

        public T1 getDestination() {
            return destination;
        }

        public T2 getWeight() {
            return weight;
        }
    }
}
