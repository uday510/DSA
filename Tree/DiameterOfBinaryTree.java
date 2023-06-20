/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
package Tree;

public class DiameterOfBinaryTree {
    public static int diameter;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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

            diameter = 0;
        }
        public static int solve(TreeNode root) {
            // O(N) time | O(H) space
            if (root == null) return 0;
            // recursively find the longest path in
            // both left child and right child
            int leftPath = solve(root.left);
            int rightPath = solve(root.right);

            //update the diameter if leftPath plus rightPath is larger
            diameter = Math.max(diameter, leftPath + rightPath);


            // return the longest one between leftPath and rightPath is larger
            // remember to add 1 for the path connecting the node and its parent
            return Math.max(leftPath, rightPath + 1);
        }
    }
}
