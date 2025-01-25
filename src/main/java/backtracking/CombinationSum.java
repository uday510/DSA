package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
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
            combinationSum(candidates, i, remaining-candidate, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
