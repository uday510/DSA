/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
// https://leetcode.com/problems/reverse-string/
package Recursion;

public class ReverseStringLeetCode {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s, 0, s.length - 1);
        for(char c : s) {
            System.out.print(c + " ");
        }
    }
    public static void reverseString(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverseString(s, start + 1, end - 1);
    }

}
