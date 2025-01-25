package tree;


public class CountPairs {
    static int dist;
    static int pairs;
    public int countPairs(TreeNode root, int distance) {
        dist = distance;
        pairs = 0;
        dfs(root, 0);

        return pairs/2;
    }
    public int dfs(TreeNode root, int depth) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);
        if (left == 0 || right == 0) return left + right;
        if (left + right <= dist) {
            pairs++;
        }
        return Math.min(left, right) + 1;
    }
}
