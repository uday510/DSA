package graph;

import java.util.HashSet;
import java.util.Set;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] edges) {
        Set<Integer>[] adjList = new HashSet[n];

        for (int i = 0; i < n; i++) adjList[i] = new HashSet<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int curRank = adjList[i].size() + adjList[j].size();
                if (adjList[i].contains(j)) {
                    curRank--;
                }

                maxRank = Math.max(curRank, maxRank);
            }
        }

        return maxRank;
    }

}
