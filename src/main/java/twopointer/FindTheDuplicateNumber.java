/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3


Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.


Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */

package twopointer;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        // O(N) time | O(1) space
        int duplicate = 0;

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]);

            if (nums[index] < 0) {
                duplicate = index;
                break;
            } else {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicate;
    }
}
