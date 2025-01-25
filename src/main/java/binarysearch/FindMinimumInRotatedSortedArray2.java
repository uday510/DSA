package binarysearch;
 // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
public class FindMinimumInRotatedSortedArray2 {
     public int findMin(int[] nums) {
         int left = 0;
         int right = nums.length - 1;

         while (left < right) {
             int mid = (left + right) >>> 1;

             if (nums[mid] > nums[right]) {
                 left = mid + 1;
             } else if (nums[mid] < nums[right]) {
                 right = mid;
             } else {
                 right--;
             }
         }
         return nums[left];
     }
}
