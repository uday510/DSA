package graph;

class UnionFind {
    /**
     * There are few ways to implement UnionFind
     * 1. Quick Find
     * 2. Quick Union
     * 3. Union by Rank
     * 4. Path Compression
     *
     * The best way to implement UnionFind is to use
     * both Union by Rank and Path Compression
     *
     *  NOTE: Use this as default template
     */
     private static int[] root;
     private static int[] rank;

     public UnionFind(int size) {
         root = new int[size];
         rank = new int[size];
         for (int i = 0; i < size; ++i) {
             root[i] = i;
             rank[i] = 1;
         }
     }
     // The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
         if (x == root[x]) {
             return x;
         }
         return root[x] = find(root[x]);
    }
    // The union function with union by rank.
    public void union(int x, int y) {
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

    public boolean connected(int x, int y) {
         return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}

