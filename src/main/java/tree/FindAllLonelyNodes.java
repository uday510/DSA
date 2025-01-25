package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllLonelyNodes {
    public static void main(String[] args) {

    }
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {

                TreeNode currNode = queue.poll();

                if (currNode == null) { continue; }

                if (currNode.left != null && currNode.right == null) {
                    list.add(currNode.left.val);
                }

                if (currNode.left == null && currNode.right != null) {
                    list.add(currNode.right.val);
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return list;
    }
}
