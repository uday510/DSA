/**
 * Problem Description
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 * First and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum count.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 6
 * Input 2:
 *
 *  A = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 *  Minimum count of numbers, sum of whose squares is 6 is 3.
 * Explanation 2:
 *
 *  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */
package dp;

import java.util.Arrays;

public class MinimumNumberOfSquares {
    public static void main(String[] args) {
        int n = 8;

        int res = solve(n);
        System.out.println(res);
    }
    public static int solve(int n) {
        int[] dp = new int[n+1];
//        numSquares(n ,dp);
       return tabulation(n);
//        return dp[n];
    }
    public static int numSquares(int n, int[] dp) {
        if (n == 0) return n;

        if (dp[n] != 0) return dp[n];
        int res = (int) 1e9;
        for (int i = 1; i*i <= n; ++i) {
            res = Math.min(res, numSquares(n - i*i, dp));
        }
        dp[n] = res+1;
        return dp[n];
    }
    public static int tabulation(int n) {
        int[] table = new int[n+1];

        for (int i = 1; i <= n; ++i) {
            int temp = (int) 1e9;
            for (int j = 1; j*j  <= i; ++j) {
                temp = Math.min(temp, table[i-j*j]);
            }
            table[i] = temp + 1;
        }
        System.out.println(Arrays.toString(table));
        return table[n];
    }
}
