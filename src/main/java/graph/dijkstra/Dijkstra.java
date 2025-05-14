package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    private static final int UNREACHABLE = (int) 1e9;

    // Time: O((V + E) logV) | Space: O(V + E)
    private int[] findShortestPathsFromSource(int n, int[][] edges, int source) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int idx = 0; idx < n; ++idx) adjList[idx] = new ArrayList<>();

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], dist = edge[2];
            adjList[from].add(new int[] {to, dist});
        }

        int[] dists = new int[n];
        Arrays.fill(dists, UNREACHABLE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[1], o2[1])));
        pq.offer(new int[] {source, 0});
        dists[source] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], dist = curr[1];

            if (dist > dists[node]) continue;

            for (int[] neighbor : adjList[node]) {
                int nextNode = neighbor[0], weight = dists[1];
                int newDist = weight + dist;

                if (newDist < dists[nextNode]) {
                    pq.offer(new int[] {nextNode, newDist});
                    dists[nextNode] = newDist;
                }
            }
        }

        return dists;
    }
}
