/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 */
package binarysearchtree;

public class LCAOfBST {
        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(30, null, null);
            TreeNode node6 = new TreeNode(10, null, null);
            TreeNode node5 = new TreeNode(20, node6, node7);

            TreeNode node3 = new TreeNode(6, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(8, node2, node3);

            TreeNode root = new TreeNode(10, null, null);

            root.left = node1;
            root.right = node5;

            solve(root, 5, 10);
        }
        public static TreeNode solve(TreeNode root, int p, int q) {

            TreeNode currNode = root;

            while (true) {

                // if p and q are < curr, then LCA will be on left
                if (p < currNode.val && q < currNode.val)
                        currNode = currNode.left;
                    // if p and q are > curr, then LCA will be on righ
                else if (p > currNode.val && q > currNode.val)
                        currNode = currNode.right;
                // found LCA
                else break;
            }
            return currNode;
        }
}
