package dp.multiDp;

public class CherryPickup {

    private int[][] grid;
    private int n;
    private Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.dp = new Integer[n][n][n];

        return Math.max(dfs(0, 0, 0), 0);
    }

    // x1 + y1 = x2 + y2
    private int dfs(int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;

        if (
                x1 >= n || y1 >= n ||
                        x2 >= n || y2 >= n ||
                        grid[x1][y1] == -1 ||
                        grid[x2][y2] == -1
        ) {
            return Integer.MIN_VALUE;
        }

        if (x1 == n - 1 && y1 == n - 1) {
            return grid[x1][y1];
        }

        if (x2 == n - 1 && y2 == n - 1) {
            return grid[x2][y2];
        }

        if (dp[x1][y1][x2] != null) {
            return dp[x1][y1][x2];
        }

        int cur = grid[x1][y1];

        if (x1 != x2 && y1 != y2) {
            cur += grid[x2][y2];
        }

        cur +=
                Math.max(
                        Math.max(
                                dfs(x1 + 1, y1, x2 + 1),
                                dfs(x1, y1 + 1, x2)
                        ),
                        Math.max(
                                dfs(x1 + 1, y1, x2),
                                dfs(x1, y1 + 1, x2 + 1)
                        )
                );

        return dp[x1][y1][x2] = cur;
    }
}
