/**
 * Description
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.)
 *
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 *
 * Input: intervals = [(2,7)]
 * Output: 1
 * Explanation:
 * Only need one meeting room
 */
package heap;

import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static void main(String[] args) {

    }
    public int minMeetingRooms(List<MeetingRooms.Interval> intervals) {
        intervals.sort(((o1, o2) -> o1.start - o2.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals.getFirst().end);
        for (int i = 1; i < intervals.size(); ++i) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            if (start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(end);
        }

        return pq.size();
    }
}
