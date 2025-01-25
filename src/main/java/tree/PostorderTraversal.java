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

package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        ArrayList<Integer> res = new ArrayList<>();
        postorder(root, res);
        System.out.println(res);
    }

public static void postorder(TreeNode root, ArrayList<Integer> res) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode currNode = root;
    /**         LEFT | RIGHT | ROOT
     *                    1
     *                  /   \
     *                 2     6
     *                /     /  \
     *               3    7    8
     *              /  \
     *             4    5
     *            / \
     *           N   N
     */

//--------------- Using one stack-------------

    while (currNode != null || !stack.isEmpty()) {
        if (currNode != null) {
            stack.push(currNode);
            currNode = currNode.left;
        } else {
            TreeNode tempNode = stack.peek().right;
            if (tempNode == null) {
                tempNode = stack.peek();
                stack.pop();
                res.add(tempNode.val);
                while (!stack.isEmpty() && tempNode == stack.peek().right) {
                    tempNode = stack.peek();
                    stack.pop();
                    res.add(tempNode.val);
                }
             } else {
                currNode = tempNode;
            }
        }
    }

//------------- using two stacks-------------
//    Stack<TreeNode> stack1 = new Stack<>();
//    Stack<TreeNode> stack2 = new Stack<>();
//    stack1.push(root);
//
//         while (!stack1.isEmpty()) {
//            root = stack1.pop();
//            stack2.push(root);
//            if (root.left != null)  stack1.push(root.left);
//            if (root.right != null) stack1.push(root.right);
//         }
//
//         while (!stack2.isEmpty()) {
//             currNode = stack2.pop();
//             res.add(currNode.val);
//         }


// -------------- using recursion --------------

//    if (root == null) return;
//
//        postorder(root.left, res);
//        postorder(root.right, res);
//        res.add(root.val);

}
}
