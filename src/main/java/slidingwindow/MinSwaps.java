package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MinSwaps {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,0,0};
        System.out.println(minSwaps(arr));
    }
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int ones = (int) Arrays.stream(nums).filter(i -> i == 1).count();

        Queue<Integer> queue = new ArrayDeque<>();
        int res = (int) 1e9;

        for (int i = 0; i < ones; ++i) {
            if (nums[i] == 1) {
                queue.add(i);
            }
        }

        res = Math.min(res, queue.size());
        for (int i = ones; i < n + ones; ++i) {
            if (nums[i] == 1) {
                queue.add(i);
            }
            if (nums[(i - ones) % n] == 1) {
                queue.poll();
            }
            res = Math.min(res, queue.size());
        }
        return res;
    }
}
