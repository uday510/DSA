package dp;

import java.util.Arrays;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int result = maximalSquare_(matrix);
        Arrays.sort(new int[]{});
        System.out.println(result);
    }
    public static int maximalSquare_(char[][] matrix) {
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

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = matrix[i][j];
                if (ch == '0') continue;

                int dia = (i > 0 && j > 0) ? dp[i-1][j-1] : 0;
                int up = (i > 0) ? dp[i-1][j] : 0;
                int left = (j > 0) ? dp[i][j-1] : 0;

                dp[i][j] = 1 + Math.min(dia, Math.min(left, up));
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen * maxLen;
    }

}
