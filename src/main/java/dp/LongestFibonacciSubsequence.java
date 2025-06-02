/**
 * Problem Description
 * Given a strictly increasing array A of positive integers forming a sequence.
 *
 * A sequence X1, X2, X3, ..., XN is fibonacci like if
 *
 *
 * N > =3
 * Xi + Xi+1 = Xi+2 for all i+2 <= N
 * Find and return the length of the longest Fibonacci-like subsequence of A.
 *
 * If one does not exist, return 0.
 *
 * NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.
 *
 *
 *
 * Problem Constraints
 * 3 <= length of the array <= 1000
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the length of the longest Fibonacci-like subsequence of A.
 * If one does not exist, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5, 6, 7, 8]
 * Input 2:
 *
 *  A = [1, 3, 7, 11, 12, 14, 18]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
 * Explanation 2:
 *
 *  The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
 *  The length will be 3.
 */
package dp;

import java.util.HashMap;

public class LongestFibonacciSubsequence {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
    int n = A.length;
    int res = 0;
    int[][] dp = new int[1000][1000];
    HashMap<Integer, Integer> position = new HashMap<>();

    for (int i = 0; i < n; ++i) position.put(A[i], i);

    // dp[a3][a2] --> length of longest fibonacci sequence ending with a2 and a3
    // dp[a3][a2] = dp[a2][a1] + 1

    //dp[i][j]--> this is length of longest fibonacci seq ending at j, i where(j < i && a[j] < a[i] && search for (a[i] - a[j])

    //dp[a3][a2] = dp[a2][a1] + 1//because of length
    //in worst case there are three nested loops --> 10^9'

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            int a3 = A[i];
            int a2 = A[j];
            int a1 = a3 - a2; // a1 + a2 = a3 --> fibonacci

            if (a1 < a2 && position.containsKey(a1)) {
                int k = position.get(a1);
                dp[i][j] = dp[j][k] + 1;
                res = Math.max(res, dp[i][j] + 2);
            }

            // for(int k = 0; k < j - 1; k++) {
            //     if(A.get(k) == a1){
            //         //a3 {a2 a1}
            //         //search for answer when a2->a3 and a1->a2
            //
            //
            //     }
            // }
        }
    }
        return res;
    }
}
