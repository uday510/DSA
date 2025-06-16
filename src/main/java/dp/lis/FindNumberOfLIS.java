package dp.lis;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) dp[i] = cnt[i] = 1;
        int longest = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    cnt[i] = cnt[j];
                    if (dp[j] == dp[i]) cnt[i] += 1;
                }
            }
            longest = Math.max(longest, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == longest) ans = cnt[i];
        }

        return ans;
    }
}
