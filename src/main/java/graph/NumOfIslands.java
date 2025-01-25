/**
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
 *
 * More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
 *
 * (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
 * (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
 * (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
 * (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
 * (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
 * (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
 * (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
 * (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
 * Return the number of islands.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 100
 *
 * 0 <= A[i] <= 1
 *
 *
 *
 * Input Format
 * The only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the number of islands.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [0, 1, 0]
 *        [0, 0, 1]
 *        [1, 0, 0]
 *      ]
 * Input 2:
 *
 *  A = [
 *        [1, 1, 0, 0, 0]
 *        [0, 1, 0, 0, 0]
 *        [1, 0, 0, 1, 1]
 *        [0, 0, 0, 0, 0]
 *        [1, 0, 1, 0, 1]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The 1's at position A[0][1] and A[1][2] forms one island.
 *  Other is formed by A[2][0].
 * Explanation 2:
 *
 *  There 5 island in total.
 */
package graph;

public class NumOfIslands {
    private static final int[][] directions = new int[][] {
            {-1, 0}, // up
            {1, 0}, // down
            {0, -1}, // left
            {0, 1}, // right
            {-1, -1}, // up-left
            {-1, 1}, // up-right
            {1, -1}, // down-left
            {1, 1} // down-right
    };
    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(solve(A));
    }
    public static int solve(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int numIslands = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    numIslands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return numIslands;
    }
    public static void dfs(int[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;

        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
