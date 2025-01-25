/**
 * Problem Description
 *
 * Given a binary tree, find and return the sum of node value of all left leaves in it.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= number of nodes <= 5 * 105
 *
 * 1 <= node value <= 105
 *
 *
 *
 * Input Format
 *
 * First and only argument is a pointer to the root node of the Binary Tree, A.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the sum of node value of all left leaves in it.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Input 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  24
 * Output 2:
 *
 *  9
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Left leaf node in the given tree are 9 and 15. Return 24 (9 + 15).
 * Explanation 2:
 *
 *  Left leaf node in the given tree are 6 and 3. Return 9 (6 + 3).
 */

package tree;

public class SumofLeafLeaves {

    public static int count = 0;

    public static void main(String[] args) {
       TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, null, null), new TreeNode(7, null, null)), new TreeNode(15, null, new TreeNode(18, null, null)));

        count = 0;
        solve(root);
        System.out.println(count);
    }
    public static void solve(TreeNode node) {
        if (node == null) return;

        if (node.left != null && node.left.left == null && node.left.right == null) {
            count += node.left.val;
        }

        solve(node.left);
        solve(node.right);


    }
}
