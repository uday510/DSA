/*
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
package slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";

        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, n = s.length(), res = 0;
        int[] count = new int[128];

        for (; j < n; ++j) {
            count[s.charAt(j)]++;
            while (count[s.charAt(j)] > 1) count[s.charAt(i++)]--;
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
