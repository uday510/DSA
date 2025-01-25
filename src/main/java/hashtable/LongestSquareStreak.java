package hashtable;

import java.util.HashSet;

public class LongestSquareStreak {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18};
        System.out.println(longestSquareStreak(arr));
    }
    private static int longestSquareStreak(int[] arr) {
        var set = new HashSet<Long>();

        for (int num : arr)
            set.add((long) num);

        int max = 0;

        for (int num : arr) {
            long curr = (long) Math.pow(num, 0.5);

            if (set.contains(curr))
                continue;

            int count = 0;
            while (set.contains(curr)) {
                count++;
                curr = (long) Math.pow(curr, 2);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
