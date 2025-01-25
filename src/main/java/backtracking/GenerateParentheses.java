/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8

 */
package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
    public static List<String> generateParenthesis(int n) {
        //TODO <-- BACKTRACKING -->
        // O(2^2n * n) time | O(1) space
       List<String> res = new ArrayList<>();
       backtracking(res, new StringBuilder(), 0, 0, n);

       return res;
    }
    public static void backtracking(List<String> res, StringBuilder curr, int open, int close, int n) {
        if (curr.length() == 2 * n) {
            res.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append("(");
            backtracking(res, curr, open + 1, close, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            backtracking(res, curr, open, close + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public static List<String> solve(int n) {
        //TODO <-- BRUTE FORCE -->
        // O(2^2n * n) time | O(1) space
        List<String> res = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add("");


        while (!queue.isEmpty()) {
            String s = queue.poll();

            if (s.length() == 2*n) {
                if (isValid(s)) {
                    res.add(s);
                }
                continue;
            }
            queue.offer(s + "(");
            queue.offer(s + ")");
        }
        return res;
    }
    public static boolean isValid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++left;
            } else {
                --left;
            }

            if (left < 0) return false;
        }
        return left == 0;
    }
}
