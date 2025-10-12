package graph.bfs;

import java.util.*;

public class ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPathsWithVis(int n, int[][] r, int[][] b) {

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        // 0 -> red, 1 -> blue
        for (int[] e : r) {
            int u = e[0], v = e[1];
            adj[u].add(new int[]{v, 0});
        }

        for (int[] e : b) {
            int u = e[0], v = e[1];
            adj[u].add(new int[]{v, 1});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        boolean[][] vis = new boolean[n][2];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, -1});
        vis[0][0] = vis[0][1] = true;
        dis[0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1], c1 = cur[2];

            for (int[] nxt : adj[u]) {
                int v = nxt[0], c2 = nxt[1];
                if (vis[v][c2] || c1 == c2) continue;

                vis[v][c2] = true;
                // two paths from red-edge, blue-edge, FIFO is minimal
                if (dis[v] == -1) dis[v] = w + 1;
                queue.offer(new int[]{v, w + 1, c2});
            }
        }

        return dis;
    }


    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : redEdges) {
            int u = e[0], v = e[1];
            adj[u].add(new int[] {v, 0});
        }

        for (int[] e : blueEdges) {
            int u = e[0], v = e[1];
            adj[u].add(new int[] {v, 1});
        }

        int[][] dis = new int[n][2];
        for (int[] row : dis) Arrays.fill(row, (int) 1e9);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, -1});
        dis[0][0] = dis[0][1] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0], w = cur[1], c1 = cur[2];

            for (int[] nxt : adj[u]) {
                int v = nxt[0], c2 = nxt[1];
                if (w + 1 < dis[v][c2] && c1 != c2) {
                    dis[v][c2] = w + 1;
                    queue.offer(new int[] {v, w + 1, c2});
                }
            }
        }

        int[] res = new int[n];

        for (int i = 0; i < dis.length; i++) {
            int best = Math.min(dis[i][0], dis[i][1]);
            res[i] = (best == (int) 1e9) ? -1 : best;
        }

        return res;
    }
}
