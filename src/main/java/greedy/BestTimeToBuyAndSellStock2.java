package greedy;

import org.jetbrains.annotations.NotNull;

public class BestTimeToBuyAndSellStock2 {

    int[] prices;
    int n;

    public int maxProfit(int @NotNull [] prices) {
        this.prices = prices;
        n = prices.length;

//        return dfs(0);

        int profit = 0;

        for (int idx = 1; idx < prices.length; ++idx) {
            profit += Math.max(0, prices[idx] - prices[idx - 1]);
        }

        return profit;
    }

    // O(2^n) time | O(n) space
    private int dfs(int idx) {

        int max = 0;

        for (int i = idx; i < n; ++i) {
            int curr = prices[i] - prices[idx] + dfs(i + 1);
            max = Math.max(max, curr);
        }

        return max;
    }

}
