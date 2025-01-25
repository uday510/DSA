package heap;

import java.util.PriorityQueue;

public class FurthestBuilding {
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
       // use priority queue to store the difference of heights
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                pq.add(diff);
                if (pq.size() > ladders) {
                    bricks -= pq.poll();
                }
                if (bricks < 0) {
                    return i;
                }
            }
        }
        return heights.length - 1;
    }
}
