package graph.dsu;

import java.util.HashMap;
import java.util.Map;

public class SmallestEquivalentString {

    public String smallestEquivalentString(String s1, String s2, String base) {
        int n = s1.length();
        DSU dsu = new DSU(26);

        for (int i = 0; i < n; i++) {
            dsu.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c1 = s1.charAt(i) - 'a', c2 = s2.charAt(i) - 'a';
            int r1 = dsu.find(c1), r2 = dsu.find(c2);

            if (map.containsKey(r1)) {
                map.put(r1, Math.min(map.get(r1), Math.min(c1, c2)));
            } else {
                map.put(r1, Math.min(c1, c2));
            }

            if (map.containsKey(r2)) {
                map.put(r2, Math.min(map.get(r2), Math.min(c1, c2)));
            } else {
                map.put(r2, Math.min(c1, c2));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            int r = dsu.find(c - 'a');

            if (map.containsKey(r)) {
                sb.append((char) (map.get(r) + 'a'));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
