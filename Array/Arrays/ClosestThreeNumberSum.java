/**
 * Problem Description
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
 *
 * Assume that there will only be one solution.
 *
 *
 *
 * Problem Constraints
 * -108 <= B <= 108
 * 1 <= N <= 104
 * -108 <= A[i] <= 108
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer B denoting the sum you need to get close to.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the sum of three integers which is closest to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [-1, 2, 1, -4]
 * B = 1
 * Input 2:
 *
 *
 * A = [1, 2, 3]
 * B = 6
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * Explanation 2:
 *
 *  Take all elements to get exactly 6.
 */
package Array.Arrays;

import java.util.Arrays;

public class ClosestThreeNumberSum {
    public static void main(String[] args) {
        int[] array = { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8};
        int b = -1;
        int ans = solve(array, b);
        System.out.println(ans);
    }

    public static int solve(int[] array, int b) {
        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(array);

        // --- BRUTE FORCE ---
//        for (int i = 0; i < array.length - 2; i++) {
//            for (int j = i+1; j < array.length - 1; j++) {
//                for (int k = j+1; k < array.length; k++) {
//                    int currentSum = array[i] + array[j] + array[k];
//                    if (Math.abs(currentSum - b) < Math.abs(ans - b)) {
//                        ans = currentSum;
//                    }
//                }
//            }
//        }

        // --- TWO POINTER ---
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1, right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                int currentDiff = Math.abs (currentSum - b);

                if ( currentDiff < diff ) {
                    ans = currentSum;
                    diff = Math.abs (currentSum - b);
                }

                else if (currentSum < b) {
                    left++;
                } else {
                    right--;
                }

                if (currentSum == b)
                {
                    return currentSum;
                }

            }
        }

        return ans;
    }
}
