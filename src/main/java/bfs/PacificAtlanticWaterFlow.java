package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    private static final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;
    int[][] grid;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.grid = heights;
        this.m = grid.length;
        this.n = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();

        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[] {i, 0});
            atlanticQueue.offer(new int[] {i, n - 1});
            pacific[i][0] = atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[] {0, j});
            atlanticQueue.offer(new int[] {m - 1, j});
            pacific[0][j] = atlantic[m - 1][j] = true;
        }

        bfs(pacificQueue, pacific);
        bfs(atlanticQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> queue, boolean[][] vis) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            for (int[] dir : DIRs) {
                int nx = dx + dir[0], ny = dy +dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                if (vis[nx][ny] || grid[dx][dy] > grid[nx][ny]) continue;

                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }

}
