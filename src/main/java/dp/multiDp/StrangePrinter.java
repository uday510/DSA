package dp.multiDp;

import java.util.Arrays;

public class StrangePrinter {

    private int[][] dp;
    private String s;

    public int strangePrinter(String s) {
        this.s = removeDuplicates(s);
        int n = this.s.length();

        this.dp = new int[n][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, n - 1);
    }

    private int dfs(int st, int en) {
        if (st > en) return 0;
        if (st == en) return 1;

        if (dp[st][en] != -1) return dp[st][en];

        int cur = 1 + dfs(st + 1, en);

        for (int i = st + 1; i <= en; i++) {

            if (s.charAt(st) == s.charAt(i)) {

                cur = Math.min(cur,
                        dfs(st + 1, i - 1) + dfs(i, en)
                );
            }
        }

        return dp[st][en] = cur;
    }

    private String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length();) {
            sb.append(s.charAt(i));

            char ch = s.charAt(i);
            while (i < s.length() && s.charAt(i) == ch) {
                i++;
            }
        }

        return sb.toString();
    }
}
