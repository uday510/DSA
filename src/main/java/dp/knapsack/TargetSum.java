package dp.knapsack;

import java.util.Arrays;

public class TargetSum {

    int[][] dp;
    int offset;
    int MIN;

    public int findTargetSumWays(int[] nums, int target) {
        offset = Arrays.stream(nums).sum();
        dp = new int[nums.length][2 * offset + 1];
        MIN = Integer.MIN_VALUE;
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        return dfs(0, 0, nums, target);
    }

    private int dfs(int curr, int idx, int[] nums, int target) {
        if (curr == target && idx == nums.length) return 1;
        if (idx >= nums.length) return 0;
        if (dp[idx][curr + offset] != Integer.MIN_VALUE) return dp[idx][curr + offset];

        int pos = dfs(curr + nums[idx], idx + 1, nums, target);

        int neg = dfs(curr - nums[idx], idx + 1, nums, target);

        return dp[idx][curr + offset] = pos + neg;
    }

}
