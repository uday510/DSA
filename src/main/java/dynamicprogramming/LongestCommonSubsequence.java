/**Problem Description
 Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.

 You need to return the length of such longest common subsequence.



 Problem Constraints
 1 <= Length of A, B <= 1005



 Input Format
 First argument is a string A.
 Second argument is a string B.



 Output Format
 Return an integer denoting the length of the longest common subsequence.



 Example Input
 Input 1:

 A = "abbcdgf"
 B = "bbadcgf"
 Input 2:

 A = "aaaaaa"
 B = "ababab"


 Example Output
 Output 1:

 5
 Output 2:

 3
 *
 */
package dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String A = "abcd";
        String B = "aebd";
        int res = longestCommonSubsequence(A, B);
        System.out.println(res);
    }
    public static int solve(String A, String B) {
        Integer[][] dp = new Integer[A.length()][B.length()];
        return longestCommonSubsequence(A, B, A.length()-1, B.length()-1, dp);
    }
    public static int longestCommonSubsequence(String A, String B) {
//      O(N*M) time | O(M) space (M is the length of the shorter string
        int n = A.length();
        int m = B.length();
        int[] dp = new int[m+1];
        dp[0] = A.charAt(0) == B.charAt(0) ? 1 : 0;

        for (int i = 1; i < n+1; ++i) {
            for (int j = 1; j < m+1; ++j) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[j] = 1 + dp[j-1];
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
            }
        }
        return dp[m];
        // O(N*M) time | O(N*M) space

//        int[][] dp = new int[n+1][m+1];
//        for (int i = 0; i <= n; ++i) dp[i][0] = 0;
//        for (int j = 0; j <= m; ++j) dp[0][j] = 0;

//        for (int i = 1; i <= n; ++i) {
//            for (int j = 1; j <= m; ++j) {
//                if (A.charAt(i-1) == B.charAt(j-1)) {
//                    dp[i][j] = 1 + dp[i-1][j-1];
//                } else {
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[n][m];
    }
    public static int longestCommonSubsequence(String A, String B, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != null) return dp[i][j];

        if (A.charAt(i) == B.charAt(j)) {
            dp[i][j] = 1 + longestCommonSubsequence(A, B, i-1, j-1, dp);
        } else {
            dp[i][j] = Math.max(
                    longestCommonSubsequence(A, B, i-1, j, dp),
                    longestCommonSubsequence(A, B, i, j-1, dp));
        }
        return dp[i][j];
    }
}
