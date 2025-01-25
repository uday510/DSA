/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]

 */
package tree;

import java.util.*;

public class VerticalOrderOfBinaryTree {

        public static class Pair {
            TreeNode node;
            int level;
            Pair(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
        public static void main(String[] args) {

            TreeNode root = new TreeNode(6, new TreeNode(3, new TreeNode(2), new TreeNode(5)), new TreeNode(7, new TreeNode(8), new TreeNode(9)));

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
