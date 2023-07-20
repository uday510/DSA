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
package DynamicProgramming;

public class JumpGame2 {
    static int minSteps = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        // Then starting range of the jump is 0 to nums[0]
        int answer = 0, n = nums.length;
        int currEnd = 0, currFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            currFar = Math.max(currFar, i + nums[i]);

            // if we have reached the end of the current range
            // then we need to make a jump
            if (i == currEnd) {
                ++answer;
                currEnd = currFar;
            }
        }
        return answer;
    }
}
