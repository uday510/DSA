// Return total number of palindromic substrings in a string

package dynamicprogramming;

import java.util.Arrays;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "abac";
        boolean[][] dp = countSubstrings(s);
        for (boolean[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static boolean[][] countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int gap = 0; gap < n; ++gap) {
            int start = 0;
            int end = gap;
            while (end < n) {
                if (gap == 0) { // single character
                    dp[start][end] = true;
                } else if (gap == 1) { // two characters
                    boolean b = s.charAt(start) == s.charAt(end);
                    dp[start][end] = b;
                } else {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                }
                start++;
                end++;
            }
        }
        return dp;
    }
}
