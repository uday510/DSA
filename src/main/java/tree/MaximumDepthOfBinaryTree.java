/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf nod
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        int count = 0;
        if (root == null) {return count; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; ++i) {
                TreeNode currNode = queue.poll();
                assert currNode != null;
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
        }
        return count;
    }
    public static int dfs(TreeNode root) {
        if (root == null) {return 0; }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }
}
