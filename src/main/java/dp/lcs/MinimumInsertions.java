package dp.lcs;

import java.util.Arrays;

public class MinimumInsertions {

    int[][] dp;
    String s;
    int n;

    public int minInsertions(String s) {
        n = s.length();
        this.s = s;
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dfs(i + 1, j - 1);
        } else {
            dp[i][j] = 1 + Math.min(dfs(i + 1, j), dfs(i, j - 1));
        }

        return dp[i][j];
    }
}
