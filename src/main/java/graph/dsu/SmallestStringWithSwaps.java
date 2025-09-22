package graph.dsu;

import java.util.*;

public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        for (List<Integer> p : pairs) {
            uf.union(p.get(0), p.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        char[] res = new char[n];

        for (List<Integer> v : map.values()) {
            List<Character> chars = new ArrayList<>();
            for (int i : v) {
                chars.add(s.charAt(i));
            }

            Collections.sort(chars);
            for (int i = 0; i < v.size(); i++) {
                res[v.get(i)] = chars.get(i);
            }
        }

        return new String(res);
    }


}
