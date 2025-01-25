/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Note: we can't use same coin twice
 * Example 1:
 *
 */
package dynamicprogramming;
import java.util.Arrays;

public class CoinChange0 {
    public static void main(String[] args) {
        int[] coins = {7, 4, 9, 6, 10, 13, 14, 11};
        int amount = 22;

//        int res = optimized(coins, amount);
//        System.out.println(res);
//        System.out.println(coinChange(coins, amount));
    }
    public static int optimized(int[] coins, int amount) {
        // Induction rule: dp[i] = min(dp[i], dp[i - coin] + 1)
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
    public int coinChange(int[] coins, int remain, Integer[] memo) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;

        if (memo[remain] != null) return memo[remain];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = coinChange(coins, remain - coin, memo);
            if (count >= 0 && count < min) {
                min = count + 1;
            }
        }
        return memo[remain] = (min == Integer.MAX_VALUE) ? -1 : min;
    }
    public int bruteForce(int[] coins, int amount) {
        if (amount < 1) return -1;
        if (amount == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = bruteForce(coins, amount - coin);
            if (count >= 0 && count < min) {
                min = count + 1;
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
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
            for (int j = amount; j >= 1; --j) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
