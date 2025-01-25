/**
 * Problem Description
 * Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
 *
 * You need to return the length of longest palindromic subsequence.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of(A) <= 103
 *
 *
 *
 * Input Format
 * First and only integer is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of longest palindromic subsequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "bebeeed"
 * Input 2:
 *
 *  A = "aedsead"
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The longest palindromic subsequence is "eeee", which has a length of 4.
 * Explanation 2:
 *
 *  The longest palindromic subsequence is "aedea", which has a length of 5.
 */
package dynamicprogramming;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String A = "abac";
        System.out.println(solve(A));
    }
    public static int solve(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return lps(s, 0, s.length()-1, dp);
    }
    public static int lps(String s, int i, int j, Integer[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + lps(s, i+1, j-1, dp);
        } else {
            dp[i][j] = Math.max(lps(s, i+1, j, dp), lps(s, i, j-1, dp));
        }
        return dp[i][j];
    }
}
