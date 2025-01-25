package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class MinOperations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6};

        System.out.println(minOperations(nums));

    }

    public static int minOperations(int[] nums) {
        TreeSet<Integer> unique = new TreeSet<>();
        int N = nums.length;

        for (int num : nums) {
            unique.add(num);
        }

        int maxWindow = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int num : unique) {
            queue.add(num);
            int min = num - N + 1;

            while (!queue.isEmpty() && queue.peek() < min) {
                queue.poll();
            }
            maxWindow = Math.max(maxWindow, queue.size());
        }

        return N - maxWindow;
    }
}
