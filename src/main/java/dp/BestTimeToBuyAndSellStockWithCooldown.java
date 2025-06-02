package dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    int[] dp;
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0, prices);
    }

    private int dfs(int i, int[] prices) {
        if (i >= prices.length) return 0;

        if (dp[i] != -1) return dp[i];
        int min = prices[i];
        int max = 0;

        for (int idx = i; idx < prices.length; ++idx) {
            min = Math.min(min, prices[idx]);
            max = Math.max(max, prices[idx] - min + dfs(idx + 2, prices));
        }

        return dp[i] = max;
    }
}
