/**
 * You are given two 0-indexed arrays nums and cost consisting each of n positive integers.
 *
 * You can do the following operation any number of times:
 *
 * Increase or decrease any element of the array nums by 1.
 * The cost of doing one operation on the ith element is cost[i].
 *
 * Return the minimum total cost such that all the elements of the array nums become equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,2], cost = [2,3,1,14]
 * Output: 8
 * Explanation: We can make all the elements equal to 2 in the following way:
 * - Increase the 0th element one time. The cost is 2.
 * - Decrease the 1st element one time. The cost is 3.
 * - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
 * The total cost is 2 + 3 + 3 = 8.
 * It can be shown that we cannot make the array equal with a smaller cost.
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], cost = [4,2,8,1,3]
 * Output: 0
 * Explanation: All the elements are already equal, so no operations are needed.
 *
 *
 * Constraints:
 *
 * n == nums.length == cost.length
 * 1 <= n <= 105
 * 1 <= nums[i], cost[i] <= 106
 */
package binarysearch;

public class MinimumCostToMakeArrrayEqual {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};

        long res = minCost(nums, cost);
        System.out.println(res);

    }
        public static long minCost(int[] nums, int[] cost) {
            int ELEMENT_COUNT = 1000002;
            long[] costOfNos = new long[ELEMENT_COUNT];
            for(int i=0;i<nums.length;i++){
                costOfNos[nums[i]] += cost[i];
            }

            long[] prefSum = new long[ELEMENT_COUNT];
            long[] suffSum = new long[ELEMENT_COUNT];
            long ans  = Long.MAX_VALUE;
            long sum = 0;
            for(int i=1;i<ELEMENT_COUNT;i++){
                prefSum[i] = prefSum[i-1] + sum;
                sum += costOfNos[i];
            }

            sum = 0;
            for(int i=ELEMENT_COUNT-2;i>=0;i--){
                suffSum[i] = suffSum[i+1] + sum;
                sum += costOfNos[i];
                ans = Math.min(ans, suffSum[i] + prefSum[i]);
            }
            return ans;

        }
    public static long bruteForce(int[] nums, int[] cost) {
        long res = Long.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            long curr = 0;

            for (int j = 0; j < nums.length; ++j) {
                curr += (long) Math.abs(nums[i] - nums[j]) * cost[j];
            }
            res = Math.min(res, curr);
        }
        return res;
    }
}
