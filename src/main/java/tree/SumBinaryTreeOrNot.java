/**
 * Problem Description
 * Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
 *
 * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
 *
 * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 *
 * Return 1 if it sum-binary tree else return 0.
 */
package tree;

public class SumBinaryTreeOrNot {
    static int ans = 1;
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
        public static int solve(TreeNode root) {
            // O(N) | O(H) space
            if (root == null) return 0;

            if (root.left == null && root.right == null) return root.val;

            int left = solve(root.left);
            int right = solve(root.right);

            if (left + right != root.val) {
                ans = 0;
                return -1;
            }
            return left + right + root.val;
        }
}
