package dp.lis;

class Pair {
    int len;
    int cnt;

    Pair(int len, int cnt) { this.len = len; this.cnt = cnt; }
}

public class FindNumberOfLIS {

    Pair[][] dp;
    int n;
    int[] nums;

    public int findNumberOfLIS(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new Pair[n + 1][n];

        return dfs(-1, 0).cnt;
    }

    private Pair dfs(int i, int j) {
        if (j >= n) return new Pair(0, 1);

        if (dp[i + 1][j] != null) return dp[i + 1][j];

        Pair skip = dfs(i, j + 1);
        int len = skip.len;
        int cnt = skip.cnt;

        if (i == -1 || nums[i] < nums[j]) {

            Pair take = dfs(j, j + 1);
            int tLen = 1 + take.len;
            int tCnt = take.cnt;

            if (tLen > len) {
                len = tLen;
                cnt = tCnt;
            } else if (tLen == len) cnt += tCnt;
        }

        return dp[i + 1][j] = new Pair(len, cnt);
    }

    public int findNumberOfLISBottomUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int longest = 1;

        for (int i = 0; i < n; ++i) {
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            longest = Math.max(longest, dp[i]);
        }

        int total = 0;
        for (int i = 0; i < n; ++i) {
            total += (dp[i] == longest ? cnt[i] : 0);
        }

        return total;
    }

}
