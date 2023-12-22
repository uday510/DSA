class Solution {
    Set<Integer> vis = new HashSet<>();
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) return null;
        
        if (root.right != null && vis.contains(root.right.val)) {
            return null;
        }
        vis.add(root.val);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);
        
        return root;
    }
}