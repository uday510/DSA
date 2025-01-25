package graph;

public class QuickFind {
    private static int[] root;

    public QuickFind(int n) {
        root = new int[n];
        for (int i = 0; i < n; ++i) {
            root[i] = i; // set root to itself as default
        }
    }

    public static void main(String[] args) {
        QuickFind uf = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // 1
        System.out.println(uf.connected(5, 7)); // 1
        System.out.println(uf.connected(4, 9)); // 0
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // 1
    }
    public int find(int x) {
        // O(1) time | O(1) space
        return root[x];
    }
    public void union(int x, int y) {
        // O(N) time | O(1) space
        int rootX = find(x); // find root of x
        int rootY = find(y); // find root of y
        if (rootX == rootY) return; // already connected
        for (int i = 0; i < root.length; ++i) {
            if (root[i] == rootY) {
                root[i] = rootX; // set root of y to root of x
            }
        }
    }
    public boolean connected(int x, int y) {
        // O(1) time | O(1) space
        return root[x] == root[y];
    }
}
