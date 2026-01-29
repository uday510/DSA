package graph;


import java.util.*;

//https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/?envType=daily-question&envId=2026-01-29
public class MinimumCost {

    private int n = 26;
    private long INF = (long) 1e15;
    private List<List<Edge>> adj;

    public long minimumCost(String src, String dest, char[] or, char[] ch, int[] d) {
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < or.length; i++) {
            int u = or[i] - 'a', v = ch[i] - 'a';
            adj.get(u).add(new Edge(v, d[i]));
        }

        long min = 0;
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < src.length(); i++) {
            int u = src.charAt(i) - 'a', v = dest.charAt(i) - 'a';

            if (u == v) continue;

            long cur = dist[u][v];

            if (cur == INF) {
                cur = dijsktra(u, v);
                if (cur == INF) return -1;
                dist[u][v] = cur;
            }

            min += dist[u][v];
        }

        return min;
    }

    private long dijsktra(int src, int dest) {
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        Queue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(k -> k[1]));

        dist[src] = 0;
        pq.offer(new long[] {src, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long w = cur[1];

            if (w > dist[u]) continue;

            for (Edge e : adj.get(u)) {
                int v = e.v;
                long w1 = w + e.w;
                if (w1 < dist[v]) {
                    dist[v] = w1;
                    pq.offer(new long[] {v, w1});
                }
            }
        }

        return dist[dest];
    }


    class Edge {
        int v, w;

        Edge(int v, int w) { this.v = v; this.w = w; }
    }

}

