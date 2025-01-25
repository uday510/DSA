/**
 * Problem Description
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 *
 * ' . ' : Matches any single character.
 * ' * ' : Matches zero or more of the preceding element.
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
 * The second argument of input contains a string B denoting the pattern.
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
 *  A = "aab"
 *  B = "c*a*b"
 * Input 2:
 *
 *  A = "acz"
 *  B = "a.a"
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
 *  'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
 *  So, return 1.
 * Explanation 2:
 *
 *  '.' matches any single character. First two character in string A will be match.
 *  But the last character i.e 'z' != 'a'. Return 0.
 *
 */
package dynamicprogramming;

// https://leetcode.com/problems/regular-expression-matching/description/

public class RegularExpression2 {
    public static void main(String[] args) {
        String A = "aab";
        String B = "c*a*b";
        System.out.println(isMatch(A, B));
    }
    public static boolean solve(String A, String B) {
        return isMatch(A, B, A.length() - 1, B.length() - 1);
    }
    public static boolean isMatch(String s, String pattern) {
        boolean[][] dp = new boolean[s.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; ++j) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[0].length; ++j) {
                if (s.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]; // 0 occurence
                    if (s.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // 1 or more occurence
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][pattern.length()];

    }
    public static boolean isMatch(String s, String pattern, int i, int j) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false; // pattern is empty
        if (i < 0) {
            // pattern is not empty
            // check if all the remaining characters in pattern are '*'
            for (int k = j; k > -1; --k) {
                if (pattern.charAt(k) != '*') return false;
            }
            return true;
        }
        if (s.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
            return isMatch(s, pattern, i - 1, j - 1);
        }
        if (pattern.charAt(j) == '*') {
            if (s.charAt(i) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                return isMatch(s, pattern, i - 1, j) || isMatch(s, pattern, i, j - 2);
            } else {
                return isMatch(s, pattern, i, j - 2);
            }
        }
        return false;
    }
}
