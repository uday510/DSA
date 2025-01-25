package tree;

import java.util.ArrayList;
import java.util.Stack;

public class BalanceBST {
    public static void main(String[] args) {

    }
    java.util.List<TreeNode> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
//        inorder(root);
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currNode = root;
        stack.push(currNode);


        while (!stack.isEmpty()) {
            while (currNode != null) {
                currNode = currNode.left;
            }
            currNode = stack.pop();
            nodes.add(currNode);
            currNode = currNode.right;
        }


         return balanceBST(0, nodes.size() - 1);
    }
    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        nodes.add(root);
        inorder(root.right);
    }

    public TreeNode balanceBST(int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return new TreeNode();

        int midIdx = (startIdx + endIdx) >>> 1;

        TreeNode currRoot = nodes.get(midIdx);

        currRoot.left = balanceBST(startIdx, midIdx - 1);
        currRoot.right = balanceBST(midIdx + 1, endIdx);

        return currRoot;
    }
}
