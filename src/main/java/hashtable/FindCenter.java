package hashtable;

import java.util.HashMap;
import java.util.Map;

public class FindCenter {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        int max = 0;

        for (Map.Entry<Integer, Integer> keySet : map.entrySet()) {
            max = Math.max(max, keySet.getValue());
        }

        return max;
    }
}
