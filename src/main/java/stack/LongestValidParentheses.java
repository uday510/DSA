package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int longest = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int idx = 0; idx < s.length(); ++idx) {
            char currChar = s.charAt(idx);

            if (currChar == '(') stack.push(idx);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(idx);
                longest = Math.max(longest, idx - stack.peek());
            }
        }
        return longest;
    }


}
