package design;

class MyLinkedList {

    private final Node head;
    private final Node tail;
    private int size;

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        Node n = nodeAt(index);
        return (n == null) ? -1 : n.val;
    }

    public void addAtHead(int val) {
        insertBetween(head, head.next, new Node(val));
    }

    public void addAtTail(int val) {
        insertBetween(tail.prev, tail, new Node(val));;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else {
            Node next = nodeAt(index);
            assert next != null;
            insertBetween(next.prev, next, new Node(val));
        }
    }

    public void deleteAtIndex(int index) {
        Node target = nodeAt(index);
        if (target == null) return;
        unlink(target);
    }

    private Node nodeAt(int index) {
        if (index < 0 || index >= size) return null;
        // Bidirectional traversal for efficiency
        if (index < size / 2) {
            Node cur = head.next;
            for (int i = 0; i < index; i++) cur = cur.next;
            return cur;
        } else {
            Node cur = tail.prev;
            for (int i = size - 1; i > index; i--) cur = cur.prev;
            return cur;
        }
    }

    private void insertBetween(Node prev, Node next, Node node) {
        node.prev = prev;
        node.next = next;
        prev.next = node;
        next.prev = node;
        size++;
    }
    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private static class Node {
        int val;
        Node prev, next;
        Node(int v) { this.val = v; }
        Node() {}
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class DesignLinkedList {


}
