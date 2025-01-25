package dynamicprogramming;

import java.util.Arrays;

public class CanPartition {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
    private static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int n = nums.length;
       int[][] dp = new int[n][sum/2 + 1];
       for (int[] arr : dp)
           Arrays.fill(arr, -1);

       return dfs(nums, 0, 0,  sum/2, n, dp);
    }
    private static boolean dfs(int[] nums, int i, int sum, int target, int n, int[][] dp) {
        if(sum == target) return true;
        if(i >= n || sum > target) return false;
        if(dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean include = dfs(nums, i + 1, sum + nums[i], target, n, dp);
        boolean exclude = dfs(nums, i + 1, sum, target, n, dp);
        dp[i][sum] = include || exclude ? 1 : 0;
        return dp[i][sum] == 1;
    }
}
