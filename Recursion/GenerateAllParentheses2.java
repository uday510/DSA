/**
 * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First and only argument is integer A.
 *
 *
 *
 * Output Format
 * Return a sorted list of all possible parenthesis.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * Output 2:
 *
 * [ "()" ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All paranthesis are given in the output list.
 * Explanation 2:
 *
 *  All paranthesis are given in the output list.
 */
package Recursion;

import java.util.ArrayList;

public class GenerateAllParentheses2 {
    static ArrayList<String> ans;

    public static void main(String[] args) {
        int n = 3;
        ans = new ArrayList<String>();
        String str = new String();
        solve(n, 0, 0, str);
        System.out.println(ans);
    }
    public static void solve(int n, int opening, int closing, String str) {
        if (str.length() == 2*n) {
            ans.add(str);
            return;
        }
        if (opening < n) {
            solve(n, opening+1, closing, str+"(");
        }
        if (closing < opening) {
            solve(n, opening, closing+1, str+")");
        }
    }
}
