package graph;

import java.util.*;

public class GraphDFS {
    private final Map<Integer, List<int[]>> graph;

    public GraphDFS(Graph g) {
        this.graph = g.getGraph();
    }

    // ✅ **Iterative DFS using Stack**
    public List<Integer> dfs(int startNode, int targetNode) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> parent = new HashMap<>();
        List<Integer> result = new ArrayList<>();  // Stores nodes in DFS order

        stack.push(startNode);
        parent.put(startNode, -1);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited.contains(node)) continue;

            visited.add(node);
            result.add(node);

            // If searching for a specific node (e.g., path-finding)
            if (node == targetNode) break;

            List<int[]> neighbors = graph.getOrDefault(node, new ArrayList<>());
            neighbors.sort((a, b) -> Integer.compare(b[0], a[0])); // Maintain left-to-right order

            for (int[] neighbor : neighbors) {
                if (!visited.contains(neighbor[0])) {
                    stack.push(neighbor[0]);
                    parent.put(neighbor[0], node);
                }
            }
        }
        return result;
    }

    public Map<Integer, Integer> dijkstra(int startNode) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{startNode, 0});
        distances.put(startNode, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], dist = current[1];

            if (dist > distances.getOrDefault(node, Integer.MAX_VALUE)) continue;

            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0], weight = neighbor[1];
                int newDist = dist + weight;

                if (newDist < distances.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                    distances.put(nextNode, newDist);
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }
        return distances;
    }


    public static void main(String[] args) {
        int[][] edges = {{0, 1, 4}, {0, 2, 2}, {1, 3, 7}, {2, 3, 1}, {3, 4, 3}};
        Graph g = new Graph(edges, false, true);

        GraphDFS dfs = new GraphDFS(g);
        dfs.dfs(0, 4).forEach(node -> System.out.print(node + " "));
        System.out.println();

        System.out.println("Shortest paths from node 0: " + dfs.dijkstra(0));
    }
}
