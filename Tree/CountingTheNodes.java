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
package Tree;

public class CountingTheNodes {
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
