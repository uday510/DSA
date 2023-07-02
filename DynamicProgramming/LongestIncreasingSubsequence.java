/**Given an integer array nums, return the length of the longest strictly increasing
 subsequence
 .



 Example 1:

 Input: nums = [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 */
package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        /**
         * Algorithm
         *
         * Initialize an array dp with length nums.length and all elements equal to 1. dp[i] represents the length of the longest increasing subsequence that ends with the element at index i.
         *
         * Iterate from i = 1 to i = nums.length - 1. At each iteration, use a second for loop to iterate from j = 0 to j = i - 1 (all the elements before i). For each element before i, check if that element is smaller than nums[i]. If so, set dp[i] = max(dp[i], dp[j] + 1).
         *
         * Return the max value from dp.
         */
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int longest = 1;

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}
