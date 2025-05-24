package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/description/?envType=problem-list-v2&envId=2c451k8e
public class ReachableNodesInSubdividedGraph {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        if (edges.length == 0) return 1;
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adjList[u].add(new int[] {v, w});
            adjList[v].add(new int[] {u, w});
        }

        int[] dists = new int[n];
        int INF = (int) 1e9;
        Arrays.fill(dists, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});
        dists[0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];

            if (dists[u] < d) continue;

            for (int[] next : adjList[u]) {
                int v = next[0], w = next[1];
                int nodes = d + w + 1;
                if (nodes < dists[v]) {
                    dists[v] = nodes;
                    pq.offer(new int[] {v, nodes});
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dists[i] <= maxMoves) result++;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int a = Math.max(0, maxMoves - dists[u]);
            int b = Math.max(0, maxMoves - dists[v]);
            result += Math.min(w, a + b);
        }

        return result;
    }
}
