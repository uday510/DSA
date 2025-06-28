package dp.lis;

public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
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
