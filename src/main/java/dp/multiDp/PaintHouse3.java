package dp.multiDp;

import java.util.Arrays;

public class PaintHouse3 {


    private int[] H;
    private int[][] C;
    private int[][][] dp;
    private int m, t;
    private static final int INF = (int) 1e9;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        H = houses;
        C = cost;
        this.m = m;
        this.t = target;
        dp = new int[m][n + 1][t + 1];

        for (int[][] twoD : dp) {
            for (int[] row : twoD) {
                Arrays.fill(row, -1);
            }
        }

        int res = dfs(0, 0, 0);

        return res == INF ? - 1 : res;
    }

    private int dfs(int idx, int prevColor, int neighbors) {
        if (idx == m) {
            return neighbors == t ? 0 : INF;
        }

        if (neighbors > t) return INF;

        if (dp[idx][prevColor][neighbors] != -1) {
            return dp[idx][prevColor][neighbors];
        }

        int min = INF, c, curNeighbors;

        if (H[idx] != 0) {
            c = H[idx];
            curNeighbors = neighbors + (c != prevColor ? 1 : 0);

            return dp[idx][prevColor][neighbors] = dfs(idx + 1, c, curNeighbors);
        }

        for (int j = 0; j < C[idx].length; j++) {
            c = j + 1;
            curNeighbors = neighbors + (c != prevColor ? 1 : 0);
            int nxt = dfs(idx + 1, c, curNeighbors);

            if (nxt != INF)
                min = Math.min(min, C[idx][j] + nxt);
        }

        return dp[idx][prevColor][neighbors] = min;
    }

}
