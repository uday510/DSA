/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> res = getSubsets(nums, nums.length - 1);
        System.out.println(res);
    }
    public static List<List<Integer>> solve(int[] nums) {
        // O(N*2^N) time | O(N*2^N) space

//        return getSubsets(nums, nums.length - 1);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i = 0; i < nums.length; ++i) {
            int length = subsets.size();
            for (int j = 0; j < length; ++j) {
                List<Integer> currSubset = new ArrayList<>(subsets.get(j));
                currSubset.add(nums[i]);
                subsets.add(currSubset);
            }
        }
        return subsets;
    }
    public static List<List<Integer>> getSubsets(int[] nums, int idx) {
        // O(N*2^N) time | O(N*2^N) space
        if (idx < 0) {
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int num = nums[idx];

        List<List<Integer>> subsets = getSubsets(nums, idx-1);
        int length = subsets.size();
        for (int i = 0; i < length; ++i) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(num);
            subsets.add(currentSubset);
        }
        return subsets;
    }
}
