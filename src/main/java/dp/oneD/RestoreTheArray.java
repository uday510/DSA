package dp.oneD;

import java.util.Arrays;

public class RestoreTheArray {

    private String s;
    private int k, n;
    private final int MOD = (int) 1e9 + 7;
    private int[] dp;

    public int numberOfArrays(String s, int k) {
        this.s = s;
        this.k = k;
        this.n = s.length();
        dp = new int[n];

        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 1;

        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        long cur = 0;
        int ways = 0;
        for (int j = i; j < n; j++) {
            cur = cur * 10 + (s.charAt(j) - '0');

            if (cur > k) break;
            ways = (ways + dfs(j + 1)) % MOD;
        }

        return dp[i] = ways;
    }


}
