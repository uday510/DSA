/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 */
package NonLinear.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class TreeRightSideView {
    static List<Integer> rightSide;
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

            List<Integer> ans = solve(root);
            System.out.println(ans);
        }
    }
    public static List<Integer> solve(TreeNode root) {
        /**
         *  -- using BFS
         * Algorithm
         *
         * Initiate the list of the right side view rightside.
         *
         * Initiate the queue by adding a root.
         *
         * While the queue is not empty:
         *
         * Write down the length of the current level:
         * levelLength = queue.size().
         *
         * Iterate over i from 0 to level_length - 1:
         *
         * Pop the current node from the queue:
         * node = queue.poll().
         *
         * If i == levelLength - 1, then it's the last node
         * in the current level, push it to rightsize list.
         *
         * Add first left and then right child node
         * into the queue.
         *
         * Return rightside.
         */

        // O(N) time | O(D) space, where D is a tree diameter

//        if (root == null) return new ArrayList<>();
//
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>()
//        {{offer(root);}};
//        rightSide = new ArrayList();
//
//        while (!queue.isEmpty()) {
//            int levelLength = queue.size();
//
//            for (int i = 0; i < levelLength; i++) {
//                TreeNode currNode = queue.poll();
//                // if it's the rightmost element
//                if (i == levelLength - 1) {
//                    rightSide.add(currNode.val);
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
//        return rightSide;


        /**
         * Using DFS
         *
         * Everyone likes recursive DFS, so let's add it here as well.
         * The idea is simple: to traverse the tree level by level,
         * starting each time from the rightmost child.
         */

            if (root == null) return new ArrayList<>();

            rightSide = new ArrayList<>();

            helper(root, 0);
            return rightSide;
    }
    public static void helper(TreeNode currNode, int currLevel) {
        if (currLevel == rightSide.size()) {
            rightSide.add(currNode.val);
        }

        if (currNode.right != null) {
            helper(currNode.right, currLevel + 1);
        }
        if (currNode.left != null) {
            helper(currNode.left, currLevel + 1);
        }
    }
}
