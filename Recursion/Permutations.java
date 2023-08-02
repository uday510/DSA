package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

       List<List<Integer>> permutations = Permutations.permute(arr);
        System.out.println(permutations);
    }
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> perms = new ArrayList<>();


        Stack<List<Integer>> stack = new Stack<>();

        for (int num : nums) {
            List<Integer> perm = new ArrayList<>(); // empty list
            perm.add(num);
            stack.push(perm);
        }

        while (!stack.isEmpty()) {

            List<Integer> perm = stack.pop();

            if (perm.size() == nums.length) {
                perms.add(0, perm);
                continue;
            }

            for (int num : nums) {

                if (!perm.contains(num)) {
                    List<Integer> newPerm = new ArrayList<>(perm);
                    newPerm.add(num);
                    stack.push(newPerm);
                }
            }

        }

        return perms;
    }
    public static void permute(int[] nums, int i, int j, List<Integer> perm,
                               List<List<Integer>> perms) {
        if (i == j) {
            perms.add(new ArrayList<>(perm));
            return;
        }

        for (int k = i; k < j; ++k) {

            swap(nums, i, k);
            perm.add(nums[i]);

            permute(nums, i + 1, j, perm, perms);

            perm.remove(perm.size() - 1);
            swap(nums, i, k);

        }
    }
    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
