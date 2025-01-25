package heap;
import java.util.*;
public class MinArrayLengthAfterRemovals {
    public static void main(String[] args) {

    }
    public static int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
        }

        while (pq.size() > 1) {
            int[] max = pq.poll();
            int[] min = pq.poll();

            max[1] -= 1;
            assert min != null;
            min[1] -= 1;

            if (max[1] != 0) pq.offer(max);
            if (min[1] != 0) pq.offer(min);
        }

        int minLength = 0;
        while (!pq.isEmpty()) {
            minLength += pq.poll()[1];
        }

        return minLength;
    }
}
