/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.



Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104

 */
package binarysearch;

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,2,2};
        int target = 1;
        System.out.println(search(nums, target));
    }
    public static boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int midIdx = left + (right - left) / 2;

            if (nums[midIdx] == target || nums[left] == target || nums[right] == target) {
                return true;
            }

            if (nums[midIdx] < nums[left]) {
                if (target > nums[midIdx] && target < nums[left]) {
                    left = midIdx + 1;
                }
                else {
                    right = midIdx - 1;
                }
            }
            else if (nums[midIdx] > nums[left]) {
                if (target > nums[left] && target < nums[midIdx]) {
                    right = midIdx - 1;
                }
                else {
                    left = midIdx + 1;
                }
            }
            else {
                left++; // nums[midIdx] == nums[left]
            }
        }
        return false;
    }
}
