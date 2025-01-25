package tree;

public class FindHeightOfBinaryTree {

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

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
