/**
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 *
 * Return the minimum number of moves to make every value in nums unique.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: 1
 * Explanation: After 1 move, the array could be [1, 2, 3].
 * Example 2:
 *
 * Input: nums = [3,2,1,2,1,7]
 * Output: 6
 * Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 *
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/
 */
package array;

import java.util.Arrays;

public class MinimumIncrementToUnique {
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};

        int res = solve(nums);
        System.out.println(res);
    }
    public static int solve(int[] nums) {
        int res = 0;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] <= nums[i-1]) {
                res += nums[i-1]+1 - nums[i];
                nums[i] = nums[i-1] + 1;
            }
        }

        return res;
    }
}
