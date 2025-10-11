package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {

    int[][] edges;
    int[] dp;
    int n;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;
        edges = graph;
        dp = new int[n];

        return reversedKahns();

        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     if (dfs(i)) {
        //         list.add(i);
        //     }
        // }

        // return list;
    }

    private boolean dfs(int u) {
        if (dp[u] == 1) return false; // cycle
        if (dp[u] == 2) return true; // safe

        dp[u] = 1; // visited
        for (int v : edges[u]) {
            if (!dfs(v)) {
                return false;
            }
        }

        dp[u] = 2; // safe
        return true;
    }

    private List<Integer> reversedKahns() {
        int[] outdegree = new int[n];
        List<Integer>[] reversedAdjList = new ArrayList[n];

        for (int i = 0; i < n; i++) reversedAdjList[i] = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            for (int v : edges[u]) {
                reversedAdjList[v].add(u);
            }
            outdegree[u] = edges[u].length;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) queue.offer(i);
        }

        boolean[] safe = new boolean[n];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            safe[u] = true;

            for (int v : reversedAdjList[u]) {
                if (--outdegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) list.add(i);
        }

        return list;
    }

}
