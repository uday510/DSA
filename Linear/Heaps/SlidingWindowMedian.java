/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
 *
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 * Explanation:
 * Window position                Median
 * ---------------                -----
 * [1  3  -1] -3  5  3  6  7        1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7        3
 *  1  3  -1  -3 [5  3  6] 7        5
 *  1  3  -1  -3  5 [3  6  7]       6
 * Example 2:
 *
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */
package Linear.Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        double[] ans = solve(nums, k);
        System.out.println(Arrays.toString(ans));
    }
    public static double[] solve(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        double[] medians = new double[n-k+1];
        int idx=-1;

        int i = 0;

        // initialize the heaps
        while (i < k) {
            maxHeap.add(nums[i++]);
        }
        for (int j = 0; j < k / 2; j++) {
            minHeap.add(maxHeap.peek());
            maxHeap.poll();
        }
        System.out.println(minHeap);
        System.out.println(maxHeap);

        while (true) {
            double temp;

            if (i >= nums.length) break;

            if (nums[i] > maxHeap.size()) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            int diff = Math.abs(maxHeap.size() - minHeap.size());
            if (diff > 1) {
                balanceHeaps(maxHeap, minHeap);
            }

            if (maxHeap.size() > minHeap.size()) {
                 temp = maxHeap.peek() * 1.0;
            } else if (minHeap.size() > maxHeap.size()) {
                temp = minHeap.peek() * 1.0;
            } else {
                temp = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            medians[++idx] = temp;

            int outNum = nums[i-k];
            int inNum = nums[i++];
            hm.put(outNum, hm.getOrDefault(outNum, 0) + 1);

            while (hm.containsKey(maxHeap.peek())) {
                hm.put(maxHeap.peek(), hm.get(maxHeap.peek())-1);
                maxHeap.poll();
            }

            while (!minHeap.isEmpty() && hm.containsKey(minHeap.peek())) {
                hm.put(minHeap.peek(), hm.get(minHeap.peek())-1);
                minHeap.poll();
            }
        }
        System.out.println(Arrays.toString(medians));

        return medians;
    }

    public static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        int temp;
        if (maxHeap.size() > minHeap.size()) {
            temp = maxHeap.poll();
            minHeap.add(temp);
        } else {
            temp = minHeap.poll();
            maxHeap.add(temp);
        }
    }
}
