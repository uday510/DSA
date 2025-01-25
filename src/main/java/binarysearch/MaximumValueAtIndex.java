/**
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
 *
 * nums.length == n
 * nums[i] is a positive integer where 0 <= i < n.
 * abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
 * The sum of all the elements of nums does not exceed maxSum.
 * nums[index] is maximized.
 * Return nums[index] of the constructed array.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, index = 2,  maxSum = 6
 * Output: 2
 * Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
 * There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
 * Example 2:
 *
 * Input: n = 6, index = 1,  maxSum = 10
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= maxSum <= 109
 * 0 <= index < n
 *
 * https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 */
package binarysearch;

public class MaximumValueAtIndex {
    public static void main(String[] args) {
        int n = 4, index = 2, maxSum = 6;

    }
    public int maxValue(int n, int index, int maxSum) {
        // https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/solutions/1121538/easy-java-solution-without-using-binary-search-using-greedy-approach-with-explanation/
        int currSum = n;
        int left = index, right = index;
        int ans = 1;

        while (currSum + (right-left+1) <= maxSum) {
            currSum += right - left + 1;

            left = left == 0 ? 0 : left - 1;
            right = right == n - 1 ? right : right + 1;
            ans++;

            if (left == 0 && right == n-1) {
                int steps = 0;
                steps += (maxSum - currSum) / n;
                currSum += (steps * n);
                ans += steps;
            }
        }
        return ans;
    }
}
