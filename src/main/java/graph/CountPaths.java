package graph;

import java.util.*;

public class CountPaths {
    ArrayList<int[]>[] adjList;
    int[] indegree;
    Map<Integer, Integer> result;
    Deque<int[]> queue;
    public int countPaths(int n, int[][] roads) {
        initialize(n, roads);

        int min = 100000;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[0];
            int w = node[1];

            if (u == n - 1) {
                result.merge(u, 1, Integer::sum);
                min = Math.min(min, w);
                continue;
            }

            for (int[] nei : adjList[u]) {
                int v = nei[0];
                --indegree[v];
                if (indegree[v] == 0) {
                    queue.offer(new int[]{v, w + nei[1]});
                }
            }
        }

        return result.get(min);
    }

    private void initialize(int n, int[][] roads) {
        adjList = new ArrayList[n];
        result = new HashMap<>();
        queue = new ArrayDeque<>();

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList[u].add(new int[]{v, w});
            ++indegree[v];
        }
    }
}
