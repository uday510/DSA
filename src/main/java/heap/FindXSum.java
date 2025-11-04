package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindXSum {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            res[i] = xSum(i, k, x, nums);
        }

        return res;
    }

    private int xSum(int st, int k, int x, int[] arr) {
        int en = st + k;
        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int c1 = map.get(a), c2 = map.get(b);
            if (c1 == c2) return a - b;
            return c1 - c2;
        });

        for (int i = st; i < en; i++)
            map.merge(arr[i], 1, Integer::sum);

        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > x) pq.poll();
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int key = pq.poll();
            sum += key * map.get(key);
        }

        return sum;
    }
}
