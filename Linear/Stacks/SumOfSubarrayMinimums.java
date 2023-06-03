/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * Example 2:
 *
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */
package Linear.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {71,55,82,55};

        solve(arr);
    }

    public static int solve(int[] arr) {
        int MOD = (int) (1e9 + 7);

        int[] NSEL = getNSEL(arr);
        int[] NSER = getNSER(arr);

        System.out.print("NSEL " + Arrays.toString(NSEL));
        System.out.println();
        System.out.print("NSER " + Arrays.toString(NSER));

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // contribution
            sum += 1L* arr[i] * (i - NSEL[i]) * (NSER[i] - i);
            sum = sum % MOD;
        }
        return (int) sum;
    }
    public static int[] getNSEL(int[] array) {
        // nearest smaller element left hand side
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

    public static int[] getNSER(int[] array) {
        // nearest smaller element right hand side
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
                while (!stack.isEmpty() && currNum < array[stack.peek()]) {
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

        // c[71,55,82,55]
        return ans;
    }
}
