package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {

    private int[] nums;
    private int n;

    /**
     * Solves the K-Sum problem.
     * 
     * @param nums   Input array of integers
     * @param target Target sum
     * @return A list of all unique quadruplets that sum up to the target
     */
    public List<List<Integer>> kSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums);
        this.nums = nums;
        this.n = nums.length;

        return dfs(0, 4, target);
    }

    /**
     * Recursively solves K-Sum problem by reducing it to 2-sum.
     *
     * @param index  Starting index
     * @param k      Number of elements to sum
     * @param target Target sum
     * @return List of combinations of k numbers that sum to target
     */
    private List<List<Integer>> dfs(int index, int k, long target) {
        List<List<Integer>> result = new ArrayList<>();

        // Base case: use two-pointer approach
        if (k == 2) {
            return twoSum(index, target);
        }

        for (int i = index; i <= n - k; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; // Skip duplicates

            List<List<Integer>> subLists = dfs(i + 1, k - 1, target - nums[i]);

            for (List<Integer> sub : subLists) {
                List<Integer> combination = new ArrayList<>();
                combination.add(nums[i]);
                combination.addAll(sub);
                result.add(combination);
            }
        }

        return result;
    }

    /**
     * Two-pointer 2-sum implementation.
     *
     * @param start  Starting index
     * @param target Target sum
     * @return List of unique pairs that sum to target
     */
    private List<List<Integer>> twoSum(int start, long target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start, right = n - 1;

        while (left < right) {
            long sum = (long) nums[left] + nums[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                result.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) left++;     // Skip duplicates
                while (left < right && nums[right] == nums[right + 1]) right--; // Skip duplicates
            }
        }

        return result;
    }
}