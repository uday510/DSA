package graph.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
//        int minCost = kruskal(points);
        int minCost = prims(points);
        return minCost;
    }

    private int prims(int[][] points) {
//        List<Edge>[] adj = new ArrayList[];
        return -1;
    }

    private int kruskal(int[][] points) {
        int n = points.length;

        UnionFind uf = new UnionFind(n);

        List<Edge> edges = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            int[] c1 = points[u];
            for (int v = u + 1; v < n; v++) {
                int[] c2 = points[v];
                int w = Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);

                edges.add(new Edge(u, v, w));
            }
        }

        edges.sort(Comparator.comparingInt(a -> a.w));
        int minCost = 0, edgesUsed = 0;

        for (int i = 0; i < edges.size() && edgesUsed < n - 1; i++) {
            Edge e = edges.get(i);
            int u = e.u, v = e.v, w = e.w;

            if (!uf.connected(u, v)) {
                uf.union(u, v);
                minCost += w;
                edgesUsed++;
            }
        }

        return minCost;
    }

}

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

}

class UnionFind {
    int[] rank, root;

    UnionFind(int n) {
        rank = new int[n];
        root = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    int find(int x) {
        if (x == root[x]) return x;

        return root[x] = find(root[x]);
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

    boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

