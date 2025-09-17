package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Algorithm {

    static void main() {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3}
        };

        bfs(edges, 4, 0);
    }

    private static void bfs(int[][] edges, int n, int src) {

        List<Integer>[] adjList = new ArrayList[n + 1];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v); // directed
//            adjList[v].add(u); // undirected
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        queue.offer(src);
        vis[src] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println("vis " + u);

            for (int v : adjList[u]) {
                if (vis[v]) continue;

                queue.offer(v);
                vis[v] = true;
            }
        }
    }
}
