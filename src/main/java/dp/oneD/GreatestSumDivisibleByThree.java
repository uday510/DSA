package dp.oneD;

import java.util.Arrays;

public class GreatestSumDivisibleByThree {

    int n, k;
    int[] nums;
    int[][] dp;

    public int maxSumDivThree(int[] nums) {
        n = nums.length;
        k = 3;
        this.nums = nums;
        this.dp = new int[n][k];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int mod) {
        if (i >= n) return mod == 0 ? 0 : Integer.MIN_VALUE;

        if (dp[i][mod] != -1) return dp[i][mod];

        int skip = dfs(i + 1, mod);

        int newMod = (mod + nums[i]) % k;
        int take = nums[i] + dfs(i + 1, newMod);

        return dp[i][mod] = Math.max(skip, take);
    }

}
