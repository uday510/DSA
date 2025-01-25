/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
package tree;

public class DiameterOfBinaryTree {
    public static int diameter;
        public static void main(String[] args) {

            TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

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
