/**
 * Problem Description
 * Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 *
 *
 * Problem Constraints
 * 0 <= N <= 16
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D vector denoting all the possible subsets.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 2]
 * Input 2:
 *
 *  A = [1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     [],
 *     [1],
 *     [1, 2],
 *     [1, 2, 2],
 *     [2],
 *     [2, 2]
 *  ]
 * Output 2:
 *
 *  [
 *     [],
 *     [1],
 *     [1, 1]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All the subsets of the array [1, 2, 2] in lexicographically sorted order.
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));

        ArrayList<ArrayList<Integer>> res = solve(nums);
        for (ArrayList<Integer> a: res) {
            System.out.println(a);
        }
    }
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> nums) {

        Collections.sort(nums);

        int idx = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subset(nums, res, temp, idx);
        return res;
    }
    public static void subset(ArrayList<Integer> nums,
                              ArrayList<ArrayList<Integer>> res,
                              ArrayList<Integer> temp, int idx) {

    res.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.size(); ++i) {
            int num = nums.get(i);

            if (i > idx && num == nums.get(i-1)) { continue; }

            temp.add(num);
            subset(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);

        }
    }
}
