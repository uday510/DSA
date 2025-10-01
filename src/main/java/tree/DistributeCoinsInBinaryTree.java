package tree;

public class DistributeCoinsInBinaryTree {

    private int m;

    public int distributeCoins(TreeNode root) {
        m = 0;
        dfs(root);
        return m;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        m += Math.abs(l) + Math.abs(r);

        return (node.val - 1) + l + r;
    }

}
