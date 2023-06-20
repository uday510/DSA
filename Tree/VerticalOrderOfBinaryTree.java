/**
 * Problem Description
 * Given a binary tree, return a 2-D array with vertical order traversal of it.
 * Go through the example and image for more details.
 *
 * NOTE: If 2 Tree Nodes shares the same vertical level
 * then the one with lesser depth will come first
 */
package Tree;

import java.util.*;

public class VerticalOrderOfBinaryTree {
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

            solve(root);
        }
        public static ArrayList<ArrayList<Integer>> solve(TreeNode root) {
            // O(N) time | O(N) space
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            if (root == null) return ans;

            //     <Level, Nodes>
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

            ArrayDeque<Pair> queue = new ArrayDeque<>()
            {{offer(new Pair(root, 0));}};;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while (!queue.isEmpty()) {
                Pair currPair = queue.poll();
                TreeNode currNode = currPair.node;
                int currNodeLevel = currPair.level;

                min = Math.min(min, currNodeLevel);
                max = Math.max(max, currNodeLevel);

                // add currNode in hm
                if (!hm.containsKey(currNodeLevel)) {
                    hm.put(currNodeLevel, new ArrayList<>());
                }

                ArrayList<Integer> list = hm.get(currNodeLevel);
                list.add(currNode.val);
                hm.put(currNodeLevel, list);

                if (currNode.left != null) {
                    queue.offer(new Pair(currNode.left, currNodeLevel - 1));
                }
                if (currNode.right != null) {
                    queue.offer(new Pair(currNode.right, currNodeLevel + 1));
                }
            }

            while (min <= max) {
                ans.add(hm.get(min++));
            }
            return ans;
        }
    }
}
