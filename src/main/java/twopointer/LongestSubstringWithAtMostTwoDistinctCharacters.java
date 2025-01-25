/*
Given a string s, return the length of the longest
substring
 that contains at most two distinct characters.



Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.


Constraints:

1 <= s.length <= 105
s consists of English letters.
 */
package twopointer;

import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new java.util.HashMap<>();
        int start = 0, max = 0;

        for (int end = 0; end < s.length(); ++end) {

            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

            while (map.size() > 2) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);

                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }

                ++start;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
