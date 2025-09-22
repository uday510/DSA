package graph.mst;

import java.util.*;

public class PrimsMST {

    public void prims(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        boolean[] inMst = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        List<int[]> mst = new ArrayList<>();
        int totalWeight = 0;

        // {u, v, w} : u = parent, v = node
        pq.offer(new int[]{-1, 0, 0});

        while (!pq.isEmpty() && mst.size() < n - 1) {
            int[] cur = pq.poll();
            int u = cur[0], v = cur[1], w = cur[2];

            if (inMst[v]) continue;
            inMst[v] = true;

            if (u != -1) { // skip first dummy edge
                mst.add(new int[]{u, v, w});
                totalWeight += w;
            }

            for (int[] nei : adj[v]) {
                int next = nei[0], weight = nei[1];
                if (!inMst[next]) {
                    pq.offer(new int[]{v, next, weight});
                }
            }
        }

        System.out.println("Edges in MST:");
        for (int[] e : mst) {
            System.out.println(e[0] + " - " + e[1] + " weight: " + e[2]);
        }
        System.out.println("Total weight = " + totalWeight);
    }

     static void main() {
        int n = 4;
        int[][] edges = {
                {0, 1, 1}, {0, 2, 1}, {1, 2, 1},
                {0, 3, 2}, {1, 3, 2}, {2, 3, 2}
        };

        PrimsMST prim = new PrimsMST();
        prim.prims(n, edges);
    }
}