package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {

    public static void main(String[] args) {

    }

    public String reorganizeString(String s) {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int[] arr = new int[128];
        for (char ch : s.toCharArray()) {
            arr[ch]++;
        }

        for (int i = 97; i < 128; ++i) {
            if (arr[i] == 0) continue;
            if (arr[i] > (s.length() + 1) / 2) return "";
            pq.offer(new int[]{i, arr[i]});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char)first[0]);

                if (--first[1] > 0) {
                    pq.offer(first);
                }
            } else {
                if (pq.isEmpty()) return "";
                int[] second = pq.poll();
                sb.append((char)second[0]);

                if (--second[1] > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }

        return sb.toString();
    }

}
