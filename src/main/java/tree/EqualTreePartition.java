/**
 * Given the root of a binary tree, return true if you can partition
 * the tree into two trees with equal
 * sums of values after removing exactly one edge on the original tree.
 *
 * Input: root = [5,10,10,null,null,2,3]
 * Output: true
 */
package tree;
import java.util.Stack;

public class EqualTreePartition {
    static Stack<Long> seen;
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

            boolean ans = solve(root);
            System.out.println(ans);
        }
        public static boolean solve(TreeNode root) {
            // O(N) time | O(N) space
            /**
             * After removing some edge from parent to child,
             * (where the child cannot be the original root) the subtree
             * rooted at child must be half the sum of the entire tree.
             * Let's record the sum of every subtree.
             * We can do this recursively using depth-first search.
             * After, we should check that half the sum of the entire tree
             * occurs somewhere in our recording
             * (and not from the total of the entire tree.)
             */
            seen = new Stack<>();
            long total = sum(root);
            seen.pop(); // remove total sum of subtree, as we don't need it. USE BRAIN.
            if (total % 2 == 0) {
                for (long s : seen) {
                    if (s == total / 2)
                        return true;
                }
            }
            return false;
        }
        public static long sum(TreeNode root) {
            if (root == null) return 0;
            seen.push(sum(root.left) + sum(root.right) + root.val);
            return seen.peek();
        }
}
