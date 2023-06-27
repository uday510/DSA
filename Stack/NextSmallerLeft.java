package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerLeft {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 10, 6, 1, 7, 15};

        int[] ans = bruteforce(array);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] bruteforce(int[] array) {
        int[] res = new int[array.length];

        res[0] = -1;

        for (int i = 1; i < array.length; ++i) {
            for (int j = i-1; j > -1; --j) {
                if (array[j] < array[i]) {
                    res[i] = array[j];
                    break;
                }
            }
            if (res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;
    }
    public static int[] solve(int[] array) {
        //DAY 60
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
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
