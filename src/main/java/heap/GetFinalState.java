package heap;

import java.util.PriorityQueue;

public class GetFinalState {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 3;
        int[] finalState = getFinalState(arr, n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(finalState[i] + " ");
        }
    }
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
       PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

       for (int i = 0; i < nums.length; ++i) {
           pq.offer(new int[]{nums[i], i});
       }

       while (k > -1) {
           int[] top = pq.poll();
           int val = top[0];
           int idx = top[1];
           nums[idx] = val * multiplier;
           pq.offer(new int[]{val * multiplier, idx});
           k--;
       }
       return nums;
     }
}
