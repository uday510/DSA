package binarysearch.tool;

import java.util.Arrays;

public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int max = -1;

        while (l < r) {
            int curr = nums[l] + nums[r];
            if (curr < k) l++;
            else r--;
            if (curr < k) max = Math.max(max, curr);
        }

        return max;
    }

}
