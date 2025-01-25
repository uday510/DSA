package graph;

public class ValidateBinaryTreeNodes {

    public static void main(String[] args) {
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};

        System.out.println(validateBinaryTreeNodes(4, leftChild, rightChild));
    }
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind dsu = new UnionFind(n);

        for (int i = 0; i < n; ++i) {

            int[] children = {leftChild[i], rightChild[i]};
            for (int child : children) {
                if (child == -1) continue;

                if (dsu.connected(i, child)) {
                    return false; // cycle
                } else {
                    dsu.union(i, child);
                }
            }
        }

        int rootCount = 0;

        for (int i = 0; i < n; ++i) {
            if (dsu.rank[i] == i) rootCount++;
        }

        return rootCount == 1;
    }

    static class UnionFind {

        int[] root;
        int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                root[i] = i; // Initially, root[i] = i
                rank[i] = 1; // Initially, rank[i] = 1
            }
        }
        public int find(int x) {
            while ( x != root[x]) {
                x = root[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] +=1;
            }
        }
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}

