import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Solution {

    private static Map<Integer, int[][]> DIRs = new HashMap<>();

    static {

        DIRs.put(1, new int[][] {{0, -1}, {0, 1}});
        DIRs.put(2, new int[][] {{-1, 0}, {1, 0}});
        DIRs.put(3, new int[][] {{0, -1}, {1, 0}});
        DIRs.put(4, new int[][] {{0, 1}, {1, 0}});
        DIRs.put(5, new int[][] {{0, -1}, {-1, 0}});
        DIRs.put(6, new int[][] {{0, 1}, {-1, 0}});

    }

    public boolean hasValidPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1];

            if (dx == n - 1 && dy == m - 1) {
                return true;
            }

            for (int[] dir : DIRs.get(grid[dx][dy])) {
                int nx = dir[0] + dx;
                int ny = dir[1] + dy;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) continue;

                vis[nx][ny] = true;

                queue.offer(new int[] {nx, ny});

            }


        }


        return false;
    }
}
