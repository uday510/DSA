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

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n = 6;
        int source = 0;
        int destination = 5;
        System.out.println(validPath(n, edges, source, destination));
    }

    static List<int[]>[] adjList;
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
//        UnionFind uf = new UnionFind(n);
//
//        for (int[] edge : edges) {
//            uf.union(edge[0], edge[1]);
//        }
//
//        return uf.find(source) == uf.find(destination)
        adjList = new ArrayList[n];
        for (int[] edge : edges) {
            adjList[edge[0]].add(new int[]{edge[1]});
            adjList[edge[1]].add(new int[]{edge[0]});
        }

        return dfs(source, destination);
    }
    private static boolean dfs(int node, int destination) {
        if (node == destination) {
            return true;
        }

        for (int[] neighbor : adjList[node]) {

            if (dfs(neighbor[0], destination)) {
                return true;
            }
        }

        return false;
    }

   static class UnionFind {
       int[] root;
       int[] rank;

       public UnionFind(int n) {
           this.root = new int[n];
           this.rank = new int[n];

           for (int idx = 0; idx < n; ++idx) {
               root[idx] = idx;
               rank[idx] = 1;
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

           if (rootX == rootY)
               return;

           if (rank[rootX] > rank[rootY]) {
               root[rootY] = rootX;
           } else if (rank[rootY] > rank[rootX]) {
               root[rootX] = rootY;
           } else {
               root[rootY] = rootX;
               rank[rootX] += 1;
           }
       }
   }
}
