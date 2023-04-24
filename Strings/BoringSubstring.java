/**
 * Problem Description
 * You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
 *
 * A boring substring has the following properties:
 *
 * Its length is 2.
 * Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
 * Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * The only argument given is a string A.
 *
 *
 *
 * Output Format
 * Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abcd"
 * Input 2:
 *
 *  A = "aab"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  String A can be rearranged into "cadb" or "bdac"
 * Explanation 2:
 *
 *  No arrangement of string A can make it free of boring substrings.
 */
package Strings;

import java.util.Arrays;

public class BoringSubstring {
    public static void main(String[] args) {
        String str = "abc";

        int ans = solve(str);
        System.out.println(ans);
    }
    public static int solve(String str) {
        // O(NLogN) time | O(N) space
        String odd = "", even = "";
        // odd and even stores odd and even characters respectively
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c % 2 == 0) {
                odd += c;
            } else even += c ;
        }
        char[] ar = odd.toCharArray();
        Arrays.sort(ar);
        ar = even.toCharArray();
        Arrays.sort(ar);
        even = String.valueOf(ar);
        // check if either (odd + even) or (even + odd) has no boring substrings
        if (check(odd + even)) return 1;
        else if (check(even + odd)) return 1;
        return 0;
    }
    public static boolean check(String str) {
        boolean ok = true;

        for (int i = 0; i < str.length() - 1; i++) {
            ok &= (Math.abs(str.charAt(i) - str.charAt(i + 1)) != 1);
        }
        return ok;
    }
}
