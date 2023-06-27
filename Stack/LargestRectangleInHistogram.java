/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 */
package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 5, 6, 2, 3};

        int res = solve(heights);
        System.out.println(res);
    }
    public static int solve(int[] heights) {

        return largestRectangleArea(heights);
    }
    public static int largestRectangleArea(int[] heights) {
        //Approach 1
        // O(N^2)time | O(1) space
        int n = heights.length;
//        int maxArea = 0;
//        for (int i = 0; i < n; ++i) {
//            int minHeight = Integer.MAX_VALUE;
//            for (int j = i; j < n; ++j) {
//                minHeight = Math.min(minHeight, heights[j]);
//                int width = j - i + 1;
//                maxArea = Math.max(maxArea, minHeight * width);
//            }
//        }
        // Approach 2
        //O(3*N) time | O(N) space
        if (heights.length == 1) return heights[0];
        int ans = Integer.MIN_VALUE;
        int[] NSL = NSL(heights);
        int[] NSR = NSR(heights);
        for (int i = 0; i < heights.length; i++) {
            ans = Integer.max(ans, heights[i] *
                    (NSR[i] - NSL[i] - 1));
        }
        return ans;
    }
    public static int[] NSL(int[] array) {
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
    public static int[] NSR(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = array.length;
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
                    ans[i] = array.length;
                }
                stack.push(i);
            }

        }
        return ans;
    }
}
