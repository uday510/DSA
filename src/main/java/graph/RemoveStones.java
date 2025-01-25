package graph;

import java.util.Arrays;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class RemoveStones {

    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones)); // 5
    }

    private static int removeStones(int[][] stones) {

        UF uf = new UF(20000);

        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10000);
        }

        int count = 0;
        for (int[] stone : stones) {
            if (uf.find(stone[0]) != stone[0]) {
                System.out.println(stone[0] + " " + uf.find(stone[0]));
                count++;
            }
        }

        return count;
    }
     private static class UF {
        int[] root;
        int[] rank;

        public UF(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; ++i) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (x != root[x]) {
                x = root[x];
            }
            return x;
        }

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
     }
}
