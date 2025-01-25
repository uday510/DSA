/**
 * Problem Description
 * You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
 *
 * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
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
 * -1 <= A[i] <= 105
 *
 *
 *
 * Input Format
 * Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
 *
 *
 *
 * Output Format
 * Return the root node of the Binary Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Input 2:
 *
 *  A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 *
 *
 * Example Output
 * Output 1:
 *
 *            1
 *          /   \
 *         2     3
 *        / \
 *       4   5
 * Output 2:
 *
 *             1
 *           /   \
 *          2     3
 *         / \ .   \
 *        4   5 .   6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 *  Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 *
 *  Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 *  Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {

        public static void main(String[] args) {
            int[] a = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};

            solve(a);
        }
        public static TreeNode solve(int[] arr) {
            // O(N) time | O(N) space
            TreeNode root = new TreeNode(arr[0]);

            if (arr.length == 1) return root;

            Queue<TreeNode> queue = new LinkedList();
            queue.add(root); // add root node
            int i = 1; // to keep track of current node/child

            while (!queue.isEmpty()) {
                // pop the front node
                TreeNode currNode = queue.poll();
                if (currNode == null) continue; // if null simply continue

                int leftChildVal = arr[i];
                int rightChildVal = arr[i+1];
                i += 2; // increment i for next children

                // add only if child nodes are not null
                if (leftChildVal != -1) currNode.left = new TreeNode(leftChildVal);
                if (rightChildVal != -1) currNode.right = new TreeNode(rightChildVal);

                // add currNode children to queue
                queue.add(currNode.left);
                queue.add(currNode.right);
            }
            return root;
        }
}
