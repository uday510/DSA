/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {

    private List<List<Integer>> res;
    private List<Integer> arr;
    private int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        arr = new ArrayList<>();
        for (int num : nums) arr.add(num);
        n = arr.size();

        dfs(0);
        return res;
    }

    private void dfs(int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(arr));
            return;
        }

        Set<Integer> seen = new HashSet<>();
        for (int curIdx = idx; curIdx < n; curIdx++) {
            if (!seen.add(arr.get(curIdx))) continue;
            swap(curIdx, idx);
            dfs(idx + 1);
            swap(curIdx, idx);
        }

    }

    private void swap(int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

}
