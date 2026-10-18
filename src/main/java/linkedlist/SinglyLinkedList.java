package linkedlist;

import java.util.Objects;

public class SinglyLinkedList<T> {

    private static class Node<T> {
        T val;
        Node<T> next;
        Node(T val) { this.val = val; }
    }

    private Node<T> head, tail;
    private int size;

    public void insertAtBeginning(T val) {
        Node<T> node = new Node<>(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public void insertAtEnd(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insertAt(int pos, T value) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("pos invalid");
        }

        if (pos == 0) { insertAtBeginning(value); return; }
        if (pos == size) { insertAtEnd(value); return; }

        Node<T> prev = nodeAt(pos - 1);
        Node<T> node = new Node<>(value);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public boolean deleteByValue(T value) {
        Node<T> dummy = new Node<>(null);
        dummy.next = head;
        Node<T> prev = dummy;

        while (prev.next != null && !Objects.equals(prev.next.val, value))
            prev = prev.next;

        if (prev.next == null) return false;

        if (prev.next == tail) tail = (prev == dummy) ? null : prev;
        prev.next = prev.next.next;
        head = dummy.next;
        size--;
        return true;
    }

    public T deleteAt(int pos) {
        if (pos < 0 || pos >= size)
            throw new IndexOutOfBoundsException();

        Node<T> removed;
        if (pos == 0) {
            removed = head;
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node<T> prev = nodeAt(pos - 1);
            removed = prev.next;
            prev.next = removed.next;
            if (removed == tail) tail = prev;
        }

        return removed.val;
    }

    private Node<T> nodeAt(int pos) {
        Node<T> cur = head;
        for (int i = 0; i < pos; i++)
            cur = cur.next;

        return cur;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<T> cur = head; cur != null; cur = cur.next)
            sb.append(cur.val).append(" -> ");

        return sb.append("null").toString();
    }

    static void main() {


        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAt(2, 15);

        System.out.println(list);

        list.deleteByValue(15);
        System.out.println(list);

        list.deleteAt(1);
        list.insertAtEnd(30);
        System.out.println(list);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        System.out.println(list2);
        try { list2.deleteAt(0); }
        catch (IndexOutOfBoundsException e) { System.out.println("caught: " + e.getMessage()); }
    }

}
