package binarysearch;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    int[][] jobs;
    int[] dp;
    int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        jobs = new int[n][3];
        dp = new int[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = -1;
            jobs[i] = new int[3];
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int skip = dfs(i + 1);
        int take = jobs[i][2] + dfs(bs(i, jobs[i][1]));

        return dp[i] = Math.max(skip, take);
    }

    private int bs(int l, int target) {
        int r = n;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (target > jobs[m][0]) l = m + 1;
            else r = m;
        }

        return l;
    }

// 0 -> [1, 3] ->  20
// 1 -> [2, 5] ->  20
// 2 -> [3, 10] -> 100
// 3 -> [4, 6] ->  70
// 4 -> [6, 9] ->  60

// [[1, 3, 20], [2, 5, 20], [3, 10, 100], [4, 6, 70], [6, 9, 60]]

// end: 3

}
