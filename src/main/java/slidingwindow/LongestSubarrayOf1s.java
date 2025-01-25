/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.



Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
package slidingwindow;

public class LongestSubarrayOf1s {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};

        int res = longestSubarray(nums);
        System.out.println(res);
    }
    public static int longestSubarray(int[] nums) {

        int i = 0, j = 0, N = nums.length, cnt = 0, ans = 0;

        for (; j < N; ++j) {
            cnt += nums[j] == 0 ? 1 : 0;
            while (cnt > 1) {
                cnt -= nums[i] == 0 ? 1 : 0;
                i++;
            }
            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}
