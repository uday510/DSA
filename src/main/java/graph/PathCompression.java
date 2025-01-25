package graph;

public class PathCompression {
    private static int[] root;

    public PathCompression(int n) {
        // O(N) time | O(N) space
        root = new int[n];
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }
    }
    public static void main(String[] args) {
        PathCompression pc = new PathCompression(10);
        // 0-1-2-3-4-5-6-7-8-9
        pc.union(0, 1);
        pc.union(1, 2);
        pc.union(2, 3);
        pc.union(3, 4);
        pc.union(4, 5);
        pc.union(5, 6);
        System.out.println(pc.connected(0, 6));
        // 0-1-2-3-4-5-6-7-8-9
        System.out.println(pc.connected(0, 7));
        pc.union(6, 7);
        System.out.println(pc.connected(0, 7));
    }
    public static int find(int x) {
        // O(logN) time | O(1) space
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    public static void union(int x, int y) {
        // O(logN) time | O(1) space
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
        }
    }
    public static boolean connected(int x, int y) {
        // O(logN) time | O(1) space
        return find(x) == find(y);
    }
}
