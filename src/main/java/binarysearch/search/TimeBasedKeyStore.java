package binarysearch.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyStore {

}

class TimeMap {

    Map<String, List<Pair<String, Integer>>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> list = hm.get(key);

        timestamp++;

        if (list == null) return "";

        int l = 0;
        int r = list.size();

        while (l < r) {
            int m = (l + r) >> 1;
            if (list.get(m).v < timestamp) l = m + 1;
            else r = m;
        }

        if (l - 1 < 0 || l - 1 >= list.size()) return "";

        return list.get(l - 1).k;
    }

    class Pair<K, V> {
        K k;
        V v;

        Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

}
class TimeMapBruteForce {

    Map<String, Map<String, Integer>> hm;

    public TimeMapBruteForce() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, x -> new HashMap<>()).put(value, timestamp);
    }

    public String get(String key, int timestamp) {
        Map<String, Integer> map = hm.get(key);

        if (map == null) return "";

        int prev = Integer.MIN_VALUE;
        String res = "";
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String k = e.getKey();
            int v = e.getValue();

            if (v <= timestamp && v > prev) {
                prev = v;
                res = k;
            }
        }

        return res;
    }
}

