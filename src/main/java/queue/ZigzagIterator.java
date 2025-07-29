package queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

    Queue<Iterator<Integer>> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<>();

        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> curr = queue.poll();
        assert curr != null;
        int result = curr.next();
        if (curr.hasNext()) queue.offer(curr);
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}