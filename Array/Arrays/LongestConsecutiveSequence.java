/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
package Array.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int ans = solve(nums);
        System.out.println(ans);
    }
    public static int solve(int[] nums) {
        // 1. First store all elements with value as true

        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }
        int longestLength = 0;

        for (int num : nums) {
            if (!map.get(num)) {
                continue; // continue till num is true
            }

            // make false
            map.put(num, false);
            int currentLength = 1;
            int left = num - 1;
            int right = num + 1;

            while (map.containsKey(left)) {
                left--;
                currentLength++;
            }
            while (map.containsKey(right)) {
                right++;
                currentLength++;
            }

            right -= 1;
            left += 1;
            if (currentLength > longestLength) {
                longestLength = right - left + 1;
            }
         }
        return longestLength;
    }
}
