/**
 * Problem Description
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 450
 *
 *
 *
 * Input Format
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 *
 *
 *
 * Output Format
 * Return an integer, representing the minimum number of steps required.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abad"
 *  B = "abac"
 * Input 2:
 *
 *  A = "Anshuman"
 *  B = "Antihuman
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Exlanation 1:
 *
 *  A = "abad" and B = "abac"
 *  After applying operation: Replace d with c. We get A = B.
 *
 * Explanation 2:
 *
 *  A = "Anshuman" and B = "Antihuman"
 *  After applying operations: Replace s with t and insert i before h. We get A = B.
 */
package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "aac";
        System.out.println(getMinDistance(s1, s2));
    }
    public static int solve(String s1, String s2) {
        // O(N*M) time and O(N*M) space
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return getMinDistance(s1, s2, s1.length() - 1, s2.length() - 1, dp);
    }
    public static int getMinDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= m; ++i) dp[0][i] = i;
        for (int i = 1; i <= n; ++i) dp[i][0] = i;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min (
                    dp[i-1][j-1],
                    Math.min (
                        dp[i-1][j],
                        dp[i][j-1]
                    )
                ) + 1;
            }
        }
        return dp[n][m];
    }
    public static int getMinDistance(String s1, String s2, int i, int j, Integer[][] dp) {
       if (i < 0 && j < 0) return 0;
       if (i < 0) return j + 1;
       if (j < 0) return i + 1;

       if (dp[i][j] != null) return dp[i][j];

       if (s1.charAt(i) == s2.charAt(j)) {
           dp[i][j] = getMinDistance(s1, s2, i - 1, j - 1, dp);
       } else {
           dp[i][j] = Math.min (
                   getMinDistance(s1, s2, i - 1, j - 1, dp),
               Math.min (
                   getMinDistance(s1, s2, i - 1, j, dp),
                   getMinDistance(s1, s2, i, j - 1, dp)
               )
           ) + 1;
       }
       return dp[i][j];
    }
}
