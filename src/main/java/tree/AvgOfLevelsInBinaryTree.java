/**
 * Given the root of a binary tree, return the average value
 * of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AvgOfLevelsInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        ArrayList<Double> res = solve(root);
        System.out.println(res);
    }
    public static ArrayList<Double> solve(TreeNode root) {
        //O(N) time | O(N) space
        ArrayList<Double> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            long currSum = 0, count = 0;
            int levelLength = queue.size();

            for (int i = 0; i < levelLength; i++) {
                TreeNode currNode = queue.remove();

                currSum += currNode.val;
                count++;

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            res.add(currSum * 1.0 / count);
        }
        return res;
    }
}
