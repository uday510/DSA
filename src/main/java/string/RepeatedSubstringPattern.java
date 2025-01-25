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
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }
    public static boolean repeatedSubstringPattern(String s) {
        /*
        2. Find all the factors of the length.
        3. For each factor, check if the substring of that length is repeated.
        4. If yes, return true.
         */

        int n = s.length();

        // Find all the factors of the length.
        for (int i = n / 2; i > 0; --i) {

            String substring  = s.substring(0, i);

            StringBuilder sb = new StringBuilder();

            sb.append(substring.repeat(n / i));

            if (sb.toString().equals(s)) {
                return true;
            }


        }
        return false;
    }
}
