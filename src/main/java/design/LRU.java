package design;

import java.util.*;

public class LRU extends LinkedHashMap<Integer, Integer> {
    private final int capacity;
    public LRU(int capacity) {
        super(capacity, 0.7f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    public void put(int key, int val) {
        super.put(key, val);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
