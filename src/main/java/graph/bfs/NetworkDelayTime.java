package graph.bfs;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adjList = new ArrayList[n + 1];

        for (int idx = 1; idx <= n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adjList[u].add(new int[] {v, w});
        }

        int[] signalTimes = new int[n + 1];
        int INF = (int) 1e9;

        Arrays.fill(signalTimes, INF);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {k, 0});
        signalTimes[k] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] curr = queue.poll();
            int u = curr[0], w = curr[1];

            if (signalTimes[u] < w) continue;

            for (int[] neighbor : adjList[u]) {
                int nextNode = neighbor[0], neighborWeight = neighbor[1];
                int newWeight = neighborWeight + w;

                if (newWeight < signalTimes[nextNode]) {
                    signalTimes[nextNode] = newWeight;
                    queue.offer(new int[] {nextNode, newWeight});
                }
            }
        }

        int minDelayTime = -INF;
        for (int idx = 1; idx <= n; ++idx) {
            int signalTime = signalTimes[idx];
            if (signalTime == INF) return -1;
            minDelayTime = Math.max(minDelayTime, signalTime);
        }

        return minDelayTime;
    }

}
