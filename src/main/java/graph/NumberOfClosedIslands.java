/*
Given a 2D grid consists of 0s (land) and 1s (water).
 An island is a maximal 4-directionally connected group of 0s and a closed island
 is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Input: grid = [[1,1,1,1,1,1,1,0],
               [1,0,0,0,0,1,1,0],
               [1,0,1,0,1,1,1,0],
               [1,0,0,0,0,1,0,1],
               [1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).


Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2

input: [[0,0,1,1,0,1,0,0,1,0],
        [1,1,0,1,1,0,1,1,1,0],
[1,0,1,1,1,0,0,1,1,0],
[0,1,1,0,0,0,0,1,0,1],
[0,0,0,0,0,0,1,1,1,0],
[0,1,0,1,0,1,0,1,1,1],
[1,0,1,0,1,1,0,0,0,1],
[1,1,1,1,1,1,0,0,0,0],
[1,1,1,0,0,1,0,1,0,1],
[1,1,1,0,1,1,0,1,1,0]]

output: 5

 */
package graph;

public class NumberOfClosedIslands {
    private static final int[][] directions = new int[][] { {0,1}, {1,0}, {0,-1}, {-1,0} };

    public static void main(String[] args) {
    int[][] grid = {{0,0,1,1,0,1,0,0,1,0},
                    {1,1,0,1,1,0,1,1,1,0},
                    {1,0,1,1,1,0,0,1,1,0},
                    {0,1,1,0,0,0,0,1,0,1},
                    {0,0,0,0,0,0,1,1,1,0},
                    {0,1,0,1,0,1,0,1,1,1},
                    {1,0,1,0,1,1,0,0,0,1},
                    {1,1,1,1,1,1,0,0,0,0},
                    {1,1,1,0,0,1,0,1,0,1},
                    {1,1,1,0,1,1,0,1,1,0}};
        System.out.println(closedIsland(grid));
    }
    public static int closedIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int numIslands = 0;

        for(int i=1; i < grid.length - 1; i++) {
            for(int j=1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 0 && visited[i][j] == 0) {
                    if(dfs(grid, visited, i, j)) {
                        numIslands++;
                    }
                }
            }
        }

        return numIslands;
    }
    public static boolean dfs(int[][] grid, int[][] visited, int i, int j) {


        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false; // we are out of bounds
        }

        if (grid[i][j] == 1 || visited[i][j] == 1) {
            return true; // we are not interested in water or visited cells
        }

        visited[i][j] = 1;
        boolean isClosed = true;

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (!dfs(grid, visited, x, y)) {
                isClosed = false;
            }
        }

        return isClosed;
    }
}
