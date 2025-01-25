/**
 * Given the root of a binary tree where every node has a unique value and a target integer k, return the value of the nearest leaf node to the target k in the tree.
 *
 * Nearest to a leaf means the least number of edges traveled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
 *
 * Input: root = [1,3,2], k = 1
 * Output: 2
 * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 */
package tree;

import java.util.*;

public class ClosestLeafInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        System.out.println(findClosestLeaf(root, 1));
    }
    public static int findClosestLeaf(TreeNode root, int k) {
        // O(n) time and O(n) space
        if (root == null) return 0; // edge case
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>(); // build graph
        dfs(root, null, graph); // dfs to build graph

        Queue<TreeNode> queue = new LinkedList<>(); // bfs to find the closest leaf
        Set<TreeNode> visited = new HashSet<>(); // visited set

        for (TreeNode node : graph.keySet()) { // find the node with value k
            if (node != null && node.val == k) { // add it to the queue and visited set
                queue.add(node); // add to queue
                visited.add(node); // add to visited set
            }
        }
        while (!queue.isEmpty()) { // bfs

            TreeNode node = queue.poll(); // poll the node
            if (node != null && node.left == null && node.right == null) return node.val; // if it is a leaf node, return the value

            for (TreeNode nei : graph.get(node)) { // add all the neighbors to the queue and visited set
                if (!visited.contains(nei)) { // if the neighbor is not visited
                    queue.add(nei);
                    visited.add(nei);
                }
            }
        }
        return 0;
    }
    public static void dfs(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;

        if (!graph.containsKey(node)) graph.put(node, new ArrayList<>()); // add the node to the graph
        if (!graph.containsKey(parent)) graph.put(parent, new ArrayList<>()); // add the parent to the graph

        graph.get(node).add(parent); // add the parent to the node
        graph.get(parent).add(node); // add the node to the parent

        dfs(node.left, node, graph); // dfs left
        dfs(node.right, node, graph); // dfs right
    }
}
