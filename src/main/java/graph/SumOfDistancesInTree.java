package graph;

import java.util.*;

public class SumOfDistancesInTree {
    public static void main(String[] args) {
      int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        return dfs(n, edges);
    }
    public static int[] dfs(int n, int[][] edges) {

        int [] result = new int[n];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int [] count = new int[n];

        return result;
    }
}
