package tree;

import java.util.*;

public class NodesDistanceKInBinaryTree {
    static TreeNode targetNode = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> ans = solve(root, 2, 1);
        System.out.println(ans);
    }
    public static ArrayList<Integer> solve(TreeNode A, int B, int C) {
        findTargetNode(A, B);
        System.out.println(targetNode.val);
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        setParentNode(A, parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        int currDistance = 0;
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(targetNode);
        visited.put(targetNode, true);

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (currDistance == C) break;
            currDistance++;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null && !visited.containsKey(currNode.left)) {
                    visited.put(currNode.left, true);
                    queue.offer(currNode.left);
                }
                if (currNode.right != null && !visited.containsKey(currNode.right)) {
                    visited.put(currNode.right, true);
                    queue.offer(currNode.right);
                }
                if (parentMap.containsKey(currNode) && !visited.containsKey(parentMap.get(currNode))) {
                    visited.put(parentMap.get(currNode), true);
                    queue.offer(parentMap.get(currNode));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            ans.add(currNode.val);
        }
        return ans;
    }
    public static void findTargetNode(TreeNode root, int target) {
        if (root == null) return;

        if (root.val == target) {
            targetNode = root;
            return;
        }
        findTargetNode(root.left, target);
        findTargetNode(root.right, target);
    }
    public static void setParentNode(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null) {
                    parentMap.put(currNode.left, currNode);
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    parentMap.put(currNode.right, currNode);
                    queue.offer(currNode.right);
                }
            }
        }
    }
}
