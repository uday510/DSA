package dp.oneD;

import java.util.Arrays;

public class DecodeWays2 {

    String s;
    int n, mod;
    int[] dp;

    public int numDecodings(String s) {
        this.s = s;
        n = s.length();
        mod = (int) 1e9 + 7;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 1;

        char ch1 = s.charAt(i);

        int cnt = 0;
        if (ch1 == '*') {
            cnt = (9 + dfs(i + 1)) % mod;
        }

        if (i + 1 < n) {
            char ch2 = s.charAt(i + 1);

            if (ch1 == '*' && ch2 == '*') {
                cnt = (15 * dfs(i + 2)) % mod;
            } else if (ch1 == '*') {
                if (ch2 >= '1')
            }
        }




        return dp[i] = cnt;
    }

}
