package famousalgorithms;

import java.util.Arrays;

public class DNF { // Dutch National Flag
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 1, 0, 1};

        int[] ans = solve(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solve(int[] nums) {
        // O(N) time | O(1) space

        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(p0, curr, nums);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(curr, p2, nums);
                p2--;
            } else curr++;
        }
        return nums;
    }
    public static void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
