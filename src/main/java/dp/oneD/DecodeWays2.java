package dp.oneD;

import java.util.Arrays;

public class DecodeWays2 {

    class Solution {

        private String s;
        private int n;
        private long[] dp;
        private final int MOD = (int) 1e9 + 7;

        public int numDecodings(String s) {
            this.s = s;
            n = s.length();
            dp = new long[n];
            Arrays.fill(dp, -1);

            return (int) dfs(0);
        }

        private long dfs(int i) {
            if (i >= n) return 1;

            if (dp[i] != -1) return dp[i];

            char c1 = s.charAt(i);
            char c2 = i + 1 < n ? s.charAt(i + 1) : '#';

            long cnt = 0;

            if (c1 == '*') cnt = 9 * dfs(i + 1) % MOD;
            else if (c1 >= '1') cnt = dfs(i + 1) % MOD;

            if (c2 == '#') return dp[i] = cnt;

            if (c1 == '*') {
                if (c2 == '*') cnt += 15 * dfs(i + 2) % MOD;
                else if (c2 >= '0' && c2 <= '6') cnt += 2 * dfs(i + 2) % MOD;
                else cnt += dfs(i + 2) % MOD;
            } else if (c1 == '1') {
                if (c2 == '*') cnt += 9 * dfs(i + 2) % MOD;
                else cnt += dfs(i + 2) % MOD;
            } else if (c1 == '2') {
                if (c2 == '*') cnt += 6 * dfs(i + 2) % MOD;
                else if (c2 >= '0' && c2 <= '6') cnt += dfs(i + 2) % MOD;
            }

            return dp[i] = cnt % MOD;
        }
    }

}
