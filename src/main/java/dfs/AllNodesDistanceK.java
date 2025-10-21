package dfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceK {

    Map<TreeNode, TreeNode> map;
    List<Integer> list;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        list = new ArrayList<>();
        map.put(root, null);

        applyParent(root);

        dfs(root, k);
        return list;
    }

    private void applyParent(TreeNode node) {
        if (node == null) return;

       map.put(node.left, node);
       map.put(node.right, node);

       applyParent(node.left);
       applyParent(node.right);
    }

    private void dfs(TreeNode node, int dist) {
        if (node == null) return;

        if (dist == 0) {
            list.add(node.val);
            return;
        }

        dfs(node.left, dist - 1);
        dfs(node.right, dist - 1);
        dfs(map.get(node), dist - 1);
    }

}
