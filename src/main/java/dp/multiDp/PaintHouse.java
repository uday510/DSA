package dp.multiDp;


import java.util.Arrays;

// https://leetcode.com/problems/paint-house/description/?envType=study-plan-v2&envId=dynamic-programming
public class PaintHouse {

    private int[][] costs, dp;
    private int n, k;

    public int minCost_(int[][] costs) {

        this.costs = costs;
        n = costs.length;
        k = costs[0].length;
        dp = new int[n][k + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, -1);
    }

    private int dfs(int i, int exc) {

        if (i >= n) return 0;

        if (dp[i][exc + 1] != -1) return dp[i][exc + 1];

        int cur = (int) 1e9;

        for (int j = 0; j < k; j++) {
            if (j == exc) continue;

            cur = Math.min(cur, costs[i][j] + dfs(i + 1, j));
        }

        return dp[i][exc + 1] = cur;
    }

    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;

        int n = costs.length;

        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][2], costs[i - 1][0]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }

}
