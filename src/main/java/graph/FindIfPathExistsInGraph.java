/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 */
package graph;

import java.util.*;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n = 6;
        int source = 0;
        int destination = 5;
        System.out.println(validPath(n, edges, source, destination));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);

        while (!stack.isEmpty()) {
            // Get the current node
            int node = stack.pop();

            // Check if the node is the destination
            if (node == destination) {
                return true;
            }

            //Check if the node is seen
            if (seen[node]) {
                continue;
            }

            seen[node] = true; // Mark the node as seen

            // Add all the neighbors of the node to the stack
            for (int neighbor : adjacencyList.get(node)) {
                stack.push(neighbor);
            }
        }
        return false;

        // O(m * log(n)) time complexity | O(n) space complexity
//        UnionFind dsu = new UnionFind(n);
//
//        for (int[] edge : edges) {
//            dsu.union(edge[0], edge[1]);
//        }
//        return dsu.find(source) == dsu.find(destination);
    }
    static class UnionFind {
        private int[] root;
        private int[] rank;

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
            }  else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
}
