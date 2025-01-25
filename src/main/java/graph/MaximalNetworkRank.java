package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        System.out.println(maximalNetworkRank(n, roads));
    }
    static int maximalNetworkRank(int n, int[][] roads) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] road: roads) {
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int maxRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n; j++) {
                int rank = graph.get(i).size() + graph.get(j).size();
                if (graph.get(i).contains(j)) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}
