package dp;

import java.util.Arrays;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int result = maximalSquare(matrix);
        Arrays.sort(new int[]{});
        System.out.println(result);
    }
    public static int maximalSquare(char[][] matrix) {
        int maximumSquare = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int currentSquareLength = 0;
                boolean flag = true;

                while (currentSquareLength + row < rows && currentSquareLength + col < cols && flag) {
                    for (int currCol = col; currCol <= currentSquareLength + col; ++currCol) {
                        if (matrix[row + currentSquareLength][currCol] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    for (int currRow = row; currRow <= currentSquareLength + row; ++currRow) {
                        if (matrix[currRow][col + currentSquareLength] == '0') {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        currentSquareLength++;
                    }
                }
                maximumSquare = Math.max(maximumSquare, currentSquareLength);
            }
        }

        return maximumSquare * maximumSquare;
    }

    private static int maximalSquareOptimized(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maximum = 0;

        for (int row = 1; row <= rows; ++row) {
            for (int col = 1; col <= cols; ++col) {
                if (matrix[row - 1][col - 1] == '0') {
                    continue;
                }

                dp[row][col] = Math.min(dp[row - 1][col - 1],
                        Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;

                maximum = Math.max(dp[row][col], maximum);
            }
        }

        return maximum * maximum;
    }
}
