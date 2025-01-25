package string;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class Interview {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) {

//        print("7885025909");

//        dfs(0, 5, 0, new int[]{3, 30, 34, 5, 9});
//        System.out.println(pq.peek());
        print3(new int[]{3, 30, 34, 5, 9});
    }

    private static void print3(int[] arr) {

       for (int i = 0; i < arr.length; ++i) {
           int num = arr[i];
           for (int j = 0; j < arr.length; ++j) {
               int tmp = arr[j];
               if (i == j) {
                   continue;
               }
               while (tmp > 0) {
                   num *= 10;
                   num += (tmp % 10);
                   tmp /= 10;
               }
           }
           System.out.println(num);
       }
    }
    private static void print(String string) {
        var map = new TreeMap<Integer, Integer>();

        for (char ch : string.toCharArray()) {
            int num = ch - '0';
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }

            map.put(num, map.get(num) + 1);
        }

        for (var keySet : map.entrySet()) {
            System.out.println(keySet.getKey() + " " + keySet.getValue());
        }

    }
}
