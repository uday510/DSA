package stack;

import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> open = new HashSet<>();

        open.add('(');
        open.add('{');
        open.add('[');

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char ch : s.toCharArray()) {
            if (open.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() ||
                        stack.peek() != map.get(ch)) return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
