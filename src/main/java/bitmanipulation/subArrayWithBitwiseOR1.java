/**
 * Problem Description
 * Given an array B of length A with elements 1 or 0. Find the number of subarrays such that
 * the bitwise OR of all the elements present in the subarray is 1.
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 * Input Format
 * The first argument is a single integer A.
 * The second argument is an integer array B.
 *
 *
 * Output Format
 * Return the number of subarrays with bitwise array 1.
 *
 *
 * Example Input
 * Input 1:
 *  A = 3
 * B = [1, 0, 1]
 * Input 2:
 *  A = 2
 * B = [1, 0]
 *
 *
 * Example Output
 * Output 1:
 * 5
 * Output2:
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 * The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 * Explanation 2:
 * The subarrays are :- [1], [0], [1, 0]
 * Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 */

package bitmanipulation;

public class subArrayWithBitwiseOR1 {
    public static void main(String[] args) {
        int[] array = {1, 0, 1};
        long ans = solve(array);
        System.out.println(ans);
    }
    public static long solve(int[] array) {
        // O(N) time | O(1) space
        long count = 0;
        long zeroes = 0;
        long N = array.length;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 0) {
                zeroes++;
            } else {
                count += (zeroes * (zeroes + 1)) / 2;
                zeroes = 0;
            }
        }
        count += (zeroes * (zeroes + 1)) / 2;

        return (N * (N + 1) / 2) - count;
    }
    public static int solve2(int[] array) {
        // O(N^2) time | O(1) space
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            int val = 0;
            for (int j = i; j < array.length; ++j) {
                val = val | array[j];
                if (val == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int bruteForce(int[] array) {
        // O(N^3) time | O(1) space
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = i; j < array.length; ++j) {
                int val = 0;
                for (int k = i; k <= j; ++k) {
                    val = val | array[k];
                }
                if (val == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
