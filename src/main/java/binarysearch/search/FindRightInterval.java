package binarysearch.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            arr[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }

        Arrays.sort(arr);
        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            int idx = bs(intervals[i][1], arr);
            if (idx == n) res[i] = -1;
            else res[i] = map.get(arr[idx]);
        }

        return res;
    }

    private int bs(int t, int[] arr) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}
