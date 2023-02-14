/**
 * iven an array of integers A and an integer B.
 *
 * Find the total number of subarrays having sum equals to B.
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * Output Format
 *
 * Return the total number of subarrays having sum equals to B.
 * Constraints
 *
 * 1 <= length of the array <= 50000
 * -1000 <= A[i] <= 1000
 * For Example
 *
 * Input 1:
 *     A = [1, 0, 1]
 *     B = 1
 * Output 1:
 *     4
 *     Explanation 1:
 *         [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
 *
 * Input 2:
 *     A = [0, 0, 0]
 *     B = 0
 * Output 2:
 *     6
 */
package Hashing;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] array = {1, 1, 1};
        int k = 2;
        int res = solve(array, k);
        System.out.println(res);
    }
    public static int solve(int[] array, int k) {
        int res = 0;
        return res;
    }
}
