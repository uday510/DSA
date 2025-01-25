/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
package dynamicprogramming;

import java.util.HashMap;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int res = dp(nums);
        System.out.println(res);
    }
    public static int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dp(nums.length - 1, nums, memo);
    }
    public static int dp(int[] nums) {
        // bottom-up
        if (nums.length == 1) return nums[0];

        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < n; ++i) {
//            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
//        }
//        return dp[n-1];

//        int prev2 = 0;
//        int prev1 = nums[0];
//
//        for (int i = 1; i < nums.length; ++i) {
//            int current = Math.max (prev1 , prev2 + nums[i]);
//
//            prev2 = prev1;
//            prev1 = current;
//        }
//        return prev1;

        int robNext, robNextPlusOne;

        //Base case initializations
        robNextPlusOne = 0;
        robNext = nums[n - 1];

        //DP table calculations
        for (int i = n - 2; i > -1; --i) {
            int current = Math.max(robNext, robNextPlusOne + nums[i]);

            // update the variables
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;

    }
    public static int dp(int i, int[] nums, HashMap<Integer, Integer> memo) {
        // Base Cases
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);

        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        memo.put(i, Math.max(dp(i - 1, nums, memo), dp(i - 2, nums, memo) + nums[i]));

        return memo.get(i);
    }
}
