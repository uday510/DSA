package dp.knapsack;


import java.util.Arrays;

public class CoinChange2 {

    int[] dp;
    int INF = 0x7ffffff;

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(n);
    }

    private int dfs (int rem) {
        if (rem < 0) return INF;
        if (rem == 0) return 0;

        if (dp[rem] != -1) return dp[rem];

        int min = INF;
        for (int i = 1; i * i <= rem; ++i) {
            int next = dfs(rem - i * i);
            if (next != INF) min = Math.min(min, 1 + next);
        }

        return dp[rem] = min;
    }

}
