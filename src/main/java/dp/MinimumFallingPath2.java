package dp;

/**
 * Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
 *
 * A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no
 * two elements chosen in adjacent rows are in the same column.
 */
public class MinimumFallingPath2 {
    static int[][] dp;
    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4,5,6},{7,8,9}};

        int res = minFallingPathSum(grid);
        System.out.println(res);
    }
    public static int minFallingPathSum(int[][] grid) {

        dp = new int[grid.length][grid[0].length];

        int minFallingSum = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; ++i) {
            minFallingSum = Math.min(minFallingSum, dfs(grid, 0, i));
        }

        return minFallingSum;
    }
    public static int dfs(int[][] grid, int row, int col) {
        if (col < 0 || col == grid.length) {
            return Integer.MAX_VALUE;
        }

        if (row == grid.length - 1) {
            return grid[row][col];
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        dp[row][col] = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; ++i) {
            if (i == col) {
                continue;
            }
            dp[row][col] = Math.min(dp[row][col], dfs(grid, row + 1, i) + grid[row][col]);
        }

        return dp[row][col];
    }
}
