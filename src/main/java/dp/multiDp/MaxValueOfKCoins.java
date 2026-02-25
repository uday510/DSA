package dp.multiDp;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/?envType=study-plan-v2&envId=dynamic-programming
public class MaxValueOfKCoins {

    private List<List<Integer>> piles;
    private int n, k;
    private int[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles = piles;
        n = piles.size();
        this.k = k;
        dp = new int[n][k + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private int dfs(int i, int k1) {
        if (i >= n || k1 >= k) return 0;

        if (dp[i][k1] != -1) {
            return dp[i][k1];
        }

        int p1 = dfs(i + 1, k1);
        int p2 = 0, cur = 0, k2 = k1;
        List<Integer> pile = piles.get(i);

        for (int j = 0; j < pile.size() && k2 < k; j++) {
            cur += pile.get(j);

            p2 = Math.max(p2, cur + dfs(i + 1, ++k2));
        }

        return dp[i][k1] = Math.max(p1, p2);
    }

}
