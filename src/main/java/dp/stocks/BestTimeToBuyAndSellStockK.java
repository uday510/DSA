package dp.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockK {

    public int maxProfit(int[] prices, int k) {

        return maxProfitWithKTransactions(prices, k);
    }

    public int maxProfitWithKTransactions(int[] prices, int k) {

        int[] profit = new int[k + 1];
        int[] buy = new int[k + 1];

        Arrays.fill(buy, (int) 1e9);

        for (int price : prices) {

           for (int i = 1; i <= k; i++) {
               buy[i] = Math.min(buy[i], price - profit[i - 1]);
               profit[i] = Math.max(profit[i], price - buy[i]);
           }

        }
        return profit[k];
    }

}
