/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 */
package dynamicprogramming;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 51;
        int n = 9;

        Stopwatch stopwatch = Stopwatch.createStarted();

        int res = solve(m, n);
        System.out.println(res);
        stopwatch.stop();

        long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        if (millis > 1) {
            System.out.println("Time Limit Exceeded");
        }
        System.out.println("runTime " + millis + " ms");
    }
    public static int solve(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        return helper(0, 0, m, n, dp);
    }
    public static int helper(int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) return 0;

        if (i == m-1 && j == n-1) return 1;

        if (dp[i][j] != 0) return dp[i][j];

        return dp[i][j] = helper(i+1, j, m, n, dp) + helper(i, j+1, m, n, dp);
    }
}
