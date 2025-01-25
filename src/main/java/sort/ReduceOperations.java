package sort;

import java.util.Arrays;

public class ReduceOperations {
    public static void main(String[] args) {

    }
    public int reductionOperations(int[] nums) {
        sort(nums);
        int ops = 0;
        int prev = nums[0];
        int N = nums.length;

        for (int i = 0; i < N; ++i) {
            int curr = nums[i];
            if (prev != curr) {
                ops += i;
            }
            prev = curr;
        }
        return ops;
    }
    public void sort(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}
