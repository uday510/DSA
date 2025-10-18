package graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {

    int[][] grid;
    boolean[][] vis;
    int n;
    Queue<int[]> queue;
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        vis = new boolean[n][n];
        queue = new ArrayDeque<>();
        this.grid = grid;

        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1], w = cur[2];

            for (int[] dir : dirs) {
                int nx = dir[0] + dx, ny = dir[1] + dy;
                if (!isValid(nx, ny)) continue;

                if (grid[nx][ny] == 1) return w;
                queue.offer(new int[]{nx, ny, w + 1});
                vis[nx][ny] = true;
            }
        }

        return -1;
    }

    private void dfs(int i, int j) {
        if (!isValid(i, j) || grid[i][j] == 0) return;

        queue.offer(new int[] {i, j, 0});
        vis[i][j] = true;

        for (int[] dir : dirs) {
            int nx = dir[0] + i, ny = dir[1] + j;
            dfs(nx, ny);
        }
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n && !vis[i][j];
    }
}
