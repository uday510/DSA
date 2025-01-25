package binarysearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PaintingWalls {
    public static void main(String[] args) {
        int[] cost = {26,53,10,24,25,20,63,51};
        int[] time = {1,1,1,1,2,2,2,1};

        System.out.println(paintWalls(cost, time));
    }
        public static int paintWalls(int[] cost, int[] time) {
            int N = cost.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            for (int i = 0; i < N; ++i) {
                int t = time[i], c = cost[i];
                pq.offer(new int[]{t, c});
            }
            int min = 0;
            int halfN = N / 2;

            while (halfN > 0) {
                int[] temp = pq.poll();
                if (halfN == 1 && N % 2 == 0) {
                    if (pq.size() > 1 && pq.peek()[1] < temp[1]) {
                        temp = pq.poll();
                    } else if (pq.size() > 1 && pq.peek()[1] == temp[1] && pq.peek()[2] < temp[2]) {
                        temp = pq.poll();
                    }
                }
                min += temp[1];
                halfN--;
            }
            return min;
        }

}
