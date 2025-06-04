package dp.fibonacci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    Map<Integer, Integer> map;
    int[] dp;

    public int deleteAndEarn(int[] nums) {
        int n = -1;
        map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, num, Integer::sum);
            n = Math.max(n, num);
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return dfs(n);
    }

    private int dfs(int n) {
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        int pick = map.computeIfAbsent(n, k -> 0) + dfs(n - 2);
        int dont = dfs(n - 1);

        return dp[n] = Math.max(pick, dont);
    }

}
