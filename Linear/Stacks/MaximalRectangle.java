/**
 * Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
 *
 * Find the largest rectangle containing only 1's and return its area.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 * Input Format
 *
 * The only argument given is the integer matrix A.
 * Output Format
 *
 * Return the area of the largest rectangle containing only 1's.
 * Constraints
 *
 * 1 <= N, M <= 1000
 * 0 <= A[i] <= 1
 * For Example
 *
 * Input 1:
 *     A = [   [0, 0, 1]
 *             [0, 1, 1]
 *             [1, 1, 1]   ]
 * Output 1:
 *     4
 *
 * Input 2:
 *     A = [   [0, 1, 0, 1]
 *             [1, 0, 1, 0]    ]
 * Output 2:
 *     1
 */
package Linear.Stacks;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        int[][] matrix = { {0, 1, 1},
                           {1, 0, 0},
                           {1, 0, 0},
                           {1, 0, 0},
                           {1, 1, 1},
                           {0, 1, 0} };

        int ans = solve(matrix);
        System.out.println(ans);
    }
    public static int solve(int[][] matrix) {
        int ans = Integer.MIN_VALUE;

    /**
     * Row by Row apply maximum area of rectangle
     */
    for (int i = 0; i < matrix.length; i++) {
        ans = Math.max(ans, getMaxRectangle(matrix[i]));
    }

    return ans;
    }

    public static int getMaxRectangle(int[] heights) {
        int ans = Integer.MIN_VALUE;

        int[] nextSmallerLeft = getNsl(heights);
        int[] nextSmallerRight = getNsr(heights);

        for (int i = 0; i < heights.length; i++) {
            ans = Integer.max(ans, heights[i] *
                    (nextSmallerRight[i] - nextSmallerLeft[i] - 1));
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
