/**
 * Problem Description
 * Given the root of a binary tree A. Return the sum of all the nodes of the binary tree.
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in A <= 104
 *
 * 1 <= value of each node <= 104
 *
 *
 *
 * Input Format
 * First argument is the root of binary tree A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the sum of all the nodes
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A =   2
 *       / \
 *      1   4
 *     /
 *    5
 *
 *
 * Input 2:
 *
 * A =   3
 *       / \
 *       6  1
 *       \   \
 *        2   7
 *
 *
 * Example Output
 * Output 1:
 *
 * 12
 * Output 2:
 *
 * 19
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The sum of all the nodes is 12
 * Explanation 2:
 *
 * The sum of all the nodes is 19
 */

package tree;

public class SumOfNodesOfBinaryTree {
    public static int count = 1;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));

        count = 0;
        solve(root, Integer.MIN_VALUE);

        System.out.println(count);
    }

    public static void solve(TreeNode root, int ancestor) {
        if (root == null) return;

        if (root.val > ancestor) {
            count++;
        }
        solve(root.left, Math.max(ancestor, root.val));
        solve(root.right, Math.max(ancestor, root.val));
    }
}
