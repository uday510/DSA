package graph.bfs;

import java.util.*;

public class TreeDiameter {

    List<Integer>[] adjList;
    int n;

    public int treeDiameter(int[][] edges) {
        n = edges.length + 1;
        adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int[] longestNodeFrom0 = bfs(0);
        int[] res = bfs(longestNodeFrom0[0]);

        return res[1];
    }

    private int[] bfs(int src) {
        int[] dists = new int[n];
        Arrays.fill(dists, (int) 1e9);

        dists[src] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0});

        int node = 0, longest = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0], w = curr[1];

            if (dists[u] < w) {
                continue;
            }

            for (int v: adjList[u]) {
                if (w + 1 < dists[v]) {
                    dists[v] = w + 1;
                    queue.offer(new int[]{v, w + 1});
                    if (w + 1 > longest) {
                        longest = w + 1;
                        node = v;
                    }
                }
            }
        }

        return new int[]{node, longest};
    }

}
