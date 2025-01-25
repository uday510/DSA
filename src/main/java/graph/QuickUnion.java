package graph;

public class QuickUnion {
    private static int[] root;

    public QuickUnion(int n) {
        root = new int[n];
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        qu.union(0, 1);
        qu.union(1, 2);
        qu.union(2, 3);
        qu.union(3, 4);
        qu.union(4, 5);
        qu.union(5, 6);
        qu.union(6, 7);
        System.out.println(qu.connected(0, 7));
        System.out.println(qu.connected(0, 8));
        qu.union(8, 9);
        System.out.println(qu.connected(0, 9));

    }
    public static int find(int x) {
        // O(N) time| O(1) space
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }
    public static void union(int x, int y) {
        // O(N) time| O(1) space
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
        }
    }
    public static boolean connected(int x, int y) {
        // O(N) time| O(1) space
        return find(x) == find(y);
    }
}
