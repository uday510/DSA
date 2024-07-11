package Stack;

import java.util.Stack;

public class ReverseParentheses {
    public static void main(String[] args) {
        String s = "(abcd)";
        System.out.println(reverseParentheses(s));
    }
    public static String reverseParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        return stack.toString();
    }
}
