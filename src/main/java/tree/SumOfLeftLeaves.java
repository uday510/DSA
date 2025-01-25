/*
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
 */
package tree;

import java.util.Queue;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);

        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(root));
    }
    public static int sumOfLeftLeaves(TreeNode root) {

        int sum = 0;

        if(root == null) return sum;

        Queue<TreeNode> queue = new java.util.LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; ++i) {

                TreeNode currNode = queue.poll();

                if (currNode == null) { continue; }

                if (currNode.left != null && currNode.left.left == null && currNode.left.right == null) {
                    sum += currNode.left.val;
                }

                if (currNode.left != null) { queue.add(currNode.left); }

                if (currNode.right != null) { queue.add(currNode.right); }
            }
        }

        return sum;
    }
}
