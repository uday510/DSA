/**
 * Problem Description
 * You are given the root node of a binary tree A. You have to find the height of the given tree.
 *
 * A binary tree's height is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in the tree <= 105
 *
 * 0 <= Value of each node <= 109
 *
 *
 *
 * Input Format
 * The first and only argument is a tree node A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the height of the tree.
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
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Distance of node having value 1 from root node = 1
 *  Distance of node having value 4 from root node = 2 (max)
 *  Distance of node having value 3 from root node = 2 (max)
 * Explanation 2:
 *
 *  Distance of node having value 1 from root node = 1
 *  Distance of node having value 4 from root node = 2
 *  Distance of node having value 3 from root node = 2
 *  Distance of node having value 2 from root node = 3 (max)
 */

package tree;

public class TreeHeight {

    public static void main(String[] args) {

       TreeNode root = new TreeNode(1, new TreeNode(4, null, null), new TreeNode(3, null, null));

        int ans = solve(root);
        System.out.println(ans);
    }
    public static int solve(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(solve(root.left), solve(root.right));
    }
}
