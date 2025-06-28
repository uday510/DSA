package dp.lis;

import java.util.Arrays;

public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {
        // int n = nums.length;
        // Map<Integer, Integer>[] dp = new HashMap[n];
        // int longest = 0;

        // for (int i = 0; i < n; ++i) {
        //     dp[i] = new HashMap<>();
        //     for (int j = 0; j < i; ++j) {
        //       int diff = nums[i] - nums[j];
        //       int len = dp[j].getOrDefault(diff, 1) + 1;
        //       dp[i].put(diff, len);
        //       longest = Math.max(longest, len);
        //     }
        // }

        // return longest;

        int n = nums.length;
        int offset = 500;
        int[][] dp = new int[n][1001];
        for (int[] row : dp) Arrays.fill(row, 1);
        int longest = 2;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = nums[i] - nums[j] + offset;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                longest = Math.max(longest, dp[i][diff]);
            }
        }
        return longest;
    }

}
