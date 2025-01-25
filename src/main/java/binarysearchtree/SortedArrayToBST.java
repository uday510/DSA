/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 *
 *  Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 */
package binarysearchtree;

public class SortedArrayToBST {
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

        int[] nums = {-10, -3, 0, 5, 9};

        helper(nums, 0, nums.length - 1);

    }

    static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int idx = (left + right) / 2;
        TreeNode node = new TreeNode(nums[idx]);

        node.left = helper(nums, left, idx - 1);
        node.right = helper(nums, idx + 1, right);

        return node;
    }
}
