package graph;

import java.util.*;

class Graph {
    private final Map<Integer, Set<Integer>> adjacencyList;

    // Constructor
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new HashSet<>());
        adjacencyList.putIfAbsent(destination, new HashSet<>());
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Remove a vertex from the graph
    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) return;
        for (Integer neighbor : adjacencyList.get(vertex)) {
            adjacencyList.get(neighbor).remove(vertex);
        }
        adjacencyList.remove(vertex);
    }

    // Remove an edge from the graph
    public void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source);
        }
    }

    // Print the graph
    public void printGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Check if the graph contains a vertex
    public boolean containsVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Check if the graph contains an edge
    public boolean containsEdge(int source, int destination) {
        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.printGraph();

        // Test containsVertex and containsEdge
        System.out.println("Contains vertex 1: " + graph.containsVertex(1));
        System.out.println("Contains edge 1-2: " + graph.containsEdge(1, 2));
        System.out.println("Contains edge 2-3: " + graph.containsEdge(2, 3));

        // Remove a vertex and an edge
        graph.removeEdge(1, 3);
        graph.removeVertex(4);

        graph.printGraph();
    }
}