package dp.multiDp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

    private Map<String, Boolean> dp;
    Set<Integer> stones;
    private int lastStone;

    public boolean canCross(int[] arr) {

        dp = new HashMap<>();
        stones = new HashSet<>();

        for (int s : arr)
            stones.add(s);

        lastStone = arr[arr.length - 1];

        return dfs(0, 0);
    }

    private boolean dfs(int pos, int k) {

        if (pos == lastStone)
            return true;

        String key = pos + ":" + k;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        for (int jump = k - 1; jump <= k + 1; jump++) {

            if (jump <= 0)
                continue;

            int next = pos + jump;

            if (!stones.contains(next))
                continue;

            if (dfs(next, jump)) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }

}
