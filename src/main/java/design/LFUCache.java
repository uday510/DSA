package design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    final int capacity;
    int curSize;
    int minFreq;
    Map<Integer, Node> lru;
    Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;

        lru = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = lru.get(key);
        if (node == null) return -1;

        updateNodeFreq(node);
        return node.v;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (lru.containsKey(key)) {
            Node node = lru.get(key);
            node.v = value;
            updateNodeFreq(node);
        } else {
            if (curSize == capacity) {
                DLL list = freqMap.get(minFreq);
                if (list != null && !list.isEmpty()) {
                    Node nodeToRemove = list.head.next;
                    list.remove(nodeToRemove);
                    lru.remove(nodeToRemove.k);
                    curSize--;
                    if (list.isEmpty()) {
                        freqMap.remove(minFreq);
                    }
                }
            }

            Node newNode = new Node(key, value);
            lru.put(key, newNode);
            DLL list = freqMap.get(1);
            if (list == null) {
                list = new DLL();
                freqMap.put(1, list);
            }

            list.add(newNode);
            curSize++;
            minFreq = 1;
        }
    }

    private void updateNodeFreq(Node node ) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        DLL newList = freqMap.get(node.freq);
        if (newList == null) {
            newList = new DLL();
            freqMap.put(node.freq, newList);
        }
        newList.add(node);
    }

    private class Node {
        int k, v;
        int freq;
        Node prev, next;

        Node (int k, int v) {
            this.k = k;
            this.v = v;
            this.freq = 1;
        }
    }

    private class DLL {
        Node head, tail;

        DLL () {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            Node tailPrev = tail.prev;
            tailPrev.next = node;
            node.prev = tailPrev;

            node.next = tail;
            tail.prev = node;
        }

        void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;

            if (prevNode != null) prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode;

            node.prev = null;
            node.next = null;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }
}
