package graph.bellmanford;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = (int) 1e9;
        int[][] dp = new int[k + 2][n];

        // Initialize the DP table
        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] = 0;

        // Relax edges up to k + 1 times (because k stops means k+1 edges max)
        for (int i = 1; i <= k + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j]; // carry over previous bests
            }
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (dp[i - 1][u] != INF) {
                    dp[i][v] = Math.min(dp[i][v], dp[i - 1][u] + w);
                }
            }
        }

        return dp[k + 1][dst] == INF ? -1 : dp[k + 1][dst];
    }
}
