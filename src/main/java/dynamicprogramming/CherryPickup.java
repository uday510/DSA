/**
 * You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.
 *
 * 0 means the cell is empty, so you can pass through,
 * 1 means the cell contains a cherry that you can pick up and pass through, or
 * -1 means the cell contains a thorn that blocks your way.
 * Return the maximum number of cherries you can collect by following the rules below:
 *
 * Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
 * After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
 * When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
 * If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 *
 * Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
 * Output: 5
 * Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
 * 4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
 * Then, the player went left, up, up, left to return home, picking up one more cherry.
 * The total number of cherries picked up is 5, and this is the maximum possible.
 */

package dynamicprogramming;

import Timer.RunTime;

public class CherryPickup {
    static int n;
    static int[][][][] dp;
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,-1,-1,-1,1,0,0},
                        {1,0,0,0,1,0,0,0,1,0},
                        {0,0,1,1,1,1,0,1,1,1},
                        {1,1,0,1,1,1,0,-1,1,1},
                        {0,0,0,0,1,-1,0,0,1,-1},
                        {0,0,0,0,1,-1,0,0,1,-1,1},
                        {1,0,-1,0,-1,0,0,1,0,0},
                        {0,0,-1,0,1,0,1,0,0,1}};

        int[][] grid2 = {{1,1,-1},{1,-1,1},{-1,1,1}};
        n = grid.length;
        dp = new int[n][n][n][n];

        RunTime runtime = new RunTime();
    }
    public static int dfs(int r1, int c1, int r2, int c2, int[][] grid) {
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];
        if (r2 == n - 1 && c2 == n - 1) return grid[r2][c2];

        if (dp[r1][c1][r2][c2] != 0)
            return dp[r1][c1][r2][c2];

        int picked = 0;
        if (r1 == r2 && c1 == c2)
            picked += grid[r1][c1];
        else
            picked += grid[r1][c1] + grid[r2][c2];

        int m1 = dfs(r1, c1 + 1, r2, c2 + 1, grid);
        int m2 = dfs(r1 + 1, c1, r2, c2 + 1, grid);
        int m3 = dfs(r1 + 1, c1, r2 + 1, c2, grid);
        int m4 = dfs(r1, c1 + 1, r2 + 1, c2, grid);

        picked += Math.max(Math.max(m1, m2), Math.max(m3, m4));

        dp[r1][c1][r2][c2] = picked;
        return picked;
    }
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == -1) {
                dp[i][0] = -1;
            } else {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
        }
        for (int i = 1; i < n; i++) {
            if (grid[0][i] == -1) {
                dp[0][i] = -1;
            } else {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1][n - 1];
    }

}
