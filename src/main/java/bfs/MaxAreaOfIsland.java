package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {

    private static final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int[][] grid;
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int area = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, bfs(i, j));
                }
            }
        }

        return area;
    }

    private int bfs(int x, int y) {
        int cnt = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        grid[x][y] = -1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0 || grid[nx][ny] == -1) continue;

                grid[nx][ny] = -1;
                queue.offer(new int[] {nx, ny});
                cnt++;
            }
        }
        return cnt;
    }

}
