package graph.dijkstra;

import java.util.*;

public class Dijkstra {

    private static final int UNREACHABLE = (int) 1e9;

    // Time: O((V + E) logV) | Space: O(V + E)
    private int[][] findShortestPathsFromSource(int n, int[][] edges, int source) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int idx = 0; idx < n; ++idx) adjList[idx] = new ArrayList<>();

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], dist = edge[2];
            adjList[from].add(new int[] {to, dist});
        }

        int[] shortestDistanceFromSourceVertex = new int[n];
        Arrays.fill(shortestDistanceFromSourceVertex, UNREACHABLE);

        int[] previousVertex = new int[n];
        Arrays.fill(previousVertex, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        pq.offer(new int[] {source, 0});
        shortestDistanceFromSourceVertex[source] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], dist = curr[1];

            if (dist > shortestDistanceFromSourceVertex[node]) continue;

            for (int[] neighbor : adjList[node]) {
                int nextNode = neighbor[0], weight = neighbor[1];
                int newDist = weight + dist;

                if (newDist < shortestDistanceFromSourceVertex[nextNode]) {
                    pq.offer(new int[] {nextNode, newDist});
                    shortestDistanceFromSourceVertex[nextNode] = newDist;
                    previousVertex[nextNode] = node;
                }
            }
        }

        return new int[][] {shortestDistanceFromSourceVertex, previousVertex};
    }
}
