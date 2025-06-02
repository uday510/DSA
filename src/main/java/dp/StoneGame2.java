package dp;

public class StoneGame2 {
    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        System.out.println(stoneGame2(piles));
    }
    public static int stoneGame2(int[] piles) {
        int n = piles.length;
        int[] pf = new int[n];
        pf[0] = piles[0];

        for (int i = 1; i < n; ++i) {
            pf[i] = pf[i - 1] + piles[i];
        }

        int[][] dp = new int[n][n];

        return dfs(piles, pf, dp, 0, 1);
    }
    public static int dfs(int[] piles, int[] prefixSum, int[][] dp, int i, int m) {
        if (i >= piles.length) {
            return 0;
        }
        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        int res = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; ++x) {
            if (i + x - 1 >= piles.length) {
                break;
            }
            int sum = prefixSum[i + x - 1] - (i == 0 ? 0 : prefixSum[i - 1]);
            res = Math.min(res, sum + prefixSum[piles.length - 1] - prefixSum[i + x - 1] - dfs(piles, prefixSum, dp, i + x, Math.max(m, x)));
        }
        return dp[i][m] = res;
    }
}
