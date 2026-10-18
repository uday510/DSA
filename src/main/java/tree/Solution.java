package tree;

public class Solution {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    static void main() {

        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;


        TreeNode node = solve(root, n4, n5);
        assert node != null;
        System.out.println(node.val);

    }

    public static TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    private void solve(int n) {
        int cnt = 0;
        while (n > 0) {
            n /= 5;
            cnt += n;
        }
    }
}


/***
 *       1
 *      2  3
 *    4  5
 */