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

package NonLinear.BinaryTrees;

public class SumOfNodesOfBinaryTree {

    public static class TreeNode {
        int val;
        NodesCount.TreeNode left;
        NodesCount.TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        NodesCount.TreeNode root = new NodesCount.TreeNode(1);
        NodesCount.TreeNode child1 = new NodesCount.TreeNode(4);
        NodesCount.TreeNode child2 = new NodesCount.TreeNode(3);

        root.left = child1;
        root.right = child2;

        int ans = solve(root);
        System.out.println(ans);
    }

    public static int solve(NodesCount.TreeNode root) {
        if (root == null) return 0;

        return root.val + solve(root.left) + solve(root.right);
    }
}
