/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0


Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
 */
package slidingwindow;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;

        int res = numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;

        long i = 0, j = 0, n = nums.length, prod = 1, res = 0;

        for (; j < n; ++j) {
            prod *= nums[(int) j];
            while (i <= j && prod >= k) prod /= nums[(int) i++];
            res += j - i + 1;
        }
        return (int) res;
    }
}
