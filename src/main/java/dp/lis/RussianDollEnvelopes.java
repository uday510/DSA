package dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] en) {
        int n = en.length;
        Arrays.sort(en, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> lis = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = en[i][1];
        }

        for (int i = 0; i < n; ++i) {
            int index = bisectLeft(lis, arr[i]);
            if (index == lis.size()) lis.add(arr[i]);
            lis.set(index, arr[i]);
        }

        return lis.size();
    }

    private int bisectLeft(List<Integer> lis, int target) {
        int leftIdx = 0, rightIdx = lis.size();

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >> 1;
            if (lis.get(midIdx) < target) leftIdx = midIdx + 1;
            else rightIdx = midIdx;
        }
        return leftIdx;
    }

}
