package hashtable;

import java.util.HashMap;
import java.util.Map;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {

    }

    static class TimeMap {
        TimeMap timeMap;
        Map<String, Map<String, Integer>> hm;
        public TimeMap() {
            timeMap = new TimeMap();
            hm = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!hm.containsKey(key)) {
                hm.put(key, new HashMap<>());
            }
            hm.get(key).put(value, timestamp);
        }

        public String get(String key, int timestamp) {
            Map<String, Integer> map = hm.get(key);

            if (map == null) return "";

            for (String s : map.keySet()) {
                if (map.get(s) <= timestamp) {
                    return s;
                }
            }
            return "";
        }
    }
}
