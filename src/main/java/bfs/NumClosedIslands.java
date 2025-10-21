package bfs;

// https://leetcode.com/problems/number-of-closed-islands/?envType=study-plan-v2&envId=graph-theory

import java.util.ArrayDeque;
import java.util.Queue;

public class NumClosedIslands {

    static private final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private int m, n;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int cnt = 0;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    cnt += bfs(i, j);
                }
            }
        }

        return cnt;
    }

    private int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        grid[x][y] = -1;
        boolean closed = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    closed = false;
                    continue;
                }

                if (grid[nx][ny] == 0) {
                    grid[nx][ny] = -1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        return closed ? 1 : 0;
    }

}
