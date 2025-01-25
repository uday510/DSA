/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value
 * does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion,
 * as long as the tree remains a BST after insertion. You can return any of them.
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 */
package binarysearchtree;

public class InsertIntoABst {
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

        TreeNode ans = solve(root, 50);
    }

    public static TreeNode solve(TreeNode root, int val) {
        // O(H) time | O(H) where H is the H of given BST.
//            if (root == null) return new TreeNode(val);
//
//            // insert into the right subtree
//            if (val > root.val) root.right = solve(root.right, val);
//            // insert into the left subtree
//            else root.left = solve(root.left, val);
//
//            return root;

        /**
         * Iterative way
         */
        TreeNode currNode = root;

        while (currNode != null) {
            //insert into right subtree
            if (val > currNode.val) {
                // insert right now
                if (currNode.right == null) {
                    currNode.right = new TreeNode(val);
                    return root;
                } else currNode = currNode.right;
            }
            // insert into the left subtree
            else {
                // insert right now
                if (currNode.left == null) {
                    currNode.left = new TreeNode(val);
                    return root;
                } else currNode = currNode.left;
            }
        }
        return new TreeNode(val);
    }
}
