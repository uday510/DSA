/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 * Accepted
 * 621K
 * Submissions
 */
package Linear.Stacks;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {

    }
    public static int solve(String str) {
        /**
         * Approach 1: Brute Force
         * Algorithm
         *
         * In this approach, we consider every possible non-empty even length substring from the given string and check whether it's
         * a valid string of parentheses or not. In order to check the validity, we use the Stack's Method.
         *
         * Every time we
         * encounter a ‘(’\text{‘(’}‘(’, we push it onto the stack. For every ‘)’\text{‘)’}‘)’ encountered, we pop a ‘(’\text{‘(’}‘(’ from the stack. If ‘(’\text{‘(’}‘(’ isn't
         * available on the stack for popping at anytime or if stack contains some elements after processing complete substring, the substring of parentheses is invalid. In this way, we repeat the
         * process for every possible substring and we keep on
         * storing the length of the longest valid string found so far.
         *
         * Example:
         * "((())"
         *
         * (( --> invalid
         * (( --> invalid
         * () --> valid, length=2
         * )) --> invalid
         * ((()--> invalid
         * (())--> valid, length=4
         * maxlength=4
         *
         * Time complexity: O(n3)O(n^3)O(n
         * 3
         *  ). Generating every possible substring from a string of length nnn requires O(n2)O(n^2)O(n
         * 2
         *  ). Checking validity of a string of length nnn requires O(n)O(n)O(n).
         *
         * Space complexity: O(n)O(n)O(n). A stack of depth nnn will be required for the longest substring.
         */
        int maxlen = 0;
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i + 2; j <= str.length(); j += 2) {
//                if (isValid(str.substring(i, j))) {
//                    maxlen = Math.max(maxlen, j - i);
//                }
//            }
//        }
//        return maxlen;
        /**
         * Approach : Using Stack
         * Algorithm
         *
         * Instead of finding every possible string and checking its validity, we can make use of a stack while scanning the given string to:
         *
         * 1. Check if the string scanned so far is valid.
         * 2. Find the length of the longest valid string.
         * In order to do so, we start by pushing −1-1−1 onto the stack. For every ‘(’\text{‘(’}‘(’ encountered, we push its index onto the stack.
         *
         * For every ‘)’\text{‘)’}‘)’ encountered, we pop the topmost element. Then, the length of the currently encountered valid string of parentheses will be the difference between the current element's index and the top element of the stack.
         *
         * If, while popping the element, the stack becomes empty, we will push the current element's index onto the stack. In this way, we can continue to calculate the length of the valid substrings and return the length of the longest valid string at the end.
         */

        // O(N) time | O(N) space
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen;
    }
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
