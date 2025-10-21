package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-to-get-all-keys/description/?envType=study-plan-v2&envId=graph-theory
public class ShortestPathToGetAllKeys {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        boolean[][][] vis = new boolean[m][n][64];
        Queue<int[]> queue = new ArrayDeque<>();

        int keysMask = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    queue.offer(new int[] {i, j, 0, 0});
                    vis[i][j][0] = true;
                }
                if (isKey(ch)) {
                    keysMask |= (1 << (ch - 'a'));
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dx = cur[0], dy = cur[1], curKeysMask = cur[2], w = cur[3];

            // found all keys
            if (keysMask == curKeysMask) return w;

            for (int[] dir : DIRs) {
                int nx = dir[0] + dx, ny = dir[1] + dy;

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                char ch = grid[nx].charAt(ny);

                if (isWall(ch)) continue;

                // key not found
                if (isLock(ch) && (curKeysMask & (1 << (ch - 'A'))) == 0) continue;

                int newKeysMask = curKeysMask;
                if (isKey(ch)) newKeysMask |= (1 << (ch - 'a'));

                if (vis[nx][ny][newKeysMask]) continue;

                vis[nx][ny][newKeysMask] = true;
                queue.offer(new int[] {nx, ny, newKeysMask, w + 1});
            }
        }

        return -1;
    }

    private boolean isKey(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isLock(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private boolean isWall(char ch) {
        return ch == '#';
    }

}
