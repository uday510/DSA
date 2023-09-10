/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.



Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 */
package Recursion;

import com.google.common.base.Stopwatch;

import java.util.Arrays;

public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int target = 35;
        Stopwatch st = Stopwatch.createStarted();

        int count = combinationSum4(nums, target);
        System.out.println(count);
        System.out.println(st.stop());

    }
    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int combSum = 1; combSum <= target; ++combSum) {
            for (int num : nums) {
                if (combSum - num >= 0) {
                    dp[combSum] += dp[combSum - num];
                } else {
                    break;
                }
            }
        }
        return dp[target];
    }
    public static int combinationSum4(int currSum, int target, int[] nums) {
        if (currSum == target) {
            return 1;
        }
        if (currSum > target) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            int val = combinationSum4(currSum + num, target, nums);
            count += val;
        }
        return count;
    }
}
