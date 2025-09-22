package graph.mst;

import graph.dsu.UnionFind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

     public int kruskal(int n, int[][] nodes) {
         List<int[]> edges = new ArrayList<>();

         for (int[] e : nodes) {
             edges.add(new int[]{e[0], e[1], e[2]});
         }

         edges.sort(Comparator.comparingInt(a -> a[2]));

         UnionFind uf = new UnionFind(n);
         int minCost = 0;

         for (int[] e : edges) {
             int u = e[0], v = e[1], w = e[2];

             if (!uf.connected(u, v)) {
                 uf.union(u, v);
                 minCost += w;
             }
         }

         return minCost;

     }
}
