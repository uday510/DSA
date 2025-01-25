package array;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 2, 2, 3};

        int len = removeDuplicates2(nums);
        System.out.println(len);
    }
    public static int removeDuplicates2(int[] nums) {
        // O(n) time, O(1) space
        int j = 1;
        int count = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                ++count;
            } else {
                // reset count
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
