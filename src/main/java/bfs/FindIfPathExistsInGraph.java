package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int src, int dest) {
        List<Integer>[] adjList = new ArrayList[n];
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        queue.offer(src);
        vis[src] = true;

        while (!queue.isEmpty() && !vis[dest]) {
            int u = queue.poll();

            for (int v : adjList[u]) {
                if (vis[v]) continue;

                queue.offer(v);
                vis[v] = true;
            }
        }

        return vis[dest];
    }
}
