/**
 * Problem Description
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Return an integer array denoting the inorder traversal of the given binary tree.
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
 *  [1, 3, 2]
 * Output 2:
 *
 *  [6, 1, 3, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Inorder Traversal of the given tree is [1, 3, 2].
 * Explanation 2:
 *
 *  The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */

/**
 *  public static class Node {
 *         public int val;
 *         public Node next;
 *
 *         Node(int x) {
 *             val = x;
 *             next = null;
 *         }
 *     }
 */
package NonLinear.BinaryTrees;

import java.util.ArrayList;

public class InorderTraversal {

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
        TreeNode child1 = new TreeNode(6);
        TreeNode child2 = new TreeNode(2);
        TreeNode child3 = new TreeNode(3);

        root.left = child1;
        root.right = child2;
        child2.left = child3;

        ArrayList<Integer> list = new ArrayList<>();

        solve(root, list);
        System.out.println(list);
    }
    public static void solve(TreeNode node, ArrayList<Integer> list) {

        if (node == null) return;

        solve(node.left, list);
        list.add(node.val);
        solve(node.right, list);
    }
}
