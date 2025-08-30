package design;


import java.util.ArrayList;
import java.util.Iterator;

class MyHashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private ArrayList<Entry>[] buckets = new ArrayList[DEFAULT_CAPACITY];
    private int size = 0;

    public MyHashMap() {}

    public void put(int key, int value) {
        if ( (size + 1) > LOAD_FACTOR * buckets.length) {
            resize();
        }

        int index = indexFor(key);
        if (buckets[index] == null) buckets[index] = new ArrayList<>();

        for (Entry e : buckets[index]) {
            if (e.k == key) {
                e.v = value;
                return;
            }
        }

        buckets[index].add(new Entry(key, value));
        size++;
    }

    public int get(int key) {
        int index = indexFor(key);
        var bucket = buckets[index];
        if (bucket == null) return -1;

        for (Entry e : bucket) {
            if (e.k == key) return e.v;
        }

        return -1;
    }

    public void remove(int key) {
        int index = indexFor(key);
        var bucket = buckets[index];
        if (bucket == null) return;

        Iterator<Entry> it = bucket.iterator();
        while (it.hasNext()) {
            if (it.next().k == key) {
                it.remove();
                size--;
                return;
            }
        }
    }

    private void resize() {
        ArrayList<Entry>[] oldBuckets = buckets;
        ArrayList<Entry>[] newBuckets = new ArrayList[oldBuckets.length * 2];

        for (ArrayList<Entry> oldBucket : oldBuckets) {
            if (oldBucket == null) continue;
            for (Entry e : oldBucket) {
                int idx = Math.floorMod(e.k, newBuckets.length);
                if (newBuckets[idx] == null) newBuckets[idx] = new ArrayList<>();
                newBuckets[idx].add(e);
            }
        }

        buckets = newBuckets;
    }

    private int indexFor(int key) {
        return Math.floorMod(key, buckets.length);
    }

    class Entry {
        int k, v;

        Entry(int k, int v) { this.k = k; this.v = v; };
    }
}


public class DesignHashMap {
}
