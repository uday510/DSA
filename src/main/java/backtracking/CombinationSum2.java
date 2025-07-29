/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {2, 2, 3, 6, 7};
        int target = 7;

        ArrayList<ArrayList<Integer>> ans = solve(candidates, target);
        System.out.println(ans);
    }
    public static ArrayList<ArrayList<Integer>> solve(int[] candidates, int target) {

        Arrays.sort(candidates);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        combinationSum(candidates, 0, target, temp, res);
        return res;
    }
    public static void combinationSum(int[] candidates, int index, int remaining,ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (remaining < 0) return;
        if (remaining == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            if (i > index && candidates[i] == candidates[i-1]) continue;
            int candidate = candidates[i];
            temp.add(candidate);
            combinationSum(candidates, i+1, remaining-candidate, temp, res);
            temp.removeLast();
        }
    }
}
