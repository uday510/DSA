/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "1+ 1";

        int ans = solve(s);
        System.out.println(ans);
   }
   public static int solve(String s) {
        // O(N) time | O(N) space
        int sum = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if the c is not digit continue
            if (Character.isDigit(c)) {
                int val = 0;
                // get the digit , eg: 312
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // because of for loop
                val = val*sign; // multiple with sign
                sign = 1; // reset sign
                sum += val; // add it to the total sum
            } else if (c == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = +1;
            } else if (c == ')') {
                sum *= stack.pop(); // sign
                sum += stack.pop(); // digit
            } else if (c == '-') {
                sign *= -1;
            }
        }
        return sum;
   }
}
