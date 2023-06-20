package Array.Arrays;

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * Example 2:
 *
 * Input: nums = [5], k = 9
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 */
public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int res = solve(arr, k);
        System.out.println(res);
    }
    public static int solve(int[] nums, int k) {
        int res = 0, prefixSum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            int rem = prefixSum % k;
            if (rem < 0) rem += k;

            if (hashMap.containsKey(rem))
                res += hashMap.get(rem);

            hashMap.put(rem, hashMap.getOrDefault(rem, 0) + 1);
        }

        return res;
    }
}
