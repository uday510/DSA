/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 */
package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
    public int deepestLeavesSum(TreeNode root) {
        TreeNode currNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currNode);
        int ans = 0;
        while (queue.isEmpty() == false) {
            int size = queue.size();
            int tempVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode != null) tempVal += tempNode.val;

                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            ans = tempVal;
        }
        return ans;
    }

}
