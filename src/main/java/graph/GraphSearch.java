package graph;

import java.util.*;

class GraphSearch {
    public static boolean bfs(Graph g, int start, int target) {
        if (start == target) return true;

        Map<Integer, List<Integer>> graph = g.getGraph();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == target) return true;

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }

    public static boolean dfs(Graph g, int start, int target) {
        if (start == target) return true;

        Map<Integer, List<Integer>> graph = g.getGraph();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == target) return true;
            if (!visited.add(node)) continue;

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

   static class Graph {
        private final Map<Integer, List<Integer>> graph;

        public Graph(int[][] edges, boolean isDirected) {
            graph = new HashMap<>();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                if (!isDirected) {
                    graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
                }
            }
        }

        public Map<Integer, List<Integer>> getGraph() {
            return graph;
        }
    }
}