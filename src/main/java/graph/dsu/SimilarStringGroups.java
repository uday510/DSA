package graph.dsu;

public class SimilarStringGroups {

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            String s1 = strs[i];
            for (int j = i + 1; j < n; j++) {
                String s2 = strs[j];
                int d = 0;

                for (int k = 0; k < s1.length() && d < 3; k++) {
                    d += s1.charAt(k) != s2.charAt(k) ? 1 : 0;
                }

                if (d <= 2) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getComponents();
    }

}
