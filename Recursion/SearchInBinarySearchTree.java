package Recursion;
public class SearchInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;

        System.out.println(searchBST(root, 2).val);
    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }

        if (val <= root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
