package string;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        System.out.println(longestDiverseString(7, 1, 0));
    }
    private static String longestDiverseString(int a, int b, int c) {
        var sb = new StringBuilder();
        var pq = new PriorityQueue<int[]>((x, y) -> y[1] - x[1]);
        addKeys(pq, a, b, c);

        while (!pq.isEmpty()) {
            var peek = pq.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == peek[0] && sb.charAt(sb.length() - 2) == peek[0]) {
                if (pq.isEmpty()) {
                    break;
                }
                var next = pq.poll();
                sb.append((char) next[0]);
                next[1]--;
                if (next[1] > 0) {
                    pq.offer(next);
                }
                pq.offer(peek);
            } else {
                sb.append((char) peek[0]);
                peek[1]--;
                if (peek[1] > 0) {
                    pq.offer(peek);
                }
            }
        }
        return sb.toString();
    }
    private static void addKeys(PriorityQueue<int[]> pq, int a, int b, int c) {
      if (a > 0)
          pq.offer(new int[]{'a', a});
      if (b > 0)
          pq.offer(new int[]{'b', b});
      if (c > 0)
          pq.offer(new int[]{'c', c});

    }
}
