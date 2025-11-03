/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 */
package graph.shortest_path;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = (int) 1e9;
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adjList[u].add(new int[] {v, w});
        }

        int[] delayTimeFromK = new int[n + 1];
        Arrays.fill(delayTimeFromK, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[] {k, 0});
        delayTimeFromK[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];

            if (delayTimeFromK[u] < w) continue;

            for (int[] neighbor : adjList[u]) {
                int v = neighbor[0], neighborDelayTime = neighbor[1];
                int neighborDelayTimeFromU = neighborDelayTime + w;

                if (neighborDelayTimeFromU < delayTimeFromK[v]) {
                    delayTimeFromK[v] = neighborDelayTimeFromU;
                    pq.offer(new int[] {v, neighborDelayTimeFromU});
                }
            }
        }

        int minDelayTime = -INF;
        for (int idx = 1; idx <= n; ++idx) {
            int currDelayTime = delayTimeFromK[idx];
            if (currDelayTime == INF) return -1;
            minDelayTime = Math.max(minDelayTime, currDelayTime);
        }

        return minDelayTime;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
//        System.out.println(networkDelayTime(times, n, k));
    }

}
