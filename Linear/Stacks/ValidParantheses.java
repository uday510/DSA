package Linear.Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {

    public static void main(String[] args) {
        String str = "()[]{}";

        boolean ans = solve(str);
        System.out.println(ans);
    }
    public static boolean solve(String str) {
        // O(N) time | O(N) space
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // if the current character is a closing bracket
            if(mappings.containsKey(c)) {

                // Get the top element of the stack, if the stack is empty,
                // set a dummy value of "#"
                char topElement = stack.empty() ? '#' : stack.pop();

                // if the mapping for this bracket doesn't match the stack's
                // top element, return false

                if (topElement != mappings.get(c)) {
                    return false;
                } else {
                    // if it was an opening bracket, push to the stack.
                    stack.push(c);
                }
            }

        }
        // if the stack still contains elements, then it is an invalid expression

        return stack.isEmpty();
    }
}
