package tree;

import java.awt.desktop.PrintFilesEvent;
import java.util.HashSet;

public class LCA4 {
    static TreeNode LCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        LCA = null;
        HashSet<Integer> seen = new HashSet<>();

        for (var node : nodes) seen.add(node.val);

        helper(root, seen);
        return LCA;
    }
    public static int helper(TreeNode root, HashSet<Integer> set) {
        if (root == null) return 0;

        int leftCnt = helper(root.left, set);
        int rightCnt = helper(root.right, set);
        int cnt = leftCnt + rightCnt;
        if (set.contains(root.val)) {
            cnt++;
        }

        if (cnt == set.size() && LCA == null) {
             LCA = root;
        }
        return cnt;
    }
}
