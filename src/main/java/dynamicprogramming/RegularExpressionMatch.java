/**
 * Problem Description
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 *
 * ' ? ' : Matches any single character.
 * ' * ' : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 104
 *
 *
 *
 * Input Format
 * The first argument of input contains a string A.
 * The second argument of input contains a string B.
 *
 *
 *
 * Output Format
 * Return 1 if the patterns match else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aaa"
 *  B = "a*"
 * Input 2:
 *
 *  A = "acz"
 *  B = "a?a"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 *  So, the pattern matches we return 1.
 * Explanation 2:
 *
 *  '?' matches any single character. First two character in string A will be match.
 *  But the last character i.e 'z' != 'a'. Return 0.
 *
 */
package dynamicprogramming;
import java.util.Arrays;

// https://www.interviewbit.com/problems/regular-expression-match/
// https://leetcode.com/problems/wildcard-matching/description/
public class RegularExpressionMatch {
    public static void main(String[] args) {
        String A = "xbbzz";
        String B = "x*z***";
        System.out.println(solve(A, B));
    }
    public static boolean solve(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return isMatch(s1, s2, s1.length() - 1, s2.length() - 1, dp) == 1;
    }
    public static int isMatch(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] = 1 if s1[0...i] matches s2[0...j]
        if (s1.length() == 0 && s2.length() == 0) { // both strings are empty
            return 1;
        }
        if (s2.charAt(0) == '*') {
            Arrays.fill(dp[0], 1);
        } else {
            Arrays.fill(dp[0], 0);
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) { // string is empty
            for (int j = 1; j <= m; j++) { // pattern is empty
                if (s2.charAt(j - 1) == '*') { // if pattern has '*'
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else if (s2.charAt(j - 1) == '?' || s1.charAt(i - 1) == s2.charAt(j - 1)) { // if pattern has '?' or both characters are same
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // if pattern has some other character
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n][m];

    }
    public static int isMatch(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) { // both strings are empty
            return 1;
        }
        if (j < 0) { // pattern is empty
            return 0;
        }
        if (i < 0) { // string is empty
            if (s2.charAt(j) == '*') {
                return isMatch(s1, s2, i, j - 1, dp);
            }
            return 0;
        }
        if (dp[i][j] != -1) { // already calculated
            return dp[i][j];
        }
        if (s2.charAt(j) == '*') { // if pattern has '*'
            return dp[i][j] = Math.max(isMatch(s1, s2, i - 1, j, dp), isMatch(s1, s2, i, j - 1, dp));
        }
        if (s2.charAt(j) == '?' || s1.charAt(i) == s2.charAt(j)) { // if pattern has '?' or both characters are same
            return dp[i][j] = isMatch(s1, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = 0;
    }
}
