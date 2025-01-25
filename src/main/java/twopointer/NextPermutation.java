/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
package twopointer;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
    public static void nextPermutation(int[] nums) {
        /**
         * 1. Start from the right most element and find the first element that is smaller than the element after it
         * 2. Swap the element with the element that is just larger than it
         * 3. Reverse the array from the element after the element that is just larger than it
         * 4. If no such element exists, reverse the entire array
         */
        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2; // Start from second last element

        // Find first element that is smaller than the element after it
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j); // Swap the element with the element that is just larger than it
        }
        reverse(nums, i + 1, nums.length - 1); // Reverse the array from the element after the element that is just larger than it
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
