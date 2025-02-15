package graph;

import java.util.*;

public class GraphBFS {
    private final Map<Integer, List<int[]>> graph;

    public GraphBFS(Graph g) {
        this.graph = g.getGraph();
    }

    private void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int[] neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                int nextNode = neighbor[0];
                if (!visited.contains(nextNode)) {
                    queue.offer(nextNode);
                    visited.add(nextNode);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        Graph g = new Graph(edges, false, false);

        GraphBFS bfs = new GraphBFS(g);
        System.out.println("BFS Traversal from node 0:");
        bfs.bfs(0);
    }
}
