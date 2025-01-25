/**
 * Problem Description
 * Given the root of a binary search tree of size N with distinct values, transform it into a "greater sum tree" such that each node in the new tree has a value equal to the original tree node value plus the sum of all values greater than the original node value in the tree.
 * Return the new binary search tree.
 *
 *
 * Problem Constraints
 * 1 <= N <= 100
 *
 * 0 <= Node.val <= 100
 *
 * All the values in the tree are unique.
 *
 *
 * Input Format
 * The input consists of a single argument, the root of the binary search tree.
 *
 *
 * Output Format
 * Return the root of the transformed "greater sum tree".
 *
 *
 * Example Input
 * Input 1:
 * A = [3, 2, 5, 1, -1, 4, 6]
 * Input 2:
 * A = [1, 0, 2]
 *
 *
 * Example Output
 * Output 1:
 * [18, 20, 11, 21, -1, 15, 6]
 * Output 2:
 * [3, 3, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 * Initial BST:
 *         3
 *        / \
 *       2   5
 *      /   / \
 *     1   4   6
 *
 * After transforming to Greater sum tree:
 *        18
 *       /  \
 *     20    11
 *    /     /  \
 *   21    15   6
 * Explanation 2:
 * Initial BST:
 *     1
 *    / \
 *   0   2
 *
 * After transforming to Greater sum tree:
 *     3
 *    / \
 *   3   2
 */
package binarysearchtree;

public class GreaterSumTree {
    // Contest 5, Jun 2 2023

    static int sum;
        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(30, null, null);
            TreeNode node6 = new TreeNode(10, null, null);
            TreeNode node5 = new TreeNode(20, node6, node7);

            TreeNode node3 = new TreeNode(6, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(8, node2, node3);

            TreeNode root = new TreeNode(10, null, null);

            root.left = node1;
            root.right = node5;

        }
    public static TreeNode solve(TreeNode root) {
        sum = 0;

        reverseInorder(root);
        return root;
    }
    public static void reverseInorder(TreeNode root) {
        if (root == null) return;

        reverseInorder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorder(root.left);
    }
}
