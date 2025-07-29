package dp.multidimensional;

public class PaintHouse {

    int[][] costs;
    int[][] dp;
    int n;

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] memo = new int[n + 1][3];

        for (int i = n - 1; i > -1; --i) {
            memo[i][0] = costs[i][0] + Math.min(memo[i + 1][1], memo[i + 1][2]);
            memo[i][1] = costs[i][1] + Math.min(memo[i + 1][0], memo[i + 1][2]);
            memo[i][2] = costs[i][2] + Math.min(memo[i + 1][0], memo[i + 1][1]);
        }

        return Math.min(memo[0][0], Math.min(memo[0][1], memo[0][2]));
    }

    private int dfs(int i, int color) {
        if (i >= n) return 0;

        if (dp[i][color] != -1) return dp[i][color];

        int curr = (int) 1e9;

        if (color == 0) {
            curr = Math.min(dfs(i + 1, 1), dfs(i + 1, 2));
        } else if (color == 1) {
            curr = Math.min(dfs(i + 1, 0), dfs(i + 1, 2));
        } else if (color == 2) {
            curr = Math.min(dfs(i + 1, 0), dfs(i + 1, 1));
        }

        curr += costs[i][color];

        return dp[i][color] = curr;
    }
}
