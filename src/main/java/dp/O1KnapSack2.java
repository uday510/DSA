/**
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 * NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 500
 *
 * 1 <= C, B[i] <= 106
 *
 * 1 <= A[i] <= 50
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 *
 * Second argument is an integer array B of size N denoting the weights on N items.
 *
 * Third argument is an integer C denoting the knapsack capacity.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [6, 10, 12]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [1, 3, 2, 4]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  22
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
 * Explanation 2:
 *
 *  Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class O1KnapSack2 {
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4};
        int[] B = {12, 13, 15, 19};
        int C = 10;

        int res = solve(A, B, C);
        System.out.println(res);
    }
    public static int solve(int[] A, int[] B, int C) {
        return KnapSack(A, B, C);
    }
    public static int optimized(int[] A, int[] B, int C) {
        int k = IntStream.of(A).sum();
        int n = A.length;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, (int) 1e8);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = k; j > -1; --j) {
                if (A[i - 1] <= j && dp[j - A[i - 1]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - A[i - 1]] + B[i - 1]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        int res = 0;
        for (int j = k; j > -1; --j) {
            if (dp[j] <= C) {
                res = j;
                break;
            }
        }
        return res;
    }
    public static int KnapSack(int[] A, int[] B, int C) {
        // O(n*k) time and O(n*k) space
        int k = IntStream.of(A).sum();
        int n = A.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < k+1; ++i) dp[0][i] = Integer.MAX_VALUE;
        for (int i = 0; i < n+1; ++i) dp[i][0] = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                if (A[i-1] <= j && dp[i-1][j-A[i-1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-A[i-1]] + B[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int res = 0;
        for (int j = k; j > -1; --j) {
            if (dp[n][j] <= C) {
                res = j;
                break;
            }
        }
        return res;
    }
}
