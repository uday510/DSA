/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

 */
package binarysearch;

public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target  = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int first = binarySearch(nums, target);
        if (first >= N || nums[first] != target) {
            return new int[] {-1, -1};
        }

        int last = binarySearch(nums, target+1)-1;
        return new int[] {first, last};
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int midIdx = (left + right) >> 1;

            if (array[midIdx] < target) {
                left = midIdx + 1;
            } else {
                right = midIdx;
            }
        }
        return left;
    }
}
