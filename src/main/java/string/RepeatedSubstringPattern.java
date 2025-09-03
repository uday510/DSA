/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.


Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 */

package string;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int len = 1; len * 2 <= n; len++) {
            if (n % len != 0) continue;

            boolean ok = true;

            for (int i = len; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - len)) {
                    ok = false;
                    break;
                }
            }

            if (ok) return true;
        }

        return false;
    }
}
