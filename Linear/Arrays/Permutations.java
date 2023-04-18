/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 */
package Linear.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        solve(0, nums, permutations);

        System.out.println(permutations);
    }
    public static void solve(int i, int[] nums, List<List<Integer>> permutations) {
        // O(n*n!) time | O(n*n!) space
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int idx = 0; idx < nums.length; idx++) {
                list.add(nums[idx]);
            }
            permutations.add(list);
            return;
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(i, j, nums);
                solve(i + 1, nums, permutations);
                swap(i, j, nums);
            }
        }
    }
    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

 }
