package graph;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);
        int numberOfProvinces = n;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isConnected[i][j] == 1 && UnionFind.find(i) != UnionFind.find(j)) {
                    dsu.unionSet(i, j);
                    numberOfProvinces--;
                }
            }
        }
        return numberOfProvinces;
    }
    static class UnionFind {
        static int[] parent;
        static int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public static int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void unionSet(int x, int y) {
            int xset = find(x);
            int yset = find(y);
            if (xset == yset) {
                return;
            }

            if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else if (rank[yset] > rank[xset]) {
                parent[xset] = yset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
        }
    }
}
