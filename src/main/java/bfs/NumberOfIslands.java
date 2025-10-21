package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    private static final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int islands = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1') {
                    bfs(x, y);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '0') continue;

                grid[nx][ny] = '0';
                queue.offer(new int[] {nx, ny});
            }
        }
    }

}
