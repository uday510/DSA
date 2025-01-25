/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */
package dynamicprogramming;

import java.util.Arrays;

public class JumpGame2 {
    static int minSteps = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        /**
         * Approach: 1
         * Backtracking
         * Time Complexity: O(2^n)
         *
         * Approach: 2
         * Dynamic Programming
         * Time Complexity: O(n^2)
         *
         * Approach: 3
         * Greedy
         * Time Complexity: O(n)
         * Space Complexity: O(1)
         */

        // Approach 1

//        return jump(nums, 0, 0);

        // Approach 2

//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//
//        dp[0] = 0;
//        for (int i = 0; i < nums.length; ++i) {
//            for (int j = i+1; j <= i + nums[i] && j < nums.length; ++j) {
//                dp[j] = Math.min(dp[j], dp[i] + 1);
//            }
//        }
//        return dp[nums.length - 1];

        // Approach 3

        int jumps = 0;
        int currentJumpEnd = 0; // The end of the current jump
        int farthestJump = 0; // The farthest jump

        for (int i = 0; i < nums.length - 1; i++) {
            // Find the farthest jump
            farthestJump = Math.max(farthestJump, i + nums[i]);

            // If we have reached the end of the current jump, then we need to make another jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthestJump;
            }
        }

        return jumps;
    }
    public static int jump(int[] nums, int index, int steps) {
        if (index == nums.length - 1) {
            minSteps = Math.min(minSteps, steps);
            return minSteps;
        }

        int farthestJump = Math.min(index + nums[index], nums.length - 1);

        for (int i = index + 1; i <= farthestJump; i++) {
            jump(nums, i, steps + 1);
        }

        return minSteps;
    }
}
