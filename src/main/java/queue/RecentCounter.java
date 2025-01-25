package queue;

import java.util.*;

// https://leetcode.com/problems/number-of-recent-calls/
public class RecentCounter {
    LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    public int ping (int t) {
        queue.addLast(t);

        while (!queue.isEmpty() && queue.peekFirst() < t-3000) {
            queue.pollFirst();
        }
        return queue.size();
    }
}
