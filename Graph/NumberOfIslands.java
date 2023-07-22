/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
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
package Graph;

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
        int[][] visited = new int[grid.length][grid[0].length];
        visited[0][0] = 1;
        int numIslands = 0;

        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0) {
                    numIslands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return numIslands;
    }
    public static void dfs(char[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;

        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1' && visited[newRow][newCol] == 0) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
