package dp.trees;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

    Map<TreeNode, int[]> dp;

    public int rob(TreeNode root) {
        dp = new HashMap<>();
        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {0, 0};

        if (dp.containsKey(node)) return dp.get(node);
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int pick = node.val + left[1] + right[1];

        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        int[] curr = {pick, skip};

        dp.put(node, curr);

        return curr;
    }

}
