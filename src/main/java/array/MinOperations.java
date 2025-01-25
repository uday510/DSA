/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.



Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
 */
package array;

import java.util.Arrays;

public class MinOperations {
    public static void main(String[] args) {

        int[] nums = {3,2,20,1,1,3};

        System.out.println(minOperations(nums, 10));

    }
    public static int minOperations(int[] nums, int x) {
        int res = Integer.MAX_VALUE;

        int n = nums.length;
        int[] pf = new int[n];
        pf[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            pf[i] = nums[i] + pf[i-1];
        }

        System.out.println(Arrays.toString(pf));

        int[] sf = new int[n];
        sf[n-1] = nums[n-1];

        for (int i = n - 2; i > -1; --i) {
            sf[i] = nums[i] + sf[i+1];
        }
        System.out.println(Arrays.toString(sf));

        for (int i = 0; i < n; ++i) {

            if (pf[i] == x) {
                res = Math.min(i+1, res);
            }
            if (sf[i] == x) {
                res = Math.min(n - i - 1, res);
            }

            if (sf[i] + pf[i] == x) {
                res = Math.min(i+1 + n-1, res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
