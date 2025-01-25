/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
        public static void main(String[] args) {

            TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));

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
