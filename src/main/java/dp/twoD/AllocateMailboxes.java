package dp.twoD;

import java.util.Arrays;

public class AllocateMailboxes {

    private int n;
    private int[][] dp, arr;

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        n = houses.length;
        arr = new int[n][n];
        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int  m = (i + j) >> 1;

                for (int t = i; t <= j; t++) {
                    arr[i][j] += Math.abs(houses[m] - houses[t]);
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
            min = Math.min(min, arr[i][j] + dfs(j + 1, k - 1));
        }

        return dp[i][k] = min;
    }

}
