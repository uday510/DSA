/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1.
 * Swapping 1 and 3 makes the BST valid.
 */
package binarysearchtree;
import java.util.ArrayList;

public class RecoverBinarySearchTree {
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
        }

        /**
         * With help of morris traverse
         *
         * The idea of Morris
         * algorithm is to set the temporary link between the node and its
         * predecessor:
         * predecessor.right = root.
         * So one starts from the node, computes its predecessor and
         * verifies if the link is present.
         *
         * There is no link? Set it and go to the left subtree.
         *
         * There is a link? Break it and go to the right subtree.
         *
         * There is one small issue to deal with : what if there is no
         * left child, i.e. there is no left subtree?
         * Then go straightforward to the right subtree.
         */

        public void solveUsingMorris(TreeNode root) {
            // predecessor is a Morris predecessor.
            // In the 'loop' cases it could be equal to the node itself predecessor == root.
            // pred is a 'true' predecessor,
            // the previous node in the inorder traversal.

            TreeNode currNode = root, x = null, y = null, pred = null, predecessor;

            while (currNode != null) {
                if (currNode.left == null) {
                    // check for the swapped nodes
                    if (pred != null && currNode.val < pred.val) {
                        y = currNode; // Eg.(inorder) [1, 3, 2, 4] -> y = 1
                        if (x == null) x = pred; // Eg. (inorder) [1, 3, 2, 4] -> x = 3
                    }
                    pred = currNode;

                    currNode = currNode.right; // go right
                } else {
                    // if there is a left child
                    // then compute the predecessor
                    // if there is no link predecessor.right = currNode --> set it.
                    // if there is a link predecessor.right = currNode --> break it.

                    // Predecessor node is one step left
                    predecessor = currNode.left;
                    while (predecessor.right != null && predecessor.right != currNode) {
                        predecessor = predecessor.right;
                    }

                    //set link predecessor.right = currNode
                    // and go to explore left subtree
                    if (predecessor.right == null) {
                        predecessor.right = currNode;
                        currNode = currNode.left;
                    }
                    // break link predecessor.right = currNode
                    // link broken : time to change subtree and go right
                    else {
                        // check for swapped nodes
                        if (pred != null && currNode.val < pred.val) {
                            y = currNode;
                            if (x == null) x = pred;
                        }
                        pred = currNode;

                        predecessor.right = null;
                        currNode = currNode.right;
                    }
                }
                swap(x, y);
            }
        }
            public static void swap(TreeNode a, TreeNode b) {
                int temp = a.val;
                a.val = b.val;
                b.val = temp;
        }

        // without morris traverse
        public void recoverTree(TreeNode root) {
            /**
             * Algorithm
             *
             * Here is the algorithm:
             *
             * Construct inorder traversal of the tree.
             * It should be an almost sorted list where only two elements are swapped.
             *
             * Identify two swapped elements x and y in an almost sorted array
             * in linear time.
             *
             * Traverse the tree again. Change value x to y and value y to x.
             */
            // O(N) time | O(N) space
            ArrayList<Integer> nums = new ArrayList<>();
            inorder(root, nums);
            int[] swapped = findTwoSwapped(nums);
            recover(root, 2, swapped[0], swapped[1]);
        }
        public static void recover(TreeNode root, int count, int x, int y) {
            if (root == null) return;

            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) return;
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
        public static int[] findTwoSwapped(ArrayList<Integer> nums) {
            int n = nums.size();
            int x = -1, y = -1;
            boolean swappedFirstOccurrence = false;
            for (int i = 0; i < n; ++i) {
                if (nums.get(i+1) < nums.get(i)) {
                    // traverse till we get second occurrence
                    y = nums.get(i+1);
                    //first swap occurrence
                    if (!swappedFirstOccurrence) {
                        x = nums.get(i);
                        swappedFirstOccurrence = true;
                    } else {
                        // second swap occurrence
                        break;
                    }
                }
            }
            return new int[] {x, y};
        }
        public static void inorder(TreeNode root, ArrayList<Integer> nums) {
            if (root == null) return;

            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }
}
