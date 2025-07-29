package dp.knapsack;

import java.util.Arrays;

public class OnesAndZeroes {

    int[][] arr;
    int len;
    int m;
    int n;
    int[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
        len = strs.length;
        arr = new int[len][2];
        this.m = m;
        this.n = n;
        dp = new int[len][m + 1][n + 1];

        for (int[][] twoD : dp) {
            for (int[] oneD : twoD) Arrays.fill(oneD, -1);
        }

        for (int i = 0; i < len; ++i) {
            arr[i] = new int[2];
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') arr[i][0]++;
                else arr[i][1]++;
            }
        }

        return dfs(0, 0, 0);
    }

    private int dfs(int i, int zeros, int ones) {
        if (i >= len) return 0;

        if (dp[i][zeros][ones] != -1) return dp[i][zeros][ones];

        int exc = dfs(i + 1, zeros, ones);

        int inc = 0;

        if (zeros + arr[i][0] <= m && ones + arr[i][1] <= n) {
            inc = 1 + dfs(i + 1, zeros + arr[i][0], ones + arr[i][1]);
        }


        return dp[i][zeros][ones] = Math.max(exc, inc);
    }

}
