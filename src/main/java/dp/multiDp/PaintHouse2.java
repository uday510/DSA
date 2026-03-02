package dp.multiDp;

import java.util.Arrays;

public class PaintHouse2 {

    private int[][] costs, dp;
    private int n, k;

    public int minCostII(int[][] costs) {
        this.costs = costs;
        this.n = costs.length;
        this.k = costs[0].length;
        this.dp = new int[n][k + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, -1);
    }

    private int dfs(int i, int x) {
        if (i >= n || x >= k) return 0;

        if (dp[i][x + 1] != -1) {
            return dp[i][x + 1];
        }

        int cur = (int) 1e9;
        for (int j = 0; j < k; j++) {

            if (x == j) continue;
            cur = Math.min(cur, costs[i][j] + dfs(i + 1, j));
        }

        return dp[i][x + 1] = cur;
    }

}
