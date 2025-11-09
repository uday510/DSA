package dp.oneD;

import java.util.*;

public class LongestStringChain {
    Map<String, Integer> dp;
    Set<String> ws;
    int n;

    public int longestStrChain(String[] words) {
        n = words.length;
        ws = new HashSet<>();
        dp = new HashMap<>();

        Collections.addAll(ws, words);

        int res = 1;
        for (String w : words) {
            res = Math.max(res, dfs(w));
        }

        return res;
    }

    private int dfs(String w) {
        Integer data = dp.get(w);
        if (data != null) return data;

        int cur = 1;
        for (int i = 0; i < w.length(); i++) {
            String s = w.substring(0, i) + w.substring(i + 1);

            if (ws.contains(s)) {
                cur = Math.max(cur, 1 + dfs(s));
            }
        }

        dp.put(w, cur);
        return cur;
    }

}
