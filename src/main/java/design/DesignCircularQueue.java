package design;

class MyCircularQueue {

    private Node head, tail;
    private int cnt;
    private final int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (cnt == capacity) return false;

        Node newNode = new Node(value);
        if (cnt == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        cnt++;
        return true;
    }

    public boolean deQueue() {
        if (head == null) return false;

        head = head.next;
        cnt -= 1;

        return true;
    }

    public int Front() {
        if (cnt == 0) return -1;

        return head.value;
    }

    public int Rear() {
        if (cnt == 0) return -1;

        return tail.value;
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == capacity;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}



public class DesignCircularQueue {
}
