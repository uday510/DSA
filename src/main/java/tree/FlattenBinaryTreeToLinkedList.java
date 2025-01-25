/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
package tree;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
    }
    public static void iterative(TreeNode root) {

        // Handle the null scenario
        if (root == null) {
            return;
        }
        TreeNode currNode = root;

        while (currNode != null) {

            // If the currNode has a left child
            if (currNode.left != null) {

                // Find the rightmost node
                TreeNode rightmost = currNode.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // rewire the connections
                rightmost.right = currNode.left;
                currNode.right = currNode.left;
                currNode.left = null;
            }

            // move on the right side of the tree
            currNode = currNode.right;
        }

    }
    public static TreeNode flattenTree(TreeNode node) {
        // Handle the null
        if (node == null) {
            return null;
        }

        // For a leaf node, return the node
        if (node.left == null && node.right == null) {
            return node;
        }

        //Recursively flatten the left subtree
        TreeNode leftTail = flattenTree(node.left);

        //Recursively flatten the right subtree
        TreeNode rightTail = flattenTree(node.right);

        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side
        // anymore
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        // We need to return the "rightmost" node after we are
        // done wiring the new connections
        return  rightTail == null ? leftTail : rightTail;
    }

}
