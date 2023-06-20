/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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

            List<String> paths = new ArrayList<>();
            solve(root, "", paths);
            System.out.println(paths);
        }
        public static void solve(TreeNode root, String path, List<String> paths) {
            // O(N) time | O(N) space
            if (root == null) return;

            // add current value to path
            path += root.val;

            if ( (root.left == null) && (root.right == null) ) {
                // only one node , so add current path it paths.
                paths.add(path);
            } else {
                // add "->" to path
                path += "->";
                // go for left and right
                solve(root.left, path, paths);
                solve(root.right, path, paths);
            }
        }
    }
}
