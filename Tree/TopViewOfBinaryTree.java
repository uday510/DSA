/**
 * Problem Description
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
 *
 * The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
 *
 * Return the nodes in any order.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 10^9
 *
 *
 *
 * Input Format
 * First and only argument is head of the binary tree A.
 *
 *
 *
 * Output Format
 * Return an array, representing the top view of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
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
 *  [1, 2, 4, 8, 3, 7]
 * Output 2:
 *
 *  [1, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Top view is described.
 * Explanation 2:
 *
 * Top view is described.
 */
package Tree;

import java.util.*;

public class TopViewOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(7, null, null);
            TreeNode node6 = new TreeNode(6, null, null);
            TreeNode node5 = new TreeNode(3, node6, node7);

            TreeNode node3 = new TreeNode(5, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(2, node2, node3);

            TreeNode root = new TreeNode(1, null, null);

            root.left = node1;
            root.right = node5;

            ArrayList<Integer> ans = solve(root);
            System.out.println(ans);
        }
    public static ArrayList<Integer> solve(TreeNode root) {
        // O(N) time | O(N) space
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Map<Integer, Integer> tm = new TreeMap<>();

        ArrayDeque<Pair> queue = new ArrayDeque<>() {{
            offer(new Pair(root, 0));
        }};

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            TreeNode currNode = currPair.node;
            int currNodeLevel = currPair.level;

            // add only first node of vertical level
            if (tm.get(currNodeLevel) == null) {
                tm.put(currNodeLevel, currNode.val);
            }

            if (currNode.left != null) {
                queue.offer(new Pair(currNode.left, currNodeLevel - 1));
            }
            if (currNode.right != null) {
                queue.offer(new Pair(currNode.right, currNodeLevel + 1));
            }
        }
        // traverse in tree map, which is from min to max and to ans
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
