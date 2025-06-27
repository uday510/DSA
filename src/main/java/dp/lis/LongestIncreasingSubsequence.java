package dp.lis;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    int n;
    // int[][] dp;
    List<Integer> lis;

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        lis = new ArrayList<>();

        for (int idx = 0; idx < n; ++idx) {
            int index = bisectLeft(nums[idx]);
            if (index == lis.size()) lis.add(nums[idx]);
            lis.set(index, nums[idx]);
        }
        return lis.size();
        // dp = new int[n + 1][n];
        // for (int[] row : dp) Arrays.fill(row, -1);

        // return dfs(-1, 0, nums.length, nums);

        // int[] dp = new int[n];
        // int longest = 1;
        // for (int j = 0; j < n; ++j) {
        //     dp[j] = 1;
        //     for (int i = 0; i < j; ++i) {
        //         if (nums[i] < nums[j]) {
        //             dp[j] = Math.max(dp[i] + 1, dp[j]);
        //         }
        //     }
        //     longest = Math.max(dp[j], longest);
        // }

        // return longest;
    }

    private int bisectLeft(int target) {
        int leftIdx = 0, rightIdx = lis.size();

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >> 1;
            if (lis.get(midIdx) < target) leftIdx = midIdx + 1;
            else rightIdx = midIdx;
        }

        return leftIdx;
    }
    // private int dfs(int i, int j, int n, int[] nums) {
    //     if (j >= n) return 0;

    //     if (dp[i + 1][j] != -1) return dp[i + 1][j];

    //     int skip = dfs(i, j + 1, n, nums);

    //     int take = 0;

    //     if (i == -1 || nums[i] < nums[j]) {
    //         take = 1 + dfs(j, j + 1, n, nums);
    //     }


    //     return dp[i + 1][j] = Math.max(skip, take);
    // }
}