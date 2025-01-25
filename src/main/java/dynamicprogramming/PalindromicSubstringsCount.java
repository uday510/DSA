/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
package dynamicprogramming;

public class PalindromicSubstringsCount {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; ++i) {
            int start = 0;
            int end = i;
            while (end < n) {
                if (i == 0) { //single character
                    dp[start][end] = true;
                } else if (i == 1) { // two characters
                    dp[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = dp[start + 1][end - 1];
                    } else {
                        dp[start][end] = false;
                    }
                }
                if (dp[start][end]) {
                    ++count;
                }
                ++start;
                ++end;
            }
        }
        return count;
    }
    public static int getCount(String s) {

        int n = s.length();
        int count = 0;

        for (int start = 0; start < n; ++start) {
            for (int end = start; end < n; ++end) {
                if (isPalindrome(s, start, end)) {
                    ++count;
                }
            }
        }
        return count;
    }
    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}
