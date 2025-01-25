package graph;

public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        System.out.println(validTree(5, edges));
    }
    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        UnionFind dsu = new UnionFind(n);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
    static class UnionFind {
        static private int[] parent;
        static private int[] size; // We use this to keep track of the size of each set.

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int node = 0; node < n; ++node) {
                parent[node] = node;
                size[node] = 1;
            }
        }
        public static int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public static boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else if (size[rootY] > size[rootX]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            return true;
        }
    }
}
