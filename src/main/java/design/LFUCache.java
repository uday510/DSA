package design;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> lfu;
    private Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.lfu = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = lfu.get(key);

        if (node == null) return -1;

        updateFreq(node);

        return node.key;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = lfu.get(key);

        if (node != null) {
            node.value = value;
            updateFreq(node);

            return;
        }

        if (lfu.size() == capacity) {
            DLL minDLL = freqMap.get(minFreq);
            if (minDLL != null) {
                Node evicted = minDLL.evictHedaNext();
                if (evicted != null) lfu.remove(evicted.key);
                if (minDLL.isEmpty()) freqMap.remove(minFreq);
            }
        }

        node = new Node(key, value);
        minFreq = 1;

        lfu.put(node.key, node);
        freqMap.computeIfAbsent(minFreq, _ -> new DLL()).add(node);
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldDLL = freqMap.get(oldFreq);

        if (oldDLL.size == 0) return;

        oldDLL.remove(node);

        if (oldDLL.isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) minFreq++;
        }

        freqMap.computeIfAbsent(++node.freq, _ -> new DLL()).add(node);
    }

    static class Node {
       Node prev, next;
       int key, value, freq;

        Node (int key, int  value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

    }


    static class DLL {
        Node head, tail;
        int size;

        DLL () {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void add(Node node) {

            Node tailPrev = tail.prev;

            tailPrev.next = node;
            node.prev = tailPrev;

            node.next = tail;
            tail.prev = tailPrev;
        }

        Node remove(Node node) {
            if (node == null || size == 0) return null;

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;

            return node;
        }

        Node evictHedaNext() {
            if (size == 0) return null;

            return remove(tail.prev);
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

}



