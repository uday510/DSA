package heap;

import java.util.*;

public class SmallestChair {
    public static void main(String[] args) {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend = 1;
        int res = smallestChair(times, targetFriend);
        System.out.println(res);
    }
    public static int smallestChair(int[][] times, int targetFriend) {
        List<int[]> list = new ArrayList<>();
        var assigned = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
        var available = new PriorityQueue<Integer>();
        int currChair = 0;

        for (int i = 0; i < times.length; ++i) {
            list.add(new int[]{times[i][0], times[i][1], i});
        }

        list.sort((o1, o2) -> o1[0] - o2[0]);

        for (int[] time : list) {
            int arrival = time[0];
            int leaves = time[1];
            int index = time[2];

            while (!assigned.isEmpty() && assigned.peek()[0] <= arrival) {
                available.offer(assigned.poll()[1]);
            }

            if (index == targetFriend) {
                return available.isEmpty() ? currChair : available.poll();
            }

            int assignedChair = available.isEmpty() ? currChair++ : available.poll();
            assigned.offer(new int[]{leaves, assignedChair});
        }
        return -1;
    }
}
