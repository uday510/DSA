package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkDelayTime {

    private List<int[]>[] adjList;
    private int[] signalTimes;

    public int networkDelayTime(int[][] times, int n, int k) {
        adjList = new ArrayList[n + 1];
        signalTimes = new int[n + 1];
        int INF = (int) 1e9;
        Arrays.fill(signalTimes, INF);

        for (int i = 1; i <= n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adjList[u].add(new int[] {v, w});
        }

        int minDelayTime = -INF;
        for (int signaTime : signalTimes) {
            if (signaTime == INF) return -1;
            minDelayTime = Math.min(minDelayTime, signaTime);
        }

        dfs(k, 0);

        return minDelayTime;
    }

    private void dfs(int u, int curr) {
        if (curr >= signalTimes[u]) return;

        signalTimes[u] = curr;

        for (int[] neighbor : adjList[u]) {
            int v = neighbor[0], w = neighbor[1];
            dfs(v, curr + w);
        }

    }

}
