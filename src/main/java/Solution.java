import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int[] arr;
    private int n;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        arr = nums;
        this.n = arr.length;

        return dfs(0, 4, target);
    }

    private List<List<Integer>> dfs(int idx, int k, long cur) {
        if (k == 2) return twoSum(idx, cur);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = idx; i < n; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;

            for (List<Integer> list : dfs(i + 1, k - 1, cur - arr[i])) {
                List<Integer> sub = new ArrayList<>(List.of(arr[i]));
                sub.addAll(list);
                res.add(sub);
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int idx, long target) {
        List<List<Integer>> res = new ArrayList<>();
        int i = idx, j = n - 1;

        while (i < j) {
            int cur = arr[i] + arr[j];

            if (cur < target) i++;
            else if (cur > target) j--;
            else {

                res.add(Arrays.asList(arr[i++], arr[j--]));

                while (i < n && arr[i] == arr[i - 1]) i++;
                while (j > - 1 && arr[j] == arr[j + 1]) j--;
            }
        }

        return res;
    }

}
