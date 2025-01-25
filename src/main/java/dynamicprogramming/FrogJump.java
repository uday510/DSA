package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
    public static boolean canCross(int[] stones) {

        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        int lastStone = stones[stones.length - 1];

        map.get(0).add(1); // 0 + 1 = 1

        for (int stone : stones) {
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == lastStone) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step); // k
                    if (step - 1 > 0) { // k - 1
                        set.add(step - 1);
                    }
                    set.add(step + 1); // k + 1
                }
            }
        }
        return false;
    }
}
