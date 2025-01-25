/**
 * Given a root of binary tree A, determine if it is height-balanced.
 *
 * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the root of the tree A.
 *
 *
 *
 * Output Format
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     1
 *    / \
 *   2   3
 * Input 2:
 *
 *
 *        1
 *       /
 *      2
 *     /
 *    3
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * It is a complete binary tree.
 * Explanation 2:
 *
 * Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 * Difference = 2 > 1.
 */
package tree;

public class BalancedBinaryTree {
        public static void main(String[] args) {

            TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

            Boolean ans = solve(root);
            System.out.println(ans);
        }
        public static Boolean solve(TreeNode root) {
            // O(N) time | O(N) space

            return dfs(root) < 2;
        }
        public static int dfs(TreeNode root) {
            if( root == null) return 0;

            int leftHeight = dfs(root.left);
            if (leftHeight == -1) return -1;

            int rightHeight = dfs(root.right);
            if (rightHeight == -1) return -1;

            if (Math.abs(leftHeight - rightHeight) > 1) return -1;
            return 1 + Math.max(leftHeight, rightHeight);
        }
}
