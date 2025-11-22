package dp;

import java.util.Arrays;

public class MaxProfitWithKTransactions {

    private int maxProfitWithKTransactions(int k, int[] prices) {
        int INF = Integer.MAX_VALUE;
        int[] buy = new int[k + 1];
        int[] profit = new int[k + 1];

        Arrays.fill(buy, INF);

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                // profit[i - 1] ==> profit from previous stock to reinvest
                buy[i] = Math.min(buy[i], price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - buy[i]);
            }
        }

        return profit[k];
    }

}
