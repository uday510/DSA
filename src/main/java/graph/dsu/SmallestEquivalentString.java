package graph.dsu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestEquivalentString {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        UnionFind uf = new UnionFind(26);

        for (int i = 0; i < n; i++) {
            int x = s1.charAt(i) - 'a', y = s2.charAt(i) - 'a';
            uf.union(x, y);
        }

        Map<Integer, List<Character>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = s1.charAt(i) - 'a', y = s2.charAt(i) - 'a';
            int rootX = uf.find(x), rootY = uf.find(y);

            map.computeIfAbsent(rootX, _ -> new ArrayList<>()).add(s1.charAt(i));
            map.computeIfAbsent(rootY, _ -> new ArrayList<>()).add(s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(baseStr.charAt(i));

            if (map.containsKey(root)) {
                System.out.println(map.get(root));
            }

        }

        return "";
    }

}
