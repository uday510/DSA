package graph;

import java.util.*;

public class Graph<T> {
    private final Map<T, List<Edge<T>>> adjList = new HashMap<>();
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void addEdge(T u, T v) {
        addEdge(u, v, 1);
    }

    public void addEdge(T u, T v, int weight) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge<>(v, weight));
        if (!isDirected) {
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge<>(u, weight));
        }
    }

    // BFS Traversal
    public void bfs(T start) {
        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            T node = queue.poll();
            System.out.print(node + " ");

            for (Edge<T> edge : adjList.getOrDefault(node, Collections.emptyList())) {
                if (visited.add(edge.dest)) {
                    queue.offer(edge.dest);
                }
            }
            System.out.println();
        }
    }

    // DFS Traversal
    public void dfs(T start) {
        dfsHelper(start, new HashSet<>());
        System.out.println();
    }

    private void dfsHelper(T node, Set<T> visited) {
        if (!visited.add(node)) return;

        System.out.println(node + " ");
        for (Edge<T> edge : adjList.getOrDefault(node, Collections.emptyList())) {
            dfsHelper(edge.dest, visited);
        }
    }

    // Dijkstra’s Algorithm (Shortest Path)
    public Map<T, Integer> dijkstra(T src) {
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(Comparator.comparing(e -> e.weight));
        Map<T, Integer> dist = new HashMap<>();
        adjList.keySet().forEach(node -> dist.put(node, Integer.MAX_VALUE));
        dist.put(src, 0);
        pq.offer(new Edge<>(src, 0));

        while (!pq.isEmpty()) {
            Edge<T> current = pq.poll();
            if (current.weight > dist.get(current.dest)) continue;

            for (Edge<T> edge : adjList.getOrDefault(current.dest, Collections.emptyList())) {
                int newDist = dist.get(current.dest) + edge.weight;
                if (newDist < dist.get(edge.dest)) {
                    dist.put(edge.dest, newDist);
                    pq.offer(new Edge<>(edge.dest, newDist));
                }
            }
        }
        return dist;
    }

    // Topological Sorting (Kahn's Algorithm)
    public List<T> topologicalSort() {
        Map<T, Integer> inDegree = new HashMap<>();
        adjList.keySet().forEach(node -> inDegree.put(node, 0));
        adjList.values().forEach(edges -> edges.forEach(edge -> inDegree.put(edge.dest, inDegree.get(edge.dest))));

        Queue<T> queue = new LinkedList<>();
        inDegree.forEach((node, degree) -> { if (degree == 0) queue.offer(node); });

        List<T> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            T node = queue.poll();
            result.add(node);
            for (Edge<T> edge : adjList.getOrDefault(node, Collections.emptyList())) {
                inDegree.put(edge.dest, inDegree.get(edge.dest) - 1);
                if (inDegree.get(edge.dest) == 0) queue.offer(edge.dest);
            }
        }
        return result.size() == adjList.size() ? result : new ArrayList<>();
    }

    // Print Graph
    public void printGraph() {
        adjList.forEach((node, neighbors) -> {
            System.out.print(node + " -> ");
            neighbors.forEach(edge -> System.out.print("[" + edge.dest + ", " + edge.weight + "] "));
            System.out.println();
        });
    }

    // Edge Class (For Weighted Graphs)
    static class Edge<T> {
        T dest;
        int weight;
        Edge(T dest, int weight) { this.dest = dest; this.weight = weight; }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false); // false = undirected, true = directed

        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 4);
        graph.addEdge(5, 6, 6);

        System.out.println("Graph Representation:");
        graph.printGraph();

        System.out.print("BFS Traversal: ");
        graph.bfs(1);

        System.out.print("DFS Traversal: ");
        graph.dfs(1);

        System.out.println("Dijkstra’s Shortest Path from 1:");
        System.out.println(graph.dijkstra(1));

        System.out.println("Topological Sort:");
        System.out.println(graph.topologicalSort());
    }
}
