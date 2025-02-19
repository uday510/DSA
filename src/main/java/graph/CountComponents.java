package graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class CountComponents {
    private static boolean[] visited;
    private static List<Integer>[] adjList;
    public static int countComponents(int n, int[][] edges) {
//        UnionFind uf = new UnionFind(n);
        int numComponents = 0;

//        for (int[] edge : edges) {
//            numComponents -= uf.union(edge[0], edge[1]);
//        }

        visited = new boolean[n];
        adjList = new ArrayList[n];

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < n; ++idx) {
            adjList[edges[idx][0]].add(edges[idx][1]);
            adjList[edges[idx][1]].add(edges[idx][0]);
        }

        for (int idx = 0; idx < n; ++idx) {
            if (!visited[idx]) {
                numComponents++;
                dfs(idx);
            }
        }

        return numComponents;
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    static class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int n) {
            this.root = new int[n];
            this.rank = new int[n];

            for (int idx = 0; idx < n; ++idx) {
                root[idx] = idx;
                rank[idx] = 1;
            }
        }

        int union(int x, int y) {
            int rootX = find(root[x]);
            int rootY = find(root[y]);

            if (rootX == rootY) {
                return 0;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            return 1;
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }

            return root[x] = find(root[x]);
        }
    }
}
