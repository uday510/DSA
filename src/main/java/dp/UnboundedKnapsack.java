/**
 * Problem Description
 * Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
 *
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1000
 *
 * 1 <= |B| <= 1000
 *
 * 1 <= B[i] <= 1000
 *
 * 1 <= C[i] <= 1000
 *
 *
 *
 * Input Format
 * First argument is the Weight of knapsack A
 *
 * Second argument is the vector of values B
 *
 * Third argument is the vector of weights C
 *
 *
 *
 * Output Format
 * Return the maximum value that fills the knapsack completely
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 10
 * B = [5]
 * C = [10]
 * Input 2:
 *
 * A = 10
 * B = [6, 7]
 * C = [5, 5]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 * 14
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only valid possibility is to take the given item.
 * Explanation 2:
 *
 * Take the second item twice.
 */
package dp;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] A = {12, 20, 15, 6, 10};
        int[] B = {3, 6, 5, 2, 4};
        int c = 8;

        int res = topDown(A, B, c);
        System.out.println(res);
    }
    public int optimized(int capacity, int[] values, int[] weights) {
        int n = values.length;
        int[] dp = new int[capacity+1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= capacity; ++j) {
                if (j - weights[i-1] >= 0) {
                    dp[j] = Math.max(dp[j], values[i-1] + dp[j - weights[i-1]]);
                }
            }
        }
        return dp[capacity];
    }
    public static int solve(int[] values, int[] weights, int capacity) {
        // O(N*capacity) time | O(N*capacity) space
        int n = values.length;
        Integer[][] dp = new Integer[n+1][capacity+1];

       return solve(n-1, capacity, values, weights, dp);

//        return topDown(values, weights, capacity);
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
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i][j - weights[i-1]]);
                }
            }
        }
        return dp[n][capacity];
    }
    public static int solve(int i, int j, int[] values, int[] weights, Integer[][] dp) {
        if (i < 0 || j == 0) return 0;
        if (dp[i][j] != null) return dp[i][j];

        if (weights[i] <= j) {
            dp[i][j] = Math.max(
                    solve(i-1, j, values, weights, dp),
                    values[i] + solve(i, j-weights[i],values, weights, dp));
        } else {
            dp[i][j] = solve(i - 1, j, values, weights, dp);
        }
        return dp[i][j];
    }
}
