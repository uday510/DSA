package heap;

import java.util.*;

public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] s : slots1) {
            if (s[1] - s[0] >= duration) pq.offer(s);
        }

        for (int[] s : slots2) {
            if (s[1] - s[0] >= duration) pq.offer(s);
        }

        while(pq.size() > 1) {
            int[] s1 = pq.poll();
            int[] s2 = pq.peek();

            int st = Math.max(s1[0], s2[0]);
            int en = Math.min(s1[1], s2[1]);

            if (en - st >= duration) return new ArrayList<>(Arrays.asList(st, st + duration));
        }

        return new ArrayList<Integer>();
    }

}
