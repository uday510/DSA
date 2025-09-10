package dp.oneD;

public class DecodeWays {

    int[] dp;
    int n;
    int[] nums;

    public int numDecodings(String s) {
        n = s.length();
        nums = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
            dp[i] = -1;
        }

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 1;

        if (nums[i] == 0) return 0;

        if (dp[i] != -1) return dp[i];

        int t1 = dfs(i + 1);
        int t2 = 0;

        if (i + 1 < n && nums[i] * 10 + nums[i + 1] <= 26) t2 = dfs(i + 2);

        return dp[i] = t1 + t2;
    }

}
