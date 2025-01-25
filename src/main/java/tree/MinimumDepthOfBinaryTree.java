/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 */
package tree;

import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode right2 = new TreeNode(15);
        TreeNode right3 = new TreeNode(7);
        root.left = left;
        root.right = right1;
        right1.left = right2;
        right1.right = right3;
        System.out.println(minDepth(root));
    }
    public static int minDepth(TreeNode root) {
        // O(n) time complexity | O(n) space complexity
        if (root == null) return 0;
        TreeNode currNode = root;
        int minDepth = 0;

        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(currNode);
        ++minDepth;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                currNode = queue.poll();
                if (currNode == null) return minDepth;
                if (currNode.left == null && currNode.right == null) return minDepth;
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            ++minDepth;
        }
        return minDepth;
    }
}
