/**
 * Problem Description
 * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
 *
 * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
 *
 * NOTE:
 *
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * Only argument is a A denoting the root node of a Binary Tree.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the Level Order Traversal of the given Binary Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *            1
 *          /   \
 *         2     3
 *        / \
 *       4   5
 * Input 2:
 *
 *             1
 *           /   \
 *          2     3
 *         / \     \
 *        4   5     6
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Output 2:
 *
 *  [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 *  Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 *
 *  The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 *  Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

        public static void main(String[] args) {


            TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

            int[] ans = solve(root);
            System.out.println(Arrays.toString(ans));
        }
        public static int[] solve(TreeNode root) {
            // O(N) time | O(N) space
            ArrayList<Integer> list = new ArrayList<>();

            if (root == null) return new int[] {};
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        list.add(-1);
                    } else {
                        list.add(node.val);
                        queue.add(node.left); // if left is null, add null or add node
                        queue.add(node.right); // if right is null, add null or add node
                    }
                }
            }
            return list.stream().mapToInt(k -> k).toArray();
        }
}
