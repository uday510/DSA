package Linear.Stacks;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        String[] arr = {"1", "+", "1", "3", "*"};

        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(String[] arr) {

        HashSet<String> hs = new HashSet<>();
        hs.add("+");
        hs.add("-");
        hs.add("*");
        hs.add("/");

       Stack<Integer> stack = new Stack<>();

       for (String s : arr) {
            if (stack.empty() || !hs.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                if (s.equals("+")) {
                    stack.push(val1 + val2);
                } else if (s.equals("*")) {
                    stack.push(val1 * val2);
                } else if (s.equals("-")) {
                    stack.push(val1 - val2);
                } else {
                    stack.push(val1 / val2);
                }
            }
       }
       return stack.peek();
    }
}
