/**
 * Problem Description
 * Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
 *
 * Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
 *
 * NOTE: The value comes first in the array which have lower level.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 109
 *
 *
 *
 * Input Format
 * First and only argument is a root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the left view of the Binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *             1
 *           /   \
 *          2    3
 *         / \  / \
 *        4   5 6  7
 *       /
 *      8
 * Input 2:
 *
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 4, 8]
 * Output 2:
 *
 *  [1, 2, 4, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Left view of the binary tree is returned.
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeLeftSideView {
    static ArrayList<Integer> leftView;

        public static void main(String[] args) {

            TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));

            List<Integer> ans = solve(root);
            System.out.println(ans);
        }
        public static List<Integer> solve(TreeNode root) {

            // O(N) time | O(D) space, where D is a tree diameter

//        if (root == null) return new ArrayList<>();
//
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>()
//        {{offer(root);}};
//        leftView = new ArrayList();
//
//        while (!queue.isEmpty()) {
//            int levelLength = queue.size();
//
//            for (int i = 0; i < levelLength; i++) {
//                TreeNode currNode = queue.poll();
//                // if it's the rightmost element
//                if (i == 0) {
//                    leftView.add(currNode.val);
//                }
//
//                // add child nodes in the queue
//                if (currNode.left != null) {
//                    queue.offer(currNode.left);
//                }
//                if (currNode.right != null) {
//                    queue.offer(currNode.right);
//                }
//            }
//        }
//        return leftView;


            /**
             * Using DFS
             *
             * Everyone likes recursive DFS, so let's add it here as well.
             * The idea is simple: to traverse the tree level by level,
             * starting each time from the rightmost child.
             */

            if (root == null) return new ArrayList<>();

            leftView = new ArrayList<>();

            helper(root, 0);
            return leftView;
        }
        public static void helper(TreeNode currNode, int currLevel) {
            if (currLevel == leftView.size()) {
                leftView.add(currNode.val);
            }

            if (currNode.left != null) {
                helper(currNode.left, currLevel + 1);
            }

            if (currNode.right != null) {
                helper(currNode.right, currLevel + 1);
            }
        }

}
