import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<Integer> lis;

    public int maxEnvelopes(int[][] envelopes) {
        lis = new ArrayList<>();

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < envelopes.length; i++) {
            int num = envelopes[i][1];
            int index = bs(num);
            if (index == lis.size()) lis.add(num);
            lis.set(index, num);
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
 *
 *
 * [3, 2, 1, 5]
 *
 *
 *
 */
