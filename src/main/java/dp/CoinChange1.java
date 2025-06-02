/**
 * ou are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
package dp;

import java.util.Arrays;

public class CoinChange1 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(dfs(coins, amount));
    }
    public static int dfs(int[] coins, int amount) {
        int max = amount + 1; // because Integer.MAX_VALUE will overflow.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static int solve(int[] coins, int amount) {
        int n =  coins.length;
        Long[][] dp = new Long[n+1][amount+1];

        long val = coinChange(coins, amount, coins.length - 1, dp);

        if (val < 0 || val >= Integer.MAX_VALUE) return -1;
        return (int) val;
    }
    public static long coinChange(int[] coins, int currAmount, int n, Long[][] dp) {
        if (currAmount < 0) return (long) 1e12;

        if (currAmount == 0) return 0;

        if (n < 0) return (long) 1e12;

        if (dp[n][currAmount] != null) return dp[n][currAmount];

        if (coins[n] > currAmount) return coinChange(coins, currAmount, n - 1, dp);

        dp[n][currAmount] =  Math.min(1 + coinChange(coins, currAmount - coins[n], n, dp),
                coinChange(coins, currAmount, n - 1, dp));

        return dp[n][currAmount];
    }
}
