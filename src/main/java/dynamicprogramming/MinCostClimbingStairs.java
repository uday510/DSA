/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 *
 * Constraints:
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
package dynamicprogramming;

import java.util.HashMap;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] nums = {10, 15, 20};

        int res = solve(nums);
        System.out.println(res);
    }
    public static int solve(int[] nums) {
       return minCost(nums);
    }
    public static int minCost(int[] cost) {
        int downTwo = 0;
        int downOne = cost[0];

        for (int i = 1; i < cost.length; ++i) {
            int current = Math.min(downOne, downTwo) + cost[i];
            downTwo = downOne;
            downOne = current;
        }
        return Math.min(downOne, downTwo);
    }

    public static int minCostClimbingStairs(int index, int[] cost, HashMap<Integer, Integer> memo) {
        if (index <= 1) {
            return 0;
        }
        // Check if we have already calculated minimumCost(i)
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int downOne = cost[index - 1] + minCostClimbingStairs(index - 1, cost, memo);
        int downTwo = cost[index - 2] + minCostClimbingStairs(index - 2, cost, memo);
        memo.put(index, Math.min(downOne, downTwo));

        return memo.get(index);
    }
    public static int minCostClimbingStairs(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int[] minimumCost = new int[cost.length];

        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < minimumCost.length; ++i) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoStep = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoStep);
        }

        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length - 1];
    }
}
