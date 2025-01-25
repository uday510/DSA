/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
package graph;

public class NumberOfIslands {
    private static final int[][] directions = new int[][] { {0,1}, {1,0}, {0,-1}, {-1,0} };
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '0', '0', '0', '0', '0', },
                {'1','1', '1'},
                {'1','1', '1'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int numIslands = 0;
        boolean[][] vis = new boolean[N][M];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    numIslands++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return numIslands;
    }
    public static void dfs(char[][] grid, boolean[][] vis, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length ||
                grid[i][j] == '0' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;
        for (int[] dir : directions) {
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            dfs(grid, vis, newRow, newCol);
        }
    }

}
