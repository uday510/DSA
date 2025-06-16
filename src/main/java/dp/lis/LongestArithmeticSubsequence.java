package dp.lis;

import java.util.Arrays;

public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int offset = 500;
        int[][] dp = new int[n][1001];
        for (int[] row : dp) Arrays.fill(row, 1);
        int longest = 0;

        for (int j = 0; j < n; ++j) {
            dp[j][0] = 1;
            for (int i = 0; i < j; ++i) {
                int diff = nums[j] - nums[i] + offset;
                dp[j][diff] = Math.max(dp[j][diff], dp[i][diff] + 1);
                longest = Math.max(longest, dp[j][diff]);
            }
        }

        return longest;
    }

}
