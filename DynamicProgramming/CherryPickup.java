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

package DynamicProgramming;

import Timer.RunTime;

public class CherryPickup {
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

        RunTime runtime = new RunTime();
        int res = solve(grid2);
        System.out.println(res);
        System.out.println("Runtime " + runtime.stopTimer());
    }
    public static int solve(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        int res = cp(0, 0, 0, grid, dp);
        return Math.max(res, 0);
    }
    public static int cp(int r1, int c1, int r2, int[][] grid, int[][][] dp) {
        int c2 = r1 + c1 - r2;
        if (r1 >= grid.length || r2 >= grid.length || c2 >= grid[0].length ||
                c1 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        // if p1 and p2 reach destination
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }

        if (r2 == grid.length - 1 && c2 == grid[0].length - 1) {
            return grid[r2][c2];
        }

        if (dp[r1][c1][r2] != 0) {
            return dp[r1][c1][r2];
        }

        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int f1 = cp(r1, c1 + 1, r2, grid, dp); //h,h
        int f2 = cp(r1 + 1, c1, r2, grid, dp); //v,h
        int f3 = cp(r1 + 1, c1, r2 + 1, grid, dp); //v,v
        int f4 = cp(r1, c1 + 1, r2 + 1, grid, dp); //h,v

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        dp[r1][c1][r2] = cherries;
        return cherries;
    }
}
