package tree;
// https://leetcode.com/problems/construct-string-from-binary-tree/
public class ConstructString {
    StringBuilder sb = new StringBuilder();
    boolean isRoot;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        isRoot = true;
        dfs(root, 0);
        return sb.toString();
    }
    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (isRoot) {
            sb.append(node.val);
            isRoot = false;
        } else {
            sb.append("(");
            sb.append(node.val);
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}
