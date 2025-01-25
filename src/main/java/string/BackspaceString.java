package string;

import java.util.Objects;
import java.util.Stack;

public class BackspaceString {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        System.out.println(backspaceCompare(s, t));
    }
    public static boolean backspaceCompare(String s, String t) {
        String s1 = helper(s);
        String s2 = helper(t);

        return Objects.equals(s1, s2);
    }
    public static String helper(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.toString();
    }
}
