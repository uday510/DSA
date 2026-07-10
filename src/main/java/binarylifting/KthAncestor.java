package binarylifting;

// https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
public class KthAncestor {

}

class TreeAncestor {

    private int LOG;
    private int[][] up;

    public TreeAncestor(int n, int[] parent) {

        LOG = 17;
        up = new int[LOG][n];

        for (int v = 0; v < n; v++)
            up[0][v] = parent[v];

        for (int k = 1; k < LOG; k++) {
            for (int v = 0; v < n; v++) {
                int mid = up[k - 1][v];
                up[k][v] = (mid == -1) ? -1 : up[k - 1][mid];
            }
        }

    }

    public int getKthAncestor(int node, int k) {

        for (int i = 0; i < LOG; i++) {
            if ( ( (k >> i) & 1) == 1) {
                node = up[i][node];
                if (node == -1) return -1;
            }
        }

        return node;
    }

}



