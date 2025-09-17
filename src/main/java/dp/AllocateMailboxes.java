package dp;

import java.util.Arrays;

public class AllocateMailboxes {

    int[][] cost, dp;
    int[] H;
    int n;

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        H = houses;
        n = H.length;

        cost = new int[n][n];
        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = (i + j) >> 1;
                for (int t = i; t <= j; t++) {
                    cost[i][j] += Math.abs(H[t] - H[m]);
                }
            }
        }

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, k);
    }

    private int dfs(int i, int k) {
        if (i >= n) return 0;
        if (k == 0) return (int) 1e9;

        if (dp[i][k] != -1) return dp[i][k];

        int min = (int) 1e9;

        for (int j = i; j < n; j++) {
            min = Math.min(min, cost[i][j] + dfs(j + 1, k - 1));
        }

        return dp[i][k] = min;
    }

}
