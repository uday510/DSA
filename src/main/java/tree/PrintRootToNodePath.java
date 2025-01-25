package tree;

import java.util.ArrayList;

public class PrintRootToNodePath {
        public static void main(String[] args) {

            TreeNode root = new TreeNode(1,
                            new TreeNode(2,
                            new TreeNode(4),
                            new TreeNode(5)),
                            new TreeNode(3,
                            new TreeNode(6),
                            new TreeNode(7)));

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
