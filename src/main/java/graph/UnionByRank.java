package graph;

public class UnionByRank {

    static int[] root;
    static int[] rank;

    public UnionByRank(int n) {
        root = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; ++i) {
            root[i] = i; // Initially, root[i] = i
            rank[i] = 1; // Initially, rank[i] = 1
        }
    }
    public static void main(String[] args) {
        UnionByRank uf = new UnionByRank(10); // O(n)
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.find(1)); // 1
        System.out.println(uf.find(2)); // 1
        System.out.println(uf.find(5)); // 1
        System.out.println(uf.find(6)); // 1
        System.out.println(uf.find(7)); // 1
    }
    public static int find(int x) {
        // O(logn) time | O(1) space
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }
    public static void union(int x, int y) {
        // O(logn) time | O(1) space
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX; // rootX is the new root
        } else if (rank[rootY] > rank[rootX]) { //
            root[rootX] = rootY;
        } else { // rank[rootX] == rank[rootY]
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }
    public static boolean connected(int x, int y) {
        // O(logn) time | O(1) space
        return find(x) == find(y);
    }
}
