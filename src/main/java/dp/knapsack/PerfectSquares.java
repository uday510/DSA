package dp.knapsack;

/**
 * 
 *  "Rephrased version":
 * 
 *  Given a list of square numbers and a positive integer number n, 
 *  one is asked to find a combination of square numbers that sum up to n, 
 *  and the combination should contain the least numbers among all possible solutions.
 * 
 * 
 */

public class PerfectSquares {

    // Set<Integer> coins;
    // Map<Integer, Integer> dp;
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            dp[i] = (int) 1e9;
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], 1 + (dp[i - j * j]));
            }
        }

        return dp[n];

        // set = new HashSet<>();
        // dp = new HashMap<>();

        // for (int i = 1; i * i <= n; ++i) {
        //     coins.add(i * i);
        // }
        
        // return coinChange(n);
    }

    // private int dfs (int n) {
    //     if (n < 1) return 0;
        
    //     if (dp.containsKey(n)) return dp.get(n);

    //     int min = (int) 1e9;
    //     for (int i = 1; i * i <= n; ++i) {
    //         min = Math.min(min, 1 + dfs(n - i * i));
    //     }

    //     dp.put(n, min);
    //     return min;
    // }

    /**
     * same as coin change problem
     */
    // private int coinChange(int n) {
    //     if (n < 1) return 0;
    //     if (coins.contains(n)) return 1;

    //     if (dp.containsKey(n)) return dp.get(n);

    //     int min = (int) 1e9;
    //     for (var sq : coins) {
    //         if (n - sq >= 0) {
    //             min = Math.min(min, 1 + coinChange(n - sq));
    //         }
    //     }

    //     dp.put(n, min);
    //     return min;
    // }

}