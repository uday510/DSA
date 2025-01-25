package dynamicprogramming;

public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = {{-3, 2, 4, -5},
                           {-6, 5, -4, 6},
                           {-15, -7, 5, -2},
                           {2, 10, -3, -4} };

        int res = solve(dungeon);
        System.out.println(res);
    }
    public static int solve(int[][] dungeon) {
        return calculateMinimumHP(dungeon);
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];
        if (dungeon[n-1][m-1] >= 0) {
            dp[n-1][m-1] = dungeon[n-1][m-1] + 1;
        } else {
            dp[n-1][m-1] = Math.abs(dungeon[n-1][m-1]) + 1;
        }

        // fill the last row
        for (int j = m-2; j > -1; --j) {
            /**
             * x + dungeon[n-1][j] = dp[n-1][j+1]
             * x = dp[n-1][j+1] - dungeon[n-1][j]
             */
            dp[n-1][j] = Math.max(1, dp[n-1][j+1] - dungeon[n-1][j]);
        }
        // fill the last col
        for (int i = n-2; i > -1; --i) {
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - dungeon[i][m-1]);
        }


        for (int i = n - 2; i > -1; --i) {
            for (int j = m - 2; j > -1; --j) {
                int x = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
                dp[i][j] = x;
            }
        }
        return dp[0][0];
    }
}
