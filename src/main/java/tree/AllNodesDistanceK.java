package tree;

import java.util.*;

public class AllNodesDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParent(root, parentMap);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            if (currLevel == k) break;
            currLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null && !visited.containsKey(currNode.left)) {
                    queue.offer(currNode.left);
                    visited.put(currNode.left, true);
                }
                if (currNode.right != null && !visited.containsKey(currNode.right)) {
                    queue.offer(currNode.right);
                    visited.put(currNode.right, true);
                }
                if (parentMap.containsKey(currNode) && !visited.containsKey(parentMap.get(currNode))) {
                    queue.offer(parentMap.get(currNode));
                    visited.put(parentMap.get(currNode), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            res.add(currNode.val);
        }
        return res;
    }
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    parentMap.put(currNode.left, currNode);
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    parentMap.put (currNode.right, currNode);
                    queue.offer(currNode.right);
                }
            }
        }
    }
}
