package sort;

import java.util.*;

public class FrequencySort {

    public static void main(String[] args) {
        String s = "cccaaa";

        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.cnt - p1.cnt);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            while (p.cnt > 0) {
                sb.append(p.c);
                --p.cnt;
            }
        }
        return sb.toString();
    }
    static class Pair {
        char c;
        int cnt;

        Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
