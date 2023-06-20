/**
 * Problem Description
 * Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
 *
 * The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
 *
 * NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the each String <= 100
 *
 *
 *
 * Input Format
 * The given arguments are string A and string B.
 *
 *
 *
 * Output Format
 * Return 1 if they represent the same expression else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "-(a+b+c)"
 *  B = "-a-b-c"
 * Input 2:
 *
 *  A = "a-b-(c-d)"
 *  B = "a-b-c-d"
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
 *  The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
 * Explanation 2:
 *
 *  Both the expression are different.
 */
package Stacks;

import java.util.Stack;

public class CheckTwoBracketExpressions {
    public static void main(String[] args) {
        String a = "-(a+b+c)";
        String b = "-a-b-c";

        Boolean ans = solve(a, b);
        System.out.println(ans);
    }
    public static Boolean solve(String expr1, String expr2) {
        // DAY: 59
        // O(N) time | O(N) space
        int v[] = new int[26]; // mapping
        eval(expr1, v, true);
        // calls the second expression with opposite sign
        eval(expr2, v, false);
        // check if both the expressions are equal

        for (int i = 0; i < 26; i++) {
            if (v[i] != 0) return false;
        }
        return true;
    }
    static void eval(String s, int v[], Boolean add) { // "-(a+b+c)"
        Stack<Boolean> stack = new Stack<>();
        stack.push(true); // {true, false}
        int i = 0;
        //we evaluate the contribution of each character in the expression
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                i++;
                continue;
            }
            if (c == '(') {
                // check for prev sign
                if (adjSign(s, i)) { stack.push(stack.peek()); }
                else { stack.push(!stack.peek()); }
            } else if (c == ')') {
                stack.pop(); // done with adjSign, pop it
            } else {
                if (stack.peek()) { // if true
                    int x = 0;
                    // check for prev sign
                    if (adjSign(s, i)) {
                        if (add) { // + * + == +
                            x = 1;
                        } else {
                            x = -1; // + * - == -
                        }
                    } else {
                        if (add) {
                            x = -1; // + * - == -
                        } else {
                            x = 1; // + * + == +
                        }
                    }
                    v[c - 'a'] += x;
                } else { // false
                    int x = 0;
                    if (adjSign(s, i)) {
                        if (add) {
                            x = -1; // - * - == +
                        } else {
                            x = 1; // - * + == -
                        }
                    } else {
                        if (add) {
                            x = 1; // - * + == -
                        } else {
                            x = -1; // - * - == +
                        }
                    }
                    v[c - 'a'] += x;
                }
            } i++;
        }
    }
    static Boolean adjSign(String s, int i) {
        if (i == 0) return true;
        if (s.charAt(i - 1) == '-') return false;
        return true;
    }
}
