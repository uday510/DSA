package sort;

import java.util.Arrays;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length < 1) return true;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] prev = intervals[i - 1];
            int[] curr = intervals[i];

            if (curr[0] < prev[1]) return false;
        }

        return true;
    }
}
