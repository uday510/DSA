package dynamicprogramming;

import java.util.*;

public class JobScheduling {
     static int[][] jobs;
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        System.out.println(jobScheduling(startTime, endTime, profit));
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

       int n = startTime.length;
       jobs = new int[n][3];

       for (int i = 0; i < n; ++i) {
          jobs[i][0] = startTime[i];
          jobs[i][1] = endTime[i];
          jobs[i][2] = profit[i];
       }

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

       return dfs(0);
    }
    public static int dfs(int i) {
        if (i == jobs.length) return 0;

        int nextIndex = bs(jobs[i][2]);

        int maxProfit = Math.max(dfs(i+1), jobs[i][2] + dfs(nextIndex));

        return maxProfit;
    }
    public static int bs(int et) {
        int left = 0;
        int right = jobs.length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (jobs[mid][0] < et) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
