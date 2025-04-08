package tree;

import java.util.*;

public class AllNodesDistanceK {

    Map<TreeNode, TreeNode> parentNodes;
    List<Integer> kDistanceNodes;
    Set<TreeNode> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentNodes = new HashMap<>();
        kDistanceNodes = new ArrayList<>();
        visited = new HashSet<>();
        assignParentNodes(root, null);

        dfs(target, k);
        return kDistanceNodes;
    }

    private void dfs(TreeNode node, int currDistance) {
        if (node == null || !visited.add(node)) return;

        if (currDistance == 0) {
            kDistanceNodes.add(node.val);
            return;
        }

        dfs(parentNodes.get(node), currDistance - 1);
        dfs(node.left, currDistance - 1);
        dfs(node.right, currDistance - 1);
    }

    private void assignParentNodes(TreeNode node, TreeNode parent) {
        if (node == null) return;

        parentNodes.put(node, parent);
        assignParentNodes(node.left, node);
        assignParentNodes(node.right, node);
    }
}
