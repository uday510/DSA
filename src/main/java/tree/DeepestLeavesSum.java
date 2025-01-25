/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6)));

        DeepestLeavesSum dls = new DeepestLeavesSum();
        System.out.println(dls.deepestLeavesSum(root));

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
