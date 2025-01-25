package graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(n, edges));
    }
    public static int countComponents(int n, int[][] edges) {
        UnionFind dsu = new UnionFind(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(dsu.find(i));
        }
        return set.size();
    }

    static class UnionFind {
        static int[] parent;
        static int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public static int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }
        public static void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) return;

            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
                rank[parentX] += rank[parentY];
            } else if (rank[parentY] > rank[parentX]){
                parent[parentX] = parentY;
            } else {
                parent[parentY] = parentX;
                rank[parentX] += 1;
            }
        }
    }
}
