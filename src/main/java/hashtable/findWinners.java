package hashtable;

import java.util.*;

public class findWinners {
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> wMap = new HashMap<>();
        Map<Integer, Integer> lMap = new HashMap<>();

        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        int min = 100000000;
        int max = -1;

        for (int[] mat : matches) {
            int w = mat[0];
            int l = mat[1];

            wMap.put(w, wMap.getOrDefault(w, 0)+1);
            lMap.put(l, lMap.getOrDefault(l, 0)+1);

            min = Math.min(min, Math.min(w, l));
            max = Math.max(max, Math.max(w, l));
        }

        for (int i = min; i <= max; ++i) {

            if (!lMap.containsKey(i)) {
                winners.add(i);
            }
            else {
                if(lMap.get(i) == 1) {
                    losers.add(i);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        winners.sort((o1, o2) -> o1-o2);
        losers.sort((o1, o2) -> o1-o2);

        System.out.println(winners);
        System.out.println(losers);

        if (winners.getFirst() <= losers.getFirst()) {
            res.add(winners);
            res.add(losers);
        } else {
            res.add(losers);
            res.add(winners);
        }

        return res;

    }
}
