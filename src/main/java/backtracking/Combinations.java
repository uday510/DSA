package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


    private List<List<Integer>> res;
    private int n, k;

    public List<List<Integer>> combinations(int n, int k) {
        res = new ArrayList<>();
        this.n = n;
        this.k = k;

        dfs(1, new ArrayList<>());
        return res;
    }

    private void dfs(int idx, List<Integer> curList) {
        if (curList.size() == k) {
            res.add(new ArrayList<>(curList));
            return;
        }

        for (int curIdx = idx; curIdx <= (n - k - curList.size() - 1); curIdx++) {
            curList.add(curIdx);
            dfs(curIdx + 1, curList);
            curList.removeLast();
        }
    }

}
