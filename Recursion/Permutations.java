package Recursion;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        solve(0, nums, permutations);
        System.out.println(permutations);
    }
    public static void solve(int i, int[] nums, ArrayList<ArrayList<Integer>> permutations) {
        // O(N!*N) time | O(N!*N) space
        if (i == nums.length) {
            ArrayList<Integer> permutation = new ArrayList<>();
            for (int num: nums) {
                permutation.add(num);
            }
            permutations.add(permutation);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(i, j, nums);
            solve(i+1, nums, permutations);
            swap(i, j, nums);
        }
    }
    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
