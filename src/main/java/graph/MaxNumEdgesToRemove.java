package graph;
class MaxNumEdgesToRemove {
    private final int ALICE = 1;
    private final int BOB = 2;
    private final int BOTH = 3;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n+1);
        DSU bob = new DSU(n+1);

        int ans = 0;
        for (int type = BOTH; type > 0; --type) {
            for (int[] edge: edges) {
                int t = edge[0];
                int u = edge[1];
                int v = edge[2];

                if (t != type)
                    continue;

                if (t == BOTH) {
                    if (alice.connected(u, v) && bob.connected(u, v))
                        ++ans;
                    else {
                        alice.union(u, v);
                        bob.union(u, v);
                    }
                } else if (t == ALICE) {
                    if (alice.connected(u, v))
                        ++ans;
                    else
                        alice.union(u, v);
                } else {
                    if (t == BOB) {
                        if (bob.connected(u, v))
                            ++ans;
                        else
                            bob.union(u, v);
                    }
                }
            }
        }
        if (alice.components() != 1 || bob.components() != 1) // If there are more than one connected components, it means that there is no way to connect all the nodes.
            return -1;

        return ans;
    }
}
class DSU {
    int[] root;

    DSU(int n) {
        root = new int[n];
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x])
            return x;

        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        root[rootX] = rootY;
    }
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int components() {
        int cnt = 0;

        for (int i = 1; i < root.length; ++i) {
            if (root[i] == i)
                ++cnt;
        }

        return cnt;
    }
}