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
package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));


        ArrayList<Integer> res = new ArrayList<>();
        preorder(root, res);
        System.out.println(res);
    }
    public static void preorder(TreeNode root, ArrayList<Integer> res) {
        //--------------- Using stack-------------
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

 // -------------- using recursion --------------

//        if (root == null) return;
//
//        res.add(root.val);
//        preorder(root.left, res);
//        preorder(root.right, res);
    }
}
