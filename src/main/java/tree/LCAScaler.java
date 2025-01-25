/**
 * Problem Description
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 *
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B, C <= 109
 *
 *
 *
 * Input Format
 * First argument is head of tree A.
 *
 * Second argument is integer B.
 *
 * Third argument is integer C.
 *
 *
 *
 * Output Format
 * Return the LCA.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *       1
 *      /  \
 *     2    3
 * B = 2
 * C = 3
 * Input 2:
 *
 *       1
 *      /  \
 *     2    3
 *    / \
 *   4   5
 * B = 4
 * C = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  LCA is 1.
 * Explanation 2:
 *
 *  LCA is 2.
 */
package tree;

public class LCAScaler {
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


            int p = 4;
            int q = 6;

            int ans = solve(root, p, q);

            System.out.println(ans);
        }
        public static int solve(TreeNode root, int p, int q) {

          if (! (isExists(root, p) && isExists(root, q))) return -1;

            TreeNode ans = helper(root, p, q);

            if (ans != null) return ans.val;
            return -1;
        }
        public static TreeNode helper(TreeNode root, int p, int q) {
            if (root == null || root.val == p || root.val == q) {
                return root;
            }
            TreeNode left = helper(root.left, p, q);
            TreeNode right = helper(root.right, p, q);

            // result
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                // both left and right are not null, we found LCA
                return root;
            }
        }
        static boolean isExists(TreeNode root, int val) {
            if (root == null) return false;

            if (root.val == val) return true;

            return isExists(root.left, val) || isExists(root.right, val);
        }
}
