package dp.matrix;

public class MinimumPathSum {

    int rows;
    int cols;
    int[][] dp;

    public int minPathSum(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new int[rows][cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                dp[row][col] = grid[row][col] + getMin(row, col);
            }
        }
        return dp[rows - 1][cols - 1];
    }

    private int getMin(int row, int col) {
        int curr = 0;
        if (row > 0 && col > 0) {
            curr = Math.min(dp[row - 1][col], dp[row][col - 1]);
        } else if (row > 0) {
            curr = dp[row - 1][col];
        } else if (col > 0) {
            curr = dp[row][col - 1];
        }

        return curr;
    }
    int m = 10;
    int n = 10;
}

/**
 *
 *
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 * Example 2:
 *
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d] + 101[e] + 101[e] to the sum.
 * Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 1000
 * s1 and s2 consist of lowercase English letters.
 *
 */