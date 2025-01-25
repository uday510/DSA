/**
 * Given the root of a binary tree, check whether
 * it is a mirror of itself (i.e., symmetric around its center).
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
        public static void main(String[] args) {

           TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        }
    public static boolean isSymmetric(TreeNode root) {
        // O(N) time | O(H) space where H is height of tree.
        return isMirrorUsingRecursion(root.left, root.right);
    }
    public static boolean isMirrorUsingRecursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        return (left.val == right.val)
                && isMirrorUsingRecursion(left.left, right.right)
                && isMirrorUsingRecursion(left.right, right.left);
    }
    public static boolean isMirror(TreeNode root) {
        /**
         * Approach 2: Iterative
         * Instead of recursion, we can also use iteration with the aid of a queue.
         * Each two consecutive nodes in the queue should be equal,
         * and their subtrees a mirror of each other. Initially,
         * the queue contains root and root. Then the algorithm works similarly to BFS,
         * with some key differences. Each time, two nodes are extracted and their values compared.
         * Then, the right and left children of the two nodes are inserted in the queue in opposite order.
         * The algorithm is done when either the queue is empty, or we detect that the tree is not symmetric
         * (i.e. we pull out two consecutive nodes from the queue that are unequal).
         */

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
