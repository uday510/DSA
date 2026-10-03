package bfs;

import java.util.ArrayDeque;

class Solution {

    private static final int[][] DIRs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
    private static final char STARTING_POINT = '@';

    public int shortestPathAllKeys(String[] grid) {

        int n = grid.length, m = grid[0].length();
        var vis = new boolean[n][m][64];
        var queue = new ArrayDeque<int[]>();
        int reqMask = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                char c = grid[x].charAt(y);
                if (c == STARTING_POINT) {
                    vis[x][y][0] = true;
                    queue.offer(new int[] {x, y, 0, 0});
                }
                if (isKey(c))
                    reqMask |= (1 << (c - 'a'));
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], curMask = cur[2], w = cur[3];
            if (curMask == reqMask)
                return w;
            for (int[] dir : DIRs) {
                int nx = dir[0] + x, ny = dir[1] + y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                char c = grid[nx].charAt(ny);
                if (isWall(c) || (isLock(c) && ((curMask & (1 << (c - 'A'))) == 0)))
                    continue;
                int mask = isKey(c) ? (curMask | (1 << (c - 'a'))) : curMask;
                if (vis[nx][ny][mask]) continue;
                vis[nx][ny][mask] = true;
                queue.offer(new int[] {nx, ny, mask, w + 1});
            }
        }

        return -1;
    }

    private boolean isWall(char c) {
        return c == '#';
    }
    private boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }
    private boolean isLock(char c) {
        return c >= 'A' && c <= 'Z';
    }
}