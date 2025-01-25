/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So
 * we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 */
package binarysearchtree;

public class DeleteNodeInBST {
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
        public static void main(String[] args) {

            TreeNode node8 = new TreeNode(6, null, null);
            TreeNode node7 = new TreeNode(4, null, null);
            TreeNode node6 = new TreeNode(5, node7, node8);
            TreeNode node5 = new TreeNode(7, node6, null);


            TreeNode node3 = new TreeNode(2, null, null);
            TreeNode node1 = new TreeNode(1,null, node3);

            TreeNode root = new TreeNode(3, node1, node5);


            TreeNode ans = solve(root, 3);

            System.out.println(ans.val);

        }
    public static TreeNode solve(TreeNode root, int key) {

        /**
         *                       9
         *                    /    \
         *                  8       12
         *                /       /   \
         *               5       10   13
         *             /   \      \
         *            3      7    11
         *          /   \   /  \
         *         2     4  6    8
         *        /
         *       1
         *            let's say key = 5
         *
         *                 After deletion of 5
         *
         *                   9
         *                 /   \
         *               8      12
         *             /       /  \
         *            3       10  13
         *          /   \       \
         *         2     4      11
         *        /       \
         *       1         7
         *                /  \
         *               6    8
         */

        // O(H) time | O(1) where H is the H of given BST.
        // root is null
        if (root == null) return null;
        // only one node
        if (root.val == key) {
            return helper(root);
        }

        // main logic
        TreeNode currNode = root;
        while (currNode != null) {
            if (key < currNode.val) {
                if (currNode.left != null && currNode.val == key) {
                    currNode.left = helper(currNode.left);
                    break;
                } else currNode = currNode.left;
            } else {
                if (currNode.right != null && currNode.val == key) {
                    currNode.right = helper(currNode.right);
                    break;
                } else currNode = currNode.right;
            }
        }
        return root;
    }
    public static TreeNode helper(TreeNode node) {
        // if there is no left subtree, return right subtree
        if (node.left == null) return node.right;

        // if there is no right subtree, return left subtree
        if (node.right == null) return node.left;

        TreeNode rightChild = node.right;
        TreeNode lastRight = getLastRight(node.left);
        lastRight.right = rightChild;
        return node.left;
    }
    public static TreeNode getLastRight(TreeNode node) {

        while (node.right != null) {
            node = node.right;
        }
        return node; // 2
    }
}
