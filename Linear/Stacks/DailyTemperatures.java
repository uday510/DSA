/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
package Linear.Stacks;

import java.awt.font.ShapeGraphicAttribute;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        int[] ans = solve(temperatures);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] temperatures) {
        // O(N) time | O(N) space
        int n = temperatures.length;
        int[] ngr = ngr(temperatures);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (ngr[i] != 0) {
                ans[i] = ngr[i] - i;
            }
        }
        return ans;
    }
    public static int[] ngr(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            int currNum = temperatures[i];
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (temperatures[stack.peek()] > currNum) {
                arr[i] = stack.peek();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && currNum >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    arr[i] = stack.peek();
                }
                stack.push(i);
            }
        }
        return arr;
    }
}
