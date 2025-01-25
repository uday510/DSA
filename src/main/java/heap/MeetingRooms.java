/**
 * Given an array of meeting time intervals consisting of start and
 * end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation:
 * (0,30), (5,10) and (0,30),(15,20) will conflict
 *
 *
 * Input: intervals = [(5,8),(9,15)]
 * Output: true
 * Explanation:
 * Two times will not conflict
 */
package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRooms {
    public static void main(String[] args) {
        List<List<Interval>> intervals = new ArrayList<>();
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(((o1, o2) -> o1.end - o2.end));

        for (int i = 1; i < intervals.size(); ++i) {
            int currStart = intervals.get(i).end;
            int prevEnd = intervals.get(i-1).start;

            if (currStart < prevEnd) return false;
        }

        return true;
    }
    static class Interval {
        int start, end;
        Interval(int start, int end) {
         this.start = start;
         this.end = end;
        }
    }
}
