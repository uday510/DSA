package dp;

import java.util.Arrays;

public class JobScheduling {

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

//        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    int[] dp;
    int[][] jobs;
    int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        this.n = profit.length;
        jobs = new int[n][3];
        dp = new int[n];

        Arrays.fill(dp, -1);

        for (int i = 0; i < n; ++i) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        return dfs(0);
    }

    private int dfs(int idx) {
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int skip = dfs(idx + 1);
        int take = jobs[idx][2] + dfs(bs(jobs[idx][1]));

        return dp[idx] = Math.max(skip, take);
    }

    private int bs(int end) {
        // start has to >= end
        int left = 0, right = n;

        while (left < right) {
            int mid = (left + right) >> 1;

            int start = jobs[mid][0];
            if (end > start) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
