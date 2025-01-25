package heap;

import java.util.*;

public class FindMedianFromDataStreamScaler {
    public static void main(String[] args) {
        int[] nums = {5, 17, 100, 11};

        int[] ans = solve(nums);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // For smaller elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // For larger elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.add(nums[0]);
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxHeap.peek()) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            int diff = Math.abs(maxHeap.size() - minHeap.size());
            if (diff > 1) {
                balanceHeaps(maxHeap, minHeap);
            }
            if (maxHeap.size() == minHeap.size()) {
                list.add(maxHeap.peek());
            } else if (minHeap.size() > maxHeap.size()) {
                list.add(minHeap.peek());
            }
            else {
                list.add(maxHeap.peek());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size()) {
            int val = maxHeap.poll();
            minHeap.add(val);
        } else {
            int val = minHeap.poll();
            maxHeap.add(val);
        }
    }
}
