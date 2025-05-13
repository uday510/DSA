/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 */
package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
//        System.out.println(networkDelayTime(times, n, k));
    }

    private static final int INF = (int) 1e9;
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();
        for (int[] t : times) adjList[t[0]].add(new int[] {t[1], t[2]});

        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {k, 0});
        dists[k] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if (dists[node] < d) continue;

            for (int[] next : adjList[node]) {
                if (next[1] + d < dists[next[0]]) {
                    pq.offer(new int[] {next[0], d + next[1]});
                    dists[next[0]] = next[1] + d;
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= n; ++i) {
            if (dists[i] == INF) return -1;
            max = Math.max(max, dists[i]);
        }

        return max;
    }

}
