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

    static Integer[][] memo;
    static int length;

    public static void main(String[] args) {
        String A = "abac";
        System.out.println(solve(A));
    }

    public static int solve(String s) {
        initialize(s);
        int[][] dp = new int[length][length];

//        return dfs(0, length - 1, s);

        for (int idx1 = length - 1; idx1 > -1; --idx1) {
            dp[idx1][idx1] = 1;
            for (int idx2 = idx1 + 1; idx2 < length; ++idx2) {
                if (s.charAt(idx1) == s.charAt(idx2)) {
                    dp[idx1][idx2] = 2 + dp[idx1 + 1][idx2 - 1];
                }
                dp[idx1][idx2] = Math.max(dp[idx1 + 1][idx2], dp[idx1][idx2 - 1]);
            }
        }

        return dp[0][length - 1];
    }

    private static void initialize(String s) {
        length = s.length();
        memo = new Integer[length][length];
    }

    private static int dfs(int leftIdx, int rightIdx, String s) {
        if (leftIdx >= rightIdx) return 0;

        if (memo[leftIdx][rightIdx] != null) return memo[leftIdx][rightIdx];

        if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
            memo[leftIdx][rightIdx] =  dfs(leftIdx + 1, rightIdx - 1, s) + 2;
        } else {
            memo[leftIdx][rightIdx] = Math.max(dfs(leftIdx + 1, rightIdx, s), dfs(leftIdx, rightIdx - 1, s)) + 1;
        }

        return memo[leftIdx][rightIdx];
    }

}
