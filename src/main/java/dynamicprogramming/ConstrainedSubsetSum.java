package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstrainedSubsetSum {
    public static void main(String[] args) {
        int[] nums = {10, -2, -10, -5, 20};
        int k = 2;

        System.out.println(constrainedSubsetSum(nums, k));
    }
    public static int constrainedSubsetSum(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; ++i) {
            int tmp = 0;
            int j = i - k;

            while (j < i) {
                if (j > -1) tmp = Math.max(dp[j], tmp);
                j++;
            }

            dp[i] = nums[i] + tmp;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
