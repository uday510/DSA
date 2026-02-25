package dp.multiDp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountVowelPermutation {

    private static final Map<Character, char[]> map = new HashMap<>();
    private static final int mod = (int) 1e9 + 7;
    static {
        map.put('z', new char[] {'a', 'e', 'i', 'o', 'u'});
        map.put('a', new char[] {'e'});
        map.put('e', new char[] {'a', 'i'});
        map.put('i', new char[] {'a', 'e', 'o', 'u'});
        map.put('o', new char[] {'i', 'u'});
        map.put('u', new char[] {'a'});
    }

    private int n;
    private int[][] dp;

    public int countVowelPermutation(int n) {
        long a, e, i, o, u;
        a = e = i = o = u = 1;

        long a1, e1, i1, o1, u1;

        for (int idx = 2; idx <= n; idx++) {
            a1 = (e + i + u) % mod;
            e1 = (a + i) % mod;
            i1 = (o + e ) % mod;
            o1 = i % mod;
            u1 = (o + i) % mod;

            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }

        long total = (a + e + i + o + u) % mod;
        return (int) total;
    }

    public int countVowelPermutation_(int n) {
        this.n = n;
        dp = new int[n][26];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 'z');
    }

    private int dfs(int i, char c) {
        if (i >= n) return 1;

        int idx = c - 'a';
        if (dp[i][idx] != -1) return dp[i][idx];

        int cur = 0;
        for (char nxt : map.get(c)) {
            cur = (cur + dfs(i + 1, nxt)) % mod;
        }

        return dp[i][idx] = cur;
    }
}
