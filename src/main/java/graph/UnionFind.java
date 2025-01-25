package graph;

public class UnionFind {
    /**
     * There are few ways to implement UnionFind
     * 1. Quick Find
     * 2. Quick Union
     * 3. Union by Rank
     * 4. Path Compression
     *
     * The best way to implement UnionFind is to use
     * both Union by Rank and Path Compression
     */

     private static int[] root;
     //Use a rank array to record the height of each vertex.
     private static int[] rank;

     public UnionFind(int size) {
         // O(n) time | O(n) space
         root = new int[size];
         rank = new int[size];
         for (int i = 0; i < size; ++i) {
             root[i] = i;
             rank[i] = 1;
         }
     }

    public static void main(String[] args) {
        new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        union(1, 2);
        union(2, 5);
        union(5, 6);
        union(6, 7);
        union(3, 8);
        union(8, 9);
        System.out.println(connected(1, 5)); // true
        System.out.println(connected(5, 7)); // true
        System.out.println(connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        union(9, 4);
        System.out.println(connected(4, 9)); // true
    }
     // The find function here is the same as that in the disjoint set with path compression.
    public static int find(int x) {
         // O(logn) time | O(1) space
         if (x == root[x]) {
             return x;
         }
         return root[x] = find(root[x]);
    }
    // The union function with union by rank.
    public static void union(int x, int y) {
         // O(1) time | O(1) space
         int rootX = find(x);
         int rootY = find(y);

         if (rootX == rootY) {
             return;
         }

         if (rank[rootX] > rank[rootY]) {
             root[rootY] = rootX;
         } else if (rank[rootY] > rank[rootX]) {
             root[rootX] = rootY;
         } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
         }
    }
    public static boolean connected(int x, int y) {
         // O(1) time | O(1) space
         return find(x) == find(y);
    }
}
