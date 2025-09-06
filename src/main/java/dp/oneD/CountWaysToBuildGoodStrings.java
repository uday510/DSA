package dp.oneD;

import java.util.Arrays;

public class CountWaysToBuildGoodStrings {

    int l, h, z, o;
    static int MOD = (int) 1e9 + 7;
    int[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        l = low; h = high; z = zero; o = one;
        dp = new int[h + 1];
        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int i) {
        if (i > h) return 0;

        if (dp[i] != -1) return dp[i];

        int cnt = i >= l ? 1 : 0;

        cnt = (cnt + dfs(i + z)) % MOD;
        cnt = (cnt + dfs(i + o)) % MOD;

        return dp[i] = cnt;
    }

}
