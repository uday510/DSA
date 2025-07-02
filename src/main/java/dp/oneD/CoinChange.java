package dp.oneD;

import java.util.Arrays;

public class CoinChange {

    int[] coins;
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int res = dfs(amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs (int rem) {
        if (rem == 0) return 0;
        if (rem < 0) return Integer.MAX_VALUE;

        if (dp[rem] != -1) return dp[rem];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int curr = dfs(rem - coin);
            if (curr != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + curr);
            }
        }

        return dp[rem] = min;
    }

}
