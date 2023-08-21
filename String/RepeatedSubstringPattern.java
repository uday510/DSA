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
package String;

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

            // why n/2 ? because if the length is 10,
            // then the substring can be of length 5, 2, 1.
            // But if the length is 10,
            // then the substring can't be of length 6, 7, 8, 9.
            // why substring can't be of length 6, 7, 8, 9 ?
            // because if the substring is of length 6,
            // it can be repeated only 1 time.

            if (n % i == 0) {
                // For each factor, check if the substring of that length is repeated.
                int m = n / i; // number of times the substring is repeated.

                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();

                sb.append(sub.repeat(m)); // repeat the substring m times.

                if (sb.toString().equals(s)) {
                    // if the repeated substring is equal
                    // to the original string, return true.
                    return true;
                }
            }

        }
        return false;
    }
}
