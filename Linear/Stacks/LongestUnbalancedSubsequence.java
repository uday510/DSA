/**
 * Problem Description
 * An input string A of length N is balanced if:
 *
 * Open parentheses must be closed by closed parentheses.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * You have been given a string with ‘{‘ and ‘}’, Also called as parentheses. Your task is to find the “longest Unbalanced Subsequence” of the given string.
 *
 *
 * Problem Constraints
 * 1<= N <= 100000
 *
 * S[i] = '{' or '}'
 *
 *
 * Input Format
 * First argument A is a string.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = {{}}
 *
 * Input 2:
 *
 * A = {{{}
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 *
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Example 1:
 *
 * Given string is balanced so we cannot take the whole string as a unbalanced subsequence , removing a character from it will make the string unbalanced so the answer is 3.
 *
 * Example 2:
 *
 * Given string is unbalanced so we can take the whole string as a unbalanced subsequence so the answer is 4.
 */
package Linear.Stacks;

import java.util.Stack;

public class LongestUnbalancedSubsequence {
    // contest Jun 2 2023
    public static void main(String[] args) {
        String str = "{{{}";

        int ans = solve(str);
        System.out.println(ans);
    }
    public static int solve(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '{') stack.push(c);
            else if (c == '}') {
                if (stack.size() > 0) stack.pop();
                else return str.length();
            }
        }
        if (stack.size() == 0) return str.length() - 1;
        else return str.length();

    }
}
