package NonLinear.BinaryTrees;

public class FindHeightOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(7, null, null);
            TreeNode node6 = new TreeNode(6, null, null);
            TreeNode node5 = new TreeNode(3, node6, node7);

            TreeNode node3 = new TreeNode(5, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(2, node2, node3);

            TreeNode root = new TreeNode(1, null, null);

            root.left = node1;
            root.right = node5;

            int height = solve(root);
            System.out.println(height);
        }
        public static int solve(TreeNode root) {
            // O(N) time | O(N) space
            if (root == null || root.left == null || root.right == null) return 0;

            int leftHeight = solve(root.left);
            int rightHeight = solve(root.right);

            return 1 + Math.max(leftHeight, rightHeight);

        }
    }
}
