/**
 * Problem Description
 * Given an array of integers A.
 *
 * The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
 *
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the sum of values of all possible subarrays of A modulo 109+7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1]
 * Input 2:
 *
 *  A = [4, 7, 3, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  26
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only 1 subarray exists. Its value is 0.
 * Explanation 2:
 *
 * value ( [4] ) = 4 - 4 = 0
 * value ( [7] ) = 7 - 7 = 0
 * value ( [3] ) = 3 - 3 = 0
 * value ( [8] ) = 8 - 8 = 0
 * value ( [4, 7] ) = 7 - 4 = 3
 * value ( [7, 3] ) = 7 - 3 = 4
 * value ( [3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3] ) = 7 - 3 = 4
 * value ( [7, 3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
 * sum of values % 10^9+7 = 26
 */
package Linear.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MaxAndMin {
    public static void main(String[] args) {
        int[] array = {4, 7, 3, 8};

        int ans = solve(array);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
        // Solution having some logic error

        int[] ngl = getNextGreaterLeft(array);
        System.out.println("GREATER LEFT" + Arrays.toString(ngl));
        int[] ngr = getNextGreaterRight(array);
        System.out.println("GREATER RIGHT" + Arrays.toString(ngr));

        int[] nsl = getNextSmallerLeft(array);
        System.out.println("SMALLER LEFT" + Arrays.toString(nsl));
        int[] nsr = getNextSmallerRight(array);
        System.out.println("SMALLER RIGHT" + Arrays.toString(nsr));

        long max = 0;
        long min = 0;
        long mod = (long) (1e9 + 7);

        // 4, 7, 3, 8
        for (int i = 0; i < array.length; i++) {
            int val = array[i];

            max =  (max + (val * (i - ngl[i] + 1) * (ngr[i] - i + 1))) % mod;
            min = (min + (val * (i - nsl[i] + 1) * (nsr[i] - i + 1))) % mod;
        }
        return (int) (max - min);
    }
    public static int[] getNextSmallerLeft(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
            }
            else if (array[stack.peek()] < currNum) {
                ans[i] = stack.peek() + 1;
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum <= array[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek() + 1;
                }
//                else {
//                    ans[i] = -1;
//                }
                stack.push(i);
            }
        }
        return ans;
    }
    public static int[] getNextSmallerRight(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = array.length - 1;
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
                    ans[i] = stack.peek() - 1;
                }
                else {
                    // keep default as array length
                    ans[i] = array.length - 1;
                }
                stack.push(i);
            }

        }
        return ans;
    }
    public static int[] getNextGreaterLeft(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
//                    ans[i] = -1;
            }
            else if (array[stack.peek()] > currNum) {
                ans[i] = stack.peek() + 1;
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum >= array[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek() + 1;
                }
//                else {
//                    ans[i] = -1;
//                }
                stack.push(i);
            }
        }
        return ans;
    }
    public static int[] getNextGreaterRight(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            int currNum = array[i];

            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = array.length;
            }
            else if (array[stack.peek()] > currNum) {
                ans[i] = stack.peek() - 1;
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum >= array[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                }
                else {
                    // keep default as array length
                    ans[i] = array.length;
                }
                stack.push(i);
            }

        }
        return ans;
    }
}
