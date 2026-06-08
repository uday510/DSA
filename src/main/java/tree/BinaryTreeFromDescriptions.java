package tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/create-binary-tree-from-descriptions/
public class BinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] arr) {

        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> childs = new HashSet<>();

        for (int[] desc : arr) {
            int p = desc[0], c = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode pNode = nodes.computeIfAbsent(p, k -> new TreeNode(p));
            TreeNode cNode = nodes.computeIfAbsent(c, t -> new TreeNode(c));

            if (isLeft) pNode.left = cNode;
            else pNode.right = cNode;

            childs.add(c);
        }

        for (Integer c : nodes.keySet()) {
            if (!childs.contains(c)) {
                return nodes.get(c);
            }
        }

        return null;
    }

}
