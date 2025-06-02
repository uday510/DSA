/**
 * Problem Description
 * You are climbing a staircase and it takes A steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Return the number of distinct ways modulo 1000000007
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 * The first and the only argument contains an integer A, the number of steps.
 *
 *
 *
 * Output Format
 * Return an integer, representing the number of ways to reach the top.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Distinct ways to reach top: [1, 1], [2].
 * Explanation 2:
 *
 *  Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */
package dp;

public class Stairs {
    static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        int n = 3;

        int res = climbStairs(n);
        System.out.println(res);
    }
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        solve(n, dp);
        return dp[n];
    }
    public static int solve(int n, int[] dp) {
        if (n == 1 || n == 2) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = (solve(n-1, dp) + solve(n-2, dp)) % MOD;
        return dp[n];
    }
    public static int solve2(int n) {
        if (n == 1|| n == 2) return n;
        int a = 1;
        int b = 2;

        for (int i = 2; i <= n; ++i) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
