/**
 * Given the root of a binary search tree,
 * and an integer k, return the kth smallest value (1-indexed) of all
 * the values of the nodes in the tree.
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 */
package binarysearchtree;

import java.util.Stack;

public class KthSmallestElementInBST {

    int count;
    int ans;

        public void main(String[] args) {

            TreeNode node7 = new TreeNode(30, null, null);
            TreeNode node6 = new TreeNode(10, null, null);
            TreeNode node5 = new TreeNode(20, node6, node7);

            TreeNode node3 = new TreeNode(6, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(8, node2, node3);

            TreeNode root = new TreeNode(10, null, null);

            root.left = node1;
            root.right = node5;

            count = 0;

        }

        /**
         * go to left and start counting from left most node,
         * list inorder traverse.
         *
         *
         */
        void dfs(TreeNode root, int k) {
            if (root == null) return;

            dfs(root.left, k);

            count += 1;

            if (count == k) {
                ans = root.val;
                return;
            }
            dfs(root.right, k);
        }

        // iterative approach
        int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();

            TreeNode currNode = root;

            while (true) {
                while (currNode != null) {
                    stack.push(currNode);
                    currNode = currNode.left;
                }
                currNode = stack.pop();
                if (--k == 0) return currNode.val;
                currNode = currNode.right;
            }
        }
}
