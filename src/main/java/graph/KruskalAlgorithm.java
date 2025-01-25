// Note: Kruskal's Algorithm may not give the minimum spanning tree in some cases
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalAlgorithm {
    // Kruskal's Algorithm may not give the minimum spanning tree in some cases
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 4},
                {0, 2, 13},
                {0, 3, 7},
                {0, 4, 7},
                {1, 3, 3},
                {1, 4, 7},
                {2, 1, 9},
                {2, 3, 10},
                {3, 4, 4}
        };

        int[][] mst = kruskal(graph);
        System.out.println("Minimum Spanning Tree: " + Arrays.deepToString(mst));
    }
    public static int[][] kruskal(int[][] graph) {
        // Time Complexity: O(ElogE) or O(ElogV). Sorting of edges takes O(ELogE) time. After sorting, we iterate through all edges and apply find-union algorithm.

        /**
         * 1.Ascending sort the edges based on their weights
         * 2. Pick the edge with the minimum weight and check if it forms a cycle with the spanning tree formed so far.
         *   If cycle is not formed, include this edge. Else, discard it.
         * 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
         * 4. Return the spanning tree.
         */
        if (graph == null || graph.length == 0) { // check if graph is null or empty
            return new int[0][0]; // return empty array
        }
        int size = graph.length; // get the size of the graph
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.weight - b.weight); // create a priority queue to store the edges
        UnionFind dsu = new UnionFind(size); // create a union find object

        // add all the edges to the priority queue
        for (int[] ints : graph) {
            priorityQueue.offer(new Edge(ints[0], ints[1], ints[2]));
        }

        List<ArrayList<Integer>> mst = new ArrayList<>(); // create a list to store the minimum spanning tree

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll(); // get the edge with the minimum weight
            int vertex1 = edge.vertex1; // get the first vertex
            int vertex2 = edge.vertex2; // get the second vertex

            if (!dsu.connected(vertex1, vertex2)) { // check if the two vertices are connected
                dsu.union(vertex1, vertex2); // connect the two vertices
                ArrayList<Integer> list = new ArrayList<>(); // create a list to store the vertices and the weight of the edge
                list.add(vertex1); // add the first vertex to the list
                list.add(vertex2); // add the second vertex to the list
                list.add(edge.weight); // add the weight of the edge to the list
                mst.add(list); // add the list to the minimum spanning tree
            }
        }
        int index = 0;

        int[][] finalMst = new int[mst.size()][3]; // create a 2D array to store the minimum spanning tree
        for (ArrayList<Integer> list : mst) { // loop through the list
            finalMst[index][0] = list.get(0); // add the first vertex to the 2D array
            finalMst[index][1] = list.get(1); // add the second vertex to the 2D array
            finalMst[index][2] = list.get(2); // add the weight of the edge to the 2D array
            index++; // increment the index
        }
        return finalMst; // return the minimum spanning tree
    }
    static class Edge {
        int vertex1;
        int vertex2;
        int weight;

        Edge(int v1, int v2, int w) {
            vertex1 = v1;
            vertex2 = v2;
            weight = w;
        }
    }
    static class UnionFind{
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; ++i) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x) {
            if (root[x] == x) {
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
            } else if (rank[rootX] < rank[rootY]) {
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
