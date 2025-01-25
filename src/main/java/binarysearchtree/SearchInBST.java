/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val
 * and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
package binarysearchtree;

public class SearchInBST {
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

            TreeNode ans = solve(root, 10);

            if (ans != null)
            System.out.println(ans.val);
            else System.out.println(ans);
        }

        public static TreeNode solve(TreeNode root, int target) {
            // O(H) time | O(H) space where H is the height of the BST.
//            TreeNode currNode = root;
//
//            while (currNode != null) {
//                if (currNode.val == target) return currNode;
//
//                if (target < currNode.val) currNode = currNode.left;
//                else currNode = currNode.right;
//            }
//            return null;

            if (root == null || root.val == target) return root;

            return target < root.val ? solve(root.left, target) : solve(root.right, target);
        }
}
