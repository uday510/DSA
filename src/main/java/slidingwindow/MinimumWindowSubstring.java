package slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        var map = new HashMap<Character, Integer>();
        int st = 0, min = (int) 1e9;

        for (int i = 0; i < n; i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        int cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            char rightChar = s.charAt(l);
            if (map.containsKey(rightChar)) {
                if (map.get(rightChar) > 0) cnt++;
                map.put(rightChar, map.get(rightChar) - 1);
            }

            while (cnt == m) {

                if (min > r - l + 1) {
                    min = r - l + 1;
                    st = l;
                }

                char leftChar = s.charAt(l);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) > 0) cnt--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }

                l++;
            }
        }


        return min == (int) 1e9 ? "" : s.substring(st, st + min);
    }

}
