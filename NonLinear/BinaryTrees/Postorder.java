/***
 * Problem Description
 * Given a binary tree, return the Postorder traversal of its nodes values.
 *
 * NOTE: Using recursion is not allowed.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the Postorder traversal of the given binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *    1
 *     \
 *      2
 *     /
 *    3
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
 * Output 1:
 *
 *  [3, 2, 1]
 * Output 2:
 *
 *  [6, 3, 2, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Preoder Traversal of the given tree is [3, 2, 1].
 * Explanation 2:
 *
 *  The Preoder Traversal of the given tree is [6, 3, 2, 1].
 */

package NonLinear.BinaryTrees;

import java.util.ArrayList;

public class Postorder {

    public static class TreeNode {
        int val;
        InorderTraversal.TreeNode left;
        InorderTraversal.TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {

        InorderTraversal.TreeNode root = new InorderTraversal.TreeNode(1);
        InorderTraversal.TreeNode child1 = new InorderTraversal.TreeNode(6);
        InorderTraversal.TreeNode child2 = new InorderTraversal.TreeNode(2);
        InorderTraversal.TreeNode child3 = new InorderTraversal.TreeNode(3);

        root.left = child1;
        root.right = child2;
        child2.left = child3;

        ArrayList<Integer> list = new ArrayList<>();

        solve(root, list);
        System.out.println(list);
    }
    public static void solve(InorderTraversal.TreeNode node, ArrayList<Integer> list) {

        if (node == null) return;

        solve(node.left, list);
        solve(node.right, list);
        list.add(node.val);
    }
}
