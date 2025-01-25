package dynamicprogramming;

import java.util.Arrays;

public class CountSquares {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        System.out.println(countSquares(matrix));
    }
    private static int countSquares(int[][] matrix) {
        return bottomUp(matrix);
    }
    private static int topDown(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count += topDownHelper(matrix, i, j, dp);
            }
        }
        return count;
    }
    private static int topDownHelper(int[][] matrix, int i, int j, int[][] dp) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (matrix[i][j] == 0) {
            return dp[i][j] = 0;
        }
        int right = topDownHelper(matrix, i, j + 1, dp);
        int down = topDownHelper(matrix, i + 1, j, dp);
        int diagonal = topDownHelper(matrix, i + 1, j + 1, dp);
        return dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
    }

    private static int bottomUp(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            count += dp[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = matrix[0][j];
            count += dp[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    count += dp[i][j];
                }
            }
        }
        return count;
    }

}
