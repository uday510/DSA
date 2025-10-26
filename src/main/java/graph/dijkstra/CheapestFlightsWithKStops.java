package graph.dijkstra;

import java.util.*;

public class CheapestFlightsWithKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adjList = new ArrayList[n];
        int[][] dist = new int[n][k + 2];
        int inf = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            Arrays.fill(dist[i], inf);
        }

        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adjList[u].add(new int[]{v, w});
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0, 0});
        dist[src][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], stops = cur[1], w = cur[2];

            if (stops > k ) continue;

            for (int[] nxt : adjList[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (w + w1 < dist[v][stops + 1]) {
                    dist[v][stops + 1] = w + w1;
                    queue.offer(new int[] {v, stops + 1, w + w1});
                }
            }
        }

        int minDist = inf;
        for (int i = 0; i <= k + 1; i++) {
            minDist = Math.min(dist[dst][i], minDist);
        }

        return minDist == inf ? -1 : minDist;
    }

}
