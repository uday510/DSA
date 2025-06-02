package design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {

    LinkedHashMap<Integer, Integer> cache;

    public LRUCacheWithLinkedHashMap(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.7f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
