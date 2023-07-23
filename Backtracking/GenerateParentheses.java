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
package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParentheses(n);
        System.out.println(res);
    }
    public static List<String> generateParentheses(int n) {
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
