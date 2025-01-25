/**
 * Problem Description
 * Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
 * Return the number of important reverse pairs in the given array A.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 105
 *
 * -2 * 109 <= A[i] <= 2 * 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the number of important reverse pairs in the given array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 3, 2, 3, 1]
 * Input 2:
 *
 *  A = [4, 1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are two pairs which are important reverse i.e (3, 1) and (3, 1).
 * Explanation 2:
 *
 *  There is only one pair i.e (4, 1).
 */
package sort;

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {2000000000, 2000000000, -2000000000};
        int reversePairs = solve(arr);
        System.out.println(reversePairs);
    }
    public static int solve(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if((long) arr[i] > (long)2 * arr[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
