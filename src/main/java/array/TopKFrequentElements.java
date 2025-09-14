package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) freqMap.merge(num, 1, Integer::sum);

        int n = nums.length;
        List<Integer>[] list = new ArrayList[n + 1];

        for (var es : freqMap.entrySet()) {
            int key = es.getKey(), freq = es.getValue();

            if (list[freq] == null) {
                list[freq] = new ArrayList<>();
            }

            list[freq].add(key);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = n; i > -1 && idx < k; --i) {
            if (list[i] != null) {
                for (int num : list[i]) {
                    res[idx++] = num;
                    if (idx == k) return res;
                }
            }
        }

        return res;
    }
}
