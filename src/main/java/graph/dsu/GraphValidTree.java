package graph.dsu;

// https://leetcode.com/problems/graph-valid-tree/

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        DSU dsu = new DSU(n);

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            if (dsu.find(u) == dsu.find(v)) return false;

            dsu.union(u, v);
        }

        return true;
    }

}
