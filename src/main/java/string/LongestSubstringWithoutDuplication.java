/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

package string;
import java.util.Map;

public class LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // 3
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        Map<Character, Integer> lastSeen = new java.util.HashMap<>();
        int[] longest = {0, 1};
        int startIdx = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (lastSeen.containsKey(c)) {
                startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
            }

            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest = new int[] {startIdx, i + 1};
            }
            lastSeen.put(c, i);
        }
        String result = s.substring(longest[0], longest[1]);
        return result.length();
    }
}
