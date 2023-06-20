package Tree;

import java.util.*;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 *
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column.
 * There may be multiple nodes in the same row and same column.
 * In such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 */
public class VerticalOrderOfBinaryTree2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static class Pair {
            TreeNode node;
            int row;
            int col;
            Pair(TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
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

            ArrayList<ArrayList<Integer>> ans = solve(root);
            System.out.println(ans);
        }
        public static ArrayList<ArrayList<Integer>> solve(TreeNode root) {
            // O(NLogN) time | O(N) space
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            if (root == null) return ans;

            //     <Level, Nodes>
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();

            ArrayDeque<Pair> queue = new ArrayDeque<>()
            {{offer(new Pair(root, 0, 0));}};;


            while (!queue.isEmpty()) {
                Pair currPair = queue.poll();
                TreeNode currNode = currPair.node;
                int currLevel = currPair.row;
                int currCol = currPair.col;

                // add currNode in hm
                if (!tm.containsKey(currLevel)) {
                    tm.put(currLevel, new TreeMap<>());

                    tm.get(currLevel).put(currCol, new PriorityQueue<>());
                }
                if (!tm.get(currLevel).containsKey(currCol)) {
                    tm.get(currLevel).put(currCol, new PriorityQueue<>());
                }

                tm.get(currLevel).get(currCol).offer(currNode.val);

                if (currNode.left != null) {
                    queue.offer(new Pair(currNode.left, currLevel - 1, currCol + 1));
                }
                if (currNode.right != null) {
                    queue.offer(new Pair(currNode.right, currLevel + 1, currCol + 1));
                }
            }

            for (TreeMap<Integer, PriorityQueue<Integer>> curr: tm.values()) {
                System.out.println(curr);
                ans.add(new ArrayList<>());
                for (PriorityQueue<Integer> nodes: curr.values()) {
                    while (!nodes.isEmpty()) {
                        ans.get(ans.size() - 1).add(nodes.poll());
                    }
                }
            }
            return ans;
        }
    }
}
