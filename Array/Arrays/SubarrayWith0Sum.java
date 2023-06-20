/**
 * Problem Description
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * -10^9 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return whether the given array contains a subarray with a sum equal to 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [-1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  No subarray has sum 0.
 * Explanation 2:
 *
 *  The array has sum 0.
 */
package Array.Arrays;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWith0Sum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] nums) {
        Set<Long> set = new HashSet<>();

        set.add((long) 0); // if sub-array sum is zero.

        long currentSum = 0;

        for (int num : nums) {
            currentSum += (long) num;
            if (set.contains(currentSum)) {
                return 1;
            } set.add((long) currentSum);
        }
        return 0;
    }
}
