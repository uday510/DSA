/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal
 * of a binary tree and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 */

package tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPostorder {
    static int postorderIndex;
    static Map<Integer, Integer> inorderIndexMap;

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = solve(inorder, postorder);

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
    public static TreeNode solve(int[] inorder, int[] postorder) {
        // O(N) time | O(N) space
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(postorder, 0, inorder.length - 1);
    }
    public static TreeNode arrayToTree(int[] postorder, int left, int right) {
        // if there is no elements to construct subtrees
        if (left > right) return null;

        // pick up post_idx element as a root
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // build right subtree
        root.right = arrayToTree(postorder, inorderIndexMap.get(rootValue) + 1, right);
        // build left subtree
        root.left = arrayToTree(postorder, left, inorderIndexMap.get(rootValue) - 1);
        return root;
    }
}
