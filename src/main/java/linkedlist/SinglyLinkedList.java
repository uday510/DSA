package linkedlist;

public class SinglyLinkedList<T> {
    private static class Node<T> {
        T val;
        Node<T> next;
        Node(T val) {
            this.val = val;
        }
    }

    private Node<T> head, tail;
    private int size;

    public void addFirst(T val) {
        Node<T> node = new Node<>(val);
        node.next = head;
        head = node;
        if (tail == null) tail = node;

    }
}
