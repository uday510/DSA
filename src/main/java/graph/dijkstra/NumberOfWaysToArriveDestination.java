package graph.dijkstra;

import java.util.*;

public class NumberOfWaysToArriveDestination {

    public int countPaths(int n, int[][] roads) {
        long INF = Long.MAX_VALUE;
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        long[] dists = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dists, INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(k -> k[1]));
        pq.offer(new long[]{0, 0});
        dists[0] = 0;
        ways[0] = 1;

        int MOD = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (dists[u] < d) continue;

            for (int[] next : adjList[u]) {
                int v = next[0], w = next[1];
                long newTime = d + w;

                if (newTime < dists[v]) {
                    ways[v] = ways[u];
                    dists[v] = newTime;
                    pq.offer(new long[] {v, newTime});
                } else if (newTime == dists[v]) {
                    // already the shortest path, now combine both ways
                    ways[v] = (ways[u] + ways[v]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}
