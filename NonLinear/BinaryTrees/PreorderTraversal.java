/**
 * Problem Description
 * Given a binary tree, return the preorder traversal of its nodes values.
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
 * Return an integer array denoting the preorder traversal of the given binary tree.
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
 *  [1, 2, 3]
 * Output 2:
 *
 *  [1, 6, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Preoder Traversal of the given tree is [1, 2, 3].
 * Explanation 2:
 *
 *  The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
package NonLinear.BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);

        TreeNode node3 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(3, null, null);
        TreeNode node1 = new TreeNode(2, node2, node3);

        TreeNode root = new TreeNode(1, null, null);

        root.left = node1;
        root.right = node5;


        ArrayList<Integer> res = new ArrayList<>();
        preorder(root, res);
        System.out.println(res);
    }
//    public static void preorder(TreeNode root, ArrayList<Integer> res) {
//        if (root == null) return;
//
//        res.add(root.val);
//        preorder(root.left, res);
//        preorder(root.right, res);
//    }
    public static void preorder(TreeNode root, ArrayList<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while (!stack.isEmpty() || currNode != null) {
            while (currNode != null) {
                res.add(currNode.val);
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            currNode = currNode.right;
        }
    }
}
