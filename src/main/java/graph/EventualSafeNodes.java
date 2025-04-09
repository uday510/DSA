package graph;

import java.util.*;

public class EventualSafeNodes {
    List<Integer>[] adjList;
    Set<Integer> vis;
    int n;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        intialize(graph);
        List<Integer> list = new ArrayList<>();

        for (int node = 0; node < n; ++node) {
            if (!vis.contains(node) && dfs(node)) {
                list.add(node);
            }
        }

        Collections.sort(list);
        return list;
    }

    private boolean dfs(int node) {
        vis.add(node);
        for (int neighbour : adjList[node]) {
            if (vis.contains(neighbour)) {
                return false;
            }
            if (!dfs(neighbour)) {
                return false;
            }
        }

        return true;
    }

    private void intialize(int[][] graph) {
        int n = graph.length;
        adjList = new ArrayList[n];
        vis = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

       for (int i = 0; i < n; ++i) {
            for (int j = 0; j < graph[i].length; ++j) {
                adjList[i].add(graph[i][j]);
            }
       }
    }
}
