package binarysearch.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {

    List<Integer> lis;
    public int maxEnvelopes(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        lis = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int idx = bs(arr[i][1]);
            if (idx == lis.size()) lis.add(arr[i][1]);
            lis.set(idx, arr[i][1]);
        }

        return lis.size();
    }
    private int bs(int target) {
        int l = 0, r = lis.size();

        while (l < r) {
            int m = (l + r) >> 1;
            if (lis.get(m) < target) l = m + 1;
            else r = m;
        }

        return l;
    }

}

/**

 // eg: envelopes = [[4,5],[4,6],[6,7],[2,3],[1,1]]


 Consider an input [[1, 3], [1, 4], [1, 5], [2, 3]].
 If we simply sort and extract the second dimension we get [3, 4, 5, 3], which implies that we can fit three envelopes (3, 4, 5). The problem is that we can only fit one envelope, since envelopes that are equal in the first dimension can't be put into each other.

 In order fix this, we don't just sort increasing in the first dimension - we also sort decreasing on the second dimension, so two envelopes that are equal in the first dimension can never be in the same increasing subsequence.

 Now when we sort and extract the second element from the input we get [5, 4, 3, 3], which correctly reflects an LIS of one.


 */


