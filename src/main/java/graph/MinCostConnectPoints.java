package graph;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class KruskalUnionFind {
    int[] rank;
    int[] root;

    KruskalUnionFind(int n) {
        this.rank = new int[n];
        this.root = new int[n];

        for (int idx = 0; idx < n; ++idx) {
            rank[idx] = 1;
            root[idx] = idx;
        }
    }

    boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }

        return true;
    }

    int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

}
public class MinCostConnectPoints {

    public static void main(String[] args) {

    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        KruskalUnionFind unionFind = new KruskalUnionFind(n);
        List<int[]> edges = new ArrayList<>();

        for (int idx1 = 0; idx1 < points.length; ++idx1) {
            int[] point1 = points[idx1];
            for (int idx2 = idx1 + 1; idx2 < points.length; ++idx2) {
                int[] point2 = points[idx2];

                int dist = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                int[] edge = {idx1, idx2, dist};
                edges.add(edge);
            }
        }

        edges.sort(Comparator.comparingInt(k -> k[2]));
        int numEdges = n - 1;
        int mstCost = 0;

        for (int idx = 0; idx < edges.size() && numEdges > 0; ++idx) {
            int v1 = edges.get(idx)[0];
            int v2 = edges.get(idx)[1];
            int w = edges.get(idx)[2];

            if (unionFind.union(v1, v2)) {
                mstCost += w;
                numEdges--;
            }
        }

        return mstCost;
    }
}
