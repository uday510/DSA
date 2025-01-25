package dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/painting-the-walls/description/?envType=daily-question&envId=2023-10-14
public class PaintingWalls {

    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 2};
        int[] time = {1, 2, 3, 2};

        System.out.println(paintWalls(cost, time));

    }
    public static int paintWalls(int[] cost, int[] time) {

        Integer[][] dp = new Integer[cost.length][cost.length];

        return dfs(0, 0, cost.length, cost, time, dp);
    }
    public static int dfs(int idx, int elapsed, int N, int[] cost, int[] time, Integer[][] dp) {
        if (elapsed >= N) return 0;

        if (idx >= N) return (int) 1e9;

        if (dp[idx][elapsed] != null) return dp[idx][elapsed];
        int newElapsed = elapsed + time[idx] + 1;

        int take = cost[idx] + dfs(idx + 1, newElapsed, N, cost, time, dp);
        int dont = dfs(idx + 1, elapsed, N, cost, time, dp);

        return dp[idx][elapsed] = Math.min(take, dont);
    }

}
