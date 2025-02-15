package graph;

import java.util.*;

public class Graph {
   private final Map<Integer, List<int[]>> graph;
   private final boolean isWeighted;

   public Graph(int[][] edges, boolean isDirected, boolean isWeighted) {
       this.isWeighted = isWeighted;
       graph = new HashMap<>();
       buildGraph(edges, isDirected);
   }

   public Graph(List<List<Integer>> edges, boolean isDirected, boolean isWeighted) {
       this.isWeighted = isWeighted;
       graph = new HashMap<>();
       buildGraph(edges, isDirected);
   }

   private void buildGraph(int[][] edges, boolean isDirected) {
       for (int[] edge : edges) {
           int u = edge[0], v = edge[1];
           int weight = isWeighted ? edge[2] : 1;
           addEdge(u, v, weight, isDirected);
       }
   }

   private void buildGraph(List<List<Integer>> edges, boolean isDirected) {
       for (List<Integer> edge : edges) {
           int u = edge.getFirst(), v = edge.get(1);
           int weight = isWeighted ? edge.get(2) : 1;
           addEdge(u, v, weight, isDirected);
       }
   }

   private void addEdge(int u, int v, int weight, boolean isDirected) {
       graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, weight});
       if (!isDirected) {
           graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, weight});
       }
   }

    public Map<Integer, List<int[]>> getGraph() {
        return graph;
    }

    public void printGraph() {
        for (var entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (int[] neighbor : entry.getValue()) {
                System.out.print("[" + neighbor[0] + ", W=" + neighbor[1] + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] weightedEdges = {{0, 1, 4}, {0, 2, 2}, {1, 3, 7}, {2, 3, 1}};
        int[][] unweightedEdges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};

        List<List<Integer>> weightedList = Arrays.asList(
                Arrays.asList(0, 1, 4),
                Arrays.asList(0, 2, 2),
                Arrays.asList(1, 3, 7),
                Arrays.asList(2, 3, 1)
        );

        List<List<Integer>> unweightedList = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3)
        );

        System.out.println("Unweighted Graph (int[][]):");
        Graph g1 = new Graph(unweightedEdges, false, false);
        g1.printGraph();

        System.out.println("\nWeighted Graph (int[][]):");
        Graph g2 = new Graph(weightedEdges, false, true);
        g2.printGraph();

        System.out.println("\nUnweighted Graph (List<List<Integer>>):");
        Graph g3 = new Graph(unweightedList, false, false);
        g3.printGraph();

        System.out.println("\nWeighted Graph (List<List<Integer>>):");
        Graph g4 = new Graph(weightedList, false, true);
        g4.printGraph();
    }
}
