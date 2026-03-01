package graph.topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/collect-coins-in-a-tree/
public class CollectTheCoins {

    public int collectTheCoins(int[] coins, int[][] edges) {

        int n = coins.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] deg = new int[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v); adj[v].add(u);
            deg[u]++; deg[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            deg[u]--;

            for (int v : adj[u]) {
                deg[v]--;

                if (deg[v] == 1 && coins[v] == 0) queue.offer(v);
            }
        }

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                queue.offer(i);
            }
        }

        for (int r = 0; r < 2; r++) {
            int sz = queue.size();

            while (sz-- > 0) {
                assert !queue.isEmpty();
                int u = queue.poll();
                deg[u]--;

                for (int v : adj[u]) {
                    deg[v]--;
                    if (deg[v] == 1) queue.offer(v);
                }
            }
        }

        int rm = 0;
        for (int[] e : edges) {
            if (deg[e[0]] > 0 && deg[e[1]] > 0) {
                rm++;
            }
        }

        return rm * 2;
    }


}
