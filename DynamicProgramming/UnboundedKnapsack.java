package DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] A = {12, 20, 15, 6, 10};
        int[] B = {3, 6, 5, 2, 4};
        int c = 8;

        int res = topDown(A, B, c);
        System.out.println(res);
    }
    public static int topDown(int[] values, int[] weights, int capacity) {
        // O(N*capacity) time | O(N*capacity) space
        int n = values.length;
        Integer[][] dp = new Integer[n+1][capacity+1];

        Arrays.fill(dp[0], 0);
        for (int i = 1; i < n+1; ++i) dp[i][0] = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= capacity; ++j) {
                dp[i][j] = dp[i-1][j];
                if (j - weights[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j - weights[i-1]]);
                }
            }
        }

        return dp[n][capacity];
    }
}
