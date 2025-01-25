package graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumDiameterAfterMerge {

    static List<List<Integer>> graph1;
    static List<List<Integer>> graph2;
    static int n;
    static int m;

    public static void main(String[] args) {

    }
    private static void intialize(int[][] edges1, int[][] edges2) {
        int n = edges1.length;
        int m = edges2.length;
        graph1 = new ArrayList<>();
        graph2 = new ArrayList<>();

        buildGraph(edges1, graph1);
        buildGraph(edges2, graph2);
    }

    private static void buildGraph(int[][] edges, List<List<Integer>> graph) {
        for (int idx = 0; idx < n; ++idx) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

    }
}
