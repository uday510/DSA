package binarysearch.search;

public class BinarySearch {

    private int bisectLeft(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = (l + r) >> 1;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }

        return -1;
    }

    private int bs(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}
