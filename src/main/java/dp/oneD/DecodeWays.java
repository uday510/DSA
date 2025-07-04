package dp.oneD;

import java.util.Arrays;

public class DecodeWays {

    String s;
    int[] dp;
    public int numDecodings(String s) {
        this.s = s;
        dp = new int[100];
        Arrays.fill(dp, -1);
        return dfs(0);
    }

    private int dfs(int idx) {
        if (idx >= s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (idx == s.length() - 1) return 1;

        if (dp[idx] != -1) return dp[idx];

        int res = dfs(idx + 1);
        if (Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
            res += dfs(idx + 2);
        }

        return dp[idx] = res;
    }

}
