package Tree;

import java.util.*;

public class ZigzagLevelOrderTraversal {
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

            ArrayList<ArrayList<Integer>> ans = solve(root);
            System.out.println(ans);
        }
        public static ArrayList<ArrayList<Integer>> solve(TreeNode root) {
            // O(N) time | O(1) space
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            if (root == null) return new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root); // root is even
            boolean even = true;

            while (!queue.isEmpty()) {
                int levelLength = queue.size();
                ArrayList<Integer> list = new ArrayList<>(levelLength);

                for (int i = 0; i < levelLength; i++) {
                    TreeNode currNode = queue.poll();

                    if (currNode.left != null) queue.offer(currNode.left);
                    if (currNode.right != null) queue.offer(currNode.right);

                    if (even) list.add(currNode.val); // add at first
                    else list.add(0, currNode.val); // add at last
                }
                ans.add(list);
                even = !even;
            }
            return ans;
        }
//        List<List<Integer>> list = new ArrayList<>();
//
//            if (root == null) return list;
//
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//            int level = 1;
//            while (!queue.isEmpty()) {
//
//                int levelLength = queue.size();
//                List<Integer> curr = new ArrayList<>();
//
//                for (int i = 0; i < levelLength; i++) {
//                    TreeNode currNode = queue.poll();
//
//                    curr.add(currNode.val);
//                    if (currNode.left != null) {
//                        queue.offer(currNode.left);
//                    }
//                    if (currNode.right != null) {
//                        queue.offer(currNode.right);
//                    }
//                }
//                if (level % 2 != 0) {
//                    list.add(curr);
//                } else {
//                   Collections.reverse(curr);
//                   list.add(curr);
//                }
//                level += 1;
//            }
//            return list;
    }
}
