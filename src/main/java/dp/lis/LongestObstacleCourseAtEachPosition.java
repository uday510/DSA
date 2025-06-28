package dp.lis;

import java.util.ArrayList;
import java.util.List;

public class LongestObstacleCourseAtEachPosition {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n];
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int curr = obstacles[i];
            int index = bisectLeft(curr, lis);
            dp[i] = index + 1;
            if (index == lis.size()) lis.add(curr);
            lis.set(index, curr);
        }

        return dp;


        // for (int i = 0; i < n; ++i) {
        //     dp[i] = 1;

        //     for (int j = 0; j < i; ++j) {
        //         if (obstacles[j] <= obstacles[i]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        // }

        // return dp;
    }

    private int bisectLeft(int target, List<Integer> lis) {
        int left = 0, right = lis.size();

        while (left < right) {
            int mid = (left + right) >> 1;
            if (lis.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

}
