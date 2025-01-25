package tree;

import java.util.ArrayList;

public class ReverseInorder {
    static ArrayList<Integer> list;
        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(30, null, null);
            TreeNode node6 = new TreeNode(10, null, null);
            TreeNode node5 = new TreeNode(20, node6, node7);

            TreeNode node3 = new TreeNode(6, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(8, node2, node3);

            TreeNode root = new TreeNode(10, null, null);

            root.left = node1;
            root.right = node5;

        }
    public static void reverseInorder(TreeNode root) {
        if (root == null) return;

        reverseInorder(root.right);
        list.add(root.val);
        reverseInorder(root.left);
    }
}
