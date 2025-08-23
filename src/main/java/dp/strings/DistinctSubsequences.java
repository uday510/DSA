package dp.strings;

import java.util.Arrays;

public class DistinctSubsequences {

    int m, n;
    String s, t;
    int[][] dp;

    public int numDistinct(String s, String t) {
        m = s.length(); n = t.length();
        this.s = s;
        this.t = t;
        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        // if (i >= m && j >= n) return 1;
        if (j >= n) return 1;
        if (i >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(i + 1, j) + dfs(i + 1, j + 1);
        } else {
            dp[i][j] = dfs(i + 1, j);
        }

        return dp[i][j];
    }

}
