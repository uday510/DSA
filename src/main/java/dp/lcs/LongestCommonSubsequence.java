package dp.lcs;

public class LongestCommonSubsequence {

    int n, m;
    String s1, s2;
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        s1 = text1;
        s2 = text2;
        dp = new int[n + 1][m + 1];

//        for (int i = n - 1; i > -1; --i) {
//            for (int j = m - 1; j > -1; --j) {
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    dp[i][j] = 1 + dp[i + 1][j + 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
//                }
//            }
//        }
//
//        return dp[0][0];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 +dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

       return dp[n - 1][m - 1];
    }

    private int dfs(int i, int j) {
        if (i >= n || j >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(dfs(i, j + 1), dfs(i + 1, j));
        }

        return dp[i][j];
    }
}
