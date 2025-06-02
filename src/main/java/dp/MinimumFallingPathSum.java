/**
 *Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 *
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 */
package dp;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3}, {6,5,4},{7,8,9}};

        int res = solve(matrix);
        System.out.println(res);
    }
    public static int solve(int[][] matrix) {

        return minFallingPathSum(matrix);
    }
    public static int minFallingPathSum(int[][] matrix) {
        // O(N^2) time | O(N^2) space

        int minFallingSum = Integer.MAX_VALUE;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];

        for (int startCol = 0; startCol < matrix.length; ++startCol) {
            minFallingSum = Math.min(minFallingSum, dfs(matrix, 0, startCol, dp));
        }
      return minFallingSum;
    }
    public static int dfs(int[][] matrix, int row, int col, Integer[][] dp) {
        // base cases
        if (col < 0 || col == matrix.length) {
            return Integer.MAX_VALUE;
        }
        // check if we have reached the last row
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        // check if the result are calculated before
        if (dp[row][col] != null) {
            return dp[row][col];
        }
        // calculate the minimum falling path sum starting from each possible next step
        int left = dfs(matrix, row + 1, col-1, dp);
        int middle = dfs(matrix, row + 1, col, dp);
        int right = dfs(matrix, row + 1, col + 1, dp);

        dp[row][col] = Math.min(left, Math.min(middle, right)) + matrix[row][col];
        return dp[row][col];
    }
    public static int findFallingSum(int[][] matrix, int row, int col) {
        // check if we are out of the left or right boundary of the matrix
        if (col < 0 || col == matrix.length) {
            return Integer.MAX_VALUE;
        }
        // check if we have reached the last row
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        // calculate the minimum falling path sum starting from each possible next step
        int left = findFallingSum(matrix, row + 1, col-1);
        int middle = findFallingSum(matrix, row + 1, col);
        int right = findFallingSum(matrix, row + 1, col + 1);

        return Math.min(left, Math.min(middle, right)) + matrix[row][col];
    }
}
