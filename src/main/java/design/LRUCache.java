/**
 *

 Implement an LRUCache class for a Least Recently Used (LRU) cache. The class should support:

 Inserting key-value pairs with the insertKeyValuePair method.
 Retrieving a key's value with the getValueFromKey method.
 Retrieving the most recently used (the most recently inserted or retrieved) key with the getMostRecentKey method.

 Each of these methods should run in constant time.

 Additionally, the LRUCache class should store a maxSize property set to the size of the cache, which is passed in as an argument during
 instantiation. This size represents the maximum number of key-value pairs that the cache can store at once. If a key-value pair is inserted
 in the cache when it has reached maximum capacity, the least recently used key-value pair should be evicted from the cache and no longer retrievable;
 the newly added key-value pair should effectively replace it.

 Note that inserting a key-value pair with an already existing key should simply replace the key's value in the cache with the new value and shouldn't
 evict a key-value pair if the cache is full. Lastly, attempting to retrieve a value from a key that isn't in the cache should return None / null.
 Sample Usage

 // All operations below are performed sequentially.
 LRUCache(3): - // instantiate an LRUCache of size 3
 insertKeyValuePair("b", 2): -
 insertKeyValuePair("a", 1): -
 insertKeyValuePair("c", 3): -
 getMostRecentKey(): "c" // "c" was the most recently inserted key
 getValueFromKey("a"): 1
 getMostRecentKey(): "a" // "a" was the most recently retrieved key
 insertKeyValuePair("d", 4): - // the cache had 3 entries; the least recently used one is evicted
 getValueFromKey("b"): None // "b" was evicted in the previous operation
 insertKeyValuePair("a", 5): - // "a" already exists in the cache so its value just gets replaced
 getValueFromKey("a"): 5
 */

package design;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev;
    int key;
    int val;
    Node next;

    Node (int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);

        remove(node);
        addToTail(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            node.val = value;
            addToTail(node);
            return;
        }

        if (cache.size() >= capacity) {
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addToTail(newNode);
        cache.put(key, newNode);
    }

    private void addToTail(Node node) {
        Node tailPrev = tail.prev;

        tailPrev.next = node;
        node.prev = tailPrev;
        tail.prev = node;
        node.next = tail;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}