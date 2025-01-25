/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
package dynamicprogramming;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};

        int ans = solve(grid);
        System.out.println(ans);
    }
    public static int solve(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;


        int[][] memo = new int[m][n];

        memo[0][0] = 1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j< n; ++j) {

                if (grid[i][j] == 1) {
                    memo[i][j] = 0; // obstacle
                } else {
                    // two ways to reach this cell
                    // 1. from top, 2. from left
                    if (i > 0) memo[i][j] += memo[i-1][j]; // from top
                    if (j > 0) memo[i][j] += memo[i][j-1]; // from left
                }
            }
        }
//        return memo[m-1][n-1];

        // optimize to 1D array
        /*
        At any point, we need only the previous row to calculate the current row.
        So, we can optimize the space by using a 1D array instead of a 2D array.
         */

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j< n; ++j) {

                if (grid[i][j] == 1) {
                    dp[j] = 0; // obstacle
                } else {
                    // two ways to reach this cell
                    // 1. from top, 2. from left
                    if (j > 0) dp[j] += dp[j-1]; // from left

                }
            }
        }

        return dp[n-1];
    }
    public static int helper(int i, int j, int m, int n,
                             int[][] grid, int[][] dp) {

        // if we reach an obstacle or go out of bounds, return 0
        if (i >= m || j >= n || grid[i][j] == 1) return 0;

        // if we reach the bottom right corner, return 1
        if (i == m-1 && j == n-1) return 1;

        // if we have already calculated the number of
        // paths from this cell, return it
        if (dp[i][j] != 0) return dp[i][j];

        //  else, calculate the number of paths from the cell
        //  below and to the right of the current cell
        return dp[i][j] = helper(i+1, j, m, n, grid, dp)
                        + helper(i, j+1, m, n, grid, dp);
    }
}
