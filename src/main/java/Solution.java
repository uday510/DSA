import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private static final int[][] DIRs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        int mx = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {

                if (grid[x][y] == 0) {
                    mx = Math.max(mx, bfs(x, y, n, m, grid));
                }
            }
        }

        return mx;
    }

    private int bfs(int x, int y, int n, int m, int[][] grid) {

        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        grid[x][y] = 0;
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            for (int[] nxt : DIRs) {
                int nx = dx + nxt[0], ny = dy + nxt[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 0) {
                    continue;
                }

                grid[nx][ny] = 0;
                cnt++;
                queue.offer(new int[] {nx, ny});
            }
        }

        return cnt;
    }

}