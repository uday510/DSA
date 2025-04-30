package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    private static String  minWindow(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();

        int n = s.length(), m = t.length();
        int len = Integer.MAX_VALUE;
        int st = 0, l = 0, r = 0;
        int count = 0;

        for (char ch : t.toCharArray()) cnt.merge(ch, 1, Integer::sum);

        while (r < n) {
            char ch = s.charAt(r);
            r++;
            if (!cnt.containsKey(ch)) continue;

            if (cnt.get(ch) > 0) count++;
            cnt.merge(ch, -1, Integer::sum);

            while (count == m) {
                if (len > r - l + 1) {
                    len = r - l + 1;
                    st = l;
                }

                char ch2 = s.charAt(l);

                if (cnt.containsKey(ch2)) {
                    cnt.merge(ch2, 1, Integer::sum);
                    count--;
                }
                l++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(st, st + len);
    }
}
