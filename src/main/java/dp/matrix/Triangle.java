package dp.matrix;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    int[][] dp;
    int m;

    public int minimumTotal(List<List<Integer>> triangle) {
        m = triangle.size();
        dp = new int[m][m];

        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(0, 0, triangle);
    }

    private int dfs(int i, int j, List<List<Integer>> triangle) {
        if (i >= m || j >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int curr = triangle.get(i).get(j);
        return dp[i][j] = curr + Math.min(dfs(i + 1, j, triangle), dfs(i + 1, j + 1, triangle));
    }
}
