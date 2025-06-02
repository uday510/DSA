package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        solve(n);
    }
    public static void solve(int n) {

//        getNthFibonacciUsingTopDown(n);
        getNthFibonacciUsingBottomUp(n);
    }
    public static void getNthFibonacciUsingBottomUp(int n) {
        // Tabulation
        int[] table = new int[n+1];

        bottomUpHelper2(n);
    }
    public static void bottomUpHelper2(int n) {
        int a = 0, b = 1;
        for (int i = 2; i <= n; ++i) {
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
    }
    public static void bottomUpHelper1(int n, int[] table) {
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; ++i) {
            table[i] = table[i-1] + table[i-2];
        }
        System.out.println(table[n]);
    }

    public static void getNthFibonacciUsingTopDown(int n) {
        // memoization
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        topDownHelper(n, dp);
        System.out.println(dp[n]);
    }
    public static int topDownHelper(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != 0) return dp[n];

        dp[n] = topDownHelper(n-1 , dp) + topDownHelper(n-2, dp);
        return dp[n];
    }
    static Map<Integer, Integer> cache = new HashMap<>();

    public static int getFib(int n) {
       if (cache.containsKey(n)) {
           return cache.get(n);
       }
       int result;
       if (n < 2) {
           result = 2;
       } else {
           result = getFib(n-1) + getFib(n-2);
       }
       cache.put(n, result);

       return result;
    }
}
