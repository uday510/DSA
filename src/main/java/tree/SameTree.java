package tree;

public class SameTree {
        public static void main(String[] args) {

            TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));


        }
    public static boolean solve(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        return (p.val == q.val) &&
                solve(p.left, q.left) &&
                solve(p.right, q.right);
    }
}
