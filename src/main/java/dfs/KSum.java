package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {

    public List<List<Integer>> dfs(int idx, int target, int k, int[] arr) {
        if (k == 2) return twoSum(idx, target, arr);

        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = idx; i < n; i++) {
            if (i > idx && arr[i] == arr[idx]) continue;

            for (List<Integer> sub : dfs(i + 1, target - arr[i], k - 1, arr)) {
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.addAll(sub);

                res.add(cur);
           }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int st, int target, int[] arr) {
        int i = st, n = arr.length, j = n - 1;

        List<List<Integer>> res = new ArrayList<>();

       while (i < j) {
           int cur = arr[i] + arr[j];

           if (cur < target) {
               i++;
           } else if (cur > target) {
               j--;
           } else {
               res.add(Arrays.asList(arr[i], arr[j]));

               i++; j--;
               while (i < n && arr[i] == arr[i - 1]) i++;
               while (j > -1 && arr[j] == arr[j + 1]) j--;
           }
       }

       return res;
    }

}
