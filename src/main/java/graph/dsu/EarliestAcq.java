package graph.dsu;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestAcq {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));

        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            int u = log[1], v = log[2], t = log[0];

            uf.union(u, v);

            if (uf.getComponents() == 1) return t;
        }

        return -1;
    }
}
