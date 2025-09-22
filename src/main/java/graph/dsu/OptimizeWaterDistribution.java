package graph.dsu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptimizeWaterDistribution {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int minCost = kruskal(n, wells, pipes);

        return minCost;
    }

    private int kruskal(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();

        for (int[] e : pipes) {
            edges.add(new int[]{e[0], e[1], e[2]});
        }

        for (int v = 1; v <= n; v++) {
            edges.add(new int[] {0, v, wells[v - 1]});
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        int minCost = 0;
        UnionFind uf = new UnionFind(n + 1);

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (!uf.connected(u, v)) {
                uf.union(u, v);
                minCost += w;
            }
        }

        return minCost;
    }

    static class UnionFind {
        int[] root, rank;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 0;
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }

        int find(int x) {
            if (x == root[x]) return x;

            return root[x] = find(root[x]);
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

}
