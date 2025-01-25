/**
 * Problem Description
 *
 * You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.
 *
 * Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 105
 *
 *
 *
 * Input Format
 *
 * The only argument given is integer A.
 *
 *
 *
 * Output Format
 *
 * Return the ans%(109+7).
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  OFF OFF
 *  OFF ON
 *  ON OFF
 * All lights off is also a valid signal which probably means 'bye'
 *
 * Explanation 2:
 *
 *  OFF OFF OFF
 *  OFF OFF ON
 *  OFF ON OFF
 *  ON OFF OFF
 *  ON OFF ON
 */
package dynamicprogramming;

public class WaysToSendTheSignal {
    public static void main(String[] args) {
        int A = 26;

        int res = solve(A);
        System.out.println(res);
    }
    public static int solve(int A) {
        // O(A) time | O(A) space
        int MOD = (int) 1e9 + 7;
        int[][] dp = new int[A+1][2];

        dp[1][0] = 1; // base case
        dp[1][1] = 1; // base case

        for (int i = 2; i <= A; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
            dp[i][1] = dp[i-1][0];
        }
        return (dp[A][0] + dp[A][1]) % MOD;
    }
}
