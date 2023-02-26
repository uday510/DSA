/**
 * Problem Description
 * You are given the root node of a binary tree A. You have to find the number of nodes in this tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in the tree <= 105
 *
 * 0 <= Value of each node <= 107
 *
 *
 *
 * Input Format
 * The first and only argument is a tree node A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of nodes of the tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  Values =  1
 *           / \
 *          4   3
 * Input 2:
 *
 *
 *  Values =  1
 *           / \
 *          4   3
 *         /
 *        2
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Clearly, there are 3 nodes 1, 4 and 3.
 * Explanation 2:
 *
 * Clearly, there are 4 nodes 1, 4, 3 and 2.
 */

package NonLinear.BinaryTrees;

public class NodesCount {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(4);
        TreeNode child2 = new TreeNode(3);

        root.left = child1;
        root.right = child2;

        int ans = solve(root);
        System.out.println(ans);
    }

    public static int solve(TreeNode root) {
        if (root == null) return 0;

        return 1 + solve(root.left) +solve(root.right);
    }
}
