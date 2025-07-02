package dp.oneD;

// https://leetcode.com/problems/solving-questions-with-brainpowe

import java.util.Arrays;

public class BrainPower {

    long[] dp;
    int[][] ques;

    public long mostPoints(int[][] ques) {
        int n = ques.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i > -1; --i) {
            int points = ques[i][0];
            int skip = ques[i][1];
            int skipIdx = i + skip + 1;

            long inc = points + (skipIdx < n ? dp[skipIdx] : 0);
            long exc = dp[i + 1];

            dp[i] = Math.max(inc, exc);
        }

        return dp[0];
    }

    public long mostPoints2(int[][] questions) {
        ques = questions;
        dp = new long[questions.length];
        Arrays.fill(dp, -1L);

        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= ques.length) return 0L;

        if (dp[i] != -1L) return dp[i];

        long exc = dfs(i + 1);

        long inc = (long) ques[i][0] + dfs(i + ques[i][1] + 1);

        return dp[i] = (long) Math.max(inc, exc);
    }

}
