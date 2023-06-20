package Stack;

import java.util.Arrays;
import java.util.Stack;

// opposite of SumOfSubarrayMinimums
public class SumOfSubarrayMaximums {
    public static void main(String[] args) {
        int[] arr = {71,55,82,55};

        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] arr) {
        int MOD = (int) (1e9 + 7);

        int[] NSEL = getNGEL(arr);
        int[] NSER = getNGER(arr);

        System.out.print("NGEL " + Arrays.toString(NSEL));
        System.out.println();
        System.out.print("NGER " + Arrays.toString(NSER));

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // contribution
            sum += 1L* arr[i] * (i - NSEL[i]) * (NSER[i] - i);
            sum = sum % MOD;
        }
        return (int) sum;
    }
    public static int[] getNGEL(int[] array) {
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
            else if (array[stack.peek()] > currNum) {
                ans[i] = stack.peek();
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum >= array[stack.peek()]) {
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

    public static int[] getNGER(int[] array) {
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
            else if (array[stack.peek()] > currNum) {
                ans[i] = stack.peek();
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && currNum > array[stack.peek()]) {
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
