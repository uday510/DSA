import java.util.HashMap;
import java.util.Map;

public class Solution {

}

class LRUCache {

    Map<Integer, Node> lru;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        lru = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node cur = lru.get(key);

        if (cur == null) return -1;

        remove(cur);
        add(cur);

        return cur.v;
    }

    public void put(int key, int value) {
        Node cur = lru.get(key);

        if (cur != null) {
            remove(cur);
            cur.v = value;
        } else {
            if (lru.size() == capacity) {
                remove(head.next);
            }
            cur = new Node(key, value);
        }

        add(cur);
    }

    private void add(Node node) {
        lru.put(node.k, node);

        Node tailPrev = tail.prev;

        tailPrev.next = node;
        node.prev = tailPrev;

        tail.prev = node;
        node.next = tail;
    }

    private void remove(Node node) {
        lru.remove(node.k);

        node.next = node.prev.next;
        node.prev = node.next.prev;
    }
}

class Node {

    Node prev, next;
    int k, v;

    Node (int k, int v) { this.k = k; this.v = v; }
}