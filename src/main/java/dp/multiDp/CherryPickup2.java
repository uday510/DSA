package dp.multiDp;

// https://leetcode.com/problems/cherry-pickup-ii/description/?envType=study-plan-v2&envId=dynamic-programming-grandmaster
public class CherryPickup2 {


    private int[][] grid;
    private int n, m;
    private Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.dp = new Integer[n][m][m];

        return dfs(0, 0, m - 1);
    }

    private int dfs(int x, int y1, int y2) {
        if (
                y1 >= m || y2 >= m ||
                y1 < 0 || y2 < 0
        ) {
            return Integer.MIN_VALUE;
        }

        if (x == n - 1) {
            if (y1 == y2) return grid[x][y1] + grid[x][y2];
            return grid[x][y1];
        }

        if (dp[x][y1][y2] != null) {
            return dp[x][y1][y2];
        }

        int picked = grid[x][y1];
        if (y1 != y2) {
            picked += grid[x][y2];
        }

        int cur = 0;

        for (int y3 = y1 - 1; y3 <= y1 + 1; y3++) {
            for (int y4 = y2 - 1; y4 <= y2 + 1; y4++) {
                cur = Math.max(cur, cur + dfs(x + 1, y3, y4));
            }
        }

        return dp[x][y1][y2] = picked + cur;

    }

}
