package dp;

import dp.stocks.BestTimeToBuyAndSellStockK;

public class MaxProfitWithKTransactions {

    private int maxProfitWithKTransactions(int k, int[] prices) {
       return new BestTimeToBuyAndSellStockK().maxProfitWithKTransactions(prices, k);
    }

}
