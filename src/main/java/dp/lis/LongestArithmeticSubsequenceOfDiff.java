package dp.lis;

public class LongestArithmeticSubsequenceOfDiff {

    public int longestSubsequence(int[] arr, int difference) {
        int offset = 20_000;
        int[] dp = new int[40_001];
        int longest = 0;

        for (int x : arr) {
            int prevIdx = x - difference + offset;
            int currIdx = x + offset;

            dp[currIdx] = dp[prevIdx] + 1;
            longest = Math.max(longest, dp[currIdx]);
        }

        return longest;
    }
}
