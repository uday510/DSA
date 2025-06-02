/*
You are given two 0-indexed integer arrays nums and multipliers of size n and m respectively, where n >= m.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (0-indexed) you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Note that multipliers[0] corresponds to the first operation, multipliers[1] to the second operation, and so on.
Remove x from nums.
Return the maximum score after performing m operations.



Example 1:

Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.
Example 2:

Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
Output: 102
Explanation: An optimal solution is as follows:
- Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
- Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
- Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
- Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
- Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
The total score is 50 + 15 - 9 + 4 + 42 = 102.


Constraints:

n == nums.length
m == multipliers.length
1 <= m <= 300
m <= n <= 105
-1000 <= nums[i], multipliers[i] <= 1000
 */
package dp;

public class MaximumScore {
    public static void main(String[] args) {
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};
        System.out.println(maximumScore(nums, multipliers));
    }
    public static int maximumScore(int[] nums, int[] multipliers) {

//        return maximumScore(0, 0, nums, multipliers, new Integer[multipliers.length][multipliers.length]);
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i > -1; --i) {
            for (int left = i; left > -1; --left) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(mult * nums[left] + dp[i + 1][left + 1], mult * nums[right] + dp[i + 1][left]);
            }
        }
        return dp[0][0];
    }
    public static int maximumScore(int m, int left, int[] nums, int[] multipliers, Integer[][] dp) {

        if (m == multipliers.length) {
            return 0;
        }

        if (dp[m][left] != null) {
            return dp[m][left];
        }

        int right = nums.length - 1 - (m - left);

        int pickLeft = multipliers[m] * nums[left]  + maximumScore(m + 1, left + 1, nums, multipliers, dp);
        int pickRight = multipliers[m] * nums[right] + maximumScore(m + 1, left, nums, multipliers, dp);

        dp[m][left] = Math.max(pickLeft, pickRight);

        return dp[m][left];
    }
}
