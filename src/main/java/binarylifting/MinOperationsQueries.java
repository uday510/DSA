package binarylifting;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinOperationsQueries {

    int[][] up, count;
    int[] parent, depth;
    int LOG;
    List<int[]>[] adj;


    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        LOG = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[LOG][n];
        parent = new int[n];
        depth = new int[n];
        adj = new ArrayList[n];
        count = new int[n][27];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }

        int root = 0;
        depth[root] = 0;
        parent[root] = -1;

        boolean[] vis = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        vis[root] = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] nxt : adj[u]) {
                int v = nxt[0], w = nxt[1];
                if (vis[v]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                for (int x = 1; x <= 26; x++)
                    count[v][x] = count[u][x];
                count[v][w]++;
                vis[v] = true;
                queue.offer(v);
            }
        }

        for (int v = 0; v < n; v++)
            up[0][v] = parent[v];

        for (int k = 1; k < LOG; k++) {
            for (int v = 0; v < n; v++) {
                int mid = up[k - 1][v];
                up[k][v] = (mid == -1) ? -1 : up[k - 1][mid];
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int u = q[0], v = q[1];
            int l = lca(u, v);
            int p = depth[u] + depth[v] - 2 * depth[l];

            int mx = 0;
            for (int w = 1; w <= 26; w++) {
                int c = count[u][w] + count[v][w] - 2 * count[l][w];
                if (c > mx) mx = c;
            }

            res[i] = p - mx;
        }

        return res;

    }
    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        int dif = depth[u] - depth[v];

        for (int i = 0; i < LOG; i++) {
            if ( ((dif >> i) & 1) == 1) {
                u = up[i][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k > -1; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}
