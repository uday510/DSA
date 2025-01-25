/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {

    public static void main(String[] args) {


        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(-8);
        TreeNode node2 = new TreeNode(0);

        TreeNode node1 = new TreeNode(7, node3, node4);

        TreeNode root = new TreeNode(1, node1, node2);

        int res = solve(root);
        System.out.println(res);
    }
    public static int solve(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int temp;
        int currLevel = 1;
        int max = -(int) 1e9;
        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            temp = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode currNode = queue.poll();
                temp += currNode.val;

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            if (temp > max) {
                max = temp;
                res = currLevel;
            }
            ++currLevel;
        }
        return res;
    }
}
