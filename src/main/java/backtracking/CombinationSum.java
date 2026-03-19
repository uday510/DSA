package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> res;
    private int[] c;
    private int n, t;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        c = candidates;
        n = candidates.length;
        t = target;

        dfs(0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int idx, int sum, List<Integer> curList) {
        if (sum == t) {
            res.add(new ArrayList<>(curList));
            return;
        }

        if (idx >= n || sum > t) return;

        for (int curIdx = idx; curIdx < n; curIdx++) {
            curList.add(c[curIdx]);
            dfs(curIdx, sum + c[curIdx], curList);
            curList.removeLast();
        }

    }

}
