package dp.matrix;

public class MinimumPathSum {

    static int numRows;
    static int numCols;
    static int[][] dp;

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int res = minPathSum(grid);
        System.out.println(res);
    }
    private static int minPathSum(int[][] grid) {
       initialize(grid);

        for (int currRow = 0; currRow < numRows; ++currRow) {
            for (int currCol = 0; currCol < numCols; ++currCol) {
                dp[currRow][currCol] = grid[currRow][currCol] + getMin(currRow, currCol);
            }
        }

        return dp[numRows - 1][numCols - 1];
    }

    private static int getMin(int row, int col) {
        int curr = 0;
        if (row > 0 && col > 0) {
            curr = Math.min(dp[row - 1][col], dp[row][col - 1]);
        } else if (row > 0) {
            curr = dp[row - 1][col];
        } else if (col > 0) {
            curr = dp[row][col - 1];
        }

        return curr;
    }

    private static void initialize(int[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        dp = new int[numRows][numCols];
    }

    public int minPathSumV1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = grid[i][j];

                if (i > 0 && j > 0)
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);

                else if (i > 0) dp[i][j] += dp[i - 1][j];
                else if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
