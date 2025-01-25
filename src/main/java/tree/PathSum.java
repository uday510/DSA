/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 */
package tree;

public class PathSum {
        public static void main(String[] args) {

            TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

            boolean ans = solve(root, 24);

            System.out.println(ans);
        }
        static boolean solve(TreeNode root, int remainingSum) {
            if (root == null) return false;

            remainingSum -= root.val;

            if (remainingSum == 0 && root.left == null && root.right == null) {
                return true;
            }

            return solve(root.left, remainingSum) || solve(root.right, remainingSum);
        }
}
