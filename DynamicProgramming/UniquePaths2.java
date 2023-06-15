/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};

        int ans = solve(grid);
        System.out.println(ans);
    }
    public static int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];

        int res = helper(0, 0, m, n, grid, dp);
        System.out.println(Arrays.deepToString(grid));
        return res;
    }
    public static int helper(int i, int j, int m, int n, int[][] grid, int[][] dp) {

        if (i == m-1 && j == n-1) return 1;

        if (i >= m || j >= n || grid[i][j] == 1) return 0;

        if (dp[i][j] != 0) return dp[i][j];
        return dp[i][j] = helper(i+1, j, m, n, grid, dp) + helper(i, j+1, m, n, grid, dp);

    }
}
