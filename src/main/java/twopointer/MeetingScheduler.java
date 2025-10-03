package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

        int p1 = 0, p2 = 0, n = slots1.length, m = slots2.length;

        while (p1 < n && p2 < m) {
            int st = Math.max(slots1[p1][0], slots2[p2][0]);
            int en = Math.min(slots1[p1][1], slots2[p2][1]);

            if (en - st >= duration) return new ArrayList<>(Arrays.asList(st, st + duration));

            if (slots1[p1][1] < slots2[p2][1]) p1++;
            else p2++;
        }

        return new ArrayList<Integer>();
    }

}
