/*
Given a string s and an integer k, return true if s is a k-palindrome.

A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.



Example 1:

Input: s = "abcdeca", k = 2
Output: true
Explanation: Remove 'b' and 'e' characters.
Example 2:

Input: s = "abbababa", k = 1
Output: true


Constraints:

1 <= s.length <= 1000
s consists of only lowercase English letters.
1 <= k <= s.length
 */
package dp;

public class ValidPalindrome3 {

    public static void main(String[] args) {

    }
    public boolean isValidPalindrome(String s, int k) {
        Integer[][] dp = new Integer[s.length()][s.length()];

        int res = isValidPalindrome(s, 0, s.length() - 1, dp);

        return res <= k;
    }
    public int isValidPalindrome(String s, int i, int j, Integer[][] dp) {

        if (i >= j) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = isValidPalindrome(s, i+1, j-1, dp);
        } else {
            dp[i][j] =
                    1 + Math.min(isValidPalindrome(s, i+1, j, dp),
                            isValidPalindrome(s, i, j-1, dp));
        }

        return dp[i][j];
    }

}
