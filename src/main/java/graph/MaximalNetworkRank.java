package graph;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] edges) {

        boolean[][] conns = new boolean[n][n];
        int[] deg = new int[n];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            conns[u][v] = true;
            conns[v][u] = true;
            deg[v]++;
            deg[u]++;
        }

        int mx = 0;
        for (int u = 0; u < n; u++) {
            int du = deg[u];

            for (int v = u + 1; v < n; v++) {
                int cur = du + deg[v] - (conns[u][v] ? 1 : 0);

                mx = Math.max(cur, mx);
            }
        }

        return mx;
    }

}
