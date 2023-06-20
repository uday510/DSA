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

package Tree;

public class SumofLeafLeaves {

    public static int count = 0;
    public static class TreeNode {
        int val;
        SumOfNodesOfBinaryTree.TreeNode left;
        SumOfNodesOfBinaryTree.TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        NodesCount.TreeNode root = new NodesCount.TreeNode(3);
        NodesCount.TreeNode child1 = new NodesCount.TreeNode(9);
        NodesCount.TreeNode child2 = new NodesCount.TreeNode(20);
        NodesCount.TreeNode child3 = new NodesCount.TreeNode(15);
        NodesCount.TreeNode child4 = new NodesCount.TreeNode(7);

        root.left = child1;
        root.right = child2;
        child2.left = child3;
        child2.right = child4;

        count = 0;
        solve(root);
        System.out.println(count);
    }
    public static void solve(NodesCount.TreeNode node) {
        if (node == null) return;

        if (node.left != null && node.left.left == null && node.left.right == null) {
            count += node.left.val;
        }

        solve(node.left);
        solve(node.right);


    }
}
