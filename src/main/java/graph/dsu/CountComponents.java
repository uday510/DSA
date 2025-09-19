package graph.dsu;

public class CountComponents {
    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }

        return uf.getComponents();
    }

}
