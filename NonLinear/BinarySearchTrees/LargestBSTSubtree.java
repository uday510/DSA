package NonLinear.BinarySearchTrees;

public class LargestBSTSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static class NodeValue {
        public int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(null));
    }

   public static int solve(TreeNode root) {

        return helper(root).maxSize;
   }
   public static NodeValue helper(TreeNode root) {
        // An empty tree is a BST of size 0.
       if (root == null) {
           return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
       }

       // Get values from left ans right subtree of current tree
       NodeValue left = helper(root.left);
       NodeValue right = helper(root.right);

       // Current Node is greater than max in left AND smaller than min in right, it is a BST.
       if (left.maxNode < root.val && root.val > right.minNode) {
           // found BST
           return
                   new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                           left.maxSize + right.maxSize + 1);
       }
       // otherwise return [-inf, inf] so that parent can't be valid BST.
       return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
