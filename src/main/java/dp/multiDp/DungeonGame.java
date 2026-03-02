package dp.multiDp;

import java.util.Arrays;

public class DungeonGame {

    private int[][] dungeon, dp;
    private int m, n;

    public int calculateMinimumHP(int[][] dungeon) {
        this.dungeon = dungeon;
        this.m = dungeon.length;
        this.n = dungeon[0].length;
        this.dp = new int[m][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {

        if (
                i >= m || j >= n
        ) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            return dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
        }

        int r = dfs(i, j + 1);
        int d = dfs(i + 1, j);

        int cur = Math.min(r, d);

        return dp[i][j] = Math.max(1, cur - dungeon[i][j]);
    }
}
