/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */
package dynamicprogramming;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        /**
         * The idea is to buy the stock at the lowest price and sell it at the highest price.
         * We can hold at most one share of the stock at any time.
         * So, we can buy the stock at the lowest price and sell it at the highest price.
         * We can buy it then immediately sell it on the same day.
         */

        /**
         * BRUTE FORCE APPROACH
         * We can use two loops to find the maximum profit.
         * The first loop will iterate over the prices array and the second loop will iterate from the current index of the first loop to the end of the prices array.
         */
        int maxProfit = 0;


        /**
         * OPTIMAL APPROACH
         * We can find the maximum profit by iterating over the prices array only once.
         * We can buy the stock at the lowest price and sell it at the highest price.
         * We can buy it then immediately sell it on the same day.
         */
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
//        return maxProfit;

        maxProfit = 0;

        /**
         * DYNAMIC PROGRAMMING APPROACH
         * We can find the maximum profit by using dynamic programming.
         *
         * We can create a dp array of size n, where n is the length of the prices array.
         * The dp array will store the maximum profit that can be achieved by buying and selling the stock on the ith day.
         *
         * The dp array will be initialized with 0.
         *
         * We can iterate over the prices array and update the dp array.
         */

        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            // If the price of the stock on the ith day is greater than the price of the stock on the (i-1)th day, then we can buy the stock on the (i-1)th day and sell it on the ith day.
            // The profit that can be achieved by buying and selling the stock on the ith day is the difference between the price of the stock on the ith day and the price of the stock on the (i-1)th day.
            // The maximum profit that can be achieved by buying and selling the stock on the ith day is the maximum of the following two values:
            // 1. The maximum profit that can be achieved by buying and selling the stock on the (i-1)th day.
            // 2. The maximum profit that can be achieved by buying and selling the stock on the (i-1)th day plus the profit that can be achieved by buying and selling the stock on the ith day.
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        return dp[n - 1];
    }

    private int dfs(int i, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        int maxProfit = 0;

        for (int j = i; j < prices.length; ++j) {

            if (prices[j] > prices[i]) {
                int profit = prices[j] - prices[i] + dfs(j + 1, prices);
                maxProfit = Math.max(maxProfit, profit);
            }

        }

        maxProfit = Math.max(maxProfit, dfs(i + 1, prices));

        return maxProfit;
    }
}
