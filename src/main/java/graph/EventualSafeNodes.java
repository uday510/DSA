package graph;

import java.util.*;

public class EventualSafeNodes {
    List<Integer>[] adjList;
    int[] states;
    int n;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        initialize(graph);
        List<Integer> list = new ArrayList<>();

        // DFS
        for (int node = 0; node < n; ++node) {
            if (dfs(node)) {
                list.add(node);
            }
        }

        return list;
    }

    private boolean dfs(int node) {
       if (states[node] != 0) return states[node] == 2;

       states[node] = 1;
       for (int neighbor : adjList[node]) {
           if (!dfs(neighbor)) return false;
       }

       states[node] = 2;
       return true;
    }

    private void initialize(int[][] graph) {
        int n = graph.length;
        adjList = new ArrayList[n];
        states = new int[n];

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

       for (int i = 0; i < n; ++i) {
            for (int vertex : graph[i]) {
                adjList[i].add(vertex);
            }
       }

    }
}
