package graph;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class CheckValidPath {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        int n = 3;
        int start = 0;
        int end = 2;
        System.out.println(validPath(n, edges, start, end));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.isConnected(source, destination);
    }
    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return;

            if(rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public boolean isConnected(int source, int destination) {
            return find(source) == find(destination);
        }
    }

}
