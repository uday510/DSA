/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 */
package dp;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {

    }
    public static int change(int totalAmount, int[] coins) {
        int[] dp = new int[totalAmount + 1];
        dp[0] = 1; // Initialize first column with 1

        for (int coin : coins) {

            for (int currAmount = 1; currAmount <= totalAmount; ++currAmount) {

                if (coin <= currAmount) {
                    dp[currAmount] += dp[currAmount-coin];
                }
            }
        }
        return dp[totalAmount];
    }
    public static int coinChange(int[] coins, int amount) {
        // O(N*amount) time | O(N*amount) space
        /**
         * 1. {7, 9, 6}
         * 2. {13, 9}
         * 3. {11, 4, 7}
         * total 3 ways
         */
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        Arrays.fill(dp[0], 0); // Initialize first row with 0
        for (int[] A : dp) A[0] = 1; // Initialize first column with 1

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
