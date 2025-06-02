package dp;

import java.util.Arrays;

/*
You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of
 cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.

 */
public class CherryPick2 {
    static int[][][] dp = new int[100][100][100];
    static int[][] grid;
    static int n;
    static int m;
    public static void main(String[] args) {
        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        CherryPick2.grid = grid;
        
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        
       int res = dfs(0, 0, m - 1);
        System.out.println(res);
    }
    // r = no of rows
    // c1 = col of robot 1
    // c2 = col of robot 2
    public static int dfs(int r, int c1, int c2) {
       if (r == n) {
           return 0;
       }

        if (dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        int picked = 0;

//        for (int i = -1; i < 2; ++i) {
//            for (int j = -1; j < 2; ++j) {
//                int nc1 = c1 + i;
//                int nc2 = c2 + j;
//
//                if (nc1 < 0 || nc1 >= m || nc2 < 0 || nc2 >= m) {
//                    continue;
//                }
//                picked = Math.max(picked, dfs(r + 1, nc1, nc2));
//            }
//        }

        // all possible moves for robot 1
        int p1 = dfs(r + 1, c1, c2);
        int p2 = c1 == c2 ? 0 : dfs(r + 1, c1, c2);
        int p3 = c1 == c2 ? 0 : dfs(r + 1, c1, c2 + 1);
        int p4 = c1 == c2 ? 0 : dfs(r + 1, c1, c2 - 1);

        // all possible moves for robot 2

        int p5 = dfs(r + 1, c1, c2);
        int p6 = c1 == c2 ? 0 : dfs(r + 1, c1, c2);
        int p7 = c1 == c2 ? 0 : dfs(r + 1, c1, c2 + 1);
        int p8 = c1 == c2 ? 0 : dfs(r + 1, c1, c2 - 1);

        picked = Math.max(p1, Math.max(p2, Math.max(p3, Math.max(p4, Math.max(p5, Math.max(p6, Math.max(p7, p8)))))));

        picked += grid[r][c1];
        if (c1 != c2) {
            picked += grid[r][c2];
        }

        return dp[r][c1][c2] = picked;
    }
}
