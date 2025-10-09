package graph.topologicalsort;

import java.util.*;

public class MinimumHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Integer>[] adjList = new ArrayList[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
            d[u]++; d[v]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (d[i] == 1) queue.offer(i);
        int rem = n;

        while (rem > 2) {
            int sz = queue.size();
            rem -= sz;
            for (int i = 0; i < sz && !queue.isEmpty(); i++) {
                int u = queue.pollFirst();
                d[u] = 0;
                for (int v : adjList[u]) {
                    if (d[v] == 0) continue;
                    d[v]--;
                    if (d[v] == 1) queue.offerLast(v);
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
