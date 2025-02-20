package dynamicprogramming;

public class HouseRobber2 {

    int[] nums;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        this.nums = nums;

        int st0 = dfs(0, nums.length - 1, new int[nums.length-1]);
        int st1 = dfs(1, nums.length, new int[nums.length]);

        return Math.max(st0, st1);
    }

    private int dfs(int idx, int len, int[] dp) {
        if (idx >= len) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int pick = nums[idx] + dfs(idx + 2, len, dp);
        int dont = dfs(idx + 1, len, dp);

        return dp[idx] = Math.max(pick, dont);
    }

}
