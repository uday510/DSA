/*
A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.



Example 1:


Input: root = [1,1,1,1,1,null,1]
Output: true

 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {
    public static void main(String[] args) {



    }

    public boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        int val = root.val;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                continue;
            }

            if (node.val != val) {
                return false;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return true;
    }
}
