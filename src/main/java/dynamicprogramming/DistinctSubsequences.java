/**
 * Given two strings s and t, return the number of distinct
 * subsequences
 *  of s which equals t.
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from s.
 * rabbbit
 * rabbbit
 */
package dynamicprogramming;
public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(numDistinct(s, t));
    }
    public static int optimized(String s, String t) {
        // Note: we can use 1D array to store the result
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); ++i) {
            for (int j = t.length(); j >= 1; --j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[t.length()];
    }
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= t.length(); ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j]; // skip the character
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static int numDistinct(String s, String t, int i, int j) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (s.charAt(i) == t.charAt(j)) {
            return numDistinct(s, t, i - 1, j - 1) + numDistinct(s, t, i - 1, j);
        } else {
            return numDistinct(s, t, i - 1, j);
        }
    }
}
