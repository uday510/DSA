/**
 * Problem Description
 * You are given an array A. You need to find the length of the Longest Increasing Subsequence in the array.
 *
 * In other words, you need to find a subsequence of array A in which the elements are in sorted order, (strictly increasing) and as long as possible.
 *
 *
 *
 * Problem Constraints
 * 1 ≤ length(A), A[i] ≤ 105
 *
 *
 *
 * Input Format
 * The first and only argument of the input is the array A.
 *
 *
 *
 * Output Format
 * Output a single integer, the length of the longest increasing subsequence in array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A: [2, 1, 4, 3]
 * Input 2:
 *
 * A: [5, 6, 3, 7, 9]
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 4] and [1, 3] are the longest increasing sequences of size 2.
 * Explanation 2:
 *
 * The longest increasing subsequence we can get is [5, 6, 7, 9] of size 4.
 */
package dynamicprogramming;

import java.util.ArrayList;

public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {5, 6, 3, 7, 9};
        System.out.println(solve(nums));
    }
    public static int solve(int[] nums) {
        //O(n^2) time | O(n) space
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            if (nums[i] > sub.getLast()) {
                sub.add(nums[i]);
            } else {
                int j = 0;
                while (num > sub.get(j)) {
                    ++j;
                }
                sub.set(j, num);
            }
        }
        return sub.size();
    }
}
