package dp.fibonacci;


import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	int[][] dp;
    int n;
    
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(-1, 0, nums);
    }

    public int lengthOfLISV2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int longest = 1;

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }


    private int dfs(int prev, int curr, int[] nums) {
        if (curr >= nums.length) return 0;

        if (dp[prev + 1][curr] != -1) return dp[prev + 1][curr];
        int skip = dfs(prev, curr + 1, nums);
        int take = 0;

        if (prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + dfs (curr, curr + 1, nums);
        }

        return dp[prev + 1][curr] = Math.max(skip, take);
    }
}