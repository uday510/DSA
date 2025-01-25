package dynamicprogramming;

import java.util.Arrays;

public class NumberOfPaths {
    public static void main(String[] args) {
        int n = 4;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int res = numOfPathsToDest(0, 0,n-1,dp);
        System.out.println(res);
    }
    public static int numOfPathsToDest(int i, int j, int n, int[][] dp) {
        // your code goes here

        if (i < 0 || j < 0 || i > n || j > n) return 0;

        if (i == n && j == n) return 1;

        if (dp[i][j] != -1) return dp[i][j];


        return dp[i][j] = numOfPathsToDest(i,j+1,n,dp) + numOfPathsToDest(i+1,j,n,dp);
    }
}
