package binarysearch.search;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        return bs(nums, target);
    }
    private int bs(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = (l + r) >> 1;

            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }

        return l;
    }

}
