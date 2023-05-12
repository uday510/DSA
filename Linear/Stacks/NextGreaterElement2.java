/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
package Linear.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] ans = solve(nums);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] array) {
        // O(N) time | O(N) space
        int n = array.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i > -1; i--) {
            int currNum = array[i % n];

            if (stack.isEmpty()) {
                stack.push(currNum);
                ans[i % n] = -1;
            }
            else if (stack.peek() > currNum) {
                ans[i % n] = stack.peek();
                stack.push(currNum);
            }
            else {
                while (!stack.isEmpty() && currNum >= stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i % n] = stack.peek();
                } else {
                    ans[i % n] = -1;
                }
                stack.push(currNum);
            }

        }
        return ans;
    }
}
