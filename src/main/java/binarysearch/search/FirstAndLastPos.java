package binarysearch.search;

import binarysearch.FindFirstAndLastPosition;

public class FirstAndLastPos {

    public int[] searchRange(int[] nums, int target) {
        int l = bs(nums, target);
        if (l >= nums.length || nums[l] != target) return new int[]{-1, -1};
        int r = bs(nums, target + 1) - 1;
        return new int[]{l, r};
    }

    private int bs (int[] nums, int target) {
        return FindFirstAndLastPosition.binarySearch(nums, target);
    }

}
