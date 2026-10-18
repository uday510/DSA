package design;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

class MyHashMap <K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = (LinkedList<Entry<K,V>>[]) new LinkedList[DEFAULT_CAPACITY];
    }

    public void put(K key, V value) {
        int index = indexFor(key);
        if (buckets[index] == null) buckets[index] = new LinkedList<>();
        for (Entry<K, V> e : buckets[index]) {
            if (Objects.equals(e.k, key)) {
                e.v = value;
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
        if (size > LOAD_FACTOR * buckets.length) resize();
    }

    public V get(K key) {
        var b = buckets[indexFor(key)];
        if (b == null) return null;
        for (Entry<K, V> e : b) if (Objects.equals(e.k, key)) return e.v;
        return null;
    }

    public V remove(K key) {
        var b = buckets[indexFor(key)];
        if (b == null) return null;

        Iterator<Entry<K, V>> it = b.iterator();
        while (it.hasNext()) {
            Entry<K, V> e = it.next();
            if (Objects.equals(e.k, key)) {
                it.remove();
                size--;
                return e.v;
            }
        }
        return null;
    }

    private int indexFor(K key) {
        return key == null ? 0 : Math.floorMod(key.hashCode(), buckets.length);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Entry<K, V>>[] old = buckets;
        buckets = (LinkedList<Entry<K,V>>[]) new LinkedList[old.length * 2];

        for (var o : old) {
            if (o == null) continue;
            for (Entry<K, V> e : o) {
                int i = indexFor(e.k);
                if (buckets[i] == null) buckets[i] = new LinkedList<>();
                buckets[i].add(e);
            }
        }
    }

    private static class Entry<K, V> {
       final K k; V v;

        Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}


