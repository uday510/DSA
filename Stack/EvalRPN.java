package Stack;

import jdk.dynalink.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvalRPN {
    private static final Map<String, Operation> OPERATIONS = new HashMap<>();
    static {
        OPERATIONS.put("+", (num1, num2) -> num1 + num2);
        OPERATIONS.put("-", (num1, num2) -> num1 - num2);
        OPERATIONS.put("*",(num1, num2) -> num1 * num2);
        OPERATIONS.put("/", (num1, num2) -> num1 / num2);
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();

        for (String token : tokens) {
            if (OPERATIONS.containsKey(token)) {
                handleOperation(OPERATIONS.get(token), stack);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
    private static void handleOperation(Operation operation, Stack<Integer> stack) {
       try {
           int right = stack.pop();
           int left = stack.pop();

           int result = operation.eval(left, right);
           stack.push(result);
       } catch (Exception e) {
           throw new IllegalArgumentException("Invalid RPN expression");
       }
    }
    @FunctionalInterface
    private interface Operation {
        int eval(int num1, int num2);
    }
}
