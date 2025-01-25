package binarysearch;

import java.util.Arrays;

public class CountFairPairs {
    public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};
        System.out.println(countFairPairs(nums, 3, 6));
    }
    private static long countFairPairs(int[] nums, int lower, int higher) {
        Arrays.sort(nums);
        int n = nums.length;
        long pairs = 0;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (nums[i] + nums[j] < lower) {
                i++;
            } else if (nums[i] + nums[j] > higher) {
                j--;
            } else {
                int left = i;
                int right = j;
                while (left < j && nums[left] == nums[i]) {
                    left++;
                }
                while (right > i && nums[right] == nums[j]) {
                    right--;
                }
                pairs += (long)(left - i) * (j - right);
                i = left;
                j = right;
            }
        }
        return pairs;
    }
}
