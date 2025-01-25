package dynamicprogramming;

/**
 * You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
 *
 * t is a subsequence of the string s.
 * The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
 * Return the length of the longest ideal string.
 *
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 *
 * Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "acfgbd", k = 2
 * Output: 4
 * Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
 * Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
 * Example 2:
 *
 * Input: s = "abcd", k = 3
 * Output: 4
 * Explanation: The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 0 <= k <= 25
 * s consists of lowercase English letters.
 */
public class LongestIdealString {
    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString(s, k));
    }

    public static int longestIdealString(String s, int k) {
        int len = s.length();

        int[][] dp = new int[len][26];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < 26; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(s, k, 0, -1, dp);
    }

    public static int dfs(String s, int k, int currIndex, int prev, int[][] seen) {
        if (currIndex == s.length()) {
            return 0;
        }

        if (prev != -1 && seen[currIndex][prev] != -1) {
            return seen[currIndex][prev];
        }


        int include = 0;

        if (prev == -1 || Math.abs(s.charAt(currIndex) - ('a' + prev)) <= k) {
            include = 1 + dfs(s, k, currIndex + 1, s.charAt(currIndex) - 'a', seen);
        }

        int exclude = dfs(s, k, currIndex + 1, prev, seen);

        int result = Math.max(include, exclude);

        if (prev != -1) {
            seen[currIndex][prev] = result;
        }

        return result;
    }
}
