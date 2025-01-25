/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.



Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4


Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
 */
package dynamicprogramming;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String s1 = "seat";
        String s2 = "sea";
        System.out.println(minDistance(s1, s2));
    }
    public static int minDistance(String s1, String s2) {

//        return minDistance(s1, s2, s1.length() - 1, s2.length() - 1, new Integer[s1.length()][s2.length()]);

        int[] dp = new int[s2.length() + 1];

        for (int i = 0; i < s2.length() + 1; ++i) {
            dp[i] = i; // dp[0][i] = i; why ? because if s1 is empty then we have to delete all the characters of s2
        }


        for (int i = 1; i < s1.length() + 1; ++i) {

          int[] temp = new int[s2.length() + 1]; // dp[i] = new int[s2.length() + 1];

            temp[0] = i; // dp[i][0] = i; why ? because if s2 is empty then we have to delete all the characters of s1

            for (int j = 1; j < s2.length() + 1; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[j] = dp[j - 1]; // dp[i][j] = dp[i - 1][j - 1];
                } else {
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]); // dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            dp = temp; // dp[i - 1] = dp[i];
        }
        return dp[s2.length()];
    }
    public static int minDistance(String s1, String s2, int i, int j, Integer[][] dp) {


        if (i < 0 && j < 0 ) {
            return 0;
        }

        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minDistance(s1, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = 1 + Math.min(minDistance(s1, s2, i - 1, j, dp), minDistance(s1, s2, i, j - 1, dp));

    }
}
