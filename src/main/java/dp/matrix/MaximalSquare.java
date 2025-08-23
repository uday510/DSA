package dp.matrix;

public class MaximalSquare {

    public int maximalSquare_(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int maxLen = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '0') continue;

                int up = 0, left = 0, dia = 0;
                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];
                if (i > 0 && j > 0) dia = dp[i - 1][j - 1];

                dp[i][j] = 1 + Math.min(up, Math.min(left, dia));
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen * maxLen;
    }

        public int maximalSquare(char[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;

            int[][] dp = new int[m][n];
            int largest = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    char ch = matrix[i][j];
                    if (ch == '0') continue;

                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(
                                dp[i-1][j-1],
                                Math.min(dp[i-1][j], dp[i][j-1]));
                    }

                    dp[i][j] += 1;
                    largest = Math.max(largest, dp[i][j]);
                }
            }

            return largest * largest;
        }

}
