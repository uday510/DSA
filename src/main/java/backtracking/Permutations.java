/**
 * Problem Description
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 *
 * NOTE:
 *
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 9
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible permutation of the array.
 *
 *
 *
 * Example Input
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * [ [1, 2, 3]
 *   [1, 3, 2]
 *   [2, 1, 3]
 *   [2, 3, 1]
 *   [3, 1, 2]
 *   [3, 2, 1] ]
 *
 *
 * Example Explanation
 * All the possible permutation of array [1, 2, 3].
 */

package backtracking;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {18, 7, 2};

        ArrayList<ArrayList<Integer>> res = solve(nums);

        System.out.println(res);
    }
    public static ArrayList<ArrayList<Integer>> solve(int[] nums) {
        // O(N*N!) time | O(N*N!) space
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();

       boolean[] visited = new boolean[nums.length];

        int[] currPerm = new int[nums.length];

       getPermutations(nums, 0, visited, currPerm, res);


       return res;

    }
    public static void getPermutations(int[] nums, int idx, boolean[] visited, int[] currPerm, ArrayList<ArrayList<Integer>> perms) {
        if (idx == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int val : currPerm) temp.add(val);
            perms.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) { // All Possibilities
            if (!visited[i]) {
                visited[i] = true;    // make changes
                currPerm[idx] = nums[i];
                getPermutations(nums, idx+1, visited, currPerm, perms); // recursive call
                visited[i] = false; // undo changes
            }
        }
    }
}
