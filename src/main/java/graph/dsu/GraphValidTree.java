package graph.dsu;

// https://leetcode.com/problems/graph-valid-tree/

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            if (uf.connected(u, v)) return false;

            uf.union(u, v);
        }

        return true;
    }

}
