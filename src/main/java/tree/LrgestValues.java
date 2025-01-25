package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LargestValues {
    public static void main(String[] args) {

    }
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(root.val);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int rowMax = Integer.MIN_VALUE;

            for (int i = 0; i < size; ++i) {
                TreeNode currNode = queue.poll();
                assert currNode != null;
                rowMax = Math.max(currNode.val, rowMax);

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            res.add(rowMax);
        }
        return res;
    }
}
