package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LCAOfDeepestLeaves {
    public static void main(String[] args) {

    }
    public Pair lcaDeepestLeaves(TreeNode root, int d) {
        if (root == null) return new Pair(null, d);

        Pair l = lcaDeepestLeaves(root.left, d+1);
        Pair r = lcaDeepestLeaves(root.right, d+1);

        if (l.d == r.d) {
            return new Pair(root, l.d);
        }
        return l.d > r.d ? l : r;
    }

    static class Pair {
        TreeNode node;
        int d;

        public Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }
}
