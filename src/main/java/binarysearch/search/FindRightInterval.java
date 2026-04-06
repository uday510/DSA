package binarysearch.search;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {

    public int[] findRightInterval(int[][] arr) {

        int n = arr.length;
        int[][] st = new int[n][2];

        for (int i = 0; i < n; i++) {
            st[i][0] = arr[i][0];
            st[i][1] = i;
        }

        Arrays.sort(st, Comparator.comparing(k -> k[0]));

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = bs(st, arr[i][1]);
            res[i] = idx == n ? -1 : st[idx][1];
        }

        return res;
    }

    private int bs(int[][] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {

            int m = l + (r - l) / 2;

            if (arr[m][0] < target) l = m + 1;
            else r = m;
        }

        return l;
    }


}
