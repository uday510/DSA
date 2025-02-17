package graph;

import java.util.*;

public class GraphValidTree {
    private static Map<Integer, List<Integer>> graph;
    private static Set<Integer> visited;
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2},{0,3},{1,4}};
        System.out.println(validTree(5, edges));
    }
    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        initialize(edges);
//        if (!dfs(0, -1)) return false;

//        UnionFind uf = new UnionFind(n);
//        for (int[] edge : edges) {
//            if (!uf.union(edge[0], edge[1])) {
//                return false;
//            }
//        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int node = arr[0];
            int parent = arr[1];
            List<Integer> neighbors = graph.getOrDefault(arr[0], new ArrayList<>());
            for (int neighbor : neighbors) {
                if (neighbor == parent) continue;
                if (!visited.add(neighbor)) return false;
                queue.offer(new int[]{neighbor, node});
            }
        }
        return visited.size() == n;
    }

    private static boolean dfs(int node, int parent) {
        if (!visited.add(node)) return false;
        var neighbors = graph.getOrDefault(node, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (parent == neighbor) continue;
            if (!dfs(neighbor, node)) return false;
        }
        return true;
    }

    private static void initialize(int[][] edges) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }

    static class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            for (int idx = 0; idx < n; ++idx) {
                root[idx] = idx;
                rank[idx] = 1;
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

}
