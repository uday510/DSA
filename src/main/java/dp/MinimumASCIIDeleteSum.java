/*
Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.



Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.


Constraints:

1 <= s1.length, s2.length <= 1000
s1 and s2 consist of lowercase English letters.
 */
package dp;

public class MinimumASCIIDeleteSum {
    public static void main(String[] args) {
        String s1 = "delete", s2 = "leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }
    public static int minimumDeleteSum(String s1, String s2){

        int[] dp = new int[s2.length() + 1];

        for (int j = 1; j < s2.length() + 1; ++j) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1); // if s1 is empty, then we have to delete all the characters of s2
        }

        for (int i = 1; i < s1.length() + 1; ++i) {

            int[] prev = new int[s2.length() + 1];

            prev[0] = dp[0] + s1.charAt(i - 1); // if s2 is empty, then we have to delete all the characters of s1

            for (int j = 1; j < s2.length() + 1; ++j) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // if the characters are equal, then we don't have to delete any character
                    prev[j] = dp[j - 1];
                } else {
                    prev[j] = Math.min(s1.charAt(i - 1) + dp[j], s2.charAt(j - 1) + prev[j - 1]);
                }
            }
            dp = prev;
        }
        return dp[s2.length()];

    }
    public static int minimumDeleteSum(String s1, String s2, int i, int j, Integer[][] dp) {

        if (i < 0 && j < 0) return 0; // base case

        if (i < 0) { // if s1 is empty, then we have to delete all the characters of s2
            int sum = 0;
            for (int k = 0; k < j + 1; ++k) {
                sum += s2.charAt(k);
            }
            return sum;
        }

        if (j < 0) { // if s2 is empty, then we have to delete all the characters of s1
            int sum = 0;
            for (int k = 0; k < i + 1; ++k) {
                sum += s1.charAt(k);
            }
            return sum;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) { // if the characters are equal, then we don't have to delete any character
            return dp[i][j] = minimumDeleteSum(s1, s2, i - 1, j - 1, dp);
        } else {
            // WHY NOT DELETING BOTH THE CHARACTERS? BECAUSE WE HAVE TO DELETE THE MINIMUM NUMBER OF CHARACTERS TO MAKE THE STRINGS EQUAL
            // WHAT HAPPENS IF WE DELETE BOTH THE CHARACTERS? THEN WE HAVE TO DELETE ONE MORE CHARACTER TO MAKE THE STRINGS EQUAL

            // if the characters are not equal, then we have to delete one of them
            return dp[i][j] = Math.min(s1.charAt(i) +
                    minimumDeleteSum(s1, s2, i - 1, j, dp), s2.charAt(j)
                    + minimumDeleteSum(s1, s2, i, j - 1, dp));
        }

    }
}
