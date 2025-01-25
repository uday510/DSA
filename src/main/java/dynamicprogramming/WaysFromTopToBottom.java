/**
 * Given matrix[n][m], find total no.of ways from (0, 0) to (n-1, m-1).
 */
package dynamicprogramming;

import java.util.Arrays;

public class WaysFromTopToBottom {
    public static void main(String[] args) {
        int res = optimized(5, 6);
        System.out.println(res);
    }
    public static int solve(int n, int m) {
        int[][] dp = new int[n][m];

        return ways(n-1, m-1, dp);
    }
    public static int optimized(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);

      for (int i = 0; i < m; ++i) {
          for (int j = 1; j < m; ++j) {
              dp[j] = dp[j-1] + dp[j];
          }
      }
      return dp[m-1];
    }
    public static int bottomUp(int n, int m) {
        int[][] dp = new int[n][m];

        // initialize first row, first col with 1.
        Arrays.fill(dp[0], 1);
        for (int x = 0; x < n; ++x) {
            dp[x][0] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][m-1];
    }
    public static int ways(int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 1;

        if (dp[i][j] != 0) return dp[i][j];

        int res = ways(i, j - 1, dp) + ways(i - 1, j, dp);

        dp[i][j] = res;

        return res;
    }
}
