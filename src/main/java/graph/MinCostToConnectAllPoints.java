package graph;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }
        UnionFind dsu = new UnionFind(n);
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        for (int i = 0; i < n; ++i) {
            int[] coordinate1 = points[i];
            for (int j = i + 1; j < n; ++j) {
                int[] coordinate2 = points[j];
                // Calculate the distance between two coordinates.
                int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
                Edge edge = new Edge(i, j, cost);
                pq.add(edge);
            }
        }

        int minCost = 0;
        int edges = n - 1; // The number of edges in MST is n - 1.

        while (!pq.isEmpty() && edges > 0) {
            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;
            int cost = edge.cost;

            if (!dsu.connected(point1, point2)) {
                dsu.union(point1, point2);
                minCost += cost;
                edges--;
            }
        }
        return minCost;

    }
    static class Edge {
        int point1;
        int point2;
        int cost;

        public Edge(int p1, int p2, int c) {
            point1 = p1;
            point2 = p2;
            cost = c;
        }
    }
    static class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
