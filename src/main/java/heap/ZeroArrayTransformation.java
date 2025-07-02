package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ZeroArrayTransformation {

    public static void main(String[] args) {

    }


    public int maxRemoval(int[] nums, int[][] queries) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int diff1 = a[1] - a[0];
            int diff2 = b[1] - b[0];

            if (diff1 != diff2) {
                return diff2 - diff1;
            }

            return b[1] - a[1];
        });

        int cnt = 0;

        for (int[] query: queries) {
            pq.offer(query);
        }

        while (!pq.isEmpty()) {
            int[] query = pq.poll();
            System.out.println(Arrays.toString(query));

            cnt++;
            decrement(nums, query);

            if ((int) Arrays.stream(nums).sum() == 0) {
                return queries.length - cnt;
            }
        }

        return -1;
    }

    private void decrement(int[] nums, int[] query) {
        int i = query[0], j = query[1];

        while (i <= j) {
            if (nums[i] > 0) {
                nums[i]--;
            }
            i++;
        }
    }
}
