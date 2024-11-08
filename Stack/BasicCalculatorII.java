package Stack;

import java.util.Stack;

public class BasicCalculatorII {

    public static void main(String[] args) {
        String s = "1-4";
        System.out.println(calculate(s));
    }
    private static int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int n = s.length();
        var stack = new Stack<Integer>();
        int currNum = 0;
        char operation = '+';

        for (int i = 0; i < n; ++i) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                currNum = (currNum * 10) + (curr - '0');
            }

            if (!Character.isDigit(curr) && !Character.isWhitespace(curr) || i == n - 1) {
                if (operation == '+') {
                    stack.push(currNum);
                }
                else if (operation == '-') {
                    stack.push(-currNum);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currNum);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currNum);
                }
                operation = curr;
                currNum = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
