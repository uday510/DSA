package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinimumPushes {
    public static void main(String[] args) {
       String word = "geeks";
       System.out.println(minimumPushes(word));
    }
    public static int minimumPushes(String word) {
       Map<Character, Integer> map = new HashMap<>();

       for (char c : word.toCharArray()) {
           map.put(c, map.getOrDefault(c, 0) + 1);
       }

       PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

       pq.addAll(map.values());

       int index = 0;
       int count = 0;

       while (!pq.isEmpty()) {

           // index/8 + 1 is the number of pushes required to push the ith character to the end of the string and then push the next character, * pq.poll() is the number of characters of ith type
           count += (index/8 + 1) * pq.poll();
           ++index;
       }
       return count;
    }

}
