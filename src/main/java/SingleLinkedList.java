

/**
 *
 *
 * Create a singly linked list. Insert a node at the beginning,
 * at the end, and at a specific position. Delete a node by value and by position.
 * Traverse and display all elements in the list.
 */

public class SingleLinkedList {

    private static class Node {
        Node next;
        int value;
        Node (int value) {
            this.value = value;
        }
    }

    private Node head, tail;
    private int size;

    public void insertAtBeginning(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public void insertAtEnd(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void insertAt(int pos, int val) {
        if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException("invalid pos");

        if (pos == 0) { insertAtBeginning(val); return; }
        if (pos == size) { insertAtEnd(val); return; }

        Node prev = nodeAt(pos - 1);
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }
    public boolean deleteByValue(int val) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (prev.next != null && prev.next.value != val) {
            prev = prev.next;
        }

        // 0 1 2 3 4 5
        // 0 1
        if (prev.next == null) return false;
        if (prev.next == tail) tail = (prev == dummy) ? null : prev;

        prev.next = prev.next.next;
        head = dummy.next;
        size--;
        return true;
    }

    public int deleteAt(int pos) {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException("invalid pos");

        Node toBeRemoved;
        if (pos == 0) {
            toBeRemoved = head;
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node prev = nodeAt(pos - 1);
            toBeRemoved = prev.next;
            prev.next = toBeRemoved.next;
            if (toBeRemoved == tail) tail = prev;
        }
        size--;
        return toBeRemoved.value;
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.value).append(" -> ");
        }
        sb.append("null");
        System.out.println(sb);
    }

    private Node nodeAt(int pos) {
        Node curNode = head;
        for (int i = 0; i < pos; i++) curNode = curNode.next;
        return curNode;
    }

    static void main() {

        SingleLinkedList list = new SingleLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAt(2, 15);
        list.display();

        list.deleteByValue(15);
        list.display();

        list.deleteAt(0);
        list.display();

        list.deleteAt(1);
        list.insertAtEnd(30);
        list.display();
    }
}


// 1 2 3 4 5