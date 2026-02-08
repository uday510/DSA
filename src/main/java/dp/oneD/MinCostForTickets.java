package dp.oneD;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinCostForTickets {

    Set<Integer> travellingDays;
    int[] dp;
    int lastDay;
    int[] costs;

    public int mincostTickets(int[] days, int[] costs) {
        travellingDays = new HashSet<>();
        lastDay = days[days.length - 1];
        dp = new int[lastDay + 1];
        this.costs = costs;

        for (int day : days) travellingDays.add(day);
        Arrays.fill(dp, -1);

        return dfs(days[0]);
    }

    private int dfs (int day) {
        if (day > lastDay) return 0;

        if (dp[day] != -1) return dp[day];

        if (!travellingDays.contains(day)) {
            return dp[day] = dfs(day + 1);
        }

        int day1Pass = costs[0] + dfs(day + 1);
        int day7Pass = costs[1] + dfs(day + 7);
        int day30Pass = costs[2] + dfs(day + 30);

        return dp[day] = Math.min(day1Pass, Math.min(day7Pass, day30Pass));
    }

}
