/**
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 *
 * A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4], difference = 1
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [1,2,3,4].
 * Example 2:
 *
 * Input: arr = [1,3,5,7], difference = 1
 * Output: 1
 * Explanation: The longest arithmetic subsequence is any single element.
 * Example 3:
 *
 * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [7,5,3,1].
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 */
package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDiff {
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(longestSubsequence(arr, difference));
    }
    public static int longestSubsequence(int[] arr, int difference) {
        // O(n) time and O(n) space where n is the length of the array
        Map<Integer, Integer> dp = new HashMap<>();
        int res = 1;
        dp.put(arr[0], 1);

        for (int i = 1; i < arr.length; ++i) {
            int curr = arr[i];
            int diff = curr - difference;
            if (dp.containsKey(diff)) {
                dp.putIfAbsent(curr, 1);
                dp.put(curr, Math.max(dp.get(curr), dp.get(diff) + 1));
            } else {
                dp.put(curr, 1);
            }
            res = Math.max(res, dp.get(curr));
        }
        return res;
    }
}
