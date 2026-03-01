package graph;

import java.util.*;

/**
 *
 *
 * Alex is playing a game in Hackerland and needs to collect coins from various locations.
 * The city is represented as a tree with vertices labeled from 0 to n- 1.
 * There is an array called coins of size n where coins) is either 0 or 1,
 * where 1 means the vertex contains a coin.
 *
 * Alex must travel along the tree's edges to collect all the coins.
 * The distance between two vertices is the number of edges between them.
 * From any given vertex x, Alex can collect all coins located within a distance of 2 edges from x.
 *
 *
 * The goal is to find the shortest path that allows Alex to collect all the coins.
 * Alex can choose any vertex but must start and end at that vertex.
 * The path can traverse the same edge multiple times, and all edges are bidirectional.
 *
 * Return the number of edges in the shortest path along which Alex can collect all the coins.
 *
 * Example
 * tree nodes - 11
 * tree from - [0, 0, 0, 1, 1, 3,  4, 6,  7, 8]
 * tree to -   [1, 2, 6, 3, 4, 10, 5, 7,  8, 9]
 * coin -      [0, 0, 1, 1, 0, 0,  0, 0, 1, 1]
 *
 */

public class Solution {

    public int findShortestPath(int n, int[] fr, int[] to, int[] coins) {

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int u = fr[i], v = to[i], w = coins[i];
            w = w == 1 ? 0 : 1;

            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }

        int inf = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, inf);

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(k -> k[1]));

        dist[0] = 0;
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1];

            if (dist[u] < w) continue;;

            for (int[] nxt : adj[u]) {
                int v = nxt[0], w1 = nxt[1];

                if (w + w1 < dist[v]) {
                    dist[v] = w + w1;
                    queue.offer(new int[] {v, w + w1});
                }
            }
        }

        int min = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist[i] == inf) {
                return -1;
            }
            min = Math.max(min, dist[i]);
        }

        return min;
    }
}
