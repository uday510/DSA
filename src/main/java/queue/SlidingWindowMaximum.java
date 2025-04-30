/**
 * ou are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;

        int[] ans = solve(nums, k);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] nums, int k) {

        int n = nums.length;
        if (n*k == 0) return new int[0];

        int[] output = new int[n-k+1];

//        O(N-K+1) time | O(K) space
//        for (int i = 0; i < n - k + 1; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            output[i] = max;
//        }

        // queue won't work here, for explanation purpose, dry run with the input
        int idx = 0;
        // store index
        // monotonous increasing queue
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // remove smaller elements in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                assert !deque.isEmpty();
                output[idx++] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}
