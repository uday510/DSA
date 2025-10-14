import java.util.HashMap;
import java.util.Map;

public class Solution {

    class LRUCache {

        int capacity;
        Node head, tail;

        Map<Integer, Node> lru;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            lru = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = lru.get(key);

            if (node == null) {
                return -1;
            }

            remove(node);
            add(node);

            return node.v;
        }

        public void put(int key, int value) {
            Node node = lru.get(key);

            if (node == null) {
                if (lru.size() == capacity) {
                    remove(head.next);
                }
                node = new Node(key, value);
                add(node);
            } else {
                remove(node);
                add(node);
            }

        }

        private void add(Node node) {
            lru.put(node.k, node);

            Node tailPrev = tail.prev;

            tailPrev.next = node;
            node.prev = tailPrev;
            node.next = tail;
            tail.prev = node;
        }

        private void remove(Node node) {
            lru.remove(node.k);

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    static class Node {
        Node prev, next;
        int k, v;

        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }


}

