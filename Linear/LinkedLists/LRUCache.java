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

package Linear.LinkedLists;
import java.util.HashMap;

public class LRUCache {
    static HashMap<Integer, DoublyLinkedListNode> cache;
    int maxSize;
    int currentSize;
    static DoublyLinkedList listOfMostRecent = new DoublyLinkedList();
    public LRUCache(int capacity) {
        this.currentSize = 0;
        this.maxSize =  capacity;
        this.cache = new HashMap<>();
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        int ans = get(10);
        System.out.println(ans);
    }
    public static int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        updateMostRecent(cache.get(key));
        return cache.get(key).value;
    }
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (currentSize == maxSize) {
                evictLeastRecent();
            } else {
                currentSize += 1;
            }
            cache.put(key, new DoublyLinkedListNode(key, value));
        } else {
            replaceKey(key, value);
        }
        updateMostRecent(cache.get(key));
    }
    public int getMostRecentKey() {
        if (listOfMostRecent.head == null) {
            return -1;
        }
        return listOfMostRecent.head.key;
    }
    public void evictLeastRecent() {
        int keyToRemove = listOfMostRecent.tail.key;
        listOfMostRecent.removeTail();
        cache.remove(keyToRemove);
    }
    public static void updateMostRecent(DoublyLinkedListNode node) {
        listOfMostRecent.setHeadTo(node);
    }
    public void replaceKey(int key, int value) {
        if (!this.cache.containsKey(key)) {
            return;
        }
        cache.get(key).value = value;
    }
}
class DoublyLinkedList {
    DoublyLinkedListNode head = null;
    DoublyLinkedListNode tail = null;
    public void setHeadTo(DoublyLinkedListNode node) {
        if (head == node) {
        } else if (head == null) {
            head = node;
            tail = node;
        } else if (head == tail) {
            tail.prev = node;
            head = node;
            head.next = tail;
        } else {
            if (tail == node) {
                removeTail();
            }
            node.removeBindings();
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
    public void removeTail() {
        if (tail == null) {
            return;
        }
        if (tail == head) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
}
class DoublyLinkedListNode {
    int key;
    int value;
    DoublyLinkedListNode prev = null;
    DoublyLinkedListNode next = null;
    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public void removeBindings() {
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        prev = null;
        next = null;
    }
}

