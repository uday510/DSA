package NonLinear.BinaryTrees;

import java.util.ArrayList;

public class PrintRootToNodePath {
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
        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(30, null, null);
            TreeNode node6 = new TreeNode(10, null, null);
            TreeNode node5 = new TreeNode(20, node6, node7);

            TreeNode node3 = new TreeNode(6, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(8, node2, node3);

            TreeNode root = new TreeNode(10, null, null);

            root.left = node1;
            root.right = node5;

            ArrayList<Integer> ans = solve(root, 8);
            System.out.println(ans);
        }
        public static ArrayList<Integer> solve(TreeNode root, int k) {
            // O(N) time | O(N) space
            ArrayList<Integer> arr = new ArrayList<>();
            if (root == null) return arr;
            helper(root, k, arr);
            return arr;
        }
        public static boolean helper(TreeNode root, int k, ArrayList<Integer> arr) {
            if (root == null) return false;

            // add curr val to list
            arr.add(root.val);
            if (root.val == k) return true;

            if ( helper(root.left, k, arr) || helper(root.right, k, arr) )
                return true;

            // remove curr val and return false, as we don't need this value
            arr.remove(arr.size() - 1);
            return false;
        }
    }
}
