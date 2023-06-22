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
package DynamicProgramming;

import java.util.HashMap;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int res = rob(nums);
        System.out.println(res);
    }
    public static int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dp(nums.length - 1, nums, memo);
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
