package dp.stocks;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int minLeft = prices[0];
        int maxRight = prices[len - 1];
        int[] left = new int[len];
        int[] right = new int[len + 1];

        for (int idx = 1; idx < len; ++idx) {
            left[idx] = Math.max(prices[idx] - minLeft, left[idx - 1]);
            minLeft = Math.min(prices[idx], minLeft);

            int r = len - idx - 1;
            right[r] = Math.max(right[r + 1], maxRight - prices[r]);
            maxRight = Math.max(prices[r], maxRight);
        }


        int maxProfit = 0;
        for (int idx = 0; idx < len; ++idx) {
            maxProfit = Math.max(maxProfit, left[idx] + right[idx + 1]);
        }

        return maxProfit;
    }
}
