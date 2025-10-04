package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1, cnt = 0;
            List<Integer> list = new ArrayList<>();
            while (cycle-- > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur > 1) list.add(cur - 1);
                cnt++;
            }

            for (int t : list) pq.offer(t);

            time += (pq.isEmpty() ? cnt : n + 1);
        }

        return time;
    }

}
