package dp.multiDp;

public class CherryPickup {

    private int[][] grid;
    private int n;
    private Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        dp = new Integer[n][n][n];

        return Math.max(dfs(0, 0, 0), 0);
    }

    // r1 + c1 = r2 + c2
    private int dfs(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n ||
                r2 >= n || c2 >= n ||
                grid[r1][c1] == -1 ||
                grid[r2][c2] == -1
        )  {
            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (r2 == n - 1 && c2 == n - 1) {
            return grid[r2][c2];
        }

        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }

        int pick = grid[r1][c1];

        if (r1 != r2 && c1 != c2) {
            pick += grid[r2][c2];
        }

        int cur =
                Math.max(
                        Math.max(
                                dfs(r1 + 1, c1, r2 + 1), // down, down
                                dfs(r1, c1 + 1, r2) // right, right
                        ),
                        Math.max(
                                dfs(r1 + 1, c1, r2), // down, right
                                dfs(r1, c1 + 1, r2 + 1) // right, down
                        )
                );

        return dp[r1][c1][r2] = pick + cur;

    }
}
