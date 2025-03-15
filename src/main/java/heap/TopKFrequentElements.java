package heap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
    }

    public int[] topKFrequentHeapBased(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int num : count.keySet()) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }

        int[] topK = new int[k];
        for (int i = k - 1; i > -1 && !heap.isEmpty(); --i) {
            topK[i] = heap.poll();
        }

        return topK;

    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.merge(num, 1, (a, b) -> a + b);

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int key : count.keySet()) {
            buckets[count.get(key)].add(key);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = buckets.length - 1; i > -1; --i) {
            for (int num : buckets[i]) {
                list.add(num);
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; ++i) {
            topK[i] = list.get(i);
        }

        return topK;
    }

}