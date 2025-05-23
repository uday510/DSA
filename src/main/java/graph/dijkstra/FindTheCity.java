package graph.dijkstra;

// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/?envType=problem-list-v2&envId=2c451k8e

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindTheCity {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int idx = 0; idx < n; ++idx) adjList[idx] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjList[u].add(new int[] {v, w});
            adjList[v].add(new int[] {u, w});
        }

        int minReachable = (int) 1e9;
        int city = -1;

        for (int idx = 0; idx < n; ++idx) {
            int reachable = countReachable(idx, adjList, distanceThreshold, n);
            if (reachable <= minReachable) {
                city = idx;
                minReachable = reachable;
            }
        }
        return city;
    }

    private int countReachable(int src, List<int[]>[] adjList, int distanceThreshold, int n) {
        int INF = (int) 1e9;
        int[] dists = new int[n];
        Arrays.fill(dists, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[2]);
        pq.offer(new int[] {src, 0});
        dists[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];

            if (dists[u] < d) continue;

            for (int[] next : adjList[u]) {
                int v = next[0], w = next[1];

                if (w <= distanceThreshold && d + w < dists[v]) {
                    dists[v] = d + w;
                    pq.offer(new int[] {v, d + w});
                }
            }
        }

        int reachable = 0;

        for (int idx = 0; idx < n; ++idx) {
            if (idx != src && dists[idx] <= distanceThreshold) reachable++;
        }

        return reachable;
    }
}
