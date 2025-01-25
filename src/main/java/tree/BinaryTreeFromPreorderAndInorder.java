/**
 * Given two integer arrays preorder and inorder where
 * preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 *
 */
package tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderAndInorder {
    static int preorderIndex;
    static Map<Integer, Integer> inorderIndexMap;

    public static void main(String[] args) {

        int[] preorder = {2, 1, 7, 5, 4, 6};
        int[] inorder = {1, 2, 4, 5, 6, 7};
        TreeNode root = solve(preorder, inorder);
        System.out.println(root.val);
    }
    public static TreeNode solve(int[] preorder, int[] inorder) {
        // O(N) time | O(N) space
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }
    public static TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index elements to construct the tree
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        //build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
