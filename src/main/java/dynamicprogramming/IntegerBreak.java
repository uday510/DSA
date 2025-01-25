package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IntegerBreak {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(integerBreak(n));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];

        return integerBreak(n, dp);
    }
    public static int integerBreak(int n, int[] dp) {
        if  (dp[n] != 0) {
            return dp[n];
        }

        int res = n;

        for (int i = 2; i <= n; ++i) {
            res = Math.max(res, i * integerBreak(n-i));
            System.out.println(res);
        }
        dp[n] = res;


        return res;
    }
}
