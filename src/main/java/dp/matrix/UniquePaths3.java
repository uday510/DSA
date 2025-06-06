/**
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */
package dp.matrix;

public class UniquePaths3 {
    static int res;
    static int[] positionArray1 = {-1, 0, 1, 0};
    static int[] positionArray2 = {0, -1, 0, 1};
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 2, -1}};

        int res = solve(grid);
        System.out.println(res);
    }
    public static int solve(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int zeroes = 0;
        res = 0;
        int i = -1, j = -1;

        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < m; ++y) {
                if (grid[x][y] == 1) {
                    i = x; j = y;
                } else if (grid[x][y] == 0) ++zeroes;
            }
        }
        helper(i, j, n, m, zeroes+1, grid);
        return res;
    }
    public static void helper(int i, int j,int n, int m, int zeroes, int[][] grid) {
        if (grid[i][j] == 2) {
            if (zeroes == 0) ++res;
            return;
        }

        grid[i][j] = -1;
        for (int x = 0; x < 4; ++x) {
            int newI = i + positionArray1[x];
            int newJ = j + positionArray2[x];

            if (isValidPath(newI, newJ, n, m, grid)) {
                helper(newI, newJ, n, m, zeroes-1, grid);
            }
        }
        grid[i][j] = 0;
    }
    public static boolean isValidPath(int i, int j, int n, int m, int[][] grid) {
        return ( i > -1 && i < n && j > -1 && j < m && grid[i][j] != -1 );
    }
}
