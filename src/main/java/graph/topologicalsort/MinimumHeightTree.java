package graph.topologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjList[i].size() == 1) leaves.add(i);
        }

        int rem = n;

        while (rem > 2) {
            rem -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int nei = adjList[leaf].getFirst();
                adjList[nei].remove(Integer.valueOf(leaf));
                if (adjList[nei].size() == 1) {
                    newLeaves.add(nei);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
