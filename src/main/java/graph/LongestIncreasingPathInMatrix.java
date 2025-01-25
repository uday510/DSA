/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1

 */
package graph;

public class LongestIncreasingPathInMatrix {
    private static final int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
    public static int longestIncreasingPath(int[][] matrix) {
        // O(mn) time | O(mn) space
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,dfs(matrix,i,j,dp));
            }
        }
        return max;
    }
    public static int dfs(int[][] matrix, int i, int j, Integer[][] dp){
        if(dp[i][j] != null) return dp[i][j];

        int max = 0;

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            int prev = matrix[i][j];

            if (newRow < 0 || newRow >= matrix.length || newCol < 0 ||
                newCol >= matrix[0].length || prev >= matrix[newRow][newCol]) {
                continue;
            }

            max = Math.max(max, dfs(matrix, newRow, newCol, dp));
        }

        dp[i][j] = max + 1; // +1 for the current cell
        return dp[i][j];
    }
}
