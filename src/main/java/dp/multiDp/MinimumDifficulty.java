package dp.multiDp;


// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/?envType=study-plan-v2&envId=dynamic-programming-grandmaster

import java.util.Arrays;

public class MinimumDifficulty {

    private int[] difficulty;
    private int totalDays, n;
    private static final int INF = (int) 1e9;
    private int[][] dp;

    public int minDifficulty(int[] jobDifficulty, int d) {
        difficulty = jobDifficulty;
        this.totalDays = d;
        this.n = difficulty.length;
        this.dp = new int[n + 1][d + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        int res = dfs(0, 0);
        return res == INF ? -1 : res;
    }

    private int dfs(int i, int curDays) {
        if (curDays == totalDays) {
            return max(i);
        }

        if (dp[i][curDays] != -1) {
            return dp[i][curDays];
        }

        int mx = 0;
        int cur = (int) 1e9;

        for (int j = i; j < n; j++) {
            mx = Math.max(mx, difficulty[j]);

            cur = Math.min(cur, mx + dfs(j + 1, curDays + 1));
        }

        return dp[i][curDays] = cur;
    }

    private int max(int i) {
        int mx = 0;
        for (; i < n; i++) {
            mx = Math.max(mx, difficulty[i]);
        }

        return mx;
    }
}