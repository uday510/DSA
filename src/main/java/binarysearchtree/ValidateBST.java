/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
package binarysearchtree;

public class ValidateBST {
    public static class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
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

        boolean ans = solve(root);
        System.out.println(ans);
    }

    public static boolean solve(TreeNode root) {
        // O(N) time | O(H) space

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode currNode, long min, long max) {
        if (currNode == null) return true;
        if (currNode.val <= min || currNode.val >= max) return false;

        return helper(currNode.left, min, currNode.val) &&
                helper(currNode.right, currNode.val, max);
    }
}
