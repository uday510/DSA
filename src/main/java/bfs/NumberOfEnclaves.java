package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfEnclaves {

    private static final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;
    int[][] grid;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt += bfs(i, j);
                }
            }
        }

        return cnt;
    }

    private int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        queue.offer(new int[] {x, y});
        grid[x][y] = 0;
        boolean boundaryPath = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            if (isBoundary(dx, dy)) boundaryPath = true;
            else cnt++;

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;

                grid[nx][ny] = 0;
                queue.offer(new int[] {nx, ny});
            }
        }

        return boundaryPath ? 0 : cnt;
    }

    private boolean isBoundary(int x, int y) {
        return (x == 0 || y == 0 || x == m - 1 || y == n - 1);
    }

}
