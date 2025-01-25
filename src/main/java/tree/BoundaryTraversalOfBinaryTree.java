/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 *
 * Left boundary is defined as the path from the root to the left-most node. Right boundary is defined as the path from the root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 *
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 *
 * The right-most node is also defined by the same way with left and right exchanged.
 *
 * Return an array of integers denoting the boundary values of tree in anti-clockwise order.
 *
 * For Example
 *
 * Input 1:
 *                _____1_____
 *               /           \
 *              2             3
 *             / \            /
 *            4   5          6
 *               / \        / \
 *              7   8      9  10
 * Output 1:
 *     [1, 2, 4, 7, 8, 9, 10, 6, 3]
 *     Explanation 1:
 *         The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 *         The leaves are node 4,7,8,9,10.
 *         The right boundary are node 1,3,6,10. (10 is the right-most node).
 *         So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 *
 * Input 2:
 *                 1
 *                / \
 *               2   3
 *              / \  / \
 *             4   5 6  7
 * Output 2:
 *      [1, 2, 4, 5, 6, 7, 3]
 */
package tree;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {
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

        public static class Pair {
            TreeNode node;
            int row;
            int col;

            Pair(TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }

        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(7, null, null);
            TreeNode node6 = new TreeNode(6, null, null);
            TreeNode node5 = new TreeNode(3, node6, node7);

            TreeNode node3 = new TreeNode(5, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(2, node2, node3);

            TreeNode root = new TreeNode(1, null, null);

            root.left = node1;
            root.right = node5;

            ArrayList<Integer> ans = solve(root);

            System.out.println(ans);
        }
        public static ArrayList<Integer> solve(TreeNode root) {
            // O(N) time | O(N) space
            ArrayList<Integer> res = new ArrayList<>();

            // add root node if it is not a leaf node
            if (!isLeafNode(root)) res.add(root.val);

            addLeftNodes(root.left, res);
            addLeafNodes(root, res);
            addRightNodes(root.right, res);

            return res;
        }
        public static void addLeftNodes(TreeNode node, ArrayList<Integer> res) {
            TreeNode currNode = node;

            while (currNode != null) {
                if (!isLeafNode(currNode)) res.add(currNode.val);
                if (currNode.left != null) currNode = currNode.left;
                else currNode = currNode.right;
            }

//            TreeNode currNode = root;
//            while (currNode.left != null || currNode.right != null) {
//                res.add(root.val);
//
//                if (currNode.left != null) {
//                    currNode = currNode.left;
//                } else {
//                    currNode = currNode.right;
//                }
//            }
        }
        public static void addLeafNodes(TreeNode root, ArrayList<Integer> res) {
           if (root == null) return;
           if (isLeafNode(root)) {
               res.add(root.val);;
               return;
           }
           addLeafNodes(root.left, res);
           addLeafNodes(root.right, res);
        }
        public static void addRightNodes(TreeNode node, ArrayList<Integer> res) {
            if (node == null) return;

            if (node.right != null) addRightNodes(node.right, res);
            else addRightNodes(node.left, res);

            if (!isLeafNode(node)) res.add(node.val);

 //-------------------without recursion-----------------
//            TreeNode currNode = root.right;
//            ArrayList<Integer> tempList = new ArrayList<>();
//            while (currNode != null) {
//                if (!isLeafNode(currNode)) tempList.add(currNode.val);
//                if (currNode.right != null) currNode = currNode.right;
//                else currNode = currNode.left;
//            }
//            // reverse the values of tempList
//            int i;
//            for (i = tempList.size() - 1; i > -1; --i) {
//                res.add(tempList.get(i));
//            }
        }
        public static boolean isLeafNode(TreeNode node) {
            return (node.left == null) && (node.right == null);
        }
    }
}
