package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<Integer> deque = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (node.left == null && node.right == null) deque.offerFirst(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return dfs(root2, deque);
    }
    public boolean dfs(TreeNode root, Deque<Integer> deque) {
        if (root == null) return true;

        if (root.left == null && root.right == null) {
            if (!deque.isEmpty() && deque.peekFirst() == root.val) {
                deque.pollLast();
                return true;
            }
            return false;
        }
        dfs(root.right, deque);
        dfs(root.left, deque);
        return true;
    }
}
