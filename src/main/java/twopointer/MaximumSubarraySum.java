/*
You are given an integer array nums and an integer k.
Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.


Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 105
 */
package twopointer;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = { 1,5,4,2,9,9,9 };
        int k = 3;
        System.out.println(maximumSubarraySum(arr, k));
    }
    public static long maximumSubarraySum(int[] nums, int k) {

        /*
        1. Create a window of size k
        2. Add the elements of the window
        3. If the window size is less than k, then add the next element
        4. If the window size is equal to k, then remove the first element and add the next element
        5. Keep track of the maximum sum
        6. Return the maximum sum
         */


        int left = 0;
        long sum = 0, max = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; ++right) {

            while (set.contains(nums[right])) { // if the element is already present in the set, then remove the first element and add the next element
                set.remove(nums[left]); // remove the first element
                sum -= nums[left]; // subtract the first element from the sum
                ++left;
            }

            set.add(nums[right]); // add the element to the set
            sum += nums[right]; // add the element to the sum

            if (right - left + 1 == k) { // if the window size is equal to k, then remove the first element and add the next element
                max = Math.max(max, sum);
                set.remove(nums[left]); // remove the first element
                sum -= nums[left]; // subtract the first element from the sum
                ++left;
            }
        }

        return max;
    }
}
