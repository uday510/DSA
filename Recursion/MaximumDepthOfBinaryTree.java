package Recursion;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        root.left = left;
        root.right = right1;
        right1.left = left2;
        right1.right = right2;

        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return Math.max(left, right) + 1;
    }
}
