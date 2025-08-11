package binarysearch.rotatedarray;

public class FindMinimumInRotatedSortedArray2 {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) >> 1;

            if (nums[m] > nums[r]) l = m + 1;
            else if (nums[m] < nums[r]) r = m;
            else r--;
        }

        return nums[l];
    }

}
