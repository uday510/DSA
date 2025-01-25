package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> res = combinations(n, k);
        System.out.println(res);
    }
    public static List<List<Integer>> combinations(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(1, k, n, curr, ans);

        return ans;

    }

    public static void solve(int idx, int k, int n, List<Integer> curr, List<List<Integer>> ans) {

        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (idx == n + 1) {
            return;
        }

        // add
        curr.add(idx);
        solve(idx + 1, k, n, curr, ans);

        // remove
        curr.remove(curr.size() - 1);
        solve(idx + 1, k, n, curr, ans);
    }
}
