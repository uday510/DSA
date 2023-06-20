/**
 * Given a stack of integers A, sort it using another stack.
 *
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 5000
 *
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument is a stack given as an integer array A.
 *
 *
 *
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 4, 3, 2, 1]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 3, 4, 5]
 * Output 2:
 *
 *  [5, 11, 17, 100]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Just sort the given numbers.
 * Explanation 2:
 *
 *  Just sort the given numbers.
 */
package Stack;

import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingAnotherStack {
    public static void main(String[] args) {
        int[] array = {5, 17, 100, 11};

        int[] ans = solve(array);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solve(int[] array) {

        /**
         * 1. Create a input-stack.
         * 2. while input is not empty:
         *          1. pop an element from input stack call it X.
         *          2. while the temporary stack is not empty and
         *          top of the temporary stack is > X pop from the
         *          temporary stack and push it into input stack.
         *          3. push x in the temporary stack.
         *
         * 4. The sorted numbers are in the temporary stack.
         *
         */
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        int n = array.length;
        for (int val : array) {
            inputStack.push(val);
        }

        while (!inputStack.empty()) {
            int curr = inputStack.pop();
            if( tempStack.empty()) {
                tempStack.push(curr);
            } else {
                while (!tempStack.isEmpty() && tempStack.peek() > curr) {
                    inputStack.push (tempStack.pop());
                }
                tempStack.push(curr);
            }
        }
        int[] ans = new int[n];
        // values are in desc order in stack from peek
        for (int i = n - 1; i > -1; i--) {
            ans[i] = tempStack.pop();
        }
        return ans;
    }
}
