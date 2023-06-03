package Linear.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerRight {
    //DAY 60
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 6, 2, 3};

        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        // O(N) time | O(N) space
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(currNum);
                ans[i] = -1;
            }
            else if (stack.peek() < currNum) {
                ans[i] = stack.peek();
                stack.push(currNum);
            }
            else {
                while (!stack.isEmpty() && currNum <= stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    ans[i] = -1;
                }
                stack.push(currNum);
            }
        }
        return ans;
    }
}
