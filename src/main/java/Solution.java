import java.util.*;

class Solution {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] p : pipes) {
            int u = p[0], v = p[1], w = p[2];

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        for (int i = 0; i < n; i++) {
            int u = 0, v = i + 1, w = wells[i];

            adj[u].add(new int[] {v, w});
        }

        boolean[] inMST = new boolean[n + 1];

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k[1]));
        pq.offer(new int[]{0, 0});
        int total = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], w = cur[1];

            if (inMST[u]) continue;

            inMST[u] = true;
            total += w;

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (!inMST[v]) {
                    pq.offer(new int[] {v, w1});
                }
            }
        }

        return total;
    }
}