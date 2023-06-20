package Array.Arrays;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        int ans = solve(heights);
        System.out.println(ans);
    }
    public static int solve(int[] heights) {
        int ans = Integer.MIN_VALUE;

        int[] NSL = getNsl(heights);
        int[] NSR = getNsr(heights);

        for (int i = 0; i < heights.length; i++) {
            ans = Integer.max(ans, heights[i] *
                    (NSR[i] - NSL[i] - 1));
        }
        return ans;
    }
    public static int[] getNsl(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = -1;
            }
            else if (array[stack.peek()] < currNum) {
                ans[i] = stack.peek();
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum <= array[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    ans[i] = -1;
                }
                stack.push(i);
            }

        }
        return ans;
    }
    public static int[] getNsr(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = -1;
            }
            else if (array[stack.peek()] < currNum) {
                ans[i] = stack.peek();
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum <= array[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    // keep default as array length
                    ans[i] = array.length;
                }
                stack.push(i);
            }

        }
        return ans;
    }
}
