/**
 *Problem Description
 * You are given a binary tree A. Your task is pretty straightforward. You have to find the sum of the product of each node and its mirror image (The mirror of a node is a node which exists at the mirror position of the node in the opposite subtree at the root.). Don’t take into account a pair more than once. The root node is the mirror image of itself. Return the answer modulo 1e9 + 7.
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in the tree <= 105
 * 1 <= node values <= 105
 *
 *
 * Input Format
 * First argument represents the root of binary tree A.
 *
 *
 * Output Format
 * Return an integer denoting the sum of the product of each node with the mirror image.
 *
 *
 * Example Input
 * Input 1:
 *
 * Given Tree A:
 *            10
 *          /    \
 *         4      15
 * Input 2:
 *
 * Given Tree A:
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
 * 160
 * Output 2:
 *
 * 31
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The original binary tree looks like
 *
 *            10          mirror image      10
 *          /    \        ----------->    /    \
 *         4      15                     15     4
 *
 *     So, the answer will be (10*10 + 15*4) = 160.
 * Explanation 2:
 *
 * The original binary tree looks like
 *
 *             1                                    1
 *           /   \        mirror image            /   \
 *          2     3       ------------>          3     2
 *         / \     \                            /     / \
 *        4   5     6                          6     5   4
 *
 *     So, the answer will be (1*1 + 3*2 + 4*6) = 31.
 */
package tree;

public class MirrorProduct {
    static long ans = 0;
    static long MOD = (long) 1e9 + 7;

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
    public static long solve(TreeNode root) {
        ans = 0;

        // first take root sum.
        ans = (((long) root.val * root.val) % MOD)%MOD;

        dfs(root.left, root.right);

        return ans;
    }
    public static void dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return;

        ans = (ans%MOD + ((long)root1.val * root2.val)%MOD)%MOD;

        dfs(root1.left, root2.right);
        dfs(root1.right, root2.left);
    }
}
