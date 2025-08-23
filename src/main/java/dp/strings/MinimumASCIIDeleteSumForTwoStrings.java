package dp.strings;

import java.util.Arrays;

public class MinimumASCIIDeleteSumForTwoStrings {

    String s1;
    String s2;
    int m, n;
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        m = s1.length();
        n = s2.length();
        dp = new int[m][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }
    private int dfs(int i, int j) {
        if (i >= m && j >= n) return 0;
        if (i >= m) return asciiSum(s2, j);
        if (j >= n) return asciiSum(s1, i);

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = dfs(i + 1, j + 1);

        return dp[i][j] = Math.min(
                s1.charAt(i) + dfs(i + 1, j),
                s2.charAt(j) + dfs(i, j + 1)
        );
    }

    private int asciiSum(String s, int idx) {
        int sum = 0;
        while (idx < s.length()) sum += s.charAt(idx++);
        return sum;
    }

}
