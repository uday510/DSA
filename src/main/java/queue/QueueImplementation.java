package queue;

import java.util.ArrayList;
import java.util.List;

class QueueImplementation<I extends Number> {
    // store elements
    private List<Integer> data;
    // a pointer to indicate the start position
    private int start;

    public QueueImplementation() {
        data = new ArrayList<Integer>();
        start = 0;
    }
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        ++start;
        return true;
    }

    public int Front() {
        return data.get(start);
    }

    public boolean isEmpty() {
        return start >= data.size();
    }

    public static void main(String[] args) {
        QueueImplementation<Number> q = new QueueImplementation<Number>();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
    }

}
