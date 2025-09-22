// PrimsMST Algorithm for Minimum Spanning Tree
// Time Complexity: O(ElogV)
// Space Complexity: O(V)
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 4},
                {1, 0, 4},
                {0, 2, 13},
                {0, 3, 7},
                {0, 4, 7},
                {1, 3, 3},
                {1, 4, 7},
                {2, 1, 9},
                {1, 2, 9},
                {2, 3, 10},
                {3, 4, 4}
        };
        int[][] mst = prims(graph);
        System.out.println("Minimum Spanning Tree: " + Arrays.deepToString(mst));
    }
    public static int[][] prims(int[][] graph) {
        // Time Complexity: O(ElogV) or O(ElogE). Sorting of edges takes O(ELogE) time. After sorting, we iterate through all edges and apply find-union algorithm.
        if (graph == null || graph.length == 0) {
            return new int[0][0];
        }
        int size = graph.length;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[size];
        List<ArrayList<Integer>> mst = new ArrayList<>();

        int root = 0;
        visited[root] = true;
        for (int i = 0; i < size; i++) {
            if (graph[i][0] == root) {
               priorityQueue.offer(new Edge(root, graph[i][1], graph[i][2]));
            }
        }

        int edges = size - 1;
        int result = 0;
        while (!priorityQueue.isEmpty() && edges > 0) {
            Edge edge = priorityQueue.poll();
            int vertex = edge.vertex;
            int adjacentVertex = edge.adjacent;
            int weight = edge.weight;

            if (visited[adjacentVertex]) {
                continue;
            }

            result += weight;

            visited[adjacentVertex] = true;
            mst.add(new ArrayList<>(Arrays.asList(vertex, adjacentVertex, weight)));
            edges--;

            for (int i = 0; i < size; i++) {
                if (graph[i][0] == adjacentVertex && !visited[graph[i][1]]) {
                    priorityQueue.offer(new Edge(graph[i][0], graph[i][1], graph[i][2]));
                }
            }
        }
        System.out.println("Minimum Cost: " + result);
        int[][] finalMst = new int[mst.size()][3];
        for (int i = 0; i < mst.size(); i++) {
            finalMst[i][0] = mst.get(i).get(0);
            finalMst[i][1] = mst.get(i).get(1);
            finalMst[i][2] = mst.get(i).get(2);
        }
        return finalMst;
    }
    static class Edge {
        int vertex;
        int adjacent;
        int weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex = vertex1;
            this.adjacent = vertex2;
            this.weight = weight;
        }
    }
}
