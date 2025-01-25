/**
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * .
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase English letters only.
 */
package dynamicprogramming;

public class PalindromePartitioning2 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(solve(s));
    }
    public static int solve(String s) {
        boolean[][] palindromeDp = getPalindromeDp(s);
        Integer[][] dp = new Integer[s.length()][s.length()];
        int startIdx = 0, endIdx = s.length() - 1;
        return minCut(s, startIdx, endIdx,dp,  palindromeDp);
    }
    public static int minCut(String s, int startIdx, int endIdx, Integer[][] dp, boolean[][] palindromeDp) {
        if (palindromeDp[startIdx][endIdx]) {
            return 0;
        }
        if (dp[startIdx][endIdx] != null) {
            return dp[startIdx][endIdx];
        }
        int min = Integer.MAX_VALUE;
        for (int i = startIdx; i < endIdx; ++i) {
            if (palindromeDp[startIdx][i]) {
                min = Math.min(min, 1 + minCut(s, i + 1, endIdx, dp, palindromeDp));
            }
        }
        dp[startIdx][endIdx] = min;
        return min;
    }
    public static boolean[][] getPalindromeDp(String s) {
        int n = s.length();
        boolean[][] palindromeDp = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            int start = 0, end = i;
            while (end < n) {
                if (i == 0) {
                    palindromeDp[start][end] = true;
                } else if (i == 1) {
                    palindromeDp[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    if (s.charAt(start) == s.charAt(end)) {
                        palindromeDp[start][end] = palindromeDp[start + 1][end - 1];
                    } else {
                        palindromeDp[start][end] = false;
                    }
                }
                start++;
                end++;
            }
        }
        return palindromeDp;
    }
}
