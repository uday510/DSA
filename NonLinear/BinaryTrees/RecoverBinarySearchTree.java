/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1.
 * Swapping 1 and 3 makes the BST valid.
 */
package NonLinear.BinaryTrees;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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
                    y = nums.get(i+1);
                    //first swap occurence
                    if (!swappedFirstOccurrence) {
                        x = nums.get(i);
                        swappedFirstOccurrence = true;
                    } else {
                        // second swap occurence
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
}
