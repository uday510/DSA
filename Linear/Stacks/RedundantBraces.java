/**
 * Problem Description
 * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
 *
 * Check whether A has redundant braces or not.
 *
 * NOTE: A will be always a valid expression and will not contain any white spaces.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return 1 if A has redundant braces else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "((a+b))"
 * Input 2:
 *
 *  A = "(a+(a+b))"
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
 *  ((a+b)) has redundant braces so answer will be 1.
 * Explanation 2:
 *
 *  (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 */
package Linear.Stacks;

import java.util.Stack;

public class RedundantBraces {
    // DAY: 59
    public static void main(String[] args) {
        String string = "((a+b))";

        int ans = solve(string);
        System.out.println(ans);
    }
    public static int solve(String string) {

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (char c : string.toCharArray()) { // "((a+b))"
            // if c is an operand, add it to output string
            if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);
            }
            // if the c is '(' push to stack
            else if (c == '(') {
                stack.push('(');
            }
            // if the c is ')' pop and to output string
            // until an '(' is encountered.
            else if (c == ')') {
                if (stack.peek() == '(') return 1;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append((char) stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && prec(c) <= prec(stack.peek())) {
                    sb.append((char) stack.pop());
                }
                stack.push(c);
            }
        }
        return 0;
    }
    public static int prec(char c) {
        if (c == '^')
            return 3;
        if (c == '*' || c == '/')
            return 2;
        if (c == '+' || c == '-')
            return 1;
        return -1;
    }
}
