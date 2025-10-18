package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/minimum-edge-reversals-so-every-node-is-reachable/

public class MinimumEdgeReversals {

    List<int[]>[] adjList;
    int[] res;
    boolean[] vis;

    public int[] minEdgeReversals(int n, int[][] edges) {
        adjList = new ArrayList[n];
        res = new int[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(new int[]{v, 0});
            adjList[v].add(new int[]{u, 1});
        }

        res[0] = dfs1(0);

        Arrays.fill(vis, false);
        dfs2(0);

        return res;
    }

    private int dfs1(int u) {
        vis[u] = true;

        int cur = 0;
        for (int[] e : adjList[u]) {
            int v = e[0], w = e[1];
            if (vis[v]) continue;
            cur += w + dfs1(v);
        }

        return cur;
    }

    private void dfs2(int u) {
        vis[u] = true;
        for (int[] e : adjList[u]) {
            int v = e[0], w = e[1];
            if (vis[v]) continue;
            res[v] = res[u] + (w == 0 ? 1 : -1);
            dfs2(v);
        }
    }
}
