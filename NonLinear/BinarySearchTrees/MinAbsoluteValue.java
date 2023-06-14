package NonLinear.BinarySearchTrees;

public class MinAbsoluteValue {
    class Solution {
        int res;
        TreeNode prevNode;
        public int getMinimumDifference(TreeNode root) {
            res = (int) 1e9;
            solve(root);
            return res;
        }
        public void solve(TreeNode currNode) {
            if (currNode == null) return;

            solve(currNode.left);
            if (prevNode != null)
                res = Math.min(res, currNode.val - prevNode.val);
            prevNode = currNode;
            solve(currNode.right);
        }
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
