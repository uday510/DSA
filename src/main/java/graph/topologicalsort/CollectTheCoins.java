package graph.topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/collect-coins-in-a-tree/

/**
 *
 * There exists an undirected and unrooted tree with n nodes indexed from 0 to n - 1. You are given an integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an array coins of size n where coins[i] can be either 0 or 1, where 1 indicates the presence of a coin in the vertex i.
 *
 * Initially, you choose to start at any vertex in the tree. Then, you can perform the following operations any number of times:
 *
 * Collect all the coins that are at a distance of at most 2 from the current vertex, or
 * Move to any adjacent vertex in the tree.
 * Find the minimum number of edges you need to go through to collect all the coins and go back to the initial vertex.
 *
 * Note that if you pass an edge several times, you need to count it into the answer several times.
 *
 * Input: coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 *
 */
public class CollectTheCoins {

    private static final Queue<Integer> queue = new ArrayDeque<>();

    public int collectTheCoins(int[] coins, int[][] edges) {

        int n = coins.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] deg = new int[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v); adj[v].add(u);
            deg[u]++; deg[v]++;
        }

        queue.clear();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            deg[u]--;
            for (int v : adj[u]) {
                deg[v]--;
                if (deg[v] == 1 && coins[v] == 0) queue.offer(v);
            }
        }

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                queue.offer(i);
            }
        }

        for (int r = 0; r < 2; r++) {
            int sz = queue.size();
            while (sz-- > 0) {
                assert !queue.isEmpty();
                int u = queue.poll();
                deg[u]--;
                for (int v : adj[u]) {
                    deg[v]--;
                    if (deg[v] == 1) queue.offer(v);
                }
            }
        }

        int rm = 0;
        for (int[] e : edges) {
            if (deg[e[0]] > 0 && deg[e[1]] > 0) {
                rm++;
            }
        }

        return rm * 2;
    }


}
