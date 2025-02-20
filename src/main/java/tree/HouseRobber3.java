package tree;

public class HouseRobber3 {

    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int pick = node.val + left[1] + right[1];
        int dont = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{pick, dont};
    }

}
