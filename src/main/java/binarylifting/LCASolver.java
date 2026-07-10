package binarylifting;


// Given n (nodes labeled 0 to n-1), an edge list edges (n-1 undirected edges forming a tree rooted at 0),
// and a list of queries [[u1, v1], [u2, v2], ...],
// return answer[] where answer[i] = LCA of u_i and v_i

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LCASolver {

    private int LOG;
    private int[][] up;
    private int[] depth;

    public LCASolver(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int root = 0;

        int[] parent = new int[n];
        depth = new int[n];
        parent[root] = -1;
        depth[root] = 0;

        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        vis[root] = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (vis[v]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                vis[v] = true;
                queue.offer(v);
            }
        }

        //        LOG = 20 / 17 by default
//        LOG = Math.max(1, (int) Math.ceil(Math.log(n) / Math.log(2)));
        LOG = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[LOG][n];

        for (int v = 0; v < n; v++)
            up[0][v] = parent[v];

        for (int k = 1; k < LOG; k++) {
            for (int v = 0; v < n; v++) {
                int mid = up[k - 1][v];
                up[k][v] = (mid == -1) ? -1 : up[k - 1][mid];
            }
        }

    }

    public int lca(int u, int v) {
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

    static void main() {

        int n = 8;
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7}};
        int[][] queries = {{7,4},{7,6},{3,4},{5,3},{7,3},{2,2}};

        LCASolver lcaSolver = new LCASolver(n, edges);

        for (int[] q : queries) {
            int res = lcaSolver.lca(q[0], q[1]);

            System.out.println("LCA of " + q[0] + " " + q[1] + " : " + res);
        }

    }
}
