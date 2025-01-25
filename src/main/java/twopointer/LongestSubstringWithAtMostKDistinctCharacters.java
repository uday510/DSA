/*
Given a string s and an integer k, return the length of the longest
substring
 of s that contains at most k distinct characters.



Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.


Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
 */
package twopointer;

import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> map = new java.util.HashMap<>();
        int start = 0, max = 0;

        for (int end = 0; end < s.length(); ++end) {

            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

            while (map.size() > k) {
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
