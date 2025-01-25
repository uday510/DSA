package tree;

public class SmallestFromLeaf {

    public static void main(String[] args) {
        SmallestFromLeaf obj = new SmallestFromLeaf();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(obj.smallestFromLeaf(root));
    }

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new StringBuilder());
    }
    public String dfs(TreeNode node, StringBuilder sb) {

        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            return sb.reverse().toString();
        }
        if (node.left == null) {
            return dfs(node.right, sb);
        }

        if (node.right == null) {
            return dfs(node.left, sb);
        }

        String left = dfs(node.left, sb);
        String right = dfs(node.right, sb);

        return left.compareTo(right) <= 0 ? left : right;
    }
}
