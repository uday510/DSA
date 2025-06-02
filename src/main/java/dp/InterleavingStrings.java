/**
 * Problem Description
 * Given A, B, C find whether C is formed by the interleaving of A and B.
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A), length(B) <= 100
 *
 * 1 <= length(C) <= 200
 *
 *
 *
 * Input Format
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * The third argument of input contains a string, C.
 *
 *
 *
 * Output Format
 * Return 1 if string C is formed by interleaving of A and B else 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "aabcc"
 *  B = "dbbca"
 *  C = "aadbbcbcac"
 * Input 2:
 *
 *  A = "aabcc"
 *  B = "dbbca"
 *  C = "aadbbbaccc"
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
 *  "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
 * Explanation 2:
 *
 *  It is not possible to get C by interleaving A and B.
 */
package dp;

import java.util.Scanner;

public class InterleavingStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();

        if (s1.length() + s2.length() != s3.length()) {
            System.out.println("false");
        } else {
            System.out.println(solve(s1, s2, s3));
        }
    }
    public static boolean bfs(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 && j == 0) { dp[i][j] = true; }
                else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                } else {
                  if (s1.charAt(i-1) == s3.charAt(i + j - 1)) {
                      dp[i-1][j] = dp[i-1][j];
                  }
                  if (!dp[i][j] && s2.charAt(j-1) == s3.charAt(i + j - 1)) {
                      dp[i][j-1] = dp[i][j-1];
                  }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static boolean solve(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return solution2(s1, s2, s3, 0, 0, dp);
    }
    public static boolean solution2(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length()) return true;

        if (dp[i][j] != null) return dp[i][j];

        boolean isMatch1 = i < s1.length() && s1.charAt(i) == s3.charAt(i + j);
        boolean isMatch2 = j < s2.length() && s2.charAt(j) == s3.charAt(i + j);

        if (isMatch1 && isMatch2) {
            dp[i][j] = solution2(s1, s2, s3, i + 1, j, dp) || solution2(s1, s2, s3, i, j + 1, dp);
        } else if (isMatch1) {
            dp[i][j] = solution2(s1, s2, s3, i + 1, j, dp);
        } else if (isMatch2) {
            dp[i][j] = solution2(s1, s2, s3, i, j + 1, dp);
        } else {
            dp[i][j] = false;
        }
        return dp[i][j];

    }

    public static int isInterleave(String s1, String s2, String s3, int i, int j, int index) {
        if (index < 0) {
            if (i == s1.length() - 1 || j == s2.length() - 1) return 0;
            else {
                return 1;
            }
        }
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0) {
            if (s2.charAt(j) == s3.charAt(index)) {
                return isInterleave(s1, s2, s3, i, j - 1, index - 1);
            } else {
                return 0;
            }
        }
        if (j < 0) {
            if (s1.charAt(i) == s3.charAt(index)) {
                return isInterleave(s1, s2, s3, i - 1, j, index - 1);
            } else {
                return 0;
            }
        }
        if (s1.charAt(i) == s3.charAt(index) && s2.charAt(j) == s3.charAt(index)) {
            return isInterleave(s1, s2, s3, i - 1, j, index - 1) | isInterleave(s1, s2, s3, i, j - 1, index - 1);
        } else if (s1.charAt(i) == s3.charAt(index)) {
            return isInterleave(s1, s2, s3, i - 1, j, index - 1);
        } else if (s2.charAt(j) == s3.charAt(index)) {
            return isInterleave(s1, s2, s3, i, j - 1, index - 1);
        } else {
            return 0;
        }
    }}
