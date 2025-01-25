/**
  Kruskal's Algorithm

 You're given a list of edges representing a weighted, undirected graph with at least one node.

 The given list is what's called an adjacency list, and it represents a graph. The number of vertices in the graph is equal to the length of edges, where each index i in edges contains vertex i's siblings, in no particular order. Each of these siblings is an array of length two, with the first value denoting the index in the list that this vertex is connected to, and and the second value denoting the weight of the edge. Note that this graph is undirected, meaning that if a vertex appears in the edge list of another vertex, then the inverse will also be true (along with the same weight).

 Write a function implementing Kruskal's Algorithm to return a new edges array that represents a minimum spanning tree. A minimum spanning tree is a tree containing all of the vertices of the original graph and a subset of the edges. These edges should connect all of the vertices with the minimum total edge weight and without generating any cycles.

 If the graph is not connected, your function should return the minimum spanning forest (i.e. all of the nodes should be able to reach the same nodes as they could in the initial edge list).

 Note that the graph represented by edges won't contain any self-loops (vertices that have an outbound edge to themselves) and will only have positively weighted edges (i.e., no negative distances).

 If you're unfamiliar with Kruskal's algorithm, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code. If you're unfamiliar with the Union Find data structure, we recommend completing that problem before attempting this one.
 Sample Input

 edges = [
 [[1, 3], [2, 5]],
 [[0, 3], [2, 10], [3, 12]],
 [[0, 5], [1, 10]],
 [[1, 12]]
 ]

 Sample Output

 [
 [[1, 3], [2, 5]],
 [[0, 3], [3, 12]],
 [[0, 5]],
 [[1, 12]]
 ]


 */
package famousalgorithms;

import java.util.ArrayList;
import java.util.List;

public class KruskalsAlgorithm {
    public static void main(String[] args) {
        int[][][] edges = {
                {{1, 3}, {2, 5}},
                {{0, 3}, {2, 10}, {3, 12}},
                {{0, 5}, {1, 10}},
                {{1, 12}}
        };
        int[][][] result = kruskalsAlgorithm(edges);
        for (int[][] arr : result) {
            for (int[] a : arr) {
                System.out.print("[" + a[0] + "," + a[1] + "]");
            }
            System.out.println();
        }
    }
    public static int[][][] kruskalsAlgorithm(int[][][] edges) {
        ArrayList<List<Integer>> sortedEdges = new ArrayList<>();
        int vertices = edges.length;
        for (int vertex = 0; vertex < vertices; ++vertex) {
            for (int[] edge : edges[vertex]) {
                if (edge[0] > vertex) {
                    List<Integer> newEdge = new ArrayList<>();
                    newEdge.add(vertex);
                    newEdge.add(edge[0]);
                    newEdge.add(edge[1]);
                    sortedEdges.add(newEdge);
                }
            }
        }

        sortedEdges.sort((edge1, edge2) -> edge1.get(2) - edge2.get(2));
        UnionFind uf = new UnionFind(vertices);
        ArrayList<ArrayList<int[]>> mst = new ArrayList<>();
        for (int vertex = 0; vertex < vertices; ++vertex) {
            mst.add(new ArrayList<>());
        }
        for (List<Integer> edge : sortedEdges) {
            int vertex1 = edge.get(0);
            int vertex2 = edge.get(1);
            if (uf.find(vertex1) != uf.find(vertex2)) {
                uf.union(vertex1, vertex2);
                mst.get(vertex1).add(new int[] {vertex2, edge.get(2)});
                mst.get(vertex2).add(new int[] {vertex1, edge.get(2)});
            }
        }
        int[][][] result = new int[vertices][][];
        for (int i = 0; i < mst.size(); ++i) {
            result[i] = new int[mst.get(i).size()][];
            for (int j = 0; j < mst.get(i).size(); ++j) {
                result[i][j] = mst.get(i).get(j);
            }
        }
        return result;

    }
    static class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0;i < n;i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[py] > rank[px]) {
                parent[px] = py;
            } else {
                parent[px] = py;
                rank[py]++;
            }
        }
    }

}
