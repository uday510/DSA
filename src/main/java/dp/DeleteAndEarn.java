/**
 https://leetcode.com/problems/delete-and-earn/
 */
package dp;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    static Map<Integer, Integer> points;
    static int[] dp;
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3, 4};

        int res = deleteAndEarn(nums);
        System.out.println(res);
    }


    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        points = new HashMap<>();

        for (int num : nums) {
            max = Math.max(num, max);
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        dp = new int[max + 1];
        dp[1] = points.getOrDefault(1, 0);

        for (int idx = 2; idx <= max; ++idx) {
            int pick = points.getOrDefault(idx, 0) + dp[idx - 2];
            int dont = dp[idx - 1];

            dp[idx] = Math.max(pick, dont);
        }

        return dp[max];
    }

    private static int dfs(int[] nums) {

        if (nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        int maxElement = nums[0];
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            points.merge(num, num, Integer::sum);
        }

        dp = new int[maxElement + 1];
        assert points.get(1) != null;
        dp[1] = points.get(1);

        for (int idx = 2; idx <= maxElement; ++idx) {
            int pick = dp[idx - 2] + points.computeIfAbsent(idx, i -> 0);
            int dont = dp[idx - 1];

            dp[idx] = Math.max(pick, dont);
        }

        return dp[maxElement];
    }
//    private static int dfs(int num) {
//        if (num < 0) {
//            return 0;
//        }
//
//        if (num == 1) {
//            return points.getOrDefault(1, 0);
//        }
//
//        if (dp[num] != -1) {
//            return dp[num];
//        }
//
//        int take = points.getOrDefault(num, 0) + dfs(num - 2);
//        int dont = dfs(num - 1);
//
//        return dp[num] = Math.max(take, dont);
//    }
}
