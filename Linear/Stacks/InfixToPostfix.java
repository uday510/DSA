/**
 * roblem Description
 * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
 *
 * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
 *
 * Find and return the postfix expression of A.
 *
 * NOTE:
 *
 * ^ has the highest precedence.
 * / and * have equal precedence but greater than + and -.
 * + and - have equal precedence and lowest precedence among given operators.
 *
 *
 * Problem Constraints
 * 1 <= length of the string <= 500000
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return a string denoting the postfix conversion of A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "x^y/(a*z)+b"
 * Input 2:
 *
 *  A = "a+b*(c^d-e)^(f+g*h)-i"
 *
 *
 */

// output 1 :   "xy^az*/b+"
// output 2 :   "abcd^e-fgh*+^*+i-"

package Linear.Stacks;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        // DAY: 59
        String string = "2-1+2";

        String ans = solve(string);
        System.out.println(ans);
    }
    public static String solve(String string) {

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (char c : string.toCharArray()) {
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

        while (!stack.isEmpty()) {
            sb.append((char) stack.pop());
        }
        return sb.toString();
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
