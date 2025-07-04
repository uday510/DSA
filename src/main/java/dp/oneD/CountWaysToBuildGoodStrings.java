package dp.oneD;

import java.util.Arrays;

public class CountWaysToBuildGoodStrings {

    int[] dp;
    int MOD = 1_000_000_007;
    int low, high, zero, one;

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;

        dp = new int[high + 1];
        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int lengthSoFar) {
        if (lengthSoFar > high) return 0;
        if (dp[lengthSoFar] != -1) return dp[lengthSoFar];

        int ways = (lengthSoFar >= low) ? 1 : 0;

        ways = (ways + dfs(lengthSoFar + zero)) % MOD;
        ways = (ways + dfs(lengthSoFar + one)) % MOD;

        return dp[lengthSoFar] = ways;
    }

}
