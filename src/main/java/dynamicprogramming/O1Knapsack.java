/**
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 *
 * Also given an integer C which represents knapsack capacity.
 *
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 *
 * NOTE:
 *
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 *
 *
 * Problem Constraints
 * 1 <= N <= 103
 *
 * 1 <= C <= 103
 *
 * 1 <= A[i], B[i] <= 103
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
 *  A = [60, 100, 120]
 *  B = [10, 20, 30]
 *  C = 50
 * Input 2:
 *
 *  A = [10, 20, 30, 40]
 *  B = [12, 13, 15, 19]
 *  C = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  220
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
 * Explanation 2:
 *
 *  Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
package dynamicprogramming;

import java.util.Arrays;

public class O1Knapsack {
    public static void main(String[] args) {
        int[] A = {12, 20, 15, 6, 10};
        int[] B = {3, 6, 5, 2, 4};
        int c = 8;

        int res = optimised(A, B, c);
        System.out.println(res);
    }
    public static int solve(int[] values, int[] weights, int capacity) {
        // O(N*capacity) time | O(N*capacity) space
        int n = values.length;
        Integer[][] dp = new Integer[n+1][capacity+1];

       return solve(n-1, capacity, values, weights, dp);

//        return topDown(values, weights, capacity);
    }
    public static int optimised(int[] A, int[] B, int C) {
        int n = A.length;
        int[] dp = new int[C+1];

        for (int i = 1; i <= n; ++i) {
            for (int j = C; j > -1; --j) {
                if (j - B[i-1] >= 0) {
                    dp[j] = Math.max(dp[j], A[i-1] + dp[j - B[i-1]]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[C];
    }
    public static int topDown(int[] values, int[] weights, int capacity) {
        // O(N*capacity) time | O(N*capacity) space
        int n = values.length;
        Integer[][] dp = new Integer[n+1][capacity+1];

        Arrays.fill(dp[0], 0);
        for (int i = 1; i < n+1; ++i) dp[i][0] = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= capacity; ++j) {
                dp[i][j] = dp[i-1][j];
                if (j - weights[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j - weights[i-1]]);
                }
            }
        }
        for (Integer[] ar : dp) System.out.println(Arrays.toString(ar));
        return dp[n][capacity];
    }
    public static int solve(int i, int j, int[] values, int[] weights, Integer[][] dp) {
        if (i < 0 || j == 0) return 0;
        if (dp[i][j] != null) return dp[i][j];

        if (weights[i] <= j) {
            dp[i][j] = Math.max(
                    solve(i-1, j, values, weights, dp),
                    values[i] + solve(i-1, j-weights[i],values, weights, dp));
        } else {
            dp[i][j] = solve(i - 1, j, values, weights, dp);
        }
        return dp[i][j];
    }
}
