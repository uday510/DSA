package tree;

public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(root));
    }
    public static int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }
    public static int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 2 + root.val;
        if (root.left == null && root.right == null) return sum;
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }
}
