/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 */
package tree;

import java.util.HashMap;

public class PathSum3 {
    static int count;
    static int k;
    static HashMap<Long, Integer> hm;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));

        int ans = solve(root, 10);
        System.out.println(ans);

    }

    public static int solve(TreeNode root, int targetSum) {
        k = targetSum;
        hm = new HashMap<>();
        preorder(root, 0L);
        return count;
    }

    public static void preorder(TreeNode node, long currSumFromRoot) {
        if (node == null) return;

        // current prefix sum
        currSumFromRoot += node.val;

        // sum we're looking for
        if (currSumFromRoot == k) count++;


        // number of times the currSumFromRoot - k has occured already,
        // determines the number of time a path with sum k
        // has occured upto the current node
        count += hm.getOrDefault(currSumFromRoot - k, 0);


        // add the current sum into hashmap
        // to use it during the child nodes processing
        hm.put(currSumFromRoot, hm.getOrDefault(currSumFromRoot, 0) + 1);

        // process left subtree
        preorder(node.left, currSumFromRoot);
        // process right subtree
        preorder(node.right, currSumFromRoot);

        // remove the currentSumFromRoot from the hash map
        // in order not to use it during
        // the parallel subtree processing
        hm.put(currSumFromRoot, hm.get(currSumFromRoot) - 1);
    }
}

    /**
     * // O(N^2) time | O(N) space
     * public int pathSum(TreeNode root, int targetSum) {
     *         if (root == null) return 0;
     *         helper (root, targetSum);
     *         pathSum(root.left, targetSum);
     *         pathSum(root.right, targetSum);
     *
     *         return ans;
     *     }
     *     public void helper(TreeNode root, int remainingSum) {
     *         if (root == null || root.val == Math.pow(10,9)) return;
     *
     *         remainingSum -= root.val;
     *         if (remainingSum == 0) ans += 1;
     *         helper(root.left, remainingSum);
     *         helper(root.right, remainingSum);
     *     }
     */
