package dp.knapsack;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {

    int cnt;
    int target;
    int n;
    Map<Integer, Integer> dp;

    public int combinationSum4(int[] nums, int target) {
        cnt = 0;
        n = nums.length;
        this.target = target;
        dp = new HashMap<>();

        return dfs(0, nums);
    }

    private int dfs (int sum, int[] nums) {
        if (sum > target) return 0;
        if (sum == target) return 1;

        if (dp.containsKey(sum)) return dp.get(sum);

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            cnt += dfs(sum + nums[i], nums);
        }

        dp.put(sum, cnt);
        return cnt;
    }

}
