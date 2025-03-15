package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        int target = 0;

        List<List<Integer>> res = fourSum(nums, target);
        for (var list : res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums, target, 0, 3);
    }
    private static List<List<Integer>> dfs(int[] nums, long target, int i, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int left = i;
            int right = nums.length - 1;

            while (left < right) {
                long sum = (long) nums[left] + (long) nums[right];
                if (sum < target) left++;
                else if (sum > target) right--;
                else {
                    res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
            return res;
        }

        for (int idx = i; idx < (nums.length - k - 1); ++idx) {
            if (idx > 0 && ( nums[idx] == nums[idx - 1])) continue;
            List<List<Integer>> list = dfs(nums, target - nums[idx], idx + 1, k - 1);
            for (List<Integer> subList : list) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[idx]);
                temp.addAll(subList);
                res.add(temp);
            }
        }
        return res;
    }
}
