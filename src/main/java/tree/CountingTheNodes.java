/**
 * Problem Description
 * Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of Nodes <= 200000
 *
 * 1 <= Value of Nodes <= 2000000000
 *
 *
 *
 * Input Format
 * The first and only argument of input is a tree node.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the count of nodes that have more value than all of its ancestors.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *      3
 * Input 2:
 *
 *
 *     4
 *    / \
 *   5   2
 *      / \
 *     3   6
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There's only one node in the tree that is the valid node.
 * Explanation 2:
 *
 *  The valid nodes are 4, 5 and 6.
 */
package tree;

public class CountingTheNodes {

    public static void main(String[] args) {

       TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(5), null), new TreeNode(2, new TreeNode(3), new TreeNode(6)));

        int ans = solve(root);
        System.out.println(ans);
    }

    public static int solve(TreeNode root) {
        if (root == null) return 0;

        return root.val + solve(root.left) + solve(root.right);
    }
}
